package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class TheBoysFragment extends Fragment {

    private String[] items = {"Item 1", "Item 2", "Item 3", "Item 4"};
    private int[] images = {R.drawable.image1, R.drawable.image2, R.drawable.image3, R.drawable.image4};

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
