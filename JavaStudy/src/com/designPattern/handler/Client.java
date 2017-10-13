package com.designPattern.handler;
/**
 * 责任链模式
* @ClassName: Client 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月13日 上午11:01:56 
*
 */
public class Client {
	public static void main(String[] args) {
		ProjectManager projectManager = new ProjectManager();
		DeptManager deptManager = new DeptManager();
		GeneralManager generalManager = new GeneralManager();
		projectManager.setSuccessor(deptManager);
		deptManager.setSuccessor(generalManager);
		projectManager.handleRequest("张三", 10000);
		deptManager.handleRequest("李四", 100);
	}
}
