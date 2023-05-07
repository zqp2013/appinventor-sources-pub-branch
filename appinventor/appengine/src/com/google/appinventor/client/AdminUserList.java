// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2015 MIT, All rights reserved
// This code is unreleased

package com.google.appinventor.client;

import static com.google.appinventor.client.Ode.MESSAGES;
import com.google.appinventor.client.admin.AdminComparators;
import com.google.appinventor.client.output.OdeLog;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.CheckBox;
import com.google.gwt.user.client.ui.ClickListener;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlexTable;
import com.google.gwt.user.client.ui.Grid;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PasswordTextBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

import com.google.appinventor.client.widgets.LabeledTextBox;
import com.google.appinventor.shared.rpc.AdminInterfaceException;
import com.google.appinventor.shared.rpc.admin.AdminUser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * A list of User elements used in the Admin interface
 *
 * @author jis@mit.edu (Jeffrey I. Schiller)
 */
public class AdminUserList extends Composite {
  private enum SortField {
    NAME,
    VISITED,
    FROM,
    EXPIRED,
  }
  private enum SortOrder {
    ASCENDING,
    DESCENDING,
  }

  // TODO: add these to OdeMessages.java

  private final List<AdminUser> adminUsers;
  private SortField sortField;
  private SortOrder sortOrder;

  // UI elements
  private final Grid table;
  private final Label nameSortIndicator;
  private final Label visitedSortIndicator;
  private final Label fromSortIndicator;
  private final Label expiredSortIndicator;

  // Date Time Formatter
  static final DateTimeFormat dateTimeFormat = DateTimeFormat.getMediumDateTimeFormat();
  static final DateTimeFormat expiredFormat = DateTimeFormat.getFormat("yyyy/MM/dd");

  // Callback to fill in table with user objects
  private final OdeAsyncCallback<List<AdminUser>> searchCallback = new OdeAsyncCallback<List<AdminUser>>(
    "Ooops") {
    @Override
    public void onSuccess(List<AdminUser> newadminUsers) {
      adminUsers.clear();
      for (AdminUser user : newadminUsers) {
        adminUsers.add(user);
      }
      refreshTable(true);
      refreshSortIndicators();
    }

  };

  /**
   * Creates a new AdminUserList
   */
  public AdminUserList() {

    adminUsers = new ArrayList<AdminUser>();

    sortField = SortField.VISITED;
    sortOrder = SortOrder.ASCENDING;;

    // Initialize UI
    table = new Grid(1, 7); // The table initially contains just the header row.
    table.addStyleName("ode-ProjectTable");
    table.setWidth("100%");
    table.setCellSpacing(0);
    nameSortIndicator = new Label("");
    visitedSortIndicator = new Label("");
    fromSortIndicator = new Label("");
    expiredSortIndicator = new Label("");
    refreshSortIndicators();
    setHeaderRow();

    HorizontalPanel searchPanel = new HorizontalPanel();
    searchPanel.setSpacing(5);
    final LabeledTextBox searchText = new LabeledTextBox("输入账号：");
    Button searchButton = new Button("搜索");
    searchPanel.add(searchText);
    searchPanel.add(searchButton);
    Button addUserButton = new Button("添加账户");
    addUserButton.addClickListener(new ClickListener() {
        @Override
        public void onClick(Widget sender) {
          addUpdateUserDialog(null);
        }
      });
    searchPanel.add(addUserButton);

    searchButton.addClickListener(new ClickListener() {
        @Override
        public void onClick(Widget sender) {
          Ode.getInstance().getAdminInfoService().searchUsers(searchText.getText(), searchCallback);
        }
      });

    VerticalPanel panel = new VerticalPanel();
    panel.setWidth("100%");

    panel.add(searchPanel);
    panel.add(table);
    Button dismissButton = new Button("禁用");
    dismissButton.addClickListener(new ClickListener() {
        @Override
        public void onClick(Widget sender) {
          Ode.getInstance().switchToDesignView();
        }
      });
    panel.add(dismissButton);
    initWidget(panel);
  }

  /**
   * Adds the header row to the table.
   *
   */
  private void setHeaderRow() {
    table.getRowFormatter().setStyleName(0, "ode-ProjectHeaderRow");

    HorizontalPanel emailHeader = new HorizontalPanel();
    final Label emailHeaderLabel = new Label("用户账号");
    emailHeaderLabel.addStyleName("ode-ProjectHeaderLabel");
    emailHeader.add(emailHeaderLabel);
    emailHeader.add(nameSortIndicator);
    table.setWidget(0, 0, emailHeader);

    HorizontalPanel uidHeader = new HorizontalPanel();
    final Label uidHeaderLabel = new Label("UID");
    uidHeaderLabel.addStyleName("ode-ProjectHeaderLabel");
    uidHeader.add(uidHeaderLabel);
    table.setWidget(0, 1, uidHeader);

    HorizontalPanel adminHeader = new HorizontalPanel();
    final Label adminHeaderLabel = new Label("是管理员？");
    adminHeaderLabel.addStyleName("ode-ProjectHeaderLabel");
    adminHeader.add(adminHeaderLabel);
    table.setWidget(0, 2, adminHeader);

    HorizontalPanel visitedHeader = new HorizontalPanel();
    final Label visitedLabel = new Label("最后一次访问时间");
    visitedLabel.addStyleName("ode-ProjectHeaderLabel");
    visitedHeader.add(visitedLabel);
    visitedHeader.add(visitedSortIndicator);
    table.setWidget(0, 3, visitedHeader);


    // AI2中文网新增
    HorizontalPanel fromHeader = new HorizontalPanel();
    final Label fromHeaderLabel = new Label("用户来源");
    fromHeaderLabel.addStyleName("ode-ProjectHeaderLabel");
    fromHeader.add(fromHeaderLabel);
    fromHeader.add(fromSortIndicator);
    table.setWidget(0, 4, fromHeader);

    HorizontalPanel expiredHeader = new HorizontalPanel();
    final Label expiredHeaderLabel = new Label("到期日");
    expiredHeaderLabel.addStyleName("ode-ProjectHeaderLabel");
    expiredHeader.add(expiredHeaderLabel);
    expiredHeader.add(expiredSortIndicator);
    table.setWidget(0, 5, expiredHeader);

    HorizontalPanel remarkHeader = new HorizontalPanel();
    final Label remarkHeaderLabel = new Label("备注");
    remarkHeaderLabel.addStyleName("ode-ProjectHeaderLabel");
    remarkHeader.add(remarkHeaderLabel);
    table.setWidget(0, 6, remarkHeader);


    MouseDownHandler mouseDownHandler = new MouseDownHandler() {
      @Override
      public void onMouseDown(MouseDownEvent e) {
        SortField clickedSortField;
        if (e.getSource() == emailHeaderLabel || e.getSource() == nameSortIndicator) {
          clickedSortField = SortField.NAME;
        } else if (e.getSource() == visitedLabel || e.getSource() == visitedSortIndicator) {
          clickedSortField = SortField.VISITED;
        } else if (e.getSource() == fromHeaderLabel || e.getSource() == fromSortIndicator) {
          clickedSortField = SortField.FROM;
        } else if (e.getSource() == expiredHeaderLabel || e.getSource() == expiredSortIndicator) {
          clickedSortField = SortField.EXPIRED;
        } else {
          return;
        }
        changeSortOrder(clickedSortField);
      }
    };
    emailHeaderLabel.addMouseDownHandler(mouseDownHandler);
    nameSortIndicator.addMouseDownHandler(mouseDownHandler);
    visitedLabel.addMouseDownHandler(mouseDownHandler);
    visitedSortIndicator.addMouseDownHandler(mouseDownHandler);
    fromHeaderLabel.addMouseDownHandler(mouseDownHandler);
    fromSortIndicator.addMouseDownHandler(mouseDownHandler);
    expiredHeaderLabel.addMouseDownHandler(mouseDownHandler);
    expiredSortIndicator.addMouseDownHandler(mouseDownHandler);
  }

  private void changeSortOrder(SortField clickedSortField) {
    if (sortField != clickedSortField) {
      sortField = clickedSortField;
      sortOrder = SortOrder.ASCENDING;
    } else {
      if (sortOrder == SortOrder.ASCENDING) {
        sortOrder = SortOrder.DESCENDING;
      } else {
        sortOrder = SortOrder.ASCENDING;
      }
    }
    refreshTable(true);
  }

  private void refreshSortIndicators() {
    String text = (sortOrder == SortOrder.ASCENDING)
        ? "\u25B2"      // up-pointing triangle
        : "\u25BC";     // down-pointing triangle
    switch (sortField) {
      case NAME:
        nameSortIndicator.setText(text);
        visitedSortIndicator.setText("");
        fromSortIndicator.setText("");
        expiredSortIndicator.setText("");
        break;
      case VISITED:
        nameSortIndicator.setText("");
        visitedSortIndicator.setText(text);
        fromSortIndicator.setText("");
        expiredSortIndicator.setText("");
        break;
      case FROM:
        nameSortIndicator.setText("");
        visitedSortIndicator.setText("");
        fromSortIndicator.setText(text);
        expiredSortIndicator.setText("");
        break;
      case EXPIRED:
        nameSortIndicator.setText("");
        visitedSortIndicator.setText("");
        fromSortIndicator.setText("");
        expiredSortIndicator.setText(text);
        break;
    }
  }

  private class UserWidgets {
    final Label nameLabel;
    final Label uidLabel;
    final Label visitedLabel;
    final Label isAdminLabel;
    final Label fromLabel;
    final Label expiredLabel;
    final Label remarkLabel;

    private UserWidgets(final AdminUser user) {
      nameLabel = new Label(user.getEmail());
      nameLabel.addStyleName("ode-ProjectNameLabel");
      uidLabel = new Label(user.getId());
      Date visited = user.getVisited();
      if (visited == null) {
        visitedLabel = new Label("<从未登录>");
      } else {
        visitedLabel = new Label(dateTimeFormat.format(user.getVisited()));
      }
      boolean isAdmin = user.getIsAdmin();
      if (!isAdmin) {
        isAdminLabel = new Label("否");
      } else {
        isAdminLabel = new Label("<是>");
      }
      fromLabel = new Label(user.getFrom());
      Date expired = user.getExpired();
      if (expired == null) {
        expiredLabel = new Label("<未设置>");
      } else {
        expiredLabel = new Label(expiredFormat.format(expired));
      }
      remarkLabel = new Label(user.getRemark());
      nameLabel.addMouseDownHandler(new MouseDownHandler() {
          @Override
          public void onMouseDown(MouseDownEvent e) {
            addUpdateUserDialog(user);
          }
        });
    }
  }

  // TODO(user): This method was made public so it can be called
  // directly from from Ode when the AdminUserList view is selected
  // from another view.
  public void refreshTable(boolean needToSort) {
    if (needToSort) {
      // Sort the projects.
      Comparator<AdminUser> comparator;
      switch (sortField) {
        default:
        case NAME:
          comparator = (sortOrder == SortOrder.ASCENDING)
            ? AdminComparators.COMPARE_BY_NAME_ASCENDING
            : AdminComparators.COMPARE_BY_NAME_DESCENDING;
          break;
        case VISITED:
          comparator = (sortOrder == SortOrder.ASCENDING)
            ? AdminComparators.COMPARE_BY_VISTED_DATE_ASCENDING
            : AdminComparators.COMPARE_BY_VISTED_DATE_DESCENDING;
          break;
        case FROM:
          comparator = (sortOrder == SortOrder.ASCENDING)
            ? AdminComparators.COMPARE_BY_FROM_ASCENDING
            : AdminComparators.COMPARE_BY_FROM_DESCENDING;
          break;
        case EXPIRED:
          comparator = (sortOrder == SortOrder.ASCENDING)
            ? AdminComparators.COMPARE_BY_EXPIRED_DATE_ASCENDING
            : AdminComparators.COMPARE_BY_EXPIRED_DATE_DESCENDING;
          break;
      }
      Collections.sort(adminUsers, comparator);
    }

    refreshSortIndicators();

    // Refill the table.
    table.resize(1 + adminUsers.size(), 7);
    int row = 1;
    for (AdminUser user : adminUsers) {
      UserWidgets uw = new UserWidgets(user);
      table.setWidget(row, 0, uw.nameLabel);
      table.setWidget(row, 1, uw.uidLabel);
      table.setWidget(row, 2, uw.isAdminLabel);
      table.setWidget(row, 3, uw.visitedLabel);
      table.setWidget(row, 4, uw.fromLabel);
      table.setWidget(row, 5, uw.expiredLabel);
      table.setWidget(row, 6, uw.remarkLabel);
      row++;
    }

  }

  private void addUpdateUserDialog(final AdminUser user) {
    boolean adding = true;
    if (user != null) {         // Adding a user
      adding = false;
    }
    final DialogBox dialogBox = new DialogBox(false, true);
    dialogBox.setStylePrimaryName("ode-DialogBox");
    if (adding) {
      dialogBox.setText("添加账户");
    } else {
      dialogBox.setText("更新账户");
    }
    dialogBox.setGlassEnabled(true);
    dialogBox.setAnimationEnabled(true);
    final HTML message = new HTML("");
    message.setStyleName("DialogBox-message");
    final FlexTable userInfo = new FlexTable(); // Holds the username and password labels and boxes
    final Label userNameLabel = new Label("账户");
    final TextBox userName = new TextBox();
    final Label passwordLabel = new Label("密码");
    final Label passwordLabel2 = new Label("确认密码");
    final TextBox passwordBox = new TextBox();
    // We switch to the ones below if the hidePasswordCheckbox is selected
    // otherwise we use the passwordBox above for the password
    final PasswordTextBox passwordBox1 = new PasswordTextBox();
    final PasswordTextBox passwordBox2 = new PasswordTextBox();
    userInfo.setWidget(0, 0, userNameLabel);
    userInfo.setWidget(0, 1, userName);
    userInfo.setWidget(1, 0, passwordLabel);
    userInfo.setWidget(1, 1, passwordBox);

    final Label fromLabel = new Label("来源");
    final TextBox from = new TextBox();
    final Label expiredLabel = new Label("到期日");
    final TextBox expired = new TextBox();
    final Label remarkLabel = new Label("备注");
    final TextBox remark = new TextBox();
    userInfo.setWidget(2, 0, fromLabel);
    userInfo.setWidget(2, 1, from);
    userInfo.setWidget(3, 0, expiredLabel);
    userInfo.setWidget(3, 1, expired);
    userInfo.setWidget(4, 0, remarkLabel);
    userInfo.setWidget(4, 1, remark);

    final CheckBox isAdminBox = new CheckBox("是管理员?");
    final CheckBox hidePasswordCheckbox = new CheckBox("隐藏密码");
    final HorizontalPanel checkboxPanel = new HorizontalPanel();
    checkboxPanel.add(isAdminBox);
    checkboxPanel.add(hidePasswordCheckbox);

    VerticalPanel vPanel = new VerticalPanel();
    vPanel.add(message);
    vPanel.add(userInfo);
    vPanel.add(checkboxPanel);
    HorizontalPanel buttonPanel = new HorizontalPanel();
    Button okButton = new Button("确定");
    buttonPanel.add(okButton);
    hidePasswordCheckbox.addClickListener(new ClickListener() {
        @Override
        public void onClick(Widget sender) {
          if (hidePasswordCheckbox.isChecked()) { // We just asked to mask passwords
            userInfo.setWidget(1, 0, passwordLabel);
            userInfo.setWidget(1, 1, passwordBox1);
            userInfo.setWidget(2, 0, passwordLabel2);
            userInfo.setWidget(2, 1, passwordBox2);
            
            userInfo.setWidget(3, 0, fromLabel);
            userInfo.setWidget(3, 1, from);
            userInfo.setWidget(4, 0, expiredLabel);
            userInfo.setWidget(4, 1, expired);
            userInfo.setWidget(5, 0, remarkLabel);
            userInfo.setWidget(5, 1, remark);
          } else {              // Unchecked, passwords in the clear
            userInfo.setWidget(1, 0, passwordLabel);
            userInfo.setWidget(1, 1, passwordBox);

            userInfo.setWidget(2, 0, fromLabel);
            userInfo.setWidget(2, 1, from);
            userInfo.setWidget(3, 0, expiredLabel);
            userInfo.setWidget(3, 1, expired);
            userInfo.setWidget(4, 0, remarkLabel);
            userInfo.setWidget(4, 1, remark);

            userInfo.removeRow(2);
          }
        }
      });
    okButton.addClickListener(new ClickListener() {
        @Override
        public void onClick(Widget sender) {
          String password = passwordBox.getText();
          if (hidePasswordCheckbox.isChecked()) {
            password = passwordBox1.getText();
            String checkPassword = passwordBox2.getText();
            if (!checkPassword.equals(password)) {
              message.setHTML("<font color=red>两次密码不匹配！</font>");
              return;
            }
          }
          String email = userName.getText();
          if (email.equals("")) {
            message.setHTML("<font color=red>账户不能为空！</font>");
            return;
          } else {
            // Work!!
            AdminUser nuser = user;
            String fromStr = from.getText();
            String expiredStr = expired.getText();
            if (expiredStr.equals("")) {
              message.setHTML("<font color=red>到期日不能为空！</font>");
              return;
            }
            Date expiredDate = null;
            try {
              expiredDate = expiredFormat.parse(expiredStr);
            } catch (Exception e) {
              message.setHTML("<font color=red>到期日格式不对！格式例如：2023/01/01</font>");
              return;
            }
            
            String remarkStr = remark.getText();
            if (nuser == null) {
              nuser = new AdminUser(null, email, email, false, isAdminBox.isChecked(), null, fromStr, expiredDate, remarkStr);
            } else {
              nuser.setIsAdmin(isAdminBox.isChecked());
              nuser.setEmail(email);
              nuser.setFrom(fromStr);
              nuser.setExpired(expiredDate);
              nuser.setRemark(remarkStr);
            }
            nuser.setPassword(password);
            Ode.getInstance().getAdminInfoService().storeUser(nuser,
              new OdeAsyncCallback<Void> ("Oops") {
                @Override
                public void onSuccess(Void v) {
                  dialogBox.hide();
                }
                @Override
                public void onFailure(Throwable error) {
                  OdeLog.xlog(error);
                  if (error instanceof AdminInterfaceException) {
                    ErrorReporter.reportError(error.getMessage());
                  } else {
                    super.onFailure(error);
                  }
                  dialogBox.hide();
                }
              });
          }
        }
      });
    Button cancelButton = new Button("取消");
    buttonPanel.add(cancelButton);
    cancelButton.addClickListener(new ClickListener() {
        @Override
        public void onClick(Widget sender) {
          dialogBox.hide();
        }
      });
    vPanel.add(buttonPanel);
    dialogBox.setWidget(vPanel);
    if (!adding) {
      isAdminBox.setChecked(user.getIsAdmin());
      userName.setText(user.getEmail());
      from.setText(user.getFrom());
      if(user.getExpired() != null)
        expired.setText(expiredFormat.format(user.getExpired()));
      remark.setText(user.getRemark());
    }
    // switchUserPanel -- Put up a button to permit us to
    // switch to the selected user, but readonly
    if (!adding) {
      HorizontalPanel switchUserPanel = new HorizontalPanel();
      Button switchButton = new Button("切换到该用户下");
      switchButton.addClickListener(new ClickListener() {
          @Override
          public void onClick(Widget sender) {
            Ode.getInstance().setReadOnly();  // Must make sure we are read only.
                                              // When we call reloadWindow (below) the onClosing
                                              // handler in Ode will be called. It will attempt
                                              // to save the project settings. But by the time we
                                              // return below, we have switched accounts, so the settings
                                              // will be saved in the wrong account(!!). So we set the
                                              // read-only flag now!
            Ode.getInstance().getAdminInfoService().switchUser(user, new OdeAsyncCallback<Void>("Oops") {
                @Override
                public void onSuccess(Void v) {
                  Ode.getInstance().reloadWindow(false);
                }
              });
          }
        });
      switchUserPanel.add(switchButton);
      vPanel.add(switchUserPanel);
    }
    dialogBox.center();
    dialogBox.show();
  }
}

