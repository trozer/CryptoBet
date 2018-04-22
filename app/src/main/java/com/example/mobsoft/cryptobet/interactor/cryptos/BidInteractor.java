package com.example.mobsoft.cryptobet.interactor.cryptos;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

import javax.inject.Inject;

public class BidInteractor {

    @Inject
    CryptoDBSource dbSource;

    public BidInteractor() {
        CryptobetApplication.injector.inject(this);
    }

    public void insertBid(Bid bid){
       dbSource.insertBid(bid);
    }

    public Bid getBidById(long id){
        return dbSource.getBidById(id);
    }

    public void deleteBid(Bid bid){
        dbSource.deleteBid(bid);
    }

    public List<Bid> getAllBids(){
        return dbSource.getAllBids();
    }

    public Bid getBidBySpecificCurrency(Currency currency){
        return dbSource.getBidBySpecificCurrency(currency);
    }
}
