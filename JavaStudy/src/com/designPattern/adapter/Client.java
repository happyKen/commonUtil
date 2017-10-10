package com.designPattern.adapter;

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