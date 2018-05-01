package com.example.mobsoft.cryptobet;

import com.example.mobsoft.cryptobet.db.DatabaseModule;
import com.example.mobsoft.cryptobet.interactor.InteractorModule;
import com.example.mobsoft.cryptobet.interactor.cryptos.BidInteractor;
import com.example.mobsoft.cryptobet.interactor.cryptos.CryptosInteractor;
import com.example.mobsoft.cryptobet.network.NetworkModule;
import com.example.mobsoft.cryptobet.ui.UIModule;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsActivity;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsPresenter;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsScreen;
import com.example.mobsoft.cryptobet.ui.main.MainActivityFragment;
import com.example.mobsoft.cryptobet.ui.main.MainAdapter;
import com.example.mobsoft.cryptobet.ui.main.MainPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {UIModule.class, NetworkModule.class, InteractorModule.class, DatabaseModule.class})
public interface CryptobetApplicationComponent {
    void inject(MainActivityFragment mainActivityFragment);

    void inject(CryptoDetailsActivity cryptoDetailsActivity);

    void inject(CryptosInteractor cryptosInteractor);

    void inject(BidInteractor bidInteractor);

    void inject(MainPresenter mainPresenter);

    void inject(CryptoDetailsPresenter CryptoDetailsPresenter);

    void inject(MainAdapter mainAdapter);
}
