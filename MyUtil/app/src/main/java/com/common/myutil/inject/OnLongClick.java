package com.common.myutil.inject;

import android.view.View;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by wangzekeng on 2017/9/19.
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
//这里绑定的名字需要同android原来的方法名字参数一致
@EventBase(listenerType = View.OnLongClickListener.class,listenerSetter = "setOnLongClickListener",methodName = "onLongClick")
public @interface OnLongClick {
    int[] value();

}
