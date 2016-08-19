package com.bwf.tuanche;

import android.app.Application;
import android.content.Context;

import com.bwf.framwork.bean.CarDetialResultBean1;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.umeng.socialize.PlatformConfig;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/**
 * Created by Lizhangfeng on 2016/8/16 0016.
 * Description:
 */
public class MyApplication extends Application {

    private static MyApplication myApplication;
    private CarDetialResultBean1 resultBean1;

    @Override
    public void onCreate() {
        super.onCreate();
        myApplication = this;

        //初始化facebook
        Fresco.initialize(this);
        //初始化okhttp
        initOkhttp();
        //初始化QQ平台
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");//appKey,appSecret

    }

    /**
     * 初始化okhttp
     */
    public void initOkhttp(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(10000L, TimeUnit.MILLISECONDS)
                .readTimeout(10000L, TimeUnit.MILLISECONDS)
                //其他配置
                .build();

        OkHttpUtils.initClient(okHttpClient);
    }

    public static MyApplication getMyApplication() {
        return myApplication;
    }

    public static Context getAppContext(){
        return myApplication.getApplicationContext();
    }

    public CarDetialResultBean1 getResultBean1() {
        return resultBean1;
    }

    public void setResultBean1(CarDetialResultBean1 resultBean1) {
        this.resultBean1 = resultBean1;
    }
}
