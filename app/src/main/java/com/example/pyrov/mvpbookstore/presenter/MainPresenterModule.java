package com.example.pyrov.mvpbookstore.presenter;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MainPresenterModule implements MainContract {
    @Singleton
    @Provides
    MainPresenter provide() {
        return new MainPresenter();
    }
}
