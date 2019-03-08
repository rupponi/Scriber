package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class PatientRegistration extends AppCompatActivity {
    public static final String TAG = "PatientRegistration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        Button patientRegisterButton = (Button) findViewById(R.id.new_patient_button);

        patientRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText nameField = (EditText) findViewById(R.id.new_patient_name_field);
                EditText emailField = (EditText) findViewById(R.id.new_patient_email_field);

                EditText addressField = findViewById(R.id.new_patient_address_field);
                EditText cityField = findViewById(R.id.new_patient_city_field);
                EditText stateField = findViewById(R.id.new_patient_state_field);
                EditText zipField = findViewById(R.id.new_patient_zip_field);

                EditText passwordField = (EditText) findViewById(R.id.new_patient_password);
                EditText passwordConfirmField = (EditText) findViewById(R.id.new_patient_password_confirm);


                String name = nameField.getText().toString().trim();
                String email = emailField.getText().toString().trim();


                String address = addressField.getText().toString().trim();
                String city = cityField.getText().toString().trim();
                String state = stateField.getText().toString().trim();

                String sZip = zipField.getText().toString().trim();

                String password = passwordField.getText().toString().trim();
                String passwordConfirm = passwordConfirmField.getText().toString().trim();



                if (name.matches("") || email.matches("") || address.matches("") || city.matches("") || state.matches("") || sZip.matches("") || password.matches("") || passwordConfirm.matches("")) {
                    Toast incompleteInfo = Toast.makeText(getApplicationContext(), "Information incomplete!", Toast.LENGTH_LONG);
                    incompleteInfo.show();
                    return;
                }

                if (!password.equals(passwordConfirm)) {
                    Toast test = Toast.makeText(getApplicationContext(), "Error: Passwords don't match. Please make sure to confirm correct password.", Toast.LENGTH_LONG);
                    test.show();
                }

                FirebaseAuth patientRegisterAuth = FirebaseAuth.getInstance();
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                patientRegisterAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(PatientRegistration.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> register) {
                        if (register.isSuccessful()) {
                            return;
                        }
                        else {
                            Toast test = Toast.makeText(getApplicationContext(), "Registration: Failure to register credentials", Toast.LENGTH_LONG);
                            test.show();
                        }
                    }
                });

                Map<String, Object> newPatient = new HashMap<>();
                newPatient.put("name", name);
                newPatient.put("street-address", address);
                newPatient.put("city", city);
                newPatient.put("state", state);
                newPatient.put("zip-code", Integer.parseInt(sZip));

                newPatient.put("primary-phone", "-2" );
                newPatient.put("gender", "M/F");
                newPatient.put("date-of-birth", "-5");
                newPatient.put("marital-status","single/married/divorced");
                newPatient.put("ethnicity", "None");
                newPatient.put("primary-insurance","None");
                newPatient.put("primary-policy","0");
                newPatient.put("primary-group", "0");
                newPatient.put("secondary-insurance","None");
                newPatient.put("secondary-policy","0");
                newPatient.put("secondary-group", "0");
                newPatient.put("employer", "None");
                newPatient.put("employer-street", "None");
                newPatient.put("employer-city", "None");
                newPatient.put("employer-state","none");
                newPatient.put("employer-zip","00000");




                db.collection("patients").document(email).set(newPatient).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Log.d(PatientRegistration.TAG, "Successful registration of patient.");
                        Toast successfulRegistration = Toast.makeText(getApplicationContext(), "Congratulations! You are now registered!", Toast.LENGTH_LONG);
                        successfulRegistration.show();

                        Intent redirectToPatientLogin = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(redirectToPatientLogin);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(PatientRegistration.TAG, "Unsuccessful registration of patient.");
                        Toast failedRegistration = Toast.makeText(getApplicationContext(), "Oops! Looks like we had some issues in setting up your account!", Toast.LENGTH_LONG);
                        failedRegistration.show();

                        Intent redirectToPatientLogin = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(redirectToPatientLogin);
                    }
                });
            }
        });

    }
}
