package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.annotation.Nullable;

public class PersonalTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_personal_tab, container, false);

        TextView patientName = fragView.findViewById(R.id.patient_name);
        TextView patientEmail = fragView.findViewById(R.id.patient_email);
        TextView patientStreetAddress = fragView.findViewById(R.id.patient_street_address);
        TextView patientCity = fragView.findViewById(R.id.patient_city);
        TextView patientState = fragView.findViewById(R.id.patient_state);
        TextView patientZip = fragView.findViewById(R.id.patient_zip);
        TextView patientPhone = fragView.findViewById(R.id.ContactInput);
        TextView patientGender = fragView.findViewById(R.id.GenderInput);
        TextView patientMarital = fragView.findViewById(R.id.MaritalInput);
        TextView patientEthnicity = fragView.findViewById(R.id.EthnicityInput);
        TextView patientAge = fragView.findViewById(R.id.AgeInput);
        TextView patientPrimaryInsurance = fragView.findViewById(R.id.PrimaryInsuranceInput);
        TextView patientPrimaryPolicy = fragView.findViewById(R.id.PrimaryPolicyInput);
        TextView patientPrimaryGroup = fragView.findViewById(R.id.PrimaryGroupInput);
        TextView patientSecondaryInsurance = fragView.findViewById(R.id.SecondaryInsuranceInput);
        TextView patientSecondaryPolicy = fragView.findViewById(R.id.SecondaryPolicyInput);
        TextView patientSecondaryGroup = fragView.findViewById(R.id.SecondaryGroupInput);
        TextView patientEmployer = fragView.findViewById(R.id.EmployerInput);
        TextView patientEmployerStreet = fragView.findViewById(R.id.EmployerStreetInput);
        TextView patientEmployerCity = fragView.findViewById(R.id.EmployerCityInput);
        TextView patientEmployerState = fragView.findViewById(R.id.EmployerStateInput);
        TextView patientEmployerZip = fragView.findViewById(R.id.EmployerZipInput);


        patientName.setText("Name: \t" + PatientHome.patientData.get("name").toString());
        patientEmail.setText("Email: \t" + PatientHome.patientData.getId());
        patientStreetAddress.setText("Street Address: \t" + PatientHome.patientData.get("street-address").toString());
        patientCity.setText("City: \t" + PatientHome.patientData.get("city").toString());
        patientState.setText("State: \t" + PatientHome.patientData.get("state").toString());
        patientZip.setText("ZIP: \t" + PatientHome.patientData.get("zip-code").toString());
        patientPhone.setText("Phone: \t" + PatientHome.patientData.get("primary-phone").toString());
        patientGender.setText("Gender: \t" + PatientHome.patientData.get("gender").toString());
        patientMarital.setText("Marital Status: \t" + PatientHome.patientData.get("marital-status").toString());
        patientEthnicity.setText("Ethnicity: \t" + PatientHome.patientData.get("ethnicity").toString());
        patientAge.setText("Date of Birth: \t" + PatientHome.patientData.get("date-of-birth").toString());
        patientPrimaryInsurance.setText("Primary Insurance: \t" + PatientHome.patientData.get("primary-insurance").toString());
        patientPrimaryPolicy.setText("Primary Policy #: \t" + PatientHome.patientData.get("primary-policy").toString());
        patientPrimaryGroup.setText("Primary Group #: \t" + PatientHome.patientData.get("primary-group").toString());
        patientSecondaryInsurance.setText("Secondary Insurance: \t" + PatientHome.patientData.get("secondary-insurance").toString());
        patientSecondaryPolicy.setText("Secondary Policy #: \t" + PatientHome.patientData.get("secondary-policy").toString());
        patientSecondaryGroup.setText("Secondary Group #: \t" + PatientHome.patientData.get("secondary-group").toString());
        patientEmployer.setText("Employer Organization: \t" + PatientHome.patientData.get("employer").toString());
        patientEmployerStreet.setText("Street Address: \t" + PatientHome.patientData.get("employer-street").toString());
        patientEmployerCity.setText("City: \t" + PatientHome.patientData.get("employer-city").toString());
        patientEmployerState.setText("State: \t" + PatientHome.patientData.get("employer-state").toString());
        patientEmployerZip.setText("Zip: \t" + PatientHome.patientData.get("employer-zip").toString());

        return fragView;
    }
}
