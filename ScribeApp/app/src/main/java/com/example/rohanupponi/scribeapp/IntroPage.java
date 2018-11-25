package com.example.rohanupponi.scribeapp;

import android.content.Intent;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class IntroPage extends AppCompatActivity {
    public static final String TAG = "IntroPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro_page);

        Button patientOptionButton = (Button) findViewById(R.id.patient_option);
        patientOptionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent toPatientLogin = new Intent(getApplicationContext(), PatientLogin.class);
                startActivity(toPatientLogin);
            }
        });

        Button doctorOptionButton = (Button) findViewById(R.id.doctor_option);
        doctorOptionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent toDoctorLogin = new Intent(getApplicationContext(), DoctorLogin.class);
                startActivity(toDoctorLogin);
            }
        });
    }
}