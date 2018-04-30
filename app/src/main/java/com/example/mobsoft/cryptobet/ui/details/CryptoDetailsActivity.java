package com.example.mobsoft.cryptobet.ui.details;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.CryptobetApplicationComponent;
import com.example.mobsoft.cryptobet.R;
import com.example.mobsoft.cryptobet.model.Currency;

import javax.inject.Inject;

public class CryptoDetailsActivity extends AppCompatActivity implements CryptoDetailsScreen {

    @Inject
    CryptoDetailsPresenter cryptoDetailsPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypto_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        CryptobetApplication.injector.inject(this);

        TextView currName = (TextView) findViewById(R.id.tvCurrName);
        TextView currPrice = (TextView) findViewById(R.id.tvCurrPrice);
        TextView curr24hVolume = (TextView) findViewById(R.id.tvCurr24hVolume);
        TextView currChange1h = (TextView) findViewById(R.id.tvCurrChange1h);
        TextView currChange24h = (TextView) findViewById(R.id.tvCurrChange24h);
        TextView currChange7d = (TextView) findViewById(R.id.tvCurrChange7d);
        TextView currMaxSupply = (TextView) findViewById(R.id.tvCurrMaxSupply);
        TextView currTotalSupply = (TextView) findViewById(R.id.tvCurrTotalSupply);
        TextView currPriceInBTC = (TextView) findViewById(R.id.tvCurrPriceInBTC);
        TextView currRank = (TextView) findViewById(R.id.tvCurrRank);

        Intent intent = getIntent();
        Currency currency = (Currency) intent.getSerializableExtra("Currency");
        currName.setText(currency.getName());
        currPrice.setText(currency.getPriceUsd().toString());
        curr24hVolume.setText(currency.get24hVolumeUsd().toString());
        currChange1h.setText(currency.getPercentChange1h().toString());
        currChange24h.setText(currency.getPercentChange24h().toString());
        currChange7d.setText(currency.getPercentChange7d().toString());
        currMaxSupply.setText(currency.getAvailableSupply().toString());
        currTotalSupply.setText(currency.getTotalSupply().toString());
        currPriceInBTC.setText(currency.getPriceBtc().toString());
        currRank.setText(currency.getRank().toString());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        cryptoDetailsPresenter.attachScreen(this);
    }

    @Override
    protected void onStop(){
        cryptoDetailsPresenter.detachScreen();
        super.onStop();
    }

    @Override
    public void showBid() {

    }
}
