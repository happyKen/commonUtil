package com.designPattern.component;
/**
 * 组件，分店
* @ClassName: TianHeMarket 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 上午10:11:02 
*
 */
public class TianHeMarket extends Market {

	public TianHeMarket(String name) {
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
		System.out.println(name + "消费了");
	}

}
