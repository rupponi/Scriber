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
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientLogin extends AppCompatActivity {
    public static final String TAG = "PatientLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_login);

        Button patientLoginButton = (Button) findViewById(R.id.patient_login_button);
        patientLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: Patient login authentication (Firebase).
                EditText emailfield = (EditText) findViewById(R.id.patient_username);
                EditText emailpass = (EditText) findViewById(R.id.patient_password);
                String email = emailfield.getText().toString();
                String password = emailpass.getText().toString();

                FirebaseAuth patientLoginAuth = FirebaseAuth.getInstance();
                patientLoginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(PatientLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> authenticate) {
                        if (authenticate.isSuccessful()) {
                            Log.d(PatientLogin.TAG, "Sign in: Successful");
                            Toast test = Toast.makeText(getApplicationContext(), "Sign in: Successful", Toast.LENGTH_LONG);
                            test.show();
                        }
                        else {
                            Log.d(PatientLogin.TAG, "Sign in: Failure");
                            Toast test = Toast.makeText(getApplicationContext(), "Sign in: Failure", Toast.LENGTH_LONG);
                            test.show();
                        }
                    }
                });

            }
        });

        Button patientForgotPassButton = (Button) findViewById(R.id.patient_forgot_password_button);
        patientForgotPassButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent patientRecoverAccount = new Intent(getApplicationContext(), PatientForgotPassword.class);
                startActivity(patientRecoverAccount);
            }
        });


        Button patientRegisterButton = (Button) findViewById(R.id.patient_register_button);
        patientRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent registerPatient = new Intent(getApplicationContext(), PatientRegistration.class);
                startActivity(registerPatient);
            }
        });

    }
}
