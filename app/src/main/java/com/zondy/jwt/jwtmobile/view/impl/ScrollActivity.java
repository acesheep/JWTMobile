package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.mapgis.android.mapview.MapView;

import java.io.File;

import butterknife.BindView;


/**
 * Created by sheep on 2016/12/26.
 */

public class ScrollActivity extends BaseActivity {

    private MapView mapView;
    private RelativeLayout rlSearch;//顶部查询总布局
    private EditText etSearch;//查询输入栏edittext

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_scroll;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParams();
        initView();
    }

    private void initParams() {
        rlSearch = (RelativeLayout) findViewById(R.id.rl_search);
        etSearch = (EditText) findViewById(R.id.et_search);
        mapView= (MapView) findViewById(R.id.mapview);
    }

    private void initView() {
        mapView.loadFromFile(Environment.getExternalStorageDirectory().getAbsolutePath()+ File.separator+"MapGIS/map/wuhan/wuhan.xml");
        mapView.setShowNorthArrow(false);
        rlSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        etSearch.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Intent intent = new Intent(ScrollActivity.this, SearchActivity.class);
                    startActivity(intent);
                }
            }
        });
        etSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });
    }
}
