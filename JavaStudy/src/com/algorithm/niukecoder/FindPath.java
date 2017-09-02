package com.algorithm.niukecoder;

import java.util.ArrayList;
/**
 * 
* @ClassName: FindPath 
* @Description:
* 题目：输入一颗二叉树和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
* 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
* 
* 思路：回溯法
* @author wangzekeng
* @date 2017年2月20日 下午3:49:20 
*
 */

public class FindPath {
	ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();
	ArrayList<Integer> list = new ArrayList<Integer>();
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
   public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	   if(root == null){
		   return lists;
	   }//终止条件
      list.add(root.val);
	  if(target == root.val && root.left == null && root.right == null){
		 lists.add(new ArrayList<Integer>(list));
	  }
	  if(target > root.val){
		  int tmp = target-root.val;
		  if(root.left !=null){
			  FindPath(root.left, tmp);
		  }
		  if(root.right != null){
			  FindPath(root.right, tmp);
		  }  
	  }
	  list.remove(list.size()-1);//找到后都要回溯
	  return lists;
    }
}
