package com.example.myappanimals.settings;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.example.myappanimals.MainActivity;
import com.example.myappanimals.R;

public class SettingsActivity extends AppCompatActivity {
    private ActionBar actionBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            actionBar = getSupportActionBar();
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle(getResources().getString(R.string.action_settings));
        }
        settingsChanges();
        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home)
        {
            Toast.makeText(this, "Настройки сохранены",Toast.LENGTH_SHORT).show();
            this.finish();
            Intent i = new Intent(SettingsActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this, "Настройки сохранены",Toast.LENGTH_SHORT).show();
        this.finish();
        Intent i = new Intent(SettingsActivity.this, MainActivity.class);
        startActivity(i);
    }

    private void settingsChanges() {
        SharedPreferences defPref = PreferenceManager.getDefaultSharedPreferences(this);
            String colorBack = defPref.getString("theme_color", "Black");
            if (colorBack != null) {


                if (colorBack.equals("Серый")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.grey));
                }

                if (colorBack.equals("Коричневый")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.brown));
                }

                if (colorBack.equals("Синий")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.blue));
                }

                if (colorBack.equals("Красный")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.red));
                }

                if (colorBack.equals("Оранжевый")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.orange));
                }

                if (colorBack.equals("Зеленый")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.green));
                }

                if (colorBack.equals("Темно-зеленый")){
                    actionBar.setBackgroundDrawable(getResources().getDrawable(R.color.green_dark));
                }

            }

        }

    }





