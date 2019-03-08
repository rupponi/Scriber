package com.example.rohanupponi.scribeapp;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EditPatient extends AppCompatActivity {


    Button Save;
    static SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_patient);

        ViewPager viewPager = findViewById(R.id.edit_view_pager);
        viewPager.setAdapter(new EditViewPagerAdapter(getSupportFragmentManager()));


        TabLayout editTabs = findViewById(R.id.edit_tabs);
        editTabs.setTabTextColors(ContextCompat.getColor(getApplicationContext(), R.color.unselectedTab), ContextCompat.getColor(getApplicationContext(), R.color.selectedTab));

        editTabs.setupWithViewPager(viewPager);



        Save=findViewById(R.id.save_changes_button);

        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText Name = findViewById(R.id.NameInput);
                EditText Email = findViewById(R.id.EmailInput);
                EditText Date = findViewById(R.id.AgeInput);
                EditText Phone = findViewById(R.id.ContactInput);

               String Na = Name.getText().toString().trim();
               String Da = (Date.getText().toString().trim());
               String Ph = (Phone.getText().toString().trim());
               String Em = Email.getText().toString().trim();




                prefs = PreferenceManager.getDefaultSharedPreferences(EditPatient.this);
                SharedPreferences.Editor editor = prefs.edit();


                editor.putString("Na",Na);
                editor.putString("Da",Da);
                editor.putString("Ph",Ph);
                editor.putString("Em", Em);
                editor.apply();


                Toast successfulSave = Toast.makeText(getApplicationContext(), "Your profile was successfully saved!", Toast.LENGTH_LONG);
                successfulSave.show();





            }
        });



    }
}
