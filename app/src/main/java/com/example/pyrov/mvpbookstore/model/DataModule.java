package com.example.pyrov.mvpbookstore.model;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;


@Module
public class DataModule {
    @Singleton
    @Provides
    Data provideData() {
        return new Data();
    }
}
