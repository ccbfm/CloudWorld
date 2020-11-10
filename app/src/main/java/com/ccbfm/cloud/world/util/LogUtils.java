package com.ccbfm.cloud.world.util;

import android.util.Log;

public class LogUtils {
    private static final boolean DEBUG = true;
    private static final String TAG = "CloudWorld";

    public static void w(String tag, String msg){
        if(DEBUG) {
            Log.w(TAG, tag + ">" + msg);
        }
    }

    public static void w(String tag, String msg, Throwable tr){
        if(DEBUG) {
            Log.w(TAG, tag + ">" + msg, tr);
        }
    }
}
