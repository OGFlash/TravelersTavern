package com.wildlab.travelerstavern.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ogflash
 * @since 9/14/2017.
 */

public class SectionsPageAdapter extends FragmentPagerAdapter {

    private final List<Fragment> fragmentList = new ArrayList<>();
    private final List<String> titleLists = new ArrayList<>();

    public void addFragment(Fragment fragment, String title){
        fragmentList.add(fragment);
        titleLists.add(title);
    }

    public SectionsPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return titleLists.get(position);
    }
}
