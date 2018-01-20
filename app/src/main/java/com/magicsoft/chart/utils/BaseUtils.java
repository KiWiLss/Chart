package com.magicsoft.chart.utils;

public class BaseUtils {

    protected static String TAG;

    {
        TAG = this.getClass().getSimpleName();
    }

    protected BaseUtils() {
        throw new UnsupportedOperationException("You can't instantiate " + TAG + "...");
    }
}
