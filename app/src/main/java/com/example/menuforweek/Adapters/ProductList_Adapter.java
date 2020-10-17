package com.example.menuforweek.Adapters;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.menuforweek.Fragments.*;

public class ProductList_Adapter extends FragmentStatePagerAdapter {
    public ProductList_Adapter(FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int i) {
        Fragment fragment = (i==1)?new Fragment_productAllTab():new Fragment_productDaysTab();
        Bundle args = new Bundle();

        // тут будет закидываться список продуктов одним объектом
        //args.putSerializable(Fragment_ProductDaysTab.ARG_PARAM1, ""+i + 1);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position == 0) {
            return "days";
        }
        return "all";
    }
}
