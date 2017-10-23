package com.algorithm.leetcode;

public class Sub8_StringtoInteger {
	public int myAtoi(String str) {
		str = str.trim();
		int pre = 1;
		int index = 0;
		int preNum = 0;
		if (str == null || str.equals("")) {
			return 0;
		}
		long result = 0;
		if (str.charAt(index) == '-') {
			pre = -1;
			preNum++;
			index++;
		} else {
			if (str.charAt(index) == '+') {
				pre = 1;
				preNum++;
				index++;
			} else {
				if (str.charAt(index) > '9' || str.charAt(index) < '0')
					return 0;
			}
		}

		if (index >= str.length() || preNum > 1) {
			return 0;
		}

		for (int i = index; i < str.length(); i++) {
			if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
				if(i>12){
					result = 2147483648L;
					break;
				}
				result = result * 10 + str.charAt(i) - '0';
			} else {
				break;
			}

		}

		if (result >= 2147483647 && pre == 1) {
			return Integer.MAX_VALUE;
		}
		if (result >= 2147483648L && pre == -1) {
			return Integer.MIN_VALUE;
		}
		result = result * pre;
		return (int) result;
	}

	public static void main(String[] args) {
		Sub8_StringtoInteger sub = new Sub8_StringtoInteger();
		// System.out.println(Integer.valueOf("  -0012a42"));
		System.out.println(sub.myAtoi("1111"));
		System.out.println(sub.myAtoi("+-2"));
		System.out.println(sub.myAtoi("+"));
		System.out.println(sub.myAtoi("2147483647"));
		int i = 2147483647;
		i++;
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MIN_VALUE);
		System.out.println(sub.myAtoi("2147483648"));
		System.out.println(sub.myAtoi("9223372036854775809"));
	}
}
