package com.example.reactiontime_v1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Transaction
    @Query("SELECT * FROM users")
   LiveData<List<UserWithTimeReaction>>  getAll();

    @Insert
    void insert(User user);

    @Delete
    void delete(User user);

    @Update
    void update(User user);
}
