package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button buttonQuiz;
    private Button buttonResults;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonQuiz = findViewById(R.id.Sicu_Bogdan_Andrei_startQuiz_btn);
        buttonQuiz.setVisibility(View.VISIBLE);
        buttonQuiz.setBackgroundColor(Color.TRANSPARENT);
        buttonQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openQuiz();
            }
        });

    }

    public void openQuiz(){
        Intent intent = new Intent(this, Intrebare.class);
        startActivity(intent);
    }

    public void openResults(){
        Intent intent = new Intent(this, Results_activity.class);
        startActivity(intent);
    }
}