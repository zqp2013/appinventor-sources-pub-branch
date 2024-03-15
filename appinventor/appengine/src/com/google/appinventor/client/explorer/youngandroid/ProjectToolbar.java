// -*- mode: java; c-basic-offset: 2; -*-
// Copyright 2009-2011 Google, All Rights reserved
// Copyright 2011-2012 MIT, All rights reserved
// Released under the Apache License, Version 2.0
// http://www.apache.org/licenses/LICENSE-2.0

package com.google.appinventor.client.explorer.youngandroid;

import com.google.appinventor.client.ErrorReporter;
import com.google.appinventor.client.Ode;
import com.google.appinventor.client.OdeAsyncCallback;
import com.google.appinventor.client.TopToolbar;
import com.google.appinventor.client.boxes.ProjectListBox;
import com.google.appinventor.client.explorer.project.Project;
import com.google.appinventor.client.widgets.Toolbar;
import com.google.appinventor.client.wizards.youngandroid.NewYoungAndroidProjectWizard;
import com.google.appinventor.shared.rpc.RpcResult;
import com.google.gwt.user.client.Command;
import com.google.gwt.user.client.Window;
import com.google.appinventor.client.wizards.NewFolderWizard;
import com.google.appinventor.client.wizards.MoveProjectsWizard;
import com.google.appinventor.client.explorer.folder.ProjectFolder;

import java.util.List;
import java.util.ArrayList;

import static com.google.appinventor.client.Ode.MESSAGES;

/**
 * The project toolbar houses command buttons in the Young Android Project tab.
 *
 */
public class ProjectToolbar extends Toolbar {
  private static final String WIDGET_NAME_NEW = "New";
  private static final String WIDGET_NAME_NEW_FOLDER = "New Folder";
  private static final String WIDGET_NAME_MOVE = "Move...";
  private static final String WIDGET_NAME_DELETE = "Delete";
  private static final String WIDGET_NAME_TRASH = "Trash";
  private static final String WIDGET_NAME_PROJECT= "Projects";
  private static final String WIDGET_NAME_RESTORE= "Restore";
  private static final String WIDGET_NAME_DELETE_FROM_TRASH= "Delete From Trash";
  private static final String WIDGET_NAME_SENDTONG = "Send to Gallery";
  private static final String WIDGET_NAME_LOGINTOGALLERY = "Login to Gallery";

  private boolean isReadOnly;

  private boolean galleryEnabled = false; // Is the new gallery enabled

  private static volatile boolean lockPublishButton = false; // To prevent double clicking

  /**
   * Initializes and assembles all commands into buttons in the toolbar.
   */
  public ProjectToolbar() {
    super();
    isReadOnly = Ode.getInstance().isReadOnly();
    galleryEnabled = Ode.getInstance().getSystemConfig().getGalleryEnabled();

    addButton(new ToolbarItem(WIDGET_NAME_NEW, MESSAGES.newProjectMenuItem(),
        new NewAction(this)));
    
    addButton(new ToolbarItem(WIDGET_NAME_NEW_FOLDER, MESSAGES.newProjectFolderButton(),
        new NewFolderAction()));
    addButton(new ToolbarItem(WIDGET_NAME_MOVE, MESSAGES.moveProjectButton(),
        new MoveProjectsAction()));

    addButton(new ToolbarItem(WIDGET_NAME_DELETE, MESSAGES.deleteProjectButton(),
        new DeleteAction())); //MoveToTrashAction
    addButton(new ToolbarItem(WIDGET_NAME_TRASH,MESSAGES.trashButton(),
        new TrashAction()));    
    addButton(new ToolbarItem(WIDGET_NAME_PROJECT,MESSAGES.myProjectsButton(),
        new BackToProjectViewAction()));
    addButton(new ToolbarItem(WIDGET_NAME_RESTORE,MESSAGES.restoreProjectButton(),
        new RestoreProjectAction()));
    addButton(new ToolbarItem(WIDGET_NAME_DELETE_FROM_TRASH,MESSAGES.deleteFromTrashButton(),
        new TopToolbar.DeleteForeverProjectAction()));
    if (galleryEnabled) {
      addButton(new ToolbarItem(WIDGET_NAME_LOGINTOGALLERY, MESSAGES.loginToGallery(),
          new LoginToGalleryAction()));
      if (!Ode.getInstance().getGalleryReadOnly()) {
        addButton(new ToolbarItem(WIDGET_NAME_SENDTONG, MESSAGES.publishToGalleryButton(),
            new SendToGalleryAction()));
      }
    }

    setTrashTabButtonsVisible(false);
    updateButtons();
  }

  public void setTrashTabButtonsVisible(boolean visible) {
    setButtonVisible(WIDGET_NAME_PROJECT, visible);
    setButtonVisible(WIDGET_NAME_RESTORE, visible);
    setButtonVisible(WIDGET_NAME_DELETE_FROM_TRASH, visible);
    updateButtons();
  }

  public void setProjectTabButtonsVisible(boolean visible) {
    setButtonVisible(WIDGET_NAME_NEW, visible);
    setButtonVisible(WIDGET_NAME_NEW_FOLDER, visible);
    setButtonVisible(WIDGET_NAME_MOVE,visible);
    setButtonVisible(WIDGET_NAME_TRASH,visible);    
    setButtonVisible(WIDGET_NAME_DELETE,visible);
  }

  private static class NewAction implements Command {
    ProjectToolbar parent;

    public NewAction(ProjectToolbar parent) {
      this.parent = parent;
    }

    @Override
    public void execute() {
      if (Ode.getInstance().screensLocked()) {
        return;                 // Refuse to switch if locked (save file happening)
      }


      // VIP到期
      if (TopToolbar.getLeftDays() <= 0) {
        TopToolbar.checkVip(-1);
        return;
      }

      // 试用账户项目数量限制
      if (Ode.getInstance().getUser().getUserEmail() == "test@fun123.cn" 
          && ProjectListBox.getProjectListBox().getProjectList().getMyProjectsCount() > 25) {
        TopToolbar.showVip("已达到试用账户项目数量上限，请升级VIP后继续！");
        return;
      }



      // Disabled the Start New Project button. We do this because on slow machines people
      // click it multiple times while the wizard (below) is starting. This then causes
      // a second wizard to start and a very confused user experience.
      // We will enable the button again when we re-visit the Project List page
      parent.setButtonEnabled(WIDGET_NAME_NEW, false);
      new NewYoungAndroidProjectWizard(parent).center();
      // The wizard will switch to the design view when the new
      // project is created.
    }
  }

  public class NewFolderAction implements Command {
    @Override
    public void execute() {

      // 试用账户不给权限
      if (Ode.getInstance().getUser().getUserEmail() == "test@fun123.cn" && !Ode.getInstance().isReadOnly()) {
        TopToolbar.showVip(null);
        return;
      }

      new NewFolderWizard();
    }
  }

  public class MoveProjectsAction implements Command {
    public void execute() {
      new MoveProjectsWizard();
    }
  }

  // private static class MoveToTrashAction implements Command {
  //   @Override
  //   public void execute() {
  //     Ode.getInstance().getEditorManager().saveDirtyEditors(new Command() {
  //       @Override
  //       public void execute() {
  //         List<Project> selectedProjects =
  //             ProjectListBox.getProjectListBox().getProjectList().getSelectedProjects();
  //         if (selectedProjects.size() > 0) {
  //           // Show one confirmation window for selected projects.
  //           if (deleteConfirmation(selectedProjects)) {
  //             for (Project project : selectedProjects) {
  //               project.moveToTrash();
  //             }
  //             Ode.getInstance().switchToProjectsView();
  //           }
  //           Ode.getInstance().switchToProjectsView();
  //         } else {
  //           // The user can select a project to resolve the
  //           // error.
  //           ErrorReporter.reportInfo(MESSAGES.noProjectSelectedForDelete());
  //         }
  //       }
  //     });
  //   }

  //   private boolean deleteConfirmation(List<Project> projects) {
  //     String message;
  //     if (projects.size() == 1) {
  //       message = MESSAGES.confirmMoveToTrashSingleProject(projects.get(0).getProjectName());
  //     } else {
  //       StringBuilder sb = new StringBuilder();
  //       String separator = "";
  //       for (Project project : projects) {
  //         sb.append(separator).append(project.getProjectName());
  //         separator = ", ";
  //       }
  //       String projectNames = sb.toString();
  //       message = MESSAGES.confirmMoveToTrash(projectNames);
  //     }
  //     return Window.confirm(message);
  //   }
  // }
  /* merge by 中文网：上面删除，带folder的删除逻辑*/
  public class DeleteAction implements Command {
    @Override
    public void execute() {

      // 试用账户不给权限
      if (Ode.getInstance().getUser().getUserEmail() == "test@fun123.cn" && !Ode.getInstance().isReadOnly()) {
        TopToolbar.showVip(null);
        return;
      }
      
      Ode.getInstance().getEditorManager().saveDirtyEditors(new Command() {
        @Override
        public void execute() {
          if (Ode.getInstance().getCurrentView() == Ode.PROJECTS) {
            List<Project> selectedProjects =
                ProjectListBox.getProjectListBox().getProjectList().getSelectedProjects();
            List<ProjectFolder> selectedFolders = ProjectListBox.getProjectListBox().getProjectList().getSelectedFolders();
            if (selectedProjects.size() > 0 || selectedFolders.size() > 0) {
              List<Project> projectsToDelete = selectedProjects;
              for (ProjectFolder f : selectedFolders) {
                projectsToDelete.addAll(f.getNestedProjects());
              }
              // Show one confirmation window for selected projects.
              if (deleteConfirmation(projectsToDelete)) {
                for (Project project : projectsToDelete) {
                  project.moveToTrash();
                }
                for (ProjectFolder f : selectedFolders) {
                  f.getParentFolder().removeChildFolder(f);
                }
              }
            } else {
              // The user can select a project to resolve the
              // error.
              ErrorReporter.reportInfo(MESSAGES.noProjectSelectedForDelete());
            }
          } else { //We are deleting a project in the designer view
            List<Project> selectedProjects = new ArrayList<Project>();
            Project currentProject = Ode.getInstance().getProjectManager().getProject(Ode.getInstance().getCurrentYoungAndroidProjectId());
            selectedProjects.add(currentProject);
            if (deleteConfirmation(selectedProjects)) {
              currentProject.moveToTrash();
              //Add the command to stop this current project from saving
            }
          }
          Ode.getInstance().switchToProjectsView();
        }
      });
    }
  
  
    private boolean deleteConfirmation(List<Project> projects) {
      String message;
      if (projects.size() == 1) {
        message = MESSAGES.confirmMoveToTrashSingleProject(projects.get(0).getProjectName());
      } else if (projects.size() < 10) {
        StringBuilder sb = new StringBuilder();
        String separator = "";
        for (Project project : projects) {
          sb.append(separator).append(project.getProjectName());
          separator = ", ";
        }
        String projectNames = sb.toString();
        message = MESSAGES.confirmMoveToTrash(projectNames);
      } else {
        message = MESSAGES.confirmMoveToTrashCount(Integer.toString(projects.size()));
      }
      return Window.confirm(message);
    }
  }

  //implementing trash method this method will show the Trash Tab
  private static class TrashAction implements Command {
    @Override
    public void execute() {
      Ode.getInstance().getEditorManager().saveDirtyEditors(new Command() {
        @Override
        public void execute() {
          Ode.getInstance().switchToTrash();
        }
      });
    }
  }

  //Moving Back From Trash Tab To Projects Tab
  private static class BackToProjectViewAction implements Command {
    @Override
    public void execute() {
      Ode.getInstance().getEditorManager().saveDirtyEditors(new Command() {
        @Override
        public void execute() {
          Ode.getInstance().getTopToolbar().updateMoveToTrash("Move To Trash");
          Ode.getInstance().switchToProjectsView();
        }
      });
    }
  }

  //Restoring the project back to My Projects from Trash Can
  private static class RestoreProjectAction implements Command {
    @Override
    public void execute() {
      List<Project> selectedProjects = ProjectListBox.getProjectListBox().getProjectList().getSelectedProjects();
      if (selectedProjects.size() > 0) {
        for (Project project : selectedProjects) {
          project.restoreFromTrash();
        }
        Ode.getInstance().switchToTrash();
      } else {
        // The user can select a project to resolve the
        // error.
        ErrorReporter.reportInfo(MESSAGES.noProjectSelectedForRestore());
      }
    }
  }

  // Login to the New Gallery
  private static class LoginToGalleryAction implements Command {
    @Override
      public void execute() {
      Ode.getInstance().getProjectService().loginToGallery(
        new OdeAsyncCallback<RpcResult>(
          MESSAGES.GalleryLoginError()) {
          @Override
          public void onSuccess(RpcResult result) {
            if (result.getResult() == RpcResult.SUCCESS) {
              Window.open(result.getOutput(), "_blank", "");
            } else {
              ErrorReporter.reportError(result.getError());
            }
          }
        });
    }
  }

  // Send to the New Gallery
  private static class SendToGalleryAction implements Command {
    @Override
    public void execute() {
      List<Project> selectedProjects =
        ProjectListBox.getProjectListBox().getProjectList().getSelectedProjects();
      if (selectedProjects.size() != 1) {
        ErrorReporter.reportInfo(MESSAGES.selectOnlyOneProject());
      } else {
        if (!lockPublishButton) {
          lockPublishButton = true;
          Project project = selectedProjects.get(0);
          Ode.getInstance().getProjectService().sendToGallery(project.getProjectId(),
            new OdeAsyncCallback<RpcResult>(
              MESSAGES.GallerySendingError()) {
              @Override
              public void onSuccess(RpcResult result) {
                lockPublishButton = false;
                if (result.getResult() == RpcResult.SUCCESS) {
                  Window.open(result.getOutput(), "_blank", "");
                } else {
                  ErrorReporter.reportError(result.getError());
                }
              }
              @Override
              public void onFailure(Throwable t) {
                lockPublishButton = false;
                super.onFailure(t);
              }
            });
        }
      }
    }
  }

  private boolean deleteConfirmation(List<Project> projects) {
    String message;
    if (projects.size() == 1) {
      message = MESSAGES.confirmDeleteSingleProject(projects.get(0).getProjectName());
    } else {
      StringBuilder sb = new StringBuilder();
      String separator = "";
      for (Project project : projects) {
        sb.append(separator).append(project.getProjectName());
        separator = ", ";
      }
      String projectNames = sb.toString();
      message = MESSAGES.confirmDeleteManyProjects(projectNames);
    }
    return Window.confirm(message);
  }

  /**
   * Enables and/or disables buttons based on how many projects exist
   * (in the case of "Download All Projects") or are selected (in the case
   * of "Delete" and "Download Source").
   */
  public void updateButtons() {
    ProjectList projectList = ProjectListBox.getProjectListBox().getProjectList();
    int numProjects = projectList.getMyProjectsCount();  // Get number of valid projects not in trash
    int numSelectedProjects = projectList.getSelectedProjectsCount();
    if (isReadOnly) {           // If we are read-only, we disable all buttons
      setButtonEnabled(WIDGET_NAME_NEW, false);
      setButtonEnabled(WIDGET_NAME_NEW_FOLDER, false);
      setButtonEnabled(WIDGET_NAME_MOVE, false);
      // del+add by 中文网：admin可以删除/恢复项目
      //setButtonEnabled(WIDGET_NAME_DELETE, false);
      //setButtonEnabled(WIDGET_NAME_RESTORE, false);
      setButtonEnabled(WIDGET_NAME_DELETE, numSelectedProjects > 0);
      setButtonEnabled(WIDGET_NAME_RESTORE, numSelectedProjects > 0);

      Ode.getInstance().getTopToolbar().updateMenuState(numSelectedProjects, numProjects);
      return;
    }
    setButtonEnabled(WIDGET_NAME_MOVE, numSelectedProjects > 0);
    setButtonEnabled(WIDGET_NAME_DELETE, numSelectedProjects > 0);
    setButtonEnabled(WIDGET_NAME_DELETE_FROM_TRASH, numSelectedProjects > 0);
    setButtonEnabled(WIDGET_NAME_RESTORE, numSelectedProjects > 0);
    Ode.getInstance().getTopToolbar().updateMenuState(numSelectedProjects, numProjects);
  }

  // If we started a project, then the start button was disabled (to avoid
  // a second press while the new project wizard was starting (aka we "debounce"
  // the button). When the person switches to the projects list view again (here)
  // we re-enable it.
  public void enableStartButton() {
    if (!isReadOnly) {
      setButtonEnabled(WIDGET_NAME_NEW, true);
    }
  }

}
