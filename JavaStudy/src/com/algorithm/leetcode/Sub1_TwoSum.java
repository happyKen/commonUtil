package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 *Given an array of integers, 
 *return indices of the two numbers such that they add up to a specific target.
 *You may assume that each input would have exactly one solution, 
 *and you may not use the same element twice. 
 * 
 * 
* @ClassName: TwoSum 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月16日 上午11:23:12 
*
 */
public class Sub1_TwoSum {
	/**
	 * 暴力方法，时间复杂度为o(n),空间复杂度o(1)
	 * @param nums
	 * @param target
	 * @return
	 */
	  public int[] twoSum(int[] nums, int target) {
	        for(int i = 0;i<nums.length;i++){
	            for(int j = i+1;j<nums.length;j++){
	                if(nums[i]+nums[j] == target){
	                   return new int[]{i,j};
	                }
	            }
	        }
	        return null;
	    }
	  
	  
	  /**
	   * 用hashmap空间换时间
	   * HashMap的get，containskey方法都是o（1），containsValue是o(n)
	   * 时间复杂度为o(n)，空间复杂度为o(n)
	   * @param nums
	   * @param target
	   * @return
	   */
	  public int[] twoSum2(int[] nums, int target) {
	      	Map<Integer,Integer> maps = new HashMap<Integer, Integer>();
	      	for(int i= 0;i<nums.length;i++){
	      		int another = target - nums[i];
	      		if(maps.containsKey(another)){
	      			return new int[]{maps.get(another),i};
	      		}
	      		maps.put(nums[i], i);
	      	}
	        return null;
	    }
}
