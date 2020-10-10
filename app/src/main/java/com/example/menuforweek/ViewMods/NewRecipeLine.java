package com.example.menuforweek.ViewMods;

import android.content.Context;
import android.text.InputType;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.menuforweek.R;
import com.example.menuforweek.Service.minusComponentLineListener;
import com.example.menuforweek.Service.plusConponentLineListener;


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


}
