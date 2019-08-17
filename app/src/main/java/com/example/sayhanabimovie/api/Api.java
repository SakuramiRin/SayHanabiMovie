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
    Observable<List<AnimesDetailBean>> getAnimeDetailApi();

    /**
     * 登录
     * @param email 邮箱
     * @param password 密码
     * @return API
     * 关键词    解释
     * code	状态
     * status	状态
     * token	令牌，请在 Header 中加入Authorization字段，值为Bearer xxx.xxx.xxx
     */
    @FormUrlEncoded
    @POST("login")
    Observable<TestBean> loginApi(@Field("email") String email, @Field("password") String password);

    /**
     * 注册
     * @param name 姓名
     * @param email 邮箱
     * @param password 密码
     * @return API
     * 关键词	解释
     * code	状态
     * status	状态
     * token	令牌，请在 Header 中加入Authorization字段，值为Bearer xxx.xxx.xxx
     */
    @FormUrlEncoded
    @POST("register")
    Observable<TestBean> registerApi(@Field("name") String name, @Field("email") String email, @Field("password") String password);

    /**
     * 获取指定动漫详情
     * @param id ID
     * @param withVideo 是否返回动漫里的视频详情 【可空】
     * @return API
     * 关键词	解释
     * name	动漫名称
     * cover	封面
     * watch	播放量
     * collection	收藏、追番数量
     * danmaku	弹幕总数
     * introduction	简介
     * release_time	上映时间
     * episodes	共有多少集
     * season_id	季度
     * season_id	季度名称
     */
    @GET("animes/{id}/info")
    Observable<AnimesInfoBean> animesInfoApi(@Path("id") String id, @Query("withVideo") String withVideo);

    /**
     * 获取动漫的内容详情
     * @param with 带此参数会返回资源数据 【可空】true | false 字符串
     * @return API
     * 关键词	解释
     * ranking	排序
     * name	当前集名称
     * info	当前集简介
     * coin	硬币
     * resource.*	资源详情
     */
    @GET("animes/{id}/video")
    Observable<AnimesDetailBean> animesDetailApi(@Query("with") String with);

    /**
     *获取指定集的资源
     * @param id ID
     * @param info  带此参数会连同该集信息一并返回【可空】
     * @return API
     * resource	资源地址
     * type	资源类型
     * resolution	解析度：380p 720p 1080p
     * ranking	排序
     */
    @GET("animes/video/{id}/resource")
    Observable<AnimesResourceBean> animesResourceApi(@Path("id") String id, @Query("info") String info);

    /**
     * 获取所有动漫
     * @param paginate 每页显示多少数据 【可空】true | false 字符串
     * @return API
     * 关键词	解释
     * current_page	当前页
     * data	数据
     * data.*	动漫详情
     * first_page_url	第一页 api 地址
     * last_page	分页总页数
     * total	总记录
     */
    @GET("animes/")
    Observable<AllAnimesBean> allAnimesApi(@Query("paginate") String paginate);

    /**
     * 新番时间表
     * @return API
     * 关键词	解释
     * 一维数组	星期几
     * 二维数组	更新的番剧数据
     * 获取最近更新的作品
     */
    @GET("animes/timeline")
    Observable<TestBean> animesTimeLineApi();

    /**
     * 最近更新
     * @return API
     * 关键词	解释
     * name	名称
     * episodes	更新到第几集
     */
    @GET("animes/recently-updated")
    Observable<TestBean> animesRecentlyUpdatedApi();

    /**
     * 查询标签
     * @param type 类型
     * @return API
     * 关键词	解释
     * name	标签名
     * type	标签类型：style为风格标签，local为地区标签，season为季度标签
     */
    @GET("animes/tags")
    Observable<TestBean> animesTagsApi(@Query("type") String type);

}
