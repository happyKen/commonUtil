package com.algorithm.sort;
/**
 * 
* @ClassName: BubbleSort 
* @Description: TODO
* @author wangzekeng
* @date 2016年12月9日 上午10:14:45 
*
 */

public class BubbleSort {
/*	
	 * 冒泡排序
	 * 每趟与后面的数一一比较，比较时交换位置
	 * 时间复杂度：
	 * 平均，最好，最坏：0（n^2）
	 * 改进：最好情况是0（n）：增加控制循环标志
	 * 空间复杂度：0(1)
	 * 稳定性：稳定
	 */
    public static void main(String arg[]){
    	int []  a = {1,2,8,4,3,10};
   	    BubbleSort.sort(a);
   	    ArrayUtils.printArray(a);
    }
    public static void sort(int [] array){
    	boolean isSort;//判断是否有序
    	if(ArrayUtils.isEmpty(array)){
    		return ;
    	}
    	for(int i= 0 ;i<array.length;i++){
    		 isSort = true;
    		for(int j=0;j<array.length-i-1;j++){
    			if(array[j]>array[j+1]){
                    ArrayUtils.changeIndex(array, j, j+1);
    				isSort = false;//需要交换时则是无序
    			}
    		}
    		if(isSort)
    			return;//有序时直接结束
    	}
    }
}
