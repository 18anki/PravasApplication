package com.example.pravas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;

import android.widget.Button;
import android.widget.EditText;
import android.view.View;

import android.widget.Toast;
import android.widget.VideoView;
import android.net.Uri;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class signup extends AppCompatActivity {
    public static final String TAG = "TAG";


    Button signUpButton;
    EditText edittext1, edittext2, edittext3;

    FirebaseFirestore fstore;
    String userId;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);


        signUpButton = findViewById(R.id.buttonSignup);
        edittext1 = findViewById(R.id.Username);
        edittext2 = findViewById(R.id.email);
        edittext3 = findViewById(R.id.Password);


        fAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = edittext1.getText().toString();
                String email = edittext2.getText().toString();
                String password = edittext3.getText().toString();

                if (TextUtils.isEmpty(email)) {
                    edittext2.setError("Email is Required");
                    return;
                }

                if (TextUtils.isEmpty(password)) {
                    edittext3.setError("Password is Required");
                    return;
                }

                if (password.length() < 6) {
                    edittext3.setError("Password must be greater than 6 characters");
                    return;
                }

                fAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser fUser = fAuth.getCurrentUser();
                            fUser.sendEmailVerification().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Toast.makeText(getApplicationContext(), "Register Successful", Toast.LENGTH_SHORT).show();
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "Onfailure: Email is sent" + e.getMessage());
                                }
                            });

                            Toast.makeText(getApplicationContext(), "User Created", Toast.LENGTH_SHORT).show();
                            userId = fAuth.getCurrentUser().getUid();
                            DocumentReference df = fstore.collection("user").document(userId);
                            Map<String, Object> user = new HashMap<>();
                            user.put("Name", username);
                            user.put("Email", email);
                            df.set(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void unused) {
                                    Log.d(TAG, "onsuccess: User profile is created for " + userId);
                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.d(TAG, "onfailure: " + e);
                                }
                            });

                            startActivity(new Intent(getApplicationContext(), Ticket.class));
                            finish();

                        } else {
                            Toast.makeText(signup.this, "Error" + Objects.requireNonNull(task.getException()).getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        });
    }
}



