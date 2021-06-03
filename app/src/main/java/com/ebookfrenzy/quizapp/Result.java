package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class Result extends AppCompatActivity {

    CircularProgressBar circularProgressBar;
    TextView resultText,correctCount,wrongCount,unattemptedCount,streakCount,name;
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
        setContentView(R.layout.activity_result);

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


        resultText.setText((((correct*10)/5) * 10)+"%");

        play_again = (Button)findViewById(R.id.play_again);

        song = MediaPlayer.create(Result.this,R.raw.resultsound);
        song.setLooping(true);
        song.start();


        play_again.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent intent = new Intent(Result.this, MainActivity.class);
            song.stop();
            startActivity(intent);
        }
    });

    }
}