package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.annotation.Nullable;

public class PersonalTab extends Fragment {

    private TextView patientName, patientEmail, patientStreetAddress, patientCity, patientState, patientZip,
                     patientPhone, patientGender, patientMarital, patientEthnicity, patientAge,
                     patientPrimaryInsurance, patientPrimaryInsurancePolicy, patientPrimaryInsuranceGroup,
                     patientSecondaryInsurance, patientSecondaryInsurancePolicy, patientSecondaryInsuranceGroup,
                     patientEmployer, patientEmployerStreet, patientEmployerCity, patientEmployerState, patientEmployerZip;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_personal_tab, container, false);

        patientName = fragView.findViewById(R.id.patient_name);
        patientEmail = fragView.findViewById(R.id.patient_email);
        patientStreetAddress = fragView.findViewById(R.id.patient_street_address);
        patientCity = fragView.findViewById(R.id.patient_city);
        patientState = fragView.findViewById(R.id.patient_state);
        patientZip = fragView.findViewById(R.id.patient_zip);
        patientPhone = fragView.findViewById(R.id.ContactInput);
        patientGender = fragView.findViewById(R.id.patient_gender);
        patientMarital = fragView.findViewById(R.id.patient_marital_status);
        patientEthnicity = fragView.findViewById(R.id.patient_ethnicity);
        patientAge = fragView.findViewById(R.id.patient_birthday);
        patientPrimaryInsurance = fragView.findViewById(R.id.PrimaryInsuranceInput);
        patientPrimaryInsurancePolicy = fragView.findViewById(R.id.PrimaryPolicyInput);
        patientPrimaryInsuranceGroup = fragView.findViewById(R.id.PrimaryGroupInput);
        patientSecondaryInsurance = fragView.findViewById(R.id.SecondaryInsuranceInput);
        patientSecondaryInsurancePolicy = fragView.findViewById(R.id.SecondaryPolicyInput);
        patientSecondaryInsuranceGroup = fragView.findViewById(R.id.SecondaryGroupInput);
        patientEmployer = fragView.findViewById(R.id.EmployerInput);
        patientEmployerStreet = fragView.findViewById(R.id.patient_employer_street_address);
        patientEmployerCity = fragView.findViewById(R.id.patient_employer_city);
        patientEmployerState = fragView.findViewById(R.id.patient_employer_state);
        patientEmployerZip = fragView.findViewById(R.id.patient_employer_zip);


        patientName.setText(PatientHome.patientData.get("name").toString());
        patientEmail.setText(PatientHome.patientData.getId());
        patientStreetAddress.setText(PatientHome.patientData.get("address-street").toString());
        patientCity.setText(PatientHome.patientData.get("address-city").toString());
        patientState.setText(PatientHome.patientData.get("address-state").toString());
        patientZip.setText(PatientHome.patientData.get("address-zip").toString());

        patientPhone.setText(PatientHome.patientData.get("primary-phone").toString());
        patientGender.setText(PatientHome.patientData.get("gender").toString());
        patientAge.setText(PatientHome.patientData.get("date-of-birth").toString());
        patientMarital.setText(PatientHome.patientData.get("marital-status").toString());
        patientEthnicity.setText(PatientHome.patientData.get("ethnicity").toString());

        patientPrimaryInsurance.setText(PatientHome.patientData.get("primary-insurance").toString());
        patientPrimaryInsurancePolicy.setText(PatientHome.patientData.get("primary-policy").toString());
        patientPrimaryInsuranceGroup.setText(PatientHome.patientData.get("primary-group").toString());
        patientSecondaryInsurance.setText(PatientHome.patientData.get("secondary-insurance").toString());
        patientSecondaryInsurancePolicy.setText(PatientHome.patientData.get("secondary-policy").toString());
        patientSecondaryInsuranceGroup.setText(PatientHome.patientData.get("secondary-group").toString());

        patientEmployer.setText(PatientHome.patientData.get("employer").toString());
        patientEmployerStreet.setText(PatientHome.patientData.get("employer-address-street").toString());
        patientEmployerCity.setText(PatientHome.patientData.get("employer-address-city").toString());
        patientEmployerState.setText(PatientHome.patientData.get("employer-address-state").toString());
        patientEmployerZip.setText(PatientHome.patientData.get("employer-address-zip").toString());

        return fragView;
    }
}
