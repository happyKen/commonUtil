package com.algorithm.niukecoder;

import java.util.Stack;

/**
 * 
* @ClassName: StackPopOrder 
* 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
* 假设压入栈的所有数字均不相等。
* 例如序列1,2,3,4,5是某栈的压入顺序，序列4，5,3,2,1是该压栈序列对应的一个弹出序列，
* 但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
* 
* 思路：
* @author wangzekeng
* @date 2016年12月26日 上午9:29:02 
*
 */
public class StackPopOrder {
	public static void main(String[] args) {
		StackPopOrder stackPopOrder = new StackPopOrder();
		int [] a  = {1,2,3,4,5};
		int [] b =  {4,5,3,2,1};
		if(stackPopOrder.IsPopOrder(a, b)){
			System.out.println("is pop order");
			
		}else{
			System.out.println("is not pop order");
		}
	}
	
	 public boolean IsPopOrder(int [] pushA,int [] popA) {
		if(pushA == null || popA == null || popA.length==0 || pushA.length == 0){
			return false;
		}
		Stack<Integer> stack = new Stack<Integer>();
		 int i = 0;
	     for(int index : popA){
	    	 if(!stack.isEmpty() && stack.peek() == index){
	    		 stack.pop();
	    	 }
	    	 while(i<pushA.length){
	    		 if(pushA[i]!=index){
	    			 stack.push(pushA[i]);
	    			 i++;
	    		 }else{
	    			 i++;
	    			 break;
	    		 }    		
	    	 }    	
	     }
	     
	    return stack.isEmpty();
	    }

}
