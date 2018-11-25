package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class DoctorLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        Button doctorLoginButton = (Button) findViewById(R.id.doctor_login_button);
        doctorLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: Login functionality to add later (Firebase authentication).
                EditText emailfield = (EditText) findViewById(R.id.doctor_email);
                EditText emailpass = (EditText) findViewById(R.id.doctor_password);
                String email = emailfield.getText().toString();
                String pass = emailpass.getText().toString();

                FirebaseAuth doctorSignInAuth = FirebaseAuth.getInstance();
            }
        });


        Button doctorForgotPassButton = (Button) findViewById(R.id.doctor_forgot_password_button);
        doctorForgotPassButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent doctorRecoverAccount = new Intent(getApplicationContext(), DoctorForgotPassword.class);
                startActivity(doctorRecoverAccount);
            }
        });


        Button doctorRegisterButton = (Button) findViewById(R.id.doctor_register_button);
        doctorRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent registerDoctor = new Intent(getApplicationContext(), DoctorRegistration.class);
                startActivity(registerDoctor);
            }
        });
    }
}
