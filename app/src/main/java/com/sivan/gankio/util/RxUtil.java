package com.sivan.gankio.util;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by lixinwei on 16/5/31.
 */
public class RxUtil {

    public static <T> Observable.Transformer<T, T> rxSchedulerHelper() {

        return new Observable.Transformer<T, T>() {
            @Override
            public Observable<T> call(Observable<T> tObservable) {
                return tObservable
                        .observeOn(AndroidSchedulers.mainThread())
                        .unsubscribeOn(Schedulers.io())
                        .subscribeOn(Schedulers.io());
            }
        };
    }

//    public static <T> Observable.Transformer<HttpResult<T>, T> handleResult() {
//        return new Observable.Transformer<HttpResult<T>, T>() {
//            @Override
//            public Observable<T> call(Observable<HttpResult<T>> httpResultObservable) {
//                return httpResultObservable.flatMap(new Func1<HttpResult<T>, Observable<?>>() {
//                    @Override
//                    public Observable<?> call(HttpResult<T> tHttpResult) {
//                        if (tHttpResult.isError()) {
//                            return Observable.error(new Throwable());
//                        }
//                        return null;
//                    }
//                });
//            }
//        }
//    }
}
