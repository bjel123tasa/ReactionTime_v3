package com.example.reactiontime_v1;

import androidx.room.Embedded;
import androidx.room.Ignore;
import androidx.room.Relation;
import java.util.List;

public class UserWithTimeReaction {

    @Embedded public User user;
    @Relation(parentColumn = "id", entityColumn = "user_id")
    public List<TimeReaction> timeReactions;

    @Ignore
    public UserWithTimeReaction(User user, List<TimeReaction> timeReactions) {
        this.user = user;
        this.timeReactions = timeReactions;
    }

    public UserWithTimeReaction() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<TimeReaction> getTimeReactions() {
        return timeReactions;
    }
}
