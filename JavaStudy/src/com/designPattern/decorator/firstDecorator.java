package com.designPattern.decorator;

public class firstDecorator extends Decorator{

	public firstDecorator(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	
	public void goHome(){
		System.out.println("回家。。。");
	}
	
	public void lookCloset(){
		System.out.println("去衣柜看看。。。");
	}
	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		goHome();
	}
	
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		lookCloset();
	}
	

}
