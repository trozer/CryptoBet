package com.example.mobsoft.cryptobet.interactor.cryptos.event;

import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

public class GetCryptoEvent {
    private int code;
    private Currency crypto;
    private Throwable throwable;

    public GetCryptoEvent(){}

    public GetCryptoEvent(int code, Currency crypto, Throwable throwable){
        this.code = code;
        this.crypto = crypto;
        this.throwable = throwable;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Currency getCrypto() {
        return crypto;
    }

    public void setCrypto(Currency crypto) {
        this.crypto = crypto;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public void setThrowable(Throwable throwable) {
        this.throwable = throwable;
    }
}
