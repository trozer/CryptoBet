package com.example.mobsoft.cryptobet;

import com.example.mobsoft.cryptobet.interactor.InteractorModule;
import com.example.mobsoft.cryptobet.mock.MockDatabaseModule;
import com.example.mobsoft.cryptobet.mock.MockNetworkModule;
import com.example.mobsoft.cryptobet.test.MainTest;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, MockDatabaseModule.class})
public interface TestComponent extends CryptobetApplicationComponent {
    void inject(MainTest mainTest);
}
