package gy.myproject.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.util.Log;

import com.yinglan.alphatabs.AlphaTabsIndicator;

import gy.myproject.R;
import gy.myproject.adapter.MainAdapter;
import gy.myproject.base.BaseActivity;
import gy.myproject.base.BaseApplication;
import gy.myproject.config.Utils;

/**
 * Created by Finder丶畅畅 on 2019/1/18 14:53
 * QQ群481606175
 */

public class MyMainActivity extends BaseActivity {
    public static MyMainActivity main;
    MainAdapter adapter;
    ViewPager tab_pager;
    AlphaTabsIndicator alphaIndicator;
    @Override
    protected int setLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        BaseApplication.Companion.addActivity(this);
        main = this;

        tab_pager = findViewById(R.id.tab_pager);
        alphaIndicator = findViewById(R.id.alphaIndicator);
        adapter = new MainAdapter(getSupportFragmentManager(), 1);
        tab_pager.setAdapter(adapter);
        tab_pager.setOffscreenPageLimit(2);
        alphaIndicator.setViewPager(tab_pager);
        tab_pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int po) {

//                if (new Utils().getCache("token").equals("")&&po==0) {
//
//                    Intent intent = new Intent(MyMainActivity.main, LoginActivity.class);
//                    startActivityForResult(intent, 1001);
//
//                } else if ((!new Utils().getCache("token").equals("")) && po != 1) {
//
//                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
