package com.sivan.gankio.http;

import com.sivan.gankio.bean.BaseResult;
import com.sivan.gankio.bean.ItemData;
import com.sivan.gankio.common.Constant;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by lixinwei on 16/5/30.
 */
public interface GankService {

    @GET(Constant.CLASSIFICATION)
    Observable<BaseResult<List<ItemData>>> getClassificationData(@Path("type") String type,
                                                                 @Path("count") int count,
                                                                 @Path("page") int page);
}
