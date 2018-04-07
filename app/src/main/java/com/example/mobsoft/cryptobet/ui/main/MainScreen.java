package com.example.mobsoft.cryptobet.ui.main;

public interface MainScreen {
    void showCryptoCurrencies();

    void showNetworkError(String errorMsg);

    void updateScore();
}
