package com.java.reflect;

import java.io.Serializable;

/**
 * 代理的委托类，也就是具体的实现类
* @ClassName: UserManagerImpl 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月11日 上午11:09:21 
*
 */


public class UserManagerImpl implements UserManager{
	private int age;
	public String name;
	protected double money;
	@Override
	public void addUser(int uid, String name) {
		// TODO Auto-generated method stub
		System.out.println("UserManagerImpl addUser()");
	}

	@Override
	public void delUser(int uid) {
		// TODO Auto-generated method stub
		System.out.println("UserManagerImpl delUser()");
	}

	@Override
	public void modifyUser(int uid, String name) {
		// TODO Auto-generated method stub
		System.out.println("UserManagerImpl modifyUser()");
	}

}
