package com.dataStructure.Enum;

/**
 * @ClassName: TestEnum
 * @Description: 枚举使用demo
 * @author wangzekeng
 * @date 2016年10月31日 下午2:38:56
 * 
 */
public class TestEnum {
	// 普通枚举
	public enum ColorEnum {
		red, blue, green, white;
	}

	// 枚举像普通的类一样可以添加属性和方法，可以为它添加静态和非静态的属性或方法
	public enum SeasonEnum {
		spring, summer, autumn, winter;
		private String position = "test";

		public SeasonEnum getSeason(String position) {
			if (position.equals(this.position)) {
				return spring;
			} else {
				return summer;
			}

		}
	}
   
	//带构造器
	public enum SexEnum{
		MAN("MAN value"), WOMAN("WOMAN value");
		private final String key;
		private SexEnum(String value) {
			// TODO Auto-generated constructor stub
			this.key = value;
		}
		public String getValue(){
			return this.key;
		}
	}
	
	//带抽象方法
	public enum OrderEnum{
		 /** 已取消 */
        CANCEL {public String getName(){return "已取消";}},
        /** 待审核 */
        WAITCONFIRM {public String getName(){return "待审核";}},
        /** 等待付款 */
        WAITPAYMENT {public String getName(){return "等待付款";}},
        /** 正在配货 */
        ADMEASUREPRODUCT {public String getName(){return "正在配货";}},
        /** 等待发货 */
        WAITDELIVER {public String getName(){return "等待发货";}},
        /** 已发货 */
        DELIVERED {public String getName(){return "已发货";}},
        /** 已收货 */
        RECEIVED {public String getName(){return "已收货";}};
        
        public abstract String getName();
	}
	
	public static void main(String args[]){
		ColorEnum color = ColorEnum.blue;
		/*
		 * 就是toString()的返回值 ,
		 * 默认的toString方法返回的就是枚举变量的名字，和name()方法返回值一样  
		 */
		System.out.println(color);
		SexEnum sex = SexEnum.MAN;
		System.out.println(sex.key);
		switch (color) {
		case blue:
			System.out.println("color is blue");
			break;
		case red:
			System.out.println("color is red");
			break;
		default: 
			break;
		}
		for(ColorEnum colorNext :ColorEnum.values()){
			System.out.println(colorNext);
		}
		System.out.println("===========");
        for(OrderEnum order : OrderEnum.values()){
            System.out.println(order.getName());
        }
    
	}
	
}
