package com.common.myutil.inject;

import android.app.Activity;
import android.view.View;

import com.common.myutil.utils.LogUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by wangzekeng on 2017/9/18.
 */

public class ViewInjectUtils {
    public static void inject(Activity activity){
        injectEvent(activity);
    }

    private static void injectEvent(Activity activity){
            Method[] methods = activity.getClass().getMethods();
            for(Method method : methods){
                Annotation[] annotations = method.getAnnotations();
                for(Annotation annotation : annotations){
                    //获取注解的注解
                    Class<? extends Annotation> anontationType = annotation.annotationType();
                    EventBase eventBase = anontationType.getAnnotation(EventBase.class);
                    if(eventBase != null){
                        //获取监听器的类型，名字，调用的方法名
                        Class<?> listenerType = eventBase.listenerType();
                        String listenerName = eventBase.listenerSetter();
                        String methodName = eventBase.methodName();
                        LogUtils.e("listenerName:"+ listenerName + "methodName:" +  methodName);

                        try {
                           Method getValue = anontationType.getDeclaredMethod("value");
                            int [] viewIds = (int[]) getValue.invoke(annotation,null);
                            DynamicHandler handler = new DynamicHandler(activity);
                            handler.addMethod(methodName,method);
                            Object listener = Proxy.newProxyInstance(listenerType.getClassLoader(),new Class<?>[]{listenerType},handler);//相当于注解委托给实际的回调方法
                            for(int viewId : viewIds){
                                LogUtils.e("id:" + viewId);
                                View view = activity.findViewById(viewId);
                                Method setEventListener = view.getClass().getMethod(listenerName,listenerType);
                                setEventListener.invoke(view,listener);//监听回调
                            }
                        } catch (NoSuchMethodException e) {
                            e.printStackTrace();
                        } catch (InvocationTargetException e) {
                            e.printStackTrace();
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }

}
