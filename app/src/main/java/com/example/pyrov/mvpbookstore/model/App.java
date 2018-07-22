package com.example.pyrov.mvpbookstore.model;

import android.app.Application;
import android.content.Context;

import com.example.pyrov.mvpbookstore.presenter.AppComponent;
import com.example.pyrov.mvpbookstore.presenter.DaggerAppComponent;

public class App extends Application {
    private static AppComponent component;
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        component = DaggerAppComponent.create();
        context = getApplicationContext();
    }

    public static AppComponent getComponent() {
        return component;
    }

    public static Context getAppContext() {
        return context;
    }
}
