package com.designPattern.decorator;
/**
 * 装饰者
* @ClassName: Decorator 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月10日 下午5:34:40 
*
 */
public abstract class Decorator implements Human{
	private Human human;
	public Decorator(Human human){
		this.human = human;
	}
	
	public void wearClothes(){
		human.wearClothes();
	}
	
	public void walkToWhere(){
		human.walkToWhere();
	}
}
