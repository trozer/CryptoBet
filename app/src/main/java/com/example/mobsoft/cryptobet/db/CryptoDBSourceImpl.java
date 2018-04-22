package com.example.mobsoft.cryptobet.db;

import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

public class CryptoDBSourceImpl implements CryptoDBSource{

    public void insertBid(Bid bid){
        bid.save();
    }

    public Bid getBidById(long id){
        return Bid.findById(Bid.class, id);
    }

    public void deleteBid(Bid bid){
        bid.delete();
    }

    public List<Bid> getAllBids(){
        return Bid.listAll(Bid.class);
    }

    public Bid getBidBySpecificCurrency(Currency currency){
        List<Bid> bids = getAllBids();
        for(Bid bid : bids){
            if(bid.getCurrency().getName().equals(currency.getName()))
                return bid;
        }
        return null;
    }
}
