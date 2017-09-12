package com.java.generic;

public class GenericSpecial {
	
	//上界，T只能是Number或者它的子类
	 static class Box1<T extends Number> {

	        private T data;//T设定成员变量类型

	        public Box1() {

	        }

	        public Box1(T data) {
	            this.data = data;
	        }

	        public T getData() {
	            return data;
	        }

	    }
	 

	 public static void main(String[] args) {
		//Box1<String> box = new Box1<String>(); 会报错
		 Box1<Integer> box = new Box1<Integer>(1);
		 System.out.println(box.getData());
		}
}
