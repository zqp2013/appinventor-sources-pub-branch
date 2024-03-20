package cn.fun123.PhoneInfo;
//https://community.appinventor.mit.edu/t/statusbartools-extension-free-open-source/19568

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.app.Activity;
import android.app.ActivityManager;
import android.os.Build;
import android.graphics.Color;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.view.ViewGroup.LayoutParams;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.EventDispatcher;
import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.ComponentConstants;
import com.google.appinventor.components.common.PropertyTypeConstants;

@DesignerComponent(version = 1, description = "Created by Salman Developer", category = ComponentCategory.EXTENSION, nonVisible = true, iconName = "https://img.icons8.com/fluent/16/000000/source-code.png")
@SimpleObject(external = true)
public class StatusBarTools extends AndroidNonvisibleComponent {
  private static final String LOG_TAG = "StatusBarTools";
  private ComponentContainer container;
  private static Context context;
  private final Activity activity;
  private boolean statusbarVisible;
  private boolean checkTpIcon = true;

  public StatusBarTools(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    context = container.$context();
    this.activity = container.$context();
  }

  @SimpleFunction(description = "This block is useful for changing the StatusBar background color")
  public void BackgroundColor(String hexColor) {
    checkTpIcon = true;

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
      Window w = this.activity.getWindow();
      w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      w.setStatusBarColor(Color.parseColor(hexColor));
    } else {
      Log.w(LOG_TAG, "Sorry, set StatusBar Color is not available for API Level < 21");
      return;
    }

  }

  @SimpleFunction(description = "This block is useful for changing the StatusBar background to Transparent")
  public void BackgroundTransparent() {
    checkTpIcon = true;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
      Window w = this.activity.getWindow();
      w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      w.setStatusBarColor(0xFF008375);
      w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    } else {
      Log.w(LOG_TAG, "Sorry, set StatusBar Transparent is not available for API Level < 21");
      return;
    }

  }

  @SimpleFunction(description = "This block is useful for changing the StatusBar background to Transparent with color")
  public void BGTransparentColor(String hexColor) {
    checkTpIcon = false;

    if (Build.VERSION.SDK_INT > Build.VERSION_CODES.KITKAT) {
      View v = this.activity.getWindow().getDecorView();
      v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);

      Window w = this.activity.getWindow();
      w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
      w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
      w.setStatusBarColor(Color.parseColor(hexColor));
    } else {
      Log.w(LOG_TAG, "Sorry, set StatusBar Transparent Color is not available for API Level < 21");
      return;
    }

  }

  @SimpleFunction(description = "This block is useful for changing the Icon Color in the StatusBar to Dark")
  public void IconDark() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (checkTpIcon) {
        View w = this.activity.getWindow().getDecorView().getRootView();
        w.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
      } else {
        View v = this.activity.getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
            | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
      }
    } else {
      Log.w(LOG_TAG, "Sorry, set StatusBar Icon to dark is not available for API Level < 23");
      return;
    }

  }

  @SimpleFunction(description = "This block is useful for changing the Icon Color in the StatusBar to Light")
  public void IconLight() {

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
      if (checkTpIcon) {
        View w = this.activity.getWindow().getDecorView().getRootView();
        w.setSystemUiVisibility(0);
      } else {
        View v = this.activity.getWindow().getDecorView();
        v.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
      }
    } else {
      Log.w(LOG_TAG, "Sorry, set StatusBar Icon to light is not available for API Level < 23");
      return;
    }

  }

}