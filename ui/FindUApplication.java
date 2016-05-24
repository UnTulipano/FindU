package com.iteam.findu.ui;

import android.app.Application;

import com.amap.api.location.AMapLocation;

/**
 * Created by 宇轩 on 2016/5/3.
 */
public class FindUApplication extends Application {

    public static AMapLocation aMapLocation = null;

    @Override
    public void onCreate() {
        super.onCreate();
    }
}
