package com.iteam.findu.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.util.Log;

import com.amap.api.location.AMapLocation;
import com.amap.api.location.AMapLocationClient;
import com.amap.api.location.AMapLocationClientOption;
import com.amap.api.location.AMapLocationListener;
import com.iteam.findu.Util.Utils;
import com.iteam.findu.ui.FindUApplication;

public class ClockService extends Service implements AMapLocationListener {

    private static final String TAG = "ClockService";
    private int TIME_Linster = 15000;
    public static StringBuffer sb = new StringBuffer(256);

    private AMapLocationClient locationClient = null;
    private AMapLocationClientOption locationOption = null;

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "ClockService start");

//        handler.postDelayed(runnable, TIME); //每隔8s执行
//        EventBus.getDefault().register(this);
//        handler_search.postDelayed(runnable_search, TIME_Linster); //每隔8s执行
//        showNotification();

        initLocation();
    }


    private void initLocation(){

        locationClient = new AMapLocationClient(this.getApplicationContext());
        locationOption = new AMapLocationClientOption();
        // 设置定位模式为高精度模式
        locationOption.setLocationMode(AMapLocationClientOption.AMapLocationMode.Hight_Accuracy);
        // 设置定位监听
        locationClient.setLocationListener(this);
        //设置是否只定位一次,默认为false
        locationOption.setOnceLocation(false);



        // 设置是否需要显示地址信息
        locationOption.setNeedAddress(true);
        /**
         * 设置是否优先返回GPS定位结果，如果30秒内GPS没有返回定位结果则进行网络定位
         * 注意：只有在高精度模式下的单次定位有效，其他方式无效
         */
        locationOption.setGpsFirst(true);

        //设置是否允许模拟位置,默认为false，不允许模拟位置
        locationOption.setMockEnable(true);

        //设置是否强制刷新WIFI，默认为强制刷新
        locationOption.setWifiActiveScan(true);

        locationOption.setInterval(5000);


        // 设置定位参数
        locationClient.setLocationOption(locationOption);
        // 启动定位
        locationClient.startLocation();

    }



    @Override
    public void onLocationChanged(AMapLocation aMapLocation) {
        if (null != aMapLocation) {
            //更新全局变量
            FindUApplication.aMapLocation = aMapLocation;
            android.os.Message msg = mHandler.obtainMessage();
            msg.obj = aMapLocation;
            msg.what = Utils.MSG_LOCATION_FINISH;
            mHandler.sendMessage(msg);
        }

    }

    Handler mHandler = new Handler() {
        public void dispatchMessage(android.os.Message msg) {

            switch (msg.what) {
                //开始定位
                case Utils.MSG_LOCATION_START:
                    //   tvReult.setText("正在定位...");
                    break;
                // 定位完成
                case Utils.MSG_LOCATION_FINISH:
                    AMapLocation loc = (AMapLocation) msg.obj;
                    String result = Utils.getLocationStr(loc);
                    Log.i(TAG, result);
//                    DBUtils.saveLocMsg(getApplicationContext(), loc);

                    break;
                //停止定位
                case Utils.MSG_LOCATION_STOP:
                    //  tvReult.setText("定位停止");
                    break;
                default:
                    break;
            }
        };
    };

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (null != locationClient) {
            /**
             * 如果AMapLocationClient是在当前Activity实例化的，
             * 在Activity的onDestroy中一定要执行AMapLocationClient的onDestroy
             */
            locationClient.onDestroy();
            locationClient = null;
            locationOption = null;
        }
        FindUApplication.aMapLocation = null;
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }


}
