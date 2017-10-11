package com.designPattern.flyweight;

public class ConcreteFlyweight extends Flyweight{
	private String name;
	
	public ConcreteFlyweight(String name){
		this.name = name;
	}
	@Override
	public void operation() {
		// TODO Auto-generated method stub
		System.out.println("concreteflyweight:" + name);
	}

}
