package com.example.myappanimals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;




public class Text_Content_Activity extends AppCompatActivity {

    private int category = 0;
    private int position = 0;

    private TextView textContent;
    private ImageView image;

    private ActionBar actionBar;

    private LinearLayout L;


    private final int[] arrWild = {R.string.hare, R.string.moose};
    private final int[] arrWild_P = {R.drawable.hare, R.drawable.moose};


    private final int[] arrPredators = {R.string.wolf, R.string.fox};
    private final int[] arrPredators_P = {R.drawable.wolf, R.drawable.fox};


    private final int[] arrBirds = {R.string.hen, R.string.turkey};
    private final int[] arrBirds_P = {R.drawable.rooster, R.drawable.turkey};


    private final int[] arrHoofed = {R.string.cow, R.string.pig};
    private final int[] arrHoofed_P = {R.drawable.cow, R.drawable.pig};

    private final int[] arrRedMammals = {R.string.wolverine};
    private final int[] arrRedMammals_P = {R.drawable.wolverine};


    private final int[] arrRedFish = {R.string.sturgeon};
    private final int[] arrRedFish_P = {R.drawable.sterlet};


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.text_content);
        init();
        receiveIntent();
        settingsChanges();
    }

    private void init() {

        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        textContent = findViewById(R.id.text_content_main);
        textContent.setTextColor(getResources().getColor(R.color.grey));
        image = findViewById(R.id.type_image);
        L = findViewById(R.id.bottom_square);
    }


    private void receiveIntent() {
        Intent in = getIntent();
        if (in != null) {
            category = in.getIntExtra("category", 0);
            position = in.getIntExtra("position", 0);
        }

        if (category == 0){
            textContent.setText(arrWild[position]);
            image.setImageResource(arrWild_P[position]);
            actionBar.setTitle(getResources().getStringArray(R.array.arr_wild_mammals)[position]);
        }

        if (category == 1){
            textContent.setText(arrPredators[position]);
            image.setImageResource(arrPredators_P[position]);
            actionBar.setTitle(getResources().getStringArray(R.array.arr_wild_predators)[position]);
        }

        if (category == 2){
            textContent.setText(arrBirds[position]);
            image.setImageResource(arrBirds_P[position]);
            actionBar.setTitle(getResources().getStringArray(R.array.arr_dom_birds)[position]);
        }

        if (category == 3){
            textContent.setText(arrHoofed[position]);
            image.setImageResource(arrHoofed_P[position]);
            actionBar.setTitle(getResources().getStringArray(R.array.arr_dom_hoofed)[position]);
        }

        if (category == 4){
            textContent.setText(arrRedMammals[position]);
            image.setImageResource(arrRedMammals_P[position]);
            actionBar.setTitle(getResources().getStringArray(R.array.arr_red_mammals)[position]);
        }

        if (category == 5){
            textContent.setText(arrRedFish[position]);
            image.setImageResource(arrRedFish_P[position]);
            actionBar.setTitle(getResources().getStringArray(R.array.arr_red_fish)[position]);
        }
    }

    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void settingsChanges() {
        SharedPreferences defPref = PreferenceManager.getDefaultSharedPreferences(this);
        String text = defPref.getString("main_text_size", "Medium");
        if (text != null) {

           if (text.equals("Большой")){
               textContent.setTextSize(25);
           }

            if (text.equals("Средний")){
                textContent.setTextSize(20);
            }

            if (text.equals("Маленький")){
                textContent.setTextSize(15);
            }
        }

        String color = defPref.getString("main_text_color", "Grey");
        if (color != null) {

            if (color.equals("Серый")){
                textContent.setTextColor(getResources().getColor(R.color.grey));
            }

            if (color.equals("Черный")){
                textContent.setTextColor(getResources().getColor(R.color.black));
            }

            if (color.equals("Коричневый")){
                textContent.setTextColor(getResources().getColor(R.color.brown));
            }

            if (color.equals("Зеленый")){
                textContent.setTextColor(getResources().getColor(R.color.green));
            }

            if (color.equals("Темно-зеленый")){
                textContent.setTextColor(getResources().getColor(R.color.green_dark));
            }

                String colorBack = defPref.getString("theme_color", "Black");
                if (colorBack != null) {

                    if (colorBack.equals("Серый")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.grey));
                        L.setBackgroundColor(getResources().getColor(R.color.grey));
                    }


                    if (colorBack.equals("Коричневый")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.brown));
                        L.setBackgroundColor(getResources().getColor(R.color.brown));
                    }

                    if (colorBack.equals("Синий")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.blue));
                        L.setBackgroundColor(getResources().getColor(R.color.blue));
                    }

                    if (colorBack.equals("Красный")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.red));
                        L.setBackgroundColor(getResources().getColor(R.color.red));
                    }

                    if (colorBack.equals("Оранжевый")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.orange));
                        L.setBackgroundColor(getResources().getColor(R.color.orange));
                    }

                    if (colorBack.equals("Зеленый")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.green));
                        L.setBackgroundColor(getResources().getColor(R.color.green));
                    }

                    if (colorBack.equals("Темно-зеленый")){
                        actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.green_dark));
                        L.setBackgroundColor(getResources().getColor(R.color.green_dark));
                    }
                }

            }
        }
    }


