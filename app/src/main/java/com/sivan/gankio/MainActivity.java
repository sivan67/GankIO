package com.sivan.gankio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.sivan.gankio.bean.GankItemData;
import com.sivan.gankio.http.HttpMethods;

import java.util.List;

import rx.Subscriber;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HttpMethods.getInstance().getClfData("Android", 10, 1)
                .subscribe(new Subscriber<List<GankItemData>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<GankItemData> gankItemDatas) {
                        Log.d(TAG, gankItemDatas.toString());
                    }
                });
    }
}
