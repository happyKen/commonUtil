package com.designPattern.factory;

public class IosGenertor implements IGenerator{

	@Override
	public IPhone generatePhone() {
		// TODO Auto-generated method stub
		return new IosPhone();
	}

}
