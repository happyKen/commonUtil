package com.common.myutil.inject;

import com.common.myutil.utils.LogUtils;

import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * Created by wangzekeng on 2017/9/18.
 */

public class DynamicHandler implements InvocationHandler{

    private WeakReference<Object> obj;
    private final HashMap<String,Method> methodMap = new HashMap<String,Method>(1);


    public DynamicHandler(Object obj){
        this.obj = new WeakReference<Object>(obj);
    }


    public  void addMethod(String methodName,Method method){
        methodMap.put(methodName,method);
    }

    public Object getHandler(){
        return obj.get();
    }

    public void setHandler(Object obj){
        this.obj = new WeakReference<Object>(obj);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object handler = getHandler();
        LogUtils.e("handler invoke");
        if(handler != null) {
            String methodName = method.getName();
            method = methodMap.get(methodName);
            LogUtils.e("method name:" + method.getName());//clickBtnInvoked,代理调用clickBtnInvoked
            if (method != null) {
                LogUtils.e("handler method");
                return method.invoke(handler, args);//需要传入这个方法的调用者
            }

        }
        return null;
    }
}
