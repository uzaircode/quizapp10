package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {
    Handler handler;
    Button btnStart;
    EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (Button)findViewById(R.id.start_btn);
        name = findViewById(R.id.name);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(name.length()==0)
                {
                    name.setError("Field can't be empty");
                }
                else {
                    Intent intent = new Intent(MainActivity.this, categories.class);
                    startActivity(intent);
                }
            }
        });
    }

}