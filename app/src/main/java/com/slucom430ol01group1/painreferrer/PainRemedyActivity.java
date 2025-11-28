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


public class PainRemedyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.pain_remedy_activity);

        Button back_button = findViewById(R.id.back_button);


        back_button.setOnClickListener(v -> {

            finish();

        });


    }

}
