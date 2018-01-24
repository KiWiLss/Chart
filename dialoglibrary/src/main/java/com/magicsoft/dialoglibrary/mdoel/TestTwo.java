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


public class TestTwo implements Parcelable {

    String data;
    String msg;

    public TestTwo(String data, String msg) {
        this.data = data;
        this.msg = msg;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    protected TestTwo(Parcel in) {
        this.data=in.readString();
        this.msg=in.readString();
    }

    public static final Creator<TestTwo> CREATOR = new Creator<TestTwo>() {
        @Override
        public TestTwo createFromParcel(Parcel in) {
            return new TestTwo(in);
        }

        @Override
        public TestTwo[] newArray(int size) {
            return new TestTwo[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.data);
        parcel.writeString(this.msg);
    }

    @Override
    public String toString() {
        return "TestTwo{" +
                "data='" + data + '\'' +
                ", msg='" + msg + '\'' +
                '}';
    }
}
