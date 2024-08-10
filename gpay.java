package com.example.pravas;

import android.os.Bundle;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

public class gpay extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gpay);
        WebView mywebview = (WebView) findViewById(R.id.webview1);
        mywebview.loadUrl("https://pay.google.com");


    }
}