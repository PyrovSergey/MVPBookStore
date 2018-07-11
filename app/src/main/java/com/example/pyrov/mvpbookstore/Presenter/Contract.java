package com.example.pyrov.mvpbookstore.Presenter;

import com.example.pyrov.mvpbookstore.Model.Book;

import java.util.List;

public interface Contract {
    interface PresenterContract {
        void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber);

        List<Book> getBookList();

        Book getChoiceBook(int id);
    }

    interface ViewContract {

    }
}
