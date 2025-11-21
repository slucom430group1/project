package com.slucom430ol01group1.painreferrer;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import java.util.List;

@Dao
public interface SavedDAO {

    @Insert
    void insert(SavedEntity favorite);

    @Delete
    void delete(SavedEntity favorite);

    @Query("SELECT * FROM saved ORDER BY timestamp DESC")
    List<SavedEntity> getAllSaved();

    @Query("SELECT * FROM saved WHERE disease = :disease AND painType = :painType LIMIT 1")
    SavedEntity findSaved(String disease, String painType);

    @Query("DELETE FROM saved")
    void deleteAll();


}
