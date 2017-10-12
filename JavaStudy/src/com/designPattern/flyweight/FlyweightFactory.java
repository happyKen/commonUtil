package com.designPattern.flyweight;

import java.util.HashMap;
/**
 * 
* @ClassName: FlyweightFactory 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月11日 下午4:42:49 
*
 */
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
