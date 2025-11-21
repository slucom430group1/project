package com.slucom430ol01group1.painreferrer;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.content.Context;

@Database(entities = {SavedEntity.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase instance;

    public abstract SavedDAO savedDAO();

    public static synchronized AppDatabase getInstance(Context context) {

        if (instance == null) {

            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "pain_referrer_db")
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();

        }

        return instance;

    }
}
