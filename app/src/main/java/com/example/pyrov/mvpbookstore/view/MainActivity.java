package com.example.pyrov.mvpbookstore.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pyrov.mvpbookstore.R;
import com.example.pyrov.mvpbookstore.model.App;
import com.example.pyrov.mvpbookstore.presenter.MainContract;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainAdapter.ViewAdapter, MainContract.ViewContract {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.button_add)
    FloatingActionButton buttonAdd;
    @BindView(R.id.text_instruction)
    TextView textInstruction;
    private MainContract.PresenterContract presenter;
    private RecyclerAdapter adapter;
    private static final String DETAIL = "detail";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        presenter = App.getComponent().getMainPresenter();
        presenter.onAttach(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter = new RecyclerAdapter(this, presenter.getBookList());
        recycler.setAdapter(adapter);
    }

    @OnClick(R.id.button_add)
    public void onViewClicked() {
        Intent intent = new Intent(this, DetailedActivity.class);
        startActivity(intent);
    }

    @Override
    public void updateDataBook(long id, String bookName, String bookPrice, int quantity, String supplierName, String supplierPhoneNumber) {
        presenter.updateDataBook(id, bookName, bookPrice, quantity, supplierName, supplierPhoneNumber);
    }

    @Override
    public void buttonSettingDetailClick(int id) {
        Intent intent = new Intent(this, DetailedActivity.class);
        intent.putExtra(DETAIL, presenter.getChoiceBook(id));
        startActivity(intent);
    }

    @Override
    public void isShowTextInstruction(Boolean isShow) {
        if (isShow) {
            textInstruction.setVisibility(View.VISIBLE);
        } else {
            textInstruction.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.onDetach();
    }
}
