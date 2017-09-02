package com.algorithm.niukecoder;
/**
 * 
* @ClassName: JumpFloorII 
* 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
* 
* 思路：斐波纳契数列扩展，找出规律即可
* @author wangzekeng
* @date 2016年12月21日 下午5:13:51 
*
 */
public class JumpFloorII {
	
	public static void main(String[] args) {
		System.out.println((new JumpFloorII()).JumpFloor2(4));

	}

	public int JumpFloor(int target) {
		if (target == 1) {
			return 1;
		} else {
			int n = 1, result = 1;
			while (n < target) {
				result = result * 2;
				n++;
			}
			return result;
		}
	}
	
	//位运算速度更快
	public int JumpFloor2(int target) {
		int result = 1;
		return result<<(target-1);//<<相当于乘与2
	}

}
