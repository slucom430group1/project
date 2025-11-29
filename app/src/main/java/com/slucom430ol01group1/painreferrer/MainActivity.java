package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button settings_button = findViewById(R.id.settings_button);
        Button saved_button = findViewById(R.id.saved_button);

        Spinner search_spinner = findViewById(R.id.search_spinner);
        Button search_button = findViewById(R.id.search_button);

        Button pain_remedy_guide_button = findViewById(R.id.pain_remedy_guide_button);

        populateSpinner();

        settings_button.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, Settings.class);

            startActivity(intent);

        });

        saved_button.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SearchResults.class);
            intent.putExtra("header_text", "SAVED");

            startActivity(intent);

        });

        search_button.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, SearchResults.class);
            intent.putExtra("header_text", search_spinner.getSelectedItem().toString());

            startActivity(intent);

        });

        pain_remedy_guide_button.setOnClickListener(v -> {

            Intent intent = new Intent(MainActivity.this, PainRemedySplash.class);

            startActivity(intent);

        });

    }

    @Override
    protected void onResume() {

        super.onResume();

        populateSpinner();

    }

    public void populateSpinner() {

        Spinner search_spinner = findViewById(R.id.search_spinner);

        try {

            List<String> symptomNames = JSONParserUtil.getSymptoms(this, "weighted_disease_symptoms_dataset.json");
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, symptomNames);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

            search_spinner.setAdapter(adapter);

        }

        catch (IOException e) {

            e.printStackTrace();

            Toast.makeText(this, "Error loading JSON", Toast.LENGTH_LONG).show();

        }

        catch (JSONException e) {

            throw new RuntimeException(e);

        }

    }

}

