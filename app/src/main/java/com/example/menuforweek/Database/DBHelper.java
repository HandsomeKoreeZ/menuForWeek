package com.example.menuforweek.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

class DBHelper extends SQLiteOpenHelper {
    private static final String basename = "WEEKMENUBAZA";
    private static final int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, basename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConst.CREATE_PROD_CAT);
        db.execSQL(DBConst.CREATE_REC_CAT);
        db.execSQL(DBConst.CREATE_REC_TEXT);
        db.execSQL(DBConst.CREATE_PRODUCTS);
        db.execSQL(DBConst.CREATE_VOLUME);
        db.execSQL(DBConst.CREATE_PRICE);
        db.execSQL(DBConst.CREATE_RECIPE);
        db.execSQL(DBConst.CREATE_PERIOD);
        db.execSQL(DBConst.CREATE_DETAIL);
        db.execSQL(DBConst.CREATE_DAY_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
