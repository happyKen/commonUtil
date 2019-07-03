package com.algorithm.sort;

/*
 * 归并排序
 * 利用递归的思想：直接取中间位分成两段，再递归排序
 * 时间复杂度：
 * 平均，最好：0(nlogn)
 * 最坏：0(nlogn)
 * 空间复杂度：
 * 0（n）：需要一个存储临时变量的数组
 * 稳定性：稳定
 */
public class MergeSort {
public static void main(String arg[]){
	int [] a = {10,5,1,9,2,25};
	MergeSort.sort(a, 0, a.length-1);
	for(int x : a){
		System.out.print(" " + x);
	}
}
public static void sort(int[] array,int left ,int right){
	if(ArrayUtils.isEmpty(array)){
		return;
	}
	if(left<right){//判断递归终止的条件
	int m = (left + right)/2;
	sort(array, left, m);//左段
	sort(array, m+1, right);	//加1比较容易计算
	merge(array, left, m, right);//合并左右段
	}
}
public static void merge(int [] array,int left,int middle,int right){
	int [] sortArray = new int[right - left + 1];
	int k =0;
	int i = left;
	int j = middle+1;
	while(i <=middle && j <=right){//加到坐标位，有等号
		if(array[i]<=array[j]){		
			sortArray[k++] = array[i++];//为了保持稳定性，有相等的情况，需要优先将左边的放到前面
		}else{	
			sortArray[k++] = array[j++];
		}
	}
			while(j<=right){
				sortArray[k++] = array[j++];//利用这种k++的方式，减少代码
			}
			while(left<=middle){
				sortArray[k++] = array[i++];
			}
	for(int h = 0;h<sortArray.length;h++){
		array[left+h] = sortArray[h];//需要将新数组赋值给原数组，而且不能直接array = sortArray,因为array不是从0开始的	
	}
}
}
