package com.designPattern.facade;
/**
 * 子模块
* @ClassName: ModuleA 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月11日 上午11:04:12 
*
 */
public class ModuleA {
	
	//外部使用
	public void test(){
		System.out.println("ModuleA test...");
	}
	
	
	//内部使用
	public void a1(){};
	public void a2(){};
}
