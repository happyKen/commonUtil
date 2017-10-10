package com.designPattern.decorator;

public class Client {
	public static void main(String[] args) {
		Human person = new Person();
		Decorator decorator = new ThirdDecorator(new SecondDecorator(new firstDecorator(person)));
		decorator.wearClothes();
		decorator.walkToWhere();
	}
}
