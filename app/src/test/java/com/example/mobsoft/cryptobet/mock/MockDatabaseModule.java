package com.example.mobsoft.cryptobet.mock;

import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.db.CryptoDBSourceImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MockDatabaseModule {
    @Provides
    @Singleton
    public CryptoDBSource provideCryptosApi() {
        return new MockCryptoDBSource();
    }
}
