package com.designPattern.simpleFactory;

public class IosPhone implements IPhone{
	protected IosPhone(){};
	@Override
	public void getOS() {
		// TODO Auto-generated method stub
		System.out.println("i am ios");
	}

}
