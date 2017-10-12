package com.designPattern.command;
/**
 * 命令模式
* @ClassName: Client 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 下午3:46:27 
*
 */
public class Client {
	public static void main(String[] args) {
		Tv tv = new Tv();
		TurnOffCommand turnOffCommand = new TurnOffCommand(tv);
		TurnOnCommand turnOnCommand = new TurnOnCommand(tv);
		ChangeChannelCommand changeChannelCommand = new ChangeChannelCommand(tv,2);
		Invoke invoke = new Invoke(turnOffCommand, turnOnCommand, changeChannelCommand);
		invoke.turnOn();
		invoke.changeChannel();
		invoke.turnOff();
	}
}
