package com.example.mobsoft.cryptobet.model;

import com.orm.SugarRecord;

import java.util.Date;

public class Bid extends SugarRecord<Bid>{
    private Currency currency;
    private int price;
    private int deadLine;

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDeadLine() {
        return deadLine;
    }

    public void setDeadLine(int deadLine) {
        this.deadLine = deadLine;
    }
}
