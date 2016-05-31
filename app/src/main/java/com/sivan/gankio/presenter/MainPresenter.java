package com.sivan.gankio.presenter;

import com.sivan.gankio.bean.GankItemData;
import com.sivan.gankio.model.OnRequestClfDataListener;
import com.sivan.gankio.model.RequestClfDataImpl;
import com.sivan.gankio.ui.view.MainView;

import java.util.List;

/**
 * Created by lixinwei on 16/5/31.
 */
public class MainPresenter {
    private RequestClfDataImpl mRequestClfData;

    private MainView mMainView;

    public MainPresenter(MainView mainView) {
        mRequestClfData = new RequestClfDataImpl();
        mMainView = mainView;
    }

    public void getClfData() {
        mMainView.showLoading();
        mRequestClfData.onRequestClfData(mMainView.getType(), mMainView.getCount(),
                mMainView.getPage(), new OnRequestClfDataListener() {
                    @Override
                    public void onRequestSuccess(List<GankItemData> itemDataList) {
                        mMainView.hideLoading();
                        mMainView.showResults(itemDataList);
                    }

                    @Override
                    public void onRequestFailed(Throwable throwable) {
                        mMainView.hideLoading();
                        mMainView.showError(throwable);
                    }
                });
    }

}
