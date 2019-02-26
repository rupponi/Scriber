package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPage extends AppCompatActivity {
    public static final String TAG = "LoginPage";
    private String[] user_creds = new String[2];

    Button loginButton, signUpButton;
    TextView forgotPassLink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginButton = findViewById(R.id.login_button);
        signUpButton = findViewById(R.id.sign_up_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText emailfield = findViewById(R.id.login_email);
                EditText passwordfield = findViewById(R.id.login_password);

                String email = emailfield.getText().toString().trim();
                String password = passwordfield.getText().toString().trim();

                if (email.matches("")) {
                    Toast requestEmail = Toast.makeText(getApplicationContext(), "Please enter an email", Toast.LENGTH_LONG);
                    requestEmail.show();
                    return;
                }

                if (password.matches("")) {
                    Toast requestPassword = Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_LONG);
                    requestPassword.show();
                    return;
                }

                emailfield.getText().clear();
                passwordfield.getText().clear();

                user_creds[0] = email;

                final FirebaseAuth loginAuth = FirebaseAuth.getInstance();
                final FirebaseFirestore db = FirebaseFirestore.getInstance();


                loginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> authenticate) {
                        if (authenticate.isSuccessful()) {
                            Log.d(LoginPage.TAG, "Credentials valid.");
                            db.collection("patients").document(user_creds[0]).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot patientDoc = task.getResult();
                                        if (patientDoc.exists()) {
                                            Intent loginPatient = new Intent(getApplicationContext(), PatientHome.class);
                                            loginPatient.putExtra("patient_creds", user_creds);
                                            startActivity(loginPatient);
                                        }
                                        else {
                                            db.collection("doctors").document(user_creds[0]).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                                @Override
                                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                                    if (task.isSuccessful()) {
                                                        DocumentSnapshot doctorDoc = task.getResult();
                                                        if (doctorDoc.exists()) {
                                                            Intent loginDoctor = new Intent(getApplicationContext(), DoctorHome.class);
                                                            loginDoctor.putExtra("doctor_creds", user_creds);
                                                            startActivity(loginDoctor);
                                                        }
                                                        else {
                                                            Toast noData = Toast.makeText(getApplicationContext(), "Couldn't find user!", Toast.LENGTH_LONG);
                                                            noData.show();
                                                        }
                                                    }
                                                }
                                            });
                                        }
                                    }
                                }
                            });
                        }
                        else {
                            Log.d(LoginPage.TAG, "Credentials invalid.");
                            Toast failure = Toast.makeText(getApplicationContext(), "Failure!", Toast.LENGTH_LONG);
                            failure.show();
                        }
                        return;
                    }
                });

            }
        });

        forgotPassLink = findViewById(R.id.forgot_password_link);
        forgotPassLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent recoverUser = new Intent(getApplicationContext(), ForgotPassword.class);
                startActivity(recoverUser);
            }
        });


        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent registerUser = new Intent(getApplicationContext(), AccountSelection.class);
                startActivity(registerUser);
            }
        });

    }

}
