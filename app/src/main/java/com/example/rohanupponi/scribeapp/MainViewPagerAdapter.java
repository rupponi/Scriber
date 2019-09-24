package com.example.rohanupponi.scribeapp;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

public class MainViewPagerAdapter extends FragmentPagerAdapter {

    private final int NUM_TABS = 3;
    private Fragment[] tabs;
    private String[] tabTitles = new String[] {
            "Personal",
            "Medical",
            "Notes"
    };

    public MainViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);

        tabs = new Fragment[] {
                new PersonalTab(),
                new MedicalTab(),
                new NotesTab()
        };
    }

    @Override
    public Fragment getItem(int currentPos) {
        return tabs[currentPos];
    }

    @Override
    public int getCount() {
        return NUM_TABS;
    }

    @Override
    public CharSequence getPageTitle(int currentPos) {
        return tabTitles[currentPos];
    }
}
