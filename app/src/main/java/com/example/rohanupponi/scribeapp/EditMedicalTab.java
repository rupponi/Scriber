package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;


import java.util.Arrays;
import java.util.List;

import javax.annotation.Nullable;


public class EditMedicalTab extends Fragment {
    @Nullable

    private EditText editPrimaryEmergencyContactName, editPrimaryEmergencyContactPhone, editSecondaryEmergencyContactName, editSecondaryEmergencyContactPhone, editPatientBloodType, editPatientPrescriptions, editPatientVaccinations, editPatientLifestyle, editPatientAllergies, editPatientFamilyHistory, editPatientSurgicalHistory, editPatientMedicalConditions;
    private Spinner editBloodType;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_edit_medical_tab, container, false);

        List<String> bloodTypeChoices = Arrays.asList(getResources().getStringArray(R.array.blood_type_array));

        editPrimaryEmergencyContactName = fragView.findViewById(R.id.edit_primary_emergency_name);
        editPrimaryEmergencyContactName.setText(PatientHome.patientData.get("primary-emergency-name").toString());

        editPrimaryEmergencyContactPhone = fragView.findViewById(R.id.edit_primary_emergency_phone);
        editPrimaryEmergencyContactPhone.setText(PatientHome.patientData.get("primary-emergency-phone").toString());
        editPrimaryEmergencyContactPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());

        editSecondaryEmergencyContactName = fragView.findViewById(R.id.edit_secondary_emergency_name);
        editSecondaryEmergencyContactName.setText(PatientHome.patientData.get("secondary-emergency-name").toString());

        editSecondaryEmergencyContactPhone = fragView.findViewById(R.id.edit_secondary_emergency_phone);
        editSecondaryEmergencyContactPhone.setText(PatientHome.patientData.get("secondary-emergency-phone").toString());
        editSecondaryEmergencyContactPhone.addTextChangedListener(new PhoneNumberFormattingTextWatcher());


        editBloodType = fragView.findViewById(R.id.EBloodtypeInput);
        ArrayAdapter bloodTypeAdapter = ArrayAdapter.createFromResource(getActivity().getApplicationContext(),
                R.array.blood_type_array,
                R.layout.dropdown_layout
        );
        bloodTypeAdapter.setDropDownViewResource(R.layout.dropdown_layout);
        editBloodType.setAdapter(bloodTypeAdapter);
        String currentBloodType = PatientHome.patientData.get("blood-type").toString().trim();
        int currentBloodTypeIndex = bloodTypeChoices.indexOf(currentBloodType);
        editBloodType.setSelection(currentBloodTypeIndex);


        editPatientPrescriptions = fragView.findViewById(R.id.edit_prescriptions);
        editPatientPrescriptions.setText(PatientHome.patientData.get("prescriptions").toString());

        editPatientVaccinations = fragView.findViewById(R.id.edit_vaccinations);
        editPatientVaccinations.setText(PatientHome.patientData.get("vaccinations").toString());

        editPatientLifestyle = fragView.findViewById(R.id.edit_lifestyle);
        editPatientLifestyle.setText(PatientHome.patientData.get("lifestyle").toString());

        editPatientAllergies = fragView.findViewById(R.id.edit_allergies);
        editPatientAllergies.setText(PatientHome.patientData.get("allergies").toString());

        editPatientFamilyHistory = fragView.findViewById(R.id.edit_family_history);
        editPatientFamilyHistory.setText(PatientHome.patientData.get("family-history").toString());

        editPatientSurgicalHistory = fragView.findViewById(R.id.edit_surgical_history);
        editPatientSurgicalHistory.setText(PatientHome.patientData.get("surgical-history").toString());

        editPatientMedicalConditions = fragView.findViewById(R.id.edit_medical_conditions);
        editPatientMedicalConditions.setText(PatientHome.patientData.get("conditions").toString());

        return fragView;


    }
}
