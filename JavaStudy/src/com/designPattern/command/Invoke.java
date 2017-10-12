package com.designPattern.command;
/**
 * 命令的执行者
* @ClassName: Invoke 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 下午3:46:14 
*
 */
public class Invoke {
	private TurnOffCommand turnOffCommand;
	private TurnOnCommand turnOnCommand;
	private ChangeChannelCommand changeChannelCommand;
	public Invoke(TurnOffCommand turnOffCommand,TurnOnCommand turnOnCommand,ChangeChannelCommand changeChannelCommand){
		this.turnOnCommand = turnOnCommand;
		this.turnOffCommand = turnOffCommand;
		this.changeChannelCommand = changeChannelCommand;
	}
	
	public void turnOff(){
		turnOffCommand.excute();
	}
	
	public void turnOn(){
		turnOnCommand.excute();
	}
	
	public void changeChannel(){
		changeChannelCommand.excute();
	}
}
