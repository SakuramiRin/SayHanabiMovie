/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.utils;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.sayhanabimovie.base.BaseApplication;

/**
 * @author ihotei
 */
public class ImageLoadUtils {

    private ImageLoadUtils() {
        throw new IllegalAccessError();
    }

    public static void loadImage(String imageUrl, ImageView view) {

        Glide.with(BaseApplication.getContext())
                .load(imageUrl)
                .into(view);
    }

}
