package com.designPattern.adapter;
/**
 * 适配器
 * 直接封装一个原系统类作为成员变量
* @ClassName: WrapAdapter 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月10日 上午11:49:30 
*
 */
public class WrapAdapter implements Target{
	private Adaptee adaptee;
	
	public WrapAdapter(Adaptee adaptee) {
		this.adaptee = adaptee;
	}
	@Override
	public void request() {
		// TODO Auto-generated method stub
		adaptee.specialRequest();
	}
	
}
