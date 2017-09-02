package com.designPattern.singleton;

import java.security.PublicKey;

/**
 * 
* @ClassName: StaticClassSingleTon 
* 常用模式，静态内部类单例模式，利用jvm提供的类加载模式，静态内部类是要在有引用了以后才会装载到内存的
* @author wangzekeng
* @date 2016年12月7日 下午2:56:15 
*
 */
public class StaticClassSingleTon {
	 private StaticClassSingleTon(){}
     private static class StaticClassSingleTonHolder{
    	 private static StaticClassSingleTon instance = new StaticClassSingleTon();
     }
     public static StaticClassSingleTon getInstance(){
    	 return StaticClassSingleTonHolder.instance;
     }
     
}
