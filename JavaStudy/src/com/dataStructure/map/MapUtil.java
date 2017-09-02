package com.dataStructure.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeMap;

public class MapUtil {
	public static void main(String [] args){
		MapUtil mHashMapUtil = new MapUtil();
		//hashmap键值都可为空，但键重复时会覆盖之前的值,hashtable键和值都不能为空但线程安全
		mHashMapUtil.add(null,null);
		mHashMapUtil.add("a", "aaaa");
		mHashMapUtil.add("a", "aaaa");
		mHashMapUtil.add("c", "ccc");
		mHashMapUtil.add("v", "bbb");
		mHashMapUtil.add("f", "ddd");
		
		mHashMapUtil.iterator();
	}
   private HashMap<String,String> mHashMap = null;
   private Hashtable<String, String>mHashtable = null;
   private TreeMap<String, String>mTreeMap = null;
   public MapUtil(){
	   mHashMap = new HashMap<String, String>();
	   mHashtable = new Hashtable<String, String>();
	   mTreeMap = new TreeMap<String, String>();
   }
   //hashtable,hashmap循环输出,输出顺序与进出次序无关,key无大小次序,treeMap key大小有序
   public void iterator(){
	  // Iterator iterator = mHashMap.keySet().iterator();
	  // Iterator iterator = mHashtable.keySet().iterator();
	   Iterator iterator = mTreeMap.keySet().iterator();
	   
	   while(iterator.hasNext()){
		   Object key = iterator.next();
		  // System.out.println("key:"+key+"  value:"+mHashMap.get(key));
		 //  System.out.println("key:"+key+"  value:"+mHashtable.get(key));
		   System.out.println("key:"+key+"  value:"+mTreeMap.get(key));
	   }
   }
   //hashmap用put添加
   public void add(String key,String value){
	 //  mHashMap.put(key, value);
	 //  mHashtable.put(key, value);
	   mTreeMap.put(key, value);
   }
   //用remove删除
   public void delete(String key){
	   mHashMap.remove(key);
	   //mHashMap.
   }
   //是否包含某个键,不能用get方法判断，在value为null时get方法也是null
   public boolean isExist(String key){
	   return mHashMap.containsKey(key);
	   
   }

  
}
