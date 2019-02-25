package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AccountSelection extends AppCompatActivity {

    Button newPatientOption, newDoctorOption;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account_selection);

        newPatientOption = findViewById(R.id.new_patient_option);
        newPatientOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerPatient = new Intent(getApplicationContext(), PatientRegistration.class);
                startActivity(registerPatient);
            }
        });

        newDoctorOption = findViewById(R.id.new_doctor_option);
        newDoctorOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerDoctor = new Intent(getApplicationContext(), DoctorRegistration.class);
                startActivity(registerDoctor);
            }
        });
    }
}
