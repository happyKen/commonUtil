package com.designPattern.flyweight;

import java.util.HashMap;

public class FlyweightFactory {
	private HashMap<String, Flyweight> map = new HashMap<String, Flyweight>();
	
	
	public Flyweight getFlyweight(String name){
		Flyweight flyweight = map.get(name);
		if(flyweight == null){
			flyweight = new ConcreteFlyweight(name);
			map.put(name, flyweight);
		}
		return flyweight;
	}
	
	public int getFlyweightSize(){
		return map.size();
	}

}
