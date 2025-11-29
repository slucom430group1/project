package com.slucom430ol01group1.painreferrer;

import android.content.Context;

import org.json.JSONObject;
import org.json.JSONException;
import java.io.*;
import java.util.*;

public class JSONParserUtil {

    public static JSONObject loadJson(Context context, String fileName) throws IOException, JSONException {

        File localFile = new File(context.getFilesDir(), fileName);

        InputStream is;
        if (localFile.exists()) {

            is = new FileInputStream(localFile);

        }

        else {

            is = context.getAssets().open(fileName);

        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line;
        while ((line = reader.readLine()) != null) {

            sb.append(line);

        }

        reader.close();

        return new JSONObject(sb.toString());

    }


    public static List<String> getSymptoms(Context context, String assetFileName) throws IOException, JSONException {

        JSONObject diseases = loadJson(context, assetFileName);
        HashSet<String> symptoms = new HashSet<>();

        Iterator<String> diseaseKeys = diseases.keys();
        while (diseaseKeys.hasNext()) {

            JSONObject diseaseObj = diseases.getJSONObject(diseaseKeys.next());
            Iterator<String> symptomKeys = diseaseObj.keys();

            while (symptomKeys.hasNext()) {

                String key = symptomKeys.next();
                if (!key.equalsIgnoreCase("n_samples")) {

                    symptoms.add(key);

                }

            }

        }

        List<String> list = new ArrayList<>(symptoms);
        Collections.sort(list);

        return list;

    }

    public static List<ResultItem> getResultsForSymptom(Context context, String assetFileName, String symptom)
            throws IOException, JSONException {

        JSONObject diseases = loadJson(context, assetFileName);
        List<ResultItem> results = new ArrayList<>();

        Iterator<String> diseaseKeys = diseases.keys();
        while (diseaseKeys.hasNext()) {

            String disease = diseaseKeys.next();
            JSONObject diseaseObj = diseases.getJSONObject(disease);

            if (diseaseObj.has(symptom)) {

                int count = diseaseObj.optInt(symptom, 0);
                int nSamples = diseaseObj.optInt("n_samples", 0);

                if (count > 0) {

                    float percent = nSamples > 0 ? (100.0f * count / nSamples) : 0;
                    results.add(new ResultItem(disease, symptom, count, nSamples, percent));

                }

            }

        }

        Collections.sort(results, (a, b) -> a.disease.compareToIgnoreCase(b.disease));

        return results;

    }


}