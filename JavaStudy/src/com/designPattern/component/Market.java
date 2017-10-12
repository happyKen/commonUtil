package com.designPattern.component;

public abstract class Market {
	String name;
	public abstract void add(Market m);
	
	public abstract void remove(Market m);
	
	public abstract void pay();
	
}
