package com.sivan.gankio.ui.view;

import com.sivan.gankio.bean.GankItemData;

import java.util.List;

/**
 * Created by lixinwei on 16/5/31.
 */
public interface MainView {

    String getType();

    int getCount();

    int getPage();

    void refreshData();

    void refreshCompleted();

    void showResults(List<GankItemData> itemDataList);

    void showError(Throwable t);

    void showLoading();

    void hideLoading();

}
