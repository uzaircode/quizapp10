package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class categories_activity extends AppCompatActivity {
    private CardView cometsAndMeteor,saveTheEarth,spaceExploration,animals,nutrition,plant,history,geography;
    int correctCategory = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        animals = findViewById(R.id.animals);
        saveTheEarth = findViewById(R.id.saveTheEarth);
        spaceExploration = findViewById(R.id.spaceExploration);
        cometsAndMeteor = findViewById(R.id.cometsAndMeteor);
        nutrition = findViewById(R.id.nutrition);
        plant = findViewById(R.id.plant);
        history = findViewById(R.id.history);
        geography = findViewById(R.id.geography);



        animals.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                correctCategory++;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        saveTheEarth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 2;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        spaceExploration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 3;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        cometsAndMeteor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 4;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        nutrition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 5;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        plant.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 6;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 7;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });

        geography.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                correctCategory = correctCategory + 8;
                Intent intent = new Intent(categories_activity.this, question_activity.class);
                intent.putExtra("category",correctCategory);
                startActivity(intent);
            }
        });
    }
}