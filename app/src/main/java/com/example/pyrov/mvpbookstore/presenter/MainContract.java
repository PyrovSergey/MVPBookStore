package com.example.pyrov.mvpbookstore.presenter;

import com.example.pyrov.mvpbookstore.model.Book;

import java.util.List;

public interface MainContract {
    interface PresenterContract {
        void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber);

        List<Book> getBookList();

        Book getChoiceBook(int id);
    }

    interface ViewContract {
        void isShowTextInstruction(Boolean isShow);
    }
}
