package com.example.menuforweek.testObjects;

import com.example.menuforweek.Entities.Product_Full;
import com.example.menuforweek.Entities.Recipe;
import com.example.menuforweek.Interface.Product;

public class testEntities {

    public static Recipe getPotatoPoure(){
        Recipe result = new Recipe();
        Product_Full cartofan   = new Product_Full("картошка","кг",1);
        Product_Full maslo      = new Product_Full("масло сливочное","гр",50);
        Product_Full sol        = new Product_Full("соль","гр",10);
        String text = "Сварить картошку, раздавить в однородную массу, добавить масло и соль, размешать. Подавать горячим";
        String name = "Пюре";


        //TODO тут проблема
        result.addProduct(cartofan);
        result.addProduct(maslo);
        result.addProduct(sol);
        result.addCategory("Гарнир");
        result.setText(text);
        result.setName(name);

        return result;
    }
}
