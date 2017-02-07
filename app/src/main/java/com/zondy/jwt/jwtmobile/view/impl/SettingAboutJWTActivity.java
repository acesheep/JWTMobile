package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.util.ToastTool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sheep on 2017/1/22.
 */

public class SettingAboutJWTActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_function_introduce)
    TextView tvFunctionIntroduce;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_setting_aboutjwt;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews() {
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.sos:
                ToastTool.getInstance().shortLength(this, "一键报警", true);
                break;
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }

    @OnClick(R.id.tv_function_introduce)
    public void onClick() {
        Intent intent=new Intent(SettingAboutJWTActivity.this,SettingFunctionIntroduceActivity.class);
        startActivity(intent);
    }
}
