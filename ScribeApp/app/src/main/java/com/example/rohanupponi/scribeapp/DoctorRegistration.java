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

public class DoctorRegistration extends AppCompatActivity {
    public static final String TAG = "DoctorRegistration";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_registration);

        Button doctorRegisterButton = (Button) findViewById(R.id.new_doctor_button);
        doctorRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText namefield = (EditText) findViewById(R.id.new_doctor_name_field);
                EditText emailfield = (EditText) findViewById(R.id.new_doctor_email_field);
                EditText passwordfield = (EditText) findViewById(R.id.new_doctor_password);
                EditText passwordconfirmfield = (EditText) findViewById(R.id.new_doctor_password_confirm);

                String name = namefield.getText().toString();
                String email = emailfield.getText().toString();
                String password = passwordfield.getText().toString();
                String passwordconfirm = passwordconfirmfield.getText().toString();

                FirebaseAuth doctorRegisterAuth = FirebaseAuth.getInstance();
                doctorRegisterAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(DoctorRegistration.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> register) {
                        if (register.isSuccessful()) {
                            Toast test = Toast.makeText(getApplicationContext(), "Congrats you can now log in on your new account!", Toast.LENGTH_LONG);
                            test.show();
                            Intent redirectToDoctorLogin = new Intent(getApplicationContext(), DoctorLogin.class);
                            startActivity(redirectToDoctorLogin);
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
