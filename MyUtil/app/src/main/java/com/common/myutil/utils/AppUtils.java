package com.common.myutil.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * app相关类
 * Created by wangzekeng on 2017/8/27.
 */

public class AppUtils {
    /**
     * 安装apk
     *
     * @param context 上下文
     * @param path    文件路劲
     */
    public static void installAPK(Context context, String path) {
        Intent intent = new Intent();
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.setAction(Intent.ACTION_VIEW);
        //intent.setDataAndType(Uri.fromFile(new File(path)), "application/vnd.android.package-archive");
        Uri fileUri;
        if(Build.VERSION.SDK_INT >= 24) {  //android 7.0 以后使用方法

            fileUri = FileProvider.getUriForFile(context, context.getPackageName() + ".provider", new File(path));
        } else {
            fileUri = Uri.fromFile(new File(path)); // Android 7.0 以前使用原来的方法来获取文件的 Uri
        }
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setDataAndType(fileUri, "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 获取版本号
     * 也可使用 BuildConfig.VERSION_NAME 替换
     *
     * @param context 上下文
     * @return 版本号
     */
    public static String getVersionName(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        String versionName = "";
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            versionName = packageInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return versionName;
    }

    /**
     * 获取版本code
     * 也可使用 BuildConfig.VERSION_CODE 替换
     *
     * @param context 上下文
     * @return 版本code
     */
    public static int getVersionCode(Context context) {
        PackageManager packageManager = context.getPackageManager();
        String packageName = context.getPackageName();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 0);
            return packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return 1;
    }

    /**
     * 重启应用
     *
     * @param context
     */
    public static void restartPackage(Context context) {
        ActivityManager manager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
        manager.restartPackage(context.getPackageName());
    }

    /**
     * 判断某个APP是否安装,true为安装
     * @param context
     * @param packageName
     * @return
     */
    public static boolean isAppInstalled(Context context, String packageName){
        PackageManager pm = context.getPackageManager();
        boolean installed =false;
        try{
            pm.getPackageInfo(packageName,PackageManager.GET_ACTIVITIES);
            installed =true;
        }catch(PackageManager.NameNotFoundException e){
            installed =false;
        }
        return installed;
    }

    /**
     * 获取某个APP的版本号，如果App没安装，则返回"0.0.0"
     * @param context
     * @param packageName
     * @return
     */
    public static String getAppVersion(Context context, String packageName){
        String version = "0.0.0" ;
        PackageManager pm = context.getPackageManager();
        try{
            PackageInfo packageInfo = pm.getPackageInfo(packageName,PackageManager.GET_ACTIVITIES);
            version = packageInfo.versionName ;
        }catch(PackageManager.NameNotFoundException e){

        }
        return version;
    }

    /**
     * 比较版本号大小
     * // 返回值 > 0 ， 表示 v1 > v2
     * @param v1
     * @param v2
     * @return
     */
    public static int cmpVersion(String v1, String v2) {
        // 返回值 > 0 表示 v1 > v2
        final int V1_EQUAL_V2 = 0;
        final int V1_BIGGER_THAN_V2 = 1;
        final int V1_LESS_THAN_V2 = -1;

        if(v1 == null && v2 == null) {
            return V1_EQUAL_V2;
        }
        if(v1 != null && v2 == null) {
            return V1_BIGGER_THAN_V2;
        }
        if(v1 == null && v2 != null) {
            return V1_LESS_THAN_V2;
        }

        String[] vv1 = v1.split("\\.");
        String[] vv2 = v2.split("\\.");
        int len1 = vv1.length;
        int len2 = vv2.length;

        int minLen = len1 < len2 ? len1 : len2;
        int cmp = V1_EQUAL_V2;
        for(int i = 0; i < minLen; i++) {
            try {
                cmp = Integer.valueOf(vv1[i]) - Integer.valueOf(vv2[i]);
            } catch (NumberFormatException e) {
                e.printStackTrace();
                // 3.a.2 vs 3.4.5
                cmp = vv1[i].compareTo(vv2[i]);
            }
            if(cmp != 0) {
                break;
            }
        }
        if(vv1.length != vv2.length && cmp == V1_EQUAL_V2) {
            // 3.4.3 vs 3.4.3.1
            cmp = vv1.length < vv2.length ? V1_LESS_THAN_V2 : V1_BIGGER_THAN_V2;
        }
        return cmp;
    }

    /**
     * 拷贝assets中的文件到指定路径
     * @param context
     * @param fileName  文件名，包含后缀
     * @param path 路径
     * @return
     */
    public static boolean copyApkFromAssets(Context context, String fileName, String path) {
        boolean copyIsFinish = false;
        try {
            InputStream is = context.getAssets().open(fileName);
            File file = new File(path);
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            byte[] temp = new byte[1024];
            int i = 0;
            while ((i = is.read(temp)) > 0) {
                fos.write(temp, 0, i);
            }
            fos.close();
            is.close();
            copyIsFinish = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return copyIsFinish;
    }

    /**
     * 安装apk
     * @param context
     * @param mUri apk路径，如："/mnt/SDCard/test.apk"
     */
    public static void install(Context context, String mUri){
        // 通过Intent安装APK文件
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setDataAndType(Uri.parse("file://" + mUri), "application/vnd.android.package-archive");
        context.startActivity(i);
    }
}
