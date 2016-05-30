package com.sivan.gankio.http;

import android.util.Log;

import com.sivan.gankio.bean.BaseResult;
import com.sivan.gankio.bean.ItemData;
import com.sivan.gankio.common.Constant;

import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

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
                        Log.d(TAG, message);
                    }
                }).setLevel(HttpLoggingInterceptor.Level.BODY));

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
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

    public Observable<List<ItemData>> getClassification(String type, int count, int page) {
        return mGankService.getClassificationData(type, count, page)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .map(new Func1<BaseResult<List<ItemData>>, List<ItemData>>() {
                    @Override
                    public List<ItemData> call(BaseResult<List<ItemData>> listBaseResult) {
                        return listBaseResult.getT();
                    }
                });
    }
}
