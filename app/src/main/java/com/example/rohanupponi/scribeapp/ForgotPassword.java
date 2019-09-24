package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {
    private EditText recoveryEmailField;
    private Button passwordResetButton;
    private FirebaseAuth passRecoverAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        passRecoverAuth = FirebaseAuth.getInstance();

        passwordResetButton = findViewById(R.id.password_recovery_button);
        passwordResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recoveryEmailField = findViewById(R.id.password_recovery_email_field);
                String recoveryEmail = recoveryEmailField.getText().toString().trim();
                if (recoveryEmail.matches("")) {
                    Toast enterEmail = Toast.makeText(getApplicationContext(), "Please enter an email.", Toast.LENGTH_LONG);
                    enterEmail.show();
                    return;
                }
                passRecoverAuth.sendPasswordResetEmail(recoveryEmail).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            Toast successfulReset = Toast.makeText(getApplicationContext(), "Reset email successfully sent! Please check your provided email.", Toast.LENGTH_LONG);
                            Intent returnToLogin = new Intent(getApplicationContext(), LoginPage.class);
                            successfulReset.show();
                            startActivity(returnToLogin);
                        }
                        else {
                            Toast failedReset = Toast.makeText(getApplicationContext(), "It seems something went wrong. Please check your connectivity and ensure the email is valid.", Toast.LENGTH_LONG);
                            failedReset.show();
                        }
                    }
                });
            }
        });
    }
}
