package com.bwf.tuanche.homepage.entity.adapter;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.bwf.framwork.utils.IntentUtils;
import com.bwf.tuanche.MainActivity;
import com.bwf.tuanche.R;

public class Wellcome_poster extends AppCompatActivity {
    private Handler handler;

    private WebView web_poster;
    private static final int WELL = 1001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wellcome_poster);

        web_poster = (WebView) findViewById(R.id.web_poster);


        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case WELL:
                        IntentUtils.openActivity(Wellcome_poster.this, MainActivity.class);
                        finish();
                        break;
                }
            }
        };
        info();
    }

    public void info() {
        web_poster.loadUrl("http://static.tuanche.com/ssg/h5/threetimes.html");
        WebSettings settings = web_poster.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setAppCacheMaxSize(8 * 1024 * 1024);
        web_poster.setWebViewClient(new Myweb());
        handler.sendEmptyMessageDelayed(WELL, 3000);

    }


    public class Myweb extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return false;
        }

    }
}
