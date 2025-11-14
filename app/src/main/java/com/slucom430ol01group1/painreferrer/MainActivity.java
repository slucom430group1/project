package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button settings_button = findViewById(R.id.settings_button);

        settings_button.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Settings.class);
            startActivity(intent);

        });

    }

}

