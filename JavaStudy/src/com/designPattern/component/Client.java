
package com.designPattern.component;

import javax.swing.text.Position.Bias;
/**
 * 组合模式
* @ClassName: Client 
* @Description: TODO
* @author wangzekeng
* @date 2017年10月12日 上午10:11:57 
*
 */
public class Client {
	public static void main(String[] args) {
		GuangzhouMarket guangzhouMarket = new GuangzhouMarket("广州");
		TianHeMarket tianHeMarket = new TianHeMarket("天河分店");
		BaiYunMarket baiYunMarket = new BaiYunMarket("白云分店");
		guangzhouMarket.add(tianHeMarket);
		guangzhouMarket.add(baiYunMarket);
		guangzhouMarket.pay();
	}
}
