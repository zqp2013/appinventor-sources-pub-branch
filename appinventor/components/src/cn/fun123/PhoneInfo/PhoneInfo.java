package cn.fun123.PhoneInfo;

//import static android.Manifest.permission.INTERNET;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;

import android.telephony.TelephonyManager;
import android.telephony.CellLocation;     
import android.telephony.PhoneStateListener;

import com.google.appinventor.components.annotations.*;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.runtime.*;

@DesignerComponent(version = 1,
        versionName = "1.0",
        description = "手机基本信息获取拓展，App Inventor 2 中文网(www.fun123.cn)原创。",
        helpUrl = "https://www.fun123.cn/reference/extensions/",
        category = ComponentCategory.EXTENSION,//展示在appinventor的哪个模块下
        nonVisible = true,//不可见
        iconName = "https://www.fun123.cn/reference/extensions/icons/phoneinfo.png")//这个组件的图标

@SimpleObject(external = true)
//@UsesPermissions({INTERNET})
@UsesPermissions(permissionNames = "android.permission.READ_PHONE_STATE")

public class PhoneInfo extends AndroidNonvisibleComponent {
    private ComponentContainer container;
    private Context context;
    private static final String LOG_TAG = "PhoneInfo";

    public PhoneInfo(ComponentContainer container) {
        super(container.$form());
        this.container = container;
        context = (Context) container.$context();
        Log.d(LOG_TAG, "PhoneInfo extension Created" );
    }

    @SimpleFunction(description = "获取设备ID")
    public String GetDeviceID() {
        TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        return tm.getDeviceId();
    }
    
}
