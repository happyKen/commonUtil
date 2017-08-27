package com.common.myutil.utils;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

/**
 * Created by wangzekeng on 2017/8/27.
 */

public class DeviceUtils {
    /**
     * 获取手机Mac地址<br/>
     * 错误返回12个0
     * @param context
     * @return
     */
    public static String getMac(Context context) {
        String macAddress = "000000000000";
        try {
            WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            WifiInfo info = wifiManager == null ? null : wifiManager.getConnectionInfo();
            if (info != null && !TextUtils.isEmpty(info.getMacAddress())) {
                macAddress = info.getMacAddress().replace(":", "");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return macAddress;
    }

    /**
     * 获取手机序列号（唯一标识）
     * 需要read_phone_state权限
     * @param context
     * @return
     */
    public static String getImei(Context context) {
        String imei = "";
        try {
            imei = ((TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE)).getDeviceId();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imei;
    }

    /**
     * 获取手机厂商
     *
     * @return  手机厂商
     */
    public static String getDeviceBrand() {
        return android.os.Build.BRAND;
    }

    /**
     * 获取当前手机系统版本号
     *
     */
    public static String getSystemVersion() {
        return android.os.Build.VERSION.RELEASE;
    }

    /**
     * 获取手机型号
     *
     * @return  手机型号
     */
    public static String getSystemModel() {
        return android.os.Build.MODEL;
    }
}
