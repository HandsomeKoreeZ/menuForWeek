package com.example.menuforweek.ViewModification;

import android.content.Context;
import android.text.InputType;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.menuforweek.Database.DBAdapter;
import com.example.menuforweek.R;
import com.example.menuforweek.Service.VolumeSpinnerListener;
import com.example.menuforweek.Service.minusComponentLineListener;

import java.util.Objects;


public class NewRecipeLine extends LinearLayout{
    private final LinearLayout.LayoutParams small = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, (float) 0.3);
    private final LinearLayout.LayoutParams large = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
    private static Integer lines = 1;

    public NewRecipeLine(Context context, LinearLayout parent) {
        super(context);
        normalize();
        EditText name = createEditText(context,R.string.newComponentHint);
        name.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,(float)0.5));
        this.addView(name);
        this.addView(createEditText(context,R.string.newComponentVolumeHint));
        this.addView(createSpinner(context));

        Button minus = createButton(context,R.string.symbol_minus,getResources().getColor(R.color.button_minus,null));
        OnClickListener clickMinus = new minusComponentLineListener(context,parent,this);
        minus.setOnClickListener(clickMinus);
        this.addView(minus);
    }

    private void normalize(){
        this.setLayoutParams(large);
        this.setOrientation(LinearLayout.HORIZONTAL);
        this.setGravity(Gravity.END);
        NewRecipeLine.lines++;
    }

    private EditText createEditText(Context context, int hint){
        EditText et = new EditText(context);
        et.setLayoutParams(small);
        et.setHint(hint);
        et.setGravity(Gravity.CENTER);
        et.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
        et.setTextSize(16);

        return et;
    }

    private Button createButton(Context context, int text, int color){
        int dp40 = (int) (50*context.getResources().getDisplayMetrics().density);                   //конвертирую dp в пиксели, потому что размеры принимаются только в пикселях
        Button bb = new Button(context);
        bb.setLayoutParams(new LinearLayout.LayoutParams(dp40,dp40));
        bb.setText(text);
        bb.setBackgroundColor(getResources().getColor(R.color.transparent,null));
        bb.setTextColor(color);
        bb.setGravity(Gravity.CENTER);
        bb.setTextSize(24);
        return bb;
    }

    private Spinner createSpinner(Context context){
        Spinner spinner = new Spinner(context);
        DBAdapter db = DBAdapter.getInstance();
        spinner.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT,(float)0.2));
        spinner.setGravity(Gravity.CENTER);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(Objects.requireNonNull(getContext()),android.R.layout.simple_spinner_item,  db.getVolumeTypeList());
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new VolumeSpinnerListener());



        return spinner;
    }


}
