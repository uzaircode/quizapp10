package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.sasank.roundedhorizontalprogress.RoundedHorizontalProgressBar;

import java.util.ArrayList;
import java.util.List;

public class question extends AppCompatActivity implements View.OnClickListener {

    TextView question,qCount,correctCategory;
    private Button option1, option2, option3, option4;
    private List<QuestionClass> questionList;
    private int quesNum;
    CountDownTimer countDown;
    RoundedHorizontalProgressBar progressBar;
    int correctCount = 0;
    int wrongCount = 0;
    int timerValue = 21;
    int unattemptedCount = 0;
    int streakCount = 0;
    int category;
    MediaPlayer song,correctSound,wrongSound;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question2);

        category = getIntent().getIntExtra("category",0);



        question = findViewById(R.id.question);
        qCount = findViewById(R.id.quest_num);
        progressBar = findViewById(R.id.countDown);

        option1 = findViewById(R.id.option1);
        option2 = findViewById(R.id.option2);
        option3 = findViewById(R.id.option3);
        option4 = findViewById(R.id.option4);

        option1.setOnClickListener(this);
        option2.setOnClickListener(this);
        option3.setOnClickListener(this);
        option4.setOnClickListener(this);

        song = MediaPlayer.create(question.this,R.raw.songtheme);
        correctSound = MediaPlayer.create(question.this,R.raw.correctsound);
        wrongSound = MediaPlayer.create(question.this,R.raw.wrongsound);


        song.setLooping(true);
        song.start();


        if(category == 1) {
            getQuestionList1();
        }
        else if(category == 2) {
            getQuestionList2();
        }
        else if(category == 3) {
            getQuestionList3();
        }
        else if(category == 4) {
            getQuestionList4();
        }
        else if(category == 5) {
            getQuestionList5();
        }
        else if(category == 6) {
            getQuestionList6();
        }
        else if(category == 7) {
            getQuestionList7();
        }
        else if(category == 8) {
            getQuestionList8();
        }

    }
    private void getQuestionList1() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("What’s the first thing a caterpillar usually eats after it’s born?", "Other bugs", "Grass", "It own eggshell", "Rendang ayam crispy", 3));
        questionList.add(new QuestionClass("Why are sloths so slow?", "Laziness", "Bad joints", "Defense habit", "Slow metabolism", 4));
        questionList.add(new QuestionClass("An ant says, “Danger ahead!” by doing what?", "Squealing", "Running toward water", "Rolling on its back", "Oozing chemicals", 4));
        questionList.add(new QuestionClass("Why do owls turn their heads when they look around?", "They use feathers to feel the air", "Due to their widely-set nostrils", "For good hearing", "Their eyeballs can't move", 3));
        questionList.add(new QuestionClass("How do flies avoid your swat attack?", "They have a danger sense", "Everything is in slow motion", "They can see movement well", "They sense vibrations", 2));

        setQuestion();
    }

    private void getQuestionList2() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("How long does it take for plastic to decompose?", "450 Years", "45 Years", "120 Years", "15 Years", 1));
        questionList.add(new QuestionClass("Which of these species are threatened by global warming?", "Koala", "Clownfish", "Arctic fox", "All of the above", 4));
        questionList.add(new QuestionClass("What is most frequently found in beach cleanups?", "Glass", "Shoes", "Pieces of plastic", "Jewelry", 3));
        questionList.add(new QuestionClass("Paper can be made from which of these materials?", "Panda poop", "Hemp", "Wood", "All of the above", 4));
        questionList.add(new QuestionClass("Which is the greenest form of transportation?", "Car", "Bicycle", "Bus", "Train", 2));

        setQuestion();
    }

    private void getQuestionList3() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("Sometime in the near future, NASA plans to extend human space travel to", "Find liquid on Europa", "Live on the Moon", "Orbit the Sun", "Explore Mars", 4));
        questionList.add(new QuestionClass("This is the only planet with liquid water on its surface.", "Mercury", "Earth", "Venus", "Mars", 2));
        questionList.add(new QuestionClass("The space mission that resulted in the first humans stepping onto the Moon was the", "Attica 13", "Odyssey", "Apollo 11", "Koro 77", 3));
        questionList.add(new QuestionClass("What was the first creature in space?","Dog", "Human", "Hamster", "Monkey", 1));
        questionList.add(new QuestionClass("The rotation of Earth on its axis causes the pattern of", "Night and Day", "Constellations", "Earth's seasons", "The phases of the moon", 1));

        setQuestion();
    }

    private void getQuestionList4() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("Which of the following did people used to think seeing a comet signified?", "Disaster", "Disease", "Death", "All of the above", 4));
        questionList.add(new QuestionClass("What is the bright glow around the “head” of a comet called?", "Ring", "Coma", "Halo", "Crown", 2));
        questionList.add(new QuestionClass("Piece of rock that burns up as it passes through the earth's atmosphere.", "Asteroid", "Meteoroid", "Comet", "Meteor", 1));
        questionList.add(new QuestionClass("What is the scientific name for a shooting star?", "Comet", "Meteor", "Asteroid", "Falling star", 2));
        questionList.add(new QuestionClass("When a meteoroid strikes the surface of the earth scientists refer to them as:", "Asteroids", "Comets", "Meteors", "Meteorites", 4));


        setQuestion();
    }

    private void getQuestionList5() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("The main function of carbohydrates is to", "Help bones form", "Provide energy", "Make muscles", "Insulate the body", 2));
        questionList.add(new QuestionClass("Which one of the following is NOT a function of water in the human body?", "It transports nutrients around the body", "Helps in the formation of bones", "It regulates body temperature", "Helps eliminate wastes", 2));
        questionList.add(new QuestionClass("Males usually require more energy than females because they tend to be more", "Tend to have more muscle", "Aggressive", "Sleepy", "Active", 1));
        questionList.add(new QuestionClass("Which one of the following types of food is needed for growth and tissue repair", "Fibre", "Protein", "Water", "Carbohydrates", 2));
        questionList.add(new QuestionClass("How can a lack of carbohydrates affect performance?", "No energy stores for endurance events", "Body will turn to use water storage instead", "Increase building of the muscles", "fasten the repair of tissues ", 1));

        setQuestion();
    }

    private void getQuestionList6() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("How can you tell how old a tree is?", "By counting the number of rings in its trunk", "By counting its leaves", "By measuring its height", "By counting its branches", 1));
        questionList.add(new QuestionClass("What is the actual reason a plant or flower may smell so nice?", "So they're good for making potpourri", "To repel insects and birds", "To attract pollinators", "To attract birds and mammals", 3));
        questionList.add(new QuestionClass("What is the basic difference between a fruit and a vegetable?", "They aren't green", "hey have seeds", "They grow on a vine", "They are sweet", 2));
        questionList.add(new QuestionClass("Paper didn't always come from trees! What plant did it originally come from?", "Dracena", "Nut grass", "Wheat", "Papyrus", 4));
        questionList.add(new QuestionClass("Why are cotton plants so important?", "Easy break apart and turn to different products", "It is useful in insulating homes", "All parts of the plant are useful", "It is used to make clothes", 3));

        setQuestion();
    }

    private void getQuestionList7() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("Korea was split into North Korea and South Korea at the conclusion of which war?", "World War One", "World War Two", "Vietnam War", "Korean War", 2));
        questionList.add(new QuestionClass("In which ocean did the Titanic sink?", "Pacific Ocean", "Indian Ocean", "Atlantic Ocean", "Arctic Ocean", 3));
        questionList.add(new QuestionClass("What was the first foreign power that occupy Malay Peninsula?", "Portuguese", "British", "Dutch", "Japanese", 1));
        questionList.add(new QuestionClass("Who invented the first successful aeroplane?", "Orville and Wilbur Wright", "Guglielmo Marconi", "John Logie Baird", "Karl Benz", 1));
        questionList.add(new QuestionClass("The first person to travel into space was from which country?", "America", "Ukraine", "Germany", "Russia", 4));

        setQuestion();
    }

    private void getQuestionList8() {
        questionList = new ArrayList<>();

        questionList.add(new QuestionClass("Which of these is not a continent?", "Alaska", "South America", "Antartica", "Africa", 1));
        questionList.add(new QuestionClass("Which is the tallest mountain on Earth?", "Mount Washington", "Mount Whitney", "Mount Everest", "Mount St. Helens", 3));
        questionList.add(new QuestionClass("Which is the tallest waterfall in the world?", "Victoria Falls", "Yosemite Falls", "Niagara Falls", "Angel Falls", 4));
        questionList.add(new QuestionClass("Which is the largest river in the world?", "Amazon River", "Yellow River", "Nile", "Yangtze", 3));
        questionList.add(new QuestionClass("How many continents are there in the world?", "5", "7", "6", "8", 2));

        setQuestion();
    }


    private void setQuestion() {

        question.setText(questionList.get(0).getQuestion());
        option1.setText(questionList.get(0).getOptionA());
        option2.setText(questionList.get(0).getOptionB());
        option3.setText(questionList.get(0).getOptionC());
        option4.setText(questionList.get(0).getOptionD());

        qCount.setText(String.valueOf(1) + "/" + String.valueOf(questionList.size()));

        startTimer();

        quesNum = 0;

    }

    private void startTimer() {
        timerValue = 21;
        progressBar.setProgress(timerValue);

        countDown = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timerValue=timerValue-1;
                progressBar.setProgress(timerValue);
            }

            @Override
            public void onFinish() {
                unattemptedCount++;
                wrongCount++;
                changeQuestion();
            }
        };
        countDown.start();
    }


    @Override
    public void onClick(View v) {

        int selectedOption = 0;

        switch (v.getId()) {
            case R.id.option1:
                selectedOption = 1;
                break;

            case R.id.option2:
                selectedOption = 2;
                break;

            case R.id.option3:
                selectedOption = 3;
                break;

            case R.id.option4:
                selectedOption = 4;
                break;

            default:
        }

        countDown.cancel();
        checkAnswer(selectedOption, v);
    }

    private void checkAnswer(int selectedOption, View view) {

        if(selectedOption == questionList.get(quesNum).getCorrectAns()) {

            option1.setEnabled(false);
            option1.setVisibility(Button.INVISIBLE);
            option1.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));

            option2.setEnabled(false);
            option2.setVisibility(Button.INVISIBLE);
            option2.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));

            option3.setEnabled(false);
            option3.setVisibility(Button.INVISIBLE);
            option3.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));

            option4.setEnabled(false);
            option4.setVisibility(Button.INVISIBLE);
            option4.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));

            ((Button)view).setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#61c270")));
            ((Button)view).setVisibility(Button.VISIBLE);

            correctCount++;
            streakCount++;
            correctSound.start();

        } else if(selectedOption != questionList.get(quesNum).getCorrectAns()) {

            wrongCount++;
            wrongSound.start();
            streakCount = 0;

            ((Button)view).setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#e63946")));
            ((Button)view).setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));

            switch(questionList.get(quesNum).getCorrectAns()) {
                case 1:
                    option1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#61c270")));
                    option1.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    option1.setEnabled(false);

                    option2.setVisibility(Button.INVISIBLE);
                    option2.setEnabled(false);

                    option3.setVisibility(Button.INVISIBLE);
                    option3.setEnabled(false);

                    option4.setVisibility(Button.INVISIBLE);
                    option4.setEnabled(false);

                    break;
                case 2:
                    option2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#61c270")));
                    option2.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    option2.setEnabled(false);

                    option1.setVisibility(Button.INVISIBLE);
                    option1.setEnabled(false);

                    option3.setVisibility(Button.INVISIBLE);
                    option3.setEnabled(false);

                    option4.setVisibility(Button.INVISIBLE);
                    option4.setEnabled(false);

                    break;
                case 3:
                    option3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#61c270")));
                    option3.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    option3.setEnabled(false);

                    option1.setVisibility(Button.INVISIBLE);
                    option1.setEnabled(false);

                    option2.setVisibility(Button.INVISIBLE);
                    option2.setEnabled(false);

                    option4.setVisibility(Button.INVISIBLE);
                    option4.setEnabled(false);

                    break;
                case 4:
                    option4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#61c270")));
                    option4.setTextColor(ColorStateList.valueOf(Color.parseColor("#FFFFFF")));
                    option4.setEnabled(false);

                    option1.setVisibility(Button.INVISIBLE);
                    option1.setEnabled(false);

                    option2.setVisibility(Button.INVISIBLE);
                    option2.setEnabled(false);

                    option3.setVisibility(Button.INVISIBLE);
                    option3.setEnabled(false);

                    break;
            }
        }
        ((Button)view).setVisibility(Button.VISIBLE);
        changeQuestion();
    }

    private void changeQuestion() {

        progressBar.setProgress(0);

        if (quesNum < questionList.size() - 1) {
            quesNum++;
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    option1.setEnabled(true);
                    option2.setEnabled(true);
                    option3.setEnabled(true);
                    option4.setEnabled(true);

                    option1.setVisibility(Button.VISIBLE);
                    option2.setVisibility(Button.VISIBLE);
                    option3.setVisibility(Button.VISIBLE);
                    option4.setVisibility(Button.VISIBLE);


                    option1. setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2596be")));
                    option2. setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#2d9ea6")));
                    option3. setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#efa928")));
                    option4. setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#d4536d")));

                    qCount.setText(String.valueOf(quesNum+1) + "/" + String.valueOf(questionList.size()));
                    startTimer();
                }
            }, 3450); // 1 sec delay
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    loadQuestions(quesNum);
                }
            }, 3450); // 1 sec delay

        } else {
            //Go to Score Activity
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(question.this,Result.class);
                    song.stop();
                    intent.putExtra("correct",correctCount);
                    intent.putExtra("wrong",wrongCount);
                    intent.putExtra("unattempted",unattemptedCount);
                    intent.putExtra("streak",streakCount);
                    startActivity(intent);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                }
            }, 3450);
        }
    }

    private void loadQuestions(int n) {
        final QuestionClass q = questionList.get(n);

        question.setText(q.getQuestion());
        option1.setText(q.getOptionA());
        option2.setText(q.getOptionB());
        option3.setText(q.getOptionC());
        option4.setText(q.getOptionD());

        }

    }