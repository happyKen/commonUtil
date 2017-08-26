package com.common.myutil.utils;

import android.content.Context;
import android.view.View;

/**
 * dp转px
 * Created by wangzekeng on 2017/6/23.
 */

public class DensityUtils {

    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     *
     * @param context 上下文
     * @param dpValue 值
     * @return 转换结果
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     *
     * @param context 上下文
     * @param pxValue 值
     * @return 转换结果
     */
    public static int px2dp(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * sp转px
     *
     * @param context 上下文
     * @param spValue 值
     * @return 转换结果
     */
    public static int sp2px(Context context, float spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale + 0.5f);
    }

    /**
     * px转sp
     *
     * @param context 上下文
     * @param pxValue 值
     * @return 转换结果
     */
    public static int px2sp(Context context, float pxValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }


    /**
     * 获取状态栏高度
     *
     * @param context
     * @return
     */
    public static int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }
        return result;
    }

    /**
     * 获取去除状态栏的坐标
     *
     * @param view
     * @param context
     * @return
     */
    public static int[] getPosition(View view, Context context) {
        int[] position = new int[2];
        view.getLocationOnScreen(position);
        position[1] -= getStatusBarHeight(context);
        return position;
    }

    /**
     * 获取去除状态栏的中心坐标
     *
     * @param view
     * @param context
     * @return
     */
    public static int[] getCenterPosition(View view, Context context) {
        int[] position = new int[2];
        view.getLocationOnScreen(position);
        position[0] = position[0] + view.getWidth() / 2;
        position[1] = position[1] - getStatusBarHeight(context) + view.getHeight() / 2;
        return position;
    }

}
