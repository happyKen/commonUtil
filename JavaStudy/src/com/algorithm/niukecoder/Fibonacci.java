package com.algorithm.niukecoder;

import javax.print.attribute.standard.Finishings;

/**
 * 
* @ClassName: Fibonacci 
* 题目：找出斐波纳契数列第N项
* 
* 思路：递归会消耗内存，非递归消耗空间
* @author wangzekeng
* @date 2016年12月21日 下午3:30:03 
*
 */
public class Fibonacci {
	public static void main(String[] args) {
		Fibonacci fibonacci = new Fibonacci();
		System.out.println(fibonacci.Fibonacci2(5));
	}
	
	//递归方法，大量计算，内存溢出
	public int Fibonacci(int n){
		if(n<=0){
			return 0;
		}
		if(n == 1){
			return 1;
		}
		else{
			return Fibonacci(n-1)+Fibonacci(n-2);
		}
		
    }
	
	//非递归方法
	public int Fibonacci2(int n){
		if(n<=0){
			return 0;
		}
		if(n<=2){
			return 1;
		}else{
			  int x=1 ,y=1,z = 2;
			  for(int i = 3;i<=n;i++){
				  z = x +y;
				  x = y;
				  y = z;			
			  }
			  return z;
		}
	  
		
    }
}
