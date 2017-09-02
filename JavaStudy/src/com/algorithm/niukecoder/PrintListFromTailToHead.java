package com.algorithm.niukecoder;

import java.util.ArrayList;
import java.util.Stack;
/**
 * 
* @ClassName: PrintListFromTailToHead 
* 题目：输入一个链表，从尾到头打印链表每个节点的值。
* 
* 思路：利用栈先进后出的特点
* @author wangzekeng
* @date 2016年12月21日 上午10:34:19 
*
 */
public class PrintListFromTailToHead {
	 public class ListNode {
		         int val;
		         ListNode next = null;
		 
		        ListNode(int val) {
		             this.val = val;
		        }
		     }
	public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        Stack<Integer> stack=new Stack<Integer>();//创建栈，必须用integer
        while(listNode!=null){
            stack.push(listNode.val);//push方法
            listNode=listNode.next;     
        }
        
        ArrayList<Integer> list=new ArrayList<Integer>();
        while(!stack.isEmpty()){
            list.add(stack.pop());//pop方法弹出
        }
        return list;
    }
}
