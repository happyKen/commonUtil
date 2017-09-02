package com.algorithm.niukecoder;
/**
 * 
* @ClassName: NumberOf1 
* 题目：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
* 
* 思路：位与运算
* @author wangzekeng
* @date 2016年12月21日 下午5:35:31 
*
 */
public class NumberOf1 {

	public static void main(String[] args) {
		System.out.println(new NumberOf1().NumberOf1(7));
	}

	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);//用&运算不必考虑补码
		}
		return count;
	}
}
