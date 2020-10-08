package com.example.menuforweek;

import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_recipe:
                    setTitle(R.string.title_add_recipe);
                    fm.beginTransaction().replace(R.id.main_frame,new Fragment_DetailRecipe()).commit();
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_newRecipe);
                    return true;
                case R.id.navigation_menu_list:
                    setTitle(R.string.title_menu_list);
                    fm.beginTransaction().replace(R.id.main_frame,new Fragment_Menu()).commit();
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_menu);
                    return true;
                case R.id.navigation_product_list:
                    setTitle(R.string.title_product_list);
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_productList);
                    return true;
                case R.id.navigation_cook:
                    setTitle(R.string.title_cook);
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_coock);
                    return true;
                case R.id.navigation_product_price:
                    setTitle(R.string.title_product_price);
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_productPrice);
                    return true;
            }
            return false;
        }
    };
    private Object newRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fm = getSupportFragmentManager();

        navView.setSelectedItemId(R.id.navigation_menu_list);                                       //set start activity
    }

}
