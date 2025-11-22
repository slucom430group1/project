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

        TextView header_text = findViewById(R.id.header_text);
        String selected_symptom = init_intent.getStringExtra("header_text");

        List<ResultItem> data = new ArrayList<>();

        try {

            if ("SAVED".equals(selected_symptom)) {

                header_text.setText(selected_symptom);

                AppDatabase db = AppDatabase.getInstance(this);
                SavedDAO dao = db.savedDAO();
                List<SavedEntity> savedItems = dao.getAllSaved();

                for (SavedEntity e : savedItems) {

                    data.add(new ResultItem(e.disease, e.painType, 0, 0, 0f));

                }

            }

            else {

                data = JSONParserUtil.getResultsForSymptom(
                        this,
                        "weighted_disease_symptoms_dataset.json",
                        selected_symptom
                );

            }

        }

        catch (Exception e) {

            e.printStackTrace();

        }

        Collections.sort(data, (a, b) -> a.disease.compareToIgnoreCase(b.disease));

        ResultsAdapter adapter = new ResultsAdapter(data);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);

        back_button.setOnClickListener(v -> finish());

    }


    public void removeItemFromList(ResultItem item) {

        RecyclerView recyclerView = findViewById(R.id.results_recyclerView);
        ResultsAdapter adapter = (ResultsAdapter) recyclerView.getAdapter();

        if (adapter != null) {

            adapter.removeItem(item);

        }

    }


    public void refreshSavedItems() {

        AppDatabase db = AppDatabase.getInstance(this);
        List<SavedEntity> saved = db.savedDAO().getAllSaved();

        List<ResultItem> refreshedList = new ArrayList<>();
        for (SavedEntity s : saved) {

            refreshedList.add(new ResultItem(s.disease, s.painType, 0, 0, 0));

        }

        RecyclerView recyclerView = findViewById(R.id.results_recyclerView);
        ResultsAdapter adapter = new ResultsAdapter(refreshedList);
        recyclerView.setAdapter(adapter);

    }




}
