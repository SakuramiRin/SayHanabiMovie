/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.example.sayhanabimovie.base.MainActivityAdapter;
import com.example.sayhanabimovie.bean.AllAnimesBean;
import com.github.florent37.materialviewpager.header.MaterialViewPagerHeaderDecorator;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

/**
 * Created by florentchampigny on 24/04/15.
 */
public class RecyclerViewFragment extends Fragment {

    private static final boolean GRID_LAYOUT = true;
    private static final int ITEM_COUNT = 10;

    RecyclerView mRecyclerView;

    AllAnimesBean mAllAnimesBean;

    public RecyclerViewFragment(AllAnimesBean allAnimesBean) {
        mAllAnimesBean = allAnimesBean;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recyclerview, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRecyclerView = view.findViewById(R.id.recyclerView);

        mAllAnimesBean.getData();

//        final List<Object> items = new ArrayList<>();
//
//        //new了10个空数据
//        for (int i = 0; i < ITEM_COUNT; ++i) {
//            items.add(new Object());
//        }
//
//        final List<AnimesInfoBean> list = new ArrayList<>();
//        for (int i = 0; i < 20; i++) {
//            AnimesInfoBean item = new AnimesInfoBean();
//            item.setName("123");
//            list.add(item);
//        }



        //setup materialviewpager

        if (GRID_LAYOUT) {
            mRecyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        } else {
            mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }
        mRecyclerView.setHasFixedSize(true);

        //Use this now
        mRecyclerView.addItemDecoration(new MaterialViewPagerHeaderDecorator());
        MainActivityAdapter adapter = new MainActivityAdapter(R.layout.list_item_card_big, mAllAnimesBean);
        adapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                Toast.makeText(getActivity(), "d", Toast.LENGTH_SHORT).show();
                Log.d("123", "onItemChildClick: ");
            }
        });
        mRecyclerView.setAdapter(adapter);
    }
}
