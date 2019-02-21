package com.example.rohanupponi.scribeapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PatientProfile extends AppCompatActivity {


    Button Save;

    EditText Name, Date, Phone;

    String Na;
    int Da;
    int Ph;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        Save=findViewById(R.id.SaveButton);
        Name= findViewById(R.id.NameInput);
        Date= findViewById(R.id.AgeInput);
        Phone= findViewById(R.id.ContactInput);

        final SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        String Na1 = prefs.getString("Na", "");
        Name.setText((Na1), TextView.BufferType.EDITABLE);

        int Da1= prefs.getInt("Da",0);
        Date.setText(Integer.toString(Da1), TextView.BufferType.EDITABLE);

        int Ph1= prefs.getInt("Ph", 0);
        Phone.setText(Integer.toString(Ph1));



        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Na = Name.getText().toString().trim();
                Da = Integer.parseInt(Date.getText().toString().trim());
                Ph = Integer.parseInt(Phone.getText().toString().trim());



                SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(PatientProfile.this);
                SharedPreferences.Editor editor = prefs.edit();


                editor.putString("Na",Na);
                editor.putInt("Da",Da);
                editor.putInt("Ph",Ph);
                editor.apply();





            }
        });


    }
}
