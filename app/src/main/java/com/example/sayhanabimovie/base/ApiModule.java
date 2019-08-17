/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.base;

import android.text.TextUtils;

import com.example.sayhanabimovie.api.Api;
import com.example.sayhanabimovie.bean.AllAnimesBean;
import com.example.sayhanabimovie.bean.AnimesDetailBean;
import com.example.sayhanabimovie.bean.AnimesInfoBean;
import com.example.sayhanabimovie.bean.AnimesResourceBean;
import com.example.sayhanabimovie.bean.TestBean;

import java.io.IOException;
import java.util.List;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author SakuramiRin
 * @date 2019-03-28 22:50
 */
public class ApiModule implements Api {

    /**
     * HttpUrl
     * @return HttpUrl服务器
     */
    private HttpUrl httpUrl() {
        return new HttpUrl.Builder()
                .scheme("http")
                .host("umarutv.misakas.com")
                .build();
    }

    /**
     * 提供拦截器
     * @return 拦截器
     */
    private Interceptor providesInterceptor() {
        return new Interceptor() {
            @NonNull
            @Override
            public Response intercept(@NonNull Chain chain) throws IOException {
                Request request = chain.request();
                Response response = chain.proceed(request);

                String chainControl = request.cacheControl().toString();
                if (TextUtils.isEmpty(chainControl)) {
                    chainControl = "public, max-age=60, max-stale=240000";
                }

                return response.newBuilder()
                        .addHeader("Chain-Control", chainControl)
                        .removeHeader("Pragmaa")
                        .build();
            }
        };
    }

    /**
     * 提供OkHttp客户端
     * @param interceptor 拦截器
     * @return OkHttp客户端
     */
    private OkHttpClient providesOkHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder()
//                .cache(cache)
                .addInterceptor(interceptor)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }


    /**
     * 提供Retrofit
     * @param client OkHttp客户端
     * @param httpUrl BaseHttpUrl地址
     * @return Retrofit
     */
    private Retrofit providesRetrofit(OkHttpClient client, HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    /**
     * 返回基本Retrofit
     * @return Retrofit
     */
    private Retrofit baseProvidesRetrofit() {
        return providesRetrofit(providesOkHttpClient(providesInterceptor()), httpUrl());
    }

    @Override
    public Observable<List<AnimesDetailBean>> getAnimeDetailApi() {
        return baseProvidesRetrofit().create(Api.class).getAnimeDetailApi();
    }

    @Override
    public Observable<TestBean> loginApi(String email, String password) {
        return baseProvidesRetrofit().create(Api.class).loginApi(email, password);
    }

    @Override
    public Observable<TestBean> registerApi(String name, String email, String password) {
        return baseProvidesRetrofit().create(Api.class).registerApi(name, email, password);
    }

    @Override
    public Observable<AnimesInfoBean> animesInfoApi(String id, String withVideo) {
        return baseProvidesRetrofit().create(Api.class).animesInfoApi(id, withVideo);
    }

    @Override
    public Observable<AnimesDetailBean> animesDetailApi(String with) {
        return baseProvidesRetrofit().create(Api.class).animesDetailApi(with);
    }

    @Override
    public Observable<AnimesResourceBean> animesResourceApi(String id, String info) {
        return baseProvidesRetrofit().create(Api.class).animesResourceApi(id, info);
    }

    @Override
    public Observable<AllAnimesBean> allAnimesApi(String paginate) {
        return baseProvidesRetrofit().create(Api.class).allAnimesApi(paginate);
    }

    @Override
    public Observable<TestBean> animesTimeLineApi() {
        return baseProvidesRetrofit().create(Api.class).animesTimeLineApi();
    }

    @Override
    public Observable<TestBean> animesRecentlyUpdatedApi() {
        return baseProvidesRetrofit().create(Api.class).animesRecentlyUpdatedApi();
    }

    @Override
    public Observable<TestBean> animesTagsApi(String type) {
        return baseProvidesRetrofit().create(Api.class).animesTagsApi(type);
    }
}
