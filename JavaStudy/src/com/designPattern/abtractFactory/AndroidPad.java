package com.designPattern.abtractFactory;

public class AndroidPad implements IPad{
	protected AndroidPad(){};
	@Override
	public void getOS() {
		// TODO Auto-generated method stub
		System.out.println("i am android pad");
	}

}
