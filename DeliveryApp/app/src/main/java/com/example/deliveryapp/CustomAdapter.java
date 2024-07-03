package com.example.deliveryapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter<FoodItem> {

    public CustomAdapter(Context context, ArrayList<FoodItem> foodItems) {
        super(context, 0, foodItems);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        FoodItem foodItem = getItem(position);

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        ImageView itemImage = convertView.findViewById(R.id.item_image);
        TextView itemName = convertView.findViewById(R.id.item_name);
        TextView itemDescription = convertView.findViewById(R.id.item_description);
        TextView itemPrice = convertView.findViewById(R.id.item_price);

        itemImage.setImageResource(foodItem.getImageResourceId());
        itemName.setText(foodItem.getName());
        itemDescription.setText(foodItem.getDescription());
        itemPrice.setText(foodItem.getPrice());

        return convertView;
    }
}
