/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

import com.qmuiteam.qmui.widget.QMUITabSegment;
import com.qmuiteam.qmui.widget.QMUIViewPager;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * @author SakuramiRin
 * @date 2019-03-23 11:30
 */
public class HomeBaseFragment extends Fragment {

    private QMUIViewPager mViewPager;
    private QMUITabSegment mTabSegment;


//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        FrameLayout layout = (FrameLayout) LayoutInflater.from(getActivity()).inflate(R.layout.activity_main, null);
//
////        //ViewPage 部分
////        mViewPager = layout.findViewById(R.id.);
////        //底部的Tab部分
////        mTabSegment = layout.findViewById(R.id.);
//
//        initPagers();
//
//    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //getLazyViewLifecycleOwner().getLifecycle().addObserver(new QDLazyTestObserver("QDfSWViewPager"));
        //添加这个到生命周期观察器
    }

    private void initPagers() {
//        QMUIFragmentPagerAdapter pagerAdapter = new QMUIFragmentPagerAdapter(getChildFragmentManager()) {
//            @Override
//            public Fragment createFragment(int position) {
//                switch (position) {
//                    case 0:
//                        return new QDTabSegmentScrollableModeFragment();
//                    case 1:
//                        return new QDCollapsingTopBarLayoutFragment();
//                    case 2:
//                        return new QDFitSystemWindowViewPagerFragment();
//                    case 3:
//                    default:
//                        return new QDViewPagerFragment();
//                }
//            }
//
//            @Override
//            public int getCount() {
//                return 4;
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                switch (position) {
//                    case 0:
//                        return "TabSegment";
//                    case 1:
//                        return "CTopBar";
//                    case 2:
//                        return "IViewPager";
//                    case 3:
//                    default:
//                        return "ViewPager";
//                }
//            }
//        };
//        mViewPager.setAdapter(pagerAdapter);
        mTabSegment.setupWithViewPager(mViewPager);
    }
}
