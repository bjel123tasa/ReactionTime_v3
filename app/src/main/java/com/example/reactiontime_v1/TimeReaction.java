package com.example.reactiontime_v1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.ArrayList;

@Entity(foreignKeys = @ForeignKey(entity = TimeReaction.class, parentColumns = "timeReactionId", childColumns = "user_id"))
public class TimeReaction {

    @PrimaryKey(autoGenerate = true)
    private int timeReactioId;

    private ArrayList<Integer> times;

    private int user_id;

    public TimeReaction(int timeReactionId, ArrayList<Integer> times, int user_id) {
        this.timeReactioId = timeReactionId;
        this.times = times;
        this.user_id = user_id;
    }

    public TimeReaction() {
    }

    public int getId() {
        return timeReactioId;
    }

    public void setId(int id) {
        this.timeReactioId = id;
    }

    public ArrayList<Integer> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<Integer> times) {
        this.times = times;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}

