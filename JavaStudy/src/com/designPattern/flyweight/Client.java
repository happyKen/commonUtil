package com.designPattern.flyweight;
/**
 * 享元模式
 * 把对象存储起来，避免相同对象重复创建
* @ClassName: Client 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月11日 下午4:41:40 
*
 */
public class Client {
	public static void main(String[] args) {
		FlyweightFactory factory = new FlyweightFactory();
		Flyweight technology = factory.getFlyweight("tech");
		Flyweight designer = factory.getFlyweight("design");
		Flyweight manager = factory.getFlyweight("manager");
		Flyweight designer2 = factory.getFlyweight("design");
		Flyweight designer3 = factory.getFlyweight("design");
		Flyweight designer4 = factory.getFlyweight("design");
		technology.operation();
		designer.operation();
		manager.operation();
		designer2.operation();
		designer3.operation();
		designer4.operation();
		System.out.println(factory.getFlyweightSize());
	}
}
