package com.example.tablayout;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class StrangerThingsFragment extends Fragment {

    private String[] items = {"Item 9", "Item 10", "Item 11", "Item 12"};
    private int[] images = {R.drawable.image9, R.drawable.image10, R.drawable.image11, R.drawable.image12};

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
