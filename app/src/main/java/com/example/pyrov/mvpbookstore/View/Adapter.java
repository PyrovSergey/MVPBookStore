package com.example.pyrov.mvpbookstore.View;

public interface Adapter {
    interface ViewAdapter {
        void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber);

        void buttonSettingDetailClick(int id);

        void visibilityTextInstruction(Boolean visibility);

    }
}
