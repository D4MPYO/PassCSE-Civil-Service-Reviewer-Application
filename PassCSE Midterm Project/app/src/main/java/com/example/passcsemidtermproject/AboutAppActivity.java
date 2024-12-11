package com.example.passcsemidtermproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class AboutAppActivity extends AppCompatActivity {

    private ImageView avatarImageView;
    private TextView userNameTextView;
    private ImageView backButton; // Add this line to declare the back button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app);

        // Initialize views
        avatarImageView = findViewById(R.id.avatarImageView);
        userNameTextView = findViewById(R.id.userNameTextView);
        backButton = findViewById(R.id.backButton); // Initialize the back button

        // Retrieve the avatar and user name from the Intent
        Intent intent = getIntent();
        String userName = intent.getStringExtra("USER_NAME");
        int avatarId = intent.getIntExtra("AVATAR_ID", R.drawable.avatar_icon); // Default avatar if not found

        // Set the avatar and user name in the UI
        avatarImageView.setImageResource(avatarId);
        if (userName != null) {
            userNameTextView.setText("Hi " + userName);
        } else {
            userNameTextView.setText("User: Guest");
        }

        // Set OnClickListener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close this activity and return to the previous one
            }
        });
    }
}
