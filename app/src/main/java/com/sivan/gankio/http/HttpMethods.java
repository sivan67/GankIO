package com.sivan.gankio.http;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sivan.gankio.bean.GankItemData;
import com.sivan.gankio.bean.HttpResult;
import com.sivan.gankio.common.Constant;
import com.sivan.gankio.util.L;
import com.sivan.gankio.util.RxUtil;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;

/**
 * Created by lixinwei on 16/5/30.
 */
public class HttpMethods {
    private static HttpMethods INSTANCE;
    private static final String TAG = "HttpMethods";
    private Retrofit mRetrofit;
    private GankService mGankService;

    private HttpMethods() {
        // 添加 http 请求 log 打印日志
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
                    @Override
                    public void log(String message) {
                        if (message.startsWith("{") || message.startsWith("[")) {
                            L.j(message);
                        } else{
                            Log.d(TAG, message);
                        }
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY));

        Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").serializeNulls().create();
        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(builder.build())
                .build();
        mGankService = mRetrofit.create(GankService.class);

    }

    public static HttpMethods getInstance() {
        if (INSTANCE == null) {
            synchronized (HttpMethods.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HttpMethods();
                }
            }
        }
        return INSTANCE;
    }

    public Observable<List<GankItemData>> getClfData(String type, int count, int page) {
        return mGankService.getClfData(type, count, page)
                .compose(RxUtil.<HttpResult<List<GankItemData>>>rxSchedulerHelper())

//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribeOn(Schedulers.io())
//                .compose(RxUtil.<List<GankItemData>>handleResult())
                .map(new HttpResultFunc<List<GankItemData>>());
    }
}
