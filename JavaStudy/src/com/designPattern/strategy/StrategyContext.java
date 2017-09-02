package com.designPattern.strategy;

/**
 * 
 * @ClassName: StrategyContext
 * @Description: 创建一个包装strategy的类来进行管理,此类不再需要修改，新增策略时只需再写类继承接口，符合开放封闭原则
 * @author wangzekeng
 * @date 2016年12月8日 下午4:46:29
 *
 */
public class StrategyContext {
	private Strategy strategy;

	public Strategy getStrategy() {
		return strategy;
	}

	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public void travel() {
		if (strategy != null) {
			strategy.travel();
		}
	}
}
