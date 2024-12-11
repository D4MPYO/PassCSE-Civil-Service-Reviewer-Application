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

public class Reviewer_Pro_Analytical extends AppCompatActivity {

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
        setContentView(R.layout.reviewer_pro_analytical);

        // Initialize UI elements
        questionTextView = findViewById(R.id.text_question);
        answerTextView = findViewById(R.id.Answer);
        explanationTextView = findViewById(R.id.explanation);
        questionCounterTextView = findViewById(R.id.cpt_question);
        nextButton = findViewById(R.id.btn_next);
        previousButton = findViewById(R.id.btn_previous);
        backButton = findViewById(R.id.backButton); // Initialize backButton

        // Initialize questions, answers, and explanations lists
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        explanations = new ArrayList<>();

        // Add questions, answers, and explanations
        questions.add("Analyze the statements: All roses are flowers. Some flowers are red. Therefore, some roses are red.\n\na.) true\nb.) false\nc.) uncertain\nd.) not necessarily");
        answers.add("Answer: c.) uncertain.");
        explanations.add("Explanation: While all roses are flowers, we cannot determine if any roses are specifically red based on the provided information.");

        questions.add("Consider this argument: If it rains, the ground will be wet. It is not raining. Therefore, the ground is not wet.\n\na.) true\nb.) false\nc.) cannot be determined\nd.) possibly true");
        answers.add("Answer: b.) false.");
        explanations.add("Explanation: The ground could be wet for other reasons even if it is not currently raining.");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n1. The scientist's **methodical** approach ensured accurate results.\n\na.) Hasty\nb.) Systematic\nc.) Random\nd.) Sporadic");
        answers.add("Answer: b.) Systematic.");
        explanations.add("Explanation: 'Methodical' means done according to a systematic or established procedure, similar to 'systematic.'");

        questions.add("Evaluate this statement: All cats are mammals. Some mammals are not pets. Therefore, some cats are not pets.\n\na.) true\nb.) false\nc.) not enough information\nd.) definitely true");
        answers.add("Answer: c.) not enough information.");
        explanations.add("Explanation: While some mammals are not pets, we cannot definitively conclude anything about cats being pets.");

        questions.add("Assess this reasoning: Some doctors are also teachers. All teachers work in schools. Therefore, some doctors work in schools.\n\na.) true\nb.) false\nc.) could be true\nd.) not necessarily");
        answers.add("Answer: c.) could be true.");
        explanations.add("Explanation: It is possible that some doctors work in schools, but the premise does not confirm this.");

        questions.add("Consider the following: All birds can fly. Penguins are birds. Therefore, penguins can fly.\n\na.) true\nb.) false\nc.) misleading\nd.) uncertain");
        answers.add("Answer: b.) false.");
        explanations.add("Explanation: Although penguins are birds, they are a unique exception that cannot fly.");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n1. The scientist's **methodical** approach ensured accurate results.\n\na.) Hasty\nb.) Systematic\nc.) Random\nd.) Sporadic");
        answers.add("Answer: b.) Systematic.");
        explanations.add("Explanation: 'Methodical' means done according to a systematic or established procedure, similar to 'systematic.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n2. The leader's **tenacity** was admired by all.\n\na.) Stubbornness\nb.) Determination\nc.) Indifference\nd.) Hesitation");
        answers.add("Answer: b.) Determination.");
        explanations.add("Explanation: 'Tenacity' refers to the quality of being determined and persistent, similar to 'determination.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n3. The film's **somber** tone made the audience reflective.\n\na.) Joyful\nb.) Gloomy\nc.) Exciting\nd.) Humorous");
        answers.add("Answer: b.) Gloomy.");
        explanations.add("Explanation: 'Somber' means dark or dull in tone, which is similar to 'gloomy.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n4. His **astute** observations impressed the committee.\n\na.) Shallow\nb.) Insightful\nc.) Reckless\nd.) Careless");
        answers.add("Answer: b.) Insightful.");
        explanations.add("Explanation: 'Astute' means having sharp or keen insight, similar to 'insightful.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n5. The **prolific** writer published numerous books every year.\n\na.) Unproductive\nb.) Fertile\nc.) Lazy\nd.) Sparse");
        answers.add("Answer: b.) Fertile.");
        explanations.add("Explanation: 'Prolific' means producing much, similar to 'fertile.'");

        questions.add("Analyze the statement: Every student must take a final exam. Some students are exempt from the final exam. Therefore, not all students must take the final exam.\n\na.) true\nb.) false\nc.) possibly true\nd.) definitely true");
        answers.add("Answer: a.) true.");
        explanations.add("Explanation: The existence of exemptions means that not all students must take the final exam.");

        questions.add("Evaluate the argument: If you study hard, you will pass the exam. You studied hard. Therefore, you will pass the exam.\n\na.) true\nb.) false\nc.) uncertain\nd.) definitely true");
        answers.add("Answer: c.) uncertain.");
        explanations.add("Explanation: While studying hard increases the likelihood of passing, it does not guarantee it.");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n2. The leader's **tenacity** was admired by all.\n\na.) Stubbornness\nb.) Determination\nc.) Indifference\nd.) Hesitation");
        answers.add("Answer: b.) Determination.");
        explanations.add("Explanation: 'Tenacity' refers to the quality of being determined and persistent, similar to 'determination.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n3. The film's **somber** tone made the audience reflective.\n\na.) Joyful\nb.) Gloomy\nc.) Exciting\nd.) Humorous");
        answers.add("Answer: b.) Gloomy.");
        explanations.add("Explanation: 'Somber' means dark or dull in tone, which is similar to 'gloomy.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n4. His **astute** observations impressed the committee.\n\na.) Shallow\nb.) Insightful\nc.) Reckless\nd.) Careless");
        answers.add("Answer: b.) Insightful.");
        explanations.add("Explanation: 'Astute' means having sharp or keen insight, similar to 'insightful.'");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n5. The **prolific** writer published numerous books every year.\n\na.) Unproductive\nb.) Fertile\nc.) Lazy\nd.) Sparse");
        answers.add("Answer: b.) Fertile.");
        explanations.add("Explanation: 'Prolific' means producing much, similar to 'fertile.'");

        questions.add("Choose the word that is most closely related to the word **'teacher'**.\n\na.) Student\nb.) Educator\nc.) Classroom\nd.) Textbook");
        answers.add("Answer: b.) Educator.");
        explanations.add("Explanation: The word 'educator' is most closely related to 'teacher,' as both refer to individuals who impart knowledge and skills to students.");

        questions.add("Choose the word that is most closely related to the word **'guitar'**.\n\na.) Piano\nb.) Violin\nc.) Instrument\nd.) Band");
        answers.add("Answer: c.) Instrument.");
        explanations.add("Explanation: The word 'instrument' is most closely related to 'guitar,' as both refer to tools used to produce music.");

        questions.add("Assess the conclusion: All athletes require physical training. Some athletes are runners. Therefore, all runners require physical training.\n\na.) true\nb.) false\nc.) could be true\nd.) uncertain");
        answers.add("Answer: a.) true.");
        explanations.add("Explanation: Since all athletes require physical training and runners are athletes, they too require physical training.");

        questions.add("Question: The red book has more pages than the green book, but fewer than the blue book. The yellow book has fewer pages than the blue book. The red book has the second fewest pages. If the first two statements are true, the third statement is\n\na.) true\nb.) false\nc.) uncertain\nd.) none of the above");
        answers.add("Answer: b.) false.");
        explanations.add("Explanation: The red book is not second to last since the green book has fewer pages.");

        questions.add("Question: Having a gym membership is a luxury. All luxuries are not necessary. Owning a bicycle is not a luxury.\nCONCLUSION:\n\na.) Owning a bicycle is necessary\nb.) Having a gym membership is not necessary\nc.) A gym membership is a necessity\nd.) Owning a bicycle is a luxury");
        answers.add("Answer: b.) Having a gym membership is not necessary.");
        explanations.add("Explanation: Since luxuries are not necessary, gym memberships fall under that category.");

        questions.add("Question: A store employee has been late to work five times. No one else in the store has been late more than five times.\n\na.) Everyone is late five times\nb.) No one else has been late\nc.) Some employees are never late\nd.) Only one employee has been late five times");
        answers.add("Answer: d.) Only one employee has been late five times.");
        explanations.add("Explanation: The statement indicates no one else has been late that many times.");

        questions.add("Assess the reasoning: All flowers are plants. Some plants need sunlight. Therefore, all flowers need sunlight.\n\na.) True\nb.) False\nc.) Could be true\nd.) Not necessarily");
        answers.add("Answer: d.) Not necessarily.");
        explanations.add("Explanation: Some plants needing sunlight doesn't imply that all flowers do, so the conclusion is not necessarily true.");

        questions.add("Evaluate the following: If the power is out, the lights will not work. The lights are not working. Therefore, the power is out.\n\na.) True\nb.) False\nc.) Possibly true\nd.) Cannot be determined");
        answers.add("Answer: b.) False.");
        explanations.add("Explanation: There could be other reasons for the lights not working, so the conclusion is false.");

        questions.add("Consider the argument: All athletes need to train. Some athletes are runners. Therefore, all runners need to train.\n\na.) True\nb.) False\nc.) Could be true\nd.) Uncertain");
        answers.add("Answer: a.) True.");
        explanations.add("Explanation: Since all athletes need to train and runners are athletes, it follows that all runners need to train.");

        questions.add("Analyze this reasoning: Some birds can fly. All birds are animals. Therefore, all animals can fly.\n\na.) True\nb.) False\nc.) Cannot be determined\nd.) Possibly true");
        answers.add("Answer: b.) False.");
        explanations.add("Explanation: The premise that some birds can fly does not apply to all animals, so the conclusion is false.");

        questions.add("Evaluate this statement: All students must pass an exam to graduate. Some students have already passed the exam. Therefore, some students will graduate.\n\na.) True\nb.) False\nc.) Uncertain\nd.) Definitely true");
        answers.add("Answer: a.) True.");
        explanations.add("Explanation: Since passing the exam is a requirement for graduation, those who passed are eligible to graduate.");

        questions.add("Consider the statement: All cars have engines. Some cars are electric. Therefore, all electric cars have engines.\n\na.) True\nb.) False\nc.) Could be true\nd.) Uncertain");
        answers.add("Answer: a.) True.");
        explanations.add("Explanation: Since all cars, including electric ones, have engines, the conclusion is true.");

        questions.add("Evaluate this reasoning: Some books are fiction. All novels are fiction. Therefore, some books are novels.\n\na.) True\nb.) False\nc.) Could be true\nd.) Not necessarily");
        answers.add("Answer: d.) Not necessarily.");
        explanations.add("Explanation: While all novels are fiction, the premise does not provide enough information to conclude that some books are novels.");

        questions.add("Analyze this argument: Some teachers are kind. All kind people are helpful. Therefore, all teachers are helpful.\n\na.) True\nb.) False\nc.) Cannot be determined\nd.) Possibly true");
        answers.add("Answer: b.) False.");
        explanations.add("Explanation: The fact that some teachers are kind does not imply that all teachers are helpful.");

        questions.add("Evaluate the statement: All fruits have seeds. Some apples are fruits. Therefore, some apples have seeds.\n\na.) True\nb.) False\nc.) Could be true\nd.) Not necessarily");
        answers.add("Answer: a.) True.");
        explanations.add("Explanation: Since apples are a type of fruit and fruits have seeds, it follows that some apples have seeds.");

        questions.add("Consider the following: Some humans are artists. All artists are creative. Therefore, all humans are creative.\n\na.) True\nb.) False\nc.) Could be true\nd.) Uncertain");
        answers.add("Answer: b.) False.");
        explanations.add("Explanation: The premise that some humans are artists does not support the conclusion that all humans are creative.");

        questions.add("Consider the statement: \"To improve air quality, the city must implement stricter emissions regulations on factories.\"\nIdentify the assumption behind this statement.\n\na.) Factories are the only source of air pollution.\nb.) Stricter regulations will reduce emissions.\nc.) Air quality is not currently a concern.\nd.) Factories cannot operate without emissions.");
        answers.add("Answer: b.) Stricter regulations will reduce emissions.");
        explanations.add("Explanation: The assumption is that implementing stricter regulations will effectively lead to reduced emissions, thereby improving air quality.");

        questions.add("The advertisement claims: \"Using Brand X toothpaste will guarantee whiter teeth.\"\nWhat assumption is made in this advertisement?\n\na.) All other toothpaste brands are ineffective.\nb.) Users will follow the instructions properly.\nc.) Brand X toothpaste is the only product that whitens teeth.\nd.) Whiter teeth are the only benefit of using toothpaste.");
        answers.add("Answer: b.) Users will follow the instructions properly.");
        explanations.add("Explanation: The assumption is that the users will use Brand X toothpaste as directed, which is necessary for it to be effective in whitening teeth.");

        questions.add("In the statement: \"If we invest in renewable energy, we will solve our energy crisis,\" what is the underlying assumption?\n\na.) Renewable energy is the only solution to the crisis.\nb.) The current energy crisis can be solved.\nc.) Investing in renewable energy will yield quick results.\nd.) There is enough renewable energy available to meet demand.");
        answers.add("Answer: b.) The current energy crisis can be solved.");
        explanations.add("Explanation: The assumption is that investing in renewable energy will help alleviate the existing energy crisis, implying that a solution exists.");

        questions.add("A politician states: \"If elected, I will reduce taxes for middle-class families.\"\nWhat assumption is implicit in this statement?\n\na.) Middle-class families want tax reductions.\nb.) Reducing taxes will improve the economy.\nc.) The government has enough budget to reduce taxes.\nd.) Only middle-class families deserve tax cuts.");
        answers.add("Answer: a.) Middle-class families want tax reductions.");
        explanations.add("Explanation: The assumption is that middle-class families desire tax reductions, which supports the politician's campaign promise.");

        questions.add("In the conclusion: \"Eating fruits and vegetables leads to better health,\" what assumption is being made?\n\na.) Only fruits and vegetables provide health benefits.\nb.) Poor health is solely due to not eating fruits and vegetables.\nc.) A healthy diet is necessary for good health.\nd.) Eating fruits and vegetables is the only way to improve health.");
        answers.add("Answer: c.) A healthy diet is necessary for good health.");
        explanations.add("Explanation: The assumption is that a balanced and healthy diet, which includes fruits and vegetables, is essential for achieving better health.");

        questions.add("Analyze the following data: A survey showed that 40% of participants prefer tea, 30% prefer coffee, and 30% prefer juice. Based on this data, which beverage is the most popular?\n\na.) Tea\nb.) Coffee\nc.) Juice\nd.) None of the above");
        answers.add("Answer: a.) Tea.");
        explanations.add("Explanation: According to the survey data, 40% of participants prefer tea, making it the most popular beverage among the options provided.");

        questions.add("Consider the pie chart representing sales of different fruits in a market: Apples 25%, Bananas 35%, Cherries 15%, and Dates 25%. Which fruit sold the most?\n\na.) Apples\nb.) Bananas\nc.) Cherries\nd.) Dates");
        answers.add("Answer: b.) Bananas.");
        explanations.add("Explanation: Bananas accounted for 35% of the sales, which is the highest percentage among the fruits listed.");

        questions.add("The bar graph shows the number of books sold in a bookstore: Fiction - 200, Non-Fiction - 150, Children's - 100, and Comics - 50. What is the total number of books sold?\n\na.) 500\nb.) 450\nc.) 400\nd.) 300");
        answers.add("Answer: a.) 500.");
        explanations.add("Explanation: Adding the numbers of each category (200 + 150 + 100 + 50) gives a total of 500 books sold.");

        questions.add("A line graph illustrates the temperature changes over a week: Monday 20°C, Tuesday 22°C, Wednesday 18°C, Thursday 21°C, Friday 23°C, Saturday 25°C, and Sunday 24°C. What was the highest temperature recorded?\n\na.) 20°C\nb.) 22°C\nc.) 25°C\nd.) 24°C");
        answers.add("Answer: c.) 25°C.");
        explanations.add("Explanation: The highest temperature recorded over the week was 25°C on Saturday.");

        questions.add("In a table displaying exam scores: Math - 85, Science - 90, English - 75, History - 80. Which subject had the lowest score?\n\na.) Math\nb.) Science\nc.) English\nd.) History");
        answers.add("Answer: c.) English.");
        explanations.add("Explanation: The lowest score recorded was in English, with a score of 75.");

        questions.add("From the following data, which product had the highest sales in January? Product A - $500, Product B - $700, Product C - $450.\n\na.) Product A\nb.) Product B\nc.) Product C\nd.) None of the above");
        answers.add("Answer: b.) Product B.");
        explanations.add("Explanation: Product B had the highest sales in January, totaling $700.");

        questions.add("Question: Social media causes people to feel less connected in real life while being more connected online.\n\na.) Social media improves real-life connections\nb.) People feel isolated due to social media\nc.) Social media makes people more sociable\nd.) People who use social media aren’t isolated");
        answers.add("Answer: b.) People feel isolated due to social media.");
        explanations.add("Explanation: The statement indicates social media decreases real-life connection.");

        questions.add("Question: The government plans to regulate online businesses under strict guidelines.\n\na.) Online businesses are already regulated\nb.) The demand for online business regulations is increasing\nc.) Businesses can operate without regulation\nd.) The government doesn’t control online businesses");
        answers.add("Answer: b.) The demand for online business regulations is increasing.");
        explanations.add("Explanation: The introduction of new rules suggests increased demand for regulation.");

        questions.add("Read the statement: \"All mammals are warm-blooded. Therefore, if an animal is warm-blooded, it must be a mammal.\"\nWhat is the conclusion drawn from this statement?\n\na.) All warm-blooded animals are mammals.\nb.) Some mammals are not warm-blooded.\nc.) Not all warm-blooded animals are mammals.\nd.) Warm-bloodedness is a characteristic of mammals.");
        answers.add("Answer: d.) Warm-bloodedness is a characteristic of mammals.");
        explanations.add("Explanation: The conclusion is that warm-bloodedness is a defining feature of mammals, based on the initial premise.");

        questions.add("Statement: \"A recent study shows that students who study at night perform better on exams. Therefore, studying at night is more effective than studying during the day.\"\nWhat is the conclusion?\n\na.) Students should study at night.\nb.) Daytime studying is ineffective.\nc.) Night study is better for all students.\nd.) Exam performance is solely dependent on study time.");
        answers.add("Answer: a.) Students should study at night.");
        explanations.add("Explanation: The conclusion drawn is that students ought to study at night to achieve better exam performance.");

        questions.add("The argument states: \"Since the new policy has been implemented, employee productivity has increased. Therefore, the new policy is effective.\"\nWhat conclusion can be made?\n\na.) Employee productivity will always improve with new policies.\nb.) The new policy is the reason for increased productivity.\nc.) All policies lead to increased productivity.\nd.) Increased productivity is the only measure of policy effectiveness.");
        answers.add("Answer: b.) The new policy is the reason for increased productivity.");
        explanations.add("Explanation: The conclusion is that the increase in employee productivity is a result of the new policy being implemented.");

        questions.add("Statement: \"Every time I eat chocolate, I feel happy. Therefore, chocolate makes me happy.\"\nWhat is the conclusion?\n\na.) Eating chocolate is always enjoyable.\nb.) Chocolate causes happiness.\nc.) Other foods do not make me happy.\nd.) Happiness is a result of eating.");
        answers.add("Answer: b.) Chocolate causes happiness.");
        explanations.add("Explanation: The conclusion is that chocolate consumption is linked to the feeling of happiness.");

        questions.add("The observation is made: \"Most birds can fly. Therefore, if an animal can fly, it must be a bird.\"\nWhat conclusion can be drawn?\n\na.) All flying animals are birds.\nb.) Some birds cannot fly.\nc.) Flying is a unique ability of birds.\nd.) Not all animals that can fly are birds.");
        answers.add("Answer: d.) Not all animals that can fly are birds.");
        explanations.add("Explanation: The conclusion is that the ability to fly does not exclusively belong to birds, as there are other flying creatures (like bats and insects).");

        questions.add("Choose the word that is most closely related to the word **'sun'**.\n\na.) Moon\nb.) Star\nc.) Planet\nd.) Light");
        answers.add("Answer: b.) Star.");
        explanations.add("Explanation: The word 'star' is most closely related to 'sun,' as the sun is a star at the center of our solar system.");

        questions.add("Choose the word that is most closely related to the word **'car'**.\n\na.) Vehicle\nb.) Bicycle\nc.) Airplane\nd.) Road");
        answers.add("Answer: a.) Vehicle.");
        explanations.add("Explanation: The word 'vehicle' is most closely related to 'car,' as a car is a type of vehicle used for transportation.");

        questions.add("Assess the statement: If John attends the meeting, then Sarah will too. John did not attend the meeting. Therefore, Sarah did not attend.\n\na.) True\nb.) False\nc.) Cannot be determined\nd.) Possibly true");
        answers.add("Answer: c.) Cannot be determined.");
        explanations.add("Explanation: The premise does not confirm what Sarah would do if John didn't attend, so the conclusion cannot be determined.");

        questions.add("Analyze this argument: If the sun is shining, we will go to the park. The sun is shining. Therefore, we will go to the park.\n\na.) True\nb.) False\nc.) Uncertain\nd.) Possibly true");
        answers.add("Answer: a.) True.");
        explanations.add("Explanation: The premise guarantees that if the sun is shining, the park visit will happen, making the conclusion true.");

        questions.add("Evaluate this reasoning: Some students like math. All students like learning. Therefore, all students like math.\n\na.) True\nb.) False\nc.) Could be true\nd.) Uncertain");
        answers.add("Answer: b.) False.");
        explanations.add("Explanation: The premise that some students like math does not support the conclusion that all students do.");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n3. The film's **somber** tone made the audience reflective.\n\na.) Joyful\nb.) Gloomy\nc.) Exciting\nd.) Humorous");
        answers.add("Answer: b.) Gloomy.");
        explanations.add("Explanation: 'Somber' means dark or dull in tone, which is similar to 'gloomy.'");

        questions.add("Choose the word that is most closely related to the word **'computer'**.\n\na.) Keyboard\nb.) Phone\nc.) Monitor\nd.) Technology");
        answers.add("Answer: d.) Technology.");
        explanations.add("Explanation: The word 'technology' is most closely related to 'computer,' as computers are a fundamental aspect of modern technology.");

        questions.add("Choose the word that is most closely related to the word **'doctor'**.\n\na.) Patient\nb.) Surgeon\nc.) Hospital\nd.) Medicine");
        answers.add("Answer: b.) Surgeon.");
        explanations.add("Explanation: The word 'surgeon' is most closely related to 'doctor,' as a surgeon is a specialized type of doctor who performs surgeries.");


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
