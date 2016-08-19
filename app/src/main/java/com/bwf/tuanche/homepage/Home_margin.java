package com.bwf.tuanche.homepage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import com.bwf.tuanche.R;

public class Home_margin extends AppCompatActivity {
    private WebView web_poster;
    private TextView dsafsdfasfasfa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_margin);
        web_poster = (WebView) findViewById(R.id.homemarginweb);
        dsafsdfasfasfa = (TextView) findViewById(R.id.dsafsdfasfasfa);
        web_poster.loadUrl("http://static.tuanche.com/ssg/h5/threetimes.html");
        WebSettings settings = web_poster.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAppCacheEnabled(true);
        settings.setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
        settings.setAppCacheMaxSize(8 * 1024 * 1024);
        web_poster.setWebViewClient(new Myweb());

        dsafsdfasfasfa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Home_margin.this.finish();
            }
        });
    }


    public class Myweb extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

            view.loadUrl(url);
            return false;
        }

    }
}
