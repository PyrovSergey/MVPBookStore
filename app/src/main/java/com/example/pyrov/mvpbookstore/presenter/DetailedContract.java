package com.example.pyrov.mvpbookstore.presenter;

public interface DetailedContract {
    interface DetailedView {
        int getBookQuantity();

        String getBookTitle();

        String getBookPrice();

        String getBookSupplierName();

        String getBookSupplierPhoneNumber();

        void setBookQuantity(int quantity);

        void alertMessageAndExit();

        void alertMessage(String message);

        void closeDetailView();

        Boolean isNewBook();

        int getIdBook();

        void alertMessageAndDelete();
    }

    interface DetailedPresenter {
        void buttonPlusClick();

        void buttonMinusClick();

        void buttonSaveClick();

        void buttonBackClick();

        void buttonDeleteClick();

        void buttonCallClick();

        void detachView();

        void deleteBook(int id);
    }
}
