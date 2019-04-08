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

    EditText editPrimaryEmergencyContactName, editPrimaryEmergencyContactPhone, editSecondaryEmergencyContactName, editSecondaryEmergencyContactPhone, editPatientBloodType, editPatientPrescriptions, editPatientVaccinations, editPatientLifestyle, editPatientAllergies, editPatientFamilyHistory, editPatientSurgicalHistory, editPatientMedicalConditions;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_medical_tab, container, false);

        editPrimaryEmergencyContactName = fragView.findViewById(R.id.edit_primary_emergency_name);
        editPrimaryEmergencyContactName.setText(PatientHome.patientData.get("primary-em-contact").toString());

        editPrimaryEmergencyContactPhone = fragView.findViewById(R.id.EPrimaryEContactInput);
        editPrimaryEmergencyContactPhone.setText(PatientHome.patientData.get("primary-em-phone").toString());

        editSecondaryEmergencyContactName = fragView.findViewById(R.id.ESecondaryEmergencyInput);
        editSecondaryEmergencyContactName.setText(PatientHome.patientData.get("secondary-em-contact").toString());

        editSecondaryEmergencyContactPhone = fragView.findViewById(R.id.ESecondaryEContactInput);
        editSecondaryEmergencyContactPhone.setText(PatientHome.patientData.get("secondary-em-phone").toString());

        editPatientBloodType = fragView.findViewById(R.id.EBloodtypeInput);
        editPatientBloodType.setText(PatientHome.patientData.get("blood-type").toString());

        editPatientPrescriptions = fragView.findViewById(R.id.EPrescriptionInput);
        editPatientPrescriptions.setText(PatientHome.patientData.get("prescription-dosage").toString());

        editPatientVaccinations = fragView.findViewById(R.id.EVaccinationInput);
        editPatientVaccinations.setText(PatientHome.patientData.get("vaccinations").toString());

        editPatientLifestyle = fragView.findViewById(R.id.ELifestyleInput);
        editPatientLifestyle.setText(PatientHome.patientData.get("lifestyle").toString());

        editPatientAllergies = fragView.findViewById(R.id.EAllergiesInput);
        editPatientAllergies.setText(PatientHome.patientData.get("allergies").toString());

        editPatientFamilyHistory = fragView.findViewById(R.id.EFamilyHistoryInput);
        editPatientFamilyHistory.setText(PatientHome.patientData.get("family-history").toString());

        editPatientSurgicalHistory = fragView.findViewById(R.id.ESurgicalHistoryInput);
        editPatientSurgicalHistory.setText(PatientHome.patientData.get("surgical-history").toString());

        editPatientMedicalConditions = fragView.findViewById(R.id.EConditionsInput);
        editPatientMedicalConditions.setText(PatientHome.patientData.get("conditions").toString());

        return fragView;


    }
}
