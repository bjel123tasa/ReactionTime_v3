package com.example.reactiontime_v1;

public class ReactionModel {
    private boolean shouldBeSelected;

    public ReactionModel(boolean shouldBeSelected) {
        this.shouldBeSelected = shouldBeSelected;
    }

    public boolean isShouldBeSelected() {
        return shouldBeSelected;
    }

    public void setShouldBeSelected(boolean shouldBeSelected) {
        this.shouldBeSelected = shouldBeSelected;
    }
}
