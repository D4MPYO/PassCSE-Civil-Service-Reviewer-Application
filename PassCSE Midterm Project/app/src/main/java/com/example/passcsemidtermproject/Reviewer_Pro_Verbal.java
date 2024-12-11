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

public class Reviewer_Pro_Verbal extends AppCompatActivity {

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
        setContentView(R.layout.reviewer_pro_verbal);

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
        questions.add("Identify the part of the sentence that contains an error.\nThe committee has decided to postpone the meeting to next week due to the chairman's absence.\nA. The committee has decided\nB. to postpone the meeting\nC. to next week\nD. due to the chairman's absence");
        answers.add("Answer: C. to next week.");
        explanations.add("Explanation: \"The correct phrase should be 'until next week' instead of 'to next week.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nEach of the students are responsible for completing their assignments on time.\nA. Each of the students\nB. are responsible\nC. for completing\nD. their assignments on time");
        answers.add("Answer: B. are responsible.");
        explanations.add("Explanation: \"Each is singular, so it should be 'is responsible.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nNeither the manager nor the employees was aware of the changes in the schedule.\nA. Neither the manager\nB. nor the employees\nC. was aware\nD. of the changes in the schedule");
        answers.add("Answer: C. was aware.");
        explanations.add("Explanation: \"Employees is plural, so it should be 'were aware.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nThe data was analyzed thoroughly by the research team.\nA. The data\nB. was analyzed\nC. thoroughly\nD. by the research team");
        answers.add("Answer: B. was analyzed.");
        explanations.add("Explanation: \"Data is plural, so it should be 'were analyzed.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nThe teacher, along with her students, are planning a field trip.\nA. The teacher\nB. along with her students\nC. are planning\nD. a field trip");
        answers.add("Answer: C. are planning.");
        explanations.add("Explanation: \"The subject 'teacher' is singular, so it should be 'is planning.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nThe company has been operating in this industry since twenty years.\nA. The company\nB. has been operating\nC. in this industry\nD. since twenty years");
        answers.add("Answer: D. since twenty years.");
        explanations.add("Explanation: \"The correct phrase should be 'for twenty years' instead of 'since twenty years.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nIf I was you, I would take the job offer.\nA. If I was you\nB. I would take\nC. the job offer\nD. No error");
        answers.add("Answer: A. If I was you.");
        explanations.add("Explanation: \"The correct phrase should be 'If I were you' instead of 'If I was you.'\"");

        questions.add("Identify the part of the sentence that contains an error.\nShe is one of those people who always tries to help others.\nA. She is\nB. one of those people\nC. who always tries\nD. to help others");
        answers.add("Answer: C. who always tries.");
        explanations.add("Explanation: \"The correct phrase should be 'who always try' because 'people' is plural.\"");

        questions.add("Identify the part of the sentence that contains an error.\nThe book, which was published last year, have received many awards.\nA. The book\nB. which was published last year\nC. have received\nD. many awards");
        answers.add("Answer: C. have received.");
        explanations.add("Explanation: \"The correct verb should be 'has received' because 'book' is singular.\"");

        questions.add("Identify the part of the sentence that contains an error.\nThe team are playing well this season.\nA. The team\nB. are playing\nC. well\nD. this season");
        answers.add("Answer: B. are playing.");
        explanations.add("Explanation: \"The correct verb should be 'is playing' because 'team' is considered a singular collective noun.\"");

// Vocabulary Questions

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe manager's decision was **prudent** considering the circumstances.\nA. Reckless\nB. Wise\nC. Hasty\nD. Impulsive");
        answers.add("Answer: B. Wise.");
        explanations.add("Explanation: \"Prudent means acting with or showing care and thought for the future, which is similar in meaning to 'wise.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe scientist's discovery was a **significant** breakthrough in the field.\nA. Minor\nB. Insignificant\nC. Important\nD. Negligible");
        answers.add("Answer: C. Important.");
        explanations.add("Explanation: \"Significant means sufficiently great or important to be worthy of attention, which is similar in meaning to 'important.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe artist's work was **exquisite**, admired by all who saw it.\nA. Ordinary\nB. Beautiful\nC. Common\nD. Unremarkable");
        answers.add("Answer: B. Beautiful.");
        explanations.add("Explanation: \"Exquisite means extremely beautiful and delicate, which is similar in meaning to 'beautiful.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe athlete's performance was **commendable**, earning him a standing ovation.\nA. Disappointing\nB. Praiseworthy\nC. Mediocre\nD. Unimpressive");
        answers.add("Answer: B. Praiseworthy.");
        explanations.add("Explanation: \"Commendable means deserving praise, which is similar in meaning to 'praiseworthy.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe politician's speech was **eloquent**, captivating the audience.\nA. Inarticulate\nB. Persuasive\nC. Confusing\nD. Boring");
        answers.add("Answer: B. Persuasive.");
        explanations.add("Explanation: \"Eloquent means fluent or persuasive in speaking or writing, which is similar in meaning to 'persuasive.'\"");

        questions.add("Read the passage:\n\"The Amazon rainforest is home to a vast array of wildlife and plants. Many species found in this region are not found anywhere else on Earth. Deforestation poses a significant threat to this unique ecosystem, as it destroys habitats and endangers the species that live there.\"\nWhat is the main idea of the passage?\n\na.) The Amazon rainforest has a rich diversity of life.\nb.) Deforestation only affects certain species.\nc.) All ecosystems are equally important.\nd.) Wildlife can adapt to deforestation.");
        answers.add("Answer: a.) The Amazon rainforest has a rich diversity of life.");
        explanations.add("Explanation: The passage highlights the unique wildlife and plant species in the Amazon rainforest, emphasizing its biodiversity.");

        questions.add("Consider the following excerpt:\n\"With the rise of technology, communication has transformed dramatically. People can now connect instantly across the globe, breaking down barriers that once existed. However, this convenience also leads to a decline in face-to-face interactions.\"\nWhat can be inferred from this passage?\n\na.) Technology improves all types of communication.\nb.) Instant communication is always beneficial.\nc.) People prefer face-to-face communication.\nd.) Technology has both positive and negative effects on communication.");
        answers.add("Answer: d.) Technology has both positive and negative effects on communication.");
        explanations.add("Explanation: The passage acknowledges the benefits of technology in communication while also noting the downside of decreased in-person interactions.");

        questions.add("Read the following text:\n\"The discovery of penicillin revolutionized medicine. Before its introduction, bacterial infections often led to severe complications or death. With penicillin, doctors gained a powerful tool to treat infections effectively and save countless lives.\"\nWhat is the significance of penicillin according to the passage?\n\na.) It was the first antibiotic ever discovered.\nb.) It has no impact on modern medicine.\nc.) It greatly reduced mortality rates from bacterial infections.\nd.) It is no longer used in medicine today.");
        answers.add("Answer: c.) It greatly reduced mortality rates from bacterial infections.");
        explanations.add("Explanation: The passage states that penicillin transformed medicine by effectively treating bacterial infections, thereby saving many lives.");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\n\"The author's style is very **eclectic**, incorporating various influences from different genres.\"\n\na.) Uniform\nb.) Diverse\nc.) Predictable\nd.) Conventional");
        answers.add("Answer: b.) Diverse.");
        explanations.add("Explanation: 'Eclectic' means deriving ideas, style, or taste from a broad and diverse range of sources, which aligns with the meaning of 'diverse.'");

        questions.add("Choose the word that best fits the following sentence:\n\"Her **meticulous** attention to detail ensured that every aspect of the project was perfect.\"\n\na.) Careless\nb.) Thorough\nc.) Hasty\nd.) Incomplete");
        answers.add("Answer: b.) Thorough.");
        explanations.add("Explanation: 'Meticulous' means showing great attention to detail; being very careful and precise, which relates to being thorough.");

        questions.add("Select the word that is the opposite in meaning to the underlined word.\n\"The atmosphere in the meeting was quite **tense**, as everyone awaited the announcement.\"\n\na.) Relaxed\nb.) Stressed\nc.) Anxious\nd.) Nervous");
        answers.add("Answer: a.) Relaxed.");
        explanations.add("Explanation: 'Tense' indicates a state of mental or emotional strain, while 'relaxed' represents a state of being free from tension and anxiety, making them antonyms.");

        questions.add("Which word is closest in meaning to the underlined word?\n\"Her **resilience** in the face of adversity inspired everyone around her.\"\n\na.) Weakness\nb.) Toughness\nc.) Fragility\nd.) Indifference");
        answers.add("Answer: b.) Toughness.");
        explanations.add("Explanation: 'Resilience' refers to the capacity to recover quickly from difficulties; toughness embodies the strength to withstand challenging situations.");

        questions.add("Choose the correct word to complete the sentence:\n\"His **apathy** towards the project was evident, as he rarely contributed to discussions.\"\n\na.) Enthusiasm\nb.) Indifference\nc.) Motivation\nd.) Interest");
        answers.add("Answer: b.) Indifference.");
        explanations.add("Explanation: 'Apathy' refers to a lack of interest, enthusiasm, or concern, which aligns closely with 'indifference.'");

        questions.add("Consider the following paragraph:\n\"In recent years, renewable energy sources like solar and wind power have gained popularity as alternatives to fossil fuels. These sources are not only sustainable but also contribute to reducing carbon emissions, helping combat climate change.\"\nWhat is the purpose of the paragraph?\n\na.) To discourage the use of fossil fuels.\nb.) To promote renewable energy sources.\nc.) To explain the process of energy generation.\nd.) To compare different types of fossil fuels.");
        answers.add("Answer: b.) To promote renewable energy sources.");
        explanations.add("Explanation: The paragraph discusses the benefits of renewable energy sources and their role in combating climate change, indicating a promotion of their use.");

        questions.add("Read the passage:\n\"The Great Wall of China is one of the most iconic structures in the world. Built over several centuries, it stretches thousands of miles and serves as a testament to the ingenuity and determination of the Chinese people. It has become a symbol of national pride and attracts millions of tourists each year.\"\nWhat does the passage imply about the Great Wall of China?\n\na.) It is primarily a tourist attraction today.\nb.) It was built for defensive purposes only.\nc.) It represents the cultural heritage of China.\nd.) It is in danger of being forgotten.");
        answers.add("Answer: c.) It represents the cultural heritage of China.");
        explanations.add("Explanation: The passage highlights the historical significance of the Great Wall and its role as a symbol of national pride, indicating its importance in Chinese culture and heritage.");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nhe scientist's hypothesis was **tenable** and supported by evidence.\nA. Indefensible\nB. Weak\nC. Defensible\nD. Unfounded");
        answers.add("Answer: C. Defensible.");
        explanations.add("Explanation: \"Tenable means able to be maintained or defended against attack or objection, which is similar in meaning to 'defensible.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe student's explanation was **lucid** and easy to understand.\nA. Confusing\nB. Clear\nC. Vague\nD. Ambiguous");
        answers.add("Answer: B. Clear.");
        explanations.add("Explanation: \"Lucid means expressed clearly; easy to understand, which is similar in meaning to 'clear.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe CEO's decision was **audacious** surprising everyone in the company.\nA. Timid\nB. Bold\nC. Cautious\nD. Predictable");
        answers.add("Answer: B. Bold.");
        explanations.add("Explanation: \"Audacious means showing a willingness to take surprisingly bold risks, which is similar in meaning to 'bold.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe new policy was **stringent**, imposing strict regulations on employees.\nA. Lenient\nB. Harsh\nC. Severe\nD. Rigid");
        answers.add("Answer: C. Severe.");
        explanations.add("Explanation: \"Stringent means strict, precise, and exacting, which is similar in meaning to 'severe.'\"");

        questions.add("Choose the word that is most similar in meaning to the underlined word.\nThe teacher's instructions were **explicit**, leaving no room for confusion.\nA. Vague\nB. Clear\nC. Ambiguous\nD. Unclear");
        answers.add("Answer: B. Clear.");
        explanations.add("Explanation: \"Explicit means stated clearly and in detail, leaving no room for confusion or doubt, which is similar in meaning to 'clear.'\"");

        questions.add("Identify the error in the following sentence:\n\"She enjoys to read historical fiction, but she doesn’t like science fiction.\"\n\na.) enjoys to read\nb.) historical fiction\nc.) but she doesn’t like\n d.) science fiction");
        answers.add("Answer: a.) enjoys to read.");
        explanations.add("Explanation: The correct phrase is 'enjoys reading' instead of 'enjoys to read.'");

        questions.add("Which of the following sentences is grammatically correct?\n\na.) Neither of the solutions work for the problem.\nb.) Each of the participants have submitted their forms.\nc.) All of the students has completed their assignments.\nd.) None of the answers is correct.");
        answers.add("Answer: d.) None of the answers is correct.");
        explanations.add("Explanation: All provided sentences contain grammatical errors.");

        questions.add("Read the passage:\n\"The rapid advancement of technology has transformed our daily lives in countless ways. From communication to transportation, innovations have made tasks easier and more efficient. However, the increased reliance on technology also raises concerns about privacy and security.\"\nWhat is the author's main point?\n\na.) Technology has no impact on daily life.\nb.) Innovations in technology only bring positive changes.\nc.) The advancement of technology has both benefits and drawbacks.\nd.) Technology will eventually replace all manual tasks.");
        answers.add("Answer: c.) The advancement of technology has both benefits and drawbacks.");
        explanations.add("Explanation: The passage discusses both the positive and negative aspects of technological advancement.");

        questions.add("Consider the following excerpt:\n\"Despite the initial challenges, the community came together to support the local shelter. Fundraising events were organized, and volunteers dedicated their time to help those in need. The success of these efforts brought a sense of unity among residents.\"\nWhat can be inferred from this passage?\n\na.) The community is indifferent to the shelter's needs.\nb.) The residents are united in their efforts to support the shelter.\nc.) Fundraising events were unsuccessful.\nd.) Volunteers did not contribute significantly.");
        answers.add("Answer: b.) The residents are united in their efforts to support the shelter.");
        explanations.add("Explanation: The passage indicates that the community worked together and felt a sense of unity in supporting the shelter.");

        questions.add("Read the following text:\n\"Climate change poses significant challenges to ecosystems around the world. Rising temperatures, changing precipitation patterns, and increased frequency of extreme weather events disrupt the delicate balance of nature. It is imperative that we take action to mitigate these effects to preserve our planet for future generations.\"\nWhat does the passage suggest is necessary to address climate change?\n\na.) Ignoring the issue\nb.) Taking action to mitigate the effects\nc.) Continuing current practices\n d.) Relying solely on technology");
        answers.add("Answer: b.) Taking action to mitigate the effects.");
        explanations.add("Explanation: The passage emphasizes the importance of taking action to address the challenges posed by climate change.");

        questions.add("Read the passage:\n\"Throughout history, art has been a reflection of society's values, beliefs, and struggles. From ancient sculptures to modern digital creations, each form of art tells a story about the culture and time in which it was created. Understanding these works can provide valuable insights into the human experience.\"\nWhat is the significance of art according to the passage?\n\na.) Art has no connection to society.\nb.) Art is only important in modern times.\nc.) Art reflects societal values and provides insights into the human experience.\nd.) Understanding art is unnecessary.");
        answers.add("Answer: c.) Art reflects societal values and provides insights into the human experience.");
        explanations.add("Explanation: The passage highlights how art is a reflection of society and offers insights into cultural and historical contexts.");


        questions.add("Choose the correct form of the verb:\n\"Each of the students ___ responsible for their own assignments.\"\n\na.) are\nb.) is\nc.) were\nd.) be");
        answers.add("Answer: b.) is.");
        explanations.add("Explanation: 'Each' is a singular subject, so the correct verb form is 'is.'");

        questions.add("Select the correct sentence:\n\na.) Neither the teacher nor the students was ready for the exam.\nb.) Neither the teacher nor the students were ready for the exam.\nc.) Neither the teacher or the students were ready for the exam.\nd.) Neither the teacher and the students was ready for the exam.");
        answers.add("Answer: b.) Neither the teacher nor the students were ready for the exam.");
        explanations.add("Explanation: When using 'neither...nor,' the verb agrees with the nearest subject, which is plural in this case, so 'were' is correct.");

        questions.add("Identify the sentence with correct punctuation:\n\na.) The committee has decided to postpone the meeting, it will be held next week.\nb.) The committee has decided to postpone the meeting; it will be held next week.\nc.) The committee, has decided to postpone the meeting, it will be held next week.\nd.) The committee has decided to postpone the meeting it will be held next week.");
        answers.add("Answer: b.) The committee has decided to postpone the meeting; it will be held next week.");
        explanations.add("Explanation: The semicolon correctly separates two independent clauses.");

        questions.add("Choose the word that best completes the sentence:\n\"The scientist's findings were ___ and led to further research.\"\n\na.) inconclusive\nb.) definitive\nc.) ambiguous\nd.) speculative");
        answers.add("Answer: b.) definitive.");
        explanations.add("Explanation: 'Definitive' means conclusive and authoritative, which aligns with findings that lead to further research.");

        questions.add("Select the word that is closest in meaning to the underlined word:\n\"The novel was so **captivating** that I couldn't put it down.\"\n\na.) Boring\nb.) Enchanting\nc.) Confusing\nd.) Lengthy");
        answers.add("Answer: b.) Enchanting.");
        explanations.add("Explanation: 'Captivating' means attracting and holding interest, similar to 'enchanting.'");

        questions.add("Choose the word that best fits the sentence:\n\"The manager was known for his **benevolence**, always helping those in need.\"\n\na.) Cruelty\nb.) Generosity\nc.) Indifference\nd.) Hostility");
        answers.add("Answer: b.) Generosity.");
        explanations.add("Explanation: 'Benevolence' refers to the quality of being well-meaning and kind, closely related to 'generosity.'");

        questions.add("Which word is the opposite of the underlined word?\n\"His behavior was **gregarious**, always seeking the company of others.\"\n\na.) Sociable\nb.) Reserved\nc.) Outgoing\nd.) Friendly");
        answers.add("Answer: b.) Reserved.");
        explanations.add("Explanation: 'Gregarious' refers to being sociable, while 'reserved' indicates a tendency to keep to oneself, making them antonyms.");

        questions.add("Choose the correct synonym for the underlined word:\n\"Her **ardent** support for the cause inspired many others.\"\n\na.) Indifferent\nb.) Passionate\nc.) Apathetic\nd.) Disinterested");
        answers.add("Answer: b.) Passionate.");
        explanations.add("Explanation: 'Ardent' means enthusiastic or passionate, making 'passionate' the closest synonym.");

        questions.add("Identify the sentence that needs correction:\n\"The team are planning to launch their new product next month, and they is excited about the possibilities.\"\n\na.) The team is planning to launch their new product next month, and they are excited about the possibilities.\nb.) The team are planning to launch their new product next month, and they are exciting about the possibilities.\nc.) The team is planning to launch their new product next month, and they was excited about the possibilities.\nd.) The team are planning to launch their new product next month, and they is exciting about the possibilities.");
        answers.add("Answer: a.) The team is planning to launch their new product next month, and they are excited about the possibilities.");
        explanations.add("Explanation: The subject 'team' is a collective noun treated as singular, so 'is' should be used instead of 'are.'");

        questions.add("Choose the correctly punctuated sentence:\n\"I love reading novels mystery and fantasy.\"\n\na.) I love reading novels mystery, and fantasy.\nb.) I love reading novels, mystery, and fantasy.\nc.) I love reading, novels, mystery and fantasy.\nd.) I love reading novels, mystery and, fantasy.");
        answers.add("Answer: b.) I love reading novels, mystery, and fantasy.");
        explanations.add("Explanation: The sentence needs commas to separate items in a list.");





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
