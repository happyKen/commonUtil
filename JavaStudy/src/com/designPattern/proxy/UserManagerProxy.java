package com.designPattern.proxy;

/**
 * 优点
 * 静态代理类 解除接口和实现类的耦合 增加预处理，日记，实现后续处理的操作
 * 
 * 缺点
 * 代理类需要实现所有接口方法，代码冗余
 * 静态代理，一个接口就要实现一个代理类，多个接口的时候需要写很多代理类
 * 
 * @ClassName: UserManagerProxy
 * @Description: TODO
 * @author wangzekeng
 * @date 2017年9月11日 上午11:16:51
 *
 */
public class UserManagerProxy implements UserManager {
	UserManager userManager;

	public UserManagerProxy(UserManager userManager) {

		this.userManager = userManager;

	}

	@Override
	public void addUser(int uid, String name) {
		// 添加日志功能
		try {
			System.out.println("start -> addUser()");//调用添加用户功能
			userManager.addUser(uid, name);
			System.out.println("success -> addUser()");//调用添加用户成功
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("fail -> addUser()");//调用添加用户失败
		}
	}

	@Override
	public void delUser(int uid) {
		// TODO Auto-generated method stub
		userManager.delUser(uid);
	}

	@Override
	public void modifyUser(int uid, String name) {
		// TODO Auto-generated method stub
		userManager.modifyUser(uid, name);
	}

}
