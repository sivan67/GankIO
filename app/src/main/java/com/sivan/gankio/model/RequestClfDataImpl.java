package com.sivan.gankio.model;

import com.sivan.gankio.bean.GankItemData;
import com.sivan.gankio.http.HttpMethods;

import java.util.List;

import rx.Subscriber;

/**
 * Created by lixinwei on 16/5/31.
 */
public class RequestClfDataImpl implements RequestClfData{

    @Override
    public void onRequestClfData(String type, int count, int page, final OnRequestClfDataListener requestClfDataListener) {
        HttpMethods.getInstance().getClfData(type, count, page)
                .subscribe(new Subscriber<List<GankItemData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {
                        requestClfDataListener.onRequestFailed(e);
                    }

                    @Override
                    public void onNext(List<GankItemData> itemDataList) {
                        requestClfDataListener.onRequestSuccess(itemDataList);
                    }
                });
    }
}
