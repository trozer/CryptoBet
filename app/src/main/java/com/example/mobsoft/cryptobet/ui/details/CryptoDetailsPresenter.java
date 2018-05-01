package com.example.mobsoft.cryptobet.ui.details;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.ui.Presenter;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

public class CryptoDetailsPresenter extends Presenter<CryptoDetailsScreen> {

    @Inject
    CryptoDBSource cryptoDBSource;


    @Override
    public void attachScreen(CryptoDetailsScreen screen) {
        CryptobetApplication.injector.inject(this);
        super.attachScreen(screen);
    }

    @Override
    public void detachScreen() {
        super.detachScreen();
    }

    public void saveBet(Currency currency, int year, int month, int dayOfMonth, int hour, int minute, String price)
    {
        try {
            if(checkActivity(currency))
                throw new Exception("You already made a bet on this currency");
            Bid bid = new Bid();
            Calendar calDate = Calendar.getInstance();
            calDate.set(Calendar.YEAR, year);
            calDate.set(Calendar.MONTH, month);
            calDate.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            calDate.set(Calendar.HOUR_OF_DAY, hour);
            calDate.set(Calendar.MINUTE, minute);
            calDate.set(Calendar.SECOND, 0);

            Date date = calDate.getTime();
            if(date.before(new Date()))
                throw new Exception("Given date time is before the current date");
            int iPrice = Integer.parseInt(price);
            bid.setDeadLine((int) (date.getTime() / 1000));
            bid.setPrice(iPrice);
            bid.setCurrentPrice(Math.round(currency.getPriceUsd()));
            bid.setCurrencyName(currency.getName());
            bid.setTimeMultiplier(((int)((date.getTime()/1000) - (new Date().getTime()/1000)))/100000);

            cryptoDBSource.insertBid(bid);
            screen.successfulBet(currency.getName(), year,month,dayOfMonth,hour,minute,iPrice);
            screen.disableBetUI();
        }catch (Exception e){
            screen.failBet(e.getMessage());
        }
    };

    public void setBetSelection(Currency currency){
        Bid bid = cryptoDBSource.getBidBySpecificCurrency(currency);
        int time = bid.getDeadLine();
        Date date = new Date(((long)time)*1000L);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        screen.setBetSelectState(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), Integer.toString(bid.getPrice()));
    }

    public boolean checkActivity(Currency currency){
        List<Bid> bids = Bid.listAll(Bid.class);

        if(cryptoDBSource.getBidBySpecificCurrency(currency) != null){
            return true;
        }else
            return false;
    }

}
