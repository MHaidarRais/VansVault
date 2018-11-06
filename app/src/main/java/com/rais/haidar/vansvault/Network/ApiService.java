package com.rais.haidar.vansvault.Network;

import com.rais.haidar.vansvault.Main.model.ResponseVans;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("everything?q=vans&from=2018-11-04&to=2010-11-04&pagesize=100&domains=hypebeast.com&apiKey=742f9c39ed6c4d5c8874aadb10b34b79")
    Call<ResponseVans> getVans(
    );
}
