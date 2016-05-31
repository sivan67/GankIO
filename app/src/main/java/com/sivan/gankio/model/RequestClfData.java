package com.sivan.gankio.model;

/**
 * Created by lixinwei on 16/5/31.
 */
public interface RequestClfData {

    void onRequestClfData(String type, int count, int page, OnRequestClfDataListener requestClfDataListener);
}
