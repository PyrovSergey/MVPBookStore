package com.example.pyrov.mvpbookstore.presenter;

import com.example.pyrov.mvpbookstore.model.Data;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component
public interface AppComponent {
    MainPresenter getMainPresenter();

    DetailedPresenter getDetailedPresenter();

    Data getData();
}
