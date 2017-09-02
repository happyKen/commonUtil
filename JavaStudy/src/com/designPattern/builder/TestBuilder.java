package com.designPattern.builder;


public class TestBuilder {
	public static void main(String[] args) {
		Person.Builder builder = new Person.Builder();
		Person person = builder.name("张三").age(11).height(14).weight(12).create();
		person.setAge(1111);
		System.out.println(person.toString());
	}
}
