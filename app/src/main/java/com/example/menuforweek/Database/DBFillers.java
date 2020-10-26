package com.example.menuforweek.Database;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.List;

public class DBFillers {

    public static List<ContentValues> volumeCategoriesList(){
        List<ContentValues> filler = new ArrayList<>();
        ContentValues cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"кг");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"гр");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"л");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"мл");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"ч.л");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"ст.л");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"стакан");
        filler.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"шт");
        filler.add(cv);

        return filler;
    }

    public static List<ContentValues> recipeCategoryList(){
        List<ContentValues> categories = new ArrayList<>();
        ContentValues cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "завтрак");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "гарнир");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "основное блюдо");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "салат");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "мясо");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "рыба");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "суп");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "десерт");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME, "разное");
        categories.add(cv);

        return categories;
    }

    public static List<ContentValues> productCategoryList(){
        List<ContentValues> categories = new ArrayList<>();
        ContentValues cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"Животные продукты");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"Растительные продукты");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"Молочные продукты");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"Бакалея");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"Специи");
        categories.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"Напитки");
        categories.add(cv);

        return  categories;
    }


    public static List<ContentValues> mealPeriodList() {
        List<ContentValues> period = new ArrayList<>();
        ContentValues cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"завтрак1");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"завтрак2");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"обед1");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"обед2");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"ужин1");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"ужин2");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"десерт1");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"десерт2");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"работа1");
        period.add(cv);
        cv = new ContentValues();
        cv.put(DBConst.COL_NAME,"работа2");
        period.add(cv);

        return period;
    }
}
