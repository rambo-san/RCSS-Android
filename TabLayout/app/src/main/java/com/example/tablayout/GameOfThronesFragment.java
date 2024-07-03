package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class GameOfThronesFragment extends Fragment {

    private String[] items = {"Item 5", "Item 6", "Item 7", "Item 8"};
    private int[] images = {R.drawable.image5, R.drawable.image6, R.drawable.image7, R.drawable.image8};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        GridView gridView = view.findViewById(R.id.gridView);
        GridAdapter adapter = new GridAdapter(getContext(), items, images);
        gridView.setAdapter(adapter);
        return view;
    }
}
