package com.common.myutil;

import com.common.myutil.exmple.ParcelableUser;
import com.common.myutil.exmple.SerializableUser;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }
    @Test
    public void Stest() throws  Exception {
        //序列化测试
        SerializableUser user = new SerializableUser();
        user.name = "wangze";
        user.age = 23;
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cache.txt"));
            outputStream.writeObject(user);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cache.txt"));
        SerializableUser user2 = (SerializableUser) objectInputStream.readObject();
        System.out.println("name:" + user2.name + "   age:" + user2.age);


//        ParcelableUser user3 = new ParcelableUser("wangze2",222,"man");
//        user3.name = "wangze2";
//        user3.age = 222;
//        user3.sex = "man";

//        try {
//            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("cache.txt"));
//            outputStream.writeObject(user3);
//        }catch (Exception e){
//            System.out.println(e.getMessage());
//        }
//
//        ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("cache.txt"));
//        ParcelableUser user4 = (ParcelableUser) objectInputStream.readObject();
//        System.out.println("name:"+ user4.name + "   age:" + user4.age + "  sex:" + user4.sex);
//
//    }
    }
}