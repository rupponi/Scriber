package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Map;

public class PatientHome extends AppCompatActivity {

    static DocumentSnapshot patientData;
    private FloatingActionButton editProfileButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String[] patientCreds = getIntent().getStringArrayExtra("patient_creds");

        db.collection("patients").document(patientCreds[0]).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    patientData = task.getResult();

                    ViewPager viewPager = findViewById(R.id.view_pager);
                    viewPager.setAdapter(new MainViewPagerAdapter(getSupportFragmentManager()));

                    TabLayout profileTabs = findViewById(R.id.profile_tabs);
                    profileTabs.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.unselectedTab), ContextCompat.getColor(getApplicationContext(), R.color.selectedTab));

                    profileTabs.setupWithViewPager(viewPager);
                }
                else {
                    Toast dataAccessFailure = Toast.makeText(getApplicationContext(), "Your profile is currently unavailable.", Toast.LENGTH_LONG);
                    dataAccessFailure.show();
                    Intent returnToLogin = new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(returnToLogin);
                    return;
                }
            }
        });

        editProfileButton = findViewById(R.id.edit_profile_button);
        editProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent editProfile = new Intent(getApplicationContext(), PatientProfile.class);
                startActivity(editProfile);
            }
        });


    }
}
