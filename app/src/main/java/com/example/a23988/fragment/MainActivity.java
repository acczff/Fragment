package com.example.a23988.fragment;

import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.example.a23988.fragment.frag.MainFragment;

import utils.app.BaseActivity;

public class MainActivity extends BaseActivity{

        private DrawerLayout dl;
        private TextView tv;
        private MainFragment frag_main;
    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        dl = findViewById(R.id.dl);
        tv = findViewById(R.id.tv);
        frag_main = (MainFragment) getSupportFragmentManager().findFragmentById(R.id.frag_main);

    }

    @Override
    protected void initData() {
        dl.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {
                switch (newState){
                    case DrawerLayout.STATE_SETTLING: // drag拖拽 idle闲置 settling沉淀

                        break;
                        }
            }
        });
        dl.closeDrawer(Gravity.START);


    }

    @Override
    protected void initListener() {

    }
}
