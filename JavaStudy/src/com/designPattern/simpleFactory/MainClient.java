package com.designPattern.simpleFactory;
/**
 * 简单工厂模式
 * 
 * 简单工厂模式，工厂没有接口或者抽象类，通过flag来生成不同产品
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
		IPhone android = PhoneGenerator.generatePhone(PhoneGenerator.ANDROID);
		android.getOS();
		IPhone ios = PhoneGenerator.generatePhone(PhoneGenerator.IOS);
		ios.getOS();
		
		
		//通过反射
		ReflectPhoneGenerator reflectPhoneGenerator = new ReflectPhoneGenerator();
		try {
			reflectPhoneGenerator.generatePhone(AndroidPhone.class).getOS();
		} catch (Exception e) {
			System.out.println("可以捕获异常");
		}
	}
}
