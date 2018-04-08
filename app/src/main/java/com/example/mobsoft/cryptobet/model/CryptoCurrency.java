package com.example.mobsoft.cryptobet.model;

public class CryptoCurrency {
    private String id;
    private String name;
    private String Symbol;
    private int rank;
    private float priceUsd;
    private float priceBtc;
    private float dayVolumeUsd;
    private float marketCapUsd;
    private float availableSupply;
    private float totalSupply;
    private float percentChangeInOneHour;
    private boolean bet;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public float getPriceUsd() {
        return priceUsd;
    }

    public void setPriceUsd(float priceUsd) {
        this.priceUsd = priceUsd;
    }

    public float getPriceBtc() {
        return priceBtc;
    }

    public void setPriceBtc(float priceBtc) {
        this.priceBtc = priceBtc;
    }

    public float getDayVolumeUsd() {
        return dayVolumeUsd;
    }

    public void setDayVolumeUsd(float dayVolumeUsd) {
        this.dayVolumeUsd = dayVolumeUsd;
    }

    public float getMarketCapUsd() {
        return marketCapUsd;
    }

    public void setMarketCapUsd(float marketCapUsd) {
        this.marketCapUsd = marketCapUsd;
    }

    public float getAvailableSupply() {
        return availableSupply;
    }

    public void setAvailableSupply(float availableSupply) {
        this.availableSupply = availableSupply;
    }

    public float getTotalSupply() {
        return totalSupply;
    }

    public void setTotalSupply(float totalSupply) {
        this.totalSupply = totalSupply;
    }

    public float getPercentChangeInOneHour() {
        return percentChangeInOneHour;
    }

    public void setPercentChangeInOneHour(float percentChangeInOneHour) {
        this.percentChangeInOneHour = percentChangeInOneHour;
    }

    public boolean isBet() {
        return bet;
    }

    public void setBet(boolean bet) {
        this.bet = bet;
    }
}
