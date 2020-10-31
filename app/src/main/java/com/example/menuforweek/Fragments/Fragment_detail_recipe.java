package com.example.menuforweek.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.menuforweek.Database.DBAdapter;
import com.example.menuforweek.R;
import com.example.menuforweek.Service.VolumeSpinnerListener;
import com.example.menuforweek.Service.plusConponentLineListener;

import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_detail_recipe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_detail_recipe extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private Spinner spinner;
    DBAdapter db;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Fragment_detail_recipe() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_detail_recipe.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_detail_recipe newInstance(String param1, String param2) {
        Fragment_detail_recipe fragment = new Fragment_detail_recipe();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = DBAdapter.getInstance();
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View obs = inflater.inflate(R.layout.fragment_detail_recipe, container, false);

        //поиск нужных вьюшек
        LinearLayout parentLL = obs.findViewById(R.id.linearLayout_componentsList);
        LinearLayout subLL = obs.findViewById(R.id.ll1);
        spinner = obs.findViewById(R.id.volSpinner1);

        //настройка спиннера
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Objects.requireNonNull(getContext()),android.R.layout.simple_spinner_item,  db.getVolumeTypeList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new VolumeSpinnerListener());

        //добавляю лиснер для добавления новых линий
        View.OnClickListener clickPlus = new plusConponentLineListener(getContext(),parentLL);
        //minusComponentLineListener clickMinus = new minusComponentLineListener(getContext(),parentLL, subLL);

        obs.findViewById(R.id.p1).setOnClickListener(clickPlus);
        //obs.findViewById(R.id.m1).setOnClickListener(clickMinus);

        return obs;
    }
}