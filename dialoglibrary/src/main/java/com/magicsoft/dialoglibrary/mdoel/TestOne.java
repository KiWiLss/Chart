package com.magicsoft.dialoglibrary.mdoel;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/23
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class TestOne implements Parcelable {
    int data;
    String msg;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.data);
        dest.writeString(this.msg);
    }

    public TestOne(int data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public TestOne() {
    }

    protected TestOne(Parcel in) {
        this.data = in.readInt();
        this.msg = in.readString();
    }

    public static final Parcelable.Creator<TestOne> CREATOR = new Parcelable.Creator<TestOne>() {
        @Override
        public TestOne createFromParcel(Parcel source) {
            return new TestOne(source);
        }

        @Override
        public TestOne[] newArray(int size) {
            return new TestOne[size];
        }
    };

    @Override
    public String toString() {
        return "TestOne{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
