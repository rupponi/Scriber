package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import javax.annotation.Nullable;


public class EditPersonalTab extends Fragment {
    @Nullable

    EditText Name, Email, City, StreetAddress, State, Zip, Phone, Gender, Ethnicity, Marital, PInsurance, PInsurancePolicy, PInsuranceGroup, SInsurance, SInsurancePolicy, SInsuranceGroup, Employer, EmployerStreet, EmployerCity, EmployerState, EmployerZip;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_personal_tab, container, false);


        Name = fragView.findViewById(R.id.ENameInput);
        Name.setText(PatientHome.patientData.get("name").toString());

        Email = fragView.findViewById(R.id.EEmailInput);
        Email.setText(PatientHome.patientData.getId());

        City = fragView.findViewById(R.id.ECityInput);
        City.setText(PatientHome.patientData.get("city").toString());

        StreetAddress = fragView.findViewById(R.id.EStreetInput);
        StreetAddress.setText(PatientHome.patientData.get("street-address").toString());

        State = fragView.findViewById(R.id.EStateInput);
        State.setText(PatientHome.patientData.get("state").toString());

        Zip = fragView.findViewById(R.id.EZipInput);
        Zip.setText(PatientHome.patientData.get("zip-code").toString());

        Phone = fragView.findViewById(R.id.EPhoneInput);
        Phone.setText(PatientHome.patientData.get("primary-phone").toString());

        Gender = fragView.findViewById(R.id.EGenderInput);
        Gender.setText(PatientHome.patientData.get("gender").toString());

        Ethnicity = fragView.findViewById(R.id.EEthnicityInput);
        Ethnicity.setText(PatientHome.patientData.get("ethnicity").toString());

        Marital = fragView.findViewById(R.id.EMaritalInput);
        Marital.setText(PatientHome.patientData.get("marital-status").toString());

        PInsurance = fragView.findViewById(R.id.EPrimaryInsuranceInput);
        PInsurance.setText(PatientHome.patientData.get("primary-insurance").toString());

        PInsurancePolicy = fragView.findViewById(R.id.EPrimaryPolicyInput);
        PInsurancePolicy.setText(PatientHome.patientData.get("primary-policy").toString());

        PInsuranceGroup = fragView.findViewById(R.id.EPrimaryGroupInput);
        PInsuranceGroup.setText(PatientHome.patientData.get("primary-group").toString());

        SInsurance = fragView.findViewById(R.id.ESecondaryInsuranceInput);
        SInsurance.setText(PatientHome.patientData.get("secondary-insurance").toString());

        SInsurancePolicy = fragView.findViewById(R.id.ESecondaryPolicyInput);
        SInsurancePolicy.setText(PatientHome.patientData.get("secondary-policy").toString());

        SInsuranceGroup = fragView.findViewById(R.id.ESecondaryGroupInput);
        SInsuranceGroup.setText(PatientHome.patientData.get("secondary-group").toString());

        Employer = fragView.findViewById(R.id.EEmployerInput);
        Employer.setText(PatientHome.patientData.get("employer").toString());

        EmployerStreet = fragView.findViewById(R.id.EEmployerStreetInput);
        EmployerStreet.setText(PatientHome.patientData.get("employer-street").toString());

        EmployerCity = fragView.findViewById(R.id.EEmployerCityInput);
        EmployerCity.setText(PatientHome.patientData.get("employer-city").toString());

        EmployerState = fragView.findViewById(R.id.EEmployerStateInput);
        EmployerState.setText(PatientHome.patientData.get("employer-state").toString());

        EmployerZip = fragView.findViewById(R.id.EEmployerZipInput);
        EmployerZip.setText(PatientHome.patientData.get("employer-zip").toString());

        return fragView;



    }
}
