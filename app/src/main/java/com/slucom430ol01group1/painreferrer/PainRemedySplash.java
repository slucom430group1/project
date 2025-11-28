package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class PainRemedySplash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pain_remedy_splash);

        Button back_button = findViewById(R.id.back_button);

        ImageButton exercise_button = findViewById(R.id.exercise_button);
        ImageButton hot_cold_button = findViewById(R.id.hot_cold_button);
        ImageButton massage_button = findViewById(R.id.massage_button);
        ImageButton stretches_button = findViewById(R.id.stretches_button);


        back_button.setOnClickListener(v -> {

            finish();

        });


        exercise_button.setOnClickListener(v -> {

            Intent intent = new Intent(PainRemedySplash.this, PainRemedyActivity.class);
            intent.putExtra("remedy_type", "EXERCISE");

            startActivity(intent);

        });


        hot_cold_button.setOnClickListener(v -> {

            Intent intent = new Intent(PainRemedySplash.this, PainRemedyActivity.class);
            intent.putExtra("remedy_type", "HOT_COLD");

            startActivity(intent);

        });


        massage_button.setOnClickListener(v -> {

            Intent intent = new Intent(PainRemedySplash.this, PainRemedyActivity.class);
            intent.putExtra("remedy_type", "MASSAGE");

            startActivity(intent);

        });


        stretches_button.setOnClickListener(v -> {

            Intent intent = new Intent(PainRemedySplash.this, PainRemedyActivity.class);
            intent.putExtra("remedy_type", "STRETCHES");

            startActivity(intent);


        });


    }

}

