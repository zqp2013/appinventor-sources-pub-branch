package cn.fun123.AI2Utils;

import android.content.Context;
import android.util.Log;
import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.*;

import com.google.appinventor.components.runtime.errors.YailRuntimeError;
import android.content.SharedPreferences;
import org.json.JSONException;

@DesignerComponent(version = AI2Utils.VERSION,
    versionName = "1.0",
    description = "不可见组件，提供AppInventor2原生组件之外的常用功能。App Inventor 2 中文网（https://www.fun123.cn）原创。",
    helpUrl = "https://www.fun123.cn/reference/extensions/",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "aiwebres/small-icon.png")

@SimpleObject(external = true)

public class AI2Utils extends AndroidNonvisibleComponent implements Component {
    public static final int VERSION = 1;
    private ComponentContainer container;
    private Context context;
    private SharedPreferences sharedPreferences;
    private static final String LOG_TAG = "AI2Utils";
    private FirstRun firstRun;
    
    public AI2Utils(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context();
        Log.d(LOG_TAG, "FirstRun Created" );
        firstRun=new FirstRun(container);
    }
    
    @SimpleFunction(description = "判断App是否是第一次运行，如果是则返回'真'，否则返回'假'。")
    public boolean IsFirstRun() {
        return firstRun.IsFirstRun();
    }
    @SimpleFunction(description = "重置App的运行状态为第一次运行。")
    public void ResetFirstRun() {
        firstRun.ClearFirstRunFlag();
    }

    
    public class FirstRun{
        final String tag="FirstRun";
        final Object valueToStore="false";

        private SharedPreferences sharedPreferences;
        
        public FirstRun(ComponentContainer container) {
            sharedPreferences = context.getSharedPreferences("FirstRun", Context.MODE_PRIVATE);
        }
        
        public boolean IsFirstRun() {
            if (GetValue(tag,"FirstRun!!!!!")=="FirstRun!!!!!"||GetValue(tag,"FirstRun!!!!!")==valueToStore){
                StoreValue(tag,valueToStore);
                return true;
            }
            return false;
        }
        public void ClearFirstRunFlag() {
            final SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();
            sharedPrefsEditor.clear();
            sharedPrefsEditor.commit();
        }
        
        private void StoreValue(final String tag, final Object valueToStore) {
            final SharedPreferences.Editor sharedPrefsEditor = sharedPreferences.edit();
            try {
                sharedPrefsEditor.putString(tag, JsonUtil.getJsonRepresentation(valueToStore));
                sharedPrefsEditor.commit();
            } catch (JSONException e) {
                throw new YailRuntimeError("Value failed to convert to JSON.", "JSON Creation Error.");
            }
        }
        
        private Object GetValue(final String tag, final Object valueIfTagNotThere) {
            try {
                String value = sharedPreferences.getString(tag, "");
                return (value.length() == 0) ? valueIfTagNotThere : JsonUtil.getObjectFromJson(value);
            } catch (JSONException e) {
                throw new YailRuntimeError("Value failed to convert from JSON.", "JSON Creation Error.");
            }
        }
        
    }
}