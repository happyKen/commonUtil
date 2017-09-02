package com.algorithm.niukecoder;

/**
 * 
 * @ClassName: HasSubtree 
 * 题目：输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 
 * 思路：利用递归的思想。由于需要先判断是否为空的情况，需要另外用一个函数
 *       如果根节点相同则递归调用递归，如果根节点不相同，则判断tree1的左子树和tree2是否相同，
 *       再判断右子树和tree2是否相同
 *       注意结束条件
 * @author wangzekeng
 * @date 2016年12月23日 上午11:14:01
 *
 */
public class HasSubtree {

	public class TreeNode {
		int val = 0;
		TreeNode left = null;
		TreeNode right = null;

		public TreeNode(int val) {
			this.val = val;
		}
	}
   //全部过一遍，简单
	public boolean HasSubtree(TreeNode root1, TreeNode root2) {
		if(root1 == null || root2 == null){
			return false;
		}else{
			return isSubTree(root1, root2) ||
					HasSubtree(root1.left, root2) ||
					HasSubtree(root1.right, root2);
		}
	}
	
   //剪掉不必要的查找
	public boolean HasSubtree2(TreeNode root1, TreeNode root2) {
		boolean result = false;
        if(root1 != null && root2 != null){
            if(root1.val == root2.val){
                result = isSubTree(root1,root2);
            }
            if(!result){result = HasSubtree2(root1.left, root2);}
            if(!result){result = HasSubtree2(root1.right, root2);}
        }
        return result;
	}
	
	public boolean isSubTree(TreeNode root1, TreeNode root2) {
		if(root2 == null) return true;
		if(root1 == null) return false;
		if(root1.val != root2.val) return false;	
		return isSubTree(root1.left, root2.left) && isSubTree(root1.right, root2.right);
	}

}
