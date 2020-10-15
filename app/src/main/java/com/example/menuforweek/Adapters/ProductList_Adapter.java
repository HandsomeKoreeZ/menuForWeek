package com.example.menuforweek.Adapters;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.menuforweek.Fragments.*;
import com.example.menuforweek.Interface.*;

class ProductList_Adapter extends FragmentStatePagerAdapter {
    public ProductList_Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int i) {
        Fragment fragment = new Fragment_ProductDaysTab();
        Bundle args = new Bundle();
        // Our object is just an integer :-P
        args.putString(Fragment_ProductDaysTab.ARG_PARAM1, ""+i + 1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 1) {
            return "days";
        }
        return "all";
    }
}
