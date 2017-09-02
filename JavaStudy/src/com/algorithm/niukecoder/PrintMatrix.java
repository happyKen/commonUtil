package com.algorithm.niukecoder;

import java.util.ArrayList;
/**
 * 
* @ClassName: PrintMatrix 
* 题目：输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
* 例如，如果输入如下矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 
* 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.（由外到内旋转输出）
* 
* 思路：按一圈圈输出
* @author wangzekeng
* @date 2016年12月24日 上午11:39:19 
*
 */
public class PrintMatrix {
	public static void main(String[] args) {
		PrintMatrix printMatrix = new PrintMatrix();
		int[][] matrix = { { 1, 2 }, { 3, 4 }, { 5, 6 }, { 7, 8 }, { 9, 10 } };
		for (int i : printMatrix.printMatrix(matrix)) {
			System.out.println(i);
		}
	}

	public ArrayList<Integer> printMatrix(int[][] matrix) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		if (matrix == null) {
			return null;
		}
		int row = matrix.length;
		int width = matrix[0].length;
		int circle = width <= row ? ((width + 1) / 2) : ((row + 1) / 2);// 这个圈数计算太麻烦了

		for (int i = 0; i < circle; i++) {
			for (int j = i; j < width - i; j++) {
				list.add(matrix[i][j]);
			}
			for (int x = i + 1; x < row - i; x++) {
				list.add(matrix[x][width - i - 1]);
			}
			if (row - i - 1 > i) {// 防止单行的情况
				for (int z = width - i - 2; z >= i; z--) {
					list.add(matrix[row - i - 1][z]);
				}
			}
			if (width - i - 1 > i) {// 防止单列的情况
				for (int m = row - i - 2; m > i; m--) {
					list.add(matrix[m][i]);
				}
			}

		}
		return list;
	}
}
