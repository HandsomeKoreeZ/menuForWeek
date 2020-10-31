package com.example.menuforweek.Database;

import android.content.ContentValues;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DBFillers {

    public static List<String> getListVolumeCategories(){
        List<String> list = new ArrayList<>();
        list.add("кг");
        list.add("гр");
        list.add("л");
        list.add("мл");
        list.add("ч.л.");
        list.add("ст.л.");
        list.add("стакан");
        list.add("шт");

        return list;
    }

    public static List<String> getListRecipeCategory(){
        List<String> list = new ArrayList<>();
        list.add("завтрак");
        list.add("гарнир");
        list.add("основное блюдо");
        list.add("салат");
        list.add("мясо");
        list.add("рыба");
        list.add("суп");
        list.add("десерт");
        list.add("разное");
        return list;
    }

    public static List<String> getListProductCategory(){
        List<String> list = new ArrayList<>();
        list.add("Животные продукты");
        list.add("Растительные продукты");
        list.add("Молочные продукты");
        list.add("Бакалея");
        list.add("Специи");
        list.add("Напитки");
        return list;
    }

    public static List<String> getListPeriod(){
        List<String> list = new ArrayList<>();
        list.add("завтрак1");
        list.add("завтрак2");
        list.add("обед1");
        list.add("обед2");
        list.add("ужин1");
        list.add("ужин2");
        list.add("десерт1");
        list.add("десерт2");
        list.add("работа1");
        list.add("работа2");
        return list;
    }

    public static List<ContentValues> fillContentList(List<String> list, String colName){
        /**
         * create list of contentValues, that contains only 1 field each one.
         * @list - list of fields
         * @colName - column name that list should be inserted
         */
        List<ContentValues> result = new ArrayList<>();
        ContentValues cv;
       for (String s: list){
           cv = new ContentValues();
           cv.put(colName,s);
           result.add(cv);
       }
        return result;
    }
}
