package com.designPattern.command;
/**
 * 具体命令
* @ClassName: ChangeChannelCommand 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 下午3:45:07 
*
 */
public class ChangeChannelCommand implements Command{
	private Tv mTv;
	private int channel;
	public ChangeChannelCommand(Tv tv,int channel){
		this.mTv = tv;
		this.channel = channel;
	}
	
	@Override
	public void excute() {
		// TODO Auto-generated method stub
		mTv.changeChannel(channel);
	}

}
