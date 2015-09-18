package com.example.yazid.meetup.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.yazid.meetup.fragments.tabs.Events;
import com.example.yazid.meetup.fragments.tabs.Posts;

/**
 * Created by Yazid on 18/09/2015.
 */
public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    String [] titles;
    int nbTabs;


    public ViewPagerAdapter(FragmentManager fm,String [] mtitles,int nbTabs) {
        super(fm);
        this.titles=mtitles;
        this.nbTabs=nbTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                    return new Posts();
            case 1:
                    return new Events();
        }

        return null;
    }


    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }

    @Override
    public int getCount() {
        return nbTabs;
    }
}
