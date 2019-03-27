/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.model.interfacemodel;

import com.example.sayhanabimovie.bean.AnimeDetailBean;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @author SakuramiRin
 * @date 2019-03-27 22:54
 */
public interface IGetAnimeDetail {
    @GET("animes/video/6/resource")
    Call<List<AnimeDetailBean>> getAnimeDetailAPI();
}
