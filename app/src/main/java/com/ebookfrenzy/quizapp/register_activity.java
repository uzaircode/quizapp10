package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

public class register_activity extends AppCompatActivity {

    DBHelper DB;
    Button btnRegister;
    TextInputLayout password,username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final ImageView backButton = (ImageView) findViewById(R.id.backButton);

        btnRegister = (Button)findViewById(R.id.buttonRegister);
        username = findViewById(R.id.textInputLayout);
        password = findViewById(R.id.textInputLayoutPassword);
        DB = new DBHelper(this);



        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(register_activity.this, login_activity.class);
                startActivity(intent);
                overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = username.getEditText().getText().toString().trim();
                String pass = password.getEditText().getText().toString().trim();

                if(user.isEmpty() || pass.isEmpty())
                {
                    username.setErrorTextAppearance(R.style.InputError_Purple);
                    username.setError("Please enter a valid email.");
                    password.setErrorTextAppearance(R.style.InputError_Purple);
                    password.setError("Password is required.");
                }
                else {
                    Boolean checkuser = DB.checkusername(user);
                    if(checkuser==false){
                        Boolean insert = DB.insertData(user,pass);
                        if(insert == true) {
                            Intent intent = new Intent(register_activity.this, login_activity.class);
                            startActivity(intent);
                            overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                        } else {
                            Toast.makeText(register_activity.this, "Registered failed", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        username.setErrorTextAppearance(R.style.InputError_Purple);
                        username.setError("Account already exists, please login.");
                    }
                }
            }
        });


    }
}