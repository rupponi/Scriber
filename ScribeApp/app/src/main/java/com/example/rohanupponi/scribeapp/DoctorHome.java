package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class DoctorHome extends AppCompatActivity {
    private FloatingActionButton doctorEditProfile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_home);

        doctorEditProfile = findViewById(R.id.Doctor_Edit_Profile);
        doctorEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openProfile = new Intent(getApplicationContext(), DoctorProfile.class);
                startActivity(openProfile);
            }
        });
    }

}
