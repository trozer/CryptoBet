package com.example.mobsoft.cryptobet.model;

import com.orm.SugarRecord;

import java.util.Date;

public class Bid extends SugarRecord<Bid>{
    private String currencyName;
    private int price;
    private int currentPrice;
    private int deadLine;
    private int timeMultiplier;

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(int currentPrice) {
        this.currentPrice = currentPrice;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }

    public int getTimeMultiplier() {
        return timeMultiplier;
    }

    public void setTimeMultiplier(int timeMultiplier) {
        this.timeMultiplier = timeMultiplier;
    }
}
