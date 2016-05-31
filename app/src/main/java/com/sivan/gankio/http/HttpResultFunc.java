package com.sivan.gankio.http;

import com.sivan.gankio.bean.HttpResult;

import rx.functions.Func1;

/**
 * Created by lixinwei on 16/5/31.
 */
public class HttpResultFunc<T> implements Func1<HttpResult<T>, T> {
    @Override
    public T call(HttpResult<T> tHttpResult) {
        return tHttpResult.getResults();
    }
}
