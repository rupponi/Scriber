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
    private String[] user_creds = new String[2];

    Button loginButton, signUpButton;
    TextView forgotPassLink;
    ProgressBar progressBar;
    FirebaseAuth loginAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        loginAuth = FirebaseAuth.getInstance();
        FirebaseUser loggedInUser;
        if (loginAuth.getCurrentUser() != null) {
            loggedInUser = loginAuth.getCurrentUser();
            user_creds[0] = loggedInUser.getEmail();
            Intent automaticLoginPatient = new Intent(getApplicationContext(), PatientHome.class);
            automaticLoginPatient.putExtra("patient_creds", user_creds);
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
                                            progressBar.setVisibility(View.GONE);
                                            Intent loginPatient = new Intent(getApplicationContext(), PatientHome.class);
                                            loginPatient.putExtra("patient_creds", user_creds);
                                            startActivity(loginPatient);
                                        }
                                        else {
                                            progressBar.setVisibility(View.GONE);
                                            Log.d(LoginPage.TAG, "Couldn't find user in database");
                                            Toast failure = Toast.makeText(getApplicationContext(), "Failure to find data!", Toast.LENGTH_LONG);
                                            failure.show();
                                        }
                                    }
                                }
                            });
                        }
                        else {
                            progressBar.setVisibility(View.GONE);
                            Toast failure = Toast.makeText(getApplicationContext(), "Failure to login!", Toast.LENGTH_LONG);
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
