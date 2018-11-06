package com.rais.haidar.vansvault.Main.presenter;

import com.rais.haidar.vansvault.Base.BasePresenter;
import com.rais.haidar.vansvault.Main.model.ArticlesItem;
import com.rais.haidar.vansvault.Main.model.ResponseVans;
import com.rais.haidar.vansvault.Main.view.MainView;
import com.rais.haidar.vansvault.Network.configNetwork;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements BasePresenter<MainView> {
    MainView mainView;
    private String apikey = "5h30dB4K4Uwuhj4KkmHmFkrBzQHtf2wGPVQSARoCa+HgMHZRk0/vFn0ZKpFDgc1KYy/F7LEE8nAOHhKgru6btQ==";

    public Call<ResponseVans> call() {
        return configNetwork.getInstance().getVans();
    }

    public void getData(){
        call().enqueue(new Callback<ResponseVans>() {
            @Override
            public void onResponse(Call<ResponseVans> call, Response<ResponseVans> response) {
                if (response.body().getStatus().equalsIgnoreCase("ok")){
                    List<ArticlesItem> articlesItems = response.body().getArticles();
                    mainView.onSuccess(articlesItems);
                }else {
                    mainView.onError("GAGAL mengambil data");
                }
            }

            @Override
            public void onFailure(Call<ResponseVans> call, Throwable t) {
                mainView.onError(t.getMessage());
            }

        });
    }

    @Override
    public void onAttach(MainView v) {
        mainView = v;
    }

    @Override
    public void onDetach() {
        mainView = null;
    }
}
