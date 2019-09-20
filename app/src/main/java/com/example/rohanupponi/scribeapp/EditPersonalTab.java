package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
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

    EditText editName, editCity, editStreetAddress, editZip, editPhoneNumber, editPrimaryInsurance, editPrimaryInsurancePolicy, editPrimaryInsuranceGroup,
            editSecondaryInsurance, editSecondaryInsurancePolicy, editSecondaryInsuranceGroup, editEmployer, editEmployerStreetAddress, editEmployerCity, editEmployerZip;
    Spinner editState, editGender, editEthnicity, editMarital, editEmployerState;
    TextView constantEmail;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_personal_tab, container, false);

        List<String> stateChoices = Arrays.asList(getResources().getStringArray(R.array.states_array));
        List<String> maritalChoices = Arrays.asList(getResources().getStringArray(R.array.marital_status_array));
        List<String> genderChoices = Arrays.asList(getResources().getStringArray(R.array.gender_array));
        List<String> ethnicityChoices = Arrays.asList(getResources().getStringArray(R.array.ethnicity_array));

        editName = fragView.findViewById(R.id.edit_name_input);
        editName.setText(PatientHome.patientData.get("name").toString());

        constantEmail = fragView.findViewById(R.id.forced_set_email);
        constantEmail.setText(PatientHome.patientData.getId());

        editStreetAddress = fragView.findViewById(R.id.edit_street_address_input);
        editStreetAddress.setText(PatientHome.patientData.get("address-street").toString());

        editCity = fragView.findViewById(R.id.edit_city_input);
        editCity.setText(PatientHome.patientData.get("address-city").toString());

        editState = fragView.findViewById(R.id.edit_state_input);
        ArrayAdapter stateAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.states_array,
                R.layout.dropdown_layout
        );
        stateAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        editState.setAdapter(stateAdapter);
        String currentState = PatientHome.patientData.get("address-state").toString().trim();
        int currentStateIndex = stateChoices.indexOf(currentState);
        editState.setSelection(currentStateIndex);


        editZip = fragView.findViewById(R.id.edit_zip_input);
        editZip.setText(PatientHome.patientData.get("address-zip").toString());

        editPhoneNumber = fragView.findViewById(R.id.edit_phone_input);
        editPhoneNumber.setText(PatientHome.patientData.get("primary-phone").toString());
        editPhoneNumber.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        editGender = fragView.findViewById(R.id.edit_gender_input);
        ArrayAdapter genderAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.gender_array,
                R.layout.dropdown_layout
        );
        genderAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        editGender.setAdapter(genderAdapter);
        String currentGender = PatientHome.patientData.get("gender").toString().trim();
        int currentGenderIndex = genderChoices.indexOf(currentGender);
        editGender.setSelection(currentGenderIndex);

        editEthnicity = fragView.findViewById(R.id.edit_ethnicity_input);
        ArrayAdapter ethnicityAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.ethnicity_array,
                R.layout.dropdown_layout
        );
        ethnicityAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        editEthnicity.setAdapter(ethnicityAdapter);
        String currentEthnicity = PatientHome.patientData.get("ethnicity").toString().trim();
        int currentEthnicityIndex = ethnicityChoices.indexOf(currentEthnicity);
        editEthnicity.setSelection(currentEthnicityIndex);

        editMarital = fragView.findViewById(R.id.edit_marital_input);
        ArrayAdapter maritalAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.marital_status_array,
                R.layout.dropdown_layout
        );
        maritalAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        editMarital.setAdapter(maritalAdapter);
        String currentStatus = PatientHome.patientData.get("marital-status").toString().trim();
        editMarital.setSelection(maritalChoices.indexOf(currentStatus));

        editPrimaryInsurance = fragView.findViewById(R.id.edit_primary_insurance_input);
        editPrimaryInsurance.setText(PatientHome.patientData.get("primary-insurance").toString());

        editPrimaryInsurancePolicy = fragView.findViewById(R.id.edit_primary_insurance_policy_input);
        editPrimaryInsurancePolicy.setText(PatientHome.patientData.get("primary-policy").toString());

        editPrimaryInsuranceGroup = fragView.findViewById(R.id.edit_primary_insurance_group_input);
        editPrimaryInsuranceGroup.setText(PatientHome.patientData.get("primary-group").toString());

        editSecondaryInsurance = fragView.findViewById(R.id.edit_secondary_insurance_input);
        editSecondaryInsurance.setText(PatientHome.patientData.get("secondary-insurance").toString());

        editSecondaryInsurancePolicy = fragView.findViewById(R.id.edit_secondary_insurance_policy_input);
        editSecondaryInsurancePolicy.setText(PatientHome.patientData.get("secondary-policy").toString());

        editSecondaryInsuranceGroup = fragView.findViewById(R.id.edit_secondary_insurance_group_input);
        editSecondaryInsuranceGroup.setText(PatientHome.patientData.get("secondary-group").toString());

        editEmployer = fragView.findViewById(R.id.edit_employer_input);
        editEmployer.setText(PatientHome.patientData.get("employer").toString());

        editEmployerStreetAddress = fragView.findViewById(R.id.edit_employer_street_address_input);
        editEmployerStreetAddress.setText(PatientHome.patientData.get("employer-address-street").toString());

        editEmployerCity = fragView.findViewById(R.id.edit_employer_city_input);
        editEmployerCity.setText(PatientHome.patientData.get("employer-address-city").toString());

        editEmployerState = fragView.findViewById(R.id.edit_employer_state_input);
        ArrayAdapter employerStateAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.states_array,
                R.layout.dropdown_layout
        );
        employerStateAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        editEmployerState.setAdapter(employerStateAdapter);
        String currentEmployerState = PatientHome.patientData.get("employer-address-state").toString().trim();
        editEmployerState.setSelection(stateChoices.indexOf(currentEmployerState));

        editEmployerZip = fragView.findViewById(R.id.edit_employer_zip_input);
        editEmployerZip.setText(PatientHome.patientData.get("employer-address-zip").toString());

        return fragView;
    }
}
