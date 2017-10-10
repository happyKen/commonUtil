package com.designPattern.adapter;


/**
 * 适配器
 * 继承原系统类，再进行封装
* @ClassName: Adapter 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月10日 上午11:31:15 
*
 */
public class InheritAdapter extends Adaptee implements Target{

	@Override
	public void request() {
		// TODO Auto-generated method stub
		super.specialRequest();
	}

}
