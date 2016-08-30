package com.bwf.tuanche.tuancheDetial;


import android.os.Build;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.bwf.framwork.base.BaseActivity;
import com.bwf.framwork.utils.DrawableUtils;
import com.bwf.framwork.utils.IntentUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;

public class OrderActivity extends BaseActivity {
    private TextView tv_quicklydenglu, tv_zhanghaodenglu;
    private EditText et_shuru_phone, et_shuru_yanzhengma;
    private Button bt_huoqu_yanzhenma, bt_denlu_yanzhen;
    private ImageButton ib_back;

    @Override
    public int getContentViewId() {
        return R.layout.activity_order;
    }

    @Override
    public void beforeInitView() {

    }

    @Override
    public void initView() {
        tv_quicklydenglu = findViewByIdNoCast(R.id.tv_quicklydenglu);
        tv_zhanghaodenglu = findViewByIdNoCast(R.id.tv_zhanghaodenglu);
        et_shuru_phone = findViewByIdNoCast(R.id.et_shuru_phone);
        et_shuru_yanzhengma = findViewByIdNoCast(R.id.et_shuru_yanzhengma);
        bt_huoqu_yanzhenma = findViewByIdNoCast(R.id.bt_huoqu_yanzhenma);
        bt_denlu_yanzhen = findViewByIdNoCast(R.id.bt_denlu_yanzhen);
        ib_back = findViewByIdNoCast(R.id.ib_back);
        setOnClick(tv_quicklydenglu, tv_zhanghaodenglu, bt_huoqu_yanzhenma
                , bt_denlu_yanzhen, ib_back);

    }

    @Override
    public void initData() {

        et_shuru_phone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_shuru_phone.getText().length()>0&&et_shuru_phone.getText().length()<11){
                    DrawableUtils.drawableRight(OrderActivity.this,et_shuru_phone,R.mipmap.delete_icon);
                    DrawableUtils.drawableLeft(OrderActivity.this,et_shuru_phone,R.mipmap.icon_reg_tel_nor);
                }else if (et_shuru_phone.getText().length()==0){
                    DrawableUtils.drawableRight(OrderActivity.this,et_shuru_phone,R.mipmap.default_list_logo);
                    DrawableUtils.drawableLeft(OrderActivity.this,et_shuru_phone,R.mipmap.icon_reg_tel_nor);
                }
                if (et_shuru_phone.getText().length() == 11) {
                    bt_huoqu_yanzhenma.setEnabled(true);
                    DrawableUtils.drawableLeft(OrderActivity.this,et_shuru_phone,R.mipmap.icon_reg_tel_sel);
                } else if (et_shuru_phone.getText().length()<11){
                    bt_huoqu_yanzhenma.setEnabled(false);
                    DrawableUtils.drawableLeft(OrderActivity.this,et_shuru_phone,R.mipmap.icon_reg_tel_nor);
                }
                if (et_shuru_phone.getText().length() != 0 && et_shuru_yanzhengma.getText().length() != 0) {
                    bt_denlu_yanzhen.setEnabled(true);
                } else {
                    bt_denlu_yanzhen.setEnabled(false);
                }

            }
        });
        et_shuru_yanzhengma.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if (et_shuru_yanzhengma.getText().length() > 0) {
                    DrawableUtils.drawableLeft(OrderActivity.this,et_shuru_yanzhengma,R.mipmap.icon_reg_key_sel);
                    if (et_shuru_phone.getText().length() != 0 ) {
                        bt_denlu_yanzhen.setEnabled(true);
                    }

                } else {

                    DrawableUtils.drawableLeft(OrderActivity.this,et_shuru_yanzhengma,R.mipmap.icon_reg_key_nor);
                    bt_denlu_yanzhen.setEnabled(false);
                }

            }
        });


    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_quicklydenglu || view.getId() == R.id.tv_zhanghaodenglu) {
            tv_quicklydenglu.setTextColor(getResources().getColor(R.color.red));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tv_quicklydenglu.setBackground(getDrawable(R.mipmap.round_white_left));
                }
            }
            tv_zhanghaodenglu.setTextColor(getResources().getColor(R.color.red));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tv_zhanghaodenglu.setBackground(getDrawable(R.mipmap.round_white_right));
                }
            }
        }
        switch (view.getId()) {
            case R.id.tv_quicklydenglu:
                tv_quicklydenglu.setTextColor(getResources().getColor(R.color.withe));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        tv_quicklydenglu.setBackground(getDrawable(R.mipmap.round_red_left));
                    }
                }
                bt_huoqu_yanzhenma.setVisibility(View.VISIBLE);
                et_shuru_yanzhengma.setHint("请输入验证码");
                bt_denlu_yanzhen.setText("验证登录");

                break;
            case R.id.tv_zhanghaodenglu:
                tv_zhanghaodenglu.setTextColor(getResources().getColor(R.color.withe));
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        tv_zhanghaodenglu.setBackground(getDrawable(R.mipmap.round_red_right));
                    }
                }
                bt_huoqu_yanzhenma.setVisibility(View.GONE);
                et_shuru_yanzhengma.setHint("请输入密码");
                bt_denlu_yanzhen.setText("登录");
                break;
            case R.id.bt_huoqu_yanzhenma:
                ToastUtil.showToast("验证码");
                break;
            case R.id.bt_denlu_yanzhen:
                ToastUtil.showToast("验证登录");
                break;
            case R.id.ib_back:
                IntentUtils.openActivity(OrderActivity.this, MainActivity.class);
                break;


        }

    }
}
