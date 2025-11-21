package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SearchResults extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_results);

        Intent init_intent = getIntent();

        RecyclerView recyclerView = findViewById(R.id.results_recyclerView);

        Button back_button = findViewById(R.id.back_button);
        Button saved_button = findViewById(R.id.saved_button);

        String selected_symptom = init_intent.getStringExtra("search_text");


        List<ResultItem> data = new ArrayList<>();
        try {

            data = JSONParserUtil.getResultsForSymptom(this, "weighted_disease_symptoms_dataset.json", selected_symptom);

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        System.out.println("Result count: " + data.size());
        ResultsAdapter adapter = new ResultsAdapter(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);



        back_button.setOnClickListener(v -> {

            finish();

        });

        saved_button.setOnClickListener(v -> {

            // ⚠️⚠️⚠️⚠️⚠️⚠️⚠️
            // Intent intent = new Intent(SearchResults.this, SearchResults.class);
            recreate();

        });

    }

}
