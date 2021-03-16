package com.example.reactiontime_v1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(tableName = "timeReaction")
public class TimeReaction {

    @PrimaryKey(autoGenerate = true)
    private int reactionId;

    private String times;

    private int user_id;

    public TimeReaction() {
    }

    public TimeReaction(int i){
        this.reactionId = i;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getReactionId() {
        return reactionId;
    }

    public void setReactionId(int reactionId) {
        this.reactionId = reactionId;
    }
}

