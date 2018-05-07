package com.example.mobsoft.cryptobet.ui.main;

import android.content.SharedPreferences;
import android.util.Log;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.di.Network;
import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;
import com.example.mobsoft.cryptobet.interactor.cryptos.event.GetCryptoEvent;
import com.example.mobsoft.cryptobet.interactor.cryptos.event.GetCryptosEvent;
import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    CryptoDBSource cryptoDBSource;

    @Inject
    CryptosInteractor cryptosInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        CryptobetApplication.injector.inject(this);
        if (!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void showCryptonCurrencyDetails(){

    };

    public void setScore(){

    };

    public void refreshCurrencies(final Integer start, final Integer limit, final String convert){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                cryptosInteractor.getCryptos(start, limit, convert);
            }
        });
    }

    public void getCryptoCurrencyByName(final String name, final String convert){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                cryptosInteractor.getCryptoCurrencyByName(name, convert);
            }
        });
    }

    public void evaluateBets(List<Currency> currencyList){
        int addScore = 0;
        for(Currency currency : currencyList){
            if(cryptoDBSource.getBidBySpecificCurrency(currency) != null){
                Bid bid = cryptoDBSource.getBidBySpecificCurrency(currency);
                if(currency.getLastUpdated() > bid.getDeadLine()){
                    int score = (int)(Double.valueOf(bid.getTimeMultiplier()) *
                            Double.valueOf(bid.getPrice()) / Double.valueOf(Math.abs(bid.getPrice() - currency.getPriceUsd())));
                    int deadLineDiff = ((int)((bid.getDeadLine()) - (new Date().getTime()/1000)))/100000;
                    if(deadLineDiff > 10)
                        score = 0;
                    addScore += score;
                    cryptoDBSource.deleteBid(bid);
                }
            }
        }
        screen.updateScore(addScore);
        screen.updateBetText(getBetNum());
    }

    private int getBetNum(){
        return cryptoDBSource.getAllBids().size();
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetCryptosEvent event){
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                evaluateBets(event.getCryptos());
                screen.showCryptoCurrencies(event.getCryptos());
            }
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(final GetCryptoEvent event){
        if (event.getThrowable() != null) {
            event.getThrowable().printStackTrace();
            if (screen != null) {
                screen.showNetworkError(event.getThrowable().getMessage());
            }
        } else {
            if (screen != null) {
                screen.showCryptoCurrency(event.getCrypto());
            }
        }
    }
}
