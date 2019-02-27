package com.example.rohanupponi.scribeapp;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
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

public class PatientHome extends AppCompatActivity {
    public static final String TAG = "PatientHome";

    private FloatingActionButton patientEditProfile;
    private TextView greetingTitle;
    private TextView patientName, patientEmail, patientAddress, patientCity, patientState, patientZip;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_home);
        patientEditProfile = findViewById(R.id.Patient_Edit_Profile);
        patientEditProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent openProfile = new Intent(getApplicationContext(), PatientProfile.class);
                startActivity(openProfile);
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


    }
}
