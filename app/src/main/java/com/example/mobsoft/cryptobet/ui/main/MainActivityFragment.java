package com.example.mobsoft.cryptobet.ui.main;

import android.app.Fragment;
import android.content.Context;
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


    public MainActivityFragment(){
        CryptobetApplication.injector.inject(this);
    }

    @Override
    public void onAttach(final Context context){
        super.onAttach(context);
        mainPresenter.attachScreen(this);

    }

    @Override
    public void onDetach() {
        mainPresenter.detachScreen();
        super.onDetach();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mainPresenter.setScore();
        mainPresenter.refreshCurrencies(0,100,"EUR");
        mainPresenter.getCryptoCurrencyByName("ethereum", "EUR");
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void showCryptoCurrencies(List<Currency> currencies) {
        for(Currency i : currencies)
            Log.i("curr",i.toString());
    }

    @Override
    public void showCryptoCurrency(Currency currency) {
        Log.i("curr", currency.toString());
    }

    @Override
    public void showNetworkError(String errorMsg) {

    }

    @Override
    public void updateScore() {

    }
}
