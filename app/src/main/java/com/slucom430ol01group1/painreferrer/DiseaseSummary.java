package com.slucom430ol01group1.painreferrer;

import java.util.HashMap;

public class DiseaseSummary {

    public String disease;
    public HashMap<String, Integer> symptomCounts = new HashMap<>();
    public int nSamples;

    public DiseaseSummary(String disease) {

        this.disease = disease;

    }

}
