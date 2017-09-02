package com.algorithm.niukecoder;
/**
 * 
* @ClassName: Power 
* 题目：幂运算
* 
* 思路：全面考察幂运算，考虑0的情况，负数情况
* @author wangzekeng
* @date 2016年12月22日 下午2:57:17 
*
 */
public class Power {
	public static void main(String[] args) {
		System.out.println(new Power().Power(2.0,2));
	}
	
	//传统方法，时间复杂度为log（n）
	 public double Power(double base, int exponent) {
		 double result = 1;
	        for(int i = 0;i<Math.abs(exponent);i++){
	        	result =result * base;
	        }
	        if(exponent<0){
	        	result = 1/result;
	        }
	        return result;
	  }
}
