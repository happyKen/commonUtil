package com.algorithm.sort;
/*
 * 希尔排序
 * 时间复杂度：
 * 最好：0（n）
 * 最坏：0（n^2）
 * 平均：0（n^1.3）
 * 稳定性：不稳定
 */
public class ShellSort {
	 public static void main(String arg[]){
	    	int [] a ={10,2,4,7,15,8,9,1};
	    	ShellSort.sort2(a, a.length);
	    	for(int v:a){
	    		System.out.print(" "+v);
	    	}
	    }
	 public static void sort(int [] array,int n){
		 int gap,i,j;
		 for( gap=n / 2;gap>0;gap /= 2){//步长再递减
			 for(i=0;i<gap;i++){//循环每一组
				 for(j=i+gap;j<n;j+=gap){//每组的元素
					 if(array[j]<array[j-gap]){
					 //直接插入
				   int temp = array[j];  
					 int key = j-gap;
					 while(key>=0 && array[key]>temp ){
						 array[key+gap]=array[key];
						 key-=gap;
					 }
					 array[key+gap] =temp;
					 
				 }
				 }
			 }
		 }
	 }
	public static void sort2(int a[], int n)  
	 {  
		int j, gap;  
	      
	    for (gap = n / 2; gap > 0; gap /= 2)  
	        for (j = gap; j < n; j++)//从数组第gap个元素开始  
	            if (a[j] < a[j - gap])//每个元素与自己组内的数据进行直接插入排序  
	            {  
	                int temp = a[j];  
	                int k = j - gap;  
	                while (k >= 0 && a[k] > temp)  
	                {  
	                    a[k + gap] = a[k];  
	                    k -= gap;  
	                }  
	                a[k + gap] = temp;  
	            }  
	 }
}
