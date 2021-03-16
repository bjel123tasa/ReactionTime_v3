package com.example.reactiontime_v1;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {User.class, TimeReaction.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    private static  AppDatabase instance;

    public abstract UserDao userDao();

    public static synchronized AppDatabase getInstance(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, "users")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            new PopulateDbAsyncTask(instance).run();
            super.onCreate(db);
        }
    };
    private  static  class PopulateDbAsyncTask implements Runnable {
        private final UserDao userDao;
        private PopulateDbAsyncTask(AppDatabase db){
            userDao = db.userDao();
        }
        @Override
        public void run() {
            userDao.insert(new User());

        }
    }
}
