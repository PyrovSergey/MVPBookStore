package com.example.pyrov.mvpbookstore.view;

public interface MainAdapter {
    interface ViewAdapter {
        void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber);

        void buttonSettingDetailClick(int id);


    }
}
