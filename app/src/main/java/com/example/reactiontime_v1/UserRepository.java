package com.example.reactiontime_v1;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.loader.content.AsyncTaskLoader;

import java.util.List;

public class UserRepository {
    private UserDao userDao;
    private LiveData<List<UserWithTimeReaction>> allUsers;

    public UserRepository(Application aplication){
        AppDatabase appDatabase = AppDatabase.getInstance(aplication);
        userDao = appDatabase.userDao();
        allUsers = userDao.getAll();
    }
    public void insert(User user){
        new InsertUserAsyncTask(userDao).execute(user);

    }
    public void delete(User user){
        new DeleteUserAsyncTask(userDao).execute(user);

    }
    public  void update(User user){
        new UpdateUserAsyncTask(userDao).execute(user);

    }
    public LiveData<List<UserWithTimeReaction>> getAllUsers(){
        return allUsers;

    }
    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;

        private  InsertUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

    private static class UpdateUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;

        private  UpdateUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.update(users[0]);
            return null;
        }
    }

    private static class DeleteUserAsyncTask extends AsyncTask<User, Void, Void>{
        private UserDao userDao;

        private  DeleteUserAsyncTask(UserDao userDao){
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.delete(users[0]);
            return null;
        }
    }


}
