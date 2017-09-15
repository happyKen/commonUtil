package com.designPattern.abtractFactory;

public interface IAbtractGenerator {
	public <T extends IPhone> T generatePhone(Class<T> cls)throws Exception;

	
	public <T extends IPad> T generatePad(Class<T> cls)throws Exception;
	
}
