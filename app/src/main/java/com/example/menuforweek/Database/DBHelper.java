package com.example.menuforweek.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.menuforweek.Entities.*;
import com.example.menuforweek.Interface.Product;

public class DBHelper extends SQLiteOpenHelper {
    private static final String basename = "WEEKMENUBAZA";
    private static final int version = 1;

    public DBHelper(@Nullable Context context) {
        super(context, basename, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(DBConst.CREATE_PROD_CAT);
            db.execSQL(DBConst.CREATE_REC_CAT);
            db.execSQL(DBConst.CREATE_VOLUME);
            db.execSQL(DBConst.CREATE_RECIPE);
            db.execSQL(DBConst.CREATE_PERIOD);
            db.execSQL(DBConst.CREATE_PRODUCTS);
            db.execSQL(DBConst.CREATE_PRICE);
            db.execSQL(DBConst.CREATE_REC_CAT_INTERS);
            db.execSQL(DBConst.CREATE_DETAIL);
            db.execSQL(DBConst.CREATE_DAY_TABLE);
            initialize(db);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void initialize(SQLiteDatabase db){
        DBFillers.fillContentList(DBFillers.getListProductCategory(),DBConst.COL_NAME).forEach((ContentValues cv)->System.out.println(db.insert(DBConst.TAB_PROD_CAT,null,cv)));
        DBFillers.fillContentList(DBFillers.getListPeriod(),DBConst.COL_NAME).forEach((ContentValues cv)->db.insert(DBConst.TAB_PERIOD,null,cv));
        DBFillers.fillContentList(DBFillers.getListVolumeCategories(),DBConst.COL_NAME).forEach((ContentValues cv)->db.insert(DBConst.TAB_VOL,null,cv));
        DBFillers.fillContentList(DBFillers.getListRecipeCategory(),DBConst.COL_NAME).forEach((ContentValues cv)-> db.insert(DBConst.TAB_REC_CATEGORY,null,cv));
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

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int getIDfrom(String table, String name ){
        int id;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select "+DBConst.COL_ID+" from "+table+" where "+DBConst.COL_NAME+"="+name;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        id = cursor.getInt(cursor.getColumnIndex(DBConst.COL_ID));
        cursor.close();
        db.close();
        return id;
    }

    public String getTextFrom(String table,String col, int id){
        String text;
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "select "+DBConst.COL_NAME+" from "+table+" where "+DBConst.COL_ID+"="+id;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();
        text = cursor.getString(cursor.getColumnIndex(col));
        cursor.close();
        db.close();
        return text;
    }

    public void insertRawProduct(Product_raw product){
        SQLiteDatabase db = this.getWritableDatabase();
        String name = product.getName();
        ContentValues cv = new ContentValues();
        cv.put(DBConst.COL_NAME,name);
        db.insert(DBConst.TAB_PROD,null,cv);
        db.close();
    }

    public Product getRawProduct(int id){
        SQLiteDatabase db = this.getReadableDatabase();
        Product_raw product = null;
        int id_cat;
        String prodName;
        String sql = "select * from "+DBConst.TAB_PROD+" where " + DBConst.COL_ID+"="+id;
        Cursor cursor = db.rawQuery(sql,null);
        cursor.moveToFirst();


        try {
            // gathering information from database
            id_cat = cursor.getInt(cursor.getColumnIndex(DBConst.COL_CAT_ID));
            prodName = cursor.getString(cursor.getColumnIndex(DBConst.COL_NAME));
            cursor.close();
            db.close();

            // set information up
            product = new Product_raw();
            product.setID(id);
            product.setName(prodName);
        } catch (Exception e) {
            System.out.println("------------------------------------------> doesn't exist product");
        }
        return product;
    }



    public void insertRecipe(Recipe recipe){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        int id_rec;
        String name = recipe.getName();
        String text = recipe.getText();
        cv.put(DBConst.COL_NAME,name);
        cv.put(DBConst.COL_REC_TEXT,text);
        id_rec = (int) db.insert(DBConst.TAB_RECIPE,null,cv);

        //insert all products to the details
        recipe.getDetails().forEach((prod)-> setProductToDetail(id_rec,prod,db));

        //insert all categories that indicated
        recipe.getCategories().forEach((cat)-> setCategoryOfRecipe(id_rec,getIDfrom(DBConst.TAB_REC_CATEGORY,cat),db));
        db.close();

    }

    public Recipe getRecipe(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Recipe recipe = new Recipe();
        recipe.setId(id);
        recipe.setName(getTextFrom(DBConst.TAB_RECIPE, DBConst.COL_NAME, id));
        recipe.setText(getTextFrom(DBConst.TAB_RECIPE, DBConst.COL_REC_TEXT, id));


        //get product list from product/recipes intersections
        String sql = "select * from " + DBConst.TAB_REC_DETAIL + " where " + DBConst.COL_REC_ID + " = " + id;
        Cursor cursor = db.rawQuery(sql, null);
        int idprod;
        int volume;
        do {
            idprod = cursor.getInt(cursor.getColumnIndex(DBConst.COL_PROD_ID));
            volume = cursor.getInt(cursor.getColumnIndex(DBConst.COL_VOL));
            recipe.addProduct(new Product_Full(getRawProduct(idprod),volume));
        }while(cursor.moveToNext());
        cursor.close();

        //get categories list from categories/recipes intersection
        sql = "select * from "+DBConst.TAB_REC_CAT_INTERS+" where "+DBConst.COL_REC_ID+" = "+id;
        cursor = db.rawQuery(sql,null);
        int idcat;
        do{
            idcat = cursor.getInt(cursor.getColumnIndex(DBConst.COL_CAT_ID));
            recipe.addCategory(getTextFrom(DBConst.TAB_REC_CATEGORY,DBConst.COL_NAME,idcat));
        }while(cursor.moveToNext());
        cursor.close();

        return recipe;
    }

    public void updateDay(DaySchedule day ){
        SQLiteDatabase db = this.getWritableDatabase();
        int periodID;
        ContentValues cv;

        for(Meal m: day.getDayschedule() ){
                cv = new ContentValues();
                cv.put(DBConst.COL_ID,day.getId());
                cv.put(DBConst.COL_NAME,day.getName());
                periodID = getIDfrom(DBConst.TAB_PERIOD, m.getPeriod());
                cv.put(DBConst.COL_PERIOD_ID,periodID);
                cv.put(DBConst.COL_REC_ID, m.getDish().getId());
                db.replace(DBConst.TAB_DAY,null,cv);
        }
    }


    public DaySchedule getDay(String name){
        // возвращаемый элемент без ID
        SQLiteDatabase db = this.getReadableDatabase();
        DaySchedule day = new DaySchedule();
        Meal meal;
        Recipe recipe;
        String period;
        int idPeriod, idRecipe;
        String sql = "SELECT * FROM "+DBConst.TAB_DAY + " WHERE "+ DBConst.COL_NAME +  " = " + name;

        day.setName(name);
        Cursor cursor = db.rawQuery(sql,null);
        do{
            idPeriod = cursor.getInt(cursor.getColumnIndex(DBConst.COL_PERIOD_ID));
            period = getTextFrom(DBConst.TAB_PERIOD,DBConst.COL_NAME,idPeriod);
            idRecipe = cursor.getInt(cursor.getColumnIndex(DBConst.COL_REC_ID));
            recipe = getRecipe(idRecipe);
            meal = new Meal(period,recipe);
            day.addMeal(meal);
        }while (cursor.moveToNext());

        return day;
    }





    //////////////////////////////////////////////////////////////////////////////////////
    //methods for internal use

    private void setProductToDetail(int id_rec, Product product, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        Product_Full product_full = (Product_Full) product;
        cv.put(DBConst.COL_REC_ID,id_rec);
        cv.put(DBConst.COL_PROD_ID, product_full.getID());
        cv.put(DBConst.COL_VOL_ID,product_full.getVolType());
        cv.put(DBConst.COL_VOL, product_full.getVolume());
        db.insert(DBConst.TAB_REC_DETAIL,null,cv);
    }

    private void setCategoryOfRecipe(int id_rec, int id_cat, SQLiteDatabase db){
        ContentValues cv = new ContentValues();
        cv.put(DBConst.COL_REC_ID,id_rec);
        cv.put(DBConst.COL_CAT_ID,id_cat);
        db.insert(DBConst.TAB_REC_CAT_INTERS,null, cv);
    }




}
