package com.designPattern.state;

public interface VoteState {
	/**
	 * 
	 * @param user 投票人
	 * @param voteItem 投票项
	 * @param voteContext 上下文
	 */
	public void vote(String user,String voteItem,VoteContext voteContext);
}
