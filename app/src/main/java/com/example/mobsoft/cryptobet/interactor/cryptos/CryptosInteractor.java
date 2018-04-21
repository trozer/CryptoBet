package com.example.mobsoft.cryptobet.interactor.cryptos;

import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.interactor.cryptos.event.GetCryptosEvent;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.network.CryptoCurrenciesInfoApi;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Response;

public class CryptosInteractor {

    @Inject
    CryptoCurrenciesInfoApi cryptoCurrenciesInfoApi;

    public CryptosInteractor() {
        CryptobetApplication.injector.inject(this);
    }

    public void getCryptos(Integer start, Integer limit, String convert){
        GetCryptosEvent event = new GetCryptosEvent();
        try {
            Call<List<Currency>> cryptosQueryCall = cryptoCurrenciesInfoApi.ticker(start, limit, convert);

            Response<List<Currency>> response = cryptosQueryCall.execute();
            if(response.code() != 200){
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setCryptos(response.body());
            EventBus.getDefault().post(event);
        }catch (Exception e){
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void getFirstHundredCryptos(){
        GetCryptosEvent event = new GetCryptosEvent();
        try {
            Call<List<Currency>> cryptosQueryCall = cryptoCurrenciesInfoApi.ticker(0, 100, "EUR");

            Response<List<Currency>> response = cryptosQueryCall.execute();
            if(response.code() != 200){
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            event.setCryptos(response.body());
            EventBus.getDefault().post(event);
        }catch (Exception e){
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

    public void getCryptoCurrencyByName(String name, String convert){
        GetCryptosEvent event = new GetCryptosEvent();
        try {
            Call<Currency> cryptosQueryCall = cryptoCurrenciesInfoApi.tickerSpecific(name, convert);

            Response<Currency> response = cryptosQueryCall.execute();
            if(response.code() != 200){
                throw new Exception("Result code is not 200");
            }
            event.setCode(response.code());
            List<Currency> currencyList = new ArrayList<Currency>();
            currencyList.add(response.body());
            event.setCryptos(currencyList);
            EventBus.getDefault().post(event);
        }catch (Exception e){
            event.setThrowable(e);
            EventBus.getDefault().post(event);
        }
    }

}
