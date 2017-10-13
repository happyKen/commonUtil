package com.designPattern.handler;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class ProjectManager extends Handler{
	
	@Override
	public void handleRequest(String name ,int fee) {
		// TODO Auto-generated method stub
		if(fee<=500){
			if(name.equals("张三")){
				System.out.println("成功：项目经理同意" + name + "的经费申请，金额为：" + fee + "元");
			}else{
				System.out.println("失败：项目经理不同意" + name + "的经费申请，金额为：" + fee + "元");
			}
		}else{
			if(getSuccessor() != null){
				getSuccessor().handleRequest(name, fee);
			}
		}
	}

}
