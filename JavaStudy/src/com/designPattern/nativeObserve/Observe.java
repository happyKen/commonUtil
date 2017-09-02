package com.designPattern.nativeObserve;
/**
 * 
* @ClassName: Observe 
* 观察者，也是泛型 
* @author wangzekeng
* @date 2016年12月12日 下午3:35:13 
* 
* @param <T>
 */
public interface Observe<T> {
	void update(Observable<T> observable,T data);
}
