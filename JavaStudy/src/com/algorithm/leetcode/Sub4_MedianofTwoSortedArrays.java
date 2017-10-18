package com.algorithm.leetcode;

/**
 * 求中位数要分奇偶
 * 
 * @ClassName: Sub4_MedianofTwoSortedArrays
 * @Description: TODO
 * @author wangzekeng
 * @date 2017年10月17日 下午3:09:54
 *
 */
public class Sub4_MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		return 0.0;
	}
	
	
	 private double findKth(int[] arr1, int[] arr2, int start1, int start2, int len1, int len2, int k){
	        // 保证arr1是较短的数组
	        if(len1>len2){
	            return findKth(arr2,arr1,start2,start1,len2,len1,k);
	        }
	        if(len1==0){
	            return arr2[start2 + k - 1];
	        }
	        if(k==1){
	            return Math.min(arr1[start1],arr2[start2]);
	        }
	        int p1 = Math.min(k/2,len1) ;
	        int p2 = k - p1;
	        if(arr1[start1 + p1-1]<arr2[start2 + p2-1]){
	            return findKth(arr1,arr2,start1 + p1,start2,len1-p1,len2,k-p1);
	        } else if(arr1[start1 + p1-1]>arr2[start2 + p2-1]){
	            return findKth(arr1,arr2,start1,start2 + p2,len1,len2-p2,k-p2);
	        } else {
	            return arr1[start1 + p1-1];
	        }
	    }
}
