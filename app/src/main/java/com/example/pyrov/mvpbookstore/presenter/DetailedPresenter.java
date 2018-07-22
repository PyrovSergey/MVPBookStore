package com.example.pyrov.mvpbookstore.presenter;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;

import com.example.pyrov.mvpbookstore.R;
import com.example.pyrov.mvpbookstore.model.App;
import com.example.pyrov.mvpbookstore.model.ContractData;

import javax.inject.Inject;

public class DetailedPresenter implements DetailedContract.DetailedPresenter {

    private DetailedContract.DetailedView detailedView;
    private ContractData data;

    public DetailedPresenter() {
        data = App.getComponent().getData();
    }

    @Override
    public void buttonPlusClick() {
        int quantity = detailedView.getBookQuantity();
        detailedView.setBookQuantity(++quantity);
    }

    @Override
    public void buttonMinusClick() {
        int quantity = detailedView.getBookQuantity();
        quantity = --quantity;
        if (quantity < 0) {
            quantity = 0;
        }
        detailedView.setBookQuantity(quantity);
    }

    @Override
    public void buttonSaveClick() {
        String title = detailedView.getBookTitle();
        String price = detailedView.getBookPrice();
        int quantity = detailedView.getBookQuantity();
        String supplier = detailedView.getBookSupplierName();
        String phoneNumber = detailedView.getBookSupplierPhoneNumber();
        if (TextUtils.isEmpty(title) |
                TextUtils.isEmpty(price) |
                TextUtils.isEmpty(supplier) |
                TextUtils.isEmpty(phoneNumber) |
                quantity == 0) {
            detailedView.alertMessage("Fill in all fields");
        } else {
            if (detailedView.isNewBook()) {
                data.insertBook(title, price, quantity, supplier, phoneNumber);
                detailedView.closeDetailView();
            } else {
                data.updateBook(detailedView.getIdBook(), title, price, quantity, supplier, phoneNumber);
                detailedView.closeDetailView();
            }
        }
    }

    @Override
    public void buttonBackClick() {
        detailedView.alertMessageAndExit();
    }

    @Override
    public void buttonDeleteClick() {
        detailedView.alertMessageAndDelete();
    }

    @Override
    public void buttonCallClick() {
        Context context = App.getAppContext();
        String phoneNumber = detailedView.getBookSupplierPhoneNumber();
        if (!TextUtils.isEmpty(phoneNumber)) {
            Intent intentCall = new Intent(Intent.ACTION_DIAL);
            intentCall.setData(Uri.parse(context.getString(R.string.tel) + phoneNumber));
            context.startActivity(intentCall);
        } else {
            detailedView.alertMessage("Enter the supplier's phone number!");
        }
    }

    @Override
    public void detachView() {
        detailedView = null;
    }

    @Override
    public void deleteBook(int id) {
        data.deleteBook(id);
    }

    @Override
    public void onAttach(DetailedContract.DetailedView detailedView) {
        this.detailedView = detailedView;
    }

    @Override
    public void onDetach() {
        detailedView = null;
    }
}
