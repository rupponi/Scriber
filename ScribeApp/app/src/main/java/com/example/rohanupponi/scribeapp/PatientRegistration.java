package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;

public class PatientRegistration extends AppCompatActivity {
    public static final String TAG = "PatientRegistration";

    private EditText nameField, emailField, addressField, cityField, zipField,
                     passwordField, passwordConfirmField;
    private Spinner stateDropDown;
    private String name, email, address, city, sZip, password, passwordConfirm;
    private Map<String, Object> newPatient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_registration);

        Button patientRegisterButton = (Button) findViewById(R.id.new_patient_button);

//====== SET UP DROPDOWN FOR STATE CHOICES ===========================================================================//
        stateDropDown = findViewById(R.id.new_patient_state_spinner);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(PatientRegistration.this,
                R.array.states_array,
                R.layout.dropdown_layout
        );
        adapter.setDropDownViewResource(R.layout.dropdown_layout);
        stateDropDown.setAdapter(adapter);

        patientRegisterButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
//============== SET EDIT FIELDS TO VIEWS TO COLLECT DATA ============================================================//
                nameField = findViewById(R.id.new_patient_name_field);
                emailField = findViewById(R.id.new_patient_email_field);

                addressField = findViewById(R.id.new_patient_address_field);
                cityField = findViewById(R.id.new_patient_city_field);
                zipField = findViewById(R.id.new_patient_zip_field);

                passwordField = findViewById(R.id.new_patient_password);
                passwordConfirmField = findViewById(R.id.new_patient_password_confirm);
//====================================================================================================================//

//============== COLLECT DATA FROM TEXT FIELDS =======================================================================//
                name = nameField.getText().toString().trim();
                email = emailField.getText().toString().trim();


                address = addressField.getText().toString().trim();
                city = cityField.getText().toString().trim();

                List<String> stateChoices = Arrays.asList(getResources().getStringArray(R.array.states_array));
                State state = Utils.getState(stateChoices.indexOf(stateDropDown.getSelectedItem().toString()));

                sZip = zipField.getText().toString().trim();

                password = passwordField.getText().toString().trim();
                passwordConfirm = passwordConfirmField.getText().toString().trim();
//====================================================================================================================//

//============== IF A FIELD IS EMPTY, YOU SHALL NOT PASS =============================================================//
                if (name.matches("") ||email.matches("") || address.matches("") || city.matches("") || sZip.matches("") || password.matches("") || passwordConfirm.matches("")) {
                    Toast incompleteInfo = Toast.makeText(getApplicationContext(),
                            "Information incomplete!",
                            Toast.LENGTH_LONG
                    );
                    incompleteInfo.show();
                    return;
                }
//====================================================================================================================//

//============== IF PASSWORD ISN'T CONFIRMED PROPERLY, YOU SHALL NOT PASS ============================================//
                if (!password.equals(passwordConfirm)) {
                    Toast test = Toast.makeText(getApplicationContext(),
                            "Error: Passwords don't match. Please make sure to confirm correct password.",
                            Toast.LENGTH_LONG
                    );
                    test.show();
                }
//====================================================================================================================//

//============== SET UP DEFAULT VALUES FOR OTHER PATIENT PROFILE ITEMS ===============================================//
                String[] newPhone = new String[] {"000", "000", "0000"};
//====================================================================================================================//

//============== GENERATE NEW PATIENT FROM INPUT FIELD DATA ==========================================================//
                newPatient = new HashMap<>();
                newPatient.put("name", name);
                newPatient.put("street-address", address);
                newPatient.put("city", city);
                newPatient.put("state", state);
                newPatient.put("zip-code", Integer.parseInt(sZip));

                newPatient.put("primary-phone", "000-000-0000");
                newPatient.put("gender", Gender.NONE);
                newPatient.put("date-of-birth", "01/01/0000");
                newPatient.put("marital-status", MaritalStatus.NONE);
                newPatient.put("ethnicity", Ethnicity.NONE);
                newPatient.put("primary-insurance","NONE");
                newPatient.put("primary-policy","0");
                newPatient.put("primary-group", "0");
                newPatient.put("secondary-insurance","NONE");
                newPatient.put("secondary-policy","0");
                newPatient.put("secondary-group", "0");
                newPatient.put("employer", "NONE");
                newPatient.put("employer-street", "NONE");
                newPatient.put("employer-city", "NONE");
                newPatient.put("employer-state", State.NONE);
                newPatient.put("employer-zip","00000");

                newPatient.put("primary-em-contact", "NONE");
                newPatient.put("primary-em-phone", "NONE");
                newPatient.put("secondary-em-contact", "NONE");
                newPatient.put("secondary-em-phone","NONE");
                newPatient.put("blood-type", "NONE");
                newPatient.put("prescription-dosage", "NONE");
                newPatient.put("vaccinations", "NONE");
                newPatient.put("lifestyle", "NONE");
                newPatient.put("allergies", "NONE");
                newPatient.put("family-history", "NONE");
                newPatient.put("surgical-history", "NONE");
                newPatient.put("conditions", "NONE");



//====================================================================================================================//

//============== REGISTER PATIENT CREDENTIALS ========================================================================//
                FirebaseAuth patientRegisterAuth = FirebaseAuth.getInstance();
                patientRegisterAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(PatientRegistration.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> register) {
                        if (register.isSuccessful()) {
                            FirebaseFirestore db = FirebaseFirestore.getInstance();
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
                        else {
                            Toast test = Toast.makeText(getApplicationContext(), "Registration: Failure to register credentials", Toast.LENGTH_LONG);
                            test.show();
                        }
                    }
                });
//====================================================================================================================//
            }
        });

    }
}
