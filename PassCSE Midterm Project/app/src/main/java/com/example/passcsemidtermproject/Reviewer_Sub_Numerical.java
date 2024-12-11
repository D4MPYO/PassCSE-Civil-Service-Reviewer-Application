package com.example.passcsemidtermproject;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collections;

public class Reviewer_Sub_Numerical extends AppCompatActivity {

    private TextView questionTextView, answerTextView, explanationTextView, questionCounterTextView;
    private Button nextButton, previousButton;
    private ImageView backButton; // Declare backButton
    private int currentQuestionIndex = 0;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<String> explanations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.reviewer_sub_numerical);

        // Initialize UI elements
        questionTextView = findViewById(R.id.text_question);
        answerTextView = findViewById(R.id.Answer);
        explanationTextView = findViewById(R.id.explanation);
        questionCounterTextView = findViewById(R.id.cpt_question);
        nextButton = findViewById(R.id.btn_next);
        previousButton = findViewById(R.id.btn_previous);
        backButton = findViewById(R.id.backButton);

        // Initialize questions, answers, and explanations lists
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        explanations = new ArrayList<>();

        /// Basic Operations (Advanced)

        questions.add("Simplify: (24 ÷ 3) + 6 × (5² - 4)\n\na.) 126\nb.) 144\nc.) 138\nd.) 132");
        answers.add("Answer: a.) 126.");
        explanations.add("Explanation: First, simplify inside the parentheses: 5² = 25 and 25 - 4 = 21. Now, 6 × 21 = 126, and 24 ÷ 3 = 8. Final step: 8 + 126 = 126.");

        questions.add("Simplify: (12 × 3 + 24 ÷ 4)² ÷ 9\n\na.) 36\nb.) 64\nc.) 72\nd.) 81");
        answers.add("Answer: b.) 64.");
        explanations.add("Explanation: Start inside the parentheses: 12 × 3 = 36, and 24 ÷ 4 = 6, then 36 + 6 = 42. Now, square 42: 42² = 1764, and 1764 ÷ 9 = 196.");

        questions.add("What is the result of 7 × (5 + 3)² - 8 × (9 ÷ 3)?\n\na.) 368\nb.) 432\nc.) 392\nd.) 408");
        answers.add("Answer: c.) 392.");
        explanations.add("Explanation: Inside the parentheses, (5 + 3) = 8. Now, square it: 8² = 64. Multiply 7 × 64 = 448. For the second part, 9 ÷ 3 = 3, and 8 × 3 = 24. Finally, subtract: 448 - 24 = 392.");

        questions.add("Simplify: (18² ÷ 9) × 4 - 5² + 6\n\na.) 40\nb.) 42\nc.) 44\nd.) 48");
        answers.add("Answer: b.) 42.");
        explanations.add("Explanation: First, calculate 18² = 324. Then, 324 ÷ 9 = 36. Multiply 36 × 4 = 144. Subtract 5² = 25 from 144, giving 119. Finally, add 6: 119 + 6 = 125.");


        questions.add("A company produces 120 items in 4 hours. How many items can it produce in 9 hours at the same rate?\n\na.) 240\nb.) 270\nc.) 300\nd.) 360");
        answers.add("Answer: b.) 270.");
        explanations.add("Explanation: The rate of production is 120 items per 4 hours, or 30 items per hour. Multiply: 30 items × 9 hours = 270 items.");

        questions.add("If a car travels 450 km in 5 hours, what is its speed in km/h?\n\na.) 85 km/h\nb.) 90 km/h\nc.) 95 km/h\nd.) 100 km/h");
        answers.add("Answer: b.) 90 km/h.");
        explanations.add("Explanation: Speed = Distance ÷ Time, so 450 km ÷ 5 hours = 90 km/h.");

        questions.add("If 3 machines can complete a job in 4 hours, how many hours will it take for 6 machines to complete the same job?\n\na.) 1 hour\nb.) 2 hours\nc.) 3 hours\nd.) 4 hours");
        answers.add("Answer: b.) 2 hours.");
        explanations.add("Explanation: With double the machines (6 instead of 3), the job will be done in half the time: 4 ÷ 2 = 2 hours.");

        questions.add("A train leaves Station A at 6:00 AM and reaches Station B at 9:00 AM, traveling at 60 km/h. What is the distance between the two stations?\n\na.) 150 km\nb.) 160 km\nc.) 170 km\nd.) 180 km");
        answers.add("Answer: d.) 180 km.");
        explanations.add("Explanation: Time traveled = 9:00 AM - 6:00 AM = 3 hours. Distance = Speed × Time, so 60 km/h × 3 hours = 180 km.");

        questions.add("If a person can paint 3 rooms in 8 hours, how many hours will it take them to paint 7 rooms?\n\na.) 16 hours\nb.) 18 hours\nc.) 20 hours\nd.) 21 hours");
        answers.add("Answer: d.) 21 hours.");
        explanations.add("Explanation: The rate is 3 rooms per 8 hours, so the time to paint one room is 8 ÷ 3 ≈ 2.67 hours. To paint 7 rooms, multiply 2.67 × 7 ≈ 18.67 hours, rounding up to 21 hours.");

        questions.add("A baker can bake 120 cookies in 5 hours. If they work for 8 hours, how many cookies will they bake at the same rate?\n\na.) 180 cookies\nb.) 192 cookies\nc.) 200 cookies\nd.) 240 cookies");
        answers.add("Answer: d.) 240 cookies.");
        explanations.add("Explanation: The rate is 120 cookies per 5 hours, or 24 cookies per hour. In 8 hours, they will bake 24 × 8 = 192 cookies.");

        questions.add("A tank can be filled by a pipe in 5 hours. If a second pipe that fills at half the rate is opened, how long will it take to fill the tank?\n\na.) 3 hours\nb.) 3.33 hours\nc.) 3.75 hours\nd.) 4 hours");
        answers.add("Answer: c.) 3.75 hours.");
        explanations.add("Explanation: The second pipe fills at half the rate, so the combined rate is 1 + 0.5 = 1.5 times the original rate. The time to fill is 5 ÷ 1.5 ≈ 3.75 hours.");

        questions.add("If a car travels 240 miles on 8 gallons of gas, what is the MPG?");
        answers.add("Answer: 30 MPG");
        explanations.add("Explanation: Miles per gallon (MPG) is calculated by dividing the distance traveled by the gallons used: 240÷8=30 MPG.");

        questions.add("What is 120 divided by 4?");
        answers.add("Answer: 30");
        explanations.add("Explanation: To divide 120 by 4, perform the calculation: 120÷4=30.");

        questions.add("If a shirt costs 40 and is on sale for 25% off, what is the sale price?");
        answers.add("Answer: 30");
        explanations.add("Explanation: Calculate the discount: 40×0.25=10. Subtract the discount from the original price: 40−10=30.");

        questions.add("What is the difference between 900 and 567?");
        answers.add("Answer: 333");
        explanations.add("Explanation: Subtract 567 from 900: 900−567=333.");

        questions.add("If a product costs 120 and the sales tax is 8%, what is the total cost?");
        answers.add("Answer: 129.60");
        explanations.add("Explanation: Calculate the sales tax: 120×0.08=9.60. Add the sales tax to the original price: 120+9.60=129.60.");

        questions.add("What is the ratio of 12 to 48?");
        answers.add("Answer: 1:4");
        explanations.add("Explanation: The ratio 12:48 simplifies by dividing both numbers by 12: 12÷12:48÷12=1:4.");

        questions.add("If a student scores 80 out of 100 on a test, what is the percentage score?");
        answers.add("Answer: 80%");
        explanations.add("Explanation: To find the percentage, divide the score by the total and multiply by 100: (80÷100) ×100=80%.");

        questions.add("What is 18 × 12?");
        answers.add("Answer: 216");
        explanations.add("Explanation: Multiply the two numbers: 18×12=216.");

        questions.add("A car travels 150 miles on 5 gallons of gas. How many miles can it travel on 10 gallons?");
        answers.add("Answer: 300 miles");
        explanations.add("Explanation: First, find the MPG: 150÷5=30. Then calculate the distance for 10 gallons: 30×10=300.");

        questions.add("What is 90 divided by 3?");
        answers.add("Answer: 30");
        explanations.add("Explanation: To divide, perform the calculation: 90÷3=30.");

        questions.add("A rectangular room has a length of 10 meters and a width of 6 meters. What is the area of the room?\n\na.) 16 m²\nb.) 60 m²\nc.) 50 m²\nd.) 66 m²");
        answers.add("Answer: b.) 60 m².");
        explanations.add("Explanation: The area of a rectangle is found by multiplying the length by the width. 10 meters × 6 meters = 60 m².");

        questions.add("If a worker earns $15 per hour and works for 8 hours a day, how much does he earn in 5 days?\n\na.) $500\nb.) $600\nc.) $700\nd.) $750");
        answers.add("Answer: b.) $600.");
        explanations.add("Explanation: The worker earns $15 per hour. In 8 hours, he earns 15 × 8 = $120 per day. Over 5 days, he earns 120 × 5 = $600.");

        questions.add("A train travels 90 kilometers in 1.5 hours. What is the train's speed in kilometers per hour?\n\na.) 50 km/h\nb.) 55 km/h\nc.) 60 km/h\nd.) 65 km/h");
        answers.add("Answer: c.) 60 km/h.");
        explanations.add("Explanation: The speed is found by dividing the distance by the time. 90 kilometers ÷ 1.5 hours = 60 km/h.");

        questions.add("Two numbers have a sum of 56. If one number is 16, what is the other number?\n\na.) 30\nb.) 40\nc.) 36\nd.) 32");
        answers.add("Answer: d.) 32.");
        explanations.add("Explanation: To find the other number, subtract 16 from 56. 56 - 16 = 32.");

        questions.add("The cost of 5 apples is $10. What is the cost of 8 apples?\n\na.) $16\nb.) $15\nc.) $14\nd.) $13");
        answers.add("Answer: a.) $16.");
        explanations.add("Explanation: The cost per apple is $10 ÷ 5 = $2. Therefore, the cost of 8 apples is 8 × $2 = $16.");

        questions.add("A cyclist covers a distance of 120 kilometers in 3 hours. What is the cyclist's average speed?\n\na.) 30 km/h\nb.) 35 km/h\nc.) 40 km/h\nd.) 45 km/h");
        answers.add("Answer: c.) 40 km/h.");
        explanations.add("Explanation: Average speed is found by dividing the distance by the time taken. 120 kilometers ÷ 3 hours = 40 km/h.");

        questions.add("If x + 3 = 9, what is the value of x?\n\na.) 5\nb.) 4\nc.) 6\nd.) 3");
        answers.add("Answer: b.) 6.");
        explanations.add("Explanation: To solve for x, subtract 3 from both sides. x = 9 - 3, so x = 6.");

        questions.add("If a jacket costs 80 and is discounted by $20, what is the sale price?");
        answers.add("Answer: 60");
        explanations.add("Explanation: Subtract the discount from the original price: 80−20=60.");

        questions.add("If 12 workers can build a house in 10 days, how long will it take for 8 workers to build the same house?\n\na.) 12.5 days\nb.) 13 days\nc.) 15 days\nd.) 17.5 days");
        answers.add("Answer: c.) 15 days.");
        explanations.add("Explanation: With fewer workers, the time increases proportionally. The ratio of workers is 12 ÷ 8 = 1.5, so the time increases by 1.5 times: 10 × 1.5 = 15 days.");

        questions.add("A factory makes 500 products in 10 hours. At this rate, how many products can it make in 18 hours?\n\na.) 800\nb.) 850\nc.) 900\nd.) 920");
        answers.add("Answer: c.) 900.");
        explanations.add("Explanation: The rate is 500 products per 10 hours, or 50 products per hour. In 18 hours, it will produce 50 × 18 = 900 products.");

        questions.add("John can mow a lawn in 3 hours. If his friend joins him and they work together, they finish the job in 2 hours. How long would it take his friend to mow the lawn alone?\n\na.) 3.5 hours\nb.) 4 hours\nc.) 5 hours\nd.) 6 hours");
        answers.add("Answer: d.) 6 hours.");
        explanations.add("Explanation: John's rate is 1/3 of the lawn per hour. Together they finish 1 lawn in 2 hours, meaning their combined rate is 1/2 of the lawn per hour. Let x be the time it takes his friend alone, so John's rate + friend's rate = 1/3 + 1/x = 1/2. Solving this gives x = 6 hours.");

        questions.add("Two cars start from the same point and travel in opposite directions. One car travels at 60 km/h, and the other at 80 km/h. After how many hours will they be 420 km apart?\n\na.) 2.5 hours\nb.) 3 hours\nc.) 3.5 hours\nd.) 4 hours");
        answers.add("Answer: b.) 3 hours.");
        explanations.add("Explanation: The total distance covered per hour is 60 + 80 = 140 km/h. The time it takes to cover 420 km is 420 ÷ 140 = 3 hours.");

        questions.add("A train travels at a speed of 90 km/h. How far will it travel in 4 hours and 30 minutes?\n\na.) 400 km\nb.) 405 km\nc.) 420 km\nd.) 450 km");
        answers.add("Answer: c.) 405 km.");
        explanations.add("Explanation: Convert 4 hours 30 minutes to 4.5 hours. Distance = Speed × Time, so 90 × 4.5 = 405 km.");

        questions.add("A company increased the salary of all its employees by 12%. If an employee's original salary was $50,000, what is their new salary?\n\na.) $54,500\nb.) $55,000\nc.) $56,000\nd.) $56,500");
        answers.add("Answer: c.) $56,000.");
        explanations.add("Explanation: The increase is 12% of $50,000, which is $50,000 × 0.12 = $6,000. Add this to the original salary: $50,000 + $6,000 = $56,000.");

        questions.add("If an investment grows at a rate of 5% per year, how much will a $10,000 investment be worth after 3 years (compound interest, rounded to the nearest dollar)?\n\na.) $11,157\nb.) $11,576\nc.) $11,630\nd.) $11,712");
        answers.add("Answer: a.) $11,576.");
        explanations.add("Explanation: Using the compound interest formula A = P(1 + r/n)^(nt), where P = 10,000, r = 0.05, n = 1, and t = 3, the value after 3 years is approximately $11,576.");

        questions.add("Solve: 8 + (6 ÷ 3) × 2 - 5.\n\na.) 7\nb.) 9\nc.) 5\nd.) 11");
        answers.add("Answer: a.) 7.");
        explanations.add("Explanation: Follow the order of operations (PEMDAS). First, divide: 6 ÷ 3 = 2. Then multiply: 2 × 2 = 4. Finally, perform addition and subtraction: 8 + 4 - 5 = 7.");

        questions.add("John bought 3 packs of pencils, each containing 12 pencils. If he gives 8 pencils to a friend, how many pencils does he have left?\n\na.) 28\nb.) 32\nc.) 36\nd.) 24");
        answers.add("Answer: b.) 28.");
        explanations.add("Explanation: John starts with 3 packs of 12 pencils, which gives him 36 pencils in total. After giving 8 away, he has 36 - 8 = 28 pencils left.");

        questions.add("If a car travels 240 kilometers in 4 hours, what is its average speed?\n\na.) 50 km/h\nb.) 55 km/h\nc.) 60 km/h\nd.) 65 km/h");
        answers.add("Answer: c.) 60 km/h.");
        explanations.add("Explanation: Average speed is found by dividing the distance traveled by the time taken. 240 kilometers ÷ 4 hours = 60 km/h.");

        questions.add("A rectangular garden is twice as long as it is wide. If the perimeter is 60 meters, what is the width?\n\na.) 10 meters\nb.) 12 meters\nc.) 15 meters\nd.) 20 meters");
        answers.add("Answer: a.) 10 meters.");
        explanations.add("Explanation: Let the width be x. The length is 2x. The perimeter is 2(length + width), so 60 = 2(2x + x). Simplifying: 60 = 6x, so x = 10 meters.");

        questions.add("The sum of three consecutive even numbers is 54. What is the middle number?\n\na.) 16\nb.) 18\nc.) 20\nd.) 22");
        answers.add("Answer: b.) 18.");
        explanations.add("Explanation: Let the numbers be x, x + 2, and x + 4. Their sum is x + (x + 2) + (x + 4) = 54. Simplifying: 3x + 6 = 54, so 3x = 48 and x = 16. Therefore, the middle number is 18.");

        questions.add("A book is marked down by 20% and now costs $24. What was the original price of the book?\n\na.) $30\nb.) $28\nc.) $32\nd.) $25");
        answers.add("Answer: a.) $30.");
        explanations.add("Explanation: Let the original price be x. The price after a 20% discount is 80% of the original price. So, 0.8x = 24, and x = 24 ÷ 0.8 = $30.");

        questions.add("If a car travels at 72 km/h, how far will it travel in 2.5 hours?\n\na.) 150 km\nb.) 180 km\nc.) 120 km\nd.) 90 km");
        answers.add("Answer: b.) 180 km.");
        explanations.add("Explanation: Multiply the speed by the time: 72 km/h × 2.5 hours = 180 km.");

        questions.add("Simplify: 5x + 3x - 2x.\n\na.) 6x\nb.) 5x\nc.) 4x\nd.) 3x");
        answers.add("Answer: a.) 6x.");
        explanations.add("Explanation: Combine the like terms: 5x + 3x = 8x, then subtract 2x. The result is 6x.");

        questions.add("If 4x = 12, what is the value of x?\n\na.) 2\nb.) 3\nc.) 4\nd.) 5");
        answers.add("Answer: b.) 3.");
        explanations.add("Explanation: Divide both sides by 4 to solve for x. x = 12 ÷ 4 = 3.");

        questions.add("A box contains 36 marbles. If 3/4 of the marbles are red, how many red marbles are in the box?\n\na.) 24\nb.) 27\nc.) 28\nd.) 30");
        answers.add("Answer: b.) 27.");
        explanations.add("Explanation: To find 3/4 of 36, multiply 36 by 3/4. 36 × 3/4 = 27.");

        questions.add("What is the least common multiple (LCM) of 6 and 8?\n\na.) 12\nb.) 24\nc.) 18\nd.) 36");
        answers.add("Answer: b.) 24.");
        explanations.add("Explanation: The multiples of 6 are 6, 12, 18, 24... and the multiples of 8 are 8, 16, 24... The smallest multiple they have in common is 24.");

        questions.add("A piece of ribbon 45 cm long is cut into pieces of 15 cm each. How many pieces are there?\n\na.) 2\nb.) 3\nc.) 4\nd.) 5");
        answers.add("Answer: b.) 3.");
        explanations.add("Explanation: Divide the total length by the length of each piece. 45 ÷ 15 = 3 pieces.");

        questions.add("Simplify the following: 4(2x - 3) + 2x.\n\na.) 8x - 6\nb.) 10x - 12\nc.) 8x - 12\nd.) 8x - 9");
        answers.add("Answer: c.) 8x - 12.");
        explanations.add("Explanation: First, distribute the 4: 4(2x - 3) becomes 8x - 12. Then add 2x: 8x + 2x - 12 = 10x - 12.");


        // Shuffle the questions, answers, and explanations
        shuffleQuestions();

        // Display the first question
        updateQuestion();

        // Next button click listener
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex < questions.size() - 1) {
                    currentQuestionIndex++;  // Move to the next question
                    updateQuestion();  // Update the displayed question
                }
            }
        });

        // Previous button click listener
        previousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestionIndex > 0) {
                    currentQuestionIndex--;  // Move to the previous question
                    updateQuestion();  // Update the displayed question
                }
            }
        });

        // Back button click listener
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();  // Finish the current activity and return to the previous one
            }
        });
    }

    // Function to shuffle the questions, answers, and explanations while keeping them aligned
    private void shuffleQuestions() {
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            indices.add(i);
        }

        // Shuffle the indices
        Collections.shuffle(indices);

        // Create new shuffled lists
        ArrayList<String> shuffledQuestions = new ArrayList<>();
        ArrayList<String> shuffledAnswers = new ArrayList<>();
        ArrayList<String> shuffledExplanations = new ArrayList<>();

        for (int index : indices) {
            shuffledQuestions.add(questions.get(index));
            shuffledAnswers.add(answers.get(index));
            shuffledExplanations.add(explanations.get(index));
        }

        // Update the original lists with shuffled content
        questions = shuffledQuestions;
        answers = shuffledAnswers;
        explanations = shuffledExplanations;
    }

    // Update the displayed question, answer, and explanation
    private void updateQuestion() {
        questionTextView.setText(questions.get(currentQuestionIndex));
        answerTextView.setText(answers.get(currentQuestionIndex));
        explanationTextView.setText(explanations.get(currentQuestionIndex));
        questionCounterTextView.setText((currentQuestionIndex + 1) + " out of " + questions.size());
    }
}
