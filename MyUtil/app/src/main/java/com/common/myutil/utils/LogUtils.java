package com.common.myutil.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

/**
 * 日志类
 * Created by wangzekeng on 2017/8/24.
 */

public class LogUtils {
    private static boolean mIsDebug = true;
    private static String TAG = "wc";
    private static boolean isDetail = true;
    private static boolean isToast = true;
    private static Toast mToast = null;
    private static void init(boolean isDebug , String tag){
        mIsDebug = isDebug;
        TAG = tag;
    }

    public static void i(String msg){
        i(null,msg);
    }

    public static void e(String msg){
        e(null,msg);
    }

    public static void d(String msg){
        d(null,msg);
    }

    public static void e(String tag,String msg){
        if(!mIsDebug)
            return;
        if(isDetail){
            msg = getDetailInfo() + msg;
        }
        Log.e(getFinalTag(tag),msg);
    }

    public static void i(String tag,String msg){
        if(!mIsDebug)
            return;
        if(isDetail){
            msg = getDetailInfo() + msg;
        }
        Log.i(getFinalTag(tag),msg);
    }

    public static void d(String tag,String msg){
        if(!mIsDebug)
            return;
        if(isDetail){
            msg = getDetailInfo() + msg;
        }
        Log.d(getFinalTag(tag),msg);
    }

    private static StackTraceElement getTargetStackTraceElement() {
        // 获取调用类
        StackTraceElement targetStackTrace = null;
        boolean shouldTrace = false;
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        for (StackTraceElement stackTraceElement : stackTrace) {
            boolean isLogMethod = stackTraceElement.getClassName().equals(LogUtils.class.getName());
            if (shouldTrace && !isLogMethod) {
                targetStackTrace = stackTraceElement;
                break;
            }
            shouldTrace = isLogMethod;
        }
        return targetStackTrace;
    }

    private static String getFinalTag(String tag){
        if(TextUtils.isEmpty(tag)){
            return TAG;
        }else{
            return tag;
        }
    }

    private static String getDetailInfo(){
        StackTraceElement targetStackTraceElement = getTargetStackTraceElement();
        // 详细调用格式 ：(MainActivity.java:31) :
        String info = "(" + targetStackTraceElement.getFileName() + ":" + targetStackTraceElement.getLineNumber() + ") :";
        return info;
    }

    /**
     * 覆盖方式显示Toast
     *
     * @param context
     * @param msg
     */
    public static void toastCover(Context context, Object msg) {
        if (!isToast)
            return;

        if (mToast == null) {
            synchronized (LogUtils.class) {
                if (mToast == null) {
                    mToast = Toast.makeText(context.getApplicationContext(), msg.toString(), Toast.LENGTH_SHORT);
                }
            }
        } else {
            mToast.setDuration(Toast.LENGTH_SHORT);
            mToast.setText(msg.toString());
        }

        mToast.show();
    }

    /**
     * 覆盖方式显示Toast
     *
     * @param context
     * @param msg
     * @param duration
     */
    public static void toastCover(Context context, Object msg, int duration) {
        if (!isToast)
            return;

        if (mToast == null) {
            synchronized (LogUtils.class) {
                if (mToast == null) {
                    mToast = Toast.makeText(context.getApplicationContext(), msg.toString(), duration);
                }
            }
        } else {
            mToast.setDuration(duration);
            mToast.setText(msg.toString());
        }

        mToast.show();
    }

    public static void toast(Context context, Object msg) {
        if (isToast) {
            Toast.makeText(context.getApplicationContext(), msg.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public static void toast(Context context, Object msg, int duration) {
        if (isToast) {
            Toast.makeText(context.getApplicationContext(), msg.toString(), duration).show();
        }
    }
}
