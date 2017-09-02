package com.algorithm.niukecoder;
/**
 * 
* @ClassName: VerifySquenceOfBST 
* 题目：输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
* 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
* 
* 
* 思路：有递归和非递归。递归：最后一位元素为根，分为两段，前面一段所有元素都小于根，
* 后面一段所有元素都大于跟。然后递归两段，注意单支问题
* 
* @author wangzekeng
* @date 2017年2月20日 上午11:09:44 
*
 */
public class VerifySquenceOfBST {
	//递归
	public boolean VerifySquenceOfBST(int[] sequence) {
		int size = sequence.length;
		if (size == 0) {
			return false;
		} else {
			return isOrder(sequence, 0, size - 1);
		}
	}

	public boolean isOrder(int[] sequence, int low, int high) {
		if (low == high) {
			return true;
		}
		int mid = low;
		while (sequence[mid++] < sequence[high] && mid < high)
			;
		int tmp = mid;
		while (sequence[tmp++] > sequence[high] && tmp < high)
			;
		if (tmp < high) {
			return false;
		}
		if (mid == low || mid == high) {
			return isOrder(sequence, low, high - 1);
		} else {
			return (isOrder(sequence, low, mid - 1) && isOrder(sequence, mid,
					high - 1));
		}
	}
	
	
}
