package com.example.mobsoft.cryptobet.interactor.cryptos;

import com.example.mobsoft.cryptobet.CryptobetApplication;

public class CryptosInteractor {

    public CryptosInteractor() {
        CryptobetApplication.injector.inject(this);
    }

    public void getCryptos(String query){}

}
