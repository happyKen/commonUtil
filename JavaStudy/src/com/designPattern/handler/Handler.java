package com.designPattern.handler;

public abstract class Handler {
	private Handler successor = null;
	
	protected Handler getSuccessor(){
		return successor;
	}
	
	public void setSuccessor(Handler handler){
		this.successor = handler;
	}
	
	public abstract void handleRequest(String name ,int fee);
	
}
