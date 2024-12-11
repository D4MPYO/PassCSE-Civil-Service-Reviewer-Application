package com.example.passcsemidtermproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TopicReviewAnalytical_Sub_Professional extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.topic_review_analytical_sub_professional);


        ImageView backButton = findViewById(R.id.backButton);
        Button startReview = findViewById(R.id.startReview);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        startReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicReviewAnalytical_Sub_Professional.this, Reviewer_Sub_Analytical.class);
                startActivity(intent);
            }
        });
    }
}
