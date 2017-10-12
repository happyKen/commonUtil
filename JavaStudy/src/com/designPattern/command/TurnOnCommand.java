package com.designPattern.command;
/**
 * 具体命令
* @ClassName: TurnOnCommand 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 下午3:44:52 
*
 */
public class TurnOnCommand implements Command{
	private Tv mTv;
	public TurnOnCommand(Tv tv){
		this.mTv = tv;
	}
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		mTv.turnOn();
	}

}
