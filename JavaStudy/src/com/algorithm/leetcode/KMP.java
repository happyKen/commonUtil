package com.algorithm.leetcode;

public class KMP {
	public int getIndex(String text,String module){
		//next
		int[] next = new int[module.length()];
		next[0] = -1;
		for(int i = 1;i<module.length();i++){
			int j = next[i-1];
			while(module.charAt(i) != module.charAt(j+1) && j>=0){
				j = next[j];
				
			}
			if(module.charAt(i) == module.charAt(j+1)){
				next[i] = j+1;
			}else{
				next[i] = -1;
			}
		}
		for(int x : next){
			System.out.println("next:"+ x + " ");
		}
		
		
		//find
		int i =0;
		int j =0;
		while(i<text.length() && j<module.length()){
			if(text.charAt(i) == module.charAt(j)){
				i++;
				j++;
			}else{
				if(j == 0){
					i++;
				}else{
					j = next[j-1]+1;
				}
			}
		}
		return j == module.length() ? (i-j+1) : -1;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			KMP kmp = new KMP();
			int x= kmp.getIndex("bacbababadababacambabacaddababacasdsd", "ababaca");
			System.out.println("index:"+ x);
	}
}
