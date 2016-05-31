package com.sivan.gankio.model;

import com.sivan.gankio.bean.GankItemData;

import java.util.List;

/**
 * Created by lixinwei on 16/5/31.
 */
public interface OnRequestClfDataListener {
    void onRequestSuccess(List<GankItemData> itemDataList);

    void onRequestFailed(Throwable throwable);
}
