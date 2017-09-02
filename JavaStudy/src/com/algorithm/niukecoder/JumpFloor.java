package com.algorithm.niukecoder;
/**
 * 
* @ClassName: JumpFloor 
* 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
* 
* 思路：变形的斐波纳契数列
* @author wangzekeng
* @date 2016年12月21日 下午4:52:36 
*
 */
public class JumpFloor {
	
	public static void main(String[] args) {
		System.out.println((new JumpFloor()).JumpFloor(4));
		
	}
	//非递归方法
	 public int JumpFloor(int target) {
			if(target<=2){
				return target;
			}else{
				  int x=1 ,y=2,z = 3;
				  for(int i = 3;i<=target;i++){
					  z = x +y;
					  x = y;
					  y = z;			
				  }
				  return z;
			}
	    }
	
}
