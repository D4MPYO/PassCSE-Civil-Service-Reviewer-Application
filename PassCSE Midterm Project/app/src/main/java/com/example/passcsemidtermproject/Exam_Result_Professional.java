package com.example.passcsemidtermproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Exam_Result_Professional extends AppCompatActivity {

    private TextView correctAnswerValueTextView;
    private TextView wrongAnswerValueTextView;
    private TextView timeSpentValueTextView;
    private Button retryButton, backHomeButton, viewResultButton;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.result_exam_professional);

        // Initialize views
        correctAnswerValueTextView = findViewById(R.id.CorrectAnswerValue);
        wrongAnswerValueTextView = findViewById(R.id.WrongAnswerValue);
        timeSpentValueTextView = findViewById(R.id.TimeSpendValue);
        retryButton = findViewById(R.id.Retry);
        backHomeButton = findViewById(R.id.backHome);
        backButton = findViewById(R.id.backButton);
        viewResultButton = findViewById(R.id.ViewResult);

        // Retrieve data from Intent
        int correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
        int wrongAnswers = getIntent().getIntExtra("wrongAnswers", 0);
        String timeSpent = getIntent().getStringExtra("timeSpent");

        // Display the results
        correctAnswerValueTextView.setText(String.valueOf(correctAnswers));
        wrongAnswerValueTextView.setText(String.valueOf(wrongAnswers));
        timeSpentValueTextView.setText(timeSpent);

        // Set colors based on performance
        correctAnswerValueTextView.setTextColor(Color.GREEN);
        wrongAnswerValueTextView.setTextColor(Color.RED);
        timeSpentValueTextView.setTextColor(Color.BLUE);

        // Set up button listeners
        setupButtonListeners(correctAnswers, wrongAnswers, timeSpent);
    }

    private void setupButtonListeners(int correctAnswers, int wrongAnswers, String timeSpent) {
        retryButton.setOnClickListener(v -> {
            // Start the examination activity again
            Intent retryIntent = new Intent(this, Examination_for_Professional.class);
            startActivity(retryIntent);
            finish();
        });

        backHomeButton.setOnClickListener(v -> {
            // Navigate back to the home activity
            Intent homeIntent = new Intent(this, HomeActivity.class);
            startActivity(homeIntent);
            finish();
        });

        backButton.setOnClickListener(v -> {
            // Go back to the previous activity
            finish();
        });

        viewResultButton.setOnClickListener(v -> {
            // Navigate to LogsExamActivity
            Intent logsIntent = new Intent(this, Logs_Exam.class);
            logsIntent.putExtra("ADD_RECORD", true); // Indicate to add a new record
            logsIntent.putExtra("correctAnswers", correctAnswers);
            logsIntent.putExtra("wrongAnswers", wrongAnswers);
            logsIntent.putExtra("timeSpent", timeSpent);
            startActivity(logsIntent);
            finish();
        });
    }
}

