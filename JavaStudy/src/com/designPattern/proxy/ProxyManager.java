package com.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyManager implements InvocationHandler{
	private Object targetObject;//目标对象
	public  <T> T newProxyInstance(Class<T> target){
		try {
			this.targetObject = target.newInstance();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//绑定
		/*
		 * 调用java自带的动态代理类Proxy，newProxyInstance代理对象
		 * 参数1：目标对象的类加载器
		 * 参数2：对标对象的接口列表
		 * 参数3：invovationhandler，this调用本身
		 */
		
		return (T)Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),targetObject.getClass().getInterfaces(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret = null;
		try{

		System.out.println("start->");
		for(Object i : args){
			System.out.println(i);
		}
		method.invoke(targetObject, args);
		System.out.println("success->");
		}catch(Exception e){
			System.out.println("fail");
			throw e;
		}
		return ret;
	}

}
