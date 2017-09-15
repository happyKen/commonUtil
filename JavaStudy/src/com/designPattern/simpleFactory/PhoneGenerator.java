package com.designPattern.simpleFactory;
/**
 * 简单工厂，也叫静态工厂
* @ClassName: PhoneGenerator 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月14日 上午10:14:29 
*
 */
public class PhoneGenerator {
	public static final int ANDROID = 1;
	public static final int IOS = 2;
	public static final int BARRY = 3;
	public static IPhone generatePhone(int flag){
		IPhone phone = null;
		switch (flag) {
		case ANDROID:
			phone =  new IosPhone();
			break;
		case IOS:
			phone =  new AndroidPhone();
			break;
		default:
			break;
		}
		return phone;
	}
}
