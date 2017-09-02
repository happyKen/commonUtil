package com.algorithm.niukecoder;

import java.util.Stack;

/**
 * 
 * @ClassName: StackReplaceQueue
 * 题目：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 
 * 思路：
 * 入队：栈A用来储存
 * 出队：栈B用来输出。每次先判断栈B是否为空，为空则将栈A全部pop，push进入栈B；栈B不为空时pop
 * @author wangzekeng
 * @date 2016年12月21日 上午10:42:47
 *
 */
public class StackReplaceQueue {
	public static void main(String[] args) {
		StackReplaceQueue stackReplaceQueue = new StackReplaceQueue();
		stackReplaceQueue.push(1);
		stackReplaceQueue.push(2);
		stackReplaceQueue.push(3);
		System.out.println(stackReplaceQueue.pop());
		System.out.println(stackReplaceQueue.pop());
		stackReplaceQueue.push(4);
		System.out.println(stackReplaceQueue.pop());
		stackReplaceQueue.push(5);
		System.out.println(stackReplaceQueue.pop());
		System.out.println(stackReplaceQueue.pop());
	}
	Stack<Integer> stack1 = new Stack<Integer>();
	Stack<Integer> stack2 = new Stack<Integer>();

	public void push(int node) {
     stack1.push(node);
	}

	public int pop() {
		if(stack1.isEmpty() && stack2.isEmpty()){
			throw new RuntimeException("队列为空");
		}else{
			if(stack2.isEmpty()){//当输出全部完了才要重新输入，先进的永远先出
			while(!stack1.isEmpty()){//一次性将stack1 输入到stack2
				stack2.push(stack1.pop());
			}
			}
			return stack2.pop();
		}
	}
}
