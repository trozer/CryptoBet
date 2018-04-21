package com.example.mobsoft.cryptobet.network;

import com.example.mobsoft.cryptobet.model.Currency;

import retrofit2.Call;
import retrofit2.http.*;

import okhttp3.RequestBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface CryptoCurrenciesInfoApi {

    /**
     * gets info about cryptocurrencies
     * Returns first 100 (in rank) cryptocurrencies. Optionally you can use these query parameters :\\n(int) start - return results from rank [start] and above\n(int) limit - return a maximum of [limit] results (default is 100, use 0 to return all results)\n(string) convert - return price, 24h volume, and market cap in terms of another currency. Valid value\: \&quot;AUD\&quot;, \&quot;BRL\&quot;, \&quot;CAD\&quot;, \&quot;CHF\&quot;, \&quot;CLP\&quot;, \&quot;CNY\&quot;, \&quot;CZK\&quot;, \&quot;DKK\&quot;, \&quot;EUR\&quot;, \&quot;GBP\&quot;, \&quot;HKD\&quot;, \&quot;HUF\&quot;, \&quot;IDR\&quot;, \&quot;ILS\&quot;, \&quot;INR\&quot;, \&quot;JPY\&quot;, \&quot;KRW\&quot;, \&quot;MXN\&quot;, \&quot;MYR\&quot;, \&quot;NOK\&quot;, \&quot;NZD\&quot;, \&quot;PHP\&quot;, \&quot;PKR\&quot;, \&quot;PLN\&quot;, \&quot;RUB\&quot;, \&quot;SEK\&quot;, \&quot;SGD\&quot;, \&quot;THB\&quot;, \&quot;TRY\&quot;, \&quot;TWD\&quot;, \&quot;ZAR\&quot;
     * @param start return results from rank [start] and above
     * @param limit return a maximum of [limit] results (default is 100, use 0 to return all results)
     * @param convert return price, 24h volume, and market cap in terms of another currency. Valid value- \&quot;AUD\&quot;, \&quot;BRL\&quot;, \&quot;CAD\&quot;, \&quot;CHF\&quot;, \&quot;CLP\&quot;, \&quot;CNY\&quot;, \&quot;CZK\&quot;, \&quot;DKK\&quot;, \&quot;EUR\&quot;, \&quot;GBP\&quot;, \&quot;HKD\&quot;, \&quot;HUF\&quot;, \&quot;IDR\&quot;, \&quot;ILS\&quot;, \&quot;INR\&quot;, \&quot;JPY\&quot;, \&quot;KRW\&quot;, \&quot;MXN\&quot;, \&quot;MYR\&quot;, \&quot;NOK\&quot;, \&quot;NZD\&quot;, \&quot;PHP\&quot;, \&quot;PKR\&quot;, \&quot;PLN\&quot;, \&quot;RUB\&quot;, \&quot;SEK\&quot;, \&quot;SGD\&quot;, \&quot;THB\&quot;, \&quot;TRY\&quot;, \&quot;TWD\&quot;, \&quot;ZAR\&quot;
     * @return Call<List<Currency>>
     */

    @GET("v1/ticker")
    Call<List<Currency>> ticker(
            @Query("start") Integer start, @Query("limit") Integer limit, @Query("convert") String convert
    );


    /**
     * gets info about a cryptocurrency
     * Returns first 100 (in rank) cryptocurrencies. Optionally you can use these query parameters :\\n(string) convert - return price, 24h volume, and market cap in terms of another currency. Valid value\: \&quot;AUD\&quot;, \&quot;BRL\&quot;, \&quot;CAD\&quot;, \&quot;CHF\&quot;, \&quot;CLP\&quot;, \&quot;CNY\&quot;, \&quot;CZK\&quot;, \&quot;DKK\&quot;, \&quot;EUR\&quot;, \&quot;GBP\&quot;, \&quot;HKD\&quot;, \&quot;HUF\&quot;, \&quot;IDR\&quot;, \&quot;ILS\&quot;, \&quot;INR\&quot;, \&quot;JPY\&quot;, \&quot;KRW\&quot;, \&quot;MXN\&quot;, \&quot;MYR\&quot;, \&quot;NOK\&quot;, \&quot;NZD\&quot;, \&quot;PHP\&quot;, \&quot;PKR\&quot;, \&quot;PLN\&quot;, \&quot;RUB\&quot;, \&quot;SEK\&quot;, \&quot;SGD\&quot;, \&quot;THB\&quot;, \&quot;TRY\&quot;, \&quot;TWD\&quot;, \&quot;ZAR\&quot;
     * @param name
     * @param convert return price, 24h volume, and market cap in terms of another currency. Valid value- \&quot;AUD\&quot;, \&quot;BRL\&quot;, \&quot;CAD\&quot;, \&quot;CHF\&quot;, \&quot;CLP\&quot;, \&quot;CNY\&quot;, \&quot;CZK\&quot;, \&quot;DKK\&quot;, \&quot;EUR\&quot;, \&quot;GBP\&quot;, \&quot;HKD\&quot;, \&quot;HUF\&quot;, \&quot;IDR\&quot;, \&quot;ILS\&quot;, \&quot;INR\&quot;, \&quot;JPY\&quot;, \&quot;KRW\&quot;, \&quot;MXN\&quot;, \&quot;MYR\&quot;, \&quot;NOK\&quot;, \&quot;NZD\&quot;, \&quot;PHP\&quot;, \&quot;PKR\&quot;, \&quot;PLN\&quot;, \&quot;RUB\&quot;, \&quot;SEK\&quot;, \&quot;SGD\&quot;, \&quot;THB\&quot;, \&quot;TRY\&quot;, \&quot;TWD\&quot;, \&quot;ZAR\&quot;
     * @return Call<Currency>
     */

    @GET("v1/ticker/{name}")
    Call<Currency> tickerSpecific(
            @Path("name") String name, @Query("convert") String convert
    );


}
