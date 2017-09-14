package com.designPattern.factory;
/**
 * 标准工厂模式
 * 
 * 工厂模式降低使用者和产品之间的耦合
 * 标准工厂模式符合开闭原则，有新的产品，需要增加产品和对应的工厂，无需修改已有代码
 * 标准工厂模式组成：产品抽象类，产品具体类，工厂抽象类，工厂类
 * 
 * 
* @ClassName: IosGenertor 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月13日 下午5:50:56 
*
 */
public class MainClient {
	public static void main(String[] args) {
		IPhone ios,android;
		IGenerator iosGenerator = new IosGenertor();
		ios = iosGenerator.generatePhone();
		ios.getOS();
		IGenerator androidGenerator = new AndroidGenerator();
		android = androidGenerator.generatePhone();
		android.getOS();
	}
}
