package com.common.myutil.utils;

import java.text.DecimalFormat;

/**
 * 数字类
 * Created by wangzekeng on 2017/6/21.
 */

public class NumberUitls {

    /**
     * 转化成以万为单位
     *
     * @param num
     * @return
     */
    public static String formatWan(long num) {
        String s = num + "";
        if (num > 10000) {
            DecimalFormat df = new DecimalFormat("###.00");
            float f = num / 10000.0f;
            s = df.format(f) + "万";
        }
        return s;
    }
}
