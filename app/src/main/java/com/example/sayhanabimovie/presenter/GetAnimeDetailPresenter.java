/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.presenter;

import android.util.Log;

import com.example.sayhanabimovie.bean.AnimeDetailBean;
import com.example.sayhanabimovie.model.GetAnimeDetailModel;
import com.example.sayhanabimovie.model.interfacemodel.IGetAnimeDetail;
import com.example.sayhanabimovie.presenter.interfacepresenter.IGetAnimeDetailPresenter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * @author SakuramiRin
 * @date 2019-03-27 23:04
 */
public class GetAnimeDetailPresenter implements IGetAnimeDetailPresenter {

    private static final String TAG = "GetAnimeDetailPresenter";

    private IGetAnimeDetail mGetAnimeDetail;

    public GetAnimeDetailPresenter() {
        mGetAnimeDetail = new GetAnimeDetailModel();
    }

    @Override
    public void getAnimeDetail() {
        mGetAnimeDetail.getAnimeDetailAPI().enqueue(new Callback<List<AnimeDetailBean>>() {
            @Override
            public void onResponse(Call<List<AnimeDetailBean>> call, Response<List<AnimeDetailBean>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: "+response.body());
                    List<AnimeDetailBean> animeDetailBeans = response.body();
                    Log.d(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<List<AnimeDetailBean>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });
    }
}
