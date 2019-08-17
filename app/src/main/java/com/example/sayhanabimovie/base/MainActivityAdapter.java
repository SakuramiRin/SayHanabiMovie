/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.base;

import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.example.sayhanabimovie.R;
import com.example.sayhanabimovie.bean.AllAnimesBean;
import com.example.sayhanabimovie.bean.AnimesInfoBean;

import java.util.List;

/**
 * @author ihotei
 */
public class MainActivityAdapter extends BaseQuickAdapter<AllAnimesBean, BaseViewHolder> {

    public MainActivityAdapter(int layoutResId, List<AllAnimesBean> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, AllAnimesBean item) {
        helper.setText(R.id.card_title, item.getData().get());
    }


}
