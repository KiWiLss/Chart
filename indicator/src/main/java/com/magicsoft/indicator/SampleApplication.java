package com.magicsoft.indicator;

import android.app.Application;

import shortbread.Shortbread;

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Shortbread.create(this);
    }
}
