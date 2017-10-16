package com.algorithm.leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sub2_AddTwoNumbers {
	/**
	 * 方法1，遍历链表，分为三种情况
	 * 遍历链表实际就是创建个游标不断为next赋值
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode listNode = new ListNode(0);
		ListNode index = listNode;//游标
		int addNum = 0;
		while (l1 != null && l2 != null) {
			int sum = (l1.val + l2.val + addNum) % 10;
			addNum = (l1.val + l2.val + addNum) / 10;
			index.next = new ListNode(sum);//赋值next，相当于为listnode的next赋值
			index = index.next;
			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 == null && l2 != null) {
			index.next = new ListNode((l2.val + addNum)%10);
			addNum = (l2.val + addNum) /10;
			l2 = l2.next;
			index = index.next;
		}

		while (l2 == null && l1 != null) {
			index.next = new ListNode((l1.val + addNum)%10);
			addNum = (l1.val + addNum) /10;
			l1 = l1.next;
			index = index.next;
		}
		if(addNum != 0){
			index.next = new ListNode(addNum);
		}
		return listNode.next;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
		ListNode head = new ListNode(0);
		ListNode index = head;
		int add = 0;
		while(l1 != null || l2 !=null){
			int v1 = (l1 != null) ? l1.val : 0;
			int v2 = (l2 != null) ? l2.val : 0;
			index.next = new ListNode((v1 + v2 + add) % 10);
			index = index.next;
			add = (v1 + v2 + add) / 10;
			if(l1 != null) l1 = l1.next;
			if(l2 != null) l2 = l2.next;
			
		}
		
		if(add != 0){
			index.next = new ListNode(add);
		}
		return head.next;
	}
	
	
	
	
	
	public int[] stringToIntegerArray(String input) {
		input = input.trim();
		input = input.substring(1, input.length() - 1);
		if (input.length() == 0) {
			return new int[0];
		}

		String[] parts = input.split(",");
		int[] output = new int[parts.length];
		for (int index = 0; index < parts.length; index++) {
			String part = parts[index].trim();
			output[index] = Integer.parseInt(part);
		}
		return output;
	}

	public ListNode stringToListNode(String input) {
		// Generate array from the input
		int[] nodeValues = stringToIntegerArray(input);

		// Now convert that list into linked list
		ListNode dummyRoot = new ListNode(0);
		ListNode ptr = dummyRoot;
		for (int item : nodeValues) {
			ptr.next = new ListNode(item);
			ptr = ptr.next;
		}
		return dummyRoot.next;
	}

	public static String listNodeToString(ListNode node) {
		if (node == null) {
			return "[]";
		}

		String result = "";
		while (node != null) {
			result += Integer.toString(node.val) + ", ";
			node = node.next;
		}
		return "[" + result.substring(0, result.length() - 2) + "]";
	}

	public static void main(String[] args) throws IOException {
		Sub2_AddTwoNumbers sub2_AddTwoNumbers = new Sub2_AddTwoNumbers();
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = in.readLine()) != null) {
			ListNode l1 = sub2_AddTwoNumbers.stringToListNode(line);
			line = in.readLine();
			ListNode l2 = sub2_AddTwoNumbers.stringToListNode(line);

			ListNode ret = new Sub2_AddTwoNumbers().addTwoNumbers2(l1, l2);

			String out = listNodeToString(ret);

			System.out.print(out);
		}
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
