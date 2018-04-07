package com.example.mobsoft.cryptobet;

import android.app.Application;

import com.example.mobsoft.cryptobet.ui.UIModule;

public class CryptobetApplication extends Application {

    public static CryptobetApplicationComponent injector;

    @Override
    public void onCreate() {
        super.onCreate();

        injector =
                DaggerCryptobetApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
