package com.designPattern.adapter;
/**
 * 适配模式
 * 
 * 原本由于接口不兼容而不能一起工作的那些类可以在一起工作
 * 类似插头转换器的功能
* @ClassName: Client 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月10日 下午3:14:15 
*
 */
public class Client {
	public static void main(String[] args) {
		
		//适配器1：继承
		InheritAdapter adapter = new InheritAdapter();
		adapter.request();
		
		
		//适配器2：直接封装
		WrapAdapter wrapAdapter = new WrapAdapter(new Adaptee());
		wrapAdapter.request();
}
}