package com.example.rohanupponi.scribeapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class PatientHome extends AppCompatActivity {
    public static final String TAG = "PatientHome";

    private Button patientEditProfile;
    private Button patientLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        patientEditProfile = (Button) findViewById(R.id.Patient_Edit_Profile);
        patientEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openProfile = new Intent(getApplicationContext(), PatientProfile.class);
                startActivity(openProfile);
            }
        });

        patientLogout = (Button) findViewById(R.id.Patient_Logout);
        patientLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), PatientLogin.class);
                startActivity(intent);
            }
        });

    }
}
