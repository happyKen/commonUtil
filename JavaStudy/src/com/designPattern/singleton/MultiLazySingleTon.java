package com.designPattern.singleton;
/**
 * 
* @ClassName: MultiLazySingleTon 
* 双重校验锁单例模式，使得懒汉模式适合多线程
* @author wangzekeng
* @date 2016年12月7日 下午2:44:59 
*
 */
public class MultiLazySingleTon {
   private static volatile MultiLazySingleTon instance = null;//在执行instance=new Singleton()；时，并不是原子语句.volatile禁止指令优化重排
   private MultiLazySingleTon(){}
   public static MultiLazySingleTon getInstance(){
	   if( instance == null){    //确保了只有第一次调用单例的时候才会做同步
		 synchronized (MultiLazySingleTon.class) {//防止多线程下创建多个实例
			if(instance == null){
				instance = new MultiLazySingleTon();
			}
		}
	   }
	   return instance;
   }
}
