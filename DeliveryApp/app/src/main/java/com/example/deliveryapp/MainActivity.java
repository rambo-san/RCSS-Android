package com.example.deliveryapp;

import android.os.Bundle;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.listView);

        ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems.add(new FoodItem(R.drawable.meals, "Meals", "Delicious kerala meals", "Rs. 50"));
        foodItems.add(new FoodItem(R.drawable.dosa, "Masala Dosa", "Yummy dosa", "Rs. 30"));
        foodItems.add(new FoodItem(R.drawable.biryani, "Biryani", "Tasty kozhikode dhum biryani", "Rs. 150"));
        foodItems.add(new FoodItem(R.drawable.porotta, "Porotta Beef combo", "Authentic porotta and tasty beef roast", "Rs. 130"));
        foodItems.add(new FoodItem(R.drawable.dosa, "Masala Dosa", "Yummy dosa", "Rs. 30"));
        foodItems.add(new FoodItem(R.drawable.biryani, "Biryani", "Tasty kozhikode dhum biryani", "Rs. 150"));
        foodItems.add(new FoodItem(R.drawable.porotta, "Porotta Beef combo", "Authentic porotta and tasty beef roast", "Rs. 130"));
        foodItems.add(new FoodItem(R.drawable.dosa, "Masala Dosa", "Yummy dosa", "Rs. 30"));
        foodItems.add(new FoodItem(R.drawable.biryani, "Biryani", "Tasty kozhikode dhum biryani", "Rs. 150"));
        foodItems.add(new FoodItem(R.drawable.porotta, "Porotta Beef combo", "Authentic porotta and tasty beef roast", "Rs. 130"));

        // Add more items as needed

        CustomAdapter adapter = new CustomAdapter(this, foodItems);
        listView.setAdapter(adapter);
    }
}
