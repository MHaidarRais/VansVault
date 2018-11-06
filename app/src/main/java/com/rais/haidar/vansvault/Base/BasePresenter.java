package com.rais.haidar.vansvault.Base;

public interface BasePresenter<T extends BaseView> {

    void onAttach(T v);
    void onDetach();

}

