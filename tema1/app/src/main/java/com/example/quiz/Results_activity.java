package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Results_activity extends AppCompatActivity {

    private TextView textview;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results_activity);

        textview = findViewById(R.id.Sicu_Bogdan_Andrei_textView);
        intent = getIntent();
        int scorul =  intent.getIntExtra("scor",0);
        String initial = textview.getText().toString();
        initial = initial+" your score is "+scorul +"/5";
        textview.setText(initial);
    }
}