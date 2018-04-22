package com.example.mobsoft.cryptobet.mock;

import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class MockNetworkModule {

    @Provides
    @Singleton
    public Retrofit.Builder provideRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()));

    }

    @Provides
    @Singleton
    public MockCryptoCurrenciesInfoApi provideCryptosApi(Retrofit.Builder retrofitBuilder) {
        return new MockCryptoCurrenciesInfoApi();
    }
}
