package com.designPattern.proto;

public class TestProto {
public static void main(String[] args) {
	Person person1 = new Person();
	person1.setName("张三");
	person1.setAge(11);
	person1.setHeight(12);
	person1.setWeight(12);
	System.out.println(person1.toString());
	
	Person person2 = (Person) person1.clone();
	person2.setName("李四");
	System.out.println(person2.toString());
}
}
