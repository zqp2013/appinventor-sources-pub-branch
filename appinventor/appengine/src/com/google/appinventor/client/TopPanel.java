// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client;

import com.google.appinventor.client.boxes.MotdBox;
import com.google.appinventor.client.boxes.ProjectListBox;

import com.google.appinventor.client.explorer.commands.ChainableCommand;
import com.google.appinventor.client.explorer.commands.SaveAllEditorsCommand;

import com.google.appinventor.client.tracking.Tracking;
import com.google.appinventor.client.output.OdeLog;

import com.google.appinventor.client.widgets.DropDownButton.DropDownItem;
import com.google.appinventor.client.widgets.DropDownButton;
import com.google.appinventor.client.widgets.TextButton;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.SimplePanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;

import com.google.appinventor.shared.rpc.project.ProjectRootNode;
import com.google.appinventor.shared.rpc.user.Config;
import com.google.appinventor.shared.rpc.admin.AdminUser;
import com.google.appinventor.shared.rpc.AdminInterfaceException;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.http.client.UrlBuilder;

import com.google.gwt.i18n.client.Dictionary;
import com.google.gwt.i18n.client.LocaleInfo;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.TextResource;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Frame;
import com.google.gwt.user.client.ui.VerticalPanel;

import java.util.List;
import java.util.MissingResourceException;
import java.util.Date;

import static com.google.appinventor.client.Ode.MESSAGES;

/**
 * The top panel, which contains the main menu, various links plus ads.
 *
 */
public class TopPanel extends Composite {
  // Strings for links and dropdown menus:
  private final DropDownButton accountButton;
  public DropDownButton languageDropDown;

  private final String WIDGET_NAME_SIGN_OUT = "Signout";
  private final String WIDGET_NAME_USER = "User";
  private static final String WIDGET_NAME_LANGUAGE = "Language";
  private final String WIDGET_NAME_DELETE_ACCOUNT = "DeleteAccount";

  private static final String SIGNOUT_URL = "/ode/_logout";
  private static final String LOGO_IMAGE_URL = "/static/images/codi_long.png";

  private static final String WINDOW_OPEN_FEATURES = "menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes";
  private static final String WINDOW_OPEN_LOCATION = "_ai2";

  private final VerticalPanel rightPanel;  // remember this so we can add MOTD later if needed

  final Ode ode = Ode.getInstance();

  static final DateTimeFormat expiredFormat = DateTimeFormat.getFormat("yyyy/MM/dd");

  interface Translations extends ClientBundle {
    Translations INSTANCE = GWT.create(Translations.class);

    @Source("languages.json")
    TextResource languages();
  }

  static {
    loadLanguages(Translations.INSTANCE.languages().getText());
    LANGUAGES = Dictionary.getDictionary("LANGUAGES");
  }

  private static native void loadLanguages(String resource)/*-{
    $wnd['LANGUAGES'] = JSON.parse(resource);
  }-*/;

  private static final Dictionary LANGUAGES;

  /**
   * Initializes and assembles all UI elements shown in the top panel.
   */
  public TopPanel() {
    /*
     * The layout of the top panel is as follows:
     *
     *  +-- topPanel ------------------------------------+
     *  |+-- logo --++-----tools-----++--links/account--+|
     *  ||          ||               ||                 ||
     *  |+----------++---------------++-----------------+|
     *  +------------------------------------------------+
     */
    HorizontalPanel topPanel = new HorizontalPanel();
    topPanel.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);

    // Create the Tools
    TopToolbar tools = new TopToolbar();
    ode.setTopToolbar(tools);

    // Create the Links
    HorizontalPanel links = new HorizontalPanel();
    links.setStyleName("ode-TopPanelLinks");
    links.setVerticalAlignment(HorizontalPanel.ALIGN_MIDDLE);

    if (Ode.getInstance().isReadOnly()) {
      Label readOnly = new Label(MESSAGES.readOnlyMode());
      readOnly.setStyleName("ode-TopPanelWarningLabel");
      links.add(readOnly);
    }

    // VIP提醒
    if (Ode.getInstance().getUser().getUserEmail() == "test@fun123.cn") {
      // 广告
      Frame adFrame = new Frame("https://www.fun123.cn/reference/info/free/?" + (new Date()).getTime());
      adFrame.setStyleName("ode-FreeFrame");
      links.add(adFrame);

      Label vipTip = new Label("升级VIP会员");
      vipTip.addClickHandler(new WindowOpenClickHandler("/pay?f=top"));
      vipTip.setStyleName("ode-TopPanelButton vip");
      links.add(vipTip);
    }

    // My Projects Link
    TextButton myProjects = new TextButton(MESSAGES.myProjectsTabName());
    myProjects.setStyleName("ode-TopPanelButton");
    myProjects.setHTML("<i class=\"mdi mdi-format-list-bulleted-square\" style=\"font-size:14px\"/></i>&nbsp;&nbsp;" + myProjects.getText());

    myProjects.addClickHandler(new ClickHandler() {
      @Override
      public void onClick(ClickEvent event) {
        Ode.getInstance().getTopToolbar().updateMoveToTrash("Move To Trash");
        ode.switchToProjectsView();
      }
    });

    myProjects.setStyleName("ode-TopPanelButton");
    links.add(myProjects);

    // View Trash Link
    //TextButton viewTrash = new TextButton(MESSAGES.viewTrashTabName());
    //viewTrash.setStyleName("ode-TopPanelButton");
    //viewTrash.addClickHandler(new ClickHandler() {
    //  @Override
    //  public void onClick(ClickEvent event) {
    //    ode.switchToTrash();
    //  }
    //});
    //links.add(viewTrash);

    Config config = ode.getSystemConfig();
    String guideUrl = config.getGuideUrl();
    if (!Strings.isNullOrEmpty(guideUrl)) {
      TextButton guideLink = new TextButton(MESSAGES.guideTabName());
      guideLink.setHTML("<i class=\"mdi mdi-school-outline\" style=\"font-size:14px\"/></i>&nbsp;&nbsp;" + guideLink.getText());
      guideLink.addClickHandler(new WindowOpenClickHandler(guideUrl));
      guideLink.setStyleName("ode-TopPanelButton hot");
      links.add(guideLink);
    }

    // Feedback Link
    String feedbackUrl = config.getForumsUrl();
    if (!Strings.isNullOrEmpty(feedbackUrl)) {
      TextButton feedbackLink = new TextButton(MESSAGES.feedbackTabName());
      feedbackLink.setHTML("<i class=\"mdi mdi-progress-question\" style=\"font-size:14px\"/></i>&nbsp;&nbsp;" + feedbackLink.getText());
      feedbackLink.addClickHandler(
        new WindowOpenClickHandler(feedbackUrl));
      feedbackLink.setStyleName("ode-TopPanelButton");
      links.add(feedbackLink);
    }

    // Create the Account Information
    rightPanel = new VerticalPanel();
    rightPanel.setHeight("100%");
    rightPanel.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);

    HorizontalPanel account = new HorizontalPanel();
    account.setStyleName("ode-TopPanelAccount");

    // Account Drop Down Button
    List<DropDownItem> userItems = Lists.newArrayList();

    // Sign Out
    userItems.add(new DropDownItem(WIDGET_NAME_SIGN_OUT, MESSAGES.signOutLink(), new SignOutAction()));
    
    if (Ode.getInstance().getUser().getUserEmail() != "test@fun123.cn") {
      //修改密码
      String cpwStr = "密码修改";
      userItems.add(new DropDownItem(cpwStr, "<i class=\"mdi mdi-pencil-lock-outline\" style=\"font-size:15px\"/></i>&nbsp;&nbsp;" + cpwStr, new ChangePwdAction(), "ode-ContextMenuItem"));

      //VIP到期日
      Date expired = Ode.getInstance().getUser().getExpired();
      String expiredStr = "到期日：";
      if (expired != null) {
        expiredStr += expiredFormat.format(expired);
      }
      userItems.add(new DropDownItem(expiredStr, "<i class=\"mdi mdi-calendar-range\" style=\"font-size:15px\"/></i>&nbsp;&nbsp;" + expiredStr, new VipInfoAction(), "ode-ContextMenuItem hot"));
    }

    // if we are allowed to delete accounts
    //if (ode.getDeleteAccountAllowed() 
    //  && Ode.getInstance().getUser().getUserEmail() != "test@fun123.cn"
    //  && Ode.getInstance().getUser().getUserEmail() != "admin") {
    //只有管理员才能删除账户
    if (Ode.getInstance().isReadOnly()) {
      userItems.add(new DropDownItem(WIDGET_NAME_DELETE_ACCOUNT, MESSAGES.deleteAccountLink(), new DeleteAccountAction(), "ode-ContextMenuItem-Red"));
    }

    accountButton = new DropDownButton(WIDGET_NAME_USER, " " , userItems, true);
    accountButton.setStyleName("ode-TopPanelButton");

    // Language
    List<DropDownItem> languageItems = Lists.newArrayList();
    String[] localeNames = LocaleInfo.getAvailableLocaleNames();
    String nativeName;
    for (String localeName : localeNames) {
      if (!localeName.equals("default")) {
        SelectLanguage lang = new SelectLanguage();
        lang.setLocale(localeName);
        nativeName = getDisplayName(localeName);
        languageItems.add(new DropDownItem(WIDGET_NAME_LANGUAGE, nativeName, lang));
      }
    }
    String currentLang = LocaleInfo.getCurrentLocale().getLocaleName();
    String nativeDisplayName = getDisplayName(currentLang);
    languageDropDown = new DropDownButton(WIDGET_NAME_LANGUAGE, nativeDisplayName, languageItems, true);
    languageDropDown.setStyleName("ode-TopPanelButton");
    languageDropDown.setHTML("<i class=\"mdi mdi-translate\" style=\"font-size:14px\"/></i>&nbsp;&nbsp;" + nativeDisplayName + " \u25BE ");

    account.setVerticalAlignment(VerticalPanel.ALIGN_MIDDLE);
    account.add(links);
    account.add(languageDropDown);
    account.add(accountButton);

    rightPanel.add(account);

    // Add the Logo, Tools, Links to the TopPanel
    addLogo(topPanel);
    topPanel.add(tools);
    topPanel.add(rightPanel);
    topPanel.setCellVerticalAlignment(rightPanel, HorizontalPanel.ALIGN_MIDDLE);
    rightPanel.setCellHorizontalAlignment(account, HorizontalPanel.ALIGN_RIGHT);
    topPanel.setCellHorizontalAlignment(rightPanel, HorizontalPanel.ALIGN_RIGHT);

    initWidget(topPanel);

    setStyleName("ode-TopPanel");
    setWidth("100%");
  }

  private String getDisplayName(String localeName){
    String nativeName=LocaleInfo.getLocaleNativeDisplayName(localeName);
    try {
      return LANGUAGES.get(localeName);
    } catch (MissingResourceException e) {
      return nativeName;
    }
  }

  private void addLogo(HorizontalPanel panel) {
    // Logo is a link to App Inv homepage. Add timestamp to logo url
    // to get around browsers that agressively cache the image! This
    // same trick is used in StorageUtil.getFilePath().
    Image logo = new Image(LOGO_IMAGE_URL + "?t=" + System.currentTimeMillis());
    logo.setSize("180px", "40px");
    logo.setStyleName("ode-Logo");
    String logoUrl = ode.getSystemConfig().getLogoUrl();
    if (!Strings.isNullOrEmpty(logoUrl)) {
      logo.addClickHandler(new WindowOpenClickHandler(logoUrl));
    }
    panel.add(logo);
    panel.setCellWidth(logo, "230px");
    panel.setCellHorizontalAlignment(logo, HorizontalPanel.ALIGN_LEFT);
    panel.setCellVerticalAlignment(logo, HorizontalPanel.ALIGN_MIDDLE);
  }

  private void addMotd(VerticalPanel panel) {
    MotdBox motdBox = MotdBox.getMotdBox();
    panel.add(motdBox);
    panel.setCellHorizontalAlignment(motdBox, HorizontalPanel.ALIGN_RIGHT);
    panel.setCellVerticalAlignment(motdBox, HorizontalPanel.ALIGN_BOTTOM);
  }

  private static boolean isNumericZidai(String str) {
    for (int i = 0; i < str.length(); i++) {
        if (!Character.isDigit(str.charAt(i))) {
            return false;
        }
    }
    return true;
  }
  // 检查手机号码正确性
  private boolean IsPhoneNum(String phone) {
    return phone.length() == 11 && isNumericZidai(phone);
  }

  /**
   * Updates the UI to show the user's email address.
   *
   * @param email the email address
   */
  public void showUserEmail(String email) {
    String disp = email;
    if (IsPhoneNum(email)) {
      //Add by 中文网：手机号隐式显示
      disp = email.substring(0, 3) + "****" + email.substring(7, 11);
    } 
    accountButton.setCaption(disp);
    accountButton.setHTML("<i class=\"mdi mdi-account\" style=\"font-size:14px\"/></i>&nbsp;&nbsp;" + disp + " \u25BE ");
  }

  /**
   * Adds the MOTD box to the right panel. This should only be called once.
   */
  public void showMotd() {
    addMotd(rightPanel);
  }

  private static class WindowOpenClickHandler implements ClickHandler {
    private final String url;

    WindowOpenClickHandler(String url) {
      this.url = url;
    }

    @Override
    public void onClick(ClickEvent clickEvent) {
      Window.open(url, WINDOW_OPEN_LOCATION, WINDOW_OPEN_FEATURES);
    }
  }

  private static class SignOutAction implements Command {
    @Override
    public void execute() {
      // Maybe take a screenshot
      Ode.getInstance().screenShotMaybe(new Runnable() {
          @Override
          public void run() {
            Window.Location.replace(SIGNOUT_URL);
          }
        }, true);               // Wait for i/o
    }
  }

  private static class VipInfoAction implements Command {
    @Override
    public void execute() {
      final DialogBox db = new DialogBox(false, true);
      db.setText("App Inventor 2 中文网VIP会员");
      db.setStyleName("ode-DialogBox");
      db.setHeight("200px");
      db.setWidth("400px");
      db.setGlassEnabled(true);
      db.setAnimationEnabled(true);
      db.center();

      VerticalPanel DialogBoxContents = new VerticalPanel();
      //VIP到期日
      Date expired = Ode.getInstance().getUser().getExpired();
      String expiredStr = "";
      if (expired != null) {
        expiredStr = expiredFormat.format(expired);
      }
      String html = "<p>尊敬的VIP用户，您的VIP期限为： " + expiredStr + "<p/><br/><a class=\"vip\" href=\"/pay?f=account\" target=\"_blank\">VIP续期</a><br/><br/>";
      HTML message = new HTML(html);

      SimplePanel holder = new SimplePanel();
      Button ok = new Button("关闭");
      ok.addClickListener(new ClickListener() {
        public void onClick(Widget sender) {
          db.hide();
        }
      });
      holder.add(ok);
      DialogBoxContents.add(message);
      DialogBoxContents.add(holder);
      db.setWidget(DialogBoxContents);
      db.show();
    }
  }

  private static class ChangePwdAction implements Command {
    @Override
    public void execute() {
      final DialogBox dialogBox = new DialogBox(false, true);
      dialogBox.setStylePrimaryName("ode-DialogBox");
      dialogBox.setText("密码修改");
      dialogBox.setGlassEnabled(true);
      dialogBox.setAnimationEnabled(true);
      final HTML message = new HTML("");
      message.setStyleName("DialogBox-message");
      final FlexTable userInfo = new FlexTable();
      final Label userNameLabel = new Label("原密码：");
      final PasswordTextBox userName = new PasswordTextBox();
      final Label passwordLabel = new Label("新密码：");
      final Label passwordLabel2 = new Label("新密码确认：");
      final PasswordTextBox passwordBox1 = new PasswordTextBox();
      final PasswordTextBox passwordBox2 = new PasswordTextBox();
      userInfo.setWidget(0, 0, userNameLabel);
      userInfo.setWidget(0, 1, userName);
      userInfo.setWidget(1, 0, passwordLabel);
      userInfo.setWidget(1, 1, passwordBox1);
      userInfo.setWidget(2, 0, passwordLabel2);
      userInfo.setWidget(2, 1, passwordBox2);

      VerticalPanel vPanel = new VerticalPanel();
      vPanel.add(message);
      vPanel.add(userInfo);
      HorizontalPanel buttonPanel = new HorizontalPanel();
      Button okButton = new Button("提交");
      buttonPanel.add(okButton);
      okButton.addClickListener(new ClickListener() {
          @Override
          public void onClick(Widget sender) {
            String pwd = userName.getText();
            if (pwd.equals("")) {
              message.setHTML("<font color=red>原密码不能为空！</font>");
              return;
            } else {
              String password = passwordBox1.getText();
              String checkPassword = passwordBox2.getText();
              if (password.equals("")) {
                message.setHTML("<font color=red>新密码不能为空！</font>");
                return;
              }
              if (password.length() < 6) {
                message.setHTML("<font color=red>新密码长度不能小于6位！</font>");
                return;
              }
              if (!checkPassword.equals(password)) {
                message.setHTML("<font color=red>新密码两次输入不一致！</font>");
                return;
              }
              if (password.equals(pwd)) {
                message.setHTML("<font color=red>新密码不能和原密码一样！</font>");
                return;
              }
            
              String userid = Ode.getInstance().getUser().getUserId();
              Ode.getInstance().getUserInfoService().modifyPassword(userid, pwd, password,
                new OdeAsyncCallback<String>("密码修改失败！") {
                  @Override
                  public void onSuccess(String reusltStr) {
                    if (reusltStr.contains("成功"))
                      message.setHTML("<font color=green>" + reusltStr + "</font>");
                    else
                      message.setHTML("<font color=red>" + reusltStr + "</font>");

                    //dialogBox.hide();
                  }
                  @Override
                  public void onFailure(Throwable error) {
                    OdeLog.xlog(error);
                    super.onFailure(error);

                    //dialogBox.hide();
                  }
                });

            }
          }
        });
      Button cancelButton = new Button("关闭");
      buttonPanel.add(cancelButton);
      cancelButton.addClickListener(new ClickListener() {
          @Override
          public void onClick(Widget sender) {
            dialogBox.hide();
          }
        });
      vPanel.add(buttonPanel);
      dialogBox.setWidget(vPanel);
      dialogBox.center();
      dialogBox.show();
    }
  }

  private static class DeleteAccountAction implements Command {
    @Override
    public void execute() {
      if(ProjectListBox.getProjectListBox().getProjectList().getMyProjectsCount() > 0) {
        Ode.getInstance().genericWarning(MESSAGES.warnHasProjects());
      } else {
        Ode.getInstance().getUserInfoService().deleteAccount(
          new OdeAsyncCallback<String>(MESSAGES.accountDeletionFailed()) {
            @Override
            public void onSuccess(String delAccountUrl) {
              if (delAccountUrl.equals("")) {
                Ode.getInstance().genericWarning(MESSAGES.warnHasProjects());
              } else {
                if (delAccountUrl.equals("NONE")) {
                  Window.Location.replace(SIGNOUT_URL);
                } else {
                  Window.Location.replace(delAccountUrl);
                }
              }
            }
          });
      }
      return;
    }
  }

  private class SelectLanguage implements Command {

    private String localeName;

    @Override
    public void execute() {
      final String queryParam = LocaleInfo.getLocaleQueryParam();
      Command savecmd = new SaveAction();
      savecmd.execute();
      if (queryParam != null) {
        UrlBuilder builder = Window.Location.createUrlBuilder().setParameter(
            queryParam, localeName);
        Window.Location.replace(builder.buildString());
      } else {
        // If we are using only cookies, just reload
        Window.Location.reload();
      }
    }

    public void setLocale(String nativeName) {
      localeName = nativeName;
    }

  }

  private class SaveAction implements Command {
    @Override
    public void execute() {
      ProjectRootNode projectRootNode = Ode.getInstance().getCurrentYoungAndroidProjectRootNode();
      if (projectRootNode != null) {
        ChainableCommand cmd = new SaveAllEditorsCommand(null);
        cmd.startExecuteChain(Tracking.PROJECT_ACTION_SAVE_YA, projectRootNode);
      }
    }
  }

}

