package com.algorithm.niukecoder;
/**
 * 
* @ClassName: MinNumberInRotateArray 
* 题目：
 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
* 
* 
* 思路：二分法变形
* 
* 
* 
* @author wangzekeng
* @date 2016年12月21日 下午3:27:53 
*
 */
public class MinNumberInRotateArray {
	public static void main(String[] args) {
		int [] array = {3,4,5,1,2};
		MinNumberInRotateArray solution = new MinNumberInRotateArray();
		System.out.println(solution.minNumberInRotateArray(array));
	}
	
	public int minNumberInRotateArray(int [] array) {
	    int low = 0;
	    int high = array.length-1;
	    while(low < high){
	    	int mid = low+ (high-low)/2;//中间或者较小的那个数
	    	if(array[mid]>array[high]){
	    	  low = mid + 1;
	    	}else if(array[mid]==array[high]){
	    		high = high -1;
	    	}else{
	    		high = mid;
	    	}
	    	
	    }
	    return array[low];
    }
}
