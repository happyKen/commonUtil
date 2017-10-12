package com.designPattern.command;
/**
 * 命令的接收者
* @ClassName: Tv 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 下午3:45:54 
*
 */
public class Tv {
	private int channel;
	
	public void turnOn(){
		System.out.println("tv turn on");
	}
	
	public void turnOff(){
		System.out.println("tv turn off");
	}
	
	public void changeChannel(int channel){
		this.channel = channel;
		System.out.println("current channel is "+ channel);
	}
}
