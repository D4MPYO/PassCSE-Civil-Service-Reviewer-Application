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

public class Reviewer_Sub_Clerical extends AppCompatActivity {

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
        setContentView(R.layout.reviewer_sub_clerical);

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

        questions.add("Which of the following words is spelled correctly?\n\na.) Acommodate\nb.) Accommodate\nc.) Acomadate\nd.) Acomodate");
        answers.add("Answer: b.) Accommodate.");
        explanations.add("Explanation: 'Accommodate' is the correct spelling, with two 'c's and two 'm's.");

        questions.add("Which word is spelled correctly?\n\na.) Neccessary\nb.) Necessary\nc.) Necesary\nd.) Necassary");
        answers.add("Answer: b.) Necessary.");
        explanations.add("Explanation: The correct spelling is 'Necessary,' with one 'c' and two 's's.");

        questions.add("Choose the correctly spelled word.\n\na.) Definately\nb.) Defenetly\nc.) Definitely\nd.) Definatly");
        answers.add("Answer: c.) Definitely.");
        explanations.add("Explanation: 'Definitely' is the correct spelling. It contains the root word 'finite'.");

        questions.add("Identify the correctly spelled word.\n\na.) Seperate\nb.) Seperete\nc.) Separate\nd.) Separet");
        answers.add("Answer: c.) Separate.");
        explanations.add("Explanation: 'Separate' is spelled with 'a' in both parts of the word.");

        questions.add("Fill in the blank with the best option: The manager _____ the new policies to ensure everyone understood them.\n\na.) elucidated\nb.) obscured\nc.) disregarded\nd.) avoided");
        answers.add("Answer: a.) elucidated.");
        explanations.add("Explanation: 'Elucidated' means explained or made clear, which fits the context of clarifying policies.");

        questions.add("Choose the correct word: The speaker's presentation was _____ and failed to engage the audience.\n\na.) dynamic\nb.) monotonous\nc.) engaging\nd.) thrilling");
        answers.add("Answer: b.) monotonous.");
        explanations.add("Explanation: 'Monotonous' means dull and repetitive, fitting the description of a disengaging presentation.");

        questions.add("Select the word that best completes the sentence: The scientist's discovery was _____, changing the way we understand the human brain.\n\na.) negligible\nb.) groundbreaking\nc.) irrelevant\nd.) inconsequential");
        answers.add("Answer: b.) groundbreaking.");
        explanations.add("Explanation: 'Groundbreaking' means highly innovative or new, which fits the context of a major discovery.");

        questions.add("Fill in the blank: The athlete's _____ dedication to training helped her win the gold medal.\n\na.) indifferent\nb.) persistent\nc.) apathetic\nd.) negligent");
        answers.add("Answer: b.) persistent.");
        explanations.add("Explanation: 'Persistent' means showing determination and endurance, which fits the description of an athlete's dedication.");

        questions.add("Choose the best word to fill the blank: The novel's plot was _____, keeping readers on the edge of their seats.\n\na.) predictable\nb.) gripping\nc.) dull\nd.) flat");
        answers.add("Answer: b.) gripping.");
        explanations.add("Explanation: 'Gripping' means highly engaging or exciting, which matches the context of a thrilling plot.");

        questions.add("Which word is spelled correctly?\n\na.) Publically\nb.) Publicly\nc.) Publikly\nd.) Pubicly");
        answers.add("Answer: b.) Publicly.");
        explanations.add("Explanation: 'Publicly' is the correct spelling. The word does not have an extra 'a'.");

        questions.add("Choose the correct word to fill the blank: She was _____ in her belief that honesty is the best policy.\n\na.) resolute\nb.) relaxant\nc.) reclining\nd.) reactive");
        answers.add("Answer: a.) resolute.");
        explanations.add("Explanation: 'Resolute' means firm or determined, which fits the context.");

        questions.add("Select the best word to fill the blank: The student _____ to finish the assignment on time.\n\na.) struggled\nb.) rejoiced\nc.) regaled\nd.) relinquished");
        answers.add("Answer: a.) struggled.");
        explanations.add("Explanation: 'Struggled' fits the context of facing difficulty in finishing the assignment.");

        questions.add("Choose the correct word to complete the sentence: The ______ noise from the construction site made it hard to concentrate.\n\na.) clamorous\nb.) serene\nc.) peaceful\nd.) placid");
        answers.add("Answer: a.) clamorous.");
        explanations.add("Explanation: 'Clamorous' means loud and noisy, which fits the context of a construction site.");

        questions.add("Fill in the blank: The scientist's ______ discovery revolutionized the way we understand the universe.\n\na.) novel\nb.) antiquated\nc.) obsolete\nd.) moribund");
        answers.add("Answer: a.) novel.");
        explanations.add("Explanation: 'Novel' means new and original, which fits the context of a groundbreaking discovery.");

        questions.add("Select the correct word: The _____ manager made sure that all tasks were completed efficiently.\n\na.) diligent\nb.) negligent\nc.) inactive\nd.) indifferent");
        answers.add("Answer: a.) diligent.");
        explanations.add("Explanation: 'Diligent' means hardworking and attentive, which is suitable for a manager ensuring efficiency.");

        questions.add("Choose the word that best fits the sentence: The artist's work was ______, appealing to both critics and the general public.\n\na.) ubiquitous\nb.) divisive\nc.) acclaimed\nd.) obscure");
        answers.add("Answer: c.) acclaimed.");
        explanations.add("Explanation: 'Acclaimed' means praised or highly regarded, fitting the context of wide appeal.");

        questions.add("Identify the best word for the blank: The proposal was ______ because it lacked sufficient detail.\n\na.) ambiguous\nb.) clear\nc.) explicit\nd.) transparent");
        answers.add("Answer: a.) ambiguous.");
        explanations.add("Explanation: 'Ambiguous' means unclear or open to interpretation, which fits the context of lacking detail.");

        questions.add("Choose the correct word: The athlete's performance was ______, setting a new record in the competition.\n\na.) lackluster\nb.) stellar\nc.) unimpressive\nd.) mediocre");
        answers.add("Answer: b.) stellar.");
        explanations.add("Explanation: 'Stellar' means outstanding or exceptional, fitting the context of setting a new record.");

        questions.add("Complete the sentence with the best word: The new employee was praised for his ______ to learn and adapt quickly.\n\na.) inertia\nb.) reluctance\nc.) eagerness\nd.) lethargy");
        answers.add("Answer: c.) eagerness.");
        explanations.add("Explanation: 'Eagerness' means enthusiasm or willingness to learn, which fits the context of being praised.");

        questions.add("Choose the word that is spelled correctly:\n\na.) Embarras\nb.) Embarrass\nc.) Embarass\nd.) Embbarass");
        answers.add("Answer: b.) Embarrass.");
        explanations.add("Explanation: The correct spelling is 'Embarrass,' with two 'r's and two 's's.");

        questions.add("Which of the following is spelled correctly?\n\na.) Apparent\nb.) Aparent\nc.) Apperent\nd.) Aparant");
        answers.add("Answer: a.) Apparent.");
        explanations.add("Explanation: 'Apparent' is the correct spelling, meaning clearly visible or understood.");

        questions.add("Identify the correctly spelled word:\n\na.) Conscientous\nb.) Conscientious\nc.) Conscintious\nd.) Consientious");
        answers.add("Answer: b.) Conscientious.");
        explanations.add("Explanation: 'Conscientious' means being diligent and careful, and is spelled with 'sci' in the middle.");

        questions.add("Which is the correct spelling?\n\na.) Recomendation\nb.) Recommendation\nc.) Recomendation\nd.) Recomandation");
        answers.add("Answer: b.) Recommendation.");
        explanations.add("Explanation: 'Recommendation' has two 'm's, following the root word 'recommend'.");

        questions.add("Choose the correctly spelled word:\n\na.) Perserverance\nb.) Perseverence\nc.) Perseverance\nd.) Perserverance");
        answers.add("Answer: c.) Perseverance.");
        explanations.add("Explanation: 'Perseverance' is correctly spelled with 'sever' in the middle and ends with 'ance.'");

        questions.add("Select the correct word to complete the sentence: The professor's lecture was filled with _____ examples, making it easier to understand.\n\na.) opaque\nb.) lucid\nc.) cryptic\nd.) perplexing");
        answers.add("Answer: b.) lucid.");
        explanations.add("Explanation: 'Lucid' means clear and easy to understand, which fits the context of examples making the lecture easier to follow.");

        questions.add("Identify the sentence with correct subject-verb agreement.\n\na.) The committee are discussing the new policy.\nb.) The committee is discussing the new policy.\nc.) The committee have discussing the new policy.\nd.) The committee was discussing the new policy.");
        answers.add("Answer: b.) The committee is discussing the new policy.");
        explanations.add("Explanation: 'The committee' is a collective noun, so it takes a singular verb ('is').");

        questions.add("Choose the sentence with the correct pronoun usage.\n\na.) Each of the students have their own opinion.\nb.) Each of the students has their own opinion.\nc.) Each of the students has their own opinions.\nd.) Each of the students have their own opinions.");
        answers.add("Answer: b.) Each of the students has their own opinion.");
        explanations.add("Explanation: 'Each' is singular, so it takes 'has' and 'opinion' must match in number.");

        questions.add("Select the sentence with correct punctuation.\n\na.) She said, 'I don't like ice cream'.\nb.) She said, I don't like ice cream.\nc.) She said, 'I don't like ice cream.'\nd.) She said, 'I don't like ice cream'.'");
        answers.add("Answer: c.) She said, 'I don't like ice cream.'");
        explanations.add("Explanation: In American English, the period goes inside the quotation marks.");

        questions.add("Identify the sentence with correct pronoun usage:\n\na.) Everyone should bring their own lunch.\nb.) Everyone should bring his or her own lunch.\nc.) Everyone should bring its own lunch.\nd.) Everyone should bring their's own lunch.");
        answers.add("Answer: b.) Everyone should bring his or her own lunch.");
        explanations.add("Explanation: 'Everyone' is singular, so it requires the singular pronoun 'his or her.'");

        questions.add("Choose the correct sentence:\n\na.) Neither the teacher nor the students has been notified.\nb.) Neither the teacher nor the students have been notified.\nc.) Neither the teacher or the students has been notified.\nd.) Neither the teacher nor the students was notified.");
        answers.add("Answer: b.) Neither the teacher nor the students have been notified.");
        explanations.add("Explanation: 'Neither... nor' follows the rule that the verb agrees with the noun closest to it, in this case, 'students.'");

        questions.add("Select the sentence with the correct verb form:\n\na.) If I was you, I would take the opportunity.\nb.) If I were you, I would take the opportunity.\nc.) If I am you, I would take the opportunity.\nd.) If I will be you, I would take the opportunity.");
        answers.add("Answer: b.) If I were you, I would take the opportunity.");
        explanations.add("Explanation: The phrase 'If I were you' is a common use of the subjunctive mood, used to talk about hypothetical situations.");

        questions.add("Which sentence uses parallel structure?\n\na.) She enjoys reading books, to travel, and cooking.\nb.) She enjoys reading, traveling, and cooking.\nc.) She enjoys to read, traveling, and to cook.\nd.) She enjoys reading books, traveling, and to cook.");
        answers.add("Answer: b.) She enjoys reading, traveling, and cooking.");
        explanations.add("Explanation: Parallel structure means all items in a list should have the same grammatical form, as in this sentence.");

        questions.add("Choose the sentence with correct punctuation:\n\na.) After the movie, we went to dinner.\nb.) After the movie we went, to dinner.\nc.) After the movie we went to dinner.\nd.) After, the movie we went to dinner.");
        answers.add("Answer: a.) After the movie, we went to dinner.");
        explanations.add("Explanation: The comma is correctly placed after the introductory phrase, 'After the movie.'");

        questions.add("Choose the word that best fits the sentence: The CEO's decision to expand the company was both _____ and risky.\n\na.) prudent\nb.) audacious\nc.) cautious\nd.) timid");
        answers.add("Answer: b.) audacious.");
        explanations.add("Explanation: 'Audacious' means bold or daring, which fits the context of taking a risky decision.");

        questions.add("Identify the word that best completes the sentence: The student's _____ remarks earned him praise from the professor.\n\na.) facetious\nb.) insightful\nc.) flippant\nd.) oblivious");
        answers.add("Answer: b.) insightful.");
        explanations.add("Explanation: 'Insightful' means showing deep understanding or perception, which is appropriate for remarks praised by a professor.");

        questions.add("Select the word that fits the sentence: The author's writing style is _____, making the novel both engaging and challenging.\n\na.) simplistic\nb.) intricate\nc.) superficial\nd.) mundane");
        answers.add("Answer: b.) intricate.");
        explanations.add("Explanation: 'Intricate' means complex and detailed, which suits the description of an engaging and challenging novel.");

        questions.add("Fill in the blank: The detective's _____ investigation uncovered new evidence that changed the course of the case.\n\na.) cursory\nb.) meticulous\nc.) hasty\nd.) superficial");
        answers.add("Answer: b.) meticulous.");
        explanations.add("Explanation: 'Meticulous' means showing great attention to detail, which fits the context of uncovering new evidence.");

        questions.add("Choose the correct word: The new policy was _____ by many employees as unfair and unjust.\n\na.) embraced\nb.) lauded\nc.) derided\nd.) ignored");
        answers.add("Answer: c.) derided.");
        explanations.add("Explanation: 'Derided' means criticized or ridiculed, fitting the context of employees finding the policy unfair.");

        questions.add("Which sentence has the correct verb tense?\n\na.) By the time I arrived, she left.\nb.) By the time I arrive, she left.\nc.) By the time I arrive, she has left.\nd.) By the time I arrived, she had left.");
        answers.add("Answer: d.) By the time I arrived, she had left.");
        explanations.add("Explanation: 'Had left' is the correct past perfect tense, which is used to show the earlier of two past actions.");

        questions.add("Select the sentence with correct parallel structure.\n\na.) I like swimming, hiking, and to run.\nb.) I like to swim, hike, and running.\nc.) I like swimming, hiking, and running.\nd.) I like swimming, to hike, and running.");
        answers.add("Answer: c.) I like swimming, hiking, and running.");
        explanations.add("Explanation: Parallel structure means all the elements in a series should be in the same grammatical form.");

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
