package com.example.menuforweek.Database;

public class DBConst {
    //tables
    public static final String TAB_PROD = "product";
    public static final String TAB_RECIPE = "recipe";
    public static final String TAB_DAY = "daytable";
    public static final String TAB_VOL = "volume";
    public static final String TAB_PRICE = "price";
    public static final String TAB_PERIOD = "period";
    public static final String TAB_PROD_CAT = "prodcategory";
    public static final String TAB_REC_CATEGORY = "category";
    public static final String TAB_REC_TEXT = "recipetext";
    public static final String TAB_REC_DETAIL = "recipedetails";
    public static final String TAB_REC_CAT_INTERS = "categoryofrecipe";

    //columns
    public static final String COL_ID = "id";
    public static final String COL_NAME = "name";
    public static final String COL_CAT_ID = "id_category";
    public static final String COL_REC_ID = "id_recipe";
    public static final String COL_PROD_ID = "id_product";
    public static final String COL_PERIOD_ID = "id_period";
    public static final String COL_VOL_ID = "id_volume";
    public static final String COL_REC_TEXT = "text";
    public static final String COL_VAL = "value";
    public static final String COL_VOL = "volume";


    //create tables
    public static final String CREATE_PROD_CAT = "CREATE TABLE "+ TAB_PROD_CAT + " ( "+
            COL_ID+" int primary key, " +
            COL_NAME+" text)";

    public static final String CREATE_REC_CAT = "CREATE TABLE "+TAB_REC_CATEGORY+ " ( "+
            COL_ID+" int primary key," +
            COL_NAME + " text)";

    public static final String CREATE_VOLUME = "CREATE TABLE " + TAB_VOL + " (" +
            COL_ID + " int primary key, " +
            COL_NAME + " text)";

    public static final String CREATE_PERIOD = "CREATE TABLE "+ TAB_PERIOD+ " ( "+
            COL_ID+" int primary key," +
            COL_NAME+" text)";

    public static final String CREATE_RECIPE  = "CREATE TABLE "+TAB_RECIPE+ " ("+
            COL_ID+" int primary key,"+
            COL_NAME +" text,"+
            COL_REC_TEXT + " text)";

    public static final String CREATE_PRODUCTS = "CREATE TABLE " + TAB_PROD+ " (" +
            COL_ID +" int  primary key," +
            COL_NAME+" text,"+
            COL_CAT_ID+" int," +
            "FOREIGN KEY("+COL_CAT_ID+") REFERENCES " +TAB_PROD_CAT+" ("+COL_ID+"))";


    public static final String CREATE_PRICE = "CREATE TABLE " + TAB_PRICE+" (" +
            COL_ID+ " int primary key," +
            COL_PROD_ID +" int, "+
            COL_VOL_ID + " int, " +
            COL_VOL + " int," +
            COL_VAL + " real)" +
            "FOREIGN KEY("+COL_PROD_ID+") REFERENCES " +TAB_PROD+" ("+COL_ID+")," +
            "FOREIGN KEY("+COL_VOL_ID+") REFERENCES " +TAB_VOL+" ("+COL_ID+"))";


    public static final String CREATE_REC_CAT_INTERS = "CREATE TABLE "+TAB_REC_CAT_INTERS+" (" +
            COL_REC_ID + " int," +
            COL_CAT_ID + " int," +
            "FOREIGN KEY("+COL_REC_ID+") REFERENCES " +TAB_RECIPE+" ("+COL_ID+"), "+
            "FOREIGN KEY("+COL_CAT_ID+") REFERENCES " +TAB_REC_CATEGORY+" ("+COL_ID+"), "+
            "PRIMARY KEY ("+COL_REC_ID+","+COL_CAT_ID+"))";


    public static final String CREATE_DETAIL = "CREATE TABLE "+TAB_REC_DETAIL+ " ( "+
            COL_REC_ID+ " int," +
            COL_PROD_ID+" int," +
            COL_VOL_ID+" int,"+
            COL_VOL + " int," +
            "FOREIGN KEY("+COL_REC_ID+") REFERENCES " +TAB_RECIPE+" ("+COL_ID+"), "+
            "FOREIGN KEY("+COL_PROD_ID+") REFERENCES " +TAB_PROD+" ("+COL_ID+"), "+
            "FOREIGN KEY("+COL_VOL_ID+") REFERENCES " +TAB_VOL+" ("+COL_ID+"), "+
            "PRIMARY KEY ("+COL_REC_ID+","+COL_PROD_ID+"))";

    public static final String CREATE_DAY_TABLE = "CREATE TABLE " + TAB_DAY+ " ("+
            COL_ID + " int UNIQUE,"+
            COL_NAME+" text," +
            COL_PERIOD_ID + " int," +
            COL_REC_ID +" int,"+
            "PRIMARY KEY ("+COL_NAME+","+COL_PERIOD_ID+"),"+
            "FOREIGN KEY("+COL_PERIOD_ID+") REFERENCES " +TAB_PERIOD+" ("+COL_ID+"), "+
            "FOREIGN KEY("+COL_REC_ID+") REFERENCES " +TAB_RECIPE+" ("+COL_ID+"))";

}
