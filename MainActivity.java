package com.example.pravas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import pl.droidsonroids.gif.GifImageView;
public class MainActivity extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 1500; // Time in milliseconds (e.g., 3000ms = 3 seconds)
    public static String somed=" ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(MainActivity.this, login12.class);
                intent.putExtra("key", somed); // Make sure someData is not null


                startActivity(intent);
                finish();
            }
        }, SPLASH_TIME_OUT);


    }
}


