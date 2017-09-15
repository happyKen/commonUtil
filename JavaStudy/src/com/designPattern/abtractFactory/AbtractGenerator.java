package com.designPattern.abtractFactory;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 结合反射的工厂类
 * 
 * 结合反射无需写switch,新增加产品也无需修改此类，符合开闭原则
 * 同时产品构造函数可以私有化,防止客户通过构造函数构造
 * 
* @ClassName: ReflectPhoneGenerator 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月14日 上午10:34:41 
*
 */
public class AbtractGenerator implements IAbtractGenerator{
	
	private Map<String,IPhone> phoneMap = new HashMap<String, IPhone>();//缓存
	private Map<String, IPad> padMap = new HashMap<String, IPad>();
	@Override
	public <T extends IPhone> T generatePhone(Class<T> cls) throws Exception {
		// TODO Auto-generated method stub
		T phone = null;
		String phoneName = cls.getSimpleName();
		if(phoneMap.containsKey(phoneName)){
			
			phone = (T)phoneMap.get(phoneName);
		}else{
			cls.getDeclaredConstructor().setAccessible(true);  //修改访问权限
			phone = cls.newInstance();
			phoneMap.put(phoneName, phone);
		}
		return phone;
	}
	
	
	@Override
	public <T extends IPad> T generatePad(Class<T> cls) throws Exception {
		// TODO Auto-generated method stub
		T pad = null;
		String phoneName = cls.getSimpleName();
		if(phoneMap.containsKey(phoneName)){
			
			pad = (T)padMap.get(phoneName);
		}else{
			cls.getDeclaredConstructor().setAccessible(true);  //修改访问权限
			pad = cls.newInstance();
			padMap.put(phoneName, pad);
		}
		return pad;
	}

}
