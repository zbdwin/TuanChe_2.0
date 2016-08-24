package com.bwf.tuanche.homepage.version_Message;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.LogUtils;
import com.bwf.framwork.utils.ToastUtil;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;
import com.bwf.tuanche.homepage.entity.VersionUpadteServlet;

/**
 * Created by wanli on 2016/8/22.
 * Description:
 * 首页更新页面显示的页面
 *
 */
public class VersionCode_pop extends PopupWindow implements View.OnClickListener {
    private TextView relatupdatanow;
    private WebView VersionCodeview;
    private TextView updatatextView;
    private TextView updatetimer1;
    private TextView updatatextViewdemo;
    private ImageView updatadiss;
    private String c;
    private CountDownTimer timer =new CountDownTimer(6000,1000) {
        @Override
        public void onTick(long l) {
            updatetimer1.setText("剩余更新时间"+(l / 1000)+"秒");
        }

        @Override
        public void onFinish() {
            updatetimer1.setEnabled(true);
        }
    };

    public VersionCode_pop(Context context) {
        this(context, null);
    }

    public VersionCode_pop(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public VersionCode_pop(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    public void init(Context context) {

        View view = View.inflate(context, R.layout.updata_pop_test, null);
        updatadiss = (ImageView) view.findViewById(R.id.updatadiss);
        updatadiss.setOnClickListener(this);
        relatupdatanow = (TextView) view.findViewById(R.id.relatupdatanow);
        VersionCodeview = (WebView) view.findViewById(R.id.VersionCodeview);
        updatatextView = (TextView) view.findViewById(R.id.updatatextView);
        updatatextViewdemo = (TextView) view.findViewById(R.id.updatatextViewdemo);
        updatetimer1 = (TextView) view.findViewById(R.id.updatetimer1);
        relatupdatanow.setOnClickListener(this);
        this.setContentView(view);
        this.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setHeight(ViewGroup.LayoutParams.MATCH_PARENT);
        this.setBackgroundDrawable(new BitmapDrawable());
        this.setFocusable(true);
        this.setOutsideTouchable(false);
        getdata();
    }

    public void show(View view, int gravity, int x, int y) {
        if (!isShowing()) {
            showAtLocation(view, gravity, x, y);
            timer.start();
        }
    }



    public void getdata() {

        HttpHelper.getVersionUpadteServlet(new HttpCallBack<VersionUpadteServlet>() {
            @Override
            public void onSuccess(VersionUpadteServlet result) {
                c=result.url;
//                VersionCodeview.loadUrl(result.url);
//                relatupdatanow.setText(result.description);
                updatatextView.setText(result.description);
                updatatextViewdemo.setText(result.versionName);
            }

            @Override
            public void onFail(String errMsg) {
                LogUtils.e("++" + errMsg.toString());
            }
        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.relatupdatanow:
                ToastUtil.showToast("立即更新应用");
                VersionCodeview.loadUrl(c);
                break;
            case R.id.updatadiss:
                this.dismiss();
                break;
        }
    }
}
