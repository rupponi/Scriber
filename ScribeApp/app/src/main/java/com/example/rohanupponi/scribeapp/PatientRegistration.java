package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class PatientRegistration extends AppCompatActivity {
    public static final String TAG = "PatientRegistration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        Button patientRegisterButton = (Button) findViewById(R.id.new_patient_button);

        patientRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText namefield = (EditText) findViewById(R.id.new_patient_name_field);
                EditText emailfield = (EditText) findViewById(R.id.new_patient_email_field);
                EditText passwordfield = (EditText) findViewById(R.id.new_patient_password);
                EditText passwordconfirmfield = (EditText) findViewById(R.id.new_patient_password_confirm);
                String name = namefield.getText().toString();
                String email = emailfield.getText().toString();
                String password = passwordfield.getText().toString();
                String passwordconfirm = passwordconfirmfield.getText().toString();

                if (!password.equals(passwordconfirm)) {
                    Toast test = Toast.makeText(getApplicationContext(), "Error: Passwords don't match. Please make sure to confirm correct password.", Toast.LENGTH_LONG);
                    test.show();
                }

                FirebaseAuth patientRegisterAuth = FirebaseAuth.getInstance();
                patientRegisterAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(PatientRegistration.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> register) {
                        if (register.isSuccessful()) {
                            Toast test = Toast.makeText(getApplicationContext(), "Congrats you can now log in on your new account!", Toast.LENGTH_LONG);
                            test.show();
                            Intent redirectToPatientLogin = new Intent(getApplicationContext(), PatientLogin.class);
                            startActivity(redirectToPatientLogin);
                        }
                        else {
                            Toast test = Toast.makeText(getApplicationContext(), "Registration: Failure", Toast.LENGTH_LONG);
                            test.show();
                        }
                    }
                });
            }
        });

    }
}
