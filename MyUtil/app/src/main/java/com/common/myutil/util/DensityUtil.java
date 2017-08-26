package com.common.myutil.util;

import android.content.Context;
import android.view.View;

/**
 * dp转px
 * Created by wangzekeng on 2017/6/23.
 */

public class DensityUtil {
    public static int dp2px(Context context, float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
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
