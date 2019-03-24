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

import com.example.sayhanabimovie.manager.UpgradeManager;

/**
 * @author SakuramiRin
 * @date 2019-03-24 1:49
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Context context = getApplicationContext();
//        UpgradeManager.getUpgradeManager(context).check();
    }
}
