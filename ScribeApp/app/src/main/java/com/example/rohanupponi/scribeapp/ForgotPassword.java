package com.example.rohanupponi.scribeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText recoveryEmailField;
    private Button passwordResetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        passwordResetButton = findViewById(R.id.password_recovery_button);
        passwordResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoveryEmailField = findViewById(R.id.password_recovery_email_field);
            }
        });
    }
}
