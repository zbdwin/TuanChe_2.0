package com.bwf.tuanche.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.R;

public class Home_service_message extends BaseActivity implements View.OnClickListener {
    private ImageView serviceimg01;//返回
    private TextView serviceimg02;//提交
    private TextView serviceedittext03;//剩余字数
    private LinearLayout servicelin;//选择意见内容
    private EditText serviceedittext01;//编辑返回的意见
    private EditText serviceedittext02;//编辑联系的电话号码



    @Override
    public int getContentViewId() {
        return R.layout.activity_home_service_message;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        serviceimg01 =findViewByIdNoCast(R.id.serviceimg01);
        serviceimg02 =findViewByIdNoCast(R.id.serviceimg02);
        servicelin =findViewByIdNoCast(R.id.servicelin);
        serviceedittext01 =findViewByIdNoCast(R.id.serviceedittext01);
        serviceedittext02 =findViewByIdNoCast(R.id.serviceedittext02);
        serviceedittext03 =findViewByIdNoCast(R.id.serviceedittext03);
        serviceimg01.setOnClickListener(this);
        serviceimg02.setOnClickListener(this);
        serviceedittext03.setOnClickListener(this);
        servicelin.setOnClickListener(this);
        serviceedittext01.setOnClickListener(this);
        serviceedittext02.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View view) {
switch (view.getId()){
    case R.id.serviceimg01:
        this.finish();
    break;
    case R.id.serviceimg02:
        if (serviceedittext01.getText().length()==0||serviceedittext02.getText().length()==0){
            ToastUtil.showToast("您提交的某一项内容为空");
        }else {
            ToastUtil.showToast("提交成功");
            this.finish();
        }
        break;
    case R.id.servicelin:
        break;
    case R.id.serviceedittext03:
        //剩余字数

        break;
    case R.id.serviceedittext01:
        serviceedittext01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                serviceedittext01.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        serviceedittext03.setText("剩余"+(200-serviceedittext01.getText().length())+"字");
                    }
                },100);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


        break;
    case R.id.serviceedittext02:
        break;
}
    }
}
