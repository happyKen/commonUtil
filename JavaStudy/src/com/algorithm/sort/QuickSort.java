package com.algorithm.sort;


public class QuickSort {
	/*
	 * 快速排序
	 * 时间复杂度：
	 * 平均，最好：0（nlogn）
	 * 最差：n^2
	 * 空间复杂度：0(nlogn)
	 * 利用递归的思想：设置一个标志位，把小于这个数归到一边，大于这个数归到另一边。再对两边递归，一直只剩一个元素
	 * 稳定性：不稳定
	 */
    public static void main(String arg[]){
    	int [] a ={10,2,4,7,15,8,9};
    	QuickSort.sort(a, 0, a.length-1);
    	for(int v:a){
    		System.out.print(" "+v);
    	}
    }
    public static void sort(int [] array,int left,int right){
    	if(ArrayUtils.isEmpty(array)){
    		return ;
    	}
    	//递归结束条件是左右坐标相等
    	if(left<right){
    		
    		int p = position(array, left, right);
    		sort(array,left,p-1);
    		sort(array,p+1,right);
    	}
    } 

	public static int position(int [] array ,int left,int right){
		int p = array[left];
		while(left<right){//需要多趟交换，左右坐标相等时停止
		while(left<right && array[right]>p){
			right--;//每趟需要找到比标志位小的数
		}
		array[left] = array[right];//赋给左边
		while(left<right && array[left]<p){
			left++;//每趟需要找到比标志位大的数
		}
		array[right] = array[left];//赋给右边
		}
		
    	array[left]=p;//最后左边的数（右边值）换成标志位
    	return left;//返回标志坐标
    	
    }
    
}
