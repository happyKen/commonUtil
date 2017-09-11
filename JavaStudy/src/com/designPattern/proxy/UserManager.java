package com.designPattern.proxy;
/**
 * 代理接口 subject 客户端可见的类
* @ClassName: UserManager 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月11日 上午11:03:37 
*
 */
public interface UserManager {
	
	public void addUser(int uid,String name);
	
	public void delUser(int uid);
	
	public void modifyUser(int uid,String name);
}
