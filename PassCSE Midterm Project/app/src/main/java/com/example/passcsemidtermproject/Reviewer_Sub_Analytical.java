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

public class Reviewer_Sub_Analytical extends AppCompatActivity {

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
        setContentView(R.layout.reviewer_sub_analytical);

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

        // Add questions, answers, and explanations
        questions.add("Which word is most similar to “abundant”?");
        answers.add("Answer: Plentiful");
        explanations.add("Explanation: “Abundant” means having plenty of something. The word “plentiful” is a synonym for “abundant,” meaning in large quantities. The other options are antonyms or unrelated.");

        questions.add("Choose the word that is most opposite in meaning to “diligent.”");
        answers.add("Answer: Lazy");
        explanations.add("Explanation: “Diligent” means showing care and effort in one’s work or duties. The opposite of diligent is “lazy,” which means unwilling to work or use energy.");

        questions.add("Which word is most similar to “innovative”?");
        answers.add("Answer: Creative");
        explanations.add("Explanation: “Innovative” refers to introducing new ideas or methods. “Creative” is a synonym, meaning having the ability to create new and original ideas. The other options are more aligned with maintaining the status quo.");

        questions.add("Which word is most similar to “benevolent”?");
        answers.add("Answer: Kind");
        explanations.add("Explanation: “Benevolent” means well-meaning and kindly. The word “kind” is a synonym for benevolent.");

        questions.add("Which word is most opposite in meaning to “optimistic”?");
        answers.add("Answer: Pessimistic");
        explanations.add("Explanation: “Optimistic” means hopeful and confident about the future. The opposite is “pessimistic,” which means expecting the worst.");

        questions.add("Which word is most similar to “gregarious”?");
        answers.add("Answer: Sociable");
        explanations.add("Explanation: “Gregarious” means enjoying the company of others and being sociable. The word “sociable” is a synonym for gregarious.");

        questions.add("Choose the word that is most opposite in meaning to “frugal”.");
        answers.add("Answer: Wasteful");
        explanations.add("Explanation: “Frugal” means being economical with resources. The opposite is “wasteful,” which means using resources carelessly.");

        questions.add("Identify the assumption in the statement: “If it rains, the picnic will be canceled.”");
        answers.add("Answer: The picnic is planned for a day when it might rain.");
        explanations.add("Explanation: The assumption here is that there is a possibility of rain on the day of the picnic. Without this assumption, the statement about canceling the picnic due to rain would not make sense.");

        questions.add("What conclusion can be drawn from the statement: “All students in the class passed the exam.”?");
        answers.add("Answer: No student in the class failed the exam.");
        explanations.add("Explanation: If all students passed the exam, it logically follows that no student failed. The other options contradict the given statement.");

        questions.add("Identify the assumption in the statement: “Eating healthy foods leads to better health.”");
        answers.add("Answer: There is a direct relationship between diet and health.");
        explanations.add("Explanation: The statement assumes that there is a direct link between what one eats and their health outcomes. Without this assumption, the statement would not hold.");

        questions.add("Identify the assumption in the statement: “If you study hard, you will pass the exam.”");
        answers.add("Answer: Studying hard guarantees success.");
        explanations.add("Explanation: The statement assumes that hard study will lead to passing the exam, implying a direct correlation between effort and success.");

        questions.add("Identify the conclusion in the statement: “Since it is raining, the match will be postponed.”");
        answers.add("Answer: The match will be postponed.");
        explanations.add("Explanation: The conclusion drawn from the statement is that the match will be postponed due to the rain.");

        questions.add("Identify the assumption in the statement: “If you exercise regularly, you will stay healthy.”");
        answers.add("Answer: Exercise has a positive impact on health.");
        explanations.add("Explanation: The statement assumes that regular exercise contributes positively to one’s health. Without this assumption, the statement would not be valid.");

        questions.add("What conclusion can be drawn from the statement: “All employees must wear ID badges.”?");
        answers.add("Answer: Every employee wears an ID badge.");
        explanations.add("Explanation: If all employees must wear ID badges, it logically follows that every employee wears one.");

        questions.add("Identify the assumption in the statement: “Using public transport reduces traffic congestion.”");
        answers.add("Answer: Public transport can replace private vehicles.");
        explanations.add("Explanation: The statement assumes that public transport can effectively replace private vehicles, thereby reducing traffic congestion.");

        questions.add("If all roses are flowers and some flowers fade quickly, which of the following is true?");
        answers.add("Answer: Some flowers do not fade quickly.");
        explanations.add("Explanation: The statement does not provide enough information to conclude anything specific about roses fading quickly. However, it does imply that not all flowers fade quickly, so some flowers must not fade quickly.");

        questions.add("If A is taller than B, and B is taller than C, which of the following is true?");
        answers.add("Answer: A is taller than C.");
        explanations.add("Explanation: If A is taller than B and B is taller than C, then logically, A must be taller than C.");

        questions.add("If it is raining, then the ground is wet. The ground is not wet. What can be concluded?");
        answers.add("Answer: It is not raining.");
        explanations.add("Explanation: The statement 'If it is raining, then the ground is wet' implies that rain causes the ground to be wet. If the ground is not wet, it can be concluded that it is not raining.");

        questions.add("If all squares are rectangles and all rectangles are quadrilaterals, which of the following is true?");
        answers.add("Answer: All squares are quadrilaterals.");
        explanations.add("Explanation: Since all squares are rectangles and all rectangles are quadrilaterals, it follows that all squares must be quadrilaterals.");

        questions.add("If some fruits are apples and all apples are sweet, which of the following is true?");
        answers.add("Answer: Some fruits are sweet.");
        explanations.add("Explanation: Since some fruits are apples and all apples are sweet, it follows that some fruits must be sweet.");

        questions.add("If all birds can fly and penguins are birds, which of the following is true?");
        answers.add("Answer: Penguins cannot fly.");
        explanations.add("Explanation: The statement 'all birds can fly' includes all birds without exception. Since penguins are birds, they must also be able to fly according to the given premise, even though in reality, penguins cannot fly. This question tests logical consistency with the given premises.");

        questions.add("If some doctors are scientists and all scientists are researchers, which of the following is true?");
        answers.add("Answer: Some doctors are researchers.");
        explanations.add("Explanation: Since some doctors are scientists and all scientists are researchers, it follows that some doctors must also be researchers.");

        questions.add("A survey shows that 60% of respondents prefer coffee over tea. If 300 people were surveyed, how many prefer coffee?");
        answers.add("Answer: 180");
        explanations.add("Explanation: To find the number of people who prefer coffee, calculate 60% of 300. ( 0.60 × 300 = 180 ).");

        questions.add("In a class of 40 students, 25% received an A on the test. How many students received an A?");
        answers.add("Answer: 10");
        explanations.add("Explanation: To find the number of students who received an A, calculate 25% of 40. ( 0.25 × 40 = 10 ).");

        questions.add("A company’s revenue increased from PHP 1,000,000 to PHP 1,200,000. What is the percentage increase?");
        answers.add("Answer:20%");
        explanations.add("Explanation: The percentage increase is calculated by the formula: ({New Value} - {Old Value})/{Old Value} × 100. So, ({1,200,000 - 1,000,000}/{1,000,000} × 100 = 20%).");

        questions.add("A pie chart shows that 40% of a company’s budget is spent on salaries, 30% on marketing, 20% on research, and 10% on other expenses. If the total budget is PHP 500,000, how much is spent on marketing?");
        answers.add("Answer: PHP 150,000");
        explanations.add("Explanation: To find the amount spent on marketing, calculate 30% of PHP 500,000. ( 0.30 × 500,000 = 150,000 ).");

        questions.add("A bar graph shows the sales of a company over five years. If the sales in the first year were PHP 200,000 and increased by PHP 50,000 each subsequent year, what were the sales in the fifth year?");
        answers.add("Answer: PHP 450,000");
        explanations.add("Explanation: The sales increase by PHP 50,000 each year. Starting from PHP 200,000, using the MDAS the sales in the fifth year would be (200,000 + 5 × 50,000 = 450,000).");

        questions.add("A pie chart shows the distribution of a budget: 25% on salaries, 35% on marketing, 20% on research, and 20% on other expenses. If the total budget is PHP 800,000, how much is allocated for research?");
        answers.add("Answer: PHP 160,000");
        explanations.add("Explanation: To find the allocation for research, calculate 20% of PHP 800,000. ( 0.20 × 800,000 = 160,000 ).");

        questions.add("If the probability of drawing a red card from a deck of cards is 1/2, what is the probability of drawing a black card?");
        answers.add("Answer: 1/2");
        explanations.add("Explanation: The probability of drawing a black card is the complement of drawing a red card. Since the total probability must equal 1, if the probability of drawing a red card is 1/2, the probability of drawing a black card is also 1/2.");

        questions.add("A box contains 3 red balls, 2 blue balls, and 5 green balls. What is the probability of randomly selecting a blue ball?");
        answers.add("Answer: 1/10");
        explanations.add("Explanation: The total number of balls in the box is 3 + 2 + 5 = 10. The probability of selecting a blue ball is the number of blue balls divided by the total number of balls. (2/10 = 1/10).");

        questions.add("If there are 30 students in a class and 12 are boys, what fraction of the class is girls?");
        answers.add("Answer:3/5");
        explanations.add("Explanation: The number of girls is 30 - 12 = 18. The fraction of girls in the class is 18/30, which simplifies to 3/5.");

        questions.add("A survey indicates that 60% of people prefer to shop online. If there are 200 people surveyed, how many prefer to shop online?");
        answers.add("Answer: 120");
        explanations.add("Explanation: To find the number of people who prefer shopping online, calculate 60% of 200. (0.60 × 200 = 120).");

        questions.add("In a class of 40 students, 70% passed the exam. How many students passed?");
        answers.add("Answer: 28");
        explanations.add("Explanation: To find the number of students who passed, calculate 70% of 40. (0.70 × 40 = 28).");


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
