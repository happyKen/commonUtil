package com.algorithm.niukecoder;
import java.util.Stack;
/**
 * 
 * @ClassName: MirrorTree 
 * 题目：操作给定的二叉树，将其变换为源二叉树的镜像。
 * 
 * 思路：递归
 * @author wangzekeng
 * @date 2016年12月23日 下午5:21:03
 *
 */
public class MirrorTree {
	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
    //递归算法
	public void Mirror(TreeNode root) {
		if (root == null) {
			return;
		}
		TreeNode temp = root.left;
		root.left = root.right;
		root.right = temp;
		Mirror(root.left);
		Mirror(root.right);
	}

	
	//利用栈来写非递归
	public void Mirror2(TreeNode root) {
        if(root == null){
            return;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.left != null||node.right != null){
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            if(node.left!=null){
                stack.push(node.left);
            }
            if(node.right!=null){
                stack.push(node.right);
            }
        }
    }


}
