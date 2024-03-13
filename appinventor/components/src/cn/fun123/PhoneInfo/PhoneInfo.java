package cn.fun123.PhoneInfo;

//import static android.Manifest.permission.INTERNET;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;

import android.os.Build;
import java.util.*;
import java.net.*;

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
@UsesPermissions(permissionNames = "android.permission.READ_PHONE_STATE, android.permission.READ_PHONE_NUMBERS, android.permission.INTERNET")

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

    @SimpleFunction(description = "获取本机手机号码。无SIM卡设备将返回空文本；双SIM卡设备将返回主卡号码。")
    public String GetPhoneNumber() {
        try {
            TelephonyManager tm = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
            String phoneNumber = tm.getLine1Number();
            return (phoneNumber == null) ? "" : phoneNumber;
        } catch (SecurityException e) {
            e.printStackTrace();
            Toast.makeText(context, "无法获取本机手机号码！", Toast.LENGTH_SHORT).show();
        }
        return "";
    }

    @SimpleFunction(description = "获取本机手机型号")
    public String GetPhoneModel() {
        return Build.MODEL;
    }

    @SimpleFunction(description = "获取SDK版本")
    public String GetSDKVersion() {
        return Build.VERSION.SDK;
    }

    @SimpleFunction(description = "获取系统版本")
    public String GetReleaseVersion() {
        return Build.VERSION.RELEASE;
    }

    @SimpleFunction(description = "获取网卡MAC地址信息")
    public String GetMacAddress() {
        try {
            List<NetworkInterface> infos = Collections.list(NetworkInterface.getNetworkInterfaces());
    
            for (NetworkInterface info: infos) {
                if (!info.getName().equalsIgnoreCase("wlan0")) {
                    continue;
                }
                byte[] macBytes = info.getHardwareAddress();
                List<String> macByteList = new ArrayList<>();
                for (Byte byt: macBytes) {
                    macByteList.add(String.format("%02X", byt));
                }
                return String.join(":", macByteList);
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "获取网卡MAC地址信息失败！", Toast.LENGTH_SHORT).show();
        }
        return "00:00:00:00:00:00";
    }
}
