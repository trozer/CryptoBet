package com.example.mobsoft.cryptobet.ui.main;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mobsoft.cryptobet.R;

import javax.inject.Inject;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements MainScreen {

    @Inject
    MainPresenter mainPresenter;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void showCryptoCurrencies() {

    }

    @Override
    public void showNetworkError(String errorMsg) {

    }

    @Override
    public void updateScore() {

    }
}
