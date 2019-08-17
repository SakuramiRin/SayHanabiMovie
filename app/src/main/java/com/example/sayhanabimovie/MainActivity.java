/*
 * Copyright (c) 2019. Lorem ipsum dolor sit amet, consectetur adipiscing elit.
 * Morbi non lorem porttitor neque feugiat blandit. Ut vitae ipsum eget quam lacinia accumsan.
 * Etiam sed turpis ac ipsum condimentum fringilla. Maecenas magna.
 * Proin dapibus sapien vel ante. Aliquam erat volutpat. Pellentesque sagittis ligula eget metus.
 * Vestibulum commodo. Ut rhoncus gravida arcu.
 */

package com.example.sayhanabimovie;

import android.os.Bundle;

import com.example.sayhanabimovie.bean.AllAnimesBean;
import com.example.sayhanabimovie.presenter.GetAnimeDetailPresenter;
import com.github.florent37.materialviewpager.MaterialViewPager;
import com.github.florent37.materialviewpager.header.HeaderDesign;

import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentStatePagerAdapter;

import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import static com.example.sayhanabimovie.base.Constants.EXIT_TIME;


/**
 * @author SakuramiRin
 */
public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private AllAnimesBean mAllAnimesBean;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // api 和 rxjava测试
        new GetAnimeDetailPresenter().TestApi();
        new TestClass().method();

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
        navigationView.setNavigationItemSelectedListener(this);


    }

    /**
     * 返回键逻辑处理
     */
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            //打开抽屉时按下返回键关闭抽屉栏
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    /**
     * 右上角设置
     * @param menu 菜单
     * @return 是否显示右上角设置选项
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // 右上角设置布局
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    /**
     * 右上角设置列表点击事件
     * @param item 条目
     * @return 是否触发
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // 右上角布局点击事件
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            Toast.makeText(this, "点击了设置按钮", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 抽屉菜单内条目点击事件
     * @param item 条目
     * @return 是否触发事件
     */
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.nav_camera) {
            Toast.makeText(this, "1", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(this, "2", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(this, "3", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(this, "4", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(this, "5", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(this, "6", Toast.LENGTH_SHORT).show();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    /**
     * 初始化Main整体内容布局
     */
    private void initMaterDesignHome() {
        //设置actionBar
        MaterialViewPager materialViewPager = findViewById(R.id.materialViewPager);
        Toolbar toolbar = materialViewPager.getToolbar();

        // 设置SupportActionBar 从这个类静态方法拿到toolbar
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
                        return new RecyclerViewFragment(mAllAnimesBean);
                }
            }

            @Override
            public int getCount() {
                return 3;
            }

            @NonNull
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


    /**
     * 双击换回退出程序
     * @param keyCode 点击的按钮
     * @param event 按钮事件
     * @return 是否触发
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            long secondTime = System.currentTimeMillis();
            if (secondTime > EXIT_TIME) {
                Toast.makeText(this, "在按一次退出程序", Toast.LENGTH_SHORT).show();
                return true;
            } else {
                System.exit(0);
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
