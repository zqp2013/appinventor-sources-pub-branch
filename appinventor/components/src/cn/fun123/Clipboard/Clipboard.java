package cn.fun123.Clipboard;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

@DesignerComponent(version = Clipboard.VERSION,
    description = "App Inventor 2 剪贴板管理拓展。Powered by 中文网(www.fun123.cn)",
    helpUrl = "https://www.fun123.cn/reference/extensions/",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "https://www.fun123.cn/reference/extensions/icons/clipboard.png")
@SimpleObject(external = true)
@SuppressWarnings("deprecation")

public class Clipboard extends AndroidNonvisibleComponent implements Component {

  public static final int VERSION = 1;
  private ComponentContainer container;
  private Context context;
  private static final String LOG_TAG = "CB";
  private boolean suppressToast;


  public Clipboard(ComponentContainer container) {
    super(container.$form());
    this.container = container;
    context = (Context) container.$context();
    Log.d(LOG_TAG, "Clipboard Created");
  }


  /**
   * Returns whether Success Toast should be suppressed
   */
  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "操作成功后不显示提示信息，默认 false。")
  public boolean SuppressToast() {
    return suppressToast;
  }


  /**
   * Specifies whether Success Toast should be suppressed
   */
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "false")
  @SimpleProperty
  public void SuppressToast(boolean suppressToast) {
    this.suppressToast = suppressToast;
  }


  /**
   * The Copy method
   * http://stackoverflow.com/a/19253877/1545993 and http://stackoverflow.com/a/28780585/1545993
   *
   * @param text =  the text to copy
   */
  @SimpleFunction(description = "拷贝文本至剪贴板，如果 SuppressToast 是 true，则拷贝完成后不会显示'文本已拷贝'的提示信息。")
  public void Copy(String text) {
    try {
      int sdk = android.os.Build.VERSION.SDK_INT;
      if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
        android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setText(text);
      } else {
        android.content.ClipboardManager clipboard = (android.content.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        android.content.ClipData clip = android.content.ClipData.newPlainText("Copied text", text);
        clipboard.setPrimaryClip(clip);
      }
      Log.d(LOG_TAG, "文本已拷贝: " + text);
      if (!suppressToast) {
        Toast.makeText(context, "文本已拷贝", Toast.LENGTH_SHORT).show();
      }
    } catch (Exception e) {
      Log.e(LOG_TAG, e.getMessage(), e);
    }
  }


  /**
   * The Paste method
   * http://stackoverflow.com/a/19253877/1545993
   */
  @SimpleFunction(description = "从剪贴板粘贴文本，如果 SuppressToast 是 true，则粘贴完成后不会显示'文本已粘贴'的提示信息。")
  public String Paste() {
    int sdk = android.os.Build.VERSION.SDK_INT;
    if (sdk < android.os.Build.VERSION_CODES.HONEYCOMB) {
      android.text.ClipboardManager clipboard = (android.text.ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
      return clipboard.getText().toString();
    } else {
      ClipboardManager clipboard = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);

      // Gets the clipboard data from the clipboard
      ClipData clip = clipboard.getPrimaryClip();
      if (clip != null) {
        String text = null;

        // Gets the first item from the clipboard data
        ClipData.Item item = clip.getItemAt(0);

        // If the contents of the clipboard wasn't a reference to a note, then this converts whatever it is to text.
        if (text == null) {
          text = CoerceToText(item).toString();
        }

        Log.d(LOG_TAG, "文本已粘贴: " + text);
        if (!suppressToast) {
          Toast.makeText(context, "文本已粘贴", Toast.LENGTH_SHORT).show();
        }
        return text;
      }
    }
    return "";
  }

  private CharSequence CoerceToText(ClipData.Item item) {
    // If this Item has an explicit textual value, simply return that.
    CharSequence text = item.getText();
    if (text != null) {
      return text;
    }

    // If this Item has a URI value, try using that.
    Uri uri = item.getUri();
    if (uri != null) {
      // First see if the URI can be opened as a plain text stream (of any sub-type). If so, this is the best textual representation for it.
      FileInputStream stream = null;
      try {
        // Ask for a stream of the desired type.
        AssetFileDescriptor descr = context.getContentResolver().openTypedAssetFileDescriptor(uri, "text/*", null);
        stream = descr.createInputStream();
        InputStreamReader reader = new InputStreamReader(stream, "UTF-8");

        // Got it... copy the stream into a local string and return it.
        StringBuilder builder = new StringBuilder(128);
        char[] buffer = new char[8192];
        int len;
        while ((len = reader.read(buffer)) > 0) {
          builder.append(buffer, 0, len);
        }
        return builder.toString();
      } catch (FileNotFoundException e) {
        // Unable to open content URI as text... not really an error, just something to ignore.
        Log.d(LOG_TAG, "Unable to open content URI as text, ignoring... " +  e.getMessage(), e);
      } catch (IOException e) {
        // Something bad has happened.
        Log.w(LOG_TAG, "Failure loading text", e);
        return e.toString();
      } finally {
        if (stream != null) {
          try {
            stream.close();
          } catch (IOException e) {
            Log.e(LOG_TAG, e.getMessage(), e);
        }
      }
    }

    // If we couldn't open the URI as a stream, then the URI itself probably serves fairly well as a textual representation.
    Log.d(LOG_TAG, "Couldn't open the URI as a stream, then the URI itself probably serves fairly well as a textual representation");
    return uri.toString();
  }

  // Finally, if all we have is an Intent, then we can just turn that into text. Not the most user-friendly thing, but it's something.
  Intent intent = item.getIntent();
  if (intent != null) {
    Log.d(LOG_TAG, "all we have is an Intent, then we can just turn that into text");
    return intent.toUri(Intent.URI_INTENT_SCHEME);
  }

  // Shouldn't get here, but just in case...
  return "";
  }

}