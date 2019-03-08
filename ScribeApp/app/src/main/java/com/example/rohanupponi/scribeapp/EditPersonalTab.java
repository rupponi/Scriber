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

    EditText Name, Email, City, StreetAddress, State, Zip, Phone;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_personal_tab, container, false);


        Name = fragView.findViewById(R.id.NameInput);
        Name.setText(PatientHome.patientData.get("name").toString());

        Email = fragView.findViewById(R.id.EmailInput);
        Email.setText(PatientHome.patientData.getId());

        City = fragView.findViewById(R.id.CityInput);
        City.setText(PatientHome.patientData.get("city").toString());

        StreetAddress = fragView.findViewById(R.id.StreetInput);
        StreetAddress.setText(PatientHome.patientData.get("street-address").toString());

        State = fragView.findViewById(R.id.StateInput);
        State.setText(PatientHome.patientData.get("state").toString());

        Zip = fragView.findViewById(R.id.ZipInput);
        Zip.setText(PatientHome.patientData.get("zip-code").toString());

        Phone = fragView.findViewById(R.id.ContactInput);




        return fragView;



    }
}
