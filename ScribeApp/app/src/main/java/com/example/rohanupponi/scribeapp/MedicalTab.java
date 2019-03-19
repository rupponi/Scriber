package com.example.rohanupponi.scribeapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import javax.annotation.Nullable;

public class MedicalTab extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View fragView = inflater.inflate(R.layout.fragment_medical_tab, container, false);

        TextView primaryEmergency = fragView.findViewById(R.id.PrimaryEmergencyInput);
        TextView primaryEPhone = fragView.findViewById(R.id.PrimaryEContactInput);
        TextView secondaryEmergency = fragView.findViewById(R.id.SecondaryEmergencyInput);
        TextView secondaryEPhone = fragView.findViewById(R.id.SecondaryEContactInput);
        TextView bloodType = fragView.findViewById(R.id.BloodtypeInput);
        TextView prescriptions = fragView.findViewById(R.id.PrescriptionInput);
        TextView vaccinations = fragView.findViewById(R.id.VaccinationInput);
        TextView lifestyle = fragView.findViewById(R.id.LifestyleInput);
        TextView allergies = fragView.findViewById(R.id.AllergiesInput);
        TextView familyHistory = fragView.findViewById(R.id.FamilyHistoryInput);
        TextView surgicalHistory = fragView.findViewById(R.id.SurgicalHistoryInput);
        TextView conditions = fragView.findViewById(R.id.ConditionsInput);

        primaryEmergency.setText("Emergency Contact: \t" + PatientHome.patientData.get("primary-em-contact").toString());
        primaryEPhone.setText("Emergency Phone: \t" + PatientHome.patientData.get("primary-em-phone").toString());
        secondaryEmergency.setText("Secondary Contact: \t" + PatientHome.patientData.get("secondary-em-contact").toString());
        secondaryEPhone.setText("Secondary Phone: \t" + PatientHome.patientData.get("secondary-em-phone").toString());
        bloodType.setText("Blood Type: \t" + PatientHome.patientData.get("blood-type").toString());
        prescriptions.setText("Prescriptions/Dosages: \t" + PatientHome.patientData.get("prescription-dosage").toString());
        vaccinations.setText("Vaccinations: \t" + PatientHome.patientData.get("vaccinations").toString());
        lifestyle.setText("Lifestyle: \t" + PatientHome.patientData.get("lifestyle").toString());
        allergies.setText("Allergies: \t" + PatientHome.patientData.get("allergies").toString());
        familyHistory.setText("Family Medical History: \t" + PatientHome.patientData.get("family-history").toString());
        surgicalHistory.setText("Surgical History: \t" + PatientHome.patientData.get("surgical-history").toString());
        conditions.setText("Conditions: \t" + PatientHome.patientData.get("conditions").toString());

        return fragView;
    }
}
