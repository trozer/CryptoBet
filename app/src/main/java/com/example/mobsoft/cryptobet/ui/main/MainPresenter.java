package com.example.mobsoft.cryptobet.ui.main;

import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;
import com.example.mobsoft.cryptobet.ui.Presenter;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {
    @Inject
    CryptosInteractor cryptosInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void showCryptonCurrencyDetails(){

    };

    public void setScore(){};
}
