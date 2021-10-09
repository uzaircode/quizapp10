package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;
import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class summary_activity extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText,correctCount,wrongCount,unattemptedCount,streakCount,text_name,new_quiz;
    int correct;
    int wrong;
    int unattempted;
    int streak;
    Button play_again;
    MediaPlayer song;






    @SuppressLint({"WrongViewCast", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_summary);

        DBHelper helper = new DBHelper(this);


        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        unattempted = getIntent().getIntExtra("unattempted",0);
        streak = getIntent().getIntExtra("streak",0);
        circularProgressBar = findViewById(R.id.circularProgressBar);
        resultText = findViewById(R.id.resultText);
        circularProgressBar.setProgress(correct);
        correctCount = findViewById(R.id.correctCount);
        wrongCount = findViewById(R.id.wrongCount);
        streakCount = findViewById(R.id.streakCount);
        unattemptedCount =  findViewById(R.id.unattemptedCount);
        correctCount.setText(correct+"/5\nCorrect");
        wrongCount.setText(wrong+"/5\nIncorrect");
        unattemptedCount.setText(unattempted+"/5\nUnattempted");
        streakCount.setText(streak+"/5\nStreak");

        TextView t1;
        t1=findViewById(R.id.name1);

        SharedPreferences sp = getApplicationContext().getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);
        String name = sp.getString("name","");
        t1.setText("Congratulations, "+name);


        resultText.setText((((correct*10)/5) * 10)+"%");

        play_again = (Button)findViewById(R.id.play_again);
        new_quiz = (Button)findViewById(R.id.new_quiz);


        song = MediaPlayer.create(summary_activity.this,R.raw.resultsound);
        song.setLooping(true);
        song.start();


        play_again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(summary_activity.this, question_activity.class);
                song.stop();
                startActivity(intent);
            }
        });

        new_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(summary_activity.this, categories_activity.class);
                song.stop();
                startActivity(intent);
            }
        });
    }
}