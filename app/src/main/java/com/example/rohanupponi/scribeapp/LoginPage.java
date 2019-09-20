package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

public class LoginPage extends AppCompatActivity {
    public static final String TAG = "LoginPage";
    private String[] userCreds = new String[2];

    Button loginButton, signUpButton;
    TextView forgotPassLink;
    ProgressBar progressBar;
    FirebaseAuth loginAuth;
    FirebaseUser foundUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginAuth = FirebaseAuth.getInstance();
        if (loginAuth.getCurrentUser() != null) {
            foundUser = loginAuth.getCurrentUser();
            userCreds[0] = foundUser.getEmail();
            Intent automaticLoginPatient = new Intent(getApplicationContext(), PatientHome.class);
            automaticLoginPatient.putExtra("patient_creds", userCreds);
            startActivity(automaticLoginPatient);
            return;
        }

        progressBar = findViewById(R.id.login_loader);
        progressBar.setVisibility(View.INVISIBLE);

        loginButton = findViewById(R.id.login_button);
        signUpButton = findViewById(R.id.sign_up_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                progressBar.setVisibility(View.VISIBLE);

                EditText emailfield = findViewById(R.id.login_email);
                EditText passwordfield = findViewById(R.id.login_password);

                String email = emailfield.getText().toString().trim();
                String password = passwordfield.getText().toString().trim();

                if (email.matches("")) {
                    progressBar.setVisibility(View.GONE);
                    Toast requestEmail = Toast.makeText(getApplicationContext(), "@str", Toast.LENGTH_LONG);
                    requestEmail.show();
                    return;
                }

                if (password.matches("")) {
                    progressBar.setVisibility(View.GONE);
                    Toast requestPassword = Toast.makeText(getApplicationContext(), "Please enter a password", Toast.LENGTH_LONG);
                    requestPassword.show();
                    return;
                }

                emailfield.getText().clear();
                passwordfield.getText().clear();

                userCreds[0] = email;

                final FirebaseFirestore db = FirebaseFirestore.getInstance();


                loginAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(LoginPage.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> authenticate) {
                        if (authenticate.isSuccessful()) {
                            Log.d(LoginPage.TAG, "Credentials valid.");
                            db.collection("patients").document(userCreds[0]).get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
                                @Override
                                public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                                    if (task.isSuccessful()) {
                                        DocumentSnapshot patientDoc = task.getResult();
                                        if (patientDoc.exists()) {
                                            progressBar.setVisibility(View.GONE);
                                            Intent loginPatient = new Intent(getApplicationContext(), PatientHome.class);
                                            loginPatient.putExtra("patient_creds", userCreds);
                                            startActivity(loginPatient);
                                        }
                                        else {
                                            progressBar.setVisibility(View.GONE);
                                            Log.d(LoginPage.TAG, "Couldn't find user in database");
                                            Toast failure = Toast.makeText(getApplicationContext(), "We apologize! Your profile is temporarily unavailable.", Toast.LENGTH_LONG);
                                            failure.show();
                                        }
                                    }
                                }
                            });
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast failure = Toast.makeText(getApplicationContext(), "Incorrect username or password.", Toast.LENGTH_LONG);
                            Log.d(LoginPage.TAG, "Credentials invalid.");
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
                Intent registerUser = new Intent(getApplicationContext(), PatientRegistration.class);
                startActivity(registerUser);
            }
        });

    }

}
