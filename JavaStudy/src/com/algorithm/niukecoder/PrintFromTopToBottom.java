package com.algorithm.niukecoder;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/**
 * 
* @ClassName: PrintFromTopToBottom 
* @Description: 使用一个队列，一个链表，一个存放节点，一个存放值。
* 先将根节点加入到队列中，然后遍历队列中的元素，遍历过程中，访问该元素的左右节点，再将左右子节点加入到队列中来
* @author wangzekeng
* @date 2017年1月18日 下午4:52:38 
*
 */
public class PrintFromTopToBottom {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	    	 ArrayList<Integer> list = new ArrayList<Integer>();
	         if(root==null){
	             return list;
	         }
	         Queue<TreeNode> queue = new LinkedList<TreeNode>();//队列的实现是用LinkedList，LinkedList比ArrayList便于插入和删除
	         queue.offer(root);
	         while (!queue.isEmpty()) {
	             TreeNode treeNode = queue.poll();
	             if (treeNode.left != null) {
	                 queue.offer(treeNode.left);
	             }
	             if (treeNode.right != null) {
	                 queue.offer(treeNode.right);
	             }
	             list.add(treeNode.val);
	         }
	         return list;
	     }
	        
	    
}
