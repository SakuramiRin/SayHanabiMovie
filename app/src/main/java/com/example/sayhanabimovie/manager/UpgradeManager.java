/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.manager;

import android.content.Context;
import android.content.Intent;

import com.qmuiteam.qmui.widget.dialog.QMUIDialog;
import com.qmuiteam.qmui.widget.dialog.QMUIDialogAction;

/**
 * 升级管理器
 * @author SakuramiRin
 * @date 2019-03-24 1:05
 */
public class UpgradeManager {

    /**
     * 版本号
     */
    private static final int VERSION_100 = 100;

    /**
     * 当前版本
     */
    private static final int CURRENT_VERSION = VERSION_100;

    private static UpgradeManager sUpgradeManager = null;

    private UpgradeTipTask mUpgradeTipTask;

    private static Context mContext;

    private UpgradeManager() {
    }

    //单例模式
    public static UpgradeManager getUpgradeManager(Context context) {
        if (sUpgradeManager != null) {
            sUpgradeManager = new UpgradeManager();
        }
        mContext = context.getApplicationContext();
        return sUpgradeManager;
    }

    public void check() {
        //旧版本
        int oldVersion = VERSION_100;
        int currentVersion = CURRENT_VERSION;

        if (currentVersion > oldVersion) {
            mUpgradeTipTask = new UpgradeTipTask(oldVersion, currentVersion);
        }
    }

    //执行升级提示如果需要
    public void executeUpgradeTipTaskIfNeed(Context context) {
        if (mUpgradeTipTask != null) {
            mUpgradeTipTask.upgrade(context);
            mUpgradeTipTask = null;
        }
    }


    class UpgradeTipTask {
        private final int mOldVersion;

        private final int mNewVersion;

        public UpgradeTipTask(int oldVersion, int newVersion) {
            mNewVersion = newVersion;
            mOldVersion = oldVersion;
        }

        public void upgrade(Context context) {
            QMUIDialog.CheckBoxMessageDialogBuilder checkBox = new QMUIDialog.CheckBoxMessageDialogBuilder(context);
            checkBox.setTitle("当前版本为"+mOldVersion+",检测到新版本"+mNewVersion+"，是否前往下载");
            checkBox.setChecked(false);
            checkBox.setMessage("本次版本更新不再进行提示");
            checkBox.addAction("取消", new QMUIDialogAction.ActionListener() {
                @Override
                public void onClick(QMUIDialog dialog, int index) {
                    dialog.dismiss();
                }
            });
            checkBox.addAction("确定", new QMUIDialogAction.ActionListener() {
                @Override
                public void onClick(QMUIDialog dialog, int index) {
                    Intent intent = new Intent();
                    //隐式跳转至浏览器
                }
            });
        }
    }
}


