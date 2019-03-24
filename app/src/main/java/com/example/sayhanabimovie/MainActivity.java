/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie;

import android.os.Bundle;

import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

/**
 * @author SakuramiRin
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //隐藏系统标题
        setTitle("");

        initMaterDesignHome();


        //抽屉菜单
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        //ActionBar 抽屉切换 参数分别是     context 抽屉菜单  工具栏？ 两个String
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, null, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        //对这个抽屉菜单添加监听器
//        drawer.addDrawerListener(toggle);
//        toggle.syncState();

        //抽屉里的东西
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        //抽屉里的东西被选中监听器
//        navigationView.setNavigationItemSelectedListener(this);


    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            //打开抽屉时按下返回键关闭抽屉栏
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 右上角设置布局
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 右上角布局点击事件
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // 抽屉栏中菜单被选中
        int id = item.getItemId();

        if (id == R.id.nav_camera) {

        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void initMaterDesignHome() {
        //设置actionBar
        MaterialViewPager materialViewPager = findViewById(R.id.materialViewPager);
        Toolbar toolbar = materialViewPager.getToolbar();
//        toolbar.setNavigationIcon(R.drawable.ic_search_black_24dp);
        setSupportActionBar(toolbar);

        toolbar.setNavigationIcon(R.drawable.ic_menu_black_24dp);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        toolbar.setPopupTheme(R.style.popupTheme);

        //
        materialViewPager.getViewPager().setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @NonNull
            @Override
            public Fragment getItem(int position) {
                switch (position) {
                    case 4:
                        return new Fragment();
                    default:
                        return new RecyclerViewFragment();
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @Nullable
            @Override
            public CharSequence getPageTitle(int position) {
                switch (position) {
                    case 0:
                        return "热门";
                    case 1:
                        return "最新";
                    case 2:
                        return "连载";
                    default:
                }
                return "";
            }
        });

        materialViewPager.setMaterialViewPagerListener(new MaterialViewPager.Listener() {
            @Override
            public HeaderDesign getHeaderDesign(int page) {
                if (page == 1) {
                    return HeaderDesign.fromColorResAndDrawable(R.color.blue, getDrawable(R.drawable.backgroundimg));
                }
                if (page == 2) {
                    return HeaderDesign.fromColorResAndDrawable(R.color.blue, getDrawable(R.drawable.bg2));
                }
                return HeaderDesign.fromColorResAndDrawable(R.color.blue, getDrawable(R.drawable.bg1));
            }
        });

        materialViewPager.getViewPager().setOffscreenPageLimit(materialViewPager.getViewPager().getAdapter().getCount());
        materialViewPager.getPagerTitleStrip().setViewPager(materialViewPager.getViewPager());
    }
}
