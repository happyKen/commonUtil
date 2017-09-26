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
 *
 * Created by wangzekeng on 2017/9/20.
 */

public class EventBus {
    private static volatile EventBus instance ;
    private Handler mHandler;
    private EventBus() {
        mHandler = new Handler(Looper.getMainLooper());
    }


    //双重判断，单例
    public static EventBus getInstance() {
        if(instance == null){
            synchronized (EventBus.class){
                if(instance == null){
                    instance = new EventBus();
                }
            }
        }
        return instance;
    }

    /**
     * map储存着所有event和对应的方法封装类SubscribeMethod
     * 一个event可能对应着多个方法
     *
     *
     */
    private static Map<Class, CopyOnWriteArrayList<SubscribeMethod>> mSubscribeMethodMap = new HashMap<Class, CopyOnWriteArrayList<SubscribeMethod>>();


    /**
     *
     * 遍历注册对象所有方法
     * 将有event的方法封装存入map
     *
     * @param subscriber 注册对象
     */
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
                        if (mSubscribeMethodMap.containsKey(event)) {
                            subscribeMethods = mSubscribeMethodMap.get(event);
                        } else {
                            subscribeMethods = new CopyOnWriteArrayList<SubscribeMethod>();
                            mSubscribeMethodMap.put(event, subscribeMethods);
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

    /**
     * 使用ThreadLocal让多个线程互不干扰
     * 使用队列是为了缓存单个线程同时有多个event访问，做了个队列缓存
     * @param eventTypeInstance
     */
    public void post(Object eventTypeInstance){
        PostingThread postingThread = mPostingThread.get();
        postingThread.isMainThread = Looper.getMainLooper() == Looper.myLooper();
        postingThread.mEventQueue.add(eventTypeInstance);
        if(postingThread.isPosting){
            return;
        }
        postingThread.isPosting = true;
        while(!postingThread.mEventQueue.isEmpty()){
            Object event = postingThread.mEventQueue.remove(0);
            postEvent(event, postingThread);
        }
        postingThread.isPosting = false;
    }




    /**
     * event对应方法的执行
     * 遍历map找出需要执行的方法，根据不同线程状态执行方法
     * @param eventTypeInstance
     * @param postingThread
     */
    public void postEvent(final Object eventTypeInstance, PostingThread postingThread){
            Class<?> eventClass = eventTypeInstance.getClass();
            CopyOnWriteArrayList<SubscribeMethod> subscribeMethods = mSubscribeMethodMap.get(eventClass);
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
                        mSubscribeMethodMap.remove(paramterTypes[0]);
                    }
                }
            }
        }
    }



}

/**
 * 线程状态
 */
enum ThreadMode {
    UI, Async
}


/**
 * event方法封装
 *
 */
class SubscribeMethod {
    ThreadMode threadMode;//线程状态
    Method method;//方法
    Object subscriber;//方法调用实例

    public SubscribeMethod(ThreadMode threadMode, Method method, Object obj) {
        this.threadMode = threadMode;
        this.method = method;
        this.subscriber = obj;
    }

}

/**
 * 线程封装类
 * 封装了线程的状态，和event队列
 */
class PostingThread{
    List<Object> mEventQueue = new ArrayList<Object>();
    boolean isMainThread;
    boolean isPosting;
}