package com.example.passcsemidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

public class Slide_two extends Fragment {

    public Slide_two() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.slide_two, container, false);


        final ViewPager2 viewPager = getActivity().findViewById(R.id.pager);


        Button nextButton = view.findViewById(R.id.nextbutton);
        nextButton.setOnClickListener(v -> {
            if (viewPager != null) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1, true); // Move to the next page
            }
        });

        Button skipButton = view.findViewById(R.id.skipbutton);
        skipButton.setOnClickListener(v -> {
            // Navigate to input_name.xml
            Intent intent = new Intent(getActivity(), Choosing_Avatar.class);
            startActivity(intent);
        });

        return view;
    }
}
