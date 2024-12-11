package com.example.passcsemidtermproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    private TextView greetingTextView, exam_log;
    private ImageView avatarImageView, numericalImg, analyticalImg, verbalImg, subGeneralImg;
    private Button professionalButton, subProfessionalButton, examButton1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.main_home);

        greetingTextView = findViewById(R.id.textView);
        avatarImageView = findViewById(R.id.avatarImageView);
        professionalButton = findViewById(R.id.professionalButton);
        subProfessionalButton = findViewById(R.id.subProfessionalButton);
        examButton1 = findViewById(R.id.exam_btn1);
        numericalImg = findViewById(R.id.numericalImg);
        analyticalImg = findViewById(R.id.analyticalImg);
        verbalImg = findViewById(R.id.verbalImg);
        subGeneralImg = findViewById(R.id.subGeneralImg);
        exam_log = findViewById(R.id.exam_log);

        // Retrieve and set user name
        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName != null) {
            greetingTextView.setText("Hi, " + userName + "!");
        }

        // Retrieve the selected avatar from SharedPreferences
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int selectedAvatarId = preferences.getInt("SELECTED_AVATAR", R.drawable.avatar_icon);
        avatarImageView.setImageResource(selectedAvatarId);

        // Set up the buttons
        setActiveButton(professionalButton, subProfessionalButton);
        subProfessionalButton.setOnClickListener(v -> navigateToHome2(userName));
        examButton1.setOnClickListener(v -> navigateToProfessionalExam());

        // Set onClick listeners for numericalImg, analyticalImg, and verbalImg
        numericalImg.setOnClickListener(v -> navigateToProNumericalReview());
        analyticalImg.setOnClickListener(v -> navigateToProAnalyticalReview());
        verbalImg.setOnClickListener(v -> navigateToProVerbalReview());
        subGeneralImg.setOnClickListener(v -> navigateToSubGeneralReview());
        avatarImageView.setOnClickListener(v -> navigateToAboutApp(userName, selectedAvatarId));


        // Make exam_log clickable and navigate to Logs_Exam without adding a record
        exam_log.setOnClickListener(v -> navigateToLogsExam(false));
        exam_log.setClickable(true);  // Ensure it's clickable
    }

    private void navigateToAboutApp() {
        Intent intent = new Intent(this, AboutAppActivity.class);
        startActivity(intent);
    }


    // Navigates to Numerical Review for Professional
    private void navigateToProNumericalReview() {
        Intent intent = new Intent(this, TopicReviewNumerical_Professional.class);
        startActivity(intent);
    }

    private void navigateToSubGeneralReview() {
        Intent intent = new Intent(this, TopicReview_General.class);
        startActivity(intent);
    }

    // Navigates to Analytical Review for Professional
    private void navigateToProAnalyticalReview() {
        Intent intent = new Intent(this, TopicReviewAnalytical_Professional.class);
        startActivity(intent);
    }

    // Navigates to Verbal Review for Professional
    private void navigateToProVerbalReview() {
        Intent intent = new Intent(this, TopicReviewVerbal_Professional.class);
        startActivity(intent);
    }

    // Navigates to the Professional Exam activity
    private void navigateToProfessionalExam() {
        Intent intent = new Intent(this, com.example.passcsemidtermproject.PracticeExam_Professional.class);
        startActivity(intent);
    }

    // Navigates to Logs_Exam activity without adding a record
    private void navigateToLogsExam(boolean addRecord) {
        Intent intent = new Intent(this, Logs_Exam.class);
        intent.putExtra("ADD_RECORD", addRecord); // Pass whether to add a record
        startActivity(intent);
    }

    // Toggles between active and inactive buttons
    private void toggleButton(Button activeButton, Button inactiveButton) {
        if (activeButton.isSelected()) return;
        setActiveButton(activeButton, inactiveButton);
    }

    // Sets the active button's style and resets the inactive one
    private void setActiveButton(Button activeButton, Button inactiveButton) {
        activeButton.setBackgroundResource(R.drawable.active_button_background);
        activeButton.setTextColor(Color.WHITE);
        activeButton.setSelected(true);
        inactiveButton.setBackgroundResource(R.drawable.inactive_button_background);
        inactiveButton.setTextColor(Color.GRAY);
        inactiveButton.setSelected(false);
    }

    // Navigates to HomeActivity2, passing the username
    private void navigateToHome2(String userName) {
        Intent intent = new Intent(this, HomeActivity2.class);
        intent.putExtra("USER_NAME", userName);
        startActivity(intent);
    }

    private void navigateToAboutApp(String userName, int avatarId) {
        Intent intent = new Intent(this, AboutAppActivity.class);
        intent.putExtra("USER_NAME", userName);
        intent.putExtra("AVATAR_ID", avatarId);
        startActivity(intent);
    }
}
