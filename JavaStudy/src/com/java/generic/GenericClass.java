package com.java.generic;

/**
 * 泛型类
* @ClassName: GenericClass 
* @Description: TODO
* @author wangzekeng
* @date 2017年9月12日 下午3:17:20 
*
 */
public class GenericClass {

    public static void main(String[] args) {
        Box<String> name = new Box<String>("test");
        System.out.println("name:" + name.getData());
    }
    
    /*
     * 泛型类
     * 在类后面加<>，T是类型变量，可以多个类型变量<T,V>。
     * 类型变量多用大写字母表示
     * 用变量E表示集合的元素类型
     * K和V分别表示关键字与值的类型。
     * 字母U和S表示“任意类型”。
     */
    
    static class Box<T> {

        private T data;//T设定成员变量类型

        public Box() {

        }

        public Box(T data) {
            this.data = data;
        }

        public T getData() {
            return data;
        }

    }
}

