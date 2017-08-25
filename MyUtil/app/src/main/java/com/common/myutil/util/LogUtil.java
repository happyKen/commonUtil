package com.common.myutil.util;

import android.text.TextUtils;
import android.util.Log;

/**
 * 日志类
 * Created by wangzekeng on 2017/8/24.
 */

public class LogUtil {
    private static boolean mIsDebug = true;
    private static String TAG = "wc";
    private static boolean isDetail = true;
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
            boolean isLogMethod = stackTraceElement.getClassName().equals(LogUtil.class.getName());
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
}
