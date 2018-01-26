package com.magicsoft.indicator;

import android.os.Environment;
import android.util.Log;

import com.magicsoft.indicator.model.City;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/24
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class Utils {

    public static boolean getSDStatus(){
        String externalStorageState = Environment.getExternalStorageState();
        if (externalStorageState.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }




    {
        Log.e("MMM", "instance initializer: " );
    }

    static {
        mData = new ArrayList<>();
        Log.e("MMM", "static initializer: " );
    }
    private static ArrayList<String> mData;

    public static List<String> getData(int count){
        for (int i = 0; i < count; i++) {
            mData.add("data"+i);
        }
        return mData;
    }

    public static List<String>getDataTwo(){
        ArrayList<String> data = new ArrayList<>();
        data.add("一");
        data.add("二");
        data.add("三");
        data.add("四");
        return data;
    }

    public static List<City>getCityData(){
        ArrayList<City> list = new ArrayList<>();
        list.add(new City("杭州","浙江",R.mipmap.ic_launcher));
        list.add(new City("杭州","浙江",R.mipmap.ic_launcher));
        list.add(new City("杭州","浙江",R.mipmap.ic_launcher));
        list.add(new City("杭州","浙江",R.mipmap.ic_launcher));
        list.add(new City("杭州","浙江",R.mipmap.ic_launcher));
        list.add(new City("杭州","浙江",R.mipmap.ic_launcher));
        list.add(new City("苏州","江苏",R.mipmap.ic_launcher));
        list.add(new City("杭州","江苏",R.mipmap.ic_launcher));
        list.add(new City("杭州","江苏",R.mipmap.ic_launcher));
        list.add(new City("杭州","江苏",R.mipmap.ic_launcher));
        list.add(new City("杭州","江苏",R.mipmap.ic_launcher));
        list.add(new City("三亚","海南",R.mipmap.ic_launcher));
        list.add(new City("杭州","海南",R.mipmap.ic_launcher));
        list.add(new City("杭州","海南",R.mipmap.ic_launcher));
        list.add(new City("杭州","海南",R.mipmap.ic_launcher));
        list.add(new City("杭州","海南",R.mipmap.ic_launcher));
        list.add(new City("杭州","海南",R.mipmap.ic_launcher));
        list.add(new City("杭州","海南",R.mipmap.ic_launcher));
        return list;
    }

    public static List<City>getCityData2(){
        ArrayList<City> list = new ArrayList<>();
        list.add(new City("杭州","浙江",6));
        list.add(new City("杭州","浙江",5));
        list.add(new City("杭州","浙江",4));
        list.add(new City("杭州","浙江",3));
        list.add(new City("杭州","浙江",2));
        list.add(new City("杭州","浙江",1));
        list.add(new City("苏州","江苏",5));
        list.add(new City("杭州","江苏",4));
        list.add(new City("杭州","江苏",3));
        list.add(new City("杭州","江苏",2));
        list.add(new City("杭州","江苏",1));
        list.add(new City("三亚","海南",7));
        list.add(new City("杭州","海南",7));
        list.add(new City("杭州","海南",7));
        list.add(new City("杭州","海南",7));
        list.add(new City("杭州","海南",7));
        list.add(new City("杭州","海南",7));
        list.add(new City("杭州","海南",7));
        return list;
    }
}
