package com.designPattern.singleton;
/**
 * 
* @ClassName: LazySingleTon 
* 基本单例模式，懒汉模式，适合单线程，在初始化耗费多资源时也适用
* @author wangzekeng
* @date 2016年12月7日 下午2:38:20 
*
 */
public class LazySingleTon {
   private static LazySingleTon instance = null;
   private LazySingleTon(){}
   public static LazySingleTon getInstance(){
	   if(instance == null){
		   instance = new LazySingleTon();
	   }
	   return instance;
   }
}
