package com.example.mobsoft.cryptobet.interactor;

import com.example.mobsoft.cryptobet.interactor.cryptos.BidInteractor;
import com.example.mobsoft.cryptobet.interactor.cryptos.CryptoDBSourceInteractor;
import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {
    @Provides
    public CryptosInteractor provideCryptosInteractor() {
        return new CryptosInteractor();
    }

    @Provides
    public BidInteractor provideBidInteractor() {
        return new BidInteractor();
    }

    @Provides
    public CryptoDBSourceInteractor provideCryptoDBSourceInteractor() { return new CryptoDBSourceInteractor(); }
}
