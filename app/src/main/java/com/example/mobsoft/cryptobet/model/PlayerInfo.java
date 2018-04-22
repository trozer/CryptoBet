package com.example.mobsoft.cryptobet.model;

import com.orm.SugarRecord;

import java.util.List;

public class PlayerInfo extends SugarRecord<PlayerInfo>{
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
