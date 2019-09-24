package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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
                            "We are currently missing some information. Please be sure to fill in all fields.",
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
                    return;
                }
//====================================================================================================================//

//============== GENERATE NEW PATIENT FROM INPUT FIELD DATA ==========================================================//
                newPatient = new HashMap<>();
                newPatient.put("name", name);
                newPatient.put("address-street", address);
                newPatient.put("address-city", city);
                newPatient.put("address-state", state);
                newPatient.put("address-zip", Integer.parseInt(sZip));

                newPatient.put("primary-phone", "");
                newPatient.put("gender", Gender.NONE);
                newPatient.put("date-of-birth", "");
                newPatient.put("marital-status", MaritalStatus.NONE);
                newPatient.put("ethnicity", Ethnicity.NONE);

                newPatient.put("primary-insurance","");
                newPatient.put("primary-policy","");
                newPatient.put("primary-group", "");
                newPatient.put("secondary-insurance","");
                newPatient.put("secondary-policy","");
                newPatient.put("secondary-group", "");

                newPatient.put("employer", "");
                newPatient.put("employer-address-street", "");
                newPatient.put("employer-address-city", "");
                newPatient.put("employer-address-state", State.NONE);
                newPatient.put("employer-address-zip","");

                newPatient.put("primary-emergency-name", "");
                newPatient.put("primary-emergency-phone", "");
                newPatient.put("secondary-emergency-name", "");
                newPatient.put("secondary-emergency-phone","");
                newPatient.put("blood-type", BloodType.NONE);
                newPatient.put("prescriptions", "");
                newPatient.put("vaccinations", "");
                newPatient.put("lifestyle", "");
                newPatient.put("allergies", "");
                newPatient.put("family-history", "");
                newPatient.put("surgical-history", "");
                newPatient.put("conditions", "");



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
                                    Toast successfulRegistration = Toast.makeText(getApplicationContext(), "Congratulations! You have now been registered.", Toast.LENGTH_LONG);
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
                            Toast test = Toast.makeText(getApplicationContext(), "Sorry! We experienced some issues in connectivity. Please check your connection and try again.", Toast.LENGTH_LONG);
                            test.show();
                        }
                    }
                });
//====================================================================================================================//
            }
        });

    }
}
