package com.example.reactiontime_v1;

import android.app.Application;
import androidx.lifecycle.LiveData;
import java.util.List;
public class UserRepository {
    private final UserDao userDao;
    private final LiveData<List<UserWithTimeReaction>> allUsers;

    public UserRepository(Application aplication){
        AppDatabase appDatabase = AppDatabase.getInstance(aplication);
        userDao = appDatabase.userDao();
        allUsers = userDao.getAll();
    }
    public void insert(final User user){
        new Runnable() {
            @Override
            public void run() {
                userDao.insert(user);

            }
        };


    }
    public void delete(final User user){
        new Runnable() {
            @Override
            public void run() {
                userDao.delete(user);
            }
        };

    }
    public  void update(final User user){
        new Runnable() {
            @Override
            public void run() {
                userDao.update(user);
            }
        };

    }
    public LiveData<List<UserWithTimeReaction>> getAllUsers(){
        return allUsers;

    }

    }



