package com.example.mobsoft.cryptobet.model;

import java.util.List;

public class PlayerInfo {
    private int score;
    private List<Bid> bids;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public void setBids(List<Bid> bids) {
        this.bids = bids;
    }
}
