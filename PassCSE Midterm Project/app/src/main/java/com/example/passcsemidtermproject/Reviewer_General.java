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

public class Reviewer_General extends AppCompatActivity {

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
        setContentView(R.layout.reviewer_general_info);

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
        questions.add("What are the 3 main branches of the Government of the Philippines?\na.) Senate, Supreme Court, Congress\nb.) Presidential, Unicameral-Parliamentary, Bicameral-Parliamentary\nc.) Legislative, Executive, Judicial\nd.) The Legislature, The Senate, The Supreme Court");
        answers.add("Answer: c.) Legislative, Executive, Judicial.");
        explanations.add("Explanation: The Government of the Philippines is divided into three main branches: Legislative, Executive, and Judicial, as per the Philippine Constitution.");

        questions.add("The Supreme Court shall be composed of a Chief Justice and how many Associate Justices?\na.) 12\nb.) 13\nc.) 14\nd.) 15");
        answers.add("Answer: d.) 15.");
        explanations.add("Explanation: The Philippine Supreme Court is composed of a Chief Justice and 14 Associate Justices, making a total of 15 justices.");

        questions.add("The Commander-in-Chief of all armed forces of the Philippines in 2024 is _________.\na.) Air Force Commanding General Connor Anthony Canlas\nb.) Ferdinand R. Marcos, Jr.\nc.) Chief Justice Alexander G. Gesmundo\nd.) AFP Chief General Romeo Brawner Jr.");
        answers.add("Answer: b.) Ferdinand R. Marcos, Jr.");
        explanations.add("Explanation: As the President of the Philippines in 2024, Ferdinand R. Marcos, Jr. is the Commander-in-Chief of all armed forces of the Philippines.");

        questions.add("The executive power shall be vested in the _________.\na.) President of the Philippines\nb.) House of Representatives\nc.) The Supreme Court\nd.) The Congress");
        answers.add("Answer: a.) President of the Philippines.");
        explanations.add("Explanation: According to the Philippine Constitution, executive power is vested in the President of the Philippines.");

        questions.add("The legislative power shall be vested in the _________ which shall consist of a Senate and a House of Representatives.\na.) Congress of the Philippines\nb.) House of Ombudsman\nc.) The Supreme Court\nd.) Bureau of Internal Revenue");
        answers.add("Answer: a.) Congress of the Philippines.");
        explanations.add("Explanation: Legislative power is vested in the Congress of the Philippines, which consists of the Senate and the House of Representatives.");

        questions.add("The Senate shall be composed of how many senators elected at large by voters of the Philippines?\na.) 21\nb.) 22\nc.) 23\nd.) 24");
        answers.add("Answer: d.) 24.");
        explanations.add("Explanation: The Philippine Senate is composed of 24 senators elected by voters at large.");

        questions.add("How long shall the term of office of the senators be commenced?\na.) 3 years\nb.) 4 years\nc.) 5 years\nd.) 6 years");
        answers.add("Answer: d.) 6 years.");
        explanations.add("Explanation: The term of office for senators in the Philippines is six years, and they can serve for up to two consecutive terms.");

        questions.add("The term of office of the President and Vice-president of the Philippines shall be up to how many years?\na.) 3 years\nb.) 4 years\nc.) 5 years\nd.) 6 years");
        answers.add("Answer: d.) 6 years.");
        explanations.add("Explanation: According to the 1987 Philippine Constitution, the term of office for both the President and Vice President is six years.");

        questions.add("The members of the House of Representatives shall be elected for a term of _______.\na.) 3 years\nb.) 4 years\nc.) 5 years\nd.) 6 years");
        answers.add("Answer: a.) 3 years.");
        explanations.add("Explanation: The term of office for members of the House of Representatives in the Philippines is three years.");

        questions.add("The following shall be exempted from taxation except:\na.) Lands and buildings\nb.) Churches and convents\nc.) Charitable institutions\nd.) Non-profit cemeteries");
        answers.add("Answer: a.) Lands and buildings.");
        explanations.add("Explanation: Lands and buildings, unless otherwise specified, are not exempt from taxation in the Philippines.");

        questions.add("The Congress, by a vote of ____ of both Houses in joint session assembled, voting separately, shall have the sole power to declare a state of war.\na.) Two-thirds\nb.) One-half\nc.) Three quarters\nd.) Minority");
        answers.add("Answer: a.) Two-thirds.");
        explanations.add("Explanation: A two-thirds vote of both Houses of Congress is required to declare a state of war in the Philippines.");

        questions.add("It states that “no person shall be deprived of life, liberty, or property without due process of law, nor any person be denied the equal protection of the laws.”\na.) Article VI\nb.) Bill of Rights\nc.) Republic Act\nd.) Court Order");
        answers.add("Answer: b.) Bill of Rights.");
        explanations.add("Explanation: This principle is found in the Bill of Rights in the Philippine Constitution, which protects the rights of citizens.");

        questions.add("All of the following is TRUE except:\na.) No person shall be compelled to be a witness against himself\nb.) No person shall be imprisoned for non-payment of debt or poll tax.\nc.) No ex post facto law or bill of attainder shall not be enacted.\nd.) No person shall be detained solely by reason of his political beliefs and aspirations.");
        answers.add("Answer: c.) No ex post facto law or bill of attainder shall not be enacted.");
        explanations.add("Explanation: The correct statement is 'No ex post facto law or bill of attainder shall be enacted.' The double negative in the original statement makes it incorrect.");

        questions.add("The following are citizens of the Philippines except:\na.) Those fathers or mothers are citizens of the Philippines\nb.) Those who are born before January 17, 1973, of Filipino mothers, who elect Philippine citizenship upon reaching the age of majority\nc.) Those who are naturalized citizens of the Philippines in accordance with law.\nd.) All of the above are true.");
        answers.add("Answer: d.) All of the above are true.");
        explanations.add("Explanation: All the options provided describe conditions under which an individual is considered a citizen of the Philippines.");

        questions.add("It is the right and obligation by all citizens, who are at least 18 years of age, and qualified by law, to vote in the election of national and local officials of the government without literacy, property, or other substantive requirement.\na.) Suffrage\nb.) Election\nc.) Voting power\nd.) Civil Right");
        answers.add("Answer: a.) Suffrage.");
        explanations.add("Explanation: Suffrage is the right to vote in elections, which is a fundamental right and obligation of Filipino citizens who are at least 18 years old.");

        questions.add("The three inherent powers of the state are the following except one:\na.) Police Power\nb.) Power of Eminent Domain\nc.) Power of Taxation\nd.) Power to Impeach");
        answers.add("Answer: d.) Power to Impeach.");
        explanations.add("Explanation: The three inherent powers of the state are Police Power, the Power of Eminent Domain, and the Power of Taxation. The power to impeach is not one of the inherent powers.");

        questions.add("It is the power of the State to promote public welfare by restraining the use of both liberty and property of all people.\na.) Police Power\nb.) Power of Eminent Domain\nc.) Power of Taxation\nd.) Power to Impeach");
        answers.add("Answer: a.) Police Power.");
        explanations.add("Explanation: Police Power refers to the state's authority to promote public welfare by regulating the use of both liberty and property.");

        questions.add("It is the power of the State to take properties for the purpose of public use upon payment of just compensation.\na.) Police Power\nb.) Power of Eminent Domain\nc.) Power of Taxation\nd.) Power to Impeach");
        answers.add("Answer: b.) Power of Eminent Domain.");
        explanations.add("Explanation: The Power of Eminent Domain allows the state to expropriate private property for public use, with the obligation to provide just compensation.");

        questions.add("It is the power of the State to impose charge or burden to persons and properties, and property rights for the purpose of raising revenues to protect the people and extend public projects and services.\na.) Police Power\nb.) Power of Eminent Domain\nc.) Power of Taxation\nd.) Power to Impeach");
        answers.add("Answer: c.) Power of Taxation.");
        explanations.add("Explanation: The Power of Taxation enables the government to levy charges on individuals and properties to generate revenue for public purposes.");

        questions.add("The following are members of the Constitutional Commission except:\na.) Commission on Civil Rights\nb.) Commission on Elections\nc.) Civil Service Commission\nd.) Commission on Audit");
        answers.add("Answer: a.) Commission on Civil Rights.");
        explanations.add("Explanation: The Commission on Civil Rights is not part of the Constitutional Commission, which includes the Commission on Elections, Civil Service Commission, and Commission on Audit.");

        questions.add("It states that public office is public trust and that public officers and employees must, at all times, be accountable to the people, serve them with utmost responsibility, integrity, loyalty and efficiency; act with patriotism and justice and lead modest lives.\na.) Public Trust\nb.) Constitutional Rights\nc.) Accountability\nd.) Responsibility");
        answers.add("Answer: a.) Public Trust.");
        explanations.add("Explanation: Public trust emphasizes the accountability of public officials to the people, underscoring their duty to serve with integrity and responsibility.");

        questions.add("Who shall have the exclusive power to initiate all cases of impeachment?\na.) House of Blue Ribbon Committee\nb.) House of Representatives\nc.) House of the Senate\nd.) Speaker of the House");
        answers.add("Answer: b.) House of Representatives.");
        explanations.add("Explanation: The House of Representatives has the exclusive authority to initiate impeachment proceedings against public officials.");

        questions.add("R.A. 6713 is an act to uphold the time-honored principle of public office being a public trust, granting incentives and rewards for exemplary service, enumerating prohibited acts and providing penalties for violations thereof and for other purposes.\na.) Preamble\nb.) Code of Ethics\nc.) Code of Government Officials\nd.) Code of Conduct and Ethical Standards for Public Officials and Employees");
        answers.add("Answer: d.) Code of Conduct and Ethical Standards for Public Officials and Employees.");
        explanations.add("Explanation: R.A. 6713 is known as the Code of Conduct and Ethical Standards for Public Officials and Employees, promoting accountability and ethical behavior.");

        questions.add("The following are duties and responsibilities of Public officials and Employees except:\na.) Act promptly on letters, inquiries, calls or any other form of communications sent by the public.\nb.) Submit performance reports of the agency or office regularly\nc.) Accept gifts from the public upon prioritizing their queries.\nd.) Process documents and papers expeditiously.");
        answers.add("Answer: c.) Accept gifts from the public upon prioritizing their queries.");
        explanations.add("Explanation: Public officials and employees are prohibited from accepting gifts to ensure impartiality and integrity in their duties.");

        questions.add("It is a written instrument containing the proposition and required number of signatories and shall be in a form determined by and submitted to the Commission on Elections.\na.) Bill\nb.) Law\nc.) Proposition\nd.) Petition");
        answers.add("Answer: d.) Petition.");
        explanations.add("Explanation: A petition is a formal request submitted to the Commission on Elections, often to propose new legislation or amendments.");

        questions.add("It is the electoral process by which an initiative on the Constitution is either approved or rejected by the people.\na.) Referendum\nb.) Plebiscite\nc.) Petition\nd.) Initiative");
        answers.add("Answer: b.) Plebiscite.");
        explanations.add("Explanation: A plebiscite is a direct vote in which an entire electorate is invited to vote on a particular proposal affecting the Constitution.");

        questions.add("It is the power of the electorate to approve or reject a legislation through an election called for the purpose.\na.) Referendum\nb.) Plebiscite\nc.) Petition\nd.) Initiative");
        answers.add("Answer: a.) Referendum.");
        explanations.add("Explanation: A referendum allows voters to approve or reject proposed legislation or amendments through a direct vote.");

        questions.add("This law promotes responsible family planning and proper use of reproductive methods to eliminate over-population growth.\na.) RH Bill\nb.) Responsible Parenthood and Reproductive Health Law\nc.) Reproductive Law\nd.) Family Planning");
        answers.add("Answer: b.) Responsible Parenthood and Reproductive Health Law.");
        explanations.add("Explanation: The Responsible Parenthood and Reproductive Health Law aims to provide access to family planning methods and education.");

        questions.add("It is a specialized agency of the United Nations that concerns international public health.\na.) Department of Health\nb.) World Health Organization\nc.) International Health Organization\nd.) All of the above");
        answers.add("Answer: b.) World Health Organization.");
        explanations.add("Explanation: The World Health Organization (WHO) is the United Nations agency responsible for international public health.");

        questions.add("APEC is a summit that promotes free trade and economic cooperation throughout the Asia-Pacific region countries. APEC stands for:\na.) Asia Pacific Economic Corporation\nb.) Asia Pacific Economic Cooperation\nc.) Asia Pacific Economic Council\nd.) Asia Pacific Economic Countries");
        answers.add("Answer: b.) Asia Pacific Economic Cooperation.");
        explanations.add("Explanation: APEC stands for Asia Pacific Economic Cooperation, focusing on fostering economic growth and cooperation in the Asia-Pacific region.");

        questions.add("Association of Southeast Asian Nations (ASEAN) aims to accelerate economic growth, stability, social progress and cultural development in the spirit of equality and partnership to strengthen prosperous and peaceful community along Southeast Asian Nations. Which of the following countries is not a member of ASEAN?\na.) Hong Kong\nb.) Philippines\nc.) Singapore\nd.) Thailand");
        answers.add("Answer: a.) Hong Kong.");
        explanations.add("Explanation: Hong Kong is not a member of ASEAN, while the Philippines, Singapore, and Thailand are member countries.");

        questions.add("It is a law in the Philippines that aims to address legal issues concerning online interactions and harmful internet behavior in the Philippines. It aims to prevent and punish cybercrime in the country.\na.) Cybersquatting\nb.) Cybercrime Act\nc.) Cybercrime Prevention Act\nd.) Cyber Identity Theft Act");
        answers.add("Answer: c.) Cybercrime Prevention Act.");
        explanations.add("Explanation: The Cybercrime Prevention Act is aimed at preventing and punishing cybercrime in the Philippines.");

        questions.add("__________ waste breaks down into natural components and can be recycled into the life cycle naturally.\na.) Bio-chemical\nb.) Recyclable\nc.) Biodegradable\nd.) Non-biodegradable");
        answers.add("Answer: c.) Biodegradable.");
        explanations.add("Explanation: Biodegradable waste can decompose naturally, returning to the ecosystem and being recycled into the life cycle.");

        questions.add("The following are examples of non-biodegradable waste except:\na.) Plastics\nb.) Metals\nc.) Styrofoam\nd.) Papers");
        answers.add("Answer: d.) Papers.");
        explanations.add("Explanation: Papers are biodegradable, while plastics, metals, and styrofoam are non-biodegradable.");

        questions.add("It is a project of DOST for a more accurate, integrated and responsive disaster prevention and mitigation system especially in high-risk calamity areas of the Philippines.\na.) PAGASA\nb.) I am Ready\nc.) DOST-Advanced Disaster Program\nd.) Project NOAH");
        answers.add("Answer: d.) Project NOAH.");
        explanations.add("Explanation: Project NOAH (Nationwide Operational Assessment of Hazards) is aimed at improving disaster risk reduction in the Philippines.");

        questions.add("PAGASA is the official government agency for weather forecasting, flood control, astronomical observations, and time service. PAGASA stands for _______?\na.) Philippine Atmospheric Geographical and Astronomical Services Administration\nb.) Philippine Atmospheric Geophysical and Astronomical Services Administration\nc.) Philippine Atmospheric Geological and Astronomical Services Association\nd.) Philippine Atmospheric Geophysical and Astronomical Services Association");
        answers.add("Answer: b.) Philippine Atmospheric Geophysical and Astronomical Services Administration.");
        explanations.add("Explanation: PAGASA stands for Philippine Atmospheric Geophysical and Astronomical Services Administration, responsible for weather-related services.");

        questions.add("PHIVOLCS is a branch of DOST to moderate disasters that may arise from volcanic eruptions, earthquakes, tsunami and other related geotectonic phenomena in the Philippines. What is PHIVOLCS?\na.) Philippine Institute of Volcanology and Seismology\nb.) Philippine Institute of Volcanic and Seismic Services\nc.) Philippine Institute of Volcanic and Seismology Services\nd.) Philippine Institute of Volcano and Seismic System");
        answers.add("Answer: a.) Philippine Institute of Volcanology and Seismology.");
        explanations.add("Explanation: PHIVOLCS stands for Philippine Institute of Volcanology and Seismology, focused on monitoring geological hazards.");

        questions.add("Which of the following is a renewable source of energy?\na.) Geothermal energy\nb.) Solar energy\nc.) Wind energy\nd.) All of the above");
        answers.add("Answer: d.) All of the above.");
        explanations.add("Explanation: Geothermal energy, solar energy, and wind energy are all renewable sources of energy.");

        questions.add("It is a process by which thermal radiation from the earth’s surface is absorbed by atmospheric greenhouse gases and is re-radiated in all directions.\na.) Global Warming\nb.) Greenhouse Effect\nc.) Ozone Layer\nd.) Solar Radiation");
        answers.add("Answer: b.) Greenhouse Effect.");
        explanations.add("Explanation: The greenhouse effect occurs when greenhouse gases trap thermal radiation, leading to an increase in Earth's temperature.");

        questions.add("USB is an industry standard that connects computers and electronic devices like keyboards, digicams, portable media devices, disk drivers, smartphones, and network adapters to any computer. USB stands for?\na.) Unit Serial Box\nb.) Unit Serial Bolt\nc.) Universal Serial Bin\nd.) Universal Serial Bus");
        answers.add("Answer: d.) Universal Serial Bus.");
        explanations.add("Explanation: USB stands for Universal Serial Bus, which is a standard for connecting various devices to computers.");

        questions.add("The principle that all government authority is derived from the people is known as:\na.) Popular Sovereignty\nb.) Social Contract\nc.) Constitutionalism\nd.) Rule of Law");
        answers.add("Answer: a.) Popular Sovereignty.");
        explanations.add("Explanation: Popular sovereignty asserts that the government derives its power from the consent of the governed, emphasizing the people's authority in a democratic system.");

        questions.add("This is a form of government in which power is divided between a central authority and constituent political units:\na.) Unitary System\nb.) Federal System\nc.) Confederal System\nd.) Authoritarian System");
        answers.add("Answer: b.) Federal System.");
        explanations.add("Explanation: In a federal system, power is shared between the national government and local entities, allowing for regional autonomy while maintaining national unity.");

        questions.add("What is the highest law of the land in the Philippines?\na.) Constitution\nb.) Statutes\nc.) Administrative Code\nd.) Local Ordinances");
        answers.add("Answer: a.) Constitution.");
        explanations.add("Explanation: The Constitution is the supreme law of the Philippines, providing the framework for government and guaranteeing fundamental rights.");

        questions.add("Which of the following laws establishes the rights of citizens to participate in governance and public affairs?\na.) Anti-Discrimination Law\nb.) Freedom of Information Law\nc.) Civil Service Law\nd.) Right to Information Act");
        answers.add("Answer: b.) Freedom of Information Law.");
        explanations.add("Explanation: The Freedom of Information Law allows citizens to access government documents, promoting transparency and accountability in governance.");

        questions.add("The Clean Air Act is aimed at reducing air pollution in the Philippines. What is the main objective of this act?\na.) To promote sustainable transport\nb.) To ensure clean and healthy air\nc.) To protect wildlife habitats\nd.) To regulate waste disposal");
        answers.add("Answer: b.) To ensure clean and healthy air.");
        explanations.add("Explanation: The Clean Air Act aims to improve air quality by establishing standards and regulations to control air pollution.");

        questions.add("This environmental law mandates the establishment of a solid waste management program in the Philippines:\na.) Republic Act 9003\nb.) Republic Act 8749\nc.) Republic Act 9275\nd.) Republic Act 9512");
        answers.add("Answer: a.) Republic Act 9003.");
        explanations.add("Explanation: Republic Act 9003, also known as the Ecological Solid Waste Management Act, focuses on the management of solid waste and promotes waste reduction.");

        questions.add("The right of individuals to be informed about the environmental impact of projects is known as:\na.) Environmental Right\nb.) Right to Information\nc.) Environmental Justice\nd.) Right to Participate");
        answers.add("Answer: a.) Environmental Right.");
        explanations.add("Explanation: Environmental rights include the right to access information regarding environmental issues and to participate in decision-making processes.");

        questions.add("Which of the following is NOT a component of the Philippine government structure?\na.) Executive\nb.) Legislative\nc.) Judicial\nd.) Diplomatic");
        answers.add("Answer: d.) Diplomatic.");
        explanations.add("Explanation: The Philippine government structure consists of three branches: Executive, Legislative, and Judicial, while diplomatic activities fall under the Executive branch.");

        questions.add("This technology enables secure online transactions through encryption and digital signatures:\na.) Blockchain\nb.) VPN\nc.) Firewall\nd.) HTTP");
        answers.add("Answer: a.) Blockchain.");
        explanations.add("Explanation: Blockchain technology uses encryption and digital signatures to create secure and tamper-proof records of transactions, enhancing trust in digital interactions.");

        questions.add("The process of converting waste materials into reusable materials is known as:\na.) Recycling\nb.) Composting\nc.) Waste Reduction\nd.) Landfilling");
        answers.add("Answer: a.) Recycling.");
        explanations.add("Explanation: Recycling involves processing used materials to create new products, reducing the need for raw materials and minimizing waste.");

        questions.add("Which of the following best describes the principle of 'sustainable development'?\na.) Economic growth at all costs\nb.) Balancing economic growth with environmental protection\nc.) Development that disregards ecological limits\nd.) Focusing solely on technology for growth");
        answers.add("Answer: b.) Balancing economic growth with environmental protection.");
        explanations.add("Explanation: Sustainable development aims to meet the needs of the present without compromising the ability of future generations to meet their own needs, ensuring ecological balance.");

        questions.add("The National Environmental Awareness and Education Act aims to:\na.) Promote awareness of environmental issues\nb.) Establish environmental courts\nc.) Regulate pollution\n d.) Monitor climate change effects");
        answers.add("Answer: a.) Promote awareness of environmental issues.");
        explanations.add("Explanation: The National Environmental Awareness and Education Act focuses on increasing public awareness and education about environmental protection and sustainable practices.");

        questions.add("Which of the following is NOT a goal of the Philippine government’s disaster risk reduction strategy?\na.) Strengthening disaster preparedness\nb.) Enhancing early warning systems\nc.) Promoting economic growth without regulation\nd.) Building resilient communities");
        answers.add("Answer: c.) Promoting economic growth without regulation.");
        explanations.add("Explanation: The goal of the disaster risk reduction strategy is to build resilience and preparedness in communities, not to promote unchecked economic growth.");

        questions.add("The term used to describe the ethical responsibility of corporations to contribute positively to society and the environment is:\na.) Corporate Philanthropy\nb.) Corporate Governance\nc.) Corporate Social Responsibility\nd.) Corporate Accountability");
        answers.add("Answer: c.) Corporate Social Responsibility.");
        explanations.add("Explanation: Corporate Social Responsibility (CSR) refers to the commitment of businesses to act ethically and contribute to social and environmental well-being.");

        questions.add("What is the main purpose of the Data Privacy Act in the Philippines?\na.) To promote data sharing among government agencies\nb.) To protect individual privacy rights and personal data\nc.) To regulate internet usage\nd.) To enhance cyber security");
        answers.add("Answer: b.) To protect individual privacy rights and personal data.");
        explanations.add("Explanation: The Data Privacy Act aims to safeguard personal information and uphold the privacy rights of individuals in the digital age.");

        questions.add("The Philippine government uses this system to ensure transparency and accountability in public procurement:\na.) e-Bidding\nb.) e-Procurement\nc.) Procurement Service\n d.) Budget Management System");
        answers.add("Answer: b.) e-Procurement.");
        explanations.add("Explanation: e-Procurement systems facilitate transparent and efficient procurement processes, ensuring accountability in public spending.");

        questions.add("Which of the following is a key principle of the Clean Water Act?\na.) Protection of water quality\nb.) Promoting industrial waste\nc.) Deregulation of water resources\nd.) Encouraging pollution");
        answers.add("Answer: a.) Protection of water quality.");
        explanations.add("Explanation: The Clean Water Act aims to protect the quality of water resources in the Philippines, ensuring safe and clean water for all.");

        questions.add("Which international agreement aims to combat climate change and its impacts?\na.) Kyoto Protocol\nb.) Paris Agreement\nc.) Montreal Protocol\nd.) Rio Declaration");
        answers.add("Answer: b.) Paris Agreement.");
        explanations.add("Explanation: The Paris Agreement is an international treaty aimed at addressing climate change by limiting global warming and enhancing climate resilience.");

        questions.add("In information technology, what does the term 'phishing' refer to?\na.) A type of malware\nb.) A method of social engineering to deceive users\nc.) A form of data encryption\nd.) A web development technique");
        answers.add("Answer: b.) A method of social engineering to deceive users.");
        explanations.add("Explanation: Phishing is a cyber attack that involves tricking individuals into providing sensitive information, often through fraudulent emails or websites.");



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
