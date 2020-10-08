package com.example.menuforweek.Service;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.menuforweek.R;
import com.example.menuforweek.ViewMods.*;


public class plusConponentLineListener implements View.OnClickListener {
    private LinearLayout parent;
    private Context context;

    public plusConponentLineListener(Context context, LinearLayout ll) {
      this.parent = ll;
      this.context = context;
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(context,R.anim.onclick_animation));
        parent.addView(new NewRecipeLine(context,parent));
    }
}
