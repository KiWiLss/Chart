package com.magicsoft.chart;

import android.app.Application;
import android.content.Context;

import com.magicsoft.chart.utils.DisplayUtils;


/**
 * <pre>
 *     author : Lss winding
 *     e-mail : kiwilss@163.com
 *     time   : 2018/1/12
 *     desc   : ${DESCRIPTION}
 *     version: ${VERSION}
 * </pre>
 */


public class MyApp extends Application {

    private static Context mApplicationContext;
    public static int mHeightPixels;//屏幕高度
    public static int mWidthPixels;//屏幕宽度



    @Override
    public void onCreate() {
        super.onCreate();
            mHeightPixels = DisplayUtils.getScreenHeight(this);
            mWidthPixels = DisplayUtils.getScreenWidth(this);
        mApplicationContext = getApplicationContext();

    }



    public static Context getContext(){
        return mApplicationContext;
    }
}
