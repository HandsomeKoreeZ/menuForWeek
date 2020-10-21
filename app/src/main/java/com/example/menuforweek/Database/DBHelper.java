package com.example.menuforweek.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private static final String basename = "WEEKMENUBAZA";
    private static final int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, basename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DBConst.CREATE_PROD_CAT);
        db.execSQL(DBConst.CREATE_REC_CAT);
        db.execSQL(DBConst.CREATE_VOLUME);
        db.execSQL(DBConst.CREATE_PERIOD);
        db.execSQL(DBConst.CREATE_REC_TEXT);
        db.execSQL(DBConst.CREATE_PRODUCTS);
        db.execSQL(DBConst.CREATE_PRICE);
        db.execSQL(DBConst.CREATE_RECIPE);
        db.execSQL(DBConst.CREATE_DETAIL);
        db.execSQL(DBConst.CREATE_DAY_TABLE);
        initialize();
    }

    private void initialize(){
        SQLiteDatabase db = this.getWritableDatabase();
        DBFillers.productCategoryList().forEach((ContentValues cv)->{db.insert(DBConst.TAB_PROD_CAT,null,cv);});
        DBFillers.mealPeriodList().forEach((ContentValues cv)->{db.insert(DBConst.TAB_PROD_CAT,null,cv);});
        DBFillers.volumeCategoriesList().forEach((ContentValues cv)->{db.insert(DBConst.TAB_PROD_CAT,null,cv);});
        DBFillers.recipeCategoryList().forEach((ContentValues cv)->{db.insert(DBConst.TAB_PROD_CAT,null,cv);});
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_DAY);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_REC_DETAIL);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_RECIPE);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_PRICE);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_PROD);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_REC_TEXT);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_REC_CATEGORY);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_PROD_CAT);
        db.execSQL("DROP TABLE IF EXISTS "+DBConst.TAB_VOL);
        onCreate(db);
    }
}
