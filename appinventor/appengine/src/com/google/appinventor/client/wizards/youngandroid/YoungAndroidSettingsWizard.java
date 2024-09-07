// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.wizards.youngandroid;


import com.google.appinventor.client.Ode;

import static com.google.appinventor.client.Ode.MESSAGES;

import com.google.appinventor.client.explorer.project.Project;
import com.google.appinventor.client.explorer.youngandroid.ProjectToolbar;
import com.google.appinventor.client.tracking.Tracking;
import com.google.appinventor.client.widgets.LabeledTextBox;
import com.google.appinventor.client.widgets.Validator;
import com.google.appinventor.client.wizards.NewProjectWizard;
import com.google.appinventor.client.youngandroid.TextValidators;
import com.google.appinventor.common.utils.StringUtils;
import com.google.appinventor.shared.rpc.project.youngandroid.NewYoungAndroidProjectParameters;
import com.google.appinventor.shared.rpc.project.youngandroid.YoungAndroidProjectNode;
import com.google.gwt.core.client.Scheduler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyDownEvent;
import com.google.gwt.event.dom.client.KeyDownHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.DeferredCommand;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.Window;
import com.google.appinventor.client.OdeAsyncCallback;
import com.google.appinventor.shared.rpc.project.UserProject;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Widget;

import java.util.List;
import java.util.ArrayList;

/**
 * 编译重要参数设置向导弹窗 by中文网
 */
public class YoungAndroidSettingsWizard extends NewProjectWizard {
  // UI element for 包名
  private LabeledTextBox packageNameTextBox;
  final Label defaultLabel = new Label("恢复默认");

  /**
   * Creates a new YoungAndroid project wizard.
   */
  public YoungAndroidSettingsWizard(long projectId) {
    super("编译参数设置...");

    // Initialize the UI
    setStylePrimaryName("ode-DialogBox");

    packageNameTextBox = new LabeledTextBox("启动类名（ActivityClass）：", new Validator() {
      @Override
      public boolean validate(String value) {
        boolean valid = TextValidators.isValidClassName(value);
        if (!valid){
          errorMessage = "必须以字母开头，且只能包含字母、数字、. 和下划线";
          disableOkButton();
          return false;
        }
        errorMessage = "";
        enableOkButton();
        return true;
      }

      @Override
      public String getErrorMessage() {
        return errorMessage;
      }
    });

    // 获取最新的类名
    final Ode ode = Ode.getInstance();
    final OdeAsyncCallback<String> callback = new OdeAsyncCallback<String>("get qualified name fail.") {
      @Override
      public void onSuccess(String result) {
        packageNameTextBox.getTextBox().setText(result);
      }
    };
    ode.getProjectService().getQualifiedName(projectId, callback);


    packageNameTextBox.getTextBox().addKeyDownHandler(new KeyDownHandler() {
      @Override
      public void onKeyDown(KeyDownEvent event) {
        int keyCode = event.getNativeKeyCode();
        if (keyCode == KeyCodes.KEY_ENTER) {
          handleOkClick();
        } else if (keyCode == KeyCodes.KEY_ESCAPE) {
          handleCancelClick();
        }
      }
    });

    packageNameTextBox.getTextBox().addKeyUpHandler(new KeyUpHandler() {
      @Override
      public void onKeyUp(KeyUpEvent event) { //Validate the text each time a key is lifted
        packageNameTextBox.validate();
      }
    });

    defaultLabel.addClickListener(new ClickListener() {
      @Override
      public void onClick(Widget sender) {
        //恢复默认类名
        Project currentProject = ode.getProjectManager().getProject(projectId);
        packageNameTextBox.getTextBox().setText(StringUtils.getQualifiedFormName(ode.getUser().getUserEmail(), currentProject.getProjectName()));
      }
    });


    VerticalPanel page = new VerticalPanel();

    page.add(packageNameTextBox);
    page.add(defaultLabel);
    addPage(page);

    // Create finish command (create a new Young Android project)
    initFinishCommand(new Command() {
      @Override
      public void execute() {
        String className = packageNameTextBox.getText().trim();
        className = className.replaceAll("( )+", " ").replace(" ", "_");
        if (TextValidators.isValidClassName(className)) {
          final Ode ode = Ode.getInstance();
          final String latestClassName = className;
          final OdeAsyncCallback<Void> updateCallback = new OdeAsyncCallback<Void>("udpate qualified name fail.") {
            @Override
            public void onSuccess(Void result) {
              handleCancelClick();
            }
          };
          ode.getProjectService().updateQualifiedName(projectId, className, updateCallback);

        } else {
          show();
          center();
          return;
        }
      }
    });
  }

  @Override
  public void show() {
    super.show();
    // Wizard size (having it resize between page changes is quite annoying)
    int width = 500;
    int height = 200;
    this.center();

    setPixelSize(width, height);
    super.setPagePanelHeight(150);

    DeferredCommand.addCommand(new Command() {
      public void execute() {
        packageNameTextBox.setFocus(true);
        packageNameTextBox.selectAll();
      }
    });
  }
}
