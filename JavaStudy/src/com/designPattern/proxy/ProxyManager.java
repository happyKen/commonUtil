package com.designPattern.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyManager implements InvocationHandler{
	private Object targetObject;//目标对象
	
	public  Object newProxyInstance(Object target){
		targetObject = target;
		//newProxyInstance会返回一个Object，实际上是target的接口类型
		return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		Object ret = null;
		try{

		System.out.println("start->");
		ret = method.invoke(targetObject, args);
		System.out.println("success->");
		}catch(Exception e){
			System.out.println("fail");
			throw e;
		}
		return ret;
	}

}
