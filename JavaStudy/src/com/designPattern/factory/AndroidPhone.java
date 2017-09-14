package com.designPattern.factory;

public class AndroidPhone implements IPhone{
	protected AndroidPhone(){};
	@Override
	public void getOS() {
		// TODO Auto-generated method stub
		System.out.println("i am android");
	}

}
