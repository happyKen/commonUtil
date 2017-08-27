package com.common.myutil.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
/**
 * 日期类
 * Created by wangzekeng on 2017/8/27.
 */
public class DateUtils {
    /**
     * @param timeMillis time in milliseconds since January 1, 1970 00:00:00.0 UTC.
     * @return
     */
    public static String getFriendlyTime(long timeMillis) {
        long distanceTimeMillis = System.currentTimeMillis() - timeMillis;
        if (distanceTimeMillis > 24 * 60 * 60 * 1000) {//天
            Date date = new Date(timeMillis);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MM-dd", Locale.getDefault());
            return simpleDateFormat.format(date);
//			return (distanceTimeMillis/(24*60*60*1000)) + "昨天";
        } else if (distanceTimeMillis > 60 * 60 * 1000) {//小时
            return (distanceTimeMillis / (60 * 60 * 1000)) + "小时前";
        } else if (distanceTimeMillis > 60 * 1000) {//分钟
            return (distanceTimeMillis / (60 * 1000)) + "分钟前";
        } else if (distanceTimeMillis > 1000) {//秒前
            return (distanceTimeMillis / 1000) + "秒前";
        } else {
            return "刚刚";
        }
    }

    public static boolean isCloseEnough(long paramLong1, long paramLong2) {
        long l = paramLong1 - paramLong2;
        if (l < 0L) {
            l = -l;
        }
        return l < 300000L;
    }

}
