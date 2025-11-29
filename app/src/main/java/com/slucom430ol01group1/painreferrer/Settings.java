package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        SharedPreferences preferences = getSharedPreferences("settings", MODE_PRIVATE);
        boolean darkModeOn = preferences.getBoolean("dark_mode", true);

        AppCompatDelegate.setDefaultNightMode(
                darkModeOn ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO
        );

        setContentView(R.layout.settings);

        Button back_button = findViewById(R.id.back_button);

        Switch lightDarkSwitch = findViewById(R.id.light_dark_switch);
        lightDarkSwitch.setChecked(darkModeOn);

        Button deleteSavedButton = findViewById(R.id.delete_saved_button);

        Button updateButton = findViewById(R.id.update_database_button);


        updateButton.setOnClickListener(v -> {

            new Thread(() -> {

                try {

                    URL url = new URL("https://drive.google.com/uc?export=download&id=11ps3RnXhg96Bs2qeLgloWV74XKTL1MiB");
                    HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                    conn.setRequestProperty("Cache-Control", "no-cache");
                    conn.connect();

                    InputStream is = conn.getInputStream();

                    File output = new File(getFilesDir(), "weighted_disease_symptoms_dataset.json");
                    FileOutputStream fos = new FileOutputStream(output);

                    byte[] buffer = new byte[4096];
                    int bytesRead;

                    while ((bytesRead = is.read(buffer)) != -1) {

                        fos.write(buffer, 0, bytesRead);

                    }

                    fos.close();
                    is.close();


                    runOnUiThread(() ->

                            Toast.makeText(this, "Database updated!", Toast.LENGTH_SHORT).show()

                    );

                    finish();

                }

                catch (Exception e) {

                    e.printStackTrace();


                    runOnUiThread(() ->

                            Toast.makeText(this, "Update failed: " + e.getMessage(), Toast.LENGTH_LONG).show()

                    );


                }

            }).start();

        });


        lightDarkSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {

            preferences.edit().putBoolean("dark_mode", isChecked).apply();
            AppCompatDelegate.setDefaultNightMode(

                    isChecked ? AppCompatDelegate.MODE_NIGHT_YES : AppCompatDelegate.MODE_NIGHT_NO

            );

            recreate();

        });


        deleteSavedButton.setOnClickListener(v -> {

            AppDatabase db = AppDatabase.getInstance(this);
            db.savedDAO().deleteAll();

            Toast.makeText(this, "Data cleared!", Toast.LENGTH_SHORT).show();

            finish();

        });


        back_button.setOnClickListener(v -> {

            finish();

        });


    }

}

