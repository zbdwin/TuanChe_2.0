package com.bwf.tuanche.tuancheDetial.carDetial;


import android.graphics.Bitmap;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.bean.UserBean;
import com.bwf.framwork.http.HttpCallBack;
import com.bwf.framwork.http.HttpHelper;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;
import com.zhy.http.okhttp.callback.BitmapCallback;

import okhttp3.Call;


/**
 * 购车流程
 */
public class DetialFragment4 extends BaseFragment {
    private WebView wb_image;

    @Override
    protected int getResource() {
        return R.layout.fragment_detial_fragment4;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {

    }

    @Override
    protected void initData() {
        wb_image=findViewByIdNoCast(R.id.wb_image);
        getData();

    }
    public void getData(){
        wb_image.loadUrl(UrlUtils.BUY_CAR_LIUCHENG);
        wb_image.setWebViewClient(new MyWebViewClient());

    }


    @Override
    public void onClick(View view) {

    }
    public class MyWebViewClient extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return false;
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
