package com.llucasallvarenga.timetosleep.adapters;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> Fragment = new ArrayList<>(); //Fragment List
    private ArrayList<String> NamePage = new ArrayList<>(); // Fragment Name List

    public ViewPagerAdapter(FragmentManager mn) {
        super(mn);
    }
    public void add(Fragment Frag, String Title) {
        Fragment.add(Frag);
        NamePage.add(Title);
    }
    @Override
    public Fragment getItem(int position) {
        return Fragment.get(position);
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return NamePage.get(position);
    }
    @Override
    public int getCount() {
        return 3;
    }
}