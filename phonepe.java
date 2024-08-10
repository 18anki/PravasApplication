package com.example.pravas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class phonepe extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phonepe);
        WebView mywebview = (WebView) findViewById(R.id.webview2);
        mywebview.loadUrl("https://www.phonepe.com");
    }
}