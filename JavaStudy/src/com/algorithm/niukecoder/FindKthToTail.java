package com.algorithm.niukecoder;

/**
 * 
 * @ClassName: FindKthToTail 
 * 题目：输入一个链表，输出该链表中倒数第k个结点。
 * 
 * 思路：用两个节点只需遍历一次
 * @author wangzekeng
 * @date 2016年12月22日 下午3:22:45
 *
 */
class ListNode {
	int val;
	ListNode next = null;
	ListNode(int val) {
		this.val = val;
	}
}

public class FindKthToTail {
	
	public ListNode FindKthToTail(ListNode head, int k) {
		if(head==null || k <=0){
			return null;
		}
		ListNode i=head,j=head;
		for(int x = 1;x<k;x++){//是否需要等号通过一个具体例子获得
			if(i.next==null){
				return null;
			}
			i=i.next;
		}
		while(i.next!=null){
				i = i.next;
				j= j.next;
			}
		return j;
	}
}
