package com.designPattern.factory;

public class AndroidGenerator implements IGenerator{

	@Override
	public IPhone generatePhone() {
		// TODO Auto-generated method stub
		return new AndroidPhone();
	}

}
