package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkModeOn = preferences.getBoolean("dark_mode", false);

        AppCompatDelegate.setDefaultNightMode(
                darkModeOn ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );

        setContentView(R.layout.settings);

        Button back_button = findViewById(R.id.back_button);

        Switch lightDarkSwitch = findViewById(R.id.light_dark_switch);
        lightDarkSwitch.setChecked(darkModeOn);

        lightDarkSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            preferences.edit().putBoolean("dark_mode", isChecked).apply();
            AppCompatDelegate.setDefaultNightMode(
                    isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
            );

            recreate();

        });

        back_button.setOnClickListener(v -> {

            finish();

        });

    }

}

