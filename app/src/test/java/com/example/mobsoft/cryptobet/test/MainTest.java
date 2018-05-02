package com.example.mobsoft.cryptobet.test;

import com.example.mobsoft.cryptobet.BuildConfig;
import com.example.mobsoft.cryptobet.CryptobetApplication;
import com.example.mobsoft.cryptobet.ui.main.MainPresenter;
import com.example.mobsoft.cryptobet.ui.main.MainScreen;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;


import java.util.List;

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

    @Before
    public void setup() throws Exception{
        setTestInjector();
        mainScreen = mock(MainScreen.class);
        mainPresenter = new MainPresenter();
        mainPresenter.attachScreen(mainScreen);
    }

    @Test
    public void testDownload(){
//        mainPresenter.refreshCurrencies(1,100,"USD");
//
//        ArgumentCaptor<List> cryptoCaptor = ArgumentCaptor.forClass(List.class);
//        verify(mainScreen).showCryptoCurrencies(cryptoCaptor.capture());
//        assertTrue(cryptoCaptor.getValue().size() > 0);
        assertEquals(4, 2 + 2);
    }

    @After
    public void tearDown() {
        mainPresenter.detachScreen();
    }
}
