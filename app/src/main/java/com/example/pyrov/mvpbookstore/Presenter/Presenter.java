package com.example.pyrov.mvpbookstore.Presenter;

import com.example.pyrov.mvpbookstore.Model.ContractData;
import com.example.pyrov.mvpbookstore.Model.Data;

public class Presenter {
    private ContractView view;
    private ContractData data;

    public Presenter (ContractView view) {
        this.view = view;
        data = Data.getDataInstance();
    }
}
