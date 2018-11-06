package com.rais.haidar.vansvault.Main.activity;

import android.os.Build;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;
import android.widget.Toolbar;

import com.rais.haidar.vansvault.Main.model.ArticlesItem;
import com.rais.haidar.vansvault.Main.presenter.MainPresenter;
import com.rais.haidar.vansvault.Main.view.MainView;
import com.rais.haidar.vansvault.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainView {


    private MainPresenter mainPresenter;
    RecyclerView rcView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rcView = findViewById(R.id.rcView);
        mainPresenter = new MainPresenter();
        onAttachView();

    }

    @Override
    public void onSuccess(List<ArticlesItem> data) {
        rcView.setLayoutManager(new LinearLayoutManager(this));
        rcView.setAdapter(new MainAdapter(MainActivity.this,data));
    }

    @Override
    public void onError(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onAttachView() {
        mainPresenter.onAttach(this);
        mainPresenter.getData();

    }

    @Override
    public void onDetachView() {

    }
}
