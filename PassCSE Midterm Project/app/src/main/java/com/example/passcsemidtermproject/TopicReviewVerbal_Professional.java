package com.example.passcsemidtermproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class TopicReviewVerbal_Professional extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.topic_review_verbal_professional);

        // Initialize backButton and startReview button
        ImageView backButton = findViewById(R.id.backButton);
        Button startReview = findViewById(R.id.startReview);

        // Set an OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        startReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TopicReviewVerbal_Professional.this, Reviewer_Pro_Verbal.class);
                startActivity(intent);
            }
        });
    }
}
