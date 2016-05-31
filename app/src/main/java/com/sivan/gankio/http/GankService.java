package com.sivan.gankio.http;

import com.sivan.gankio.bean.DailyData;
import com.sivan.gankio.bean.GankItemData;
import com.sivan.gankio.bean.HttpResult;
import com.sivan.gankio.common.Constant;

import java.util.List;

import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by lixinwei on 16/5/30.
 */
public interface GankService {

    /**
     * 分类数据
     * @param type 数据类型: 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端 | all
     * @param count 请求个数: 数字，大于0
     * @param page 第几页: 数字，大于0
     * @return
     */
    @GET(Constant.CLASSIFICATION)
    Observable<HttpResult<List<GankItemData>>> getClfData(@Path("type") String type,
                                                          @Path("count") int count,
                                                          @Path("page") int page);

    /**
     * 每日数据
     * @param year 年
     * @param month 月
     * @param day 日
     * @return
     */
    @GET(Constant.DAY_DATA)
    Observable<HttpResult<DailyData>> getDailyData(@Path("year") int year,
                                                   @Path("month") int month,
                                                   @Path("day") int day);

    /**
     * 随即数据
     * @param type 数据类型: 福利 | Android | iOS | 休息视频 | 拓展资源 | 前端
     * @param count 请求个数: 数字，大于0
     * @return
     */
    @GET(Constant.RANDOM_DATA)
    Observable<HttpResult<GankItemData>> getRandomData(@Path("type") String type,
                                                       @Path("count") int count);


}
