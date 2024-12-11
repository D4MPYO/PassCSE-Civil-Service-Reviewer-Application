package com.example.passcsemidtermproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Logs_Exam extends AppCompatActivity {

    private TextView correctAnswerLogTextView;
    private TextView wrongAnswerLogTextView;
    private TextView timeSpentLogTextView;
    private TextView dateTimeLogTextView;
    private TextView totalScoreTextView;
    private DatabaseHelper databaseHelper; // Reference for professional logs
    private DatabaseHelper2 databaseHelper2; // Reference for sub-professional logs
    private ListView logsListView;
    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.logs_exam); // Use a common layout

        // Initialize views
        correctAnswerLogTextView = findViewById(R.id.correctAnswerLog);
        wrongAnswerLogTextView = findViewById(R.id.wrongAnswerLog);
        timeSpentLogTextView = findViewById(R.id.timeSpentLog);
        dateTimeLogTextView = findViewById(R.id.dateTimeLog);
        totalScoreTextView = findViewById(R.id.totalScore);
        logsListView = findViewById(R.id.logsListView);
        backButton = findViewById(R.id.backButton);

        // Initialize database helpers
        databaseHelper = new DatabaseHelper(this);
        databaseHelper2 = new DatabaseHelper2(this);

        // Retrieve the passed data from the Intent
        boolean isSubProfessional = getIntent().getBooleanExtra("IS_SUB_PROFESSIONAL", false);
        boolean addRecord = getIntent().getBooleanExtra("ADD_RECORD", false);

        if (addRecord) {
            // Retrieve the passed exam results
            int correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
            int wrongAnswers = getIntent().getIntExtra("wrongAnswers", 0);
            String timeSpent = getIntent().getStringExtra("timeSpent");

            // Insert the log into the appropriate database table
            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.getDefault()).format(new Date());
            boolean logInserted = isSubProfessional
                    ? databaseHelper2.insertLog(correctAnswers, wrongAnswers, timeSpent, currentDateAndTime)
                    : databaseHelper.insertLog(correctAnswers, wrongAnswers, timeSpent, currentDateAndTime);

            // Display the results
            correctAnswerLogTextView.setText("Correct Answers: " + correctAnswers);
            wrongAnswerLogTextView.setText("Wrong Answers: " + wrongAnswers);
            timeSpentLogTextView.setText("Time Spent: " + timeSpent);
            totalScoreTextView.setText("Total Score: " + correctAnswers + "/" + (correctAnswers + wrongAnswers));
            dateTimeLogTextView.setText("Date: " + currentDateAndTime);
        }

        // Display previous logs
        displayPreviousLogs(isSubProfessional);

        // Set onClickListener for the back button
        backButton.setOnClickListener(v -> finish());
    }

    private void displayPreviousLogs(boolean isSubProfessional) {
        Cursor cursor = isSubProfessional ? databaseHelper2.getAllLogs() : databaseHelper.getAllLogs();

        if (cursor.getCount() == 0) {
            return;
        }

        String[] logsArray = new String[cursor.getCount()];
        int index = 0;

        while (cursor.moveToNext()) {
            String logType = isSubProfessional ? "SUB-PROFESSIONAL" : " ";
            String logEntry = logType +
                    "\nAnswered Correctly: " + cursor.getInt(1) +
                    ", Answered Wrong: " + cursor.getInt(2) +
                    "\nDate: " + cursor.getString(4);
            logsArray[index++] = logEntry;
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logsArray);
        logsListView.setAdapter(adapter);
    }
}
