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

import java.util.List;
import java.util.ArrayList;

/**
 * 修改项目名称的向导弹窗 by中文网
 */
public class EditYoungAndroidProjectWizard extends NewProjectWizard {
  // UI element for project name
  private LabeledTextBox projectNameTextBox;

  /**
   * Creates a new YoungAndroid project wizard.
   */
  public EditYoungAndroidProjectWizard(long projectId, String projectName) {
    super(MESSAGES.editYoungAndroidProjectWizardCaption());

    // Initialize the UI
    setStylePrimaryName("ode-DialogBox");

    projectNameTextBox = new LabeledTextBox(MESSAGES.projectNameLabel(), new Validator() {
      @Override
      public boolean validate(String value) {
        errorMessage = TextValidators.getErrorMessage(value);
        if (errorMessage.length()>0){
          disableOkButton();
          return false;
        }
          errorMessage = TextValidators.getWarningMessages(value);
          enableOkButton();
          return true;
      }

      @Override
      public String getErrorMessage() {
        return errorMessage;
      }
    });

    projectNameTextBox.getTextBox().setText(projectName);

    projectNameTextBox.getTextBox().addKeyDownHandler(new KeyDownHandler() {
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

    projectNameTextBox.getTextBox().addKeyUpHandler(new KeyUpHandler() {
      @Override
      public void onKeyUp(KeyUpEvent event) { //Validate the text each time a key is lifted
        projectNameTextBox.validate();
      }
    });

    VerticalPanel page = new VerticalPanel();

    page.add(projectNameTextBox);
    addPage(page);

    // Create finish command (create a new Young Android project)
    initFinishCommand(new Command() {
      @Override
      public void execute() {
        String projectName = projectNameTextBox.getText().trim();
        projectName = projectName.replaceAll("( )+", " ").replace(" ", "_");
        if (TextValidators.checkNewProjectName(projectName) 
              == TextValidators.ProjectNameStatus.SUCCESS) {

          final Ode ode = Ode.getInstance();
          final OdeAsyncCallback<Void> renameCallback = new OdeAsyncCallback<Void>(MESSAGES.renameProjectError()) {
            @Override
            public void onSuccess(Void result) {
              Window.Location.reload();
            }
          };

          List<Long> projectIds = new ArrayList<Long>();
          projectIds.add(projectId);
          List<String> projectNames = new ArrayList<String>();
          projectNames.add(projectName);
          
          ode.getProjectService().renameProjects(projectIds, projectNames, renameCallback);
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
    int width = 340;
    int height = 40;
    this.center();

    setPixelSize(width, height);
    super.setPagePanelHeight(85);

    DeferredCommand.addCommand(new Command() {
      public void execute() {
        projectNameTextBox.setFocus(true);
        projectNameTextBox.selectAll();
      }
    });
  }
}
