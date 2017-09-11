package com.designPattern.proxy;

public class Client {
	public static void main(String[] args) {
		UserManager userManager = new UserManagerProxy(new UserManagerImpl());
		userManager.addUser(1, "wangze");
	}
}
