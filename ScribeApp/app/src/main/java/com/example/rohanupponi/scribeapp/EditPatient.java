package com.example.rohanupponi.scribeapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class EditPatient extends AppCompatActivity {


    Button Save;
    static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);

        ViewPager viewPager = findViewById(R.id.edit_view_pager);
        viewPager.setAdapter(new EditViewPagerAdapter(getSupportFragmentManager()));


        TabLayout editTabs = findViewById(R.id.edit_tabs);
        editTabs.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.unselectedTab), ContextCompat.getColor(getApplicationContext(), R.color.selectedTab));
        editTabs.setupWithViewPager(viewPager);

        Save=findViewById(R.id.save_changes_button);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                EditText Name = findViewById(R.id.ENameInput);
                EditText Email = findViewById(R.id.EEmailInput);
                EditText Date = findViewById(R.id.EAgeInput);
                EditText Phone = findViewById(R.id.EPhoneInput);

                EditText Gender = findViewById(R.id.EGenderInput);
                /*
                ArrayAdapter genderAdapter = ArrayAdapter.createFromResource(EditPatient.this,
                        R.array.gender_array,
                        R.layout.dropdown_layout
                );
                genderAdapter.setDropDownViewResource(R.layout.dropdown_layout);
                Gender.setAdapter(genderAdapter);
                */

                EditText Street = findViewById(R.id.EStreetInput);
                EditText City = findViewById(R.id.ECityInput);
                EditText State = findViewById(R.id.EStateInput);
                EditText Zip = findViewById(R.id.EZipInput);
                EditText Ethnicity = findViewById(R.id.EEthnicityInput);
                EditText Marital = findViewById(R.id.EMaritalInput);
                EditText PInsurance = findViewById(R.id.EPrimaryInsuranceInput);
                EditText PInsurancePolicy = findViewById(R.id.EPrimaryPolicyInput);
                EditText PInsuranceGroup = findViewById(R.id.EPrimaryGroupInput);
                EditText SInsurance = findViewById(R.id.ESecondaryInsuranceInput);
                EditText SInsurancePolicy = findViewById(R.id.ESecondaryPolicyInput);
                EditText SInsuranceGroup = findViewById(R.id.ESecondaryGroupInput);
                EditText Employer = findViewById(R.id.EEmployerInput);
                EditText EmployerStreet = findViewById(R.id.EEmployerStreetInput);
                EditText EmployerCity = findViewById(R.id.EEmployerCityInput);
                EditText EmployerState = findViewById(R.id.EEmployerStateInput);
                EditText EmployerZip = findViewById(R.id.EEmployerZipInput);



                EditText PrimaryEmergency = findViewById(R.id.EPrimaryEmergencyInput);
                EditText PrimaryEmergencyContact = findViewById(R.id.EPrimaryEContactInput);
                EditText SecondaryEmergency = findViewById(R.id.ESecondaryEmergencyInput);
                EditText SecondaryEmergencyContact = findViewById(R.id.ESecondaryEContactInput);

                EditText Bloodtype = findViewById(R.id.EBloodtypeInput);
                EditText Prescription = findViewById(R.id.EPrescriptionInput);
                EditText Vaccination = findViewById(R.id.EVaccinationInput);
                EditText Lifestyle = findViewById(R.id.ELifestyleInput);

                EditText Allergies = findViewById(R.id.EAllergiesInput);
                EditText FamilyHistory = findViewById(R.id.EFamilyHistoryInput);
                EditText SurgicalHistory = findViewById(R.id.ESurgicalHistoryInput);
                EditText Conditions = findViewById(R.id.EConditionsInput);




                String sName = Name.getText().toString().trim();
                String sDate = (Date.getText().toString().trim());
                String sPhone = (Phone.getText().toString().trim());
                String sEmployer = Email.getText().toString().trim();

                String sGender = Gender.getText().toString().trim();
                String St = Street.getText().toString().trim();
                String Ci = City.getText().toString().trim();
                String Sta= State.getText().toString().trim();
                String Zi = Zip.getText().toString().trim();
                String Eth = Ethnicity.getText().toString().trim();
                String Mar= Marital.getText().toString().trim();
                String In = PInsurance.getText().toString().trim();
                String Policy = PInsurancePolicy.getText().toString().trim();
                String Gr = PInsuranceGroup.getText().toString().trim();
                String SIn = SInsurance.getText().toString().trim();
                String SPolicy = SInsurancePolicy.getText().toString().trim();
                String SGr = SInsuranceGroup.getText().toString().trim();
                String Empl = Employer.getText().toString().trim();
                String EmplStreet = EmployerStreet.getText().toString().trim();
                String EmplCity = EmployerCity.getText().toString().trim();
                String EmplState = EmployerState.getText().toString().trim();
                String EmplZip = EmployerZip.getText().toString().trim();



                String PrimEmer = PrimaryEmergency.getText().toString().trim();
                String PrimEmerContact = PrimaryEmergencyContact.getText().toString().trim();
                String SecEmer = SecondaryEmergency.getText().toString().trim();
                String SecEmerContact = SecondaryEmergencyContact.getText().toString().trim();

                String Bltype = Bloodtype.getText().toString().trim();
                String Presc = Prescription.getText().toString().trim();
                String Vacc = Vaccination.getText().toString().trim();
                String life = Lifestyle.getText().toString().trim();

                String allergies = Allergies.getText().toString().trim();
                String famhistory = FamilyHistory.getText().toString().trim();
                String surghistory = SurgicalHistory.getText().toString().trim();
                String conditions = Conditions.getText().toString().trim();



                prefs = PreferenceManager.getDefaultSharedPreferences(EditPatient.this);
                SharedPreferences.Editor editor = prefs.edit();


                editor.putString("Na",sName);
                editor.putString("Da",sDate);
                editor.putString("Ph",sPhone);
                editor.putString("Em", sEmployer);

                editor.putString("Ge", sGender);
                editor.putString("St", St);
                editor.putString("Ci", Ci);
                editor.putString("Sta", Sta);
                editor.putString("Zi", Zi);
                editor.putString("Eth", Eth);
                editor.putString("Mar", Mar);
                editor.putString("In", In);
                editor.putString("Policy", Policy);
                editor.putString("Gr", Gr);
                editor.putString("SIn", SIn);
                editor.putString("SPolicy", SPolicy);
                editor.putString("SGr", SGr);
                editor.putString("Empl", Empl);
                editor.putString("EmplStreet", EmplStreet);
                editor.putString("EmplCity", EmplCity);
                editor.putString("EmplState", EmplState);
                editor.putString("EmplZip", EmplZip);

                editor.putString("PrimEmer", PrimEmer);
                editor.putString("PrimEmerContact", PrimEmerContact);
                editor.putString("SecEmer", SecEmer);
                editor.putString("SecEmerContact", SecEmerContact);
                editor.putString("Bltype", Bltype);
                editor.putString("Presc", Presc);
                editor.putString("Vacc", Vacc);
                editor.putString("life", life);
                editor.putString("allergies", allergies);
                editor.putString("famhistory", famhistory);
                editor.putString("surghistory", surghistory);
                editor.putString("conditions", conditions);



                editor.apply();



               //******************* PUSH TO DATABASE SECTION ********************//
                FirebaseFirestore db = FirebaseFirestore.getInstance();


                db.collection("patients").document(sEmployer).update(
                        "name", sName,
                        "street-address", St,
                        "city", Ci,
                        "state", Sta,
                        "gender", sGender,
                        "email", sEmployer,
                        "date-of-birth", sDate,
                        "primary-phone", sPhone,
                        "zip-code", Zi,
                        "ethnicity", Eth,
                        "marital-status", Mar,
                        "primary-insurance", In,
                        "primary-policy", Policy,
                        "primary-group", Gr,
                        "secondary-insurance", SIn,
                        "secondary-policy", SPolicy,
                        "secondary-group", SGr,
                        "employer", Empl,
                        "employer-street", EmplStreet,
                        "employer-city", EmplCity,
                        "employer-state", EmplState,
                        "employer-zip", EmplZip,

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
                        Toast failedUpdate = Toast.makeText(getApplicationContext(), "Oops! Something went wrong in updating your profile.", Toast.LENGTH_LONG);
                        failedUpdate.show();
                        Intent returnToPatientHome = new Intent(getApplicationContext(), LoginPage.class);
                        startActivity(returnToPatientHome);
                    }
                });



                Toast successfulSave = Toast.makeText(getApplicationContext(), "Your profile was successfully saved!", Toast.LENGTH_LONG);
                successfulSave.show();





            }
        });



    }
}
