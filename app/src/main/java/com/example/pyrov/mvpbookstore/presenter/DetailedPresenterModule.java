package com.example.pyrov.mvpbookstore.presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class DetailedPresenterModule {
    @Singleton
    @Provides
    DetailedPresenter provideDetailedPresenter(){
        return new DetailedPresenter();
    }
}
