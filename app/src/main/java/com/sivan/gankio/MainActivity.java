package com.sivan.gankio;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.sivan.gankio.bean.GankItemData;
import com.sivan.gankio.presenter.MainPresenter;
import com.sivan.gankio.ui.view.MainView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements MainView, SwipeRefreshLayout.OnRefreshListener {

    private static final String TAG = "MainActivity";
    @BindView(R.id.rv_main)
    RecyclerView mRvMain;
    @BindView(R.id.srl_main)
    SwipeRefreshLayout mSrlMain;
    @BindView(R.id.pb_main)
    ProgressBar mPbMain;

    private MainPresenter mMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSrlMain.setOnRefreshListener(this);

        mMainPresenter = new MainPresenter(this);

        mMainPresenter.getClfData();
    }

    @Override
    public String getType() {
        return "Android";
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public int getPage() {
        return 1;
    }

    @Override
    public void refreshData() {

    }

    @Override
    public void refreshCompleted() {

    }

    @Override
    public void showResults(List<GankItemData> itemDataList) {
        Snackbar.make(mRvMain, itemDataList.size() + "", Snackbar.LENGTH_LONG).show();

    }

    @Override
    public void showError(Throwable t) {
        Snackbar.make(mRvMain, t.getMessage(), Snackbar.LENGTH_LONG).show();
    }

    @Override
    public void showLoading() {
        mPbMain.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mPbMain.setVisibility(View.GONE);
    }

    @Override
    public void onRefresh() {

    }
}
