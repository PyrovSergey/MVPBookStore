package com.example.pyrov.mvpbookstore.Model;

import java.util.List;

public interface ContractData {
    List<Book> getBooksData();

    Book getBook(int id);

    void deleteBook(long id);

    void insertBook(String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber);

    void updateBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber);
}
