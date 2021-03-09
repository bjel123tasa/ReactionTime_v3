package com.example.reactiontime_v1;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import java.io.Serializable;

@Entity(tableName = "users")
public class User implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;

    private Double mean;

    private Double std;

    public User(int id, String name, Double mean, Double std) {
        this.id = id;
        this.name = name;
        this.mean = mean;
        this.std = std;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMean() {
        return mean;
    }

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public Double getStd() {
        return std;
    }

    public void setStd(Double std) {
        this.std = std;
    }
}
