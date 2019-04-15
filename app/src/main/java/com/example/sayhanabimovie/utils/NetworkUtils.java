/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;

import com.example.sayhanabimovie.base.BaseApplication;

import java.io.IOException;


/**
 * @author ihotei
 */
public final class NetworkUtils {

    private NetworkUtils() {
        throw new IllegalAccessError();
    }

    private static ConnectivityManager getConnectivityManager() {
        return (ConnectivityManager) BaseApplication.getApplication().getSystemService(Context.CONNECTIVITY_SERVICE);
    }

    /**
     * 获取Act的网络信息
     *
     * @return 网络信息
     */
    private static NetworkInfo getActiveNetworkInfo() {
        final ConnectivityManager connectivityManager = getConnectivityManager();
        if (connectivityManager == null) {
            return null;
        }
        return connectivityManager.getActiveNetworkInfo();
    }

    /**
     * 判断网络是否连接
     *
     * @return 是否连接
     */
    public static boolean isConnectedWithWifi() {
        // 6.0以上系統，使用NetworkCapabilities判断
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            NetworkCapabilities networkCapabilities = getConnectivityManager().getNetworkCapabilities(getConnectivityManager().getActiveNetwork());
            return networkCapabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
            // 好像必須使用廢棄方法
        } else {
            NetworkInfo info = getActiveNetworkInfo();
            return info != null && info.isConnected()&&(info.getType() == ConnectivityManager.TYPE_WIFI);
        }
    }

    /**
     * 判断网路是否可用
     *
     * @return 是否可用
     */
    public static boolean isAvailable() {
        // 6.0以上系統，使用NetworkCapabilities判断
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.M) {
            if (getConnectivityManager() != null) {
                NetworkCapabilities networkCapabilities = getConnectivityManager().getNetworkCapabilities(getConnectivityManager().getActiveNetwork());
                return networkCapabilities.hasCapability(NetworkCapabilities.NET_CAPABILITY_VALIDATED);
            }
        } else {
            // 根据ping命令 另外还有根据DNS地址，直接使用http尝试连接两种方法
            Runtime runtime = Runtime.getRuntime();
            try {
                // 尝试ping 百度
                Process ipProcess = runtime.exec("ping -c 3 www.baidu.com");
                return (ipProcess.waitFor()) == 0;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

}