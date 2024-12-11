package com.example.passcsemidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class Slide_three extends Fragment {

    public Slide_three() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slide_three, container, false);

        Button skipButton = view.findViewById(R.id.skipbutton);
        skipButton.setOnClickListener(v -> {

            Intent intent = new Intent(getActivity(), Choosing_Avatar.class);
            startActivity(intent);
        });

        return view;
    }
}
