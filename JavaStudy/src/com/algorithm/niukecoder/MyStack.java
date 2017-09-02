package com.algorithm.niukecoder;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: MyStack 
* 题目：栈的模仿
*
* @author wangzekeng
* @date 2016年12月24日 下午2:16:30 
*
 */
public class MyStack {
	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(3);
		System.out.println(myStack.min());
		myStack.push(4);
		System.out.println(myStack.min());
		myStack.push(2);
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
		myStack.pop();
		System.out.println(myStack.min());
	}
	private List<Integer> list = new ArrayList<Integer>();

	public void push(int node) {
		list.add(node);
	}

	public void pop() {
		if (!list.isEmpty()) {
			list.remove(list.size() - 1);
		}
	}

	public int top() {
		if (list.isEmpty()) {
			return 0;
		}
		return list.get(list.size() - 1);
	}

	public int min() {
		if (list.isEmpty()) {
			return 0;
		}
		int min = top();
		for (int index : list) {
			min = min <= index ? min : index;
		}
		return min;
	}
}
