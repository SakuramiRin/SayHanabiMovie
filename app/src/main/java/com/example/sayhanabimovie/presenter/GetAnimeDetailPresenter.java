/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.presenter;

import android.util.Log;

import com.example.sayhanabimovie.base.ApiModule;
import com.example.sayhanabimovie.bean.AllAnimesBean;
import com.example.sayhanabimovie.bean.AnimesDetailBean;
import com.example.sayhanabimovie.model.GetAnimeDetailModel;
import com.example.sayhanabimovie.model.interfacemodel.IGetAnimeDetail;
import com.example.sayhanabimovie.presenter.interfacepresenter.IGetAnimeDetailPresenter;

import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
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

    private AllAnimesBean mAllAnimesBean;

    public GetAnimeDetailPresenter() {
        mGetAnimeDetail = new GetAnimeDetailModel();
    }

    @Override
    public void getAnimeDetail() {
        mGetAnimeDetail.getAnimeDetailAPI().enqueue(new Callback<List<AnimesDetailBean>>() {
            @Override
            public void onResponse(Call<List<AnimesDetailBean>> call, Response<List<AnimesDetailBean>> response) {
                if (response.isSuccessful()) {
                    Log.d(TAG, "onResponse: "+response.body());
                    List<AnimesDetailBean> animesDetailBeans = response.body();
                    Log.d(TAG, "onResponse: ");
                }
            }

            @Override
            public void onFailure(Call<List<AnimesDetailBean>> call, Throwable t) {
                Log.e(TAG, "onFailure: "+t.getMessage() );
            }
        });
    }

    public void TestApi() {
        ApiModule api = new ApiModule();
        api.allAnimesApi("").subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Observer<AllAnimesBean>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "onSubscribe: all animes");

            }

            @Override
            public void onNext(AllAnimesBean allAnimesBean) {
                mAllAnimesBean =  allAnimesBean;
                mAllAnimesBean.getData();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });


    }
}
