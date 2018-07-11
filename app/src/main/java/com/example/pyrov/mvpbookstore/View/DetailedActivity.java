package com.example.pyrov.mvpbookstore.View;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.pyrov.mvpbookstore.Model.Book;
import com.example.pyrov.mvpbookstore.Presenter.DetailedContract;
import com.example.pyrov.mvpbookstore.Presenter.DetailedPresenter;
import com.example.pyrov.mvpbookstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailedActivity extends AppCompatActivity implements DetailedContract.DetailedView {
    @BindView(R.id.button_delete)
    FloatingActionButton buttonDelete;
    @BindView(R.id.image)
    ImageView image;
    @BindView(R.id.edit_book_title)
    EditText editBookTitle;
    @BindView(R.id.edit_book_price)
    EditText editBookPrice;
    @BindView(R.id.edit_book_supplier_name)
    EditText editBookSupplierName;
    @BindView(R.id.edit_book_supplier_phone_number)
    EditText editBookSupplierPhoneNumber;
    @BindView(R.id.button_minus)
    ImageButton buttonMinus;
    @BindView(R.id.edit_book_quantity)
    EditText editBookQuantity;
    @BindView(R.id.button_plus)
    ImageButton buttonPlus;
    @BindView(R.id.button_back)
    FloatingActionButton buttonBack;
    @BindView(R.id.button_call)
    FloatingActionButton buttonCall;
    @BindView(R.id.button_save)
    FloatingActionButton buttonSave;
    private DetailedContract.DetailedPresenter detailedPresenter;
    private static final String DETAIL = "detail";
    private boolean isNewBook = true;
    private Book book;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);
        ButterKnife.bind(this);
        detailedPresenter = new DetailedPresenter(this);

        Intent intent = getIntent();
        if (intent != null) {
            book = intent.getParcelableExtra(DETAIL);
            if (book != null) {
                isNewBook = false;
                editBookTitle.setText(book.getBookName());
                editBookPrice.setText(book.getPrice());
                editBookSupplierName.setText(book.getSupplierName());
                editBookSupplierPhoneNumber.setText(book.getSupplierPhone());
                editBookQuantity.setText(String.valueOf(book.getQuantity()));
            } else {
                buttonDelete.setVisibility(View.INVISIBLE);
                editBookQuantity.setText("0");
            }
        }
    }

    @OnClick(R.id.button_delete)
    public void onButtonDeleteClicked() {
        detailedPresenter.buttonDeleteClick();
    }

    @OnClick(R.id.button_minus)
    public void onButtonMinusClicked() {
        detailedPresenter.buttonMinusClick();
    }

    @OnClick(R.id.button_plus)
    public void onButtonPlusClicked() {
        detailedPresenter.buttonPlusClick();
    }

    @OnClick(R.id.button_back)
    public void onButtonBackClicked() {
        detailedPresenter.buttonBackClick();
    }

    @OnClick(R.id.button_call)
    public void onButtonCallClicked() {
        detailedPresenter.buttonCallClick();
    }

    @Override
    public Boolean isNewBook() {
        return isNewBook;
    }

    @Override
    public int getIdBook() {
        return book.getId();
    }

    @Override
    public void alertMessageAndDelete() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Delete")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.ic_delete_blue_900_48dp)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                        detailedPresenter.deleteBook(getIdBook());
                        finish();
                    }
                })
                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @OnClick(R.id.button_save)
    public void onButtonSaveClicked() {
        detailedPresenter.buttonSaveClick();
    }

    @Override
    public int getBookQuantity() {
        return Integer.parseInt(editBookQuantity.getText().toString());
    }

    @Override
    public String getBookTitle() {
        return editBookTitle.getText().toString();
    }

    @Override
    public String getBookPrice() {
        return editBookPrice.getText().toString();
    }

    @Override
    public String getBookSupplierName() {
        return editBookSupplierName.getText().toString();
    }

    @Override
    public String getBookSupplierPhoneNumber() {
        return editBookSupplierPhoneNumber.getText().toString();
    }

    @Override
    public void setBookQuantity(int quantity) {
        editBookQuantity.setText(String.valueOf(quantity));
    }

    @Override
    public void alertMessageAndExit() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning")
                .setMessage("Are you sure?")
                .setIcon(R.drawable.ic_warning_blue_900_48dp)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                        finish();
                    }
                }).setNegativeButton(R.string.cancel,
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    public void alertMessage(String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning")
                .setMessage(message)
                .setIcon(R.drawable.ic_warning_blue_900_48dp)
                .setCancelable(false)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.cancel();
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }

    @Override
    protected void onDestroy() {
        detailedPresenter.detachView();
        super.onDestroy();
    }

    @Override
    public void closeDetailView() {
        finish();
    }
}
