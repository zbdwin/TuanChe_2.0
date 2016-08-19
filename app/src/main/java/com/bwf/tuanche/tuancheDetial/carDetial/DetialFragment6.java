package com.bwf.tuanche.tuancheDetial.carDetial;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.framwork.base.BaseFragment;
import com.bwf.framwork.utils.UrlUtils;
import com.bwf.tuanche.R;

/**
 * 常见问题
 */
public class DetialFragment6 extends BaseFragment {
    private WebView wb_image_problem;

    @Override
    protected int getResource() {
        return R.layout.fragment_detial_fragment6;
    }

    @Override
    protected void beforeInitView() {

    }

    @Override
    protected void initView(View rootView) {
        wb_image_problem=findViewByIdNoCast(R.id.wb_image_problem);

    }

    @Override
    protected void initData() {
        wb_image_problem.loadUrl(UrlUtils.BUY_CAR_QUESTION);
        wb_image_problem.setWebViewClient(new MyWebViewClient());

    }

    @Override
    public void onClick(View view) {

    }
    public class MyWebViewClient extends WebViewClient {
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
