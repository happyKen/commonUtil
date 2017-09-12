package com.java.generic;

import java.util.Date;
/**
 *泛型方法
* @ClassName: GenericFunction 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月12日 下午3:53:26 
*
 */
public class GenericFunction {
	public static void main(String[] args) {
	  //这时候返回时一个Date对象，无需强转化。可以直接.获得Date相关方法
		Number time = show(new Date(), "gg").getTime();
		System.out.println(time);
	}
	
	//注意在返回值前需要<T,U>来声明这是一个泛型方法
	public static <T,U> T show(T t,U u){
		System.out.println(t);
		System.out.println(u);
		return t;
	}
}
