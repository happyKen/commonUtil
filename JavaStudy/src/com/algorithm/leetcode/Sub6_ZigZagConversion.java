package com.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Sub6_ZigZagConversion {
	public String convert(String s, int numRows) {
		if(numRows == 1){
			return s;
		}
        int key = 1;
        int add = 1;
        StringBuffer result = new StringBuffer("");
        Map<Integer,StringBuffer> map = new HashMap<Integer,StringBuffer>();
        StringBuffer str ;
        for(int i = 0 ;i< s.length(); i++){
            if(map.containsKey(key)){
                str = map.get(key).append(s.charAt(i));
            }else{
            	str =new StringBuffer(""+s.charAt(i));
            }
            map.put(key,str);
            key = key + add;
            if(key == 1){
                add = 1;
            }
            if(key == numRows){
                add = -1;
            }
        }
        for(int i = 1;i<=numRows;i++){
        	if(map.get(i)!=null)
        		result.append(map.get(i));
        }
        return result.toString();
    }
	
	public static void main(String[] args) {
		Sub6_ZigZagConversion sub = new Sub6_ZigZagConversion();
		System.out.println(sub.convert("PAYPALISHIRING", 3));
		System.out.println(sub.convert("A", 2));
	}
}
