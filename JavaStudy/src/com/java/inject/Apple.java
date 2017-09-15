package com.java.inject;

import com.java.inject.FruitColor.Color;

public class Apple {
	@FruitName(value = "Apple")
	public String name;
	
	@FruitColor(fruitColor = Color.RED)
	public String color;
	
	@FruitProvider(id = 1 , name = "apple" , address = "wangze.com")
	public String provider;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}


	
	
}
