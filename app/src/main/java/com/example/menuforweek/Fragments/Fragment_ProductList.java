package com.example.menuforweek.Fragments;

import android.os.Bundle;

import com.example.menuforweek.Adapters.ProductList_Adapter;
import com.google.android.material.tabs.TabLayout;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.menuforweek.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_ProductList#newInstance} factory method to
 * create an instance of this fragment.
 */

public class Fragment_ProductList extends Fragment{

    ViewPager pager;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_ProductList() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_ProductList.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_ProductList newInstance(Integer param1, String param2) {
        Fragment_ProductList fragment = new Fragment_ProductList();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_product_list, container, false);
        TabLayout tl = v.findViewById(R.id.tablayout_productList);
        ProductList_Adapter adapter = new ProductList_Adapter(getFragmentManager());
        pager = v.findViewById(R.id.viewpager_productList);

        pager.setAdapter(adapter);
        tl.setupWithViewPager(pager);



        return v;
    }
}


