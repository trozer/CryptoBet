package com.example.mobsoft.cryptobet.mock;

import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.ArrayList;
import java.util.List;

public class MockCryptoDBSource implements CryptoDBSource{
    List<Bid> bids = new ArrayList<>();

    @Override
    public void insertBid(Bid bid) {
        bids.add(bid);
    }

    @Override
    public Bid getBidById(long id) {
        for(Bid bid : bids){
            if(bid.getId().equals(id))
                return bid;
        }
        return null;
    }

    @Override
    public void deleteBid(Bid bid) {
        bids.remove(bid);
    }

    @Override
    public List<Bid> getAllBids() {
        return bids;
    }

    @Override
    public Bid getBidBySpecificCurrency(Currency currency) {
        for(Bid bid : bids){
            if(bid.getCurrencyName().equals(currency.getName()))
                return bid;
        }
        return null;
    }
}
