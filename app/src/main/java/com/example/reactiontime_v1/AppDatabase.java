package com.example.reactiontime_v1;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.loader.content.AsyncTaskLoader;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;


@Database(entities = {User.class}, version = 1)
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

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            new PopulateDbAsyncTask(instance).execute();
            super.onCreate(db);
        }
    };
    private  static  class PopulateDbAsyncTask extends AsyncTask<Void,Void, Void> {
        private  UserDao userDao;
        private PopulateDbAsyncTask(AppDatabase db){
            userDao = db.userDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            userDao.insert(new User());

            return null;
        }
    }
}
