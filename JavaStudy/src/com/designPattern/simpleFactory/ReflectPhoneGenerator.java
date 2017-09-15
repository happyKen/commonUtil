package com.designPattern.simpleFactory;

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
public class ReflectPhoneGenerator implements IReflectGenerator{
	
	private Map<String,IPhone> phoneMap = new HashMap<String, IPhone>();//缓存
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

}
