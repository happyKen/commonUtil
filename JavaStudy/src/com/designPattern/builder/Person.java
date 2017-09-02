package com.designPattern.builder;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: Person 
* builder模式，将一个复杂对象的构建与它的表示分离，使得同样的构建过程可以创建不同的表示。
* @author wangzekeng
* @date 2016年12月9日 下午2:51:59 
*
 */
public class Person {
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", height=" + height
				+ ", weight=" + weight + ", hobbies=" + hobbies + "]";
	}
	private String name;
	private int age;
	private int height;
	private int weight;
	private List<String> hobbies = new ArrayList<String>();
	private Person(Builder builder){
		this.name = builder.name;
		this.age = builder.age;
		this.height = builder.height;
		this.weight = builder.weight;
		this.hobbies = builder.hobbies;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public int getWeight() {
		return weight;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public List<String> getHobbies() {
		return hobbies;
	}
	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	} 
	public static class Builder{
		private String name;
		private int age;
		private int height;
		private int weight;
		private List<String> hobbies = new ArrayList<String>();
		public Builder name(String name){
			this.name = name;
			return this;
		}
		public Builder age(int age){
			this.age = age;
			return this;
		}
		public Builder height(int height){
			this.height = height;
			return this;
		}
		public Builder weight(int weight){
			this.weight = weight;
			return this;
		}
		public Builder hobbies(List<String> hobbies){
			this.hobbies = hobbies;
			return this;
		}
		public Person create(){
			return new Person(this);
		}
	}
}
