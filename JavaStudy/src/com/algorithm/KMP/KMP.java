package com.algorithm.KMP;
/**
 * 
* @ClassName: KMP 
* @Description: 
* KMP算法	
* 时间复杂度:0（n）
* 主串不回溯，最多比较n次（主串长度），所以时间复杂度为0（n）
* @author wangzekeng
* @date 2016年12月9日 上午10:12:36 
*
 */
public class KMP {
	 public static void main(String[] args){  
		 String S = "BBC ABCDAB ABCDABCDABDE";//主串
		 String T = "ABCDAB";//匹配串
	        KMP kmp=new KMP(S, T);  //计算next数组	          
	        kmp.printNext();  //输出next数组
	        int theLoc=kmp.getIndexOfStr();  //获得匹配位置	          
	        System.out.println();  
	        System.out.println("匹配位置在："+theLoc);  	          
	    }  	      
	    private int[] next=null;  //next数组
	    private String S=null;   //主串
	    private String T=null;  //子串   
	   
	    public KMP(String S,String T){  
	        this.S=S;  
	        this.T=T;  
	        next=next();
	    }  
	    /** 
	     * 计算next 数组的值。 
	     * next数组的值为对称位的下标（从0开始），没有对称的设置为-1
	     * next求值核心是：继承
	     * */  	    
	     public int[] next(){
	    	 if(T==null || T.length()<=0){
	    		 return null;//先检测是否空或者为""
	    	 }else{
	    		 int next[] = new int[T.length()];
	    		 next[0]=-1;//第一位一定为-1
	    		 for(int i=1;i<T.length();i++){//从第二位开始起
	    			 int j = next[i-1];//j的值与当当前位前一位的next有关
	    			 char T_j = T.charAt(j+1);
	    			 char T_m = T.charAt(i);
	    			/*
	    			 * 由于当前位的next继承前一位的next，当前一位的next不为-1时，比较当前位与前一位next+1的值，相等则加1
	    			 * 不相等则在找出更小的对称性
	    			 */
	    			 while(T_j!=T_m&&j>=0){
	    				j=next[j];
	    				T_j = T.charAt(j+1);
	    			 }
	    			 if(T_m == T_j){
	    				 next[i] = j+1;
	    			 }
	    			 else{
	    				 next[i]=-1;
	    			 }
	    		 }
	    		 return next;
	    	 }  	
	     }
	     public void printNext(){  
	         if(next!=null){  
	             System.out.println("next array的值：");  
	             for(int tmp:next){  
	                 System.out.print(tmp+"   ");  
	             }  
	         }  
	     }  
	       /*
	        * 获取匹配位置
	        */
	       public int getIndexOfStr(){
		        int i = 0;
		        int j =0;
		        char sChar;
		        char tChar;
		        /*
		         * 当主串到达尾部时，判断子串是否到达尾部，到达则求出子串在主串的位置，否为为-1
		         * 位置：子串第一个字符在主串的位置=主串匹配位-子串长度
		         */
		        while(i<S.length() && j<T.length()){
		        	sChar = S.charAt(i);
		        	tChar = T.charAt(j);
		        	if(sChar == tChar){//匹配时都递增
		        		i++;
		        		j++;
		        	}else{
		        		//不匹配时判断子串位置，若为第一位主串加一位，不是的话按next跳转
		        		if(j==0){
		        			i++;
		        		}else{
		        		j=next[j-1]+1;//跳转到前一位的next加1
		        		}
		        	}     	
		        }
		        return (j==T.length())?(i-j):-1;
	       }		
}
