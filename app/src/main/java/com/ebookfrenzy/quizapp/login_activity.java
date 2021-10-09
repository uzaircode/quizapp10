package com.ebookfrenzy.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;


public class login_activity extends AppCompatActivity {

    DBHelper DB;
    Button btnStart;
    TextInputLayout username,password;

    EditText name;
    SharedPreferences sp;
    String nameStr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_HIDDEN);


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        final TextView SignUp = (TextView) findViewById(R.id.SignUp);
        username = findViewById(R.id.username1);
        password = findViewById(R.id.password1);
        btnStart = (Button)findViewById(R.id.start_btn);
        DB = new DBHelper(this);

        name = findViewById(R.id.name);

        sp = getSharedPreferences("MyUserPrefs", Context.MODE_PRIVATE);



        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String pass = password.getEditText().getText().toString().trim();
                String user = username.getEditText().getText().toString().trim();


                if(pass.isEmpty() || user.isEmpty())
                {
                    username.setErrorTextAppearance(R.style.InputError_Purple);
                    username.setError("Username is required.");
                    password.setErrorTextAppearance(R.style.InputError_Purple);
                    password.setError("Password is required.");
                }
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(user,pass);
                    if(checkuserpass == true) {
                        nameStr = name.getText().toString();
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString("name",nameStr);
                        editor.commit();
                        Intent intent = new Intent(login_activity.this, categories_activity.class);
                        startActivity(intent);
                    }else{
                        username.setError("Username is invalid.");
                        password.setError("Password is invalid.");
                    }
                }
            }
        });

        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View  view) {
                Intent intent = new Intent(login_activity.this, register_activity.class);
                startActivity(intent);
            }
        });
    }

}