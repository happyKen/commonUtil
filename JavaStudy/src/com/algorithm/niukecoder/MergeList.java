package com.algorithm.niukecoder;

import java.util.List;

/**
 * 
 * @ClassName: MergeList 
 * 题目：输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 
 * 思路：考虑递归和非递归方法
 * @author wangzekeng
 * @date 2016年12月23日 上午9:55:06
 *
 */
public class MergeList {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		MergeList mergeList = new MergeList();
		ListNode list1 = mergeList.new ListNode(1);
		list1.next = mergeList.new ListNode(3);
		ListNode list2 = mergeList.new ListNode(2);
		list2.next = mergeList.new ListNode(4);
		ListNode merge = mergeList.Merge2(list1, list2);
		while (merge != null) {
			System.out.println(merge.val);
			merge = merge.next;
		}

	}

	// 非递归，归并排序的合并函数变形
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode mergeList = null; // 合并后的链表头
		ListNode temp = null; // 需要一个临时的变量来控制移动,做法是先连接，后移动

		// 先考虑特殊情况
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}

		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				if (mergeList == null) {// 用判空的方式解决第一次赋值
					mergeList = temp = list1;
				} else {
					temp.next = list1;// 先连接后移动
					temp = temp.next;
				}
				list1 = list1.next;
			} else if (list2.val <= list1.val) {// 用if执行到最后用到list1 =
												// list1.next，然后list1已经为空，这里做判断会空指针
				if (mergeList == null) {// 用判空的方式解决第一次赋值
					mergeList = temp = list2;
				} else {
					temp.next = list2;// 先连接后移动
					temp = temp.next;
				}
				list2 = list2.next;
			}

		}

		if (list1 == null) {
			temp.next = list2;
		} else {
			temp.next = list1;
		}
		return mergeList;
	}

	// 递归的方法
	public ListNode Merge2(ListNode list1, ListNode list2) {
		ListNode mergeList = null;
		if (list1 == null) {
			return list2;
		}
		if (list2 == null) {
			return list1;
		}
		if (list1.val < list2.val) {
			mergeList = list1;
			mergeList.next = Merge2(list1.next, list2);
		} else {
			mergeList = list2;
			mergeList.next = Merge2(list1, list2.next);
		}
		return mergeList;
	}
}
