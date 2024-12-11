//package com.example.passcsemidtermproject;
//
//import android.content.Intent;
//import android.content.pm.ActivityInfo;
//import android.database.Cursor;
//import android.os.Bundle;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ImageView;
//import android.widget.ListView;
//import android.widget.TextView;
//import androidx.appcompat.app.AppCompatActivity;
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.Locale;
//
//public class Logs_Exam2 extends AppCompatActivity {
//
//    private TextView correctAnswerLogTextView;
//    private TextView wrongAnswerLogTextView;
//    private TextView timeSpentLogTextView;
//    private TextView dateTimeLogTextView;
//    private TextView totalScoreTextView; // TextView for total score
//    private DatabaseHelper2 databaseHelper2; // Reference to DatabaseHelper
//    private ListView logsListView; // ListView to display previous exam logs
//    private ImageView backButton; // ImageView for back navigation
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//        setContentView(R.layout.logs_exam2);  // Use the Logs_Exam XML layout
//
//        // Initialize views
//        correctAnswerLogTextView = findViewById(R.id.correctAnswerLog);
//        wrongAnswerLogTextView = findViewById(R.id.wrongAnswerLog);
//        timeSpentLogTextView = findViewById(R.id.timeSpentLog);
//        dateTimeLogTextView = findViewById(R.id.dateTimeLog);
//        totalScoreTextView = findViewById(R.id.totalScore);
//        logsListView = findViewById(R.id.logsListView); // Initialize ListView
//        backButton = findViewById(R.id.backButton); // Initialize back button ImageView
//
//        // Initialize database helper
//        databaseHelper2 = new DatabaseHelper2(this);
//
//        // Check if we should add a record
//        boolean addRecord = getIntent().getBooleanExtra("ADD_RECORD", false);
//
//        if (addRecord) {
//            // Retrieve the passed data from the Intent
//            int correctAnswers = getIntent().getIntExtra("correctAnswers", 0);
//            int wrongAnswers = getIntent().getIntExtra("wrongAnswers", 0);
//            String timeSpent = getIntent().getStringExtra("timeSpent");
//
//            // Get the current date and time with AM/PM
//            String currentDateAndTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss a", Locale.getDefault()).format(new Date());
//
//            // Insert log into the database
//            if (databaseHelper2.insertLog(correctAnswers, wrongAnswers, timeSpent, currentDateAndTime)) {
//                // Log insertion successful
//            } else {
//                // Log insertion failed
//            }
//
//            // Display the results
//            correctAnswerLogTextView.setText("Correct Answers: " + correctAnswers);
//            wrongAnswerLogTextView.setText("Wrong Answers: " + wrongAnswers);
//            timeSpentLogTextView.setText("Time Spent: " + timeSpent);
//
//            // Calculate and display the total score
//            String totalScore = "Total Score: " + correctAnswers + "/" + (correctAnswers + wrongAnswers);
//            totalScoreTextView.setText(totalScore);
//
//            // Display the current date and time
//            dateTimeLogTextView.setText("Date: " + currentDateAndTime);
//        }
//
//        // Retrieve and display previous exam logs
//        displayPreviousLogs();
//
//        // Set onClickListener for the back button
//        backButton.setOnClickListener(v -> finish());
//    }
//
//    private void displayPreviousLogs() {
//        Cursor cursor = databaseHelper2.getAllLogs();
//        if (cursor.getCount() == 0) {
//            // No logs found
//            return;
//        }
//
//        String[] logsArray = new String[cursor.getCount()];
//        int index = 0;
//
//        while (cursor.moveToNext()) {
//            String logEntry ="SUB-PROFESSIONAL" + "\n" + "Answered Correctly: " + cursor.getInt(1) + ", Answered Wrong: " + cursor.getInt(2) + "\n" +
//                    "Date: " + cursor.getString(4);
//            logsArray[index++] = logEntry;
//        }
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, logsArray);
//        logsListView.setAdapter(adapter);
//    }
//}