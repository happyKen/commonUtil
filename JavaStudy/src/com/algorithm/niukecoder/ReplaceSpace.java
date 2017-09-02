package com.algorithm.niukecoder;
/**
 * 
* @ClassName: ReplaceSpace 
* 题目：请实现一个函数，将一个字符串中的空格替换成“%20”。
* 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
* 
* 思路：扩大了原数组长度，从后往前移减少移动次数
* @author wangzekeng
* @date 2016年12月21日 上午10:10:46 
*
 */
public class ReplaceSpace {
    public static void main(String[] args){
    	
    }
    /*
     * 开辟新的stringbuffer，找到空格就添加%20，否则加原字符
     */
    public static String ReplaceSpace1(String s){
    	StringBuffer buf = new StringBuffer();
    	for(int i = 0;i<s.length();i++){
    		if(s.charAt(i) == ' '){
    			buf.append("%20");
    		}else{
    			buf.append(s.charAt(i));
    		}
    	}
    	return buf.toString();
    }
    /*
     * 无需开辟新的空间，直接在原字符串上扩展空间再从后到前插入
     */
    public String replaceSpace2(StringBuffer str) {
        int spacenum = 0;//spacenum为计算空格数
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)==' ')
                spacenum++;
        }
        int indexold = str.length()-1; //indexold为为替换前的str下标
        int newlength = str.length() + spacenum*2;//计算空格转换成%20之后的str长度
        int indexnew = newlength-1;//indexold为为把空格替换为%20后的str下标
        str.setLength(newlength);//使str的长度扩大到转换成%20之后的长度,防止下标越界
        for(;indexold>=0 && indexold<newlength;--indexold){ 
                if(str.charAt(indexold) == ' '){  //
                str.setCharAt(indexnew--, '0');
                str.setCharAt(indexnew--, '2');
                str.setCharAt(indexnew--, '%');
                }else{
                    str.setCharAt(indexnew--, str.charAt(indexold));
                }
        }
        return str.toString();
    }
}
