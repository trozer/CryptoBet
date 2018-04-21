package com.example.mobsoft.cryptobet.interactor.cryptos.event;


import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

public class GetCryptosEvent {
    private int code;
    private List<Currency> cryptos;
    private Throwable throwable;

    public GetCryptosEvent(){}

    public GetCryptosEvent(int code, List<Currency> cryptos, Throwable throwable){
        this.code = code;
        this.cryptos = cryptos;
        this.throwable = throwable;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Currency> getCryptos() {
        return cryptos;
    }

    public void setCryptos(List<Currency> artists) {
        this.cryptos= cryptos;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
