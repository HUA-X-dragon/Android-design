package com.example.android_design;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Activity_webview extends AppCompatActivity {

    private String url;
    private WebView wv;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        Intent intent=getIntent();
        url = intent.getStringExtra("url");

        wv = (WebView) findViewById(R.id.web_v);
        wv.getSettings().setJavaScriptEnabled(true);//getSettiongs()用于设置一些浏览器属性，这里让WebView支持JavaScript脚本
        wv.setWebViewClient(new WebViewClient());//当需要从一个网页跳转到另一个网页是，希望目标网页仍然在当前WebView显示，而不是打开浏览器
        WebSettings settings = wv.getSettings();
        settings.setDomStorageEnabled(true);//开启DOM
        wv.loadUrl(url);
    }
}
