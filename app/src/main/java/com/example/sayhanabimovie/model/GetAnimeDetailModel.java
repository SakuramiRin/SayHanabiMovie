package com.example.sayhanabimovie.model;

import com.example.sayhanabimovie.bean.AnimesDetailBean;
import com.example.sayhanabimovie.model.interfacemodel.IGetAnimeDetail;

import java.util.List;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author SakuramiRin
 * @date 2019-03-27 22:55
 */
public class GetAnimeDetailModel implements IGetAnimeDetail {
    @Override
    public Call<List<AnimesDetailBean>> getAnimeDetailAPI() {
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();

        HttpUrl url = new HttpUrl.Builder()
                .scheme("http")
                .host("umarutv.misakas.com")
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(url)
                .build();
        return retrofit.create(IGetAnimeDetail.class).getAnimeDetailAPI();
    }
}
