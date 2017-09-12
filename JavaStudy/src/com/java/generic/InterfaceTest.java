package com.java.generic;

import java.util.Date;
/**
 * 泛型接口
* @ClassName: InterfaceTest 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月12日 下午3:26:15 
*
 */

//需要传入实参类型String,Date，作为限定
public class InterfaceTest implements GenericInterface<String, Date> {

	@Override
	public void show(String t, Date u) {
		// TODO Auto-generated method stub
		System.out.println(t);
		System.out.println(u);
	}

	
	public static void main(String[] args) {
		InterfaceTest test = new InterfaceTest();
		//调用方法时会做类型检测
		test.show("1", new Date());
	}
}
