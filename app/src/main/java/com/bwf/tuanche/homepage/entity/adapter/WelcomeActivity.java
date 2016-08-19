package com.bwf.tuanche.homepage.entity.adapter;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;

/**
 * Created by Cdy on 2016/8/16.
 * 欢迎界面
 */
public class WelcomeActivity extends Activity {
    boolean isFirstIn = false;
    private static final int GO_HOME = 1000;
    private static final int GO_GUIDE = 1001;
//    private static final int WellCOME = 1002;
    // 延迟3秒
    private static final long SPLASH_DELAY_MILLIS = 3000;
    private static final String SHAREDPREFERENCES_NAME = "first_pref";
    /**
     * Handler:跳转到不同界面
     */
    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case GO_GUIDE:
                    goGuide();
                    break;
                case GO_HOME:
                    goHome();
                    break;

            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        init();
    }

    private void init() {
        // 读取SharedPreferences中需要的数据
        // 使用SharedPreferences来记录程序的使用次数
        SharedPreferences preferences = getSharedPreferences(
                SHAREDPREFERENCES_NAME, MODE_PRIVATE);
        // 取得相应的值，如果没有该值，说明还未写入，用true作为默认值
        isFirstIn = preferences.getBoolean("isFirstIn", true);
        // 判断程序与第几次运行，如果是第一次运行则跳转到引导界面，否则跳转到主界面
        if (!isFirstIn) {
            // 使用Handler的postDelayed方法，3秒后执行跳转到MainActivity
            mHandler.sendEmptyMessageDelayed(GO_HOME, SPLASH_DELAY_MILLIS);
        } else {
            mHandler.sendEmptyMessageDelayed(GO_GUIDE, SPLASH_DELAY_MILLIS);
        }
    }

    private void goHome() {

//        IntentUtils.openActivity(this, MainActivity.class);
        IntentUtils.openActivity(this, Wellcome_poster.class);
//        mHandler.sendEmptyMessageDelayed(WellCOME,SPLASH_DELAY_MILLIS);

        this.finish();
    }

    private void goGuide() {
        Intent intent = new Intent(WelcomeActivity.this, GuideActivity.class);
        WelcomeActivity.this.startActivity(intent);
        WelcomeActivity.this.finish();
    }
}