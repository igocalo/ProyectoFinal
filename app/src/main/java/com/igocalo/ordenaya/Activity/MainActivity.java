package com.igocalo.ordenaya.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.igocalo.ordenaya.Adapter.CategoryAdapter;
import com.igocalo.ordenaya.Adapter.PopularAdapter;
import com.igocalo.ordenaya.Domain.CategoryDomain;
import com.igocalo.ordenaya.Domain.FoodDomain;
import com.igocalo.ordenaya.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerViewCategory();
        recyclerViewPopular();
        bottomNavigation();
    }

    private void bottomNavigation() {
        FloatingActionButton floatingActionButton = findViewById(R.id.card_btn);
        LinearLayout homeBtn = findViewById(R.id.homeBtn);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, CardListActivity.class));
            }
        });

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, MainActivity.class));
            }
        });
    }

    private void recyclerViewPopular() {

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewPopularList = findViewById(R.id.recyclerView2);
        recyclerViewPopularList.setLayoutManager(linearLayoutManager);

        ArrayList<FoodDomain> foodlist = new ArrayList<>();
        foodlist.add(new FoodDomain("Pizza de pepperoni ", "pizza1", "Rodajas de pepperoni, queso mozzarella, oregano, pimienta negra, salsa", 9.76));
        foodlist.add(new FoodDomain("Hamburguesa de queso", "burger", "Carne, queso gouda, salsa especial, lechuga, tomate ", 8.79));
        foodlist.add(new FoodDomain("Pizza de vegetales", "pizza2", "Aceite de oliva, aceite vegetal, kalamata sin hueso, tomate cherry,  oregano, albahaca", 8.51));

        adapter2 = new PopularAdapter(foodlist);
        recyclerViewPopularList.setAdapter(adapter2);

    }

    private void recyclerViewCategory() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerViewCategoryList = findViewById(R.id.recyclerView);
        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);

        ArrayList<CategoryDomain> categoryList = new ArrayList<>();
        categoryList.add(new CategoryDomain("Pizza", "cat_1"));
        categoryList.add(new CategoryDomain("Hambur.", "cat_2"));
        categoryList.add(new CategoryDomain("Hotdog", "cat_3"));
        categoryList.add(new CategoryDomain("Bebidas", "cat_4"));
        categoryList.add(new CategoryDomain("Donas", "cat_5"));

        adapter = new CategoryAdapter(categoryList);
        recyclerViewCategoryList.setAdapter(adapter);
    }
}