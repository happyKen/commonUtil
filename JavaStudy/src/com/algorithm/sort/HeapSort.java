package com.algorithm.sort;

/*
 * 堆排序
 * 过程：
 * 核心：一个所有子树都为堆的完全二叉树。意思就是这个二叉树只差根节点不满足堆的结构。
 * 1.初始化大根堆（0位置已经是最大数）
 * 2.选取顶元素与0位置交换（最大数进入有序区）
 * 3.交换后最大堆的性质被破坏，从新调整堆。
 * 大根堆的大是末端元素最大，所以是顺序排序
 * 时间复杂度：
 * 最好，最坏，平均：0（nlogn）
 * 空间复杂度：0（1）
 * 稳定性：不稳定
 */
public class HeapSort {
	 public static void main(String arg[]){
		 //数组表示堆从图形是从上到下，从左到右，画图分析比较简单
		 int []  a = {1,2,8,4,3,10};
	   	    HeapSort.sort(a);
	   	    ArrayUtils.printArray(a);
	 }
	 public static void sort(int [] array){
		 buildMaxHeap(array);//初始化大根堆
         for(int i=array.length-1;i>0;i--){
		 ArrayUtils.changeIndex(array, 0, i);//每次将堆顶元素和无序区最后一个元素交换，即将无序区最大的元素放入有序区
		 ajustHeap(array, 0, i);//将无序区调整为大顶堆，即选择出最大的元素。
         }
	 }
	 /*
	  * 初始化大根堆
	  */
	 public static void buildMaxHeap(int [] array){
		 int size = array.length;
		 //从最后一个非叶子节点调整到根节点
		 for(int i = size/2-1;i>=0;i--){//size/2-1为最后一个非叶子节点下标（因为堆是一种满二叉树，由满二叉树性质可知）
			 ajustHeap(array, i, size);
		 }
	 }
	 /*
	  * 调整堆
	  */
	 public static void ajustHeap(int [] array,int i,int size){
          if(i<size/2){//非叶子节点才执行
        	  int max = i;//最大值坐标，跟选择排序类似，所以有资料说堆排序时改进的选择排序
        	  int left = 2*i+1;//左子节点的坐标
        	  int right = 2*i+2;//右子节点的坐标
        	  //找出大值的坐标
        	  if(left <size && array[left]>array[max]){
        		  max = left;
        	  }
        	  if(right<size && array[right]>array[max]){
        		  max = right;
        	  }
        	  if(max!=i){
        		  ArrayUtils.changeIndex(array, max, i);//交换
        		  ajustHeap(array, max, size);//有交换会破坏大根堆性质，需要重新调整，与max值有关
        	  }
        	
          }
	 }
}
