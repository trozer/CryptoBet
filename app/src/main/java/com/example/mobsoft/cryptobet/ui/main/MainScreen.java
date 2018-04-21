package com.example.mobsoft.cryptobet.ui.main;

import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

public interface MainScreen {
    void showCryptoCurrencies(List<Currency> currencies);

    void showNetworkError(String errorMsg);

    void updateScore();
}
