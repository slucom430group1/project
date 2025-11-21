package com.slucom430ol01group1.painreferrer;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "saved")
public class SavedEntity {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String disease;
    public String painType;
    public long timestamp;

    public SavedEntity(String disease, String painType) {

        this.disease = disease;
        this.painType = painType;
        this.timestamp = System.currentTimeMillis();

    }

}
