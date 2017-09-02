package com.designPattern.javaObserve;
/**
 * 
* @ClassName: TestObserver 
* java自带观察者模式测试
* @author wangzekeng
* @date 2016年12月7日 下午3:53:02 
*
 */
public class TestObserver {
  public static void main(String [] args){
	  Watched watched = new Watched();
	  Watcher watcher1 = new Watcher(watched);
	  Watcher watcher2 = new Watcher(watched);
	  watched.setData("hhh");
	  watched.setData("bbb");
	  watched.setData("bbb");
  }
}
