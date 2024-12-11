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

public class HomeActivity2 extends AppCompatActivity {
    private Button professionalButton;
    private Button subProfessionalButton;
    private Button examButton;
    private TextView userNameTextView, exam_log;
    private ImageView userAvatarImageView;
    private ImageView subNumericalImg, subAnalyticalImg, subClericalImg, subGeneralImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.main_home2);

        professionalButton = findViewById(R.id.professionalButton);
        subProfessionalButton = findViewById(R.id.subProfessionalButton);
        userNameTextView = findViewById(R.id.userNameTextView);
        userAvatarImageView = findViewById(R.id.avatarImageView);
        examButton = findViewById(R.id.exam_btn2);
        subNumericalImg = findViewById(R.id.subNumericalImg);
        subAnalyticalImg = findViewById(R.id.subAnalyticalImg);
        subGeneralImg = findViewById(R.id.subGeneralImg);
        subClericalImg = findViewById(R.id.SubClericalImg);
        exam_log = findViewById(R.id.exam_log);

        // Set up listeners for sub-review images
        subNumericalImg.setOnClickListener(v -> navigateToSubNumericalReview());
        subAnalyticalImg.setOnClickListener(v -> navigateToSubAnalyticalReview());
        subClericalImg.setOnClickListener(v -> navigateToSubClericalReview());
        subGeneralImg.setOnClickListener(v -> navigateToSubGeneralReview());

        // No record adding; just navigate to Logs_Exam without changing data
        exam_log.setOnClickListener(v -> navigateToLogsExam());

        // Get the user name from the intent
        String userName = getIntent().getStringExtra("USER_NAME");
        if (userName != null) {
            userNameTextView.setText("Hi, " + userName + "!");
        }

        loadSelectedAvatar();

        // Set the avatar click to navigate to AboutAppActivity
        userAvatarImageView.setOnClickListener(v -> navigateToAboutApp(userName));

        setActiveButton(subProfessionalButton);

        professionalButton.setOnClickListener(v -> navigateToHome(userName));
        examButton.setOnClickListener(v -> navigateToExam());
    }

    // Method to load the selected avatar from SharedPreferences
    private void loadSelectedAvatar() {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int selectedAvatarId = preferences.getInt("SELECTED_AVATAR", R.drawable.avatar_icon);
        userAvatarImageView.setImageResource(selectedAvatarId);
    }

    // Add the method to navigate to AboutAppActivity, passing userName and avatar
    private void navigateToAboutApp(String userName) {
        SharedPreferences preferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int selectedAvatarId = preferences.getInt("SELECTED_AVATAR", R.drawable.avatar_icon); // Load selected avatar

        Intent intent = new Intent(this, AboutAppActivity.class);
        intent.putExtra("USER_NAME", userName);
        intent.putExtra("AVATAR_ID", selectedAvatarId);  // Pass the selected avatar
        startActivity(intent);
    }

    private void navigateToLogsExam() {
        Intent intent = new Intent(this, Logs_Exam.class);
        startActivity(intent); // No need to pass any record addition flag
    }

    private void setActiveButton(Button activeButton) {
        activeButton.setBackgroundResource(R.drawable.active_button_background);
        activeButton.setTextColor(Color.WHITE);
        activeButton.setSelected(true);

        if (activeButton == professionalButton) {
            subProfessionalButton.setBackgroundResource(R.drawable.inactive_button_background);
            subProfessionalButton.setTextColor(Color.GRAY);
            subProfessionalButton.setSelected(false);
        } else {
            professionalButton.setBackgroundResource(R.drawable.inactive_button_background);
            professionalButton.setTextColor(Color.GRAY);
            professionalButton.setSelected(false);
        }
    }

    private void navigateToHome(String userName) {
        Intent intent = new Intent(this, HomeActivity.class);
        intent.putExtra("USER_NAME", userName);
        startActivity(intent);
        finish();
    }

    private void navigateToExam() {
        Intent intent = new Intent(this, PracticeExam_Sub_Professional.class);
        startActivity(intent);
    }

    private void navigateToSubNumericalReview() {
        Intent intent = new Intent(this, TopicReviewNumerical_Sub_Professional.class);
        startActivity(intent);
    }

    private void navigateToSubAnalyticalReview() {
        Intent intent = new Intent(this, TopicReviewAnalytical_Sub_Professional.class);
        startActivity(intent);
    }

    private void navigateToSubClericalReview() {
        Intent intent = new Intent(this, TopicReviewClericalSub_Professional.class);
        startActivity(intent);
    }

    private void navigateToSubGeneralReview() {
        Intent intent = new Intent(this, TopicReview_General.class);
        startActivity(intent);
    }
}
