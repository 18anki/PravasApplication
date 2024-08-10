package com.example.pravas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.Button;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Bundle;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;



/*public class login12 extends AppCompatActivity {
    private EditText mEmailField;
    private EditText mPasswordField;
    private Button buttonLogin;
    TextView opts;
    FirebaseAuth fAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login12);
        // Login page activity
        //public class login12 extends AppCompatActivity {



            /*@Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_login12);*/

       /* mEmailField = findViewById(R.id.email);
        mPasswordField = findViewById(R.id.Password);
        buttonLogin = findViewById(R.id.buttonlogin);
        //opts = (TextView) findViewById(R.id.textViewSignUp);
        opts = findViewById(R.id.textViewSignUp);


        // Set up the login button
        buttonLogin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Intent intent = new Intent(login12.this, Ticket.class);
                startActivity(intent);

                    String email = mEmailField.getText().toString();
                    String password = mPasswordField.getText().toString();
                    if (TextUtils.isEmpty(email)) {
                        mEmailField.setError(" Email is Required ");
                        return;
                    }
                    if (TextUtils.isEmpty(password)) {
                        mPasswordField.setError(" Password is Required ");
                        return;
                    }
                    if (password.length() < 6) {
                        mPasswordField.setError(" password must be greater than 6 characters");
                        return;
                    }

                    // Sign in the user with the entered email and password
                    signIn(email, password);
            }
        });
    }

    private void signIn(String email, String password) {
        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        // Sign in the user with the entered email and password
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    // Sign-in successful
                    Toast.makeText(login12.this, "Sign-in successful", Toast.LENGTH_SHORT).show();

                    // Go to the main activity
                    Intent intent = new Intent(login12.this, Ticket.class);
                    startActivity(intent);
                    finish();
                } else {
                    // Sign-in failed
                    Toast.makeText(login12.this, "Sign-in failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });

        opts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(login12.this, signup.class);
                startActivity(intent);
               // startActivity(new Intent(getApplicationContext(), signup.class));
            }
        });
    }
}*/
       public class login12 extends AppCompatActivity {
           private EditText mEmailField;
           private EditText mPasswordField;
           private Button buttonLogin;
           private TextView opts;
           private FirebaseAuth fAuth;

           @Override
           protected void onCreate(Bundle savedInstanceState) {
               super.onCreate(savedInstanceState);
               setContentView(R.layout.activity_login12);

               mEmailField = findViewById(R.id.email);
               mPasswordField = findViewById(R.id.Password);
               buttonLogin = findViewById(R.id.buttonlogin);
               opts = findViewById(R.id.textViewSignUp);

               fAuth = FirebaseAuth.getInstance();

               buttonLogin.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View view) {
                       String email = mEmailField.getText().toString();
                       String password = mPasswordField.getText().toString();

                       if (TextUtils.isEmpty(email)) {
                           mEmailField.setError("Email is Required");
                           return;
                       }

                       if (TextUtils.isEmpty(password)) {
                           mPasswordField.setError("Password is Required");
                           return;
                       }

                       if (password.length() < 6) {
                           mPasswordField.setError("Password must be greater than 6 characters");
                           return;
                       }

                       // Sign in the user with the entered email and password
                       signIn(email, password);
                   }
               });

               opts.setOnClickListener(new View.OnClickListener() {
                   @Override
                   public void onClick(View v) {
                       Intent intent = new Intent(login12.this, signup.class);
                       startActivity(intent);
                   }
               });
           }

           private void signIn(String email, String password) {
               fAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                   @Override
                   public void onComplete(@NonNull Task<AuthResult> task) {
                       if (task.isSuccessful()) {
                           // Sign-in successful
                           Toast.makeText(login12.this, "Sign-in successful", Toast.LENGTH_SHORT).show();

                           // Go to the main activity
                           Intent intent = new Intent(login12.this, Ticket.class);
                           startActivity(intent);
                           finish();
                       } else {
                           // Sign-in failed
                           Toast.makeText(login12.this, "Sign-in failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }
               });
           }
       }



