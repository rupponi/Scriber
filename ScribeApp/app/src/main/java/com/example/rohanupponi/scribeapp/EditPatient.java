package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditPatient extends AppCompatActivity {

    private Button SaveButton;
    private EditText editName, editEmail, editBirthDate, editPhone, editStreet, editCity, editZip,
                     editPrimaryInsurance, editPrimaryInsurancePolicy, editPrimaryInsuranceGroup,
                     editSecondaryInsurance, editSecondaryInsurancePolicy, editSecondaryInsuranceGroup,
                     editEmployer, editEmployerStreet, editEmployerCity, editEmployerZip,
                     editPrimaryEmergencyContact, editPrimaryEmergencyContactNumber,
                     editSecondaryEmergencyContact, editSecondaryEmergencyContactNumber;

    private Spinner editState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);

        ViewPager viewPager = findViewById(R.id.edit_view_pager);
        viewPager.setAdapter(new EditViewPagerAdapter(getSupportFragmentManager()));


        TabLayout editTabs = findViewById(R.id.edit_tabs);
        editTabs.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.unselectedTab), ContextCompat.getColor(getApplicationContext(), R.color.selectedTab));
        editTabs.setupWithViewPager(viewPager);

        SaveButton = findViewById(R.id.save_changes_button);




        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                editName = findViewById(R.id.ENameInput);
                editEmail = findViewById(R.id.EEmailInput);
                editBirthDate = findViewById(R.id.EAgeInput);
                editPhone = findViewById(R.id.EPhoneInput);

                EditText Gender = findViewById(R.id.EGenderInput);
                /*
                ArrayAdapter genderAdapter = ArrayAdapter.createFromResource(EditPatient.this,
                        R.array.gender_array,
                        R.layout.dropdown_layout
                );
                genderAdapter.setDropDownViewResource(R.layout.dropdown_layout);
                Gender.setAdapter(genderAdapter);
                */

                editStreet = findViewById(R.id.EStreetInput);
                editCity = findViewById(R.id.ECityInput);
                EditText State = findViewById(R.id.EditStateInput);
                editZip = findViewById(R.id.EZipInput);
                EditText Ethnicity = findViewById(R.id.EEthnicityInput);
                EditText Marital = findViewById(R.id.EMaritalInput);
                editPrimaryInsurance = findViewById(R.id.EPrimaryInsuranceInput);
                editPrimaryInsurancePolicy = findViewById(R.id.EPrimaryPolicyInput);
                editPrimaryInsuranceGroup = findViewById(R.id.EPrimaryGroupInput);
                editSecondaryInsurance = findViewById(R.id.ESecondaryInsuranceInput);
                editSecondaryInsurancePolicy = findViewById(R.id.ESecondaryPolicyInput);
                editSecondaryInsuranceGroup = findViewById(R.id.ESecondaryGroupInput);
                editEmployer = findViewById(R.id.EEmployerInput);
                editEmployerStreet = findViewById(R.id.EEmployerStreetInput);
                editEmployerCity = findViewById(R.id.EEmployerCityInput);
                EditText EmployerState = findViewById(R.id.EEmployerStateInput);
                editEmployerZip = findViewById(R.id.EEmployerZipInput);



                editPrimaryEmergencyContact = findViewById(R.id.EPrimaryEmergencyInput);
                editPrimaryEmergencyContactNumber = findViewById(R.id.EPrimaryEContactInput);
                editSecondaryEmergencyContact = findViewById(R.id.ESecondaryEmergencyInput);
                editSecondaryEmergencyContactNumber = findViewById(R.id.ESecondaryEContactInput);

                EditText Bloodtype = findViewById(R.id.EBloodtypeInput);
                EditText Prescription = findViewById(R.id.EPrescriptionInput);
                EditText Vaccination = findViewById(R.id.EVaccinationInput);
                EditText Lifestyle = findViewById(R.id.ELifestyleInput);

                EditText Allergies = findViewById(R.id.EAllergiesInput);
                EditText FamilyHistory = findViewById(R.id.EFamilyHistoryInput);
                EditText SurgicalHistory = findViewById(R.id.ESurgicalHistoryInput);
                EditText Conditions = findViewById(R.id.EConditionsInput);

                String sEmployer = editEmail.getText().toString().trim();

                String sGender = Gender.getText().toString().trim();
                String Sta= State.getText().toString().trim();
                String Eth = Ethnicity.getText().toString().trim();
                String Mar= Marital.getText().toString().trim();
                String EmplState = EmployerState.getText().toString().trim();



                String PrimEmer = editPrimaryEmergencyContact.getText().toString().trim();
                String PrimEmerContact = editPrimaryEmergencyContactNumber.getText().toString().trim();
                String SecEmer = editSecondaryEmergencyContact.getText().toString().trim();
                String SecEmerContact = editSecondaryEmergencyContactNumber.getText().toString().trim();

                String Bltype = Bloodtype.getText().toString().trim();
                String Presc = Prescription.getText().toString().trim();
                String Vacc = Vaccination.getText().toString().trim();
                String life = Lifestyle.getText().toString().trim();

                String allergies = Allergies.getText().toString().trim();
                String famhistory = FamilyHistory.getText().toString().trim();
                String surghistory = SurgicalHistory.getText().toString().trim();
                String conditions = Conditions.getText().toString().trim();


               //******************* PUSH TO DATABASE SECTION ********************//
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                db.collection("patients").document(sEmployer).update(
                        "name", editName.getText().toString().trim(),
                        "street-address", editStreet.getText().toString().trim(),
                        "city", editCity.getText().toString().trim(),
                        "state", Sta,
                        "gender", sGender,
                        "email", editEmployer.getText().toString().trim(),
                        "date-of-birth", editBirthDate.getText().toString().trim(),
                        "primary-phone", editPhone.getText().toString().trim(),
                        "zip-code", editZip.getText().toString().trim(),
                        "ethnicity", Eth,
                        "marital-status", Mar,
                        "primary-insurance", editPrimaryInsurance.getText().toString().trim(),
                        "primary-policy", editPrimaryInsurancePolicy.getText().toString().trim(),
                        "primary-group", editPrimaryInsuranceGroup.getText().toString().trim(),
                        "secondary-insurance", editSecondaryInsurance.getText().toString().trim(),
                        "secondary-policy", editSecondaryInsurancePolicy.getText().toString().trim(),
                        "secondary-group", editSecondaryInsuranceGroup.getText().toString().trim(),
                        "employer", editEmployer.getText().toString().trim(),
                        "employer-street", editEmployerStreet.getText().toString().trim(),
                        "employer-city", editEmployerCity.getText().toString().trim(),
                        "employer-state", EmplState,
                        "employer-zip", editEmployerZip.getText().toString().trim(),

                        "primary-em-contact", PrimEmer,
                        "primary-em-phone", PrimEmerContact,
                        "secondary-em-contact", SecEmer,
                        "secondary-em-phone", SecEmerContact,
                        "blood-type", Bltype,
                        "prescription-dosage", Presc,
                        "vaccinations", Vacc,
                        "lifestyle", life,
                        "allergies", allergies,
                        "family-history", famhistory,
                        "surgical-history", surghistory,
                        "conditions", conditions

                ).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast successfulUpdate = Toast.makeText(getApplicationContext(), "Successfully updated profile!", Toast.LENGTH_LONG);
                        successfulUpdate.show();
                        Intent returnToPatientHome = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(returnToPatientHome);
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast failedUpdate = Toast.makeText(getApplicationContext(), "Oops! We couldn't update the database. Please check your internet connection.", Toast.LENGTH_LONG);
                        failedUpdate.show();
                        Intent returnToPatientHome = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(returnToPatientHome);
                    }
                });
            }
        });
    }
}
