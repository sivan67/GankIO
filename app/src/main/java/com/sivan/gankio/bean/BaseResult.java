package com.sivan.gankio.bean;

/**
 * Created by lixinwei on 16/5/30.
 */
public class BaseResult<T> {

    private boolean error;
    private T t;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }
}
