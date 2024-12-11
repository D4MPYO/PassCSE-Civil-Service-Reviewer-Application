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

public class Examination_for_SubProfessional extends AppCompatActivity {

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
    private final int maxQuestions = 70;     // CHANGE THE  TOTAL QUESTION BASE ON HOW MANY YOU WANT // CHANGE THE  TOTAL QUESTION BASE ON HOW MANY YOU WANT
    private ArrayList<String> userAnswers;
    private CountDownTimer countDownTimer;
    private static final int TIMER_DURATION_MINUTES = 45; // CHANGE THE MAX TIME LIMIT IN TAKING EXAM  // CHANGE THE MAX TIME LIMIT IN TAKING EXAM
    private long timeLeftInMillis = TIMER_DURATION_MINUTES * 60 * 1000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.examination_for_subprofessional);

        backButton = findViewById(R.id.backButton);

        // Set the click listener for the back button
        backButton.setOnClickListener(v -> showExitConfirmationDialog());

        // Initialize UI elements
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

//  Clerical Operations Questions

        questions.add("Which department of an office is responsible for hiring new personnel?");
        choices.add(new ArrayList<>(List.of("Office of the President", "Accounting Department", "Logistic and Supply", "Human Resource Department")));
        correctAnswers.add("Human Resource Department");

        questions.add("Which computer program should you go if you want to email a company?");
        choices.add(new ArrayList<>(List.of("Word", "Excel", "Outlook", "Powerpoint")));
        correctAnswers.add("Outlook");

        questions.add("This is a telephonic transmission of scanned documents of texts and images to a telephone number connected to a printer.");
        choices.add(new ArrayList<>(List.of("Photocopying Machine", "Fax Machine", "Typewriter", "Inkjet Printer")));
        correctAnswers.add("Fax Machine");

        questions.add("The chief financial officer is responsible for the financial matters and financial management of a corporation, she is also known as the _______.");
        choices.add(new ArrayList<>(List.of("Auditor", "Treasurer", "Chief Executive Officer", "Manager")));
        correctAnswers.add("Treasurer");

        questions.add("Which department of a company is responsible for cash register operations and payment processing?");
        choices.add(new ArrayList<>(List.of("Cashier", "Billing", "Accounting", "Budget")));
        correctAnswers.add("Cashier");

        questions.add("What is the correct filing arrangement for the following names? \n - Angeles, Mario P. \n - Angeles, Maricel P. \n - Angeles, Marissa P. \n - Angeles, Maria P.");
        choices.add(new ArrayList<>(List.of("4,2,1,3", "4,1,2,3", "4,3,2,1", "4,1,3,2")));
        correctAnswers.add("4,1,2,3");

        questions.add("All of the following items are found in the Official Receipt form except _____.");
        choices.add(new ArrayList<>(List.of("Name and address of the buyer", "Signature of the recipient", "Quantity of the items paid", "Credit Card Number of the customer")));
        correctAnswers.add("Credit Card Number of the customer");

        questions.add("The method of indexing and filing where names are in alphabetized order.");
        choices.add(new ArrayList<>(List.of("Numeric", "Metric", "Geographic", "Alphabetic")));
        correctAnswers.add("Alphabetic");

        questions.add("Which is the best way to address a correspondence for the President of the Philippines?");
        choices.add(new ArrayList<>(List.of("His Excellency Ferdinand Marcos Jr.", "His Excellency President Ferdinand Marcos Jr.", "President Ferdinand Marcos Jr.", "President BBM")));
        correctAnswers.add("His Excellency President Ferdinand Marcos Jr.");

        questions.add("How do you address the Queen of England when you talk about her?");
        choices.add(new ArrayList<>(List.of("Her Highness the Queen", "Her Majesty Queen Elizabeth II", "Queen Elizabeth II her Highness", "Queen Elizabeth II her Majesty")));
        correctAnswers.add("Her Majesty Queen Elizabeth II");

        questions.add("Your boss asked you to send her a soft copy of your latest résumé. An example of a soft copy is:");
        choices.add(new ArrayList<>(List.of("A print out copy usually in a paper", "Original copy written in a paper", "A copy saved in a computer and sent through email", "A copy from a Xerox machine")));
        correctAnswers.add("A copy saved in a computer and sent through email");

        questions.add("When a company asked you to submit your latest CV, what does CV stand for?");
        choices.add(new ArrayList<>(List.of("Curriculum Vitum", "Curriculum Virtue", "Curriculum Vitae", "Curriculum Vital")));
        correctAnswers.add("Curriculum Vitae");

        questions.add("It is the section of Accounting Department in a company that records goods and services that it receives and the payments it owes.");
        choices.add(new ArrayList<>(List.of("Budget", "Payroll", "Accounts Payable and Receivable", "Inventory")));
        correctAnswers.add("Accounts Payable and Receivable");

        questions.add("Which of the following is not a function of Accounting Department in a big corporation?");
        choices.add(new ArrayList<>(List.of("Prepare Interim Financial Statements", "Inventory Management", "Bank Reconciliation", "Internal and External Auditing")));
        correctAnswers.add("Inventory Management");

        questions.add("He is the highest ranking executive manager in a corporation and he is the top person in command in an organization.");
        choices.add(new ArrayList<>(List.of("Chief Financial Executive", "Chief Executive Officer", "Executive Admin. Officer", "Chief Executive Assistant")));
        correctAnswers.add("Chief Executive Officer");

        questions.add("Which of the following is not a responsibility of a clerical worker?");
        choices.add(new ArrayList<>(List.of("Marketing and promotion for customers", "Filing and updating purchase orders", "Updating and billing buyer’s account", "Answering business emails")));
        correctAnswers.add("Marketing and promotion for customers");

        questions.add("Arrange the proper filing of the following in alphabetical order: \n - A. Lieutenant Colonel Mark David \n - B. Atty. Elen Rodriguez \n - C. Captain Max Aquino \n - D. Dr. Juan Castro");
        choices.add(new ArrayList<>(List.of("CDAB", "CDBA", "BDCA", "BCDA")));
        correctAnswers.add("BCDA");

        questions.add("Arrange the proper filing of the following in alphabetical order: \n - A. Sec. Dinky Soliman \n - B. Sec. Richard Gordon \n - C. Sec. Voltaire Gazmin \n - D. Sec. Armin Luistro");
        choices.add(new ArrayList<>(List.of("DABC", "DACB", "CBDA", "CBAD")));
        correctAnswers.add("CBDA");

        questions.add("How much is the present Value-Added Tax in the Philippines?");
        choices.add(new ArrayList<>(List.of("12% of gross profit", "12% of cost of goods sold", "12% of gross sales", "12% of net income")));
        correctAnswers.add("12% of gross sales");

        questions.add("This department of the company is responsible for preparing and updating customers’ accounts:");
        choices.add(new ArrayList<>(List.of("Purchasing section", "Cashier section", "Billing Section", "Releasing section")));
        correctAnswers.add("Billing Section");

        questions.add("This is a type of document issued by a seller to a buyer relating to a sale transaction and indicating the products, quantities and prices sold to the buyer.");
        choices.add(new ArrayList<>(List.of("Check voucher", "Purchase order", "Delivery receipt", "Sales invoice")));
        correctAnswers.add("Sales invoice");

        questions.add("Which of the following is not a usual document used in a sales company?");
        choices.add(new ArrayList<>(List.of("Form 137", "Delivery receipt", "Sales invoice", "Purchase order")));
        correctAnswers.add("Form 137");

        questions.add("One of the responsibilities of a clerical job is answering and tending phone calls. Which is the best way to answer a phone call in a company?");
        choices.add(new ArrayList<>(List.of("Say “Hello,” and wait for the caller to speak.", "Run and get a pen and notebook then pick up the phone.", "Answer the phone politely and give your department or company name.", "Wait for fellow employees to answer the phone.")));
        correctAnswers.add("Answer the phone politely and give your department or company name.");

        questions.add("An example of a hard copy document is:");
        choices.add(new ArrayList<>(List.of("PDF file letter", "Company email message", "A business letter saved in USB", "Business letter in a paper")));
        correctAnswers.add("Business letter in a paper");

        questions.add("What does CC mean in an email message?");
        choices.add(new ArrayList<>(List.of("Copy sent", "Copy furnished", "Copy cat", "Client copy")));
        correctAnswers.add("Copy furnished");
//MATH
        questions.add("2187, 729, 243, 81, 27, 9, ____?");
        choices.add(new ArrayList<>(List.of("6", "3", "4", "2")));
        correctAnswers.add("3");

        questions.add("1, 4, 9, 16, 25, 36, 49, 64, ___?");
        choices.add(new ArrayList<>(List.of("72", "75", "81", "90")));
        correctAnswers.add("81");

        questions.add("13 - 21 34 - 55 89 ___?");
        choices.add(new ArrayList<>(List.of("-95", "104", "-123", "-144")));
        correctAnswers.add("-144");

        questions.add("AZ CX EV GT ____?");
        choices.add(new ArrayList<>(List.of("IR KP", "IR KQ", "IS KQ", "IS KP")));
        correctAnswers.add("IR KP");

        questions.add("A5 D25 G125 J625 M3125 ____?");
        choices.add(new ArrayList<>(List.of("P15525", "P15625", "O15525", "O15625")));
        correctAnswers.add("P15625");

        questions.add("What is -25 + 16?");
        choices.add(new ArrayList<>(List.of("9", "-9", "-41", "41")));
        correctAnswers.add("-9");

        questions.add("What is 107 – (-17)?");
        choices.add(new ArrayList<>(List.of("-90", "90", "124", "-124")));
        correctAnswers.add("124");

        questions.add("(-9) (-22) = ____?");
        choices.add(new ArrayList<>(List.of("198", "-198", "31", "-31")));
        correctAnswers.add("198");

        questions.add("(21) (-4) + (8) (-2) = ____?");
        choices.add(new ArrayList<>(List.of("-100", "100", "-23", "23")));
        correctAnswers.add("-23");

        questions.add("(-560) ÷ 7 = ___?");
        choices.add(new ArrayList<>(List.of("-80", "80", "-553", "553")));
        correctAnswers.add("-80");

        questions.add("6/8 + 2 ½ + 4/12 is also the same as?");
        choices.add(new ArrayList<>(List.of("½ + 2.5 + ¼", "½ + 5/2 + 1/6", "¾ + 2.5 + 1/6", "¾ + 5/2 + 1/3")));
        correctAnswers.add("½ + 5/2 + 1/6");

        questions.add("What is the Least Common Denominator of 1/8, ¾, and 1/16?");
        choices.add(new ArrayList<>(List.of("4", "8", "16", "2")));
        correctAnswers.add("16");

        questions.add("What is the Greatest Common Factor of 36 and 54?");
        choices.add(new ArrayList<>(List.of("6", "12", "18", "9")));
        correctAnswers.add("18");

        questions.add("What is the sum of ½ + 8/4 + 6/12?");
        choices.add(new ArrayList<>(List.of("15/12", "3/12", "3", "3 1/12")));
        correctAnswers.add("3");

        questions.add("3/9 x 2/3 = ____");
        choices.add(new ArrayList<>(List.of("6/27", "2/9", "9/18", "1/9")));
        correctAnswers.add("2/9");

        questions.add("¾ ÷ 1/8 = ____");
        choices.add(new ArrayList<>(List.of("8", "4", "12", "6")));
        correctAnswers.add("6");

        questions.add("What is the decimal form of ¾ %?");
        choices.add(new ArrayList<>(List.of(".0075", ".075", ".75", ".00075")));
        correctAnswers.add(".0075");

        questions.add("Convert 3.4% as a fraction.");
        choices.add(new ArrayList<>(List.of("34/100", ".34/100", "3.4/1000", "3.4/100")));
        correctAnswers.add("34/100");

        questions.add("What is ¼ in decimal?");
        choices.add(new ArrayList<>(List.of(".025", ".25", "2.5", ".0025")));
        correctAnswers.add(".25");

        questions.add("What is the ratio of ½ to 2/5?");
        choices.add(new ArrayList<>(List.of("3:4", "5:4", "1:3", "2:5")));
        correctAnswers.add("5:4");

        questions.add("2.12 is multiplied by 10 to the sixth power is?");
        choices.add(new ArrayList<>(List.of("212.000", "2,120,000", "212,000", "21,200")));
        correctAnswers.add("2,120,000");

        questions.add("25 is multiplied by 10 to the fifth power is?");
        choices.add(new ArrayList<>(List.of("2,500,000", "250,000", "25,000", ".000025")));
        correctAnswers.add("250,000");

        questions.add("Find the value of x in the equation: 5x + 25 =10");
        choices.add(new ArrayList<>(List.of("5", "3", "-3", "-5")));
        correctAnswers.add("-3");

        questions.add("If x=8, find the value of y in the equation: 4x – 2y = 28.");
        choices.add(new ArrayList<>(List.of("-4", "-2", "4", "2")));
        correctAnswers.add("2");

        questions.add("Find the value of x if y= 8 in the equation: 2x + 4y = 50");
        choices.add(new ArrayList<>(List.of("9", "8", "10", "4")));
        correctAnswers.add("10");

        questions.add("Kit is twice as old as his friend Sam. Sam is 5 years older than Cara. In 5 years, Kit will be three times as old as Cara. How old is Sam?");
        choices.add(new ArrayList<>(List.of("2 years old", "3 years old", "4 years old", "5 years old")));
        correctAnswers.add("5 years old");

        questions.add("James’s dad is 5 times older than James and James is twice as old as his sister Sara. In two years, the sum of their ages will be 58. How old is James now?");
        choices.add(new ArrayList<>(List.of("6 years old", "7 years old", "8 years old", "9 years old")));
        correctAnswers.add("8 years old");

        questions.add("Cathy scored 85, 87, 90, 95, and 100 in her Math exams. What will be her average grade in Math from this period?");
        choices.add(new ArrayList<>(List.of("91.40", "91.50", "92", "93.50")));
        correctAnswers.add("91.50");

        questions.add("Letty left home and drove at the rate of 50 miles per hour for 2 hours. She stopped for lunch then drove for another 4 hours at 65 mph to reach Los Angeles. How many miles did Letty drive to reach LA?");
        choices.add(new ArrayList<>(List.of("115 miles", "360 miles", "310 miles", "100 miles")));
        correctAnswers.add("360 miles");

        questions.add("Michelle went to SM for the 3-day sale. She bought a new pair of shoes and paid only P2,450 discounted for 20% off. What was the original price of the shoes?");
        choices.add(new ArrayList<>(List.of("P3,062.50", "P3,260.50", "P3,620.50", "P3,026.50")));
        correctAnswers.add("P3,062.50");

// ANALOGY AND LOGICS

        questions.add("Iron: metal :: granite: ______");
        choices.add(new ArrayList<>(List.of("marble", "rock", "sand", "solid")));
        correctAnswers.add("rock");

        questions.add("Decibel: sound :: volt: ______");
        choices.add(new ArrayList<>(List.of("accounting", "merchandise", "cost", "list")));
        correctAnswers.add("cost");

        questions.add("Coward: brave :: philanthropist: ______");
        choices.add(new ArrayList<>(List.of("selfish", "kind", "pessimist", "optimist")));
        correctAnswers.add("selfish");

        questions.add("Logic: reasoning :: ethics: _______");
        choices.add(new ArrayList<>(List.of("character", "behavior", "subject", "traits")));
        correctAnswers.add("behavior");

        questions.add("Antenna: signal :: net: ______");
        choices.add(new ArrayList<>(List.of("web", "catch", "gross", "fish")));
        correctAnswers.add("catch");

        questions.add("Stanza: poem :: act: ______");
        choices.add(new ArrayList<>(List.of("movie", "opera", "song", "lyric")));
        correctAnswers.add("movie");

        questions.add("Astrology: Astronomy :: Alchemy: ______");
        choices.add(new ArrayList<>(List.of("Chemistry", "Biology", "Physics", "Science")));
        correctAnswers.add("Chemistry");

        questions.add("Census: population :: inventory: ______");
        choices.add(new ArrayList<>(List.of("license", "contact", "agreement", "paper")));
        correctAnswers.add("agreement");

        questions.add("Oath: promise :: contract: ______");
        choices.add(new ArrayList<>(List.of("license", "contact", "agreement", "paper")));
        correctAnswers.add("agreement");

        questions.add("Glimmer: Flicker :: murmur: _______");
        choices.add(new ArrayList<>(List.of("whisper", "shout", "rumor", "speak")));
        correctAnswers.add("whisper");

        questions.add("Bouquet: flowers :: flock: ______");
        choices.add(new ArrayList<>(List.of("dogs", "sheep", "ship", "cats")));
        correctAnswers.add("sheep");

        questions.add("Rescind: law :: withdraw: _______");
        choices.add(new ArrayList<>(List.of("bank", "candidacy", "deposit", "resume")));
        correctAnswers.add("candidacy");

        questions.add("Hoax: deceive :: filibuster: ______");
        choices.add(new ArrayList<>(List.of("delay", "refuse", "stop", "none")));
        correctAnswers.add("delay");

        questions.add("Syllabus: course :: agenda: _______");
        choices.add(new ArrayList<>(List.of("subject", "platform", "meeting", "lesson")));
        correctAnswers.add("meeting");

        questions.add("Cat: kitten :: horse: ______");
        choices.add(new ArrayList<>(List.of("cab", "puppy", "stallion", "pony")));
        correctAnswers.add("pony");

        questions.add("Evaporate: vapor :: petrify: _______");
        choices.add(new ArrayList<>(List.of("liquid", "stone", "magnify", "cold")));
        correctAnswers.add("stone");

        questions.add("Canvas: painter :: marble: ________");
        choices.add(new ArrayList<>(List.of("sculptor", "rock", "statue", "form")));
        correctAnswers.add("sculptor");

        questions.add("Hammer: anvil :: pestle: _________");
        choices.add(new ArrayList<>(List.of("ground", "grinder", "mortar", "knife")));
        correctAnswers.add("mortar");

        questions.add("Librarian: books :: curator: _______");
        choices.add(new ArrayList<>(List.of("atlas", "encyclopedia", "room", "paintings")));
        correctAnswers.add("paintings");

        questions.add("Archive: manuscript :: arsenal: ______");
        choices.add(new ArrayList<>(List.of("soldier", "weapon", "castle", "king")));
        correctAnswers.add("weapon");

        questions.add("Bodyguard: protection :: mentor: ______");
        choices.add(new ArrayList<>(List.of("advice", "counsel", "teacher", "leader")));
        correctAnswers.add("advice");

        questions.add("Novelist: plot :: Architect: _______");
        choices.add(new ArrayList<>(List.of("building", "design", "blueprint", "house")));
        correctAnswers.add("blueprint");

        questions.add("Molecule: atoms :: tissue: _______");
        choices.add(new ArrayList<>(List.of("organ", "cells", "body", "neutrons")));
        correctAnswers.add("cells");

        questions.add("Call: telephone :: type: ________");
        choices.add(new ArrayList<>(List.of("cellphone", "ipad", "keyboard", "piano")));
        correctAnswers.add("keyboard");

        questions.add("Eavesdrop: conversation :: trespass: ______");
        choices.add(new ArrayList<>(List.of("property", "house", "land", "assets")));
        correctAnswers.add("property");

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

// CLERICAL

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


        questions.add("This is a type of document issued by a seller to a buyer relating to a sale transaction and indicating the products, quantities, and prices sold to the buyer.");
        choices.add(new ArrayList<>(List.of("Check voucher", "Purchase order", "Delivery receipt", "Sales invoice")));
        correctAnswers.add("Sales invoice");

        questions.add("Which of the following is not a usual document used in a sales company?");
        choices.add(new ArrayList<>(List.of("Form 137", "Delivery receipt", "Sales invoice", "Purchase order")));
        correctAnswers.add("Form 137");

        questions.add("One of the responsibilities of a clerical job is answering and tending phone calls. Which is the best way to answer a phone call in a company?");
        choices.add(new ArrayList<>(List.of("Say “Hello,” and wait for the caller to speak.", "Run and get a pen and notebook then pick up the phone.", "Answer the phone politely and give your department or company name.", "Wait for fellow employees to answer the phone.")));
        correctAnswers.add("Answer the phone politely and give your department or company name.");

        questions.add("An example of a hard copy document is:");
        choices.add(new ArrayList<>(List.of("PDF file letter", "Company email message", "A business letter saved in USB", "Business letter in a paper")));
        correctAnswers.add("Business letter in a paper");

        questions.add("What does a CC mean in an email message?");
        choices.add(new ArrayList<>(List.of("Copy sent", "Copy furnished", "Copy cat", "Client copy")));
        correctAnswers.add("Copy furnished");

        questions.add("Which computer program should you go to if you want to email a company?");
        choices.add(new ArrayList<>(List.of("Word", "Excel", "Outlook", "PowerPoint")));
        correctAnswers.add("Outlook");

        questions.add("This is a telephonic transmission of scanned documents of texts and images to a telephone number connected to a printer.");
        choices.add(new ArrayList<>(List.of("Photocopying Machine", "Fax Machine", "Typewriter", "Inkjet Printer")));
        correctAnswers.add("Fax Machine");

        questions.add("The chief financial officer is responsible for the financial matters and financial management of a corporation; she is also known as the _______.");
        choices.add(new ArrayList<>(List.of("Auditor", "Treasurer", "Chief Executive Officer", "Manager")));
        correctAnswers.add("Treasurer");

        questions.add("Which department of a company is responsible for cash register operations and payment processing?");
        choices.add(new ArrayList<>(List.of("Cashier", "Billing", "Accounting", "Budget")));
        correctAnswers.add("Cashier");

        questions.add("Your boss asked you to send her a soft copy of your latest résumé. An example of a soft copy is:");
        choices.add(new ArrayList<>(List.of("A printout copy usually on paper", "Original copy written on paper", "A copy saved on a computer and sent through email", "A copy from a Xerox machine")));
        correctAnswers.add("A copy saved on a computer and sent through email");

 // GRAMMAR

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
        Intent intent = new Intent(this, Exam_Result_SubProfessional.class);
        intent.putExtra("correctAnswers", correctAnswersCount);
        intent.putExtra("wrongAnswers", wrongAnswersCount);
        intent.putExtra("timeSpent", timeSpentFormatted); // Use the formatted time string

        startActivity(intent);
        finish(); // Optionally finish the current activity if you want to close it
    }
}

