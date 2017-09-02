

import java.util.HashMap;

public class MapTest {
	public MapTest(){
	HashMap<String, String> sensitiveWordMap = new HashMap(100);     //初始化敏感词容器，减少扩容操作  
	HashMap nowMap = sensitiveWordMap;
	HashMap  newWorMap = new HashMap<String,String>();
     newWorMap.put("isEnd", "0");     //不是最后一个  
     nowMap.put("中", newWorMap);  
    // nowMap = newWorMap;  
	}
}
