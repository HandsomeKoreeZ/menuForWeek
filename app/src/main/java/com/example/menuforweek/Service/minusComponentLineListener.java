package com.example.menuforweek.Service;

import android.content.Context;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.example.menuforweek.R;

public class minusComponentLineListener implements View.OnClickListener {
    LinearLayout parent, target;
    Context context;

    public minusComponentLineListener(Context context,LinearLayout parent, LinearLayout target) {
        this.target = target;
        this.context = context;
        this.parent = parent;
    }

    @Override
    public void onClick(View v) {
        v.startAnimation(AnimationUtils.loadAnimation(context, R.anim.onclick_animation));
        parent.removeView(target);
    }
}
