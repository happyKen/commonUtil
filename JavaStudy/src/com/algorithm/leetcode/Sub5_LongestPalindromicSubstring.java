package com.algorithm.leetcode;

public class Sub5_LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		String result = "";
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i; j < s.length(); j++) {
				if (isPalindromic(s.substring(i, j + 1))) {
					if (max < j - i + 1) {
						max = j - i + 1;
						result = s.substring(i, j + 1);
					}
				}

			}
		}
		return result;
	}

	public boolean isPalindromic(String s) {
		boolean isPalindromic = true;
		int i = 0;
		int j = s.length() - 1;
		while (i < j) {
			if (s.charAt(i++) != s.charAt(j--)) {
				isPalindromic = false;
			}
		}
		return isPalindromic;
	}

	
	/**
	 * 动态规划
	 * 需要建立一个表，横纵坐标表示字符串的起始和结束，pal[0][s.length(0)]表示整个字符串是否为回文。
	 * 注意在遍历表时候去掉不需要的情况
	 * @param s
	 * @return
	 */
	public String longestPalindrome2(String s) {
		int max = 0;
		int start = 0;
		int end = 0;
		boolean[][] isPal = new boolean[s.length()][s.length()];
		for (int i = s.length(); i >= 0; i--) {
			for (int j = i; j < s.length(); j++) {
				if (i == j) {
					isPal[i][j] = true;
				} else if(i+1 == j){
					if(s.charAt(i) == s.charAt(j)){
						isPal[i][j] = true;
					}else{
						isPal[i][j] = false;
					}
				}else{
					if (isPal[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
						isPal[i][j] = true;
					} else {
						isPal[i][j] = false;
					}
				}

				if (isPal[i][j] && j - i + 1 >= max) {
					max = j - i + 1;
					start = i;
					end = j;
				}
			}
		}
		return s.substring(start, end+1);
	}

	public static void main(String[] args) {
		Sub5_LongestPalindromicSubstring sub = new Sub5_LongestPalindromicSubstring();
		System.out.println(sub.longestPalindrome2("babad"));
	}
}
