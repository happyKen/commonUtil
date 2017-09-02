package com.algorithm.niukecoder;
/**
 * 
* @ClassName: SortedArrayFind 
* @题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
* 每一列都按照从上到下递增的顺序排序。
* 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
* 
* @思路：从左下角向上递减，向右递增
* @author wangzekeng
* @date 2016年12月21日 上午9:45:04 
*
 */
public class SortedArrayFind {
	public static void main(String[] args) {
		SortedArrayFind sortedArrayFind = new SortedArrayFind();
		int [][] array = {{1,2,3},{4,5,6},{7,8,9}};
		if(sortedArrayFind.Find(10, array)){
			System.out.println("true");
		}else{
			System.out.println("false");
		}
	}
	 public boolean Find(int target, int [][] array) {
		 int height = array.length;    //二维的length表示有多少行,不是元素个数
		 int width  = array[0].length;
		 int i = height-1;
		 int j = 0;
		 while(i>=0 && j<=width-1){
			 if(target == array[i][j]){
				 return true;    //有return就已经跳出了
			 }else if(target<array[i][j]){
				 i--;
			 }else{
				 j++;
			 }
		 }
		 return false;
				 }
}
