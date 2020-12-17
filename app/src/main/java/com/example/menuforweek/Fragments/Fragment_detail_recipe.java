package com.example.menuforweek.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.renderscript.ScriptGroup;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.menuforweek.Database.DBAdapter;
import com.example.menuforweek.Entities.Product_Full;
import com.example.menuforweek.Entities.Recipe;
import com.example.menuforweek.Interface.Product;
import com.example.menuforweek.R;
import com.example.menuforweek.Service.VolumeSpinnerListener;
import com.example.menuforweek.Service.plusConponentLineListener;
import com.example.menuforweek.Service.saveButtonListener;
import com.example.menuforweek.ViewModification.NewRecipeLine;
import com.example.menuforweek.databinding.ActivityMainBinding;
import com.example.menuforweek.testObjects.testEntities;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Objects;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Fragment_detail_recipe#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_detail_recipe extends Fragment {

    private Spinner spinner;
    private DBAdapter db;
    private Button saveButton;

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
     * @return A new instance of fragment Fragment_detail_recipe.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_detail_recipe newInstance() {
        Fragment_detail_recipe fragment = new Fragment_detail_recipe();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = DBAdapter.getInstance();
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

        //кнопка сохранения рецепта и последующее его сохранение
        saveButton = obs.findViewById(R.id.buttonSaveRecipe);
        View.OnClickListener clickSave = new saveButtonListener(getContext(),obs);
        saveButton.setOnClickListener(clickSave);

        //TODO
        //remove this after test
        db.addRecipe(testEntities.getPotatoPoure());

        return obs;
    }

}