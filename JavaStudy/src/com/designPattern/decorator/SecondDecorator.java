package com.designPattern.decorator;


public class SecondDecorator extends Decorator{

	public SecondDecorator(Human human) {
		super(human);
		// TODO Auto-generated constructor stub
	}
	public void findClothes(){
		System.out.println("找到一件t恤");
	}
	
	
	public void findMap(){
		System.out.println("找到一张地图");
	}
	@Override
	public void walkToWhere() {
		// TODO Auto-generated method stub
		super.walkToWhere();
		findMap();
	}
	
	@Override
	public void wearClothes() {
		// TODO Auto-generated method stub
		super.wearClothes();
		findClothes();
	}
		
}
