package com.designPattern.handler;

import org.omg.PortableInterceptor.USER_EXCEPTION;

public class GeneralManager extends Handler{
	
	@Override
	public void handleRequest(String name ,int fee) {
		// TODO Auto-generated method stub
		if(fee>1000){
			if(name.equals("张三")){
				System.out.println("成功：总经理同意" + name + "的经费申请，金额为：" + fee + "元");
			}else{
				System.out.println("失败：总经理不同意" + name + "的经费申请，金额为：" + fee + "元");
			}
		}else{
			if(getSuccessor() != null){
				getSuccessor().handleRequest(name, fee);
			}
		}
	}

}
