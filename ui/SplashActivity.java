package com.iteam.findu.ui;

import android.os.Bundle;
import android.os.Handler;

import com.iteam.findu.R;
import com.iteam.findu.ui.base.BaseActivity;

public class SplashActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
               //添加判断条件
                if (null == null) {
                    startActivity(MainActivity.class, null, true);
                } else {
                    startActivity(MainActivity.class, null, true);
                }
            }
        }, 1000);
    }
}
