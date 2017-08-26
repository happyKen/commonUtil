package com.common.myutil.base;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by wuguohui on 2017/3/7.
 */

public abstract class BaseSharePreferences {

    protected  static String fileName = "default";
    protected static int mode = Context.MODE_PRIVATE;


    private static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(fileName, mode);
    }

    private static SharedPreferences.Editor getEditor(Context context) {
        return getSharedPreferences(context).edit();
    }

    public static boolean getBoolean(Context context, String key, boolean defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getBoolean(key, defValue);
    }

    public static int getInt(Context context, String key, int defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getInt(key, defValue);
    }

    public static float getFloat(Context context, String key, float defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getFloat(key, defValue);
    }

    public static long getLong(Context context, String key, long defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getLong(key, defValue);
    }

    public static String getString(Context context, String key, String defValue) {
        SharedPreferences sp = getSharedPreferences(context);
        return sp.getString(key, defValue);
    }

    public static void putBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static void putInt(Context context, String key, int value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putInt(key, value);
        editor.commit();
    }

    public static void putFloat(Context context, String key, float value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putFloat(key, value);
        editor.commit();
    }

    public static void putLong(Context context, String key, long value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putLong(key, value);
        editor.commit();
    }

    public static void putString(Context context, String key, String value) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.putString(key, value);
        editor.commit();
    }

    public static void remove(Context context, String key) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.remove(key);
        editor.commit();
    }

    public static void clear(Context context) {
        SharedPreferences.Editor editor = getEditor(context);
        editor.clear();
        editor.commit();
    }
}
