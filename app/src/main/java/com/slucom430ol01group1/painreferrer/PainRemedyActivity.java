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
        TextView body_text = findViewById(R.id.body_text);

        Button info_link_text = findViewById(R.id.info_link_text);

        String remedy_type = getIntent().getStringExtra("remedy_type");
        String query = "";

        switch (remedy_type) {

            case ("EXERCISE"):

                header_image.setImageResource(R.drawable.exercise);

                header_text.setText("CALISTHENICS");

                body_text.setText("What are calisthenics?\n" +
                        "Calisthenics is a form of strength training that uses your body weight as a form of resistance to perform full-body exercises. Fitness experts regard calisthenics as an effective way to keep in shape that can help improve strength, endurance, flexibility, and coordination.\n" +
                        "\n" +
                        "Push-ups, sit-ups, and jumping jacks are all calisthenics exercises that you may have been doing since gym class as a kid. Today, popular calisthenics exercises like squats, chin-ups, burpees, and planks have been added to the mix. Calisthenics exercises can range from easy to hard and can be modified as needed to meet your fitness level.");

                info_link_text.setText("FOR MORE INFORMATION FROM HARVARD HEALTH, CLICK HERE");

                query = "https://www.health.harvard.edu/exercise-and-fitness/calisthenics-an-effective-low-frills-way-to-stay-fit";

                break;


            case ("HOT_COLD"):

                header_image.setImageResource(R.drawable.hot_cold);

                header_text.setText("HOT / COLD TREATMENT");

                body_text.setText("Heat therapy helps improves blood flow to the area where the heat is applied. It’s best for muscle pain or stiffness. Cold therapy helps reduce inflammation. It’s most helpful when used for acute injuries and pain.\n" +
                        "\n" +
                        "We treat everything from arthritis to pulled muscles to inflammation with ice packs or heating pads. Treating pain with hot and cold can be extremely effective for a number of different conditions and injuries, and easily affordable.\n" +
                        "\n");

                info_link_text.setText("FOR MORE INFORMATION FROM HEALTHLINE, CLICK HERE");

                query = "https://www.healthline.com/health/chronic-pain/treating-pain-with-heat-and-cold";

                break;


            case ("MASSAGE"):

                header_image.setImageResource(R.drawable.massage);

                header_text.setText("MASSAGE");

                body_text.setText("Self massage techniques are techniques that you can do yourself to get rid of muscle tightness and trigger points throughout your body.\n" +
                        "\n" +
                        "Many self massage techniques can be performed with your fingers, hands, and elbows, while others require simple items such as tennis balls, foam rollers, or trigger point tools such as the Theracane.\n" +
                        "\n");

                info_link_text.setText("FOR MORE INFORMATION FROM BACK INTELLIGENCE, CLICK HERE");

                    query = "https://backintelligence.com/self-massage-techniques/";

                break;


            case ("STRETCHES"):

                header_image.setImageResource(R.drawable.stretch);

                header_text.setText("STRETCHES");

                body_text.setText("It's helpful to include stretching in your exercise plan. Stretching can increase flexibility and improve the range of motion in your joints. Being more flexible can help you move more freely and be better able do daily activities. And the flexibility you gain from stretching might protect you from injury.\n" +
                        "\n" +
                        "Balance exercises, such as balancing on one foot, can help prevent and cut the risk of injury from falls too.");

                info_link_text.setText("FOR MORE INFORMATION FROM MAYO CLINIC, CLICK HERE");

                query = "https://www.mayoclinic.org/healthy-lifestyle/fitness/in-depth/stretching/art-20546848";

                break;

        }


        back_button.setOnClickListener(v -> {

            finish();

        });

        String finalQuery = query;
        info_link_text.setOnClickListener(v -> {

            Intent intent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse(finalQuery));

            v.getContext().startActivity(intent);

        });


    }

}
