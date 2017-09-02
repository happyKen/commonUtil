package com.algorithm.sort;

/*
 * 插入排序
 * 从第二元素开始，每次与前面的元素比较（前面元素以排序），找到他的位置，则将前面的元素往后移动，留出空位给插入元素。
 * 时间复杂度：
 * 最坏，平均：0（n^2）
 * 最好：0（n）
 * 空间复杂度：0（1）
 * 稳定性：稳定
 * 
 */
public class InsertSort {
	  public static void main(String arg[]){
	    	int []  a = {5,2,8,4,3,10};
	   	    InsertSort.sort(a);
	   	    ArrayUtils.printArray(a);
	    }
	  public static void sort(int [] array){
		  int j;
		  int currentValue;
		  for(int i=1;i<array.length;i++){
			  j=i-1;//当前位的前一位
			  currentValue = array[i];//保留当前位的值，因为需要移动，必须先将值保留下来
			  while(j>=0 && array[j]>currentValue ){//当前小则前面元素需要移动
				  //注意：j>=0条件要放在前面，如果放后面可能出现j<0导致array[j]越界
				  array[j+1]=array[j];
				  j--;
				  
			  }
			  array[j+1] = currentValue;//注意上面j--减多了一位要加回来
		  }
	  }
}
