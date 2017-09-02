package com.designPattern.strategy;

public class TestStrategy {

	public static void main(String[] args) {

		StrategyContext plane = new StrategyContext();
		plane.setStrategy(new PlaneStrategy());
		plane.travel();

		StrategyContext walk = new StrategyContext();
		walk.setStrategy(new WalkStrategy());
		walk.travel();
	}
}
