package com.example.mobsoft.cryptobet.interactor;

import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public CryptosInteractor provideArtistsInteractor() {
        return new CryptosInteractor();
    }
}
