package com.designPattern.nativeObserve;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @ClassName: Observable
 * @Description: 被观察者:注册，注销，通知。通用定义为泛型。
 * @author wangzekeng
 * @date 2016年12月12日 下午3:05:19
 *
 */
public class Observable<T> {
	private List<Observe<T>> observes = new ArrayList<Observe<T>>();
  
	public void register(Observe<T> observe) {
		if (observe != null) {
			synchronized (this) {
				if (!observes.contains(observe))
					observes.add(observe);
			}
		}
	}
	
	public void unRegister(Observe<T> observe){
		if (observe != null) {
			synchronized (this) {
				if (observes.contains(observe))
					observes.remove(observe);
			}
		}
	}
	
	public void notifyObservers(T data){
		for(Observe<T> observe : observes){
			observe.update(this, data);
		}
	}
}
