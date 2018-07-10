package com.example.pyrov.mvpbookstore.View;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.pyrov.mvpbookstore.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements Adapter.ViewAdapter {

    @BindView(R.id.recycler)
    RecyclerView recycler;
    @BindView(R.id.button_add)
    FloatingActionButton buttonAdd;
    @BindView(R.id.text_instruction)
    TextView textInstruction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        LinearLayoutManager manager = new LinearLayoutManager(this);
        recycler.setLayoutManager(manager);
        RecyclerAdapter adapter = new RecyclerAdapter();
    }

    @OnClick(R.id.button_add)
    public void onViewClicked() {
        Intent intent = new Intent(this, DetailedActivity.class);
        startActivity(intent);
    }

    @Override
    public void buttonSaleClick(int id) {

    }

    @Override
    public void buttonSettingDetailClick(int id) {

    }

    @Override
    public void visibilityTextInstruction(Boolean visibility) {
        if (visibility) {
            textInstruction.setVisibility(View.VISIBLE);
        } else {
            textInstruction.setVisibility(View.INVISIBLE);
        }
    }
}
