package com.example.menuforweek;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.menuforweek.Service.*;

public class Fragment_DetailRecipe extends Fragment {


    private FragmentDetailRecipeViewModel mViewModel;

    public static Fragment_DetailRecipe newInstance() {
        return new Fragment_DetailRecipe();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View obs = inflater.inflate(R.layout.fragment_detail_recipe, container, false);

        //добавляю лиснер для добавления новых линий
        LinearLayout parentLL = obs.findViewById(R.id.linearLayout_componentsList);
        LinearLayout subLL = obs.findViewById(R.id.ll1);
        View.OnClickListener clickPlus = new plusConponentLineListener(getContext(),parentLL);
        //minusComponentLineListener clickMinus = new minusComponentLineListener(getContext(),parentLL, subLL);

        obs.findViewById(R.id.p1).setOnClickListener(clickPlus);
        //obs.findViewById(R.id.m1).setOnClickListener(clickMinus);

        return obs;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentDetailRecipeViewModel.class);
        // TODO: Use the ViewModel

    }

}