package com.example.mobsoft.cryptobet.network;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public CryptosApi provideCryptosApi() {
        return null;
    }
}
