package com.example.mobsoft.cryptobet.db;

import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;

import java.util.List;

public interface CryptoDBSource {

    public void insertBid(Bid bid);

    public Bid getBidById(long id);

    public void deleteBid(Bid bid);

    public List<Bid> getAllBids();

    public Bid getBidBySpecificCurrency(Currency currency);
}
