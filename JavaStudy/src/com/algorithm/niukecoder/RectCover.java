package com.algorithm.niukecoder;
/**
 * 
* @ClassName: RectCover 
* 题目：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
* 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
* 
* 思路：类似跳阶梯，斐波纳契数列变形
* @author wangzekeng
* @date 2016年12月21日 下午5:22:11 
*
 */
public class RectCover {
	
	public static void main(String[] args) {
     System.out.println(new RectCover().RectCover(4));
	}
	public int RectCover(int target) {
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
