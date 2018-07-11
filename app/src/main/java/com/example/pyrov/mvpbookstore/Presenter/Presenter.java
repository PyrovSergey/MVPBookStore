package com.example.pyrov.mvpbookstore.Presenter;

import com.example.pyrov.mvpbookstore.Model.Book;
import com.example.pyrov.mvpbookstore.Model.ContractData;
import com.example.pyrov.mvpbookstore.Model.Data;

import java.util.List;

public class Presenter implements Contract.PresenterContract {
    private Contract.ViewContract view;
    private ContractData data;

    public Presenter(Contract.ViewContract view) {
        this.view = view;
        data = Data.getDataInstance();
    }

    @Override
    public void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber) {
        data.updateBook(id, bookName, bookPrice, quantity, supplierName, supplierPhoneNumber);
    }

    @Override
    public List<Book> getBookList() {
        return data.getBooksData();
    }

    @Override
    public Book getChoiceBook(int id) {
        return data.getBook(id);
    }
}
