package com.example.mobsoft.cryptobet.test;

import com.example.mobsoft.cryptobet.BuildConfig;
import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.DaggerTestComponent;
import com.example.mobsoft.cryptobet.TestComponent;
import com.example.mobsoft.cryptobet.TestModule;
import com.example.mobsoft.cryptobet.db.CryptoDBSource;
import com.example.mobsoft.cryptobet.model.Bid;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.ui.main.MainPresenter;
import com.example.mobsoft.cryptobet.ui.main.MainScreen;

import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLog;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import static com.example.mobsoft.cryptobet.TestHelper.setTestInjector;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class MainTest {
    private MainPresenter mainPresenter;
    private MainScreen mainScreen;

    @Inject
    CryptoDBSource cryptoDBSource;

    @Before
    public void setup() throws Exception{
        setTestInjector().inject(this);
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testDownloadCryptoCurrencies(){
        mainPresenter.refreshCurrencies(1,100,"USD");

        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
        verify(mainScreen).showCryptoCurrencies(cryptoCaptor.capture());
        assertTrue(cryptoCaptor.getValue().size() > 0);
    }

    @Test
    public void testEvaluateBetsAfterDeadline(){
        Bid bid = new Bid();
        bid.setCurrencyName("Bitcoin");
        bid.setCurrentPrice(5000);
        bid.setPrice(6000);
        bid.setDeadLine((int)(new Date().getTime()/1000) - 10);
        bid.setTimeMultiplier(50);
        cryptoDBSource.insertBid(bid);

        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));
        List<Currency> currencies = new ArrayList<>();
        currencies.add(currency);

        mainPresenter.evaluateBets(currencies);

        assertEquals(0, cryptoDBSource.getAllBids().size());
        ArgumentCaptor<Integer> scoreCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mainScreen).updateScore(scoreCaptor.capture());
        assertTrue(scoreCaptor.getValue() > 0);
        ArgumentCaptor<Integer> bidNumCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mainScreen).updateBetText(bidNumCaptor.capture());
        assertTrue(bidNumCaptor.getValue() == 0);
    }

    @Test
    public void testEvaluateBetsBeforeDeadline(){
        Bid bid = new Bid();
        bid.setCurrencyName("Bitcoin");
        bid.setCurrentPrice(5000);
        bid.setPrice(6000);
        bid.setDeadLine((int)(new Date().getTime()/1000));
        bid.setTimeMultiplier(50);
        cryptoDBSource.insertBid(bid);

        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500f);
        currency.setLastUpdated((int)(new Date().getTime()/1000) - 10);
        List<Currency> currencies = new ArrayList<>();
        currencies.add(currency);

        mainPresenter.evaluateBets(currencies);

        assertEquals(1, cryptoDBSource.getAllBids().size());
        ArgumentCaptor<Integer> scoreCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mainScreen).updateScore(scoreCaptor.capture());
        assertTrue(scoreCaptor.getValue() == 0);
        ArgumentCaptor<Integer> bidNumCaptor = ArgumentCaptor.forClass(Integer.class);
        verify(mainScreen).updateBetText(bidNumCaptor.capture());
        assertTrue(bidNumCaptor.getValue() > 0);
    }


    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
