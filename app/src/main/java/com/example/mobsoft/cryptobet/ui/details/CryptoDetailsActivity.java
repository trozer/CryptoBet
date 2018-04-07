package com.example.mobsoft.cryptobet.ui.details;

import android.os.Bundle;
import android.app.Activity;

import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.ui.main.MainPresenter;

import javax.inject.Inject;

public class CryptoDetailsActivity extends Activity implements  CryptoDetailsScreen {


    @Inject
    CryptoDetailsPresenter cryptoDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_details);
    }

    @Override
    public void showBid() {

    }
}
