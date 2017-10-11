package com.designPattern.facade;
/**
 * 子模块
* @ClassName: ModuleB 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月11日 上午11:05:45 
*
 */
public class ModuleB {
	//外部使用
		public void test(){
			System.out.println("ModuleB test...");
		}
		
		
		//内部使用
		public void b1(){};
		public void b2(){};
}
