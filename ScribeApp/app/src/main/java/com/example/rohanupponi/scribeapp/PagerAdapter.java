package com.example.rohanupponi.scribeapp;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class PagerAdapter extends FragmentStatePagerAdapter {

    int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;

    }

    @Override
    public Fragment getItem (int position) {
        switch(position)
        {
            case 0:
            PersonalTab personalTab = new PersonalTab();
            return personalTab;

            case 1:
            MedicalTab medicalTab = new MedicalTab();
            return medicalTab;


            case 2:
            NotesTab notesTab = new NotesTab();
            return notesTab;

            default:
                return null;
        }

    }

    @Override
    public int getCount () {
        return 0;


    }
}
