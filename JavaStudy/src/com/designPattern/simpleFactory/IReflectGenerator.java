package com.designPattern.simpleFactory;

public interface IReflectGenerator {
	public <T extends IPhone> T generatePhone(Class<T> cls)throws Exception;
}
