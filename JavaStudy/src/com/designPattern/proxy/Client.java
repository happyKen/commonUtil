package com.designPattern.proxy;
/**
 * 模拟客户端
* @ClassName: Client 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月11日 上午11:29:54 
*
 */
public class Client {
	public static void main(String[] args) {
		//静态代理
//		UserManager userManager = new UserManagerProxy(new UserManagerImpl());
//		userManager.addUser(1, "wangze");
		
		
		//动态代理
		new ProxyManager().newProxyInstance(UserManagerImpl.class).addUser(1, "wangze");
	//	userManager.addUser(1, "wangze");
	}
}
