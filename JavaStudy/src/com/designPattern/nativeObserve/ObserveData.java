package com.designPattern.nativeObserve;
/**
 * 
* @ClassName: ObserveData 
* 被观察的数据
* @author wangzekeng
* @date 2016年12月12日 下午3:26:35 
*
 */
public class ObserveData {
	private String description;

	public String getDescription() {
		return description;
	}

	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString() {
		return " [description=" + description + "]";
	}


}
