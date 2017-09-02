package com.algorithm.niukecoder;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: ReOrderArray 
* 题目：
* 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
* 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
* 
* @author wangzekeng
* @date 2016年12月22日 下午3:21:58 
*
 */
public class ReOrderArray {
	public static void main(String[] args) {
		ReOrderArray reOrderArray = new ReOrderArray();
		int [] array = {1,2,3,4,5,6};
		reOrderArray.reOrderArray(array);
		for(int index : array){
			System.out.println(index);
		}
	}
	//暴力解决，直接创建连个链表
	public void reOrderArray(int[] array) {
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();
		for(int index : array){
			if(index % 2 != 0){
				list1.add(index);
			}else{
				list2.add(index);
			}
		}
		list1.addAll(list2);
		for(int i = 0;i<array.length;i++){
			array[i]= list1.get(i);
		}
		
		
	}
}
