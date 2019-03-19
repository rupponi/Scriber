package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


import javax.annotation.Nullable;


public class EditMedicalTab extends Fragment {
    @Nullable

    EditText PrimaryEmergency, PrimaryEPhone, SecondaryEmergency, SecondaryEPhone, Bloodtype, Prescriptions, Vaccinations, Lifestyle, Allergies, FamilyHistory, SurgicalHistory, Conditions;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_medical_tab, container, false);

        PrimaryEmergency = fragView.findViewById(R.id.EPrimaryEmergencyInput);
        PrimaryEmergency.setText(PatientHome.patientData.get("primary-em-contact").toString());

        PrimaryEPhone = fragView.findViewById(R.id.EPrimaryEContactInput);
        PrimaryEPhone.setText(PatientHome.patientData.get("primary-em-phone").toString());

        SecondaryEmergency = fragView.findViewById(R.id.ESecondaryEmergencyInput);
        SecondaryEmergency.setText(PatientHome.patientData.get("secondary-em-contact").toString());

        SecondaryEPhone = fragView.findViewById(R.id.ESecondaryEContactInput);
        SecondaryEPhone.setText(PatientHome.patientData.get("secondary-em-phone").toString());

        Bloodtype = fragView.findViewById(R.id.EBloodtypeInput);
        Bloodtype.setText(PatientHome.patientData.get("blood-type").toString());

        Prescriptions = fragView.findViewById(R.id.EPrescriptionInput);
        Prescriptions.setText(PatientHome.patientData.get("prescription-dosage").toString());

        Vaccinations = fragView.findViewById(R.id.EVaccinationInput);
        Vaccinations.setText(PatientHome.patientData.get("vaccinations").toString());

        Lifestyle = fragView.findViewById(R.id.ELifestyleInput);
        Lifestyle.setText(PatientHome.patientData.get("lifestyle").toString());

        Allergies = fragView.findViewById(R.id.EAllergiesInput);
        Allergies.setText(PatientHome.patientData.get("allergies").toString());

        FamilyHistory = fragView.findViewById(R.id.EFamilyHistoryInput);
        FamilyHistory.setText(PatientHome.patientData.get("family-history").toString());

        SurgicalHistory = fragView.findViewById(R.id.ESurgicalHistoryInput);
        SurgicalHistory.setText(PatientHome.patientData.get("surgical-history").toString());

        Conditions = fragView.findViewById(R.id.EConditionsInput);
        Conditions.setText(PatientHome.patientData.get("conditions").toString());

        return fragView;


    }
}
