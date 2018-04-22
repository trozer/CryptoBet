package com.example.mobsoft.cryptobet.mock;

import com.example.mobsoft.cryptobet.model.Currency;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public class MockCryptoCurrenciesInfoApi {

    Call<List<Currency>> ticker(
            @Query("start") Integer start, @Query("limit") Integer limit, @Query("convert") String convert
    ){
        final List<Currency> currenciesResult = new ArrayList<Currency>();

        Currency currency = new Currency();
        currency.setId(new Long(1));
        currency.setId("bitcoin");
        currency.setName("Bitcoin");
        currency.setSymbol("BTC");
        currency.setRank(new Integer(1));
        currency.setPriceUsd(new Float(573.137));
        currency.setPriceBtc(new Float(1.0));
        currency.set24hVolumeUsd(new Double(72855700.0));
        currency.setMarketCapUsd(new Double(9080883500.0));
        currency.setAvailableSupply(new Double(15844176.0));
        currency.setTotalSupply(new Double(15844176.0));
        currency.setPercentChange1h(new Float(0.04));
        currency.setPercentChange24h(new Float(-0.3));
        currency.setPercentChange7d(new Float(-0.57));
        currency.setLastUpdated(new Integer(1472762067));

        currenciesResult.add(currency);

        Call<List<Currency>> call = new Call<List<Currency>>() {
            @Override
            public Response<List<Currency>> execute() throws IOException {
                return Response.success(currenciesResult);
            }

            @Override
            public void enqueue(Callback<List<Currency>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Currency>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
        return call;
    }

    Call<List<Currency>> tickerSpecific(
            @Path("name") String name, @Query("convert") String convert
    ){
        final List<Currency> currenciesResult = new ArrayList<Currency>();

        Currency currency = new Currency();
        currency.setId(new Long(1));
        currency.setId("bitcoin");
        currency.setName("Bitcoin");
        currency.setSymbol("BTC");
        currency.setRank(new Integer(1));
        currency.setPriceUsd(new Float(573.137));
        currency.setPriceBtc(new Float(1.0));
        currency.set24hVolumeUsd(new Double(72855700.0));
        currency.setMarketCapUsd(new Double(9080883500.0));
        currency.setAvailableSupply(new Double(15844176.0));
        currency.setTotalSupply(new Double(15844176.0));
        currency.setPercentChange1h(new Float(0.04));
        currency.setPercentChange24h(new Float(-0.3));
        currency.setPercentChange7d(new Float(-0.57));
        currency.setLastUpdated(new Integer(1472762067));

        currenciesResult.add(currency);

        Call<List<Currency>> call = new Call<List<Currency>>() {
            @Override
            public Response<List<Currency>> execute() throws IOException {
                return Response.success(currenciesResult);
            }

            @Override
            public void enqueue(Callback<List<Currency>> callback) {

            }

            @Override
            public boolean isExecuted() {
                return false;
            }

            @Override
            public void cancel() {

            }

            @Override
            public boolean isCanceled() {
                return false;
            }

            @Override
            public Call<List<Currency>> clone() {
                return null;
            }

            @Override
            public Request request() {
                return null;
            }
        };
        return call;
    }

}
