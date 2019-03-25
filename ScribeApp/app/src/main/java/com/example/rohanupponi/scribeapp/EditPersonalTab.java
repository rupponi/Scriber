package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;


public class EditPersonalTab extends Fragment {
    @Nullable

    EditText newName, newCity, newStreetAddress, newZip, newPhone, newPrimaryInsurance, newPrimaryInsurancePolicy, newPrimaryInsuranceGroup,
             newSecondaryInsurance, newSecondaryInsurancePolicy, newSecondaryInsuranceGroup, newEmployer, newEmployerStreet, newEmployerCity, newEmployerZip;
    Spinner newState, newGender, newEthnicity, newMarital, newEmployerState;
    TextView constantEmail;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_personal_tab, container, false);


        List<String> stateChoices = Arrays.asList(getResources().getStringArray(R.array.states_array));
        List<String> maritalChoices = Arrays.asList(getResources().getStringArray(R.array.marital_status_array));
        List<String> genderChoices = Arrays.asList(getResources().getStringArray(R.array.gender_array));
        List<String> ethnicityChoices = Arrays.asList(getResources().getStringArray(R.array.ethnicity_array));


        newName = fragView.findViewById(R.id.edit_name_input);
        newName.setText(PatientHome.patientData.get("name").toString());

        constantEmail = fragView.findViewById(R.id.forced_set_email);
        constantEmail.setText(PatientHome.patientData.getId());

        newStreetAddress = fragView.findViewById(R.id.edit_street_address_input);
        newStreetAddress.setText(PatientHome.patientData.get("street-address").toString());

        newCity = fragView.findViewById(R.id.edit_city_input);
        newCity.setText(PatientHome.patientData.get("city").toString());

        newState = fragView.findViewById(R.id.edit_state_input);
        ArrayAdapter stateAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.states_array,
                R.layout.dropdown_layout
        );
        stateAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        newState.setAdapter(stateAdapter);
        String currentState = PatientHome.patientData.get("state").toString().trim();
        int currentStateIndex = stateChoices.indexOf(currentState);
        newState.setSelection(currentStateIndex);


        newZip = fragView.findViewById(R.id.edit_zip_input);
        newZip.setText(PatientHome.patientData.get("zip-code").toString());

        newPhone = fragView.findViewById(R.id.edit_phone_input);
        newPhone.setText(PatientHome.patientData.get("primary-phone").toString());

        newGender = fragView.findViewById(R.id.edit_gender_input);
        ArrayAdapter genderAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.gender_array,
                R.layout.dropdown_layout
        );
        genderAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        newGender.setAdapter(genderAdapter);
        String currentGender = PatientHome.patientData.get("gender").toString().trim();
        int currentGenderIndex = genderChoices.indexOf(currentGender);
        newGender.setSelection(currentGenderIndex);

        newEthnicity = fragView.findViewById(R.id.edit_ethnicity_input);
        ArrayAdapter ethnicityAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.ethnicity_array,
                R.layout.dropdown_layout
        );
        ethnicityAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        newEthnicity.setAdapter(ethnicityAdapter);
        String currentEthnicity = PatientHome.patientData.get("ethnicity").toString().trim();
        int currentEthnicityIndex = ethnicityChoices.indexOf(currentEthnicity);
        newEthnicity.setSelection(currentEthnicityIndex);

        newMarital = fragView.findViewById(R.id.edit_marital_input);
        ArrayAdapter maritalAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.marital_status_array,
                R.layout.dropdown_layout
        );
        maritalAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        newMarital.setAdapter(maritalAdapter);
        String currentStatus = PatientHome.patientData.get("marital-status").toString().trim();
        newMarital.setSelection(maritalChoices.indexOf(currentStatus));

        newPrimaryInsurance = fragView.findViewById(R.id.edit_primary_insurance_input);
        newPrimaryInsurance.setText(PatientHome.patientData.get("primary-insurance").toString());

        newPrimaryInsurancePolicy = fragView.findViewById(R.id.edit_primary_insurance_policy_input);
        newPrimaryInsurancePolicy.setText(PatientHome.patientData.get("primary-policy").toString());

        newPrimaryInsuranceGroup = fragView.findViewById(R.id.edit_primary_insurance_group_input);
        newPrimaryInsuranceGroup.setText(PatientHome.patientData.get("primary-group").toString());

        newSecondaryInsurance = fragView.findViewById(R.id.edit_secondary_insurance_input);
        newSecondaryInsurance.setText(PatientHome.patientData.get("secondary-insurance").toString());

        newSecondaryInsurancePolicy = fragView.findViewById(R.id.edit_secondary_insurance_policy_input);
        newSecondaryInsurancePolicy.setText(PatientHome.patientData.get("secondary-policy").toString());

        newSecondaryInsuranceGroup = fragView.findViewById(R.id.edit_secondary_insurance_group_input);
        newSecondaryInsuranceGroup.setText(PatientHome.patientData.get("secondary-group").toString());

        newEmployer = fragView.findViewById(R.id.edit_employer_input);
        newEmployer.setText(PatientHome.patientData.get("employer").toString());

        newEmployerStreet = fragView.findViewById(R.id.edit_employer_street_address_input);
        newEmployerStreet.setText(PatientHome.patientData.get("employer-street").toString());

        newEmployerCity = fragView.findViewById(R.id.edit_employer_city_input);
        newEmployerCity.setText(PatientHome.patientData.get("employer-city").toString());

        newEmployerState = fragView.findViewById(R.id.edit_employer_state_input);
        ArrayAdapter employerStateAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.states_array,
                R.layout.dropdown_layout
        );
        employerStateAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        newEmployerState.setAdapter(employerStateAdapter);
        String currentEmployerState = PatientHome.patientData.get("employer-state").toString().trim();
        newEmployerState.setSelection(stateChoices.indexOf(currentEmployerState));

        newEmployerZip = fragView.findViewById(R.id.edit_employer_zip_input);
        newEmployerZip.setText(PatientHome.patientData.get("employer-zip").toString());

        return fragView;
    }
}
