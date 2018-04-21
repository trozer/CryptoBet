package com.example.mobsoft.cryptobet.ui.main;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    public MainActivityFragment() {
        CryptobetApplication.injector.inject(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void showCryptoCurrencies(List<Currency> currencies) {
        Log.i("curr",currencies.get(0).toString());
        mainPresenter.setScore();
        mainPresenter.refreshCurrencies(0,100,"EUR");
    }

    @Override
    public void showNetworkError(String errorMsg) {

    }

    @Override
    public void updateScore() {

    }
}
