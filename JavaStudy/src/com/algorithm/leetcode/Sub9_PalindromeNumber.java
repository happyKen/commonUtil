package com.algorithm.leetcode;

public class Sub9_PalindromeNumber {
	  //判断是数字
	  public boolean isPalindrome(int x) {
		if(x<0 || (x % 10 == 0 && x !=0)){
			return false;
		}
		int reservedNum = 0;
		while(x > reservedNum){
			reservedNum = reservedNum * 10 + x % 10;
			x /= 10;
		}
		
		return (x == reservedNum || x == reservedNum/10);
		  
	  }
	  public static void main(String[] args) {
		Sub9_PalindromeNumber sub = new Sub9_PalindromeNumber();
		int x = 10;
		if(sub.isPalindrome(x)){
			System.out.println(x + " is a PalindromeNumber");
		}
	}
}
