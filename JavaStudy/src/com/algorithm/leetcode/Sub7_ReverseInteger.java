package com.algorithm.leetcode;

public class Sub7_ReverseInteger {
	public int reverse(int x) {
		if(x > Integer.MAX_VALUE || x<Integer.MIN_VALUE){
			return 0;
		}
		String str = Math.abs(x)+ "";
		StringBuffer stringBuffer = new StringBuffer();
		for(int i=str.length()-1;i>=0;i--){
			stringBuffer.append(str.charAt(i));
		}
        if(x>=0){
        	try{
        		return Integer.valueOf(stringBuffer.toString());
			}catch(Exception e ){
				return 0;
			}
        	
        }else{
        	try{
        		return -Integer.valueOf(stringBuffer.toString());
			}catch(Exception e ){
				return 0;
			}
        }
    }
	public static void main(String[] args) {
		Sub7_ReverseInteger sub = new Sub7_ReverseInteger();
		System.out.println(sub.reverse(234));
		
	}
}
