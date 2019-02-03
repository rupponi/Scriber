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

public class DoctorLogin extends AppCompatActivity {
    public static final String TAG = "DoctorLogin";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_login);

        Button doctorLoginButton = (Button) findViewById(R.id.doctor_login_button);
        doctorLoginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                // TODO: Login functionality to add later (Firebase authentication).
                EditText emailfield = (EditText) findViewById(R.id.doctor_email);
                EditText emailpass = (EditText) findViewById(R.id.doctor_password);
                String email = emailfield.getText().toString();
                String password = emailpass.getText().toString();

                FirebaseAuth doctorLoginAuth = FirebaseAuth.getInstance();
                doctorLoginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(DoctorLogin.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> authenticate) {
                        if (authenticate.isSuccessful()) {
                            Log.d(DoctorLogin.TAG, "Sign in: Successful");
                            Intent accessDoctorHome = new Intent (getApplicationContext(), DoctorHome.class);
                            startActivity(accessDoctorHome);
                        }
                        else {
                            Log.d(DoctorLogin.TAG, "Sign in: Failure");
                            Toast test = Toast.makeText(getApplicationContext(), "Sign in: Failure", Toast.LENGTH_LONG);
                            test.show();
                        }
                    }
                });
            }
        });


        Button doctorForgotPassButton = (Button) findViewById(R.id.doctor_forgot_password_button);
        doctorForgotPassButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent doctorRecoverAccount = new Intent(getApplicationContext(), DoctorForgotPassword.class);
                startActivity(doctorRecoverAccount);
            }
        });


        Button doctorRegisterButton = (Button) findViewById(R.id.doctor_register_button);
        doctorRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent registerDoctor = new Intent(getApplicationContext(), DoctorRegistration.class);
                startActivity(registerDoctor);
            }
        });
    }
}
