package com.example.mobsoft.cryptobet.ui.details;

public interface CryptoDetailsScreen {

    public void successfulBet(String currName, int year, int month, int dayOfMonth, int hour, int minute, float price);
    public void failBet(String message);
    public void disableBetUI();
    public void setBetSelectState(int year, int month, int dayOfMonth, int hour, int minute, String price);

}
