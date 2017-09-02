package com.algorithm.niukecoder;

import java.util.Stack;

/**
 * 
 * @ClassName: ReverseList 
 * 题目：输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * 思路：
 * @author wangzekeng
 * @date 2016年12月22日 下午3:44:35
 *
 */


//复杂度过大
public class ReverseList {
	public ListNode ReverseList(ListNode head) {
		Stack<ListNode> stack = new Stack<ListNode>();
		stack.push(head);
		while (head.next != null) {
			head = head.next;
			stack.push(head);
		}
		head = stack.pop();
		while (!stack.isEmpty()) {
			head.next = stack.pop();
		}
		return head;
	}
}
