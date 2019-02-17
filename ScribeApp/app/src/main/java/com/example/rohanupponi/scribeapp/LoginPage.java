package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.io.IOException;

public class LoginPage extends AppCompatActivity {
    public static final String TAG = "LoginPage";
    private String[] user_creds = new String[2];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        Button loginButton = (Button) findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText emailfield = findViewById(R.id.login_email);
                EditText passwordfield = findViewById(R.id.login_password);

                String email = emailfield.getText().toString().trim();
                String password = passwordfield.getText().toString().trim();

                user_creds[0] = email;

                FirebaseAuth loginAuth = FirebaseAuth.getInstance();
                loginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> authenticate) {
                        if (authenticate.isSuccessful()) {
                            Log.d(LoginPage.TAG, "Credentials valid.");
                            FirebaseFirestore db = FirebaseFirestore.getInstance();

                            CollectionReference patients = db.collection("patients");
                            Query patientExists = patients.whereEqualTo("email", user_creds[0]);

                            CollectionReference doctors = db.collection("doctors");
                            Query doctorExists = doctors.whereEqualTo("email", user_creds[0]);


                            if (patientExists != null) {
                                Intent loginPatient = new Intent(getApplicationContext(), PatientHome.class);
                                loginPatient.putExtra("patient_creds", user_creds);
                                startActivity(loginPatient);
                            }
                            else if (doctorExists != null) {
                                Intent loginDoctor = new Intent(getApplicationContext(), DoctorHome.class);
                                loginDoctor.putExtra("doctor_creds", user_creds);
                                startActivity(loginDoctor);
                            }
                            else {
                                Toast missingData = Toast.makeText(getApplicationContext(), "Error: Could not match credentials with account", Toast.LENGTH_LONG);
                                missingData.show();
                            }
                        }
                        else {
                            Toast failure = Toast.makeText(getApplicationContext(), "Failure!", Toast.LENGTH_LONG);
                            failure.show();
                        }
                    }
                });

            }
        });
    }

}
