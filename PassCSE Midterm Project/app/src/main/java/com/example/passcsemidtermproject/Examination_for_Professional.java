package com.example.passcsemidtermproject;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Examination_for_Professional extends AppCompatActivity {

    private TextView questionTextView, questionCounterTextView, timerTextView;
    private Button nextButton, previousButton;
    private Button choice1, choice2, choice3, choice4;
    private ImageView backButton;

    private int currentQuestionIndex = 0;
    private ArrayList<String> questions;
    private ArrayList<ArrayList<String>> choices;
    private ArrayList<String> correctAnswers;
    private int score = 0;
    private int totalQuestions;
    private final int maxQuestions = 120;          // CHANGE THE  TOTAL QUESTION BASE ON HOW MANY YOU WANT // CHANGE THE  TOTAL QUESTION BASE ON HOW MANY YOU WANT
    private ArrayList<String> userAnswers;
    private CountDownTimer countDownTimer;
    private static final int TIMER_DURATION_MINUTES = 60;    // CHANGE THE MAX TIME LIMIT IN TAKING EXAM  // CHANGE THE MAX TIME LIMIT IN TAKING EXAM
    private long timeLeftInMillis = TIMER_DURATION_MINUTES * 60 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.examination_for_professional);

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(v -> showExitConfirmationDialog());

        initUI();

        // Initialize lists for questions, choices, and correct answers
        setupQuestionsAndChoices();

        // Shuffle both questions and choices
        shuffleQuestionsAndChoices();

        totalQuestions = Math.min(maxQuestions, questions.size());

        // Initialize userAnswers with empty strings
        userAnswers = new ArrayList<>(Collections.nCopies(totalQuestions, ""));

        // Start the countdown timer
        startTimer();

        // Display the first question and its choices
        updateQuestion();

        // Set up listeners for navigation and back buttons
        setupButtonListeners();
    }

    private void initUI() {
        questionTextView = findViewById(R.id.text_question);
        questionCounterTextView = findViewById(R.id.cpt_question);
        timerTextView = findViewById(R.id.Timer);
        nextButton = findViewById(R.id.btn_next);
        previousButton = findViewById(R.id.btn_previous);
        choice1 = findViewById(R.id.LetterA);
        choice2 = findViewById(R.id.LetterB);
        choice3 = findViewById(R.id.LetterC);
        choice4 = findViewById(R.id.LetterD);
        backButton = findViewById(R.id.backButton);
    }

    private void setupQuestionsAndChoices() {
        questions = new ArrayList<>();
        choices = new ArrayList<>();
        correctAnswers = new ArrayList<>();

        questions.add("What is 432 + 198?");
        choices.add(new ArrayList<>(List.of("630", "620", "610", "640")));
        correctAnswers.add("630");

        questions.add("What is 15% of 200?");
        choices.add(new ArrayList<>(List.of("25", "30", "20", "15")));
        correctAnswers.add("30");

        questions.add("A recipe calls for 4 cups of water for every 2 cups of rice. What is the ratio of water to rice?");
        choices.add(new ArrayList<>(List.of("1:2", "2:1", "4:2", "3:1")));
        correctAnswers.add("2:1");

        questions.add("If a car travels 240 miles on 8 gallons of gas, what is the MPG?");
        choices.add(new ArrayList<>(List.of("25 MPG", "30 MPG", "20 MPG", "35 MPG")));
        correctAnswers.add("30 MPG");

        questions.add("What is 120 divided by 4?");
        choices.add(new ArrayList<>(List.of("30", "28", "32", "25")));
        correctAnswers.add("30");

        questions.add("If a shirt costs P40 and is on sale for 25% off, what is the sale price?");
        choices.add(new ArrayList<>(List.of("30", "25", "35", "32")));
        correctAnswers.add("30");

        questions.add("What is the difference between 900 and 567?");
        choices.add(new ArrayList<>(List.of("333", "322", "353", "342")));
        correctAnswers.add("333");

        questions.add("If a product costs $120 and the sales tax is 8%, what is the total cost?");
        choices.add(new ArrayList<>(List.of("129.60", "126.40", "130.00", "125.00")));
        correctAnswers.add("129.60");

        questions.add("What is the ratio of 12 to 48?");
        choices.add(new ArrayList<>(List.of("1:4", "2:4", "1:3", "2:5")));
        correctAnswers.add("1:4");

        questions.add("If a student scores 80 out of 100 on a test, what is the percentage score?");
        choices.add(new ArrayList<>(List.of("75%", "80%", "85%", "90%")));
        correctAnswers.add("80%");

        questions.add("A store is offering a 15% discount on an item that costs P60. What is the discount amount?");
        choices.add(new ArrayList<>(List.of("8", "9", "10", "12")));
        correctAnswers.add("9");

        questions.add("If 3 apples cost 1.50, how much do 12 apples cost?");
        choices.add(new ArrayList<>(List.of("5.00", "6.00", "4.00", "4.50")));
        correctAnswers.add("6.00");

        questions.add("What is 25% of 80?");
        choices.add(new ArrayList<>(List.of("15", "20", "25", "30")));
        correctAnswers.add("20");

        questions.add("A car can travel 300 miles on a full tank of gas. If the tank holds 15 gallons, what is the MPG?");
        choices.add(new ArrayList<>(List.of("20 MPG", "25 MPG", "30 MPG", "35 MPG")));
        correctAnswers.add("20 MPG");

        questions.add("What is the product of 7 and 6?");
        choices.add(new ArrayList<>(List.of("42", "48", "36", "40")));
        correctAnswers.add("42");

        questions.add("If a bicycle costs 150 and is on sale for 10% off, what is the sale price?");
        choices.add(new ArrayList<>(List.of("140", "135", "145", "150")));
        correctAnswers.add("135");

        questions.add("What is the sum of 250 and 375?");
        choices.add(new ArrayList<>(List.of("625", "600", "550", "650")));
        correctAnswers.add("625");

        questions.add("If 60% of a number is 30, what is the number?");
        choices.add(new ArrayList<>(List.of("50", "60", "70", "80")));
        correctAnswers.add("50");

        questions.add("A recipe requires 2 tablespoons of sugar for every 5 cups of flour. What is the ratio of sugar to flour?");
        choices.add(new ArrayList<>(List.of("2:5", "1:5", "5:2", "2:10")));
        correctAnswers.add("2:5");

        questions.add("If a person earns 1,200 monthly and saves 20%, how much do they save?");
        choices.add(new ArrayList<>(List.of("200", "220", "240", "260")));
        correctAnswers.add("240");

        questions.add("What is 18 × 12?");
        choices.add(new ArrayList<>(List.of("216", "224", "228", "210")));
        correctAnswers.add("216");

        questions.add("A car travels 150 miles on 5 gallons of gas. How many miles can it travel on 10 gallons?");
        choices.add(new ArrayList<>(List.of("250 miles", "300 miles", "350 miles", "400 miles")));
        correctAnswers.add("300 miles");

        questions.add("What is 90 divided by 3?");
        choices.add(new ArrayList<>(List.of("25", "30", "20", "15")));
        correctAnswers.add("30");

        questions.add("If a jacket costs 80 and is discounted by 20, what is the sale price?");
        choices.add(new ArrayList<>(List.of("50", "60", "70", "80")));
        correctAnswers.add("60");

        questions.add("What is the ratio of 20 to 50?");
        choices.add(new ArrayList<>(List.of("2:5", "3:5", "4:5", "5:2")));
        correctAnswers.add("2:5");

        questions.add("If a student scored 72 out of 90 on a test, what percentage did they achieve?");
        choices.add(new ArrayList<>(List.of("75%", "80%", "85%", "70%")));
        correctAnswers.add("80%");

        questions.add("A bag of flour costs 3.25. How much do 4 bags cost?");
        choices.add(new ArrayList<>(List.of("12.00", "13.00", "14.00", "15.00")));
        correctAnswers.add("13.00");

        questions.add("If an item is priced at 150 and has a 20% discount, what is the sale price?");
        choices.add(new ArrayList<>(List.of("120", "130", "110", "100")));
        correctAnswers.add("120");

        questions.add("What is the sum of 567 and 434?");
        choices.add(new ArrayList<>(List.of("1001", "1101", "900", "800")));
        correctAnswers.add("1001");

        questions.add("If a car uses 12 gallons of gas for 300 miles, how many gallons are needed for 600 miles?");
        choices.add(new ArrayList<>(List.of("18 gallons", "20 gallons", "24 gallons", "22 gallons")));
        correctAnswers.add("24 gallons");

        questions.add("What is 7% of 200?");
        choices.add(new ArrayList<>(List.of("14", "12", "16", "18")));
        correctAnswers.add("14");

        questions.add("If a student scored 85 out of 100, what is their percentage score?");
        choices.add(new ArrayList<>(List.of("80%", "85%", "90%", "75%")));
        correctAnswers.add("85%");

        questions.add("A store sells 3 notebooks for 6. How much would 10 notebooks cost?");
        choices.add(new ArrayList<>(List.of("15", "20", "18", "12")));
        correctAnswers.add("20");

        questions.add("What is the difference between 1,000 and 345?");
        choices.add(new ArrayList<>(List.of("655", "660", "670", "675")));
        correctAnswers.add("655");

        questions.add("If a dress costs 120 and is on sale for 30% off, what is the sale price?");
        choices.add(new ArrayList<>(List.of("84", "90", "100", "110")));
        correctAnswers.add("84");

        questions.add("What is 40% of 250?");
        choices.add(new ArrayList<>(List.of("80", "100", "90", "70")));
        correctAnswers.add("100");

        questions.add("If a train travels 180 miles in 3 hours, what is its speed in miles per hour?");
        choices.add(new ArrayList<>(List.of("60 MPH", "55 MPH", "50 MPH", "65 MPH")));
        correctAnswers.add("60 MPH");

        questions.add("If a pizza is cut into 8 equal slices and 3 are eaten, what fraction of the pizza remains?");
        choices.add(new ArrayList<>(List.of("5/8", "3/8", "2/8", "4/8")));
        correctAnswers.add("5/8");

        questions.add("What is 50 divided by 5?");
        choices.add(new ArrayList<>(List.of("5", "10", "15", "20")));
        correctAnswers.add("10");

        questions.add("If a computer costs 800 and is discounted by 15%, what is the sale price?");
        choices.add(new ArrayList<>(List.of("680", "720", "750", "800")));
        correctAnswers.add("680");

        questions.add("What is the sum of 1,234 and 567?");
        choices.add(new ArrayList<>(List.of("1,801", "1,801", "1,900", "1,700")));
        correctAnswers.add("1,801");

        questions.add("If a pair of shoes costs 90 and is on sale for 20% off, what is the discount amount?");
        choices.add(new ArrayList<>(List.of("15", "18", "20", "25")));
        correctAnswers.add("18");

        questions.add("A car can travel 400 miles on 10 gallons of gas. What is the MPG?");
        choices.add(new ArrayList<>(List.of("35 MPG", "30 MPG", "40 MPG", "45 MPG")));
        correctAnswers.add("40 MPG");

        questions.add("What is 2/5 of 100?");
        choices.add(new ArrayList<>(List.of("20", "30", "40", "50")));
        correctAnswers.add("40");

        questions.add("If a watch costs 250 and the sales tax is 10%, what is the total price?");
        choices.add(new ArrayList<>(List.of("275", "280", "300", "290")));
        correctAnswers.add("275");

        questions.add("What is the ratio of 15 to 45?");
        choices.add(new ArrayList<>(List.of("1:2", "1:3", "2:3", "3:1")));
        correctAnswers.add("1:3");

        questions.add("If 30% of a number is 12, what is the number?");
        choices.add(new ArrayList<>(List.of("30", "36", "40", "50")));
        correctAnswers.add("40");

        questions.add("A box contains 6 red balls and 4 blue balls. What is the ratio of red balls to total balls?");
        choices.add(new ArrayList<>(List.of("6:10", "4:10", "3:5", "2:5")));
        correctAnswers.add("3:5");

        questions.add("What is 200 minus 78?");
        choices.add(new ArrayList<>(List.of("122", "120", "125", "130")));
        correctAnswers.add("122");

        questions.add("If a product is priced at 200 and has a 25% discount, what is the final price?");
        choices.add(new ArrayList<>(List.of("150", "175", "180", "200")));
        correctAnswers.add("150");


        questions.add("2, 4, 8, 16, ___");
        choices.add(new ArrayList<>(List.of("24", "32", "36", "40")));
        correctAnswers.add("32");

        questions.add("5, 10, 15, 20, ___");
        choices.add(new ArrayList<>(List.of("25", "30", "35", "40")));
        correctAnswers.add("25");

        questions.add("3, 6, 12, 24, ___");
        choices.add(new ArrayList<>(List.of("36", "48", "60", "72")));
        correctAnswers.add("48");

        questions.add("1, 1, 2, 3, 5, ___");
        choices.add(new ArrayList<>(List.of("7", "8", "9", "10")));
        correctAnswers.add("8");

        questions.add("10, 20, 30, 40, ___");
        choices.add(new ArrayList<>(List.of("45", "50", "55", "60")));
        correctAnswers.add("50");

        questions.add("1, 4, 9, 16, ___");
        choices.add(new ArrayList<>(List.of("20", "25", "30", "35")));
        correctAnswers.add("25");

        questions.add("7, 14, 28, 56, ___");
        choices.add(new ArrayList<>(List.of("112", "120", "124", "128")));
        correctAnswers.add("112");

        questions.add("100, 90, 80, 70, ___");
        choices.add(new ArrayList<>(List.of("50", "60", "65", "70")));
        correctAnswers.add("60");

        questions.add("2, 5, 10, 17, ___");
        choices.add(new ArrayList<>(List.of("24", "30", "35", "40")));
        correctAnswers.add("26");

        questions.add("1, 2, 4, 7, ___");
        choices.add(new ArrayList<>(List.of("10", "11", "12", "13")));
        correctAnswers.add("11");

        questions.add("12, 15, 18, 21, ___");
        choices.add(new ArrayList<>(List.of("22", "24", "25", "27")));
        correctAnswers.add("24");

        questions.add("2, 3, 5, 7, 11, ___");
        choices.add(new ArrayList<>(List.of("12", "13", "14", "15")));
        correctAnswers.add("13");

        questions.add("20, 30, 40, 50, ___");
        choices.add(new ArrayList<>(List.of("55", "60", "65", "70")));
        correctAnswers.add("60");

        questions.add("9, 18, 36, 72, ___");
        choices.add(new ArrayList<>(List.of("144", "150", "180", "200")));
        correctAnswers.add("144");

        questions.add("5, 10, 20, 40, ___");
        choices.add(new ArrayList<>(List.of("60", "70", "80", "100")));
        correctAnswers.add("80");

        questions.add("8, 16, 32, 64, ___");
        choices.add(new ArrayList<>(List.of("128", "120", "140", "150")));
        correctAnswers.add("128");

        questions.add("15, 30, 45, 60, ___");
        choices.add(new ArrayList<>(List.of("70", "75", "80", "90")));
        correctAnswers.add("75");

        questions.add("4, 8, 16, 32, ___");
        choices.add(new ArrayList<>(List.of("48", "64", "80", "96")));
        correctAnswers.add("64");

        questions.add("3, 7, 13, 21, ___");
        choices.add(new ArrayList<>(List.of("29", "31", "33", "35")));
        correctAnswers.add("31");

        questions.add("1, 3, 6, 10, ___");
        choices.add(new ArrayList<>(List.of("12", "13", "14", "15")));
        correctAnswers.add("15");


// VERBAL
        questions.add("A pretty penny means _____________.");
        choices.add(new ArrayList<>(List.of("If something costs a pretty penny, it is very expensive.", "If something costs a pretty penny, it is very inexpensive.", "If something costs a pretty penny, it is very precious.", "If something costs a pretty penny, it is very unimportant.")));
        correctAnswers.add("If something costs a pretty penny, it is very expensive.");

        questions.add("Come out of your shell means _____________.");
        choices.add(new ArrayList<>(List.of("If someone comes in of their shell, they never stop being shy and withdrawn and become more unfriendly and sociable.", "If someone comes out of their shell, they stop being shy and withdrawn and become more friendly and sociable.", "If someone comes out of their shell, they never stop being shy and withdrawn and become more friendly and sociable.", "If someone comes in of their shell, they stop being shy and withdrawn and become more unfriendly and unsociable.")));
        correctAnswers.add("If someone comes out of their shell, they stop being shy and withdrawn and become more friendly and sociable.");

        questions.add("Derring-do means _________.");
        choices.add(new ArrayList<>(List.of("If a person shows derring-do, they show unwillingness.", "If a person shows derring-do, they show shyness.", "If a person shows derring-do, they show great courage.", "If a person shows derring-do, they show pettiness.")));
        correctAnswers.add("If a person shows derring-do, they show great courage.");

        questions.add("Hot water means ___________.");
        choices.add(new ArrayList<>(List.of("If you get into hot water, you get into trouble.", "If you get into hot water, you get a lucky day.", "If you get into hot water, you get a bad day.", "If you get into hot water, you get a burn skin.")));
        correctAnswers.add("If you get into hot water, you get into trouble.");

        questions.add("Keep abreast means __________.");
        choices.add(new ArrayList<>(List.of("If you keep abreast of things, you stay uninformed about developments.", "If you keep abreast of things, you stay informed about developments.", "If you keep abreast of things, you stay informed about things.", "If you keep abreast of things, you stay informed about life.")));
        correctAnswers.add("If you keep abreast of things, you stay informed about developments.");

        questions.add("There are times when you must decide and 'take the bull by the horns.'");
        choices.add(new ArrayList<>(List.of("make the right decision", "make the wrong decision", "make a bold decision", "make a final decision")));
        correctAnswers.add("make a bold decision.");

        questions.add("He 'leads a dog's life' really because his freedom is always curtailed.");
        choices.add(new ArrayList<>(List.of("never knows what to do", "sometimes does something wrong", "never goes out", "never does what he wants")));
        correctAnswers.add("never does what he wants.");

        questions.add("No-one ever mentions him because he's regarded as the 'black sheep of the family.'");
        choices.add(new ArrayList<>(List.of("the one with a sense of humour", "the one with a bad reputation", "the one who is always late", "the one who never washes")));
        correctAnswers.add("the one with a bad reputation.");

        questions.add("I shouldn't go outside without a raincoat because 'it's raining cats and dogs.'");
        choices.add(new ArrayList<>(List.of("it's just started to rain", "it's going to rain", "it's raining very heavily", "it's raining a little")));
        correctAnswers.add("it's raining very heavily.");

        questions.add("You shouldn't sign there I think he's about 'to make a monkey out of you.'");
        choices.add(new ArrayList<>(List.of("to make a fool of you", "to make you lose money", "to make you feel stupid", "to make you lose interest")));
        correctAnswers.add("to make a fool of you.");

        questions.add("Sila ay nagdadamayan sa hirap at ginhawa. Sila ay totoong 'naghihiramang suklay'.");
        choices.add(new ArrayList<>(List.of("mag asawa", "magkapatid", "magkaibigan", "magka anak")));
        correctAnswers.add("magkaibigan");

        questions.add("There is no PANACEA that will solve our financial difficulty.");
        choices.add(new ArrayList<>(List.of("cure-all", "answer", "paradox", "criteria")));
        correctAnswers.add("cure-all");

        questions.add("DEBACLE");
        choices.add(new ArrayList<>(List.of("introduction", "conflict", "disaster", "assault")));
        correctAnswers.add("disaster");

        questions.add("LAGASAW");
        choices.add(new ArrayList<>(List.of("tunog ng pag-yak", "tunog ng hangin", "tunog ng alon", "tunog ng busina")));
        correctAnswers.add("tunog ng alon");

        questions.add("KABAL");
        choices.add(new ArrayList<>(List.of("sepal", "kaban", "unawa", "agimat")));
        correctAnswers.add("kaban");

        questions.add("HAGINIT");
        choices.add(new ArrayList<>(List.of("hagikhik", "hambalang", "handusay", "harurot")));
        correctAnswers.add("harurot");

        questions.add("DALAHIKAN");
        choices.add(new ArrayList<>(List.of("daungan", "istambayan", "palaruan", "dagat")));
        correctAnswers.add("daungan");

        questions.add("FORBEARANCE");
        choices.add(new ArrayList<>(List.of("attitude", "stubbornness", "generosity", "patience")));
        correctAnswers.add("patience");

        questions.add("ALLEGIANCE");
        choices.add(new ArrayList<>(List.of("loyalty", "solemnity", "intelligence", "sincerity")));
        correctAnswers.add("loyalty");

        questions.add("GRUNGY");
        choices.add(new ArrayList<>(List.of("fashionable", "brittle", "dirty", "warm")));
        correctAnswers.add("dirty");

        questions.add("PROSCRIBE");
        choices.add(new ArrayList<>(List.of("record", "promote", "forbid", "interpret")));
        correctAnswers.add("forbid");

        questions.add("HULAS");
        choices.add(new ArrayList<>(List.of("litaw", "lusaw", "hilaw", "durog")));
        correctAnswers.add("litaw");

        questions.add("DALAHIRA");
        choices.add(new ArrayList<>(List.of("matulungin", "tsismosa", "pustura", "madalasin")));
        correctAnswers.add("matulungin");

        questions.add("BARAL");
        choices.add(new ArrayList<>(List.of("metal", "trangka", "santo", "sulat")));
        correctAnswers.add("trangka");

        questions.add("DULANG");
        choices.add(new ArrayList<>(List.of("mahabang hapag", "uri ng isda", "malungkot na drama", "makasaysayang tula")));
        correctAnswers.add("mahabang hapag");

        questions.add("GULA-GULANIT");
        choices.add(new ArrayList<>(List.of("lukot-lukot", "punit-punit", "iba-ibang kulay", "buhol-buhol")));
        correctAnswers.add("iba-ibang kulay");

        questions.add("LAGAK");
        choices.add(new ArrayList<>(List.of("tuyot", "tungga", "pigtal", "deposito")));
        correctAnswers.add("deposito");

        questions.add("DALAHIKAN");
        choices.add(new ArrayList<>(List.of("daungan", "istambayan", "palaruan", "dagat")));
        correctAnswers.add("daungan");

        questions.add("CANTANKEROUS");
        choices.add(new ArrayList<>(List.of("ill-advised", "offensive", "greasy", "quarrelsome")));
        correctAnswers.add("quarrelsome");

        questions.add("PERAMBULATE");
        choices.add(new ArrayList<>(List.of("move back and forth", "walk", "disbelieve", "investigate")));
        correctAnswers.add("walk");

// GENERAL

        questions.add("What is the national language of the Philippines according to the 1987 Phil Constitution article XIV section 6?");
        choices.add(new ArrayList<>(List.of("Pilipino", "Tagalog", "Filipino", "English", "Both B & C")));
        correctAnswers.add("Filipino");

        questions.add("What do you call the introductory part of the Constitution?");
        choices.add(new ArrayList<>(List.of("Preface", "Amendments", "Preamble", "Bill of Rights")));
        correctAnswers.add("Preamble");

        questions.add("What form of government does the Philippines adopt?");
        choices.add(new ArrayList<>(List.of("Republican", "Democratic", "Neither a nor b", "Both a and b")));
        correctAnswers.add("Both a and b");

        questions.add("Who among the following may issue a warrant of arrest or a search warrant?");
        choices.add(new ArrayList<>(List.of("A senator", "A judge", "A congressman", "The President")));
        correctAnswers.add("A judge");

        questions.add("A foreigner may acquire Filipino citizenship through:");
        choices.add(new ArrayList<>(List.of("Naturalization", "Extradition", "Rebirth", "Visa application")));
        correctAnswers.add("Naturalization");

        questions.add("What is regarded by the State as a \"primary social economic force?\"");
        choices.add(new ArrayList<>(List.of("Education", "Trade", "Labor", "Commerce")));
        correctAnswers.add("Labor");

        questions.add("According to Article III, Section 15 of the Constitution, the writ of habeas corpus may be suspended in times of rebellion or what?");
        choices.add(new ArrayList<>(List.of("Martial law", "War", "Terrorism", "Invasion")));
        correctAnswers.add("Martial law");

        questions.add("The Lower Chamber of the Congress of the Philippines is known by what name?");
        choices.add(new ArrayList<>(List.of("Senate", "Congressional Lower Chamber", "National Assembly", "House of Representatives")));
        correctAnswers.add("House of Representatives");

        questions.add("A Member of either house of Congress may be expelled by their fellow Members. For a Member to be expelled, how much of the total number of Members of a house must concur with the expulsion?");
        choices.add(new ArrayList<>(List.of("Two-thirds", "Majority", "Three-fourths", "Nine-tenths")));
        correctAnswers.add("Two-thirds");

        questions.add("If a President wishes to veto a bill, he/she must communicate it within a certain span of time; otherwise, the bill will become a law. How long is this span of time?");
        choices.add(new ArrayList<>(List.of("3 weeks", "48 days", "60 days", "30 days")));
        correctAnswers.add("30 days");

        questions.add("At present, how many percent of the population of the Philippines are aliens?");
        choices.add(new ArrayList<>(List.of("30%", "25%", "40%", "50%", "70%")));
        correctAnswers.add("25%");

        questions.add("What project of the DENR includes the protection of industrial pollution of our environment?");
        choices.add(new ArrayList<>(List.of("Bantay Kalikasan", "Bantay Ilog", "Bantay Dagat", "Ecological Watch", "Solid Waste Management")));
        correctAnswers.add("Bantay Kalikasan");

        questions.add("What government agency does the status of government employee in the free voluntary services belong to?");
        choices.add(new ArrayList<>(List.of("Secretary", "Regional", "Municipal", "National", "Barangay")));
        correctAnswers.add("National");

        questions.add("Which is not a ground for impeachment of the President, Vice-President, Ombudsman, and Senator?");
        choices.add(new ArrayList<>(List.of("Graft and corruption", "Sexual harassment", "Grave abuse of authority", "Against the family if the child scolded by the parents", "Other crimes")));
        correctAnswers.add("Against the family if the child scolded by the parents");

        questions.add("What is a ground for impeachment of the President, Vice-President, Ombudsman, and Senator?");
        choices.add(new ArrayList<>(List.of("Sexual harassment", "Heinous crime", "Grave abuse of authority", "Graft and corruption", "Culpable violation of the Constitution")));
        correctAnswers.add("Culpable violation of the Constitution");

// LOGIC

        questions.add("The history book has more pages than the poetry book, but fewer pages than the math book. The math book has more pages than the science book but fewer pages than the English book. The poetry book has the fewest pages. If the first two statements are true, the third is:");
        choices.add(new ArrayList<>(List.of("true", "false", "uncertain", "none of the above")));
        correctAnswers.add("true");

        questions.add("Subscribing to Cable T.V. is a luxury. All luxuries are needless expenditures. Having a cellular phone is not a luxury. Dining in a Five-Star hotel is a needless expenditure. CONCLUSION:");
        choices.add(new ArrayList<>(List.of("Having a cellular phone is not a needless expenditure", "Subscribing to Cable TV is a needless expenditure", "Subscribing to cable TV is not a needless expenditure", "Dining in a Five-Star hotel is a luxury")));
        correctAnswers.add("Having a cellular phone is not a needless expenditure");

        questions.add("A factory worker has five children. No one else in the factory has five children.");
        choices.add(new ArrayList<>(List.of("All workers in the factory have five children each.", "Everybody in the factory has children.", "Some of the factory workers have more than five children.", "Only one worker in the factory has exactly five children.")));
        correctAnswers.add("Only one worker in the factory has exactly five children.");

        questions.add("Television convinces viewers that the likelihood of their becoming the victim of a violent crime is extremely high; at the same time, by its very nature, TV persuades viewers to passively accept whatever happens to them.");
        choices.add(new ArrayList<>(List.of("TV viewing promotes criminal behaviour.", "TV viewers are most likely to be victimized than others.", "People should not watch TV.", "TV promotes a feeling of helpless vulnerability in viewers.")));
        correctAnswers.add("TV promotes a feeling of helpless vulnerability in viewers.");

        questions.add("The government is soon going to introduce a bill which would permit the instituting of private universities under very strict directions.");
        choices.add(new ArrayList<>(List.of("We have some private universities in our country even now.", "The demand for more universities is being stepped up.", "Such directions can also be issued without informing the Parliament.", "The government gives directions to establish anything in the private sector.")));
        correctAnswers.add("The demand for more universities is being stepped up.");

        questions.add("All the tulips in Zoe’s garden are white. All the pansies in Zoe’s garden are yellow. All the flowers in Zoe’s garden are either white or yellow. If the first two statements are true, the third statement is:");
        choices.add(new ArrayList<>(List.of("true", "false", "uncertain", "not applicable")));
        correctAnswers.add("true.");

        questions.add("Tom puts on his socks before he puts on his shoes. He puts on his shirt before he puts on his jacket. Tom puts on his shoes before he puts on his shirt. If the first two statements are true, the third statement is:");
        choices.add(new ArrayList<>(List.of("true", "false", "uncertain", "none of the above")));
        correctAnswers.add("false.");

        questions.add("Three pencils cost the same as two erasers. Four erasers cost the same as one ruler. Pencils are more expensive than rulers. If the first two statements are true, the third statement is:");
        choices.add(new ArrayList<>(List.of("true", "false", "uncertain", "all of the above")));
        correctAnswers.add("false.");

        questions.add("A jar of jelly beans contains more red beans than green. There are more yellow beans than red. The jar contains fewer yellow jelly beans than green ones. If the first two statements are true, the third statement is:");
        choices.add(new ArrayList<>(List.of("true", "false", "uncertain", "none of the above")));
        correctAnswers.add("false.");

        questions.add("A toothpick is useful. Useful things are valuable. A toothpick is valuable. If the first two statements are true, the third statement is:");
        choices.add(new ArrayList<>(List.of("true", "false", "uncertain", "none of the above")));
        correctAnswers.add("true.");

        questions.add("What is the proper arrangement of the sentences?");
        choices.add(new ArrayList<>(List.of("CBAD", "CBDA", "CDAB", "CDBA")));
        correctAnswers.add("CBDA");

        questions.add("What is the proper arrangement of the sentences?");
        choices.add(new ArrayList<>(List.of("BDAC", "BADC", "BACD", "BDCA")));
        correctAnswers.add("BACD");

        questions.add("What is the proper arrangement of the sentences?");
        choices.add(new ArrayList<>(List.of("ABCD", "ADBC", "ACBD", "ADCB")));
        correctAnswers.add("ADBC");

        questions.add("What is the proper arrangement of the sentences?");
        choices.add(new ArrayList<>(List.of("DCBA", "DACB", "DABC", "DCAB")));
        correctAnswers.add("DABC");

        questions.add("What is the proper arrangement of the sentences?");
        choices.add(new ArrayList<>(List.of("BDAC", "BCDA", "BADC", "BCAD")));
        correctAnswers.add("BCDA");

        questions.add("Which word is most similar to “abundant”?");
        choices.add(new ArrayList<>(List.of("Scarce", "Plentiful", "Rare", "Limited")));
        correctAnswers.add("Plentiful");

        questions.add("Choose the word that is most opposite in meaning to “diligent”.");
        choices.add(new ArrayList<>(List.of("Industrious", "Lazy", "Hardworking", "Careful")));
        correctAnswers.add("Lazy");

        questions.add("Which word is most similar to “innovative”?");
        choices.add(new ArrayList<>(List.of("Traditional", "Creative", "Conventional", "Old-fashioned")));
        correctAnswers.add("Creative");

        questions.add("Which word is most similar to “benevolent”?");
        choices.add(new ArrayList<>(List.of("Malevolent", "Kind", "Cruel", "Indifferent")));
        correctAnswers.add("Kind");

        questions.add("Which word is most opposite in meaning to “optimistic”?");
        choices.add(new ArrayList<>(List.of("Hopeful", "Pessimistic", "Positive", "Confident")));
        correctAnswers.add("Pessimistic");

        questions.add("Which word is most similar to “gregarious”?");
        choices.add(new ArrayList<>(List.of("Shy", "Sociable", "Reserved", "Introverted")));
        correctAnswers.add("Sociable");

        questions.add("Choose the word that is most opposite in meaning to “frugal”.");
        choices.add(new ArrayList<>(List.of("Thrifty", "Economical", "Wasteful", "Prudent")));
        correctAnswers.add("Wasteful");

        questions.add("Identify the assumption in the statement: “If it rains, the picnic will be canceled.”");
        choices.add(new ArrayList<>(List.of("The picnic is planned for a day when it might rain.", "The picnic will be held indoors.", "The picnic will be canceled regardless of the weather.", "The picnic will be rescheduled.")));
        correctAnswers.add("The picnic is planned for a day when it might rain.");

        questions.add("What conclusion can be drawn from the statement: “All students in the class passed the exam.”?");
        choices.add(new ArrayList<>(List.of("Some students in the class failed the exam.", "No student in the class failed the exam.", "Only a few students passed the exam.", "The exam was very difficult.")));
        correctAnswers.add("No student in the class failed the exam.");

        questions.add("Identify the assumption in the statement: “Eating healthy foods leads to better health.”");
        choices.add(new ArrayList<>(List.of("Unhealthy foods do not affect health.", "Healthy foods are expensive.", "There is a direct relationship between diet and health.", "Exercise is not important for health.")));
        correctAnswers.add("There is a direct relationship between diet and health.");

        questions.add("Identify the assumption in the statement: “If you study hard, you will pass the exam.”");
        choices.add(new ArrayList<>(List.of("The exam is easy.", "Studying hard guarantees success.", "The exam is difficult.", "Passing the exam is not important.")));
        correctAnswers.add("Studying hard guarantees success.");

        questions.add("Identify the conclusion in the statement: “Since it is raining, the match will be postponed.”");
        choices.add(new ArrayList<>(List.of("It is raining.", "The match will be postponed.", "The match will be canceled.", "The match will continue.")));
        correctAnswers.add("The match will be postponed.");

        questions.add("Identify the assumption in the statement: “If you exercise regularly, you will stay healthy.”");
        choices.add(new ArrayList<>(List.of("Regular exercise is not beneficial.", "Health is not influenced by exercise.", "Exercise has a positive impact on health.", "Staying healthy requires no exercise.")));
        correctAnswers.add("Exercise has a positive impact on health.");

        questions.add("What conclusion can be drawn from the statement: “All employees must wear ID badges.”?");
        choices.add(new ArrayList<>(List.of("Some employees do not wear ID badges.", "No employee wears an ID badge.", "Every employee wears an ID badge.", "Only a few employees wear ID badges.")));
        correctAnswers.add("Every employee wears an ID badge.");

        questions.add("Identify the assumption in the statement: “Using public transport reduces traffic congestion.”");
        choices.add(new ArrayList<>(List.of("Public transport is expensive.", "Traffic congestion is not a problem.", "Public transport is widely used.", "Public transport can replace private vehicles.")));
        correctAnswers.add("Public transport can replace private vehicles.");

        questions.add("If all roses are flowers and some flowers fade quickly, which of the following is true?");
        choices.add(new ArrayList<>(List.of("All roses fade quickly.", "Some roses fade quickly.", "No roses fade quickly.", "Some flowers do not fade quickly.")));
        correctAnswers.add("Some flowers do not fade quickly.");

        questions.add("If A is taller than B, and B is taller than C, which of the following is true?");
        choices.add(new ArrayList<>(List.of("A is shorter than C.", "C is taller than A.", "A is taller than C.", "B is taller than A.")));
        correctAnswers.add("A is taller than C.");

        questions.add("If it is raining, then the ground is wet. The ground is not wet. What can be concluded?");
        choices.add(new ArrayList<>(List.of("It is raining.", "It is not raining.", "The ground is dry.", "It is snowing.")));
        correctAnswers.add("It is not raining.");

        questions.add("If all squares are rectangles and all rectangles are quadrilaterals, which of the following is true?");
        choices.add(new ArrayList<>(List.of("All squares are quadrilaterals.", "Some squares are not quadrilaterals.", "No squares are quadrilaterals.", "Some rectangles are not quadrilaterals.")));
        correctAnswers.add("All squares are quadrilaterals.");

        questions.add("If some fruits are apples and all apples are sweet, which of the following is true?");
        choices.add(new ArrayList<>(List.of("All fruits are sweet.", "Some fruits are sweet.", "No fruits are sweet.", "Some apples are not sweet.")));
        correctAnswers.add("Some fruits are sweet.");

        questions.add("If all birds can fly and penguins are birds, which of the following is true?");
        choices.add(new ArrayList<>(List.of("Penguins can fly.", "Penguins cannot fly.", "Some birds cannot fly.", "All birds cannot fly.")));
        correctAnswers.add("Penguins can fly.");

        questions.add("If some doctors are scientists and all scientists are researchers, which of the following is true?");
        choices.add(new ArrayList<>(List.of("All doctors are researchers.", "Some doctors are researchers.", "No doctors are researchers.", "Some researchers are not doctors.")));
        correctAnswers.add("Some doctors are researchers.");

        questions.add("A survey shows that 60% of respondents prefer coffee over tea. If 300 people were surveyed, how many prefer coffee?");
        choices.add(new ArrayList<>(List.of("120", "150", "180", "200")));
        correctAnswers.add("180");

        questions.add("In a class of 40 students, 25% received an A on the test. How many students received an A?");
        choices.add(new ArrayList<>(List.of("8", "10", "12", "15")));
        correctAnswers.add("10");

        questions.add("A company’s revenue increased from PHP 1,000,000 to PHP 1,200,000. What is the percentage increase?");
        choices.add(new ArrayList<>(List.of("20%", "25%", "15%", "10%")));
        correctAnswers.add("20%");

        questions.add("A pie chart shows that 40% of a company’s budget is spent on salaries, 30% on marketing, 20% on research, and 10% on other expenses. If the total budget is PHP 500,000, how much is spent on marketing?");
        choices.add(new ArrayList<>(List.of("PHP 150,000", "PHP 200,000", "PHP 100,000", "PHP 50,000")));
        correctAnswers.add("PHP 150,000");

        questions.add("A bar graph shows the sales of a company over five years. If the sales in the first year were PHP 200,000 and increased by PHP 50,000 each subsequent year, what were the sales in the fifth year?");
        choices.add(new ArrayList<>(List.of("PHP 250,000", "PHP 300,000", "PHP 400,000", "PHP 450,000")));
        correctAnswers.add("PHP 450,000");

        questions.add("A pie chart shows the distribution of a budget: 25% on salaries, 35% on marketing, 20% on research, and 20% on other expenses. If the total budget is PHP 800,000, how much is allocated to research?");
        choices.add(new ArrayList<>(List.of("PHP 160,000", "PHP 200,000", "PHP 240,000", "PHP 280,000")));
        correctAnswers.add("PHP 160,000");


    }

    // Shuffle questions and their corresponding choices
    private void shuffleQuestionsAndChoices() {
        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < questions.size(); i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        ArrayList<String> shuffledQuestions = new ArrayList<>();
        ArrayList<ArrayList<String>> shuffledChoices = new ArrayList<>();
        ArrayList<String> shuffledCorrectAnswers = new ArrayList<>();

        for (int index : indices) {
            shuffledQuestions.add(questions.get(index));
            ArrayList<String> currentChoices = new ArrayList<>(choices.get(index));
            Collections.shuffle(currentChoices);  // Shuffle the choices for each question
            shuffledChoices.add(currentChoices);
            shuffledCorrectAnswers.add(correctAnswers.get(index));
        }

        questions = shuffledQuestions;
        choices = shuffledChoices;
        correctAnswers = shuffledCorrectAnswers;
    }

    // Start the countdown timer
    private void startTimer() {
        countDownTimer = new CountDownTimer(timeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMillis = millisUntilFinished;
                updateTimer();
            }

            @Override
            public void onFinish() {
                submitExamAutomatically();
            }
        }.start();
    }

    private void updateTimer() {
        int hours = (int) (timeLeftInMillis / 1000) / 3600;
        int minutes = (int) (timeLeftInMillis / 1000) % 3600 / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;

        String timeLeftFormatted = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        timerTextView.setText("Time Left: " + timeLeftFormatted);
    }

    private void updateQuestion() {
        questionTextView.setText(questions.get(currentQuestionIndex));
        ArrayList<String> currentChoices = choices.get(currentQuestionIndex);

        choice1.setText(currentChoices.get(0));
        choice2.setText(currentChoices.get(1));
        choice3.setText(currentChoices.get(2));
        choice4.setText(currentChoices.get(3));

        questionCounterTextView.setText((currentQuestionIndex + 1) + " out of " + totalQuestions);

        nextButton.setText(currentQuestionIndex == totalQuestions - 1 ? "Submit" : "Next");

        resetButtonStates();
        restoreUserAnswer();
    }

    private void setupButtonListeners() {
        nextButton.setOnClickListener(v -> {
            saveUserAnswer();
            if (currentQuestionIndex < totalQuestions - 1) {
                currentQuestionIndex++;
                updateQuestion();
            } else {
                submitExam();
            }
        });

        previousButton.setOnClickListener(v -> {
            saveUserAnswer();
            if (currentQuestionIndex > 0) {
                currentQuestionIndex--;
                updateQuestion();
            }
        });

//        backButton.setOnClickListener(v -> finish());

        setupChoiceListeners();
    }

    private void setupChoiceListeners() {
        View.OnClickListener choiceListener = v -> {
            resetButtonStates();
            selectChoice((Button) v);
            saveUserAnswer();
        };

        choice1.setOnClickListener(choiceListener);
        choice2.setOnClickListener(choiceListener);
        choice3.setOnClickListener(choiceListener);
        choice4.setOnClickListener(choiceListener);
    }

    private void saveUserAnswer() {
        Button selectedButton = getSelectedButton();
        if (selectedButton != null) {
            userAnswers.set(currentQuestionIndex, selectedButton.getText().toString());
        }
    }

    private Button getSelectedButton() {
        if (choice1.isSelected()) return choice1;
        if (choice2.isSelected()) return choice2;
        if (choice3.isSelected()) return choice3;
        if (choice4.isSelected()) return choice4;
        return null;
    }

    private void selectChoice(Button choice) {
        choice.setSelected(true);
        choice.setBackgroundColor(getResources().getColor(R.color.colorSelected));
    }

    private void restoreUserAnswer() {
        String previousAnswer = userAnswers.get(currentQuestionIndex);
        if (!previousAnswer.isEmpty()) {
            if (previousAnswer.equals(choice1.getText().toString())) selectChoice(choice1);
            else if (previousAnswer.equals(choice2.getText().toString())) selectChoice(choice2);
            else if (previousAnswer.equals(choice3.getText().toString())) selectChoice(choice3);
            else if (previousAnswer.equals(choice4.getText().toString())) selectChoice(choice4);
        }
    }

    private void resetButtonStates() {
        choice1.setSelected(false);
        choice2.setSelected(false);
        choice3.setSelected(false);
        choice4.setSelected(false);
        choice1.setBackgroundColor(getResources().getColor(R.color.colorDefault));
        choice2.setBackgroundColor(getResources().getColor(R.color.colorDefault));
        choice3.setBackgroundColor(getResources().getColor(R.color.colorDefault));
        choice4.setBackgroundColor(getResources().getColor(R.color.colorDefault));
    }

    private void submitExam() {
        new AlertDialog.Builder(this)
                .setTitle("Submit Exam")
                .setMessage("Are you sure you want to submit the exam?")
                .setPositiveButton("Submit", (dialog, which) -> {
                    countDownTimer.cancel();  // Cancel timer only when submitting
                    showScoreDialog(); // Show score dialog after cancellation
                })
                .setNegativeButton("Review", (dialog, which) -> {
                    // Do nothing for review option
                    dialog.dismiss(); // Dismiss the dialog and continue reviewing
                })
                .show();
    }


    private void submitExamAutomatically() {
        countDownTimer.cancel();
        new AlertDialog.Builder(this)
                .setTitle("Time's Up!")
                .setMessage("Time has run out. The exam will be submitted automatically.")
                .setPositiveButton("Submit", (dialog, which) -> showScoreDialog())
                .show();
    }

    private void calculateScore() {
        score = 0;
        for (int i = 0; i < totalQuestions; i++) {
            if (userAnswers.get(i).equals(correctAnswers.get(i))) {
                score++;
            }
        }
    }

    private void showExitConfirmationDialog() {
        // Show a confirmation dialog when the back button is pressed
        new AlertDialog.Builder(this)
                .setTitle("Quit Exam?")
                .setMessage("Are you sure you want to exit? All progress will be lost.")
                .setPositiveButton("YES", (dialog, which) -> {
                    // Finish the activity if the user confirms
                    finish();
                })
                .setNegativeButton("NO", (dialog, which) -> {
                    // Dismiss the dialog and stay in the exam
                    dialog.dismiss();
                })
                .show();
    }

    @Override
    public void onBackPressed() {
        // Show a confirmation dialog when the back button is pressed
        new AlertDialog.Builder(this)
                .setTitle("Quit Exam?")
                .setMessage("Are you sure you want to exit? All progress will be lost.")
                .setPositiveButton("YES", (dialog, which) -> {
                    // If the user clicks "YES", exit the exam and finish the activity
                    super.onBackPressed(); // Calls the original back press functionality
                })
                .setNegativeButton("NO", (dialog, which) -> {
                    // If the user clicks "NO", just dismiss the dialog and do nothing
                    dialog.dismiss();
                })
                .show();
    }

    private void showScoreDialog() {
        calculateScore();
        long timeSpentMillis = (TIMER_DURATION_MINUTES * 60 * 1000) - timeLeftInMillis;

        // Calculate hours, minutes, and seconds
        int hoursSpent = (int) (timeSpentMillis / 1000) / 3600;
        int minutesSpent = (int) (timeSpentMillis / 1000) % 3600 / 60;
        int secondsSpent = (int) (timeSpentMillis / 1000) % 60;

        // Format the time spent
        String timeSpentFormatted = String.format("%02d hr, %02d minutes, %02d secs", hoursSpent, minutesSpent, secondsSpent);

        // Calculate correct and wrong answers
        int correctAnswersCount = score;
        int wrongAnswersCount = totalQuestions - score;

        // Create an Intent to navigate to the result activity
        Intent intent = new Intent(this, Exam_Result_Professional.class);
        intent.putExtra("correctAnswers", correctAnswersCount);
        intent.putExtra("wrongAnswers", wrongAnswersCount);
        intent.putExtra("timeSpent", timeSpentFormatted); // Use the formatted time string

        startActivity(intent);
        finish(); // Optionally finish the current activity if you want to close it
    }
}

