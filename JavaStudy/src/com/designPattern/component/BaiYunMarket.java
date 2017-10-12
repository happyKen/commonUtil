package com.designPattern.component;
/**
 * 组件，分店
* @ClassName: BaiYunMarket 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 上午10:10:43 
*
 */
public class BaiYunMarket extends Market{
	
	public BaiYunMarket(String name) {
		this.name = name;
	}
	
	@Override
	public void add(Market m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Market m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println(name + "消费了");
	}

}
