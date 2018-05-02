package com.example.mobsoft.cryptobet;

import com.example.mobsoft.cryptobet.interactor.InteractorModule;
import com.example.mobsoft.cryptobet.mock.MockDatabaseModule;
import com.example.mobsoft.cryptobet.mock.MockNetworkModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MockNetworkModule.class, TestModule.class, InteractorModule.class, MockDatabaseModule.class})
public interface TestComponent extends CryptobetApplicationComponent {
}
