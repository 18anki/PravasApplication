package com.example.pravas;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Spinner;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.view.View;
import android.widget.AdapterView;

import androidx.appcompat.app.AppCompatActivity;

public class Ticket extends AppCompatActivity {
    Spinner spinnerFrom, spinnerTo, spinnerpay;
    Button btnConfirm;
    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        spinnerpay = findViewById(R.id.spinnerpay);
        btnConfirm = findViewById(R.id.btnConfirm);
        text1 = findViewById(R.id.textViewAmount);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.from_array,
                android.R.layout.simple_spinner_item
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerFrom.setAdapter(adapter);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.to_array,
                android.R.layout.simple_spinner_item
        );
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTo.setAdapter(adapter1);

        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(
                this,
                R.array.SEATS_array,
                android.R.layout.simple_spinner_item
        );
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerpay.setAdapter(adapter2);

        updateAmount();

        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateAmount();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Do nothing
            }
        });

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int seatCount = Integer.parseInt(spinnerpay.getSelectedItem().toString());
                updateAmount();
                Intent intent = new Intent(Ticket.this, paymentgateway.class);
                startActivity(intent);
            }
        });
    }

    private void updateAmount() {
        String from = spinnerFrom.getSelectedItem().toString();
        String to = spinnerTo.getSelectedItem().toString();

        int amount = getAmount(from, to);
        String amountText = "Amount: Rs " + amount;
        text1.setText(amountText);
    }

    private int getAmount(String from, String to) {
        int basePrice = 20;
        int priceIncrement = 10;

        int fromIndex = getLocationIndex(from);
        int toIndex = getLocationIndex(to);

        if (fromIndex == -1 || toIndex == -1) {
            return 0;
        }

        int locationsDifference = Math.abs(fromIndex - toIndex);

        return (basePrice + locationsDifference * priceIncrement);
    }

    private int getLocationIndex(String location) {
        String[] fromArray = getResources().getStringArray(R.array.from_array);
        for (int i = 0; i < fromArray.length; i++) {
            if (fromArray[i].equalsIgnoreCase(location)) {
                return i;
            }
        }
        String[] toArray = getResources().getStringArray(R.array.to_array);
        for (int j = 0; j < toArray.length; j++) {
            if (toArray[j].equalsIgnoreCase(location)) {
                return j;
            }
        }
        return -1;
    }
}