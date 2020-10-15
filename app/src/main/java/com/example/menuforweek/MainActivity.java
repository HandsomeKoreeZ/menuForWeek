package com.example.menuforweek;

import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.fragment.app.FragmentManager;
import androidx.appcompat.app.AppCompatActivity;
import android.view.MenuItem;
import com.example.menuforweek.Fragments.*;

public class MainActivity extends AppCompatActivity {
    private FragmentManager fm;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_recipe:
                    setTitle(R.string.title_add_recipe);
                    fm.beginTransaction().replace(R.id.main_frame,new Fragment_detail_recipe()).commit();
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_newRecipe);
                    return true;
                case R.id.navigation_menu_list:
                    setTitle(R.string.title_menu_list);
                    fm.beginTransaction().replace(R.id.main_frame,new Fragment_menu()).commit();
                    findViewById(R.id.main_frame).setBackgroundResource(R.color.color_menu);
                    return true;
                case R.id.navigation_product_list:
                    setTitle(R.string.title_product_list);
                    fm.beginTransaction().replace(R.id.main_frame, new Fragment_ProductList()).commit();
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
