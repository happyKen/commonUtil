package com.designPattern.singleton;
/**
 * 
* @ClassName: HungerSingleTon 
* 最基本的单例模式，饿汉模式，适合初始化花费较少的程序，同时适合单线程也适合多线程
* @author wangzekeng
* @date 2016年12月7日 下午2:31:01 
*
 */
public class HungerSingleTon {
   private static HungerSingleTon instance = new HungerSingleTon();//不通过实例调用，通过类中方法获得实例必须静态
   private HungerSingleTon(){}
   public static HungerSingleTon getInstance(){
	   return instance;
   }
}
