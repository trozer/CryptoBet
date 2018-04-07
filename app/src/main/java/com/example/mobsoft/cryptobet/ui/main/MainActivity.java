package com.example.mobsoft.cryptobet.ui.main;

import android.os.Bundle;
import android.app.Activity;

import com.example.mobsoft.cryptobet.R;

public class MainActivity extends Activity implements MainScreen {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void showCryptoCurrencies() {

    }

    @Override
    public void showNetworkError(String errorMsg) {

    }
}
