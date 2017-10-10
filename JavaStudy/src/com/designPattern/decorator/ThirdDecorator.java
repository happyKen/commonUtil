package com.designPattern.decorator;

public class ThirdDecorator extends Decorator{

	public ThirdDecorator(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	
	public void wearThirt(){
		System.out.println("穿上t恤");
	}
	
	public void goPark(){
		System.out.println("去公园");
	}
	
	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		goPark();
	}
	
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		wearThirt();
	}

}
