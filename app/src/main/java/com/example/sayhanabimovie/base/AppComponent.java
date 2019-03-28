/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.base;

import android.app.Application;
import android.content.Context;
import android.widget.Toast;

import javax.inject.Singleton;

import dagger.Component;
import dagger.Module;
import retrofit2.Retrofit;

/**
 * @author SakuramiRin
 * @date 2019-03-28 22:40
 */

@Singleton
@Component(modules = {AppModule.class, ApiModule.class})
public interface AppComponent {
    Context getContext();

    Application getApplication();

    Retrofit getRetrofit();

    Toast getToast();
}
