package com.example.rakesh.news;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rakesh on 12-07-2018.
 */

public class ViewPagerAdaper extends FragmentPagerAdapter {
    private final List<Fragment> listFragmnt= new ArrayList<>();
    private final List<String> listTitle = new ArrayList<>();

    public ViewPagerAdaper(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return listFragmnt.get(position);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitle.get(position);
    }

    @Override
    public int getCount() {
        return listTitle.size();
    }
    public void AddFragment (Fragment fragment,String title){
        listFragmnt.add(fragment);
        listTitle.add(title);
    }
}
