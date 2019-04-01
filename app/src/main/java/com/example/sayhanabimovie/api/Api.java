/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.api;

import com.example.sayhanabimovie.bean.AllAnimesBean;
import com.example.sayhanabimovie.bean.AnimesDetailBean;
import com.example.sayhanabimovie.bean.AnimesInfoBean;
import com.example.sayhanabimovie.bean.AnimesResourceBean;
import com.example.sayhanabimovie.bean.TestBean;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author SakuramiRin
 * @date 2019-03-30 13:48
 */
public interface Api {
    @GET("animes/video/6/resource")
    Observable<List<AnimesDetailBean>> getAnimeDetailAPI();

    @FormUrlEncoded
    @POST("login")
    Observable<TestBean> loginApi(@Field("email") String email, @Field("password") String password);

    @FormUrlEncoded
    @POST("register")
    Observable<TestBean> registerApi(@Field("name") String name, @Field("email") String email, @Field("password") String password);

    /**
     * 获取指定动漫详情
     * @param id ID
     * @param withVideo 是否返回动漫里的视频详情 【可空】
     * @return API
     */
    @GET("name/{id}/info")
    Observable<AnimesInfoBean> animesInfoApi(@Path("id") String id, @Query("withVideo") String withVideo);

    /**
     * 获取动漫的内容详情
     * @param with 带此参数会返回资源数据 【可空】true | false 字符串
     * @return API
     */
    @GET("animes/{id}/video")
    Observable<AnimesDetailBean> animesDetailApi(@Query("with") String with);

    /**
     *获取指定集的资源
     * @param id ID
     * @param info  带此参数会连同该集信息一并返回【可空】
     * @return API
     */
    @GET("animes/video/{id}/resource")
    Observable<AnimesResourceBean> animesResourceApi(@Path("id") String id, @Query("info") String info);

    /**
     * 获取所有动漫
     * @param paginate 每页显示多少数据 【可空】true | false 字符串
     * @return API
     */
    @GET("animes/")
    Observable<AllAnimesBean> allAnimesApi(@Query("paginate") String paginate);

    /**
     * 新番时间表
     * @return API
     */
    @GET("animes/timeline")
    Observable<TestBean> animesTimeLineApi();

    @GET("animes/recently-updated")
    Observable<TestBean> animesRecentlyUpdatedApi();

    @GET("animes/tags")
    Observable<TestBean> animesTagsApi(@Query("type") String type);

}
