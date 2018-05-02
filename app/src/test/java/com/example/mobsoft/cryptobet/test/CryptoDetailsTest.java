package com.example.mobsoft.cryptobet.test;

import com.example.mobsoft.cryptobet.BuildConfig;
import com.example.mobsoft.cryptobet.model.Currency;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsPresenter;
import com.example.mobsoft.cryptobet.ui.details.CryptoDetailsScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.time.Month;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static com.example.mobsoft.cryptobet.TestHelper.setTestInjector;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class)
public class CryptoDetailsTest {
    private CryptoDetailsPresenter cryptoDetailsPresenter;
    private CryptoDetailsScreen cryptoDetailsScreen;

    @Before
    public void setup() throws Exception{
        setTestInjector();
        cryptoDetailsScreen = mock(CryptoDetailsScreen.class);
        cryptoDetailsPresenter = new CryptoDetailsPresenter();
        cryptoDetailsPresenter.attachScreen(cryptoDetailsScreen);
    }

    @Test
    public void testSaveBetSuccessful(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) + 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");
        ArgumentCaptor<String> cNameCaptor = ArgumentCaptor.forClass(String.class);
        ArgumentCaptor<Integer> yearCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> monthCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> dayOfMonthCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> hourCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> minuteCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Float> pricerCaptor = ArgumentCaptor.forClass(Float.class);
        verify(cryptoDetailsScreen).successfulBet(cNameCaptor.capture(), yearCaptor.capture(),
                monthCaptor.capture(), dayOfMonthCaptor.capture(),
                hourCaptor.capture(), minuteCaptor.capture(), pricerCaptor.capture());
        assertEquals(currency.getName(), cNameCaptor.getValue());
        assertEquals((long)(cal.get(Calendar.YEAR) + 1),(long) yearCaptor.getValue());
        assertEquals((long)(cal.get(Calendar.MONTH)),(long) monthCaptor.getValue());
        assertEquals((long)(cal.get(Calendar.DAY_OF_MONTH)),(long) dayOfMonthCaptor.getValue());
        assertEquals((long)(cal.get(Calendar.HOUR_OF_DAY)),(long) hourCaptor.getValue());
        assertEquals((long)(cal.get(Calendar.MINUTE)),(long) minuteCaptor.getValue());
        assertTrue(pricerCaptor.getValue() >= 0);
        verify(cryptoDetailsScreen).disableBetUI();
    }

    @Test
    public void testSaveBetUnSuccessfulCheckActivity(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) + 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) + 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");

        ArgumentCaptor<String> exception = ArgumentCaptor.forClass(String.class);
        verify(cryptoDetailsScreen).failBet(exception.capture());
        assertEquals("You already made a bet on this currency", exception.getValue());
    }

    @Test
    public void testSaveBetUnSuccessfulWrongTime(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) - 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");

        ArgumentCaptor<String> exception = ArgumentCaptor.forClass(String.class);
        verify(cryptoDetailsScreen).failBet(exception.capture());
        assertEquals("Given date time is before the current date", exception.getValue());
    }

    @Test
    public void testSaveBetUnSuccessfulWrongPrice(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));


        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) - 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "asd");

        ArgumentCaptor<String> exception = ArgumentCaptor.forClass(String.class);
        verify(cryptoDetailsScreen).failBet(exception.capture());
        assertNotNull(exception.getValue());
    }

    @Test
    public void testSetBetSelection(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) + 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");
        cryptoDetailsPresenter.setBetSelection(currency);

        ArgumentCaptor<Integer> yearCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> monthCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> dayOfMonthCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> hourCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<Integer> minuteCaptor = ArgumentCaptor.forClass(Integer.class);
        ArgumentCaptor<String> pricerCaptor = ArgumentCaptor.forClass(String.class);
        verify(cryptoDetailsScreen).setBetSelectState(yearCaptor.capture(),
                monthCaptor.capture(), dayOfMonthCaptor.capture(), hourCaptor.capture(),
                minuteCaptor.capture(), pricerCaptor.capture());
        assertTrue(yearCaptor.getValue() > 0);
        assertTrue(monthCaptor.getValue() > 0);
        assertTrue(dayOfMonthCaptor.getValue() > 0);
        assertTrue(hourCaptor.getValue() > 0);
        assertTrue(minuteCaptor.getValue() > 0);
        assertNotNull(pricerCaptor.getValue());
    }

    @Test
    public void testCheckActivityTrue(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) + 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");
        assertTrue(cryptoDetailsPresenter.checkActivity(currency));

    }

    @Test
    public void testCheckActivityFalse(){
        Currency currency = new Currency();
        currency.setName("Bitcoin");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));

        Currency currency2 = new Currency();
        currency.setName("Ethereum");
        currency.setPriceUsd(5500.34f);
        currency.setLastUpdated((int)(new Date().getTime()/1000));

        Date date = new Date();
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cryptoDetailsPresenter.saveBet(currency, cal.get(Calendar.YEAR) + 1, cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH),
                cal.get(Calendar.HOUR_OF_DAY), cal.get(Calendar.MINUTE), "51256.67");
        assertFalse(cryptoDetailsPresenter.checkActivity(currency2));

    }


    @After
    public void tearDown() {
        cryptoDetailsPresenter.detachScreen();
    }
}
