package com.luisemilio.appmascotas.Adatadores;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class PageAdapter extends FragmentPagerAdapter {


    private ArrayList<Fragment> fragment;

    public PageAdapter(@NonNull FragmentManager fm, int behavior, ArrayList<Fragment>fragments) {
        super(fm, behavior);
        this.fragment=fragments;
    }


    @NonNull
    @Override
    public Fragment getItem(int position) {
        return fragment.get(position);
    }

    @Override
    public int getCount() {
        return fragment.size();
    }
}