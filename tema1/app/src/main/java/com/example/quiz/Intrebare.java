package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Intrebare extends AppCompatActivity {

    private Button quitAndSave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrebare);

        quitAndSave =findViewById(R.id.quit_and_save_btn);
        quitAndSave.setVisibility(View.VISIBLE);
        quitAndSave.setBackgroundColor(Color.TRANSPARENT);

        quitAndSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit_and_save();
            }
        });
    }

    public void quit_and_save(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}