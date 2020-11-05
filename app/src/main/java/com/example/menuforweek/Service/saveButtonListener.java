package com.example.menuforweek.Service;

import android.content.Context;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.menuforweek.Database.DBAdapter;
import com.example.menuforweek.Entities.Product_Full;
import com.example.menuforweek.Entities.Recipe;
import com.example.menuforweek.Interface.Product;
import com.example.menuforweek.R;
import com.example.menuforweek.ViewModification.NewRecipeLine;

import java.util.ArrayList;

public class saveButtonListener implements View.OnClickListener {
    private DBAdapter db;
    private View parent;

    public saveButtonListener(Context context, View parent) {
        db = DBAdapter.getInstance();
        this.parent = parent;

    }

    @Override
    public void onClick(View v) {
        Recipe recipe = new Recipe();

        EditText recNameET = parent.findViewById(R.id.editTextRecipeName);
        EditText recText   = parent.findViewById(R.id.editTextRecipe);
        recipe.setName(String.valueOf(recNameET.getText()));
        recipe.setText(String.valueOf(recText.getText()));
        recipe.setCategories(harvestRecipeCategories(parent));
        recipe.setDetails(harvestProducts(parent));
        db.addRecipe(recipe);
    }




    private ArrayList<String> harvestRecipeCategories(View inflater){
        ArrayList<String> list = new ArrayList<>();

        CheckBox box = inflater.findViewById(R.id.checkBox_breakfast);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_dessert);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_fish);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_garnish);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_mainPlate);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_meat);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_other);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_salad);
        if(box.isChecked()) list.add((String) box.getText());

        box = inflater.findViewById(R.id.checkBox_soup);
        if(box.isChecked()) list.add((String) box.getText());

        return list;
    }

    private ArrayList<Product> harvestProducts(View inflater){
        ArrayList<Product> list = new ArrayList<>();
        int lineCounter = 1;
        LinearLayout ll = inflater.findViewWithTag(NewRecipeLine.tagLL+lineCounter);
        EditText productName, productVol;
        Spinner productVolType;

        String tempName, tempVolType;
        Integer tempVol;
        while(ll != null){
            productName = inflater.findViewWithTag(NewRecipeLine.tagName+lineCounter);
            productVol = inflater.findViewWithTag(NewRecipeLine.tagVolumeValue+lineCounter);
            productVolType = inflater.findViewWithTag(NewRecipeLine.tagSpinner+lineCounter);

            tempName = String.valueOf(productName.getText());
            tempVolType = String.valueOf(productVolType.getSelectedItem());
            tempVol = Integer.parseInt(String.valueOf(productVol.getText()));
            list.add(new Product_Full(tempName, tempVolType,tempVol));
            lineCounter++;
            ll = inflater.findViewWithTag(NewRecipeLine.tagLL+lineCounter);
        }
        return list;
    }
}
