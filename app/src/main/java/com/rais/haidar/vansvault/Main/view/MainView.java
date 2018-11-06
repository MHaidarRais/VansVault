package com.rais.haidar.vansvault.Main.view;

import com.rais.haidar.vansvault.Base.BaseView;
import com.rais.haidar.vansvault.Main.model.ArticlesItem;

import java.util.List;

public interface MainView extends BaseView {
    void onSuccess(List<ArticlesItem> data);
    void onError(String msg);

}
