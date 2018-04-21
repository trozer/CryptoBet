package com.example.mobsoft.cryptobet.ui.main;

import android.util.Log;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.di.Network;
import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;
import com.example.mobsoft.cryptobet.interactor.cryptos.event.GetCryptosEvent;
import com.example.mobsoft.cryptobet.ui.Presenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.concurrent.Executor;

import javax.inject.Inject;

public class MainPresenter extends Presenter<MainScreen> {

    @Inject
    @Network
    Executor networkExecutor;

    @Inject
    CryptosInteractor cryptosInteractor;

    @Override
    public void attachScreen(MainScreen screen) {
        super.attachScreen(screen);
        CryptobetApplication.injector.inject(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void detachScreen() {
        EventBus.getDefault().unregister(this);
        super.detachScreen();
    }

    public void showCryptonCurrencyDetails(){

    };

    public void setScore(){
        Log.i("test", "jani");
    };

    public void refreshCurrencies(final Integer start, final Integer limit, final String convert){
        networkExecutor.execute(new Runnable() {
            @Override
            public void run() {
                cryptosInteractor.getCryptos(start, limit, convert);
            }
        });
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
                screen.showCryptoCurrencies(event.getCryptos());
            }
        }
    }
}
