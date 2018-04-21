package com.example.mobsoft.cryptobet;

import com.example.mobsoft.cryptobet.interactor.InteractorModule;
import com.example.mobsoft.cryptobet.interactor.cryptos.BidInteractor;
import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;
import com.example.mobsoft.cryptobet.network.NetworkModule;
import com.example.mobsoft.cryptobet.ui.UIModule;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsActivity;
import com.example.mobsoft.cryptobet.ui.main.MainActivity;
import com.example.mobsoft.cryptobet.ui.main.MainActivityFragment;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class})
public interface CryptobetApplicationComponent {
    void inject(MainActivityFragment mainActivityFragment);

    void inject(CryptoDetailsActivity cryptoDetailsActivity);

    void inject(CryptosInteractor cryptosInteractor);

    void inject(BidInteractor bidInteractor);
}
