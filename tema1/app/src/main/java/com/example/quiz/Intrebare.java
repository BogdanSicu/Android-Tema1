package com.example.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Random;

public class Intrebare extends AppCompatActivity  {

    private Button quitAndSave;
    private Button raspuns1;
    private Button raspuns2;
    private Button raspuns3;
    private Button raspuns4;
    public static ArrayList<Material_Intrebare> lista = new ArrayList<Material_Intrebare>();
    public static ArrayList<Button> butoane;
    public static int numarul_intrebarii = 0;
    public static int scor = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intrebare);

        Material_Intrebare intrebare1 = new Material_Intrebare("koala", "urs brun", "wombat","capybara");
        lista.add(intrebare1);
        Material_Intrebare intrebare2 = new Material_Intrebare("okapi", "zebra", "caprioara","girafa");
        lista.add(intrebare2);
        Material_Intrebare intrebare3 = new Material_Intrebare("skink", "dragon de apa austalian", "varan de desert","agama");
        lista.add(intrebare3);
        Material_Intrebare intrebare4 = new Material_Intrebare("tucan", "zebra", "caprioara","girafa");
        lista.add(intrebare4);
        Material_Intrebare intrebare5 = new Material_Intrebare("leu", "pantera", "tigru","hiena");
        lista.add(intrebare5);

        quitAndSave =findViewById(R.id.Sicu_Bogdan_Andrei_quit_and_save_btn);
        quitAndSave.setVisibility(View.VISIBLE);
        quitAndSave.setBackgroundColor(Color.TRANSPARENT);

        quitAndSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                quit_and_save();
            }
        });


        butoane = new ArrayList<Button>();

        raspuns1 = findViewById(R.id.Sicu_Bogdan_Andrei_answer1_btn);
        raspuns2 = findViewById(R.id.Sicu_Bogdan_Andrei_answer2_btn);
        raspuns3 = findViewById(R.id.Sicu_Bogdan_Andrei_answer3_btn);
        raspuns4 = findViewById(R.id.Sicu_Bogdan_Andrei_answer4_btn);

        butoane.add(raspuns1);
        butoane.add(raspuns2);
        butoane.add(raspuns3);
        butoane.add(raspuns4);

        Random(lista.get(numarul_intrebarii), butoane);

        raspuns1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apasat_buton(lista.get(numarul_intrebarii),R.id.Sicu_Bogdan_Andrei_answer1_btn);
            }
        });

        raspuns2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apasat_buton(lista.get(numarul_intrebarii),R.id.Sicu_Bogdan_Andrei_answer2_btn);
            }
        });

        raspuns3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apasat_buton(lista.get(numarul_intrebarii),R.id.Sicu_Bogdan_Andrei_answer3_btn);
            }
        });

        raspuns4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                apasat_buton(lista.get(numarul_intrebarii),R.id.Sicu_Bogdan_Andrei_answer4_btn);
            }
        });


    }

    public void quit_and_save(){
        Intent intent = new Intent(this, Results_activity.class);
        intent.putExtra("scor", scor);
        startActivity(intent);
    }

    public void Random(Material_Intrebare obiect, ArrayList<Button> buttons){

            ImageView imageView = findViewById(R.id.Sicu_Bogdan_Andrei_image_question);

            Resources res = getResources();
            int resourceId = res.getIdentifier(
                    obiect.raspunsCorect, "drawable", getPackageName() );
            imageView.setImageResource( resourceId );

            ArrayList<String> stringuri = new ArrayList<>();
            stringuri.add(obiect.raspunsCorect);
            stringuri.add(obiect.raspuns1);
            stringuri.add(obiect.raspuns2);
            stringuri.add(obiect.raspuns3);

            int s=4;

            while(!stringuri.isEmpty()){
                Random dice = new Random();
                int iteratie_string = dice.nextInt(s);
                int iteratie_butoane = dice.nextInt(s);
                buttons.get(iteratie_butoane).setText(stringuri.get(iteratie_string));

                stringuri.remove(iteratie_string);
                buttons.remove(iteratie_butoane);
                s--;
            }
        }



    public void apasat_buton(Material_Intrebare intrebare, int nush){
        Button auxiliar = findViewById(nush);
        if(auxiliar.getText()==intrebare.raspunsCorect){
            scor++;
        }
        butoane.add(raspuns1);
        butoane.add(raspuns2);
        butoane.add(raspuns3);
        butoane.add(raspuns4);

        numarul_intrebarii++;
        if(numarul_intrebarii<5) {
            Random(lista.get(numarul_intrebarii), butoane);
        }
        else{
            numarul_intrebarii=0;
            int auxi = scor;
            scor=0;
            Intent intent = new Intent(this, Results_activity.class);
            intent.putExtra("scor", auxi);
            startActivity(intent);

        }

    }
}
