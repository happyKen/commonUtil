package com.common.myutil;


import com.common.myutil.utils.LogUtils;

public class ActivityList {
    private String activityName;
    private String title;
    private String content;

    public ActivityList(String activityName) {
        this.activityName = activityName;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Class getActivityClass() {
        try {
            Class activityClass = Class.forName("com.common.myutil.activity." + activityName);
            return activityClass;
        } catch (ClassNotFoundException e) {
            LogUtils.e("找不到类");
            return null;
        }
    }
}
