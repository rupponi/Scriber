package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PatientLogin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        Button patientLoginButton = (Button) findViewById(R.id.patient_login_button);
        patientLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: Patient login authentication (Firebase).
            }
        });

        Button patientForgotPassButton = (Button) findViewById(R.id.patient_forgot_password_button);
        patientForgotPassButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: Patient forgot password (Forgot password form to send email recovery).
            }
        });


        Button patientRegisterButton = (Button) findViewById(R.id.patient_register_button);
        patientRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent registerPatient = new Intent(PatientLogin.this, PatientRegistration.class);
                startActivity(registerPatient);
            }
        });

    }
}
