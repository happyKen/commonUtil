package com.designPattern.command;
/**
 * 具体命名
* @ClassName: TurnOffCommand 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 下午3:44:37 
*
 */
public class TurnOffCommand implements Command{
	private Tv mTv;
	public TurnOffCommand(Tv tv){
		this.mTv = tv;
	}
	
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		mTv.turnOff();
	}

}
