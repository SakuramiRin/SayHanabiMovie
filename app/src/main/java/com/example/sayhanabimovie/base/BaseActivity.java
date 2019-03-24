/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.base;

import com.example.sayhanabimovie.manager.UpgradeManager;

import androidx.appcompat.app.AppCompatActivity;

/**
 * @author SakuramiRin
 * @date 2019-03-24 2:00
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        UpgradeManager.getUpgradeManager(this).executeUpgradeTipTaskIfNeed(this);
    }
}
