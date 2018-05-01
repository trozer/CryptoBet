package com.example.mobsoft.cryptobet.ui.details;

import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.ui.Presenter;

import java.util.Calendar;
import java.util.Date;

public class CryptoDetailsPresenter extends Presenter<CryptoDetailsScreen> {
    @Override
    public void attachScreen(CryptoDetailsScreen screen) {
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void saveBet(Currency currency, int year, int month, int dayOfMonth, int hour, int minute, int price)
    {
        Bid bid = new Bid();
        Calendar calDate = Calendar.getInstance();
        calDate.set(Calendar.YEAR, year);
        calDate.set(Calendar.MONTH, month);
        calDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        calDate.set(Calendar.HOUR_OF_DAY, hour);
        calDate.set(Calendar.MINUTE, minute);
        calDate.set(Calendar.SECOND, 0);

        Date date = calDate.getTime();
        bid.setDeadLine((int)(date.getTime()/1000));
        bid.setCurrency(currency);
        bid.setPrice(price);

        bid.save();
    };

}
