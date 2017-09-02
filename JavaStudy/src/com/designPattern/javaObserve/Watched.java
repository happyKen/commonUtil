package com.designPattern.javaObserve;

import java.util.Observable;

public class Watched extends Observable{
    private String data ="";

	public String getData() {
		return data;
	}

	public void setData(String data) {
		if(!data.equals(this.data)){
//	    System.out.println("this.data:"+this.data);
//	    System.out.println("new data:"+data);
		this.data = data;
		setChanged();
		
		}
		notifyObservers();
	}
  
}
