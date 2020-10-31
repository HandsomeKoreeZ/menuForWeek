package com.example.menuforweek.Service;

import android.app.Activity;
import android.view.View;
import android.widget.AdapterView;

public class VolumeSpinnerListener extends Activity implements AdapterView.OnItemSelectedListener {

    public VolumeSpinnerListener(){}


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        parent.getItemAtPosition(position);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
