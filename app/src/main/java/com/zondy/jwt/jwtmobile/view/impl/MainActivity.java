package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.util.SharedTool;
import com.zondy.mapgis.android.mapview.MapView;

import java.io.File;

import butterknife.BindView;

/**
 * Created by sheep on 2017/1/5.
 */

public class MainActivity extends BaseActivity {
    @BindView(R.id.tv_ll_name)
    TextView tvName;
    @BindView(R.id.tv_ll_jh)
    TextView tvJh;
    private DrawerLayout drawerLayout;
    private MapView mapView;
    private FloatingActionButton fab;
    private LinearLayout llZhcx;
    private LinearLayout llTxl;
    private LinearLayout llSz;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams();
        initViews();
    }

    private void initParams() {
        mapView = (MapView) findViewById(R.id.mapview);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        llZhcx = (LinearLayout) findViewById(R.id.ll_main_zonghcx);
        llTxl = (LinearLayout) findViewById(R.id.ll_main_tongxl);
        llSz = (LinearLayout) findViewById(R.id.ll_main_shez);
    }

    private void initViews() {
        EntityUser user = SharedTool.getInstance().getUserInfo(MainActivity.this);
        if (user != null) {
            tvName.setText(user.getCtname());
            tvJh.setText("警号："+user.getUserName());
        }
        mapView.loadFromFile(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "MapGIS/map/wuhan/wuhan.xml");
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(Gravity.LEFT);
            }
        });
        llZhcx.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScrollActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
            }
        });
        llTxl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,ContactsActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
            }
        });
        llSz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SettingActivity.class);
                startActivity(intent);
                drawerLayout.closeDrawers();
            }
        });
    }
}
