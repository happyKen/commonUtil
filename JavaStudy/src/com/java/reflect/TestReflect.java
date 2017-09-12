package com.java.reflect;

import java.lang.reflect.Field;

public class TestReflect {
	public static void main(String[] args) {
		try {
			Class cls = Class.forName("com.java.reflect.UserManagerImpl");
			//getSimpleName() : 获取类名 UserManager
			System.out.println(cls.getSimpleName());
			
			//getName() : 获取完整类名 com.java.reflect.UserManager
			System.out.println(cls.getName());
			
			//ls.getInterfaces() : 获取该类实现的接口com.java.reflect.UserManager,可能有多个implements
			Class[] ifs = cls.getInterfaces();
			for(Class i : ifs){
				System.out.println(i.getName());
			}
			
			
			//getFields：获取public的成员变量
			Field[] fds = cls.getFields();
			for(Field fd : fds){
				Class type = fd.getType();
				String strType = type.getName();
				String strName = fd.getName();
				System.out.println("field name:" + strName + "  field type:" + strType);
			}
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
