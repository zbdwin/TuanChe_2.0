package com.bwf.tuanche;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.base.BaseBean;
import com.bwf.framwork.base.ReccleViewAdapter;
import com.bwf.framwork.bean.UserBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.homepage.HomePage_FmentTitlebar01;
import com.bwf.tuanche.homepage.entity.Cheap_car_home;
import com.bwf.tuanche.homepage.entity.Cheap_car_home_result;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements Handler.Callback {
    private HomePage_FmentTitlebar01 homePage_fmentTitlebar01;
    private Cheap_car_home_result cheap_car_home_result;
    private String cityId = "156";
    private boolean isBack = true;
    private Handler handler;

    @Override
    public int getContentViewId() {
        return R.layout.activity_main;
    }

    @Override
    public void beforeInitView() {
        handler = new Handler(this);
    }

    @Override
    public void initView() {
        homePage_fmentTitlebar01 = (HomePage_FmentTitlebar01) getSupportFragmentManager().findFragmentById(R.id.homopagement01);
    }

    @Override
    public void initData() {
        HttpHelper.getTopBrand(cityId, new HttpCallBack<Cheap_car_home_result>() {


            @Override
            public void onSuccess(Cheap_car_home_result result) {

            }

            @Override
            public void onFail(String errMsg) {

            }
        });
    }

    @Override
    public void onClick(View view) {

    }


    /**
     * 按下监听
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (event.getAction() == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_BACK) {//按下返回键

            if (isBack) {
                ToastUtil.showToast("再次点击退出");
                isBack = false;
                handler.sendEmptyMessageDelayed(1, 3000);
            } else {
                //退出app
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public boolean handleMessage(Message message) {

        switch (message.what) {
            case 1:
                isBack = true;
                break;
        }

        return false;
    }
}
