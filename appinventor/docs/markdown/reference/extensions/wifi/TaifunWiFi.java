//-*- mode: java; c-basic-offset: 2; -*-
package com.puravidaapps;
// Version 2: form.registerForDestroy(this) added, MacAddress added
// Version 2a: avoid DX execution failed error: build each extension separately
// Version 3: BSSID
// Version 3a: bugfix "IllegalArgumentException: Receiver not registered: null" while switching screens
// Version 3b: bugfix "IllegalArgumentException: Receiver not registered" while switching screens
// Version 4: correspondingRSSIs, SignalStrength, ConnectionInfo, Is5GHzBandSupported added
// Version 5: correspondingBSSIs added
// Version 5a: fix ConnectSSID method, see also https://groups.google.com/d/msg/mitappinventortest/BvbzgUeHMGs/rw1-V60UBgAJ
// Version 5b: fix ConnectSSID method, see also https://groups.google.com/d/msg/mitappinventortest/BvbzgUeHMGs/ErFcSgnWBQAJ
// Version 6: new MacAddress workaround, new AccessPointIP method
// Version 7: connect without password
// Version 8: Disconnect method added
// Version 9: DNS method added
// Version 10: SDK 26 update: remove dangerous permission android.permission.ACCESS_COARSE_LOCATION, AvailableSSIDs removed
// Version 11: AvailableSSIDs added again. Additionally example project provided about how to use it together with the location sensor
// Version 12: AfterWifiNegotiation event added
// Version 13: RemoveSSID added
// Version 14: LocalIP: returns wifi ip if its enabled else the cellular one
// Version 15: android.permission.ACCESS_NETWORK_STATE added for App Inventor nb188 release

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.DhcpInfo;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkInfo;
import android.net.RouteInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.http.conn.util.InetAddressUtils;

import com.google.appinventor.components.annotations.DesignerComponent;
import com.google.appinventor.components.annotations.DesignerProperty;
import com.google.appinventor.components.annotations.PropertyCategory;
import com.google.appinventor.components.annotations.SimpleEvent;
import com.google.appinventor.components.annotations.SimpleFunction;
import com.google.appinventor.components.annotations.SimpleObject;
import com.google.appinventor.components.annotations.SimpleProperty;
import com.google.appinventor.components.annotations.UsesPermissions;
import com.google.appinventor.components.common.ComponentCategory;
import com.google.appinventor.components.common.PropertyTypeConstants;
import com.google.appinventor.components.runtime.*;
import com.google.appinventor.components.runtime.util.AsynchUtil;



@SuppressWarnings("deprecation")
@DesignerComponent(version = TaifunWiFi.VERSION,
    description = "WiFi Manager Extension. Version 15 as of 2021-11-12.",
    category = ComponentCategory.EXTENSION,
    nonVisible = true,
    iconName = "https://puravidaapps.com/images/taifun16.png",
    helpUrl = "https://puravidaapps.com/wifi.php")
@SimpleObject(external = true)
@UsesPermissions(permissionNames = "android.permission.ACCESS_WIFI_STATE, android.permission.CHANGE_WIFI_STATE, android.permission.ACCESS_NETWORK_STATE")

public class TaifunWiFi extends AndroidNonvisibleComponent implements Component, OnDestroyListener {

  public static final int VERSION = 14;
  private ComponentContainer container;
  private Context context;
  private final Activity activity;
  private static final String LOG_TAG = "TaifunWiFi";
  private boolean suppressSuccessMessage;
  private boolean suppressWarnings;
  private static WifiManager wm;
  private boolean isRepl = false;
  private WiFiReceiverScan wiFiReceiverScan; 


  public TaifunWiFi(ComponentContainer container) {
    super(container.$form());
    if (form instanceof ReplForm) { // Note: form is defined in our superclass
      isRepl = true;
    }
    this.container = container;
    context = (Context) container.$context();
    activity = (Activity) container.$context();
    wm = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
   Log.d(LOG_TAG, "TaifunWiFi Created" );
  }

  /**
   * Returns whether Success Message should be suppressed
   */
  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "whether Success Message should be suppressed. Used in Enable and Disable method.")
  public boolean SuppressSuccessMessage() {
    return suppressSuccessMessage;
  }


  /**
   * Specifies whether Success Message should be suppressed
   */
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "false")
  @SimpleProperty
  public void SuppressSuccessMessage(boolean suppressSuccessMessage) {
    this.suppressSuccessMessage = suppressSuccessMessage;
  }


  
  /**
   * Returns whether Warnings should be suppressed
   */
  @SimpleProperty(category = PropertyCategory.BEHAVIOR,
      description = "whether Warnings should be suppressed")
  public boolean SuppressWarnings() {
    return suppressWarnings;
  }


  /**
   * Specifies whether Warnings should be suppressed
   */
  @DesignerProperty(editorType = PropertyTypeConstants.PROPERTY_TYPE_BOOLEAN,
      defaultValue = "false")
  @SimpleProperty
  public void SuppressWarnings(boolean suppressWarnings) {
    this.suppressWarnings = suppressWarnings;
  }
  
  
  @SimpleFunction(description = "Return the local IP Address. Returns wifi ip if its enabled else the cellular one.")
  public String LocalIP() {
    if(wm.isWifiEnabled()) {
      // http://stackoverflow.com/a/18436895/1545993
      final WifiInfo wi = wm.getConnectionInfo();
      int ipAddress = wi.getIpAddress();
      String ip = String.format("%d.%d.%d.%d", (ipAddress & 0xff),(ipAddress >> 8 & 0xff),(ipAddress >> 16 & 0xff),(ipAddress >> 24 & 0xff));
      return ip;
    }

    // 2019-10-21
    // https://stackoverflow.com/a/30183130
    try {
      for (Enumeration<NetworkInterface> en = NetworkInterface.getNetworkInterfaces(); en.hasMoreElements(); ) {
        NetworkInterface intf = en.nextElement();
        for (Enumeration<InetAddress> enumIpAddr = intf.getInetAddresses(); enumIpAddr.hasMoreElements();) {
          InetAddress inetAddress = enumIpAddr.nextElement();
          Log.i(LOG_TAG, "inetAddress.getHostAddress(): "+ inetAddress.getHostAddress());
          //the condition after && is missing in your snippet, checking instance of inetAddress
          if (!inetAddress.isLoopbackAddress() && inetAddress instanceof Inet4Address) {
            Log.i(LOG_TAG, "return inetAddress.getHostAddress(): "+ inetAddress.getHostAddress());
            return inetAddress.getHostAddress();
          }
        }
      }
    } catch (Exception e) {
      return "";
    }     
    return "";
  }

  
  /**
   * http://www.programcreek.com/java-api-examples/android.net.wifi.WifiManager 
   */
  @SimpleFunction(description = "Get current WiFi state: true or false.")
  public boolean IsEnabled(){
    final WifiInfo wi = wm.getConnectionInfo();
    try {
      if (!wm.isWifiEnabled() || wi.getSSID() == null) {
        return false;
      } else {
        return true;
      }
    } catch (Exception e) {
      return false;
    } 
  }


  /**
   * http://www.programcreek.com/java-api-examples/android.net.wifi.WifiManager 
   */
  @SimpleFunction(description = "Enable WiFi. You can hide the success message after setting the suppressSuccessMessage property to false.")
  public void Enable(){
    if (isRepl){
      Log.w(LOG_TAG, "You have to build the app to be able to use this method!");
      if (!suppressWarnings) {
        Toast.makeText(context, "You have to build the app to be able to use this method!", Toast.LENGTH_SHORT).show();
      }  
    } else {  
      wm.setWifiEnabled(true);
      if (!suppressSuccessMessage) {
        Toast.makeText(context, "WiFi enabled.", Toast.LENGTH_SHORT).show();
      }
    }  
  }

  
  /**
   * http://www.programcreek.com/java-api-examples/android.net.wifi.WifiManager 
   */
  @SimpleFunction(description = "Disable WiFi. You can hide the success message after setting the suppressSuccessMessage property to false.")
  public void Disable(){
    if (isRepl){
      Log.w(LOG_TAG, "You have to build the app to be able to use this method!");
      if (!suppressWarnings) {
        Toast.makeText(context, "You have to build the app to be able to use this method!", Toast.LENGTH_SHORT).show();
      }  
    } else {  
      wm.setWifiEnabled(false);
      if (!suppressSuccessMessage) {
        Toast.makeText(context,"WiFi disabled.",Toast.LENGTH_LONG).show();
      }
    }  
  }


  /*
   * http://stackoverflow.com/a/11075300
   */
  @SimpleFunction(description = "Get current WiFi SSID (Service Set Identifier).")
  public String SSID(){
    String ssid = "";
    ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    @SuppressWarnings("deprecation")
	NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    if (networkInfo.isConnected()) {
      final WifiInfo wi = wm.getConnectionInfo();
      if (wi != null && !TextUtils.isEmpty(wi.getSSID())) {
        ssid = wi.getSSID().replace("\"", ""); // replace double quotes in SSID
      }
    }
    
    if (!wm.isWifiEnabled()) {
      if (!suppressWarnings) {
        Toast.makeText(context, "WiFi is disabled, can't get current SSID.", Toast.LENGTH_SHORT).show();
      }  
    }
    
    Log.d(LOG_TAG, "SSID: " + ssid);
		return ssid;
  }


  /**
   * http://stackoverflow.com/a/20504821/1545993
   */
  @SimpleFunction(description = "Connect to a SSID (Service Set Identifier).")
  public void ConnectSSID(final String ssid, final String password){
    Log.d(LOG_TAG, "ConnectSSID");
    if (TextUtils.isEmpty(ssid)) {
      Log.d(LOG_TAG, "ssid is empty");
      if (!suppressWarnings) {
        Toast.makeText(context, "Can't connect to an empty SSID", Toast.LENGTH_SHORT).show();
      }  
    } else if (!wm.isWifiEnabled()) {
      if (!suppressWarnings) {
        Toast.makeText(context, "WiFi is disabled, can't connect to " + ssid, Toast.LENGTH_SHORT).show();
      }
    } else if (isRepl){
      if (!suppressWarnings) {
        Toast.makeText(context, "You have to build the app to be able to use this method!", Toast.LENGTH_SHORT).show();
      }  
    } else {
      AsynchUtil.runAsynchronously(new Runnable() {
        @Override
        public void run() {
        	AsyncConnectSSID(ssid, password);
        }
      });
    }
  }


  private void AsyncConnectSSID(String ssid, String password) {       
    Log.d(LOG_TAG, "AsyncConnectSSID");
  	WifiConfiguration wc = new WifiConfiguration();
    wc.SSID = String.format("\"%s\"", ssid);
    // 2018-04-11: connect without password
    if (password.isEmpty()) {
        // https://stackoverflow.com/a/37991589
      Log.v(LOG_TAG, "open network");
      wc.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.NONE);
      wc.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
      wc.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
      wc.allowedAuthAlgorithms.clear();
      wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
      wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
    } else {
      Log.v(LOG_TAG, "WPA");
      // 2018-04-13
      wc.allowedProtocols.set(WifiConfiguration.Protocol.RSN);
      wc.allowedProtocols.set(WifiConfiguration.Protocol.WPA);
      wc.allowedKeyManagement.set(WifiConfiguration.KeyMgmt.WPA_PSK);
      wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.CCMP);
      wc.allowedPairwiseCiphers.set(WifiConfiguration.PairwiseCipher.TKIP);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP40);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.WEP104);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.CCMP);
      wc.allowedGroupCiphers.set(WifiConfiguration.GroupCipher.TKIP);
      wc.preSharedKey = String.format("\"%s\"", password);
    }
  
    
    // 2017-12-06
    //wm.disconnect(); //  in case you are already connected to another network
    // if you use boolean disableOthers true, then you don't have to disconnect or connect, it will do both for you
    //wm.enableNetwork(netId, true);
    //wm.reconnect();
    List<WifiConfiguration> list = wm.getConfiguredNetworks();
    boolean found = false;
    int netId = 0; // 2019-04-26
    for( WifiConfiguration i : list ) {
      if(i.SSID != null && i.SSID.equals("\"" + ssid + "\"")) {
        found = true;
        wm.disconnect();
        netId = i.networkId;
        Log.d(LOG_TAG, "ssid: " + ssid + " found in configured SSIDs, netId: " + netId);
        wm.enableNetwork(netId, true);
        wm.reconnect();               
        break;
      }           
    }
    if (!found) {
      //remember id
      netId = wm.addNetwork(wc);
      Log.d(LOG_TAG, "remember ssid: " + ssid + " in configured SSIDs, netId: " + netId);

      // 2017-12-14: if not found then connect the first time
      wm.disconnect(); //  in case you are already connected to another network
      wm.enableNetwork(netId, true);
      wm.reconnect();               
    }
    
    // 2019-04-26
    if (netId == -1) {
      activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            AfterWifiNegotiation(false);
          }
      });
    } else {
      final boolean successful = checkWifiNegotiation(netId);
      activity.runOnUiThread(new Runnable() {
          @Override
          public void run() {
            AfterWifiNegotiation(successful);
          }
      });
    }
  }

  
  /**
   * http://stackoverflow.com/a/20772151/1545993
   * http://www.programcreek.com/java-api-examples/android.net.wifi.WifiManager example 6
   */
  @SimpleFunction(description = "Get a list of configured SSIDs (Service Set Identifiers). WiFi must be enabled for this.")
  public Object ConfiguredSSIDs(){
    Log.d(LOG_TAG, "ConfiguredSSIDs");
    try {
      List<WifiConfiguration> networks = wm.getConfiguredNetworks();
      List<String> ssids = new ArrayList<String>();
    
      if (networks != null){
        for (WifiConfiguration result : networks) {
          ssids.add(result.SSID.replace("\"", ""));  // replace double quotes in SSID
        }
      }
      return ssids;
    } catch (Exception e){
      if (!suppressWarnings) {
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
      }  
      e.printStackTrace();
      Log.e(LOG_TAG, e.getMessage(), e);
      return null;
    }
  }

   
  
  /* ****************************************************************************************************************** */

  
  /*
   * Get MAC address 
   * min API Level 9 / Android 2.3
   * 
   * https://stackoverflow.com/a/10831640
   * https://stackoverflow.com/a/13007325
   * Note: wi.getMacAddress() does not work for Android M, see also http://stackoverflow.com/a/33165854
   */
  @SimpleFunction(description = "Get MAC address")
  public String MacAddress() {
    Log.d(LOG_TAG, "MacAddress");
    String macAddress = "02:00:00:00:00:00";
    WifiInfo wi = wm.getConnectionInfo();
    macAddress = wi.getMacAddress(); 

    if (macAddress.equals("02:00:00:00:00:00")) {
      Log.d(LOG_TAG, "MacAddress workaround");
      String interfaceName = "wlan0";
      try {
        List<NetworkInterface> interfaces = Collections.list(NetworkInterface.getNetworkInterfaces());
        for (NetworkInterface intf : interfaces) {
          if (interfaceName != null) {
            if (!intf.getName().equalsIgnoreCase(interfaceName)) continue;
          }
          byte[] mac = intf.getHardwareAddress();
          if (mac==null) return "02:00:00:00:00:00";
          StringBuilder buf = new StringBuilder();
          for (int idx=0; idx<mac.length; idx++)
            buf.append(String.format("%02X:", mac[idx]));       
          if (buf.length()>0) buf.deleteCharAt(buf.length()-1);
          return buf.toString();
        }
      } catch (Exception e) { 
        Log.e(LOG_TAG, e.getMessage(), e);
        if (!suppressWarnings){
          Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();  
        }
      }
      return "02:00:00:00:00:00";
    } else {
      return macAddress;  
    }  
  }

  

  
  /* ****************************************************************************************************************** */

  /* VERSION 3

  /* ****************************************************************************************************************** */

  /*
   * http://stackoverflow.com/a/6064347
   */
  @SimpleFunction(description = "Get current WiFi BSSID (the MAC address of the access point).")
  public String BSSID(){
    String bssid = "";
    ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    @SuppressWarnings("deprecation")
	NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);
    if (networkInfo.isConnected()) {
      final WifiInfo wi = wm.getConnectionInfo();
      if (wi != null && !TextUtils.isEmpty(wi.getBSSID())) {
        bssid = wi.getBSSID(); 
      }
    }
    
    if (!wm.isWifiEnabled()) {
      if (!suppressWarnings) {
        Toast.makeText(context, "WiFi is disabled, can't get current BSSID.", Toast.LENGTH_SHORT).show();
      }  
    }
    
    Log.d(LOG_TAG, "SSID: " + bssid);
    return bssid;
  }

  /* ****************************************************************************************************************** */

  /* VERSION 4

  /* ****************************************************************************************************************** */
 
  // https://stackoverflow.com/a/12029597
  @SimpleFunction(description = "Get signal strength (RSSI) in a range between 0 and 100.")
  public int SignalStrength(){
    Log.d(LOG_TAG, "SignalStrength");
    int MIN_RSSI        = -100;
    int MAX_RSSI        = -55;  
    int levels          = 101;
    WifiManager wifi    = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);            
    WifiInfo info       = wifi.getConnectionInfo(); 
    int rssi            = info.getRssi();

    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.ICE_CREAM_SANDWICH){
      return WifiManager.calculateSignalLevel(info.getRssi(), levels);
    } else {             
      // this is the code since 4.0.1
      if (rssi <= MIN_RSSI) {
        return 0;
      } else if (rssi >= MAX_RSSI) {
        return levels - 1;
      } else {
        float inputRange = (MAX_RSSI - MIN_RSSI);
        float outputRange = (levels - 1);
        return (int)((float)(rssi - MIN_RSSI) * outputRange / inputRange);
      }
    }
  }
  
  
  @SimpleFunction(description = "Get current connection info.")
  public String ConnectionInfo(){
    Log.d(LOG_TAG, "ConnectionInfo");
    ConnectivityManager connManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    @SuppressWarnings("deprecation")
	NetworkInfo networkInfo = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

    if (!wm.isWifiEnabled()) {
      if (!suppressWarnings) {
        Toast.makeText(context, "WiFi is disabled, can't get current connection info.", Toast.LENGTH_SHORT).show();
      }  
    }
    
    String connectionInfo = "";
    if (networkInfo.isConnected()) {
      final WifiInfo wi = wm.getConnectionInfo();
      if (wi != null){
        connectionInfo = wi.toString();
      } 
    }  
    return connectionInfo;
  }

  
  @SimpleFunction(description = "Check, if 5 GHz Band is supported.")
  public boolean Is5GHzBandSupported(){
    Log.d(LOG_TAG, "Is5GHzBandSupported");

    if (!wm.isWifiEnabled()) {
      if (!suppressWarnings) {
        Toast.makeText(context, "WiFi is disabled, can't get check if 5 Ghz band is supported.", Toast.LENGTH_SHORT).show();
      }  
      return false;
    } else {
      return wm.is5GHzBandSupported();
    }
  }
  

  /* ****************************************************************************************************************** */

  /* VERSION 6

  /* ****************************************************************************************************************** */
  // https://stackoverflow.com/a/31308600
  @SimpleFunction(description = "Return the IP Address of access point.")
  public String AccessPointIP() {
    DhcpInfo dhcpInfo = wm.getDhcpInfo();
    byte[] ipAddress = convert2Bytes(dhcpInfo.serverAddress);
    try {
      String apIpAddr = InetAddress.getByAddress(ipAddress).getHostAddress();
      return apIpAddr;
    } catch (UnknownHostException e) {
      if (!suppressWarnings){
        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();  
      }
    }
    return "";
}

  
  private static byte[] convert2Bytes(int hostAddress) {
    byte[] addressBytes = { (byte)(0xff & hostAddress),
            (byte)(0xff & (hostAddress >> 8)),
            (byte)(0xff & (hostAddress >> 16)),
            (byte)(0xff & (hostAddress >> 24)) };
    return addressBytes;
  }

  /* ****************************************************************************************************************** */

  /* VERSION 8

  /* ****************************************************************************************************************** */
 
  // https://stackoverflow.com/a/38628311
  @SimpleFunction(description = "Disconnect.")
  public void Disconnect() {
    wm.disconnect();
  }

  /* ****************************************************************************************************************** */

  /* VERSION 9

  /* ****************************************************************************************************************** */

  @SimpleFunction(description = "Return a list of DNS servers (primary and secondary) of the current network.")
  public Object DnsServers() {
    Log.d(LOG_TAG, "DnsServers");

  	DnsServersDetector d = new DnsServersDetector();
  	String [] dnsArray = d.getServers();
    List<String> dnsList = new ArrayList<String>();
    for (String dns : dnsArray) {
      dnsList.add(dns.toString());
    }
    return dnsList;
  }


  
  /**
   * DNS servers detector
   *
   * IMPORTANT: don't cache the result.
   *
   * Or if you want to cache the result make sure you invalidate the cache
   * on any network change.
   *
   * It is always better to use a new instance of the detector when you need
   * current DNS servers otherwise you may get into troubles because of invalid/changed
   * DNS servers.
   *
   * This class combines various methods and solutions from:
   * Dnsjava http://www.xbill.org/dnsjava/
   * Minidns https://github.com/MiniDNS/minidns
   *
   * Unfortunately both libraries are not aware of Orero changes so new method was added to fix this.
   *
   * Created by Madalin Grigore-Enescu on 2/24/18.
   */
  
  //https://stackoverflow.com/a/48973823
  public class DnsServersDetector {

      private static final String TAG = "DnsServersDetector";

      /**
       * Holds some default DNS servers used in case all DNS servers detection methods fail.
       * Can be set to null if you want caller to fail in this situation.
       */
      private final String[] FACTORY_DNS_SERVERS = {
          "0.0.0.0",
          "0.0.0.0"
      };


      /**
       * Properties delimiter used in exec method of DNS servers detection
       */
      private static final String METHOD_EXEC_PROP_DELIM = "]: [";

			//private final String CONNECTIVITY_SERVICE = null;


      //region - public //////////////////////////////////////////////////////////////////////////////
      ////////////////////////////////////////////////////////////////////////////////////////////////

      /**
       * Constructor
       */
      public DnsServersDetector() {
      }

      /**
       * Returns android DNS servers used for current connected network
       * @return Dns servers array
       */
      public String [] getServers() {

        // Will hold the consecutive result
        String[] result;

        // METHOD 1: old deprecated system properties
        result = getServersMethodSystemProperties();
        Log.d(LOG_TAG, "DNS, method1");
        if (result != null && result.length > 0) {
          Log.d(LOG_TAG, "result: " + result.toString());
          return result;
        }

        // METHOD 2 - use connectivity manager
        result = getServersMethodConnectivityManager();
        Log.d(LOG_TAG, "DNS, method2");
        if (result != null && result.length > 0) {
          Log.d(LOG_TAG, "result: " + result.toString());
          return result;
        }

        // LAST METHOD: detect android DNS servers by executing getprop string command in a separate process
        // This method fortunately works in Oreo too but many people may want to avoid exec
        // so it's used only as a failsafe scenario
        result = getServersMethodExec();
        Log.d(LOG_TAG, "DNS, method3");
        if (result != null && result.length > 0) {
          Log.d(LOG_TAG, "result: " + result.toString());
          return result;
        }

        // Fall back on factory DNS servers
        Log.d(LOG_TAG, "DNS, return default, " + FACTORY_DNS_SERVERS.toString());
        return FACTORY_DNS_SERVERS;
      }

      //endregion

      //region - private /////////////////////////////////////////////////////////////////////////////
      ////////////////////////////////////////////////////////////////////////////////////////////////

      /**
       * Detect android DNS servers by using connectivity manager
       *
       * This method is working in android LOLLIPOP or later
       *
       * @return Dns servers array
       */
      private String [] getServersMethodConnectivityManager() {

          // This code only works on LOLLIPOP and higher
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

              try {

                  ArrayList<String> priorityServersArrayList  = new ArrayList<>();
                  ArrayList<String> serversArrayList          = new ArrayList<>();

                  ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);   
                  if (connectivityManager != null) {

                      // Iterate all networks
                      // Notice that android LOLLIPOP or higher allow iterating multiple connected networks of SAME type
                      for (Network network : connectivityManager.getAllNetworks()) {

                          NetworkInfo networkInfo = connectivityManager.getNetworkInfo(network);
                          if (networkInfo.isConnected()) {

                              LinkProperties linkProperties    = connectivityManager.getLinkProperties(network);
                              List<InetAddress> dnsServersList = linkProperties.getDnsServers();

                              // Prioritize the DNS servers for link which have a default route
                              if (linkPropertiesHasDefaultRoute(linkProperties)) {

                                  for (InetAddress element: dnsServersList) {

                                      String dnsHost = element.getHostAddress();
                                      priorityServersArrayList.add(dnsHost);

                                  }

                              } else {

                                  for (InetAddress element: dnsServersList) {

                                      String dnsHost = element.getHostAddress();
                                      serversArrayList.add(dnsHost);

                                  }

                              }

                          }

                      }

                  }

                  // Append secondary arrays only if priority is empty
                  if (priorityServersArrayList.isEmpty()) {

                      priorityServersArrayList.addAll(serversArrayList);

                  }

                  // Stop here if we have at least one DNS server
                  if (priorityServersArrayList.size() > 0) {

                      return priorityServersArrayList.toArray(new String[0]);

                  }

              } catch (Exception ex) {

                  Log.d(TAG, "Exception detecting DNS servers using ConnectivityManager method", ex);

              }

          }

          // Failure
          return null;

      }

      /**
       * Detect android DNS servers by using old deprecated system properties
       *
       * This method is NOT working anymore in Android 8.0
       * Official Android documentation state this in the article Android 8.0 Behavior Changes.
       * The system properties net.dns1, net.dns2, net.dns3, and net.dns4 are no longer available,
       * a change that improves privacy on the platform.
       *
       * https://developer.android.com/about/versions/oreo/android-8.0-changes.html#o-pri
       * @return Dns servers array
       */
      private String [] getServersMethodSystemProperties() {


          if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {

              // This originally looked for all lines containing .dns; but
              // http://code.google.com/p/android/issues/detail?id=2207#c73
              // indicates that net.dns* should always be the active nameservers, so
              // we use those.
              final String re1 = "^\\d+(\\.\\d+){3}$";
              final String re2 = "^[0-9a-f]+(:[0-9a-f]*)+:[0-9a-f]+$";
              ArrayList<String> serversArrayList = new ArrayList<>();
              try {

                @SuppressWarnings("rawtypes")
				Class SystemProperties = Class.forName("android.os.SystemProperties");
                @SuppressWarnings("unchecked")
				Method method = SystemProperties.getMethod("get", new Class[]{String.class});
                  final String[] netdns = new String[]{"net.dns1", "net.dns2", "net.dns3", "net.dns4"};
                  for (int i = 0; i < netdns.length; i++) {

                      Object[] args = new Object[]{netdns[i]};
                      String v = (String) method.invoke(null, args);
                      if (v != null && (v.matches(re1) || v.matches(re2)) && !serversArrayList.contains(v)) {
                          serversArrayList.add(v);
                      }

                  }

                  // Stop here if we have at least one DNS server
                  if (serversArrayList.size() > 0) {

                      return serversArrayList.toArray(new String[0]);

                  }

              } catch (Exception ex) {

                  Log.d(TAG, "Exception detecting DNS servers using SystemProperties method", ex);

              }

          }

          // Failed
          return null;

      }

      /**
       * Detect android DNS servers by executing getprop string command in a separate process
       *
       * Notice there is an android bug when Runtime.exec() hangs without providing a Process object.
       * This problem is fixed in Jelly Bean (Android 4.1) but not in ICS (4.0.4) and probably it will never be fixed in ICS.
       * https://stackoverflow.com/questions/8688382/runtime-exec-bug-hangs-without-providing-a-process-object/11362081
       *
       * @return Dns servers array
       */
      private String [] getServersMethodExec() {

          // We are on the safe side and avoid any bug
          if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {

              try {

                  Process process = Runtime.getRuntime().exec("getprop");
                  InputStream inputStream = process.getInputStream();
                  LineNumberReader lineNumberReader = new LineNumberReader(new InputStreamReader(inputStream));
                  Set<String> serversSet = methodExecParseProps(lineNumberReader);
                  if (serversSet != null && serversSet.size() > 0) {

                      return serversSet.toArray(new String[0]);

                  }

              } catch (Exception ex) {

                  Log.d(TAG, "Exception in getServersMethodExec", ex);

              }

          }

          // Failed
          return null;

      }

      /**
       * Parse properties produced by executing getprop command
       * @param lineNumberReader
       * @return Set of parsed properties
       * @throws Exception
       */
      private Set<String> methodExecParseProps(BufferedReader lineNumberReader) throws Exception {

          String line;
          Set<String> serversSet = new HashSet<String>(10);

          while ((line = lineNumberReader.readLine()) != null) {
              int split = line.indexOf(METHOD_EXEC_PROP_DELIM);
              if (split == -1) {
                  continue;
              }
              String property = line.substring(1, split);

              int valueStart  = split + METHOD_EXEC_PROP_DELIM.length();
              int valueEnd    = line.length() - 1;
              if (valueEnd < valueStart) {

                  // This can happen if a newline sneaks in as the first character of the property value. For example
                  // "[propName]: [\n...]".
                  Log.d(TAG, "Malformed property detected: \"" + line + '"');
                  continue;

              }

              String value = line.substring(valueStart, valueEnd);

              if (value.isEmpty()) {

                  continue;

              }

              if (property.endsWith(".dns") || property.endsWith(".dns1") ||
                      property.endsWith(".dns2") || property.endsWith(".dns3") ||
                      property.endsWith(".dns4")) {

                  // normalize the address
                  InetAddress ip = InetAddress.getByName(value);
                  if (ip == null) continue;
                  value = ip.getHostAddress();

                  if (value == null) continue;
                  if (value.length() == 0) continue;

                  serversSet.add(value);

              }

          }

          return serversSet;

      }

      /**
       * Returns true if the specified link properties have any default route
       * @param linkProperties
       * @return true if the specified link properties have default route or false otherwise
       */
      @TargetApi(Build.VERSION_CODES.LOLLIPOP)
      private boolean linkPropertiesHasDefaultRoute(LinkProperties linkProperties) {

          for (RouteInfo route : linkProperties.getRoutes()) {
              if (route.isDefaultRoute()) {
                  return true;
              }
          }
          return false;

      }

      //endregion

  }
 
  
  /* ****************************************************************************************************************** */

  /* VERSION 11

  /* ****************************************************************************************************************** */

  
  /**
   * Get a list of available SSIDs
   * http://stackoverflow.com/a/11898482/1545993
   * http://stackoverflow.com/a/7527380/1545993
   */
  @SimpleFunction(description = "Get a list of available SSIDs (Service Set Identifiers). WiFi must be enabled for this.")
  public void AvailableSSIDs(){
    Log.d(LOG_TAG, "AvailableSSIDs called" );
    if (wm.isWifiEnabled()) {
      if (isRepl){
        Log.w(LOG_TAG, "You have to build the app to be able to use this method!");
        if (!suppressWarnings) {
          Toast.makeText(context, "You have to build the app to be able to use this method!", Toast.LENGTH_SHORT).show();
        }
      } else {
        wiFiReceiverScan = new WiFiReceiverScan();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION);
        context.registerReceiver(wiFiReceiverScan, intentFilter);
        wm.startScan();
      }
    } else {
      if (!suppressWarnings) {
        Toast.makeText(context, "WiFi is disabled, can't get list of available SSIDs.", Toast.LENGTH_SHORT).show();
      }
      Log.d(LOG_TAG, "WiFi is disabled, exit." );
    }
  }

  
  /**
   * Event indicating that Available SSIDs have been scanned.
   */
  @SimpleEvent(description = "indicating that Available SSIDs (Service Set Identifiers) have been scanned.")
  public void GotAvailableSSIDs(Object availableSSIDs, String bestSSID, Object correspondingRSSIs, Object correspondingBSSIs) {
    Log.d(LOG_TAG, "GotAvailableSSIDs" );
    // invoke the application's "GotAvailableSSIDs" event handler.
    EventDispatcher.dispatchEvent(this, "GotAvailableSSIDs", availableSSIDs, bestSSID, correspondingRSSIs, correspondingBSSIs);
    unregisterReceiverScan();
  }


  private class WiFiReceiverScan extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
      Log.d(LOG_TAG, "onReceive, API version: " + Build.VERSION.SDK_INT);
      // probably check for M? http://stackoverflow.com/q/32151603/1545993
      List<ScanResult> scanresult = wm.getScanResults();
      List<String> ssids = new ArrayList<String>();
      List<String> rssis = new ArrayList<String>();
      List<String> bssis = new ArrayList<String>();
      
      ScanResult bestResult = null;
      String bestResultSSID = "";
      Log.d(LOG_TAG, "intent: " + intent + ", size: " + scanresult.size() + ", enabled: " + wm.isWifiEnabled() );
      
      for (ScanResult result : scanresult) {
        String ssid = result.SSID.replace("\"", "");  // replace double quotes in SSID 
        Log.d(LOG_TAG, ssid);
        ssids.add(ssid);  
        
        rssis.add(String.valueOf(result.level));  
        bssis.add(String.valueOf(result.BSSID));  
               
        // http://stackoverflow.com/a/11898482/1545993
        if(bestResult == null || WifiManager.compareSignalLevel(bestResult.level, result.level) < 0){
          bestResult = result;
          bestResultSSID = bestResult.SSID.replace("\"", "");
        }
      }
      GotAvailableSSIDs(ssids, bestResultSSID, rssis, bssis);
    }  
  }


  /**
   * Unregister
   */
  private void unregisterReceiverScan(){
    if (wiFiReceiverScan != null) {  // 2017-02-25
      Log.d(LOG_TAG, "unregisterReceiver");
      context.unregisterReceiver(wiFiReceiverScan);
      wiFiReceiverScan = null;       // 2017-05-10
    }
  }


  
  @Override
  public void onDestroy() {
    Log.d(LOG_TAG, "onDestroy");
    unregisterReceiverScan();
  }

  
  /* ****************************************************************************************************************** */

  /* VERSION 12

  /* ****************************************************************************************************************** */
  // https://stackoverflow.com/a/51872400
  private static boolean checkWifiNegotiation(int netId) {
    Log.d(LOG_TAG, "checkWifiNegotiation, netId: " + netId);
    boolean startedHandshake = false;
    boolean successful = false;

    for (int i = 0; i < 30; i++) {
      Log.d(LOG_TAG, "checkWifiNegotiation, i: " + i);
      try {
        Thread.sleep(300);
      } catch (InterruptedException e) {
        e.printStackTrace();
        Log.e(LOG_TAG, e.getMessage());
      }

      SupplicantState currentState = wm.getConnectionInfo().getSupplicantState();
      if (!startedHandshake && currentState.equals(SupplicantState.FOUR_WAY_HANDSHAKE)) {
        startedHandshake = true;
      } else if (startedHandshake) {
        if (currentState.equals(SupplicantState.DISCONNECTED)) {
          break;
        } else if (currentState.equals(SupplicantState.COMPLETED)) {
          successful = true;
          break;
        }
      }
      wm.enableNetwork(netId, true);
    }

	// no matter what happened above, if COMPLETED then we have the correct pw
	if (!successful && wm.getConnectionInfo().getSupplicantState().equals(SupplicantState.COMPLETED)) {
	  successful = true;
	}
    return successful;
  }

  /**
   * Indicates that the media has reached the end
   */
  @SimpleEvent(description = "Check if the negotiation with the WifiConfiguration was successful, Returns true or false.")
  public void AfterWifiNegotiation(boolean successful) {
    Log.d(LOG_TAG, "AfterWifiNegotiation" );
    EventDispatcher.dispatchEvent(this, "AfterWifiNegotiation", successful);
  }

  /* ****************************************************************************************************************** */

  /* VERSION 13

  /* ****************************************************************************************************************** */

  @SuppressWarnings("deprecation")
  /**
   * https://stackoverflow.com/a/16053255
   */
  @SimpleFunction(description = "Remove a SSID from the network list. "
  		+ "Note: starting from Android M, apps are not allowed to remove networks that they did not create.")
  public boolean RemoveSSID(final String ssid){
    Log.d(LOG_TAG, "RemoveSSID");
    boolean found = false;
    if (isRepl){
      if (!suppressWarnings) {
        Toast.makeText(context, "You have to build the app to be able to use this method!", Toast.LENGTH_SHORT).show();
      }  
    } else {
      List<WifiConfiguration> list = wm.getConfiguredNetworks();
      int netId = 0; // 
      for( WifiConfiguration i : list ) {
        if(i.SSID != null && i.SSID.equals("\"" + ssid + "\"")) {
          found = true;
          wm.disconnect();
          netId = i.networkId;
          Log.d(LOG_TAG, "ssid: " + ssid + " found in configured SSIDs, netId: " + netId);
          wm.removeNetwork(netId);
          wm.saveConfiguration();
          break;
        }  
      }           
    }
    return found;
  }  

}



