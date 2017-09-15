package com.designPattern.abtractFactory;
/**
 * 抽象工厂模式
 * 
 * 一个工厂可以生产更多系列
 * 
 * 可以结合反射来解除耦合
 * 
* @ClassName: IosGenertor 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月13日 下午5:50:56 
*
 */
public class MainClient {
	public static void main(String[] args) {

		
		//通过反射
		AbtractGenerator generator = new AbtractGenerator();
		try {
			generator.generatePhone(AndroidPhone.class).getOS();
		} catch (Exception e) {
			System.out.println("可以捕获异常");
		}
		
		try {
			generator.generatePad(AndroidPad.class).getOS();
		} catch (Exception e) {
			System.out.println("可以捕获异常");
		}
		
	
	}
}
