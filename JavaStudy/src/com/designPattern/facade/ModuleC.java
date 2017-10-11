package com.designPattern.facade;
/**
 * 子模块
* @ClassName: ModuleC 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月11日 上午11:06:16 
*
 */
public class ModuleC {
			//外部使用
			public void test(){
				System.out.println("ModuleC test...");
			}
			
			
			//内部使用
			public void c1(){};
			public void c2(){};
}
