package com.example.pyrov.mvpbookstore.presenter;

import com.example.pyrov.mvpbookstore.model.Data;
import com.example.pyrov.mvpbookstore.model.DataModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {MainPresenterModule.class, DetailedPresenterModule.class, DataModule.class})
public interface AppComponent {
    MainPresenter getMainPresenter();

    DetailedPresenter getDetailedPresenter();

    Data getData();
}
