package com.sivan.gankio.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by lixinwei on 16/5/31.
 */
public class DailyData {
    @SerializedName("Android")
    private List<GankItemData> androidList;
    @SerializedName("iOS")
    private List<GankItemData> iOSList;
    @SerializedName("休息视频")
    private List<GankItemData> restList;
    @SerializedName("拓展资源")
    private List<GankItemData> expandList;
    @SerializedName("瞎推荐")
    private List<GankItemData> blindRecList;
    @SerializedName("福利")
    private List<GankItemData> welfareList;

    public List<GankItemData> getAndroidList() {
        return androidList;
    }

    public void setAndroidList(List<GankItemData> androidList) {
        this.androidList = androidList;
    }

    public List<GankItemData> getiOSList() {
        return iOSList;
    }

    public void setiOSList(List<GankItemData> iOSList) {
        this.iOSList = iOSList;
    }

    public List<GankItemData> getRestList() {
        return restList;
    }

    public void setRestList(List<GankItemData> restList) {
        this.restList = restList;
    }

    public List<GankItemData> getExpandList() {
        return expandList;
    }

    public void setExpandList(List<GankItemData> expandList) {
        this.expandList = expandList;
    }

    public List<GankItemData> getBlindRecList() {
        return blindRecList;
    }

    public void setBlindRecList(List<GankItemData> blindRecList) {
        this.blindRecList = blindRecList;
    }

    public List<GankItemData> getWelfareList() {
        return welfareList;
    }

    public void setWelfareList(List<GankItemData> welfareList) {
        this.welfareList = welfareList;
    }
}
