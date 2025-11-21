package com.slucom430ol01group1.painreferrer;

public class ResultItem {

    public String disease;
    public String painType;
    public int count;
    public int nSamples;
    public float percent;

    public ResultItem(String disease, String painType, int count, int nSamples, float percent) {

        this.disease = disease;
        this.painType = painType;
        this.count = count;
        this.nSamples = nSamples;
        this.percent = percent;

    }

}
