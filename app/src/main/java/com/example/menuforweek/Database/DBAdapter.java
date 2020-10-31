package com.example.menuforweek.Database;

import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class DBAdapter {
    private static DBAdapter adapter;
    private static DBHelper db;

    private DBAdapter() {
    }

    public static DBAdapter getInstance(){
        if (adapter==null) adapter = new DBAdapter();
        return adapter;
    }

    public void setBase(DBHelper base){
        db = base;
    }
 ///////////////////////////////////////////////////////////////////////////////////
    public List<String> getVolumeTypeList(){
        return DBFillers.getListVolumeCategories();

    }


}
