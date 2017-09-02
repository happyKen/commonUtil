package com.algorithm.sort;
/**
 * 
* @ClassName: ArrayUtils 
* 数组操作工具类，判断数组是否为空，交换数据
* @author wangzekeng
* @date 2016年12月9日 上午10:11:30 
*
 */
public class ArrayUtils {
public static void printArray(int [] array){
	for(int x : array){
		System.out.print(" "+x);
	}
	System.out.print("\n");
}
public static void changeIndex(int [] array, int index1, int index2){
	array[index1] = array[index1]^array[index2];
	array[index2] = array[index1]^array[index2];
	array[index1] = array[index1]^array[index2];
}
public static boolean isEmpty(int [] array){
	if(array==null || array.length<=0)
		return true;
	else
		return false;
}
}
