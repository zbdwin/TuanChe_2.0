package com.bwf.framwork.base;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.drawable.AnimationDrawable;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;

import com.bwf.framwork.tools.AppManager;
import com.bwf.tuanche.R;

/**
 * Created by Lizhangfeng on 2016/7/13 0013.
 * Description: Activity基本
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(getContentViewId());

        //如果存在actionBar，就隐藏
        if (getSupportActionBar() != null)
            getSupportActionBar().hide();
        AppManager.getInstance().addActivity(this);

        setTranslucentStatus();

        beforeInitView();
        initView();
        initData();

    }

    public abstract int getContentViewId();//放layoutId

    public abstract void beforeInitView();//初始化View之前做的事

    public abstract void initView();//初始化View

    public abstract void initData();//初始化数据

    /**
     * 状态栏透明只有Android 4.4 以上才支持
     */
    public void setTranslucentStatus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            WindowManager.LayoutParams layoutParams = window.getAttributes();
            layoutParams.flags |= WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
            window.setAttributes(layoutParams);
        }
    }

    /**
     * 不用强制转换的findviewbyid
     *
     * @param id
     * @param <T>
     * @return
     */
    public <T extends View> T findViewByIdNoCast(int id) {
        return (T) findViewById(id);
    }

    public void setOnClick(int... ids) {
        for (int id : ids)
            findViewById(id).setOnClickListener(this);

    }

    public void setOnClick(View... views) {
        for (View view : views)
            view.setOnClickListener(this);

    }
private Dialog dialog;

    /**
     * dialog的显示和消失
     */
    public  void showProgressbar(){
        if (dialog==null)
            dialog=new Dialog(this, android.R.style.Theme_DeviceDefault_Dialog_NoActionBar);
        View view=View.inflate(this, R.layout.show_progressbar,null);
        dialog.setContentView(view);
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        ImageView imageView= (ImageView) view.findViewById(R.id.iv_progress);
        AnimationDrawable drawable= (AnimationDrawable) imageView.getDrawable();
        drawable.start();
            dialog.show();
    }
    public void dissmissProgressbar(){
        if (dialog!=null&&dialog.isShowing()){
            dialog.dismiss();
        }
    }


    /**
     * 本段代码用来处理如果输入法还显示的话就消失掉输入键盘
     */
    protected void dismissSoftKeyboard(Activity activity) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(),
                    InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 显示键盘
     *
     * @param view
     */
    protected void showKeyboard(View view) {
        try {
            InputMethodManager inputMethodManage = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
            inputMethodManage.showSoftInput(view, InputMethodManager.SHOW_FORCED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onDestroy() {
        AppManager.getInstance().remove(this);
        super.onDestroy();
    }
}
