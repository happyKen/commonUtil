package com.designPattern.component;

import java.util.ArrayList;
import java.util.List;
/**
 * 组件的集合，总店
* @ClassName: GuangzhouMarket 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 上午10:11:16 
*
 */
public class GuangzhouMarket extends Market{
	
	public GuangzhouMarket(String name) {
		this.name = name;
	}
	
	List<Market> list = new ArrayList<Market>();
	@Override
	public void add(Market m) {
		// TODO Auto-generated method stub
		list.add(m);
	}

	@Override
	public void remove(Market m) {
		// TODO Auto-generated method stub
		list.remove(m);
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		System.out.println(name+"消费了");
		for(Market m : list){
			m.pay();
		}
	}
	
}
