package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Sub3_LongestSubstringWithoutRepeatingCharacters {
	/**
	 * 
	 * 暴力查找 n2
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring(String s) {
		int max = 0;
		int i = 0;
		String str = "";
		while (i < s.length()) {
			
			for(int j = 0;j<str.length();j++){
				if(str.charAt(j) == s.charAt(i)){
					max = max < str.length() ? str.length() : max;
					str = str.substring(j+1, str.length());
				}
			}
			str = str + s.charAt(i);
			i++;

		}
		if(str != null){
			max = max < str.length() ? str.length() : max;
		}
		return max;
	}
	
	/**
	 * 滑动窗口
	 * set
	 * @param s
	 * @return
	 */
	public int lengthOfLongestSubstring2(String s) {
		int max = 0;
		int i = 0,j=0;
		Set<Character> set = new HashSet<Character>();
		while(j<s.length()){
			if(!set.contains(s.charAt(j))){
				max = Math.max(max, j-i+1);
				set.add(s.charAt(j++));
			}else{
				set.remove(s.charAt(i++));
			}
		}
		return max;
	}
	
	public int lengthOfLongestSubstring3(String s) {
		int max = 0;
		int i = 0,j=0;
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		while (j < s.length()) {
			if(map.containsKey(s.charAt(j))){
				max = Math.max(max, j-i);
				i = Math.max(map.get(s.charAt(j))+1, i);
			}
			map.put(s.charAt(j), j);
			j++;
		}
		max = Math.max(j-i, max);
		return max;
	}
	
	
	public static void main(String[] args) {
		Sub3_LongestSubstringWithoutRepeatingCharacters sub = new Sub3_LongestSubstringWithoutRepeatingCharacters();
		System.out.println(sub.lengthOfLongestSubstring3("abccbcd"));
	}
}
