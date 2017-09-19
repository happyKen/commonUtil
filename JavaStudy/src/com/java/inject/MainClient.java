package com.java.inject;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

public class MainClient {
	
	public static void main(String[] args) {
		fruitUtils(Apple.class);
		
	}
	
	
	public static void fruitUtils(Class<?> cls){

		Field[] fields = cls.getDeclaredFields();
		
		for(Field field: fields){
			if(field.isAnnotationPresent(FruitName.class)){
				FruitName fuiltName = field.getAnnotation(FruitName.class);
				System.out.println("fuilt name:" + fuiltName.value());
				
				
			}else if(field.isAnnotationPresent(FruitColor.class)){
				FruitColor fruitColor = field.getAnnotation(FruitColor.class);
				System.out.println("fruit color:" + fruitColor.fruitColor().toString());
				
				
			}else if(field.isAnnotationPresent(FruitProvider.class)){
				FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
				System.out.println("fruit provider:"+ fruitProvider.id() + "+" + fruitProvider.name()
						+ "+" + fruitProvider.address());
				
				
			}
		}
	}
	
}
