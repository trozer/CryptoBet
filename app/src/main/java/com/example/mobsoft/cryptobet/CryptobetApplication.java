package com.example.mobsoft.cryptobet;

import android.app.Application;

import com.example.mobsoft.cryptobet.ui.UIModule;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.orm.SugarApp;

public class CryptobetApplication extends SugarApp {

    public static CryptobetApplicationComponent injector;

    @Override
    public void onCreate() {
        if(false)
            super.onCreate();
        injector =
                DaggerCryptobetApplicationComponent.builder().
                        uIModule(
                                new UIModule(this)
                        ).build();
    }
}
