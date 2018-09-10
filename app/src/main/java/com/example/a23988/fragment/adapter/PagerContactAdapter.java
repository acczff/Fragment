package com.example.a23988.fragment.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import utils.app.BaseFragment;

public class PagerContactAdapter extends FragmentPagerAdapter {

    private BaseFragment[] frags;
    private String[] str;
    public PagerContactAdapter(FragmentManager fm,BaseFragment[] frags,String[] str) {
        super(fm);
        this.frags = frags;
        this.str = str;
    }

    @Override
    public Fragment getItem(int i) {
        return frags[i];
    }

    @Override
    public int getCount() {
        return frags.length;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return str[position];
    }
}
