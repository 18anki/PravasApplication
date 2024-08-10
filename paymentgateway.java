package com.example.pravas;

import android.content.Intent;

import android.os.Bundle;


import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

public class paymentgateway extends AppCompatActivity {

    private static final String TAG = "PaymentGateway";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentgateway);

        Button btnGooglePay = findViewById(R.id.GPay);
        Button btnPhonePe = findViewById(R.id.PhonePe);

        btnGooglePay.setOnClickListener(v -> {

            Intent intent = new Intent(paymentgateway.this, gpay.class);
            startActivity(intent);
        });

        btnPhonePe.setOnClickListener(v -> {
            Intent intent = new Intent(paymentgateway.this, gpay.class);
            startActivity(intent);
        });
    }

}
