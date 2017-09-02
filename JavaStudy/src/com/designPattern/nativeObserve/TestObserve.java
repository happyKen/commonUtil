package com.designPattern.nativeObserve;
/**
 * 
* @ClassName: 观察者模式的使用 
* 创建被观察者，通过被观察者注册观察者。生成数据，传入被观察者的通知方法。
* @author wangzekeng
* @date 2016年12月12日 下午3:25:17 
*
 */
public class TestObserve {
	public static void main(String[] args) {
		Observable<ObserveData> mObservable = new Observable<ObserveData>();
		Observe<ObserveData> observe1 = new Observe<ObserveData>() {

			@Override
			public void update(Observable<ObserveData> observable,
					ObserveData data) {
				// TODO Auto-generated method stub
				System.out.println("观察者1:" + data.toString());
			}
		};

		Observe<ObserveData> observe2 = new Observe<ObserveData>() {

			@Override
			public void update(Observable<ObserveData> observable,
					ObserveData data) {
				// TODO Auto-generated method stub
				System.out.println("观察者2:" + data.toString());
			}
		};
		
		mObservable.register(observe1);
		mObservable.register(observe2);
		
		ObserveData data1 = new ObserveData();
		data1.setDescription("太阳出来了");
		mObservable.notifyObservers(data1);
		
		ObserveData data2 = new ObserveData();
		data2.setDescription("下雨了");
		mObservable.unRegister(observe2);
		mObservable.notifyObservers(data2);
	}
}
