package com.common.myutil.exmple;

import android.os.Parcel;
import android.os.Parcelable;

/**
 *
 * Parcelable接口一般用于intent的数据传输，而不使用在本地存储对象，因为在外界变化下，Parcelable不能保证数据的持续化
 * Created by wangzekeng on 2017/9/8.
 */

public class ParcelableUser implements Parcelable {
    public String name;
    public int age;
    public String sex;
    public ParcelableUser(){};
    public ParcelableUser( String name,int age,String sex){
        this.name = name;
        this.age = age;
        this.sex = sex;
    };
    protected ParcelableUser(Parcel in) {
        // 读取Parcel里面数据时必须按照成员变量声明的顺序
        this.name = in.readString();
        this.age = in.readInt();
        this.sex = in.readString();
    }

    public static final Creator<ParcelableUser> CREATOR = new Creator<ParcelableUser>() {
        @Override
        public ParcelableUser createFromParcel(Parcel in) {
            return new ParcelableUser(in);
        }

        @Override
        public ParcelableUser[] newArray(int size) {
            return new ParcelableUser[size];
        }
    };

    @Override
    public int describeContents() {
        //描述内容，没什么用
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        // 序列化过程：必须按成员变量声明的顺序进行封装
        dest.writeString(this.name);
        dest.writeInt(this.age);
        dest.writeString(this.sex);
    }
}
