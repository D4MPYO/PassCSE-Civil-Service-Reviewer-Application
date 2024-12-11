package com.example.passcsemidtermproject;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView; // Import ImageView
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Collections;
import java.util.ArrayList;

public class Reviewer_Pro_Numerical extends AppCompatActivity {

    private TextView questionTextView, answerTextView, explanationTextView, questionCounterTextView;
    private Button nextButton, previousButton;
    private ImageView backButton;
    private int currentQuestionIndex = 0;
    private ArrayList<String> questions;
    private ArrayList<String> answers;
    private ArrayList<String> explanations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.reviewer_pro_numerical);

        // Initialize UI elements
        questionTextView = findViewById(R.id.text_question);
        answerTextView = findViewById(R.id.Answer);
        explanationTextView = findViewById(R.id.explanation);
        questionCounterTextView = findViewById(R.id.cpt_question);
        nextButton = findViewById(R.id.btn_next);
        previousButton = findViewById(R.id.btn_previous);
        backButton = findViewById(R.id.backButton);


        questions = new ArrayList<>();
        answers = new ArrayList<>();
        explanations = new ArrayList<>();

        // Add questions, answers, and explanations
        questions.add("What is 432 + 198?");
        answers.add("Answer: 630");
        explanations.add("Explanation: Add the two numbers: 432 + 198 = 630.");

        questions.add("What is 15% of 200?");
        answers.add("Answer: 30");
        explanations.add("Explanation: To find 15% of 200, multiply 200 by 0.15 (15/100): 200×0.15=30.");

        questions.add("A recipe calls for 4 cups of water for every 2 cups of rice. What is the ratio of water to rice?");
        answers.add("Answer: 2:1");
        explanations.add("Explanation: The ratio of water to rice is calculated as 4:2, which simplifies to 2:1 by dividing both sides by 2.");

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

        questions.add("A car travels 150 miles on 5 gallons of gas. How many miles can it travel on 10 gallons?");
        answers.add("Answer: 300 miles");
        explanations.add("Explanation: First, find the MPG: 150÷5=30. Then calculate the distance for 10 gallons: 30×10=300.");

        questions.add("What is 90 divided by 3?");
        answers.add("Answer: 30");
        explanations.add("Explanation: To divide, perform the calculation: 90÷3=30.");

        questions.add("If a jacket costs 80 and is discounted by $20, what is the sale price?");
        answers.add("Answer: 60");
        explanations.add("Explanation: Subtract the discount from the original price: 80−20=60.");

        questions.add("What is the ratio of 20 to 50?");
        answers.add("Answer: 2:5");
        explanations.add("Explanation: The ratio 20:50 simplifies by dividing both numbers by 10: 20÷10:50÷10=2:5.");

        questions.add("If a student scored 72 out of 90 on a test, what percentage did they achieve?");
        answers.add("Answer: 80%");
        explanations.add("Explanation: To find the percentage, divide the score by the total and multiply by 100: (72÷90) ×100=80%.");

        questions.add("A bag of flour costs 3.25. How much do 4 bags cost?");
        answers.add("Answer: 13.00");
        explanations.add("Explanation: Multiply the cost of one bag by 4: 3.25×4=13.00.");

        questions.add("If an item is priced at 150 and has a 20% discount, what is the sale price?");
        answers.add("Answer: 120");
        explanations.add("Explanation: Calculate the discount: 150×0.20=30. Subtract from the original price: 150−30=120.");

        questions.add("What is the sum of 567 and 434?");
        answers.add("Answer: 1001");
        explanations.add("Explanation: Add the two numbers: 567+434=1001.");

        questions.add("If a car uses 12 gallons of gas for 300 miles, how many gallons are needed for 600 miles?");
        answers.add("Answer: 24 gallons");
        explanations.add("Explanation: Since 300 miles uses 12 gallons, 600 miles will use double the amount: 12×2=24.");

        questions.add("What is 18 × 12?");
        answers.add("Answer: 216");
        explanations.add("Explanation: Multiply the two numbers: 18×12=216.");

        questions.add("A car travels 150 miles on 5 gallons of gas. How many miles can it travel on 10 gallons?");
        answers.add("Answer: 300 miles");
        explanations.add("Explanation: First, find the MPG: 150÷5=30. Then calculate the distance for 10 gallons: 30×10=300.");

        questions.add("What is 90 divided by 3?");
        answers.add("Answer: 30");
        explanations.add("Explanation: To divide, perform the calculation: 90÷3=30.");

        questions.add("If a jacket costs 80 and is discounted by $20, what is the sale price?");
        answers.add("Answer: 60");
        explanations.add("Explanation: Subtract the discount from the original price: 80−20=60.");

        questions.add("What is the ratio of 20 to 50?");
        answers.add("Answer: 2:5");
        explanations.add("Explanation: The ratio 20:50 simplifies by dividing both numbers by 10: 20÷10:50÷10=2:5.");

        questions.add("If a student scored 72 out of 90 on a test, what percentage did they achieve?");
        answers.add("Answer: 80%");
        explanations.add("Explanation: To find the percentage, divide the score by the total and multiply by 100: (72÷90) ×100=80%.");

        questions.add("A bag of flour costs 3.25. How much do 4 bags cost?");
        answers.add("Answer: 13.00");
        explanations.add("Explanation: Multiply the cost of one bag by 4: 3.25×4=13.00.");

        questions.add("If an item is priced at 150 and has a 20% discount, what is the sale price?");
        answers.add("Answer: 120");
        explanations.add("Explanation: Calculate the discount: 150×0.20=30. Subtract from the original price: 150−30=120.");

        questions.add("What is the sum of 567 and 434?");
        answers.add("Answer: 1001");
        explanations.add("Explanation: Add the two numbers: 567+434=1001.");

        questions.add("If a car uses 12 gallons of gas for 300 miles, how many gallons are needed for 600 miles?");
        answers.add("Answer: 24 gallons");
        explanations.add("Explanation: Since 300 miles uses 12 gallons, 600 miles will use double the amount: 12×2=24.");

        questions.add("What is 7% of 200?");
        answers.add("Answer: 14");
        explanations.add("Explanation: Multiply 200 by 0.07: 200×0.07=14.");

        questions.add("If a student scored 85 out of 100, what is their percentage score?");
        answers.add("Answer: 85%");
        explanations.add("Explanation: Divide the score by the total and multiply by 100: (85÷100) ×100=85%.");

        questions.add("A store sells 3 notebooks for 6. How much would 10 notebooks cost?");
        answers.add("Answer: 20");
        explanations.add("Explanation: First, find the cost of one notebook: 6÷3=2. Then multiply by 10: 2×10=20.");

        questions.add("What is the difference between 1,000 and 345?");
        answers.add("Answer: 655");
        explanations.add("Explanation: Subtract 345 from 1000: 1000−345=655.");

        questions.add("If a dress cost 120 and is on sale for 30% off, what is the sale price?");
        answers.add("Answer: 84");
        explanations.add("Explanation: Calculate the discount: 120×0.30=36. Subtract from the original price: 120−36=84.");

        questions.add("What is 40% of 250?");
        answers.add("Answer: 100");
        explanations.add("Explanation: Multiply 250 by 0.40: 250×0.40=100.");

        questions.add("If a train travels 180 miles in 3 hours, what is its speed in miles per hour?");
        answers.add("Answer: 60 MPH");
        explanations.add("Explanation: Speed is calculated by dividing distance by time: 180÷3=60 MPH.");

        questions.add("If a pizza is cut into 8 equal slices and 3 are eaten, what fraction of the pizza remains?");
        answers.add("Answer: 5/8");
        explanations.add("Explanation: 5 slices are left out of 8, so the fraction is 5/8.");

        questions.add("What is 50 divided by 5?");
        answers.add("Answer: 10");
        explanations.add("Explanation: Perform the division: 50÷5=10.");

        questions.add("If a computer cost 800 and is discounted by 15%, what is the sale price?");
        answers.add("Answer: 680");
        explanations.add("Explanation: Calculate the discount: 800×0.15=120. Subtract from the original price: 800−120=680.");

        questions.add("What is the sum of 1,234 and 567?");
        answers.add("Answer: 1,801");
        explanations.add("Explanation: Add the two numbers: 1234+567=1801.");

        questions.add("If a pair of shoes costs 90 and is on sale for 20% off, what is the discount amount?");
        answers.add("Answer: 18");
        explanations.add("Explanation: Calculate the discount: 90×0.20=18.");

        questions.add("A car can travel 400 miles on 10 gallons of gas. What is the MPG?");
        answers.add("Answer: 40 MPG");
        explanations.add("Explanation: Calculate MPG: 400÷10=40.");

        questions.add("What is 2/5 of 100?");
        answers.add("Answer: 40");
        explanations.add("Explanation: Multiply 100 by 0.4: 100×0.4=40.");

        questions.add("If a watch cost 250 and the sales tax is 10%, what is the total price?");
        answers.add("Answer: 275");
        explanations.add("Explanation: Calculate the sales tax: 250×0.10=25. Add the tax to the original price: 250+25=275.");

        questions.add("What is the ratio of 15 to 45?");
        answers.add("Answer: 1:3");
        explanations.add("Explanation: The ratio 15:45 simplifies by dividing both numbers by 15: 15÷15:45÷15=1:3.");

        questions.add("If 30% of a number is 12, what is the number?");
        answers.add("Answer: 40");
        explanations.add("Explanation: Let x be the number. Set up the equation: 0.30x=12. Solve for x: x=12÷0.30=40.");

        questions.add("A box contains 6 red balls and 4 blue balls. What is the ratio of red balls to total balls?");
        answers.add("Answer: 6:10 (or 3:5)");
        explanations.add("Explanation: There are 6 red and 4 blue balls, totaling 10 balls. The ratio of red balls to total is 6:10, which simplifies to 3:5.");

        questions.add("What is 200 minus 78?");
        answers.add("Answer: 122");
        explanations.add("Explanation: Subtract 78 from 200: 200−78=122.");

        questions.add("If a product is priced at $200 and has a 25% discount, what is the final price?");
        answers.add("Answer: $150");
        explanations.add("Explanation: Calculate the discount: 200×0.25=50. Subtract the discount from the original price: 200−50=150.");

        questions.add("2, 4, 8, 16, ___");
        answers.add("Answer: 32");
        explanations.add("Explanation: Each number is multiplied by 2: 2 × 2 = 4, 4 × 2 = 8, 8 × 2 = 16. Continuing this pattern: 16 × 2 = 32.");

        questions.add("5, 10, 15, 20, ___");
        answers.add("Answer: 25");
        explanations.add("Explanation: Each number increases by 5: 5 + 5 = 10, 10 + 5 = 15, 15 + 5 = 20. Thus, 20 + 5 = 25.");

        questions.add("3, 6, 12, 24, ___");
        answers.add("Answer: 48");
        explanations.add("Explanation: Each number is multiplied by 2: 3 × 2 = 6, 6 × 2 = 12, 12 × 2 = 24. Continuing this pattern: 24 × 2 = 48.");

        questions.add("1, 1, 2, 3, 5, ___");
        answers.add("Answer: 7");
        explanations.add("Explanation: This is the Fibonacci sequence where the next number is the sum of the two preceding numbers: 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5. Thus, 5 + 2 = 7.");

        questions.add("10, 20, 30, 40, ___");
        answers.add("Answer: 50");
        explanations.add("Explanation: Each number increases by 10: 10 + 10 = 20, 20 + 10 = 30, 30 + 10 = 40. Therefore, 40 + 10 = 50.");

        questions.add("1, 4, 9, 16, ___");
        answers.add("Answer: 25");
        explanations.add("Explanation: These are perfect squares: 1^2 = 1, 2^2 = 4, 3^2 = 9, 4^2 = 16. Thus, the next number is 5^2 = 25.");

        questions.add("7, 14, 28, 56, ___");
        answers.add("Answer: 112");
        explanations.add("Explanation: Each number is multiplied by 2: 7 × 2 = 14, 14 × 2 = 28, 28 × 2 = 56. Continuing this pattern: 56 × 2 = 112.");

        questions.add("100, 90, 80, 70, ___");
        answers.add("Answer: 60");
        explanations.add("Explanation: Each number decreases by 10: 100 - 10 = 90, 90 - 10 = 80, 80 - 10 = 70. Thus, 70 - 10 = 60.");

        questions.add("1, 2, 4, 7, ___");
        answers.add("Answer: 11");
        explanations.add("Explanation: The differences are increasing: 2 - 1 = 1, 4 - 2 = 2, 7 - 4 = 3. The next difference should be 4: 7 + 4 = 11.");

        questions.add("12, 15, 18, 21, ___");
        answers.add("Answer: 24");
        explanations.add("Explanation: Each number increases by 3: 12 + 3 = 15, 15 + 3 = 18, 18 + 3 = 21. Thus, 21 + 3 = 24.");

        questions.add("2, 5, 10, 17, ___");
        answers.add("Answer: 26");
        explanations.add("Explanation: The differences between the numbers are increasing by 2: 5 - 2 = 3, 10 - 5 = 5, 17 - 10 = 7. The next difference should be 9: 17 + 9 = 26.");

        questions.add("2, 3, 5, 7, 11, ___");
        answers.add("Answer: 13");
        explanations.add("Explanation: These are prime numbers: 2, 3, 5, 7, 11. The next prime number is 13.");

        questions.add("20, 30, 40, 50, ___");
        answers.add("Answer: 60");
        explanations.add("Explanation: Each number increases by 10: 20 + 10 = 30, 30 + 10 = 40, 40 + 10 = 50. Thus, 50 + 10 = 60.");

        questions.add("9, 18, 36, 72, ___");
        answers.add("Answer: 144");
        explanations.add("Explanation: Each number is multiplied by 2: 9 × 2 = 18, 18 × 2 = 36, 36 × 2 = 72. Thus, 72 × 2 = 144.");

        questions.add("5, 10, 20, 40, ___");
        answers.add("Answer: 80");
        explanations.add("Explanation: Each number is multiplied by 2: 5 × 2 = 10, 10 × 2 = 20, 20 × 2 = 40. Therefore, 40 × 2 = 80.");

        questions.add("8, 16, 32, 64, ___");
        answers.add("Answer: 128");
        explanations.add("Explanation: Each number is multiplied by 2: 8 × 2 = 16, 16 × 2 = 32, 32 × 2 = 64. Thus, 64 × 2 = 128.");

        questions.add("15, 30, 45, 60, ___");
        answers.add("Answer: 75");
        explanations.add("Explanation: Each number increases by 15: 15 + 15 = 30, 30 + 15 = 45, 45 + 15 = 60. Therefore, 60 + 15 = 75.");

        questions.add("4, 8, 16, 32, ___");
        answers.add("Answer: 64");
        explanations.add("Explanation: Each number is multiplied by 2: 4 × 2 = 8, 8 × 2 = 16, 16 × 2 = 32. Thus, 32 × 2 = 64.");

        questions.add("3, 7, 13, 21, ___");
        answers.add("Answer: 29");
        explanations.add("Explanation: The differences between the numbers are increasing: 7 - 3 = 4, 13 - 7 = 6, 21 - 13 = 8. The next difference should be 10: 21 + 8 = 29.");

        questions.add("1, 3, 6, 10, ___");
        answers.add("Answer: 15");
        explanations.add("Explanation: This is the sequence of triangular numbers: 1 = 1, 1 + 2 = 3, 3 + 3 = 6, 6 + 4 = 10. Thus, 10 + 5 = 15.");

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
