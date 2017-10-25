package com.algorithm.leetcode;

public class Sub10_RegularExpressionMatching {
	public boolean isMatch(String s,String p){
		//s next
		int [] next = new int[s.length()];
		next[0] = -1;
		for(int i = 1; i<s.length();i++){
			int j = next[i-1];
			while(s.charAt(i) != s.charAt(j+1) && j>=0){
				j = next[j];
			}
			if(s.charAt(i) == s.charAt(j+1)){
				next[i] = j+1;
			}else{
				next[i] = -1;
			}
		}
		
		for(int x : next){
		System.out.println("next:" + x);
		}
		
		//find
		int i=0,j=0;
		while(i<s.length() && j <p.length()){
			if(s.charAt(i) == p.charAt(j)){
				i++;
				j++;
			}else{
				if(p.charAt(j) == '.' ){
					i++;
					j++;
				}else if(p.charAt(j) == '*'){
						int x = j-1;
						while(x>=0){
							if(s.charAt(i)==p.charAt(x) || p.charAt(x)=='.'){
								i++;
								j++;
								break;
							}else if(p.charAt(x) == '*'){
								x--;
							}else{//不匹配跳下一个next
								if(i == 0){
									j++;
								}else{
								i = next[i-1] +1;
								}
								break;
							}
						}
						
				}else{
					if(i == 0){
						j++;
					}else{
					i = next[i-1] +1;
					}
				}
			}
		}
		
		return i == s.length() ? true : false;
	}
	public static void main(String[] args) {
		Sub10_RegularExpressionMatching sub = new Sub10_RegularExpressionMatching();
		if(sub.isMatch("aaa", "aa")){
			System.out.println("is true");
		}
	}
}
