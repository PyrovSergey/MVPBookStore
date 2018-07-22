package com.example.pyrov.mvpbookstore.presenter;

import com.example.pyrov.mvpbookstore.model.App;
import com.example.pyrov.mvpbookstore.model.Book;
import com.example.pyrov.mvpbookstore.model.ContractData;

import java.util.List;

import javax.inject.Inject;

public class MainPresenter implements MainContract.PresenterContract {
    private MainContract.ViewContract view;
    private ContractData data;

    @Inject
    public MainPresenter() {
        data = App.getComponent().getData();
    }

    @Override
    public void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber) {
        data.updateBook(id, bookName, bookPrice, quantity, supplierName, supplierPhoneNumber);
    }

    @Override
    public List<Book> getBookList() {
        List<Book> list = data.getBooksData();
        view.isShowTextInstruction(list.isEmpty());
        return list;
    }

    @Override
    public Book getChoiceBook(int id) {
        return data.getBook(id);
    }

    @Override
    public void onAttach(MainContract.ViewContract view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        view = null;
    }
}
