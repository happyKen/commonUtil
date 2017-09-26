package com.algorithm.sort;

/*
 * 选择排序
 * 每趟排序与后面的数一一比较，选出最小数（最大数），交换位置。
 * 时间复杂度：
 * 最好，平均，最坏：n^2,有序也要遍历一边
 * 空间复杂度：0（1）
 * 稳定性：不稳定
 */
public class ChoiceSort {
   public static void main(String arg[]){
	 int []  a = {1,2,8,4,3,10};
	 ChoiceSort.sort(a);
	 ArrayUtils.printArray(a);
   }
   public static void sort(int [] array){
	   if(ArrayUtils.isEmpty(array)){//写排序都应该先判断空的情况
		   return ;
	   }
	   for(int i= 0 ;i<array.length;i++){
		   int min = i;//最小数的坐标
		   for(int j=i+1;j<array.length;j++){
			  min = (array[j]<array[min])?j:min;//找出最小数坐标
		   }
		   if(i!=min){//异或交换
			   array[i] = array[i]^array[min];
			   array[min] = array[i]^array[min];
			   array[i] = array[i]^array[min];
		   }
	   }
   }
}
