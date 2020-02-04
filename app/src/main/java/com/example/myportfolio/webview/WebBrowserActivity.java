package com.example.myportfolio.webview;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.example.myportfolio.R;
import com.example.myportfolio.databinding.ActivityWebBrowserBinding;

public class WebBrowserActivity extends AppCompatActivity {

    String toolbarTitle = "", cloneUrl = "";
    ActivityWebBrowserBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_web_browser);

        setSupportActionBar(mBinding.headerLayout.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        toolbarTitle = getIntent().getStringExtra("title");
        cloneUrl = getIntent().getStringExtra("redirect_url");

        mBinding.setTitle(toolbarTitle);

        WebSettings webSettings = mBinding.webLayout.webView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mBinding.webLayout.webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mBinding.webLayout.webView.loadUrl(cloneUrl);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_BACK) && mBinding.webLayout.webView.canGoBack()) {
            mBinding.webLayout.webView.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    public void onBackPressed() {
        if (mBinding.webLayout.webView.canGoBack()) {
            mBinding.webLayout.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
