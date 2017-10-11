package com.designPattern.facade;
/**
 * 外观模式
 * 
 * 将子模块集合封装，隐藏内部细节
* @ClassName: ModuleFacade 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月11日 上午11:08:50 
*
 */
public class ModuleFacade {
	private ModuleA moduleA = new ModuleA();
	private ModuleB moduleB = new ModuleB();
	private ModuleC moduleC = new ModuleC();
	public void test(){
		moduleA.test();
		moduleB.test();
		moduleC.test();
	}
	
	public static void main(String[] args) {
		ModuleFacade moduleFacade = new ModuleFacade();
		moduleFacade.test();
	}
}
