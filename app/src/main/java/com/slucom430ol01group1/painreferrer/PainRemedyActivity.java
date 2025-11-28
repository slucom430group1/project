package com.slucom430ol01group1.painreferrer;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
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

        ImageView header_image = findViewById(R.id.header_image);
        TextView header_text = findViewById(R.id.header_text);

        TextView info_link_text = findViewById(R.id.info_link_text);





        String remedy_type = getIntent().getStringExtra("remedy_type");

        switch (remedy_type) {

            case ("EXERCISE"):

                header_image.setImageResource(R.drawable.exercise);

                break;


            case ("HOT_COLD"):

                header_image.setImageResource(R.drawable.hot_cold);

                break;


            case ("MASSAGE"):

                header_image.setImageResource(R.drawable.massage);

                break;


            case ("STRETCHES"):

                header_image.setImageResource(R.drawable.stretch);

                break;

        }


        back_button.setOnClickListener(v -> {

            finish();

        });

        info_link_text.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://google.com/"));

            v.getContext().startActivity(intent);

        });


    }

}
