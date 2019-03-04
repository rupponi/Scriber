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

        patientName.setText("Name: \t" + PatientHome.patientData.get("name").toString());
        patientEmail.setText("Email: \t" + PatientHome.patientData.getId());
        patientStreetAddress.setText("Street Address: \t" + PatientHome.patientData.get("street-address").toString());
        patientCity.setText("City: \t" + PatientHome.patientData.get("city").toString());
        patientState.setText("State: \t" + PatientHome.patientData.get("state").toString());
        patientZip.setText("ZIP: \t" + PatientHome.patientData.get("zip-code").toString());

        return fragView;
    }
}
