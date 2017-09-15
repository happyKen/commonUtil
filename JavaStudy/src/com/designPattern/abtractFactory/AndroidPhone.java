package com.designPattern.abtractFactory;

public class AndroidPhone implements IPhone{
	protected AndroidPhone(){};
	@Override
	public void getOS() {
		// TODO Auto-generated method stub
		System.out.println("i am android phone");
	}

}
