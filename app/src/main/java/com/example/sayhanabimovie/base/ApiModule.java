/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.base;

import android.content.Context;
import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
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
@Module
@Singleton
public class ApiModule {

    @Provides
    private HttpUrl providesHttpUrl() {
        return new HttpUrl.Builder()
                .scheme("http")
                .host("umarutv.misakas.com/")
                .build();
    }

    @Provides
    public Interceptor providesInterceptor() {
        return new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
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
    @Provides
    public Cache providesCache(Context context) { File httpCacheFile = context.getExternalCacheDir().getAbsoluteFile();
        return new Cache(httpCacheFile, 1024 * 10 * 1024);
    }

    @Provides
    @Singleton
    public OkHttpClient providesOkHttpClient(Interceptor interceptor, Cache cache) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Provides
    @Singleton
    public Retrofit providesRetrofit(OkHttpClient client, HttpUrl httpUrl) {
        return new Retrofit.Builder()
                .baseUrl(httpUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }
}
