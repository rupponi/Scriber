package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import androidx.annotation.NonNull;
import com.google.android.material.tabs.TabLayout;
import androidx.core.content.ContextCompat;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

public class EditPatient extends AppCompatActivity {

    private Button SaveButton;
    private EditText updatedName, updatedBirthdate, updatedPhone, updatedStreet, updatedCity, updatedZip,
                     editPrimaryInsurance, editPrimaryInsurancePolicy, editPrimaryInsuranceGroup,
                     editSecondaryInsurance, editSecondaryInsurancePolicy, editSecondaryInsuranceGroup,
                     editEmployer, editEmployerStreet, editEmployerCity, editEmployerZip,
                     editPrimaryEmergencyContact, editPrimaryEmergencyContactNumber,
                     editSecondaryEmergencyContact, editSecondaryEmergencyContactNumber;

    private Spinner updatedState, updatedGender, updatedEthnicity, updatedMaritalStatus, updatedEmployerState, updatedBloodType;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);

        viewPager = findViewById(R.id.edit_view_pager);
        viewPager.setAdapter(new EditViewPagerAdapter(getSupportFragmentManager()));

        TabLayout editTabs = findViewById(R.id.edit_tabs);
        editTabs.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.unselectedTab), ContextCompat.getColor(getApplicationContext(), R.color.selectedTab));
        editTabs.setupWithViewPager(viewPager);

        SaveButton = findViewById(R.id.save_changes_button);


        SaveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                updatedName = findViewById(R.id.edit_name_input);
                updatedBirthdate = findViewById(R.id.edit_birthdate_input);
                updatedPhone = findViewById(R.id.edit_phone_input);

                updatedStreet = findViewById(R.id.edit_street_address_input);
                updatedCity = findViewById(R.id.edit_city_input);
                updatedState = findViewById(R.id.edit_state_input);
                updatedZip = findViewById(R.id.edit_zip_input);

                updatedEthnicity = findViewById(R.id.edit_ethnicity_input);
                updatedGender = findViewById(R.id.edit_gender_input);
                updatedMaritalStatus = findViewById(R.id.edit_marital_input);

                editPrimaryInsurance = findViewById(R.id.edit_primary_insurance_input);
                editPrimaryInsurancePolicy = findViewById(R.id.edit_primary_insurance_policy_input);
                editPrimaryInsuranceGroup = findViewById(R.id.edit_primary_insurance_group_input);
                editSecondaryInsurance = findViewById(R.id.edit_secondary_insurance_input);
                editSecondaryInsurancePolicy = findViewById(R.id.edit_secondary_insurance_policy_input);
                editSecondaryInsuranceGroup = findViewById(R.id.edit_secondary_insurance_group_input);
                editEmployer = findViewById(R.id.edit_employer_input);
                editEmployerStreet = findViewById(R.id.edit_employer_street_address_input);
                editEmployerCity = findViewById(R.id.edit_employer_city_input);
                updatedEmployerState = findViewById(R.id.edit_employer_state_input);
                editEmployerZip = findViewById(R.id.edit_employer_zip_input);



                editPrimaryEmergencyContact = findViewById(R.id.edit_primary_emergency_name);
                editPrimaryEmergencyContactNumber = findViewById(R.id.edit_primary_emergency_phone);
                editSecondaryEmergencyContact = findViewById(R.id.edit_secondary_emergency_name);
                editSecondaryEmergencyContactNumber = findViewById(R.id.edit_secondary_emergency_phone);

                updatedBloodType = findViewById(R.id.EBloodtypeInput);
                EditText Prescription = findViewById(R.id.edit_prescriptions);
                EditText Vaccination = findViewById(R.id.edit_vaccinations);
                EditText Lifestyle = findViewById(R.id.edit_lifestyle);

                EditText Allergies = findViewById(R.id.edit_allergies);
                EditText FamilyHistory = findViewById(R.id.edit_family_history);
                EditText SurgicalHistory = findViewById(R.id.edit_surgical_history);
                EditText Conditions = findViewById(R.id.edit_medical_conditions);

                String sEmployer = editEmployer.getText().toString().trim();



                String PrimEmer = editPrimaryEmergencyContact.getText().toString().trim();
                String PrimEmerContact = editPrimaryEmergencyContactNumber.getText().toString().trim();
                String SecEmer = editSecondaryEmergencyContact.getText().toString().trim();
                String SecEmerContact = editSecondaryEmergencyContactNumber.getText().toString().trim();

                String Presc = Prescription.getText().toString().trim();
                String Vacc = Vaccination.getText().toString().trim();
                String life = Lifestyle.getText().toString().trim();

                String allergies = Allergies.getText().toString().trim();
                String famhistory = FamilyHistory.getText().toString().trim();
                String surghistory = SurgicalHistory.getText().toString().trim();
                String conditions = Conditions.getText().toString().trim();


               //******************* PUSH TO DATABASE SECTION ********************//
                FirebaseFirestore db = FirebaseFirestore.getInstance();

                db.collection("patients").document(PatientHome.patientData.getId()).update(
                        "name", updatedName.getText().toString().trim(),
                        "address-street", updatedStreet.getText().toString().trim(),
                        "address-city", updatedCity.getText().toString().trim(),
                        "address-state", updatedState.getSelectedItem(),
                        "address-zip", updatedZip.getText().toString().trim(),
                        "primary-phone", updatedPhone.getText().toString().trim(),
                        "gender", updatedGender.getSelectedItem(),
                        "date-of-birth", updatedBirthdate.getText().toString().trim(),
                        "marital-status", updatedMaritalStatus.getSelectedItem(),
                        "ethnicity", updatedEthnicity.getSelectedItem(),
                        "primary-insurance", editPrimaryInsurance.getText().toString().trim(),
                        "primary-policy", editPrimaryInsurancePolicy.getText().toString().trim(),
                        "primary-group", editPrimaryInsuranceGroup.getText().toString().trim(),
                        "secondary-insurance", editSecondaryInsurance.getText().toString().trim(),
                        "secondary-policy", editSecondaryInsurancePolicy.getText().toString().trim(),
                        "secondary-group", editSecondaryInsuranceGroup.getText().toString().trim(),
                        "employer", editEmployer.getText().toString().trim(),
                        "employer-address-street", editEmployerStreet.getText().toString().trim(),
                        "employer-address-city", editEmployerCity.getText().toString().trim(),
                        "employer-address-state", updatedEmployerState.getSelectedItem(),
                        "employer-address-zip", editEmployerZip.getText().toString().trim(),

                        "primary-emergency-name", PrimEmer,
                        "primary-emergency-phone", PrimEmerContact,
                        "secondary-emergency-name", SecEmer,
                        "secondary-emergency-phone", SecEmerContact,
                        "blood-type", updatedBloodType.getSelectedItem(),
                        "prescriptions", Presc,
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
