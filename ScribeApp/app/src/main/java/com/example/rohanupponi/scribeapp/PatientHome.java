package com.example.rohanupponi.scribeapp;

import android.net.Uri;

import android.support.annotation.NonNull;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.content.Intent;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;


public class PatientHome extends AppCompatActivity implements PersonalTab.OnFragmentInteractionListener, MedicalTab.OnFragmentInteractionListener, NotesTab.OnFragmentInteractionListener {
    public static final String TAG = "PatientHome";

    private FloatingActionButton patientEditProfile;
    Button PatientLogout;

    private TextView greetingTitle;
    private TextView patientName, patientEmail, patientAddress, patientCity, patientState, patientZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);

        TabLayout tabLayout = (TabLayout)findViewById(R.id.tablayout);
        tabLayout.addTab(tabLayout.newTab().setText("Personal"));
        tabLayout.addTab(tabLayout.newTab().setText("Medical"));
        tabLayout.addTab(tabLayout.newTab().setText("Notes"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager)findViewById(R.id.pager);
        final PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager(),tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });


        FirebaseFirestore db = FirebaseFirestore.getInstance();
        String[] patientCreds = getIntent().getStringArrayExtra("patient_creds");

        greetingTitle = findViewById(R.id.patient_greeting);
        patientName = findViewById(R.id.patient_name);
        patientEmail = findViewById(R.id.patient_email);
        patientAddress = findViewById(R.id.patient_address);
        patientCity = findViewById(R.id.patient_city);
        patientState = findViewById(R.id.patient_state);
        patientZip = findViewById(R.id.patient_zip);

        db.collection("patients").document(patientCreds[0]).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()) {
                    // Acquire all fields.
                    String name = task.getResult().get("name").toString();
                    String nameGreeting = "Welcome " + name + "!";
                    String email = task.getResult().getId();
                    String address = task.getResult().get("street-address").toString();
                    String city = task.getResult().get("city").toString();
                    String state = task.getResult().get("state").toString();
                    String zip = task.getResult().get("zip-code").toString();

                    // Set all textviews.
                    greetingTitle.setText(nameGreeting);
                    patientName.setText("Name: " + name);
                    patientEmail.setText("Email: " + email);
                    patientAddress.setText("Address: " + address);
                    patientCity.setText("City: " + city);
                    patientState.setText("State: " + state);
                    patientZip.setText("ZIP: " + zip);
                }
                else {
                    Toast retry = Toast.makeText(getApplicationContext(), "Sorry we could not retrieve your data at this time.", Toast.LENGTH_LONG);
                    retry.show();
                    Intent returnToLogin = new Intent(getApplicationContext(), LoginPage.class);
                    startActivity(returnToLogin);
                }
            }
        });


        patientEditProfile = findViewById(R.id.Patient_Edit_Profile);
        patientEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openProfile = new Intent(getApplicationContext(), PatientProfile.class);
                startActivity(openProfile);
            }
        });

        PatientLogout = findViewById(R.id.logoutButton);
        PatientLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Logout = new Intent(getApplicationContext(), LoginPage.class);
                startActivity(Logout);

            }

        });

    }

    @Override
    public void onFragmentInteraction(Uri uri) {


    }
}





