package com.common.myutil.eventbus;

import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * 自定义eventbus例子
 * <p>
 * Created by wangzekeng on 2017/9/20.
 */

public class EventBus {
    private static EventBus instance = new EventBus();
    private Handler mHandler;
    private EventBus() {
        mHandler = new Handler(Looper.getMainLooper());
    }

    public static EventBus getInstance() {
        return instance;
    }


    private static Map<Class, CopyOnWriteArrayList<SubscribeMethod>> mSubscribeMethodByEventTypes = new HashMap<Class, CopyOnWriteArrayList<SubscribeMethod>>();

    public void register(Object subscriber) {
        CopyOnWriteArrayList<SubscribeMethod> subscribeMethods = null;
        Class subscriberClass = subscriber.getClass();
        Method[] methods = subscriberClass.getDeclaredMethods();
        for (Method method : methods) {
            if (method.getName().startsWith("onEvent")) {

                //初始化
                String threadMode = method.getName().substring("onEvent".length());
                SubscribeMethod subscribeMethod = null;
                ThreadMode mode = ThreadMode.UI;


                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    Class<?> event = parameterTypes[0];
                    synchronized (this) {
                        if (mSubscribeMethodByEventTypes.containsKey(event)) {
                            subscribeMethods = mSubscribeMethodByEventTypes.get(event);
                        } else {
                            subscribeMethods = new CopyOnWriteArrayList<SubscribeMethod>();
                            mSubscribeMethodByEventTypes.put(event, subscribeMethods);
                        }

                        if (threadMode.equals("Async")) {
                            mode = ThreadMode.Async;
                        }

                        subscribeMethod = new SubscribeMethod(mode, method, subscriber);
                        subscribeMethods.add(subscribeMethod);
                    }

                }
            }
        }

    }



    private static ThreadLocal<PostingThread> mPostingThread = new ThreadLocal<PostingThread>(){
        @Override
        public PostingThread get() {
            return new PostingThread();
        }
    };


    public void post(Object eventTypeInstance){
        PostingThread postingThread = mPostingThread.get();
        postingThread.isMainThread = Looper.getMainLooper() == Looper.myLooper();
        postingThread.mEventQueue.add(eventTypeInstance);
        if(postingThread.isPosting){
            return;
        }
        postingThread.isPosting = true;
        while(!postingThread.mEventQueue.isEmpty()){
            Object eventType = postingThread.mEventQueue.remove(0);
            postEvent(eventType, postingThread);
        }
        postingThread.isPosting = false;
    }


    public void postEvent(final Object eventTypeInstance, PostingThread postingThread){
            Class<?> eventClass = eventTypeInstance.getClass();
            CopyOnWriteArrayList<SubscribeMethod> subscribeMethods = mSubscribeMethodByEventTypes.get(eventClass);
            for(final SubscribeMethod subscribeMethod : subscribeMethods){
                if(subscribeMethod.threadMode == ThreadMode.UI){
                    if(postingThread.isMainThread){
                        invokeMethod(eventTypeInstance,subscribeMethod);
                    }else{
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                invokeMethod(eventTypeInstance,subscribeMethod);
                            }
                        });

                    }
                }else if(subscribeMethod.threadMode == ThreadMode.Async){
                    new AsyncTask<Void,Void,Void>() {
                        @Override
                        protected Void doInBackground(Void... params) {
                            invokeMethod(eventTypeInstance,subscribeMethod);
                            return null;
                        }

                    };


                }
            }
    }




    //调用方法
    private void invokeMethod(Object eventType,SubscribeMethod subscribeMethod){
        try {
            subscribeMethod.method.invoke(subscribeMethod.subscriber,eventType);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }


    public void unregister(Object subscriber){
        Class clazz = subscriber.getClass();
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            if(method.getName().startsWith("onEvent")){
                Class<?>[] paramterTypes = method.getParameterTypes();
                if(paramterTypes.length == 1){
                    synchronized (this) {
                        mSubscribeMethodByEventTypes.remove(paramterTypes[0]);
                    }
                }
            }
        }
    }



}


enum ThreadMode {
    UI, Async
}

class SubscribeMethod {
    ThreadMode threadMode;
    Method method;
    Object subscriber;

    public SubscribeMethod(ThreadMode threadMode, Method method, Object obj) {
        this.threadMode = threadMode;
        this.method = method;
        this.subscriber = obj;
    }

}
class PostingThread{
    List<Object> mEventQueue = new ArrayList<Object>();
    boolean isMainThread;
    boolean isPosting;
}