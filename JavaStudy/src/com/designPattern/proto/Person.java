package com.designPattern.proto;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: Person 
* @Description: 原型模式，实现clone方法
* @author wangzekeng
* @date 2017年1月7日 下午2:37:57 
*
 */
public class Person implements Cloneable{
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
	//重写clone
    @Override
    public Object clone(){
    	Person person = null;
        try {
			person = (Person) super.clone();
			person.name = this.name;
			person.age = this.age;
			person.weight = this.weight;
			person.height = this.height;
			person.hobbies = this.hobbies;
			
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return person;
    }
}
