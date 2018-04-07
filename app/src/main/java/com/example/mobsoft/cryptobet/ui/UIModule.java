package com.example.mobsoft.cryptobet.ui;

import android.content.Context;

import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsPresenter;
import com.example.mobsoft.cryptobet.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class UIModule {
    private Context context;

    public UIModule(Context context) { this.context = context; }

    @Provides
    public Context provideContext() {
        return context;
    }

    @Provides
    @Singleton
    public MainPresenter provideMainPresenter() {
        return new MainPresenter();
    }

    @Provides
    @Singleton
    public CryptoDetailsPresenter provideCryptoDetailsPresenter() {
        return new CryptoDetailsPresenter();
    }
}
