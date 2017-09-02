package com.designPattern.strategy;

public class PlaneStrategy implements Strategy{

	@Override
	public void travel() {
		System.out.println(" by plane");
	}

}
