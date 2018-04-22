package com.example.mobsoft.cryptobet.db;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DatabaseModule {

    @Provides
    @Singleton
    public CryptoDBSource provideCryptosApi() {
        return new CryptoDBSourceImpl();
    }
}
