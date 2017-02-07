package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.manager.ActivityCollector;
import com.zondy.jwt.jwtmobile.presenter.ISettingPresenter;
import com.zondy.jwt.jwtmobile.presenter.impl.SettingPresenterImpl;
import com.zondy.jwt.jwtmobile.util.CommonUtil;
import com.zondy.jwt.jwtmobile.util.SharedTool;
import com.zondy.jwt.jwtmobile.util.ToastTool;
import com.zondy.jwt.jwtmobile.view.ISettingView;

import butterknife.BindView;

/**
 * Created by sheep on 2017/1/11.
 */

public class SettingActivity extends BaseActivity implements View.OnClickListener, ISettingView {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_logout)
    TextView tvLogout;
    ISettingPresenter settingPresenter = new SettingPresenterImpl(this);
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_jh)
    TextView tvJh;
    @BindView(R.id.rl_account_info)
    RelativeLayout rlAccountInfo;
    @BindView(R.id.tv_about_jwt)
    TextView tvAboutJwt;
    @BindView(R.id.tv_caiji_info)
    TextView tvCaijiInfo;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_setting;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();
    }

    private void initViews() {
        EntityUser user = SharedTool.getInstance().getUserInfo(SettingActivity.this);
        if (user != null) {
            tvName.setText(user.getCtname());
            tvJh.setText("警号：" + user.getUserName());
        }
        tvLogout.setOnClickListener(this);
        rlAccountInfo.setOnClickListener(this);
        tvAboutJwt.setOnClickListener(this);
        tvCaijiInfo.setOnClickListener(this);
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

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_logout:
                Snackbar.make(tvLogout, "确定退出登录？", Snackbar.LENGTH_LONG)
                        .setAction("确定", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                EntityUser userInfo = SharedTool.getInstance().getUserInfo(SettingActivity.this);
                                String simid = CommonUtil.getDeviceId(SettingActivity.this);
                                settingPresenter.logout(userInfo.getUserName(), simid);
                            }
                        }).show();
                break;
            case R.id.rl_account_info:
                Intent intentAccountInfo=new Intent(SettingActivity.this,SettingAccountInfo.class);
                startActivity(intentAccountInfo);
                break;
            case R.id.tv_about_jwt:
                Intent intent=new Intent(SettingActivity.this,SettingAboutJWTActivity.class);
                startActivity(intent);
                break;
            case R.id.tv_caiji_info:
                ToastTool.getInstance().shortLength(this,"即将开放...",true);
                break;
        }
    }

    @Override
    public void logoutSuccessed() {
        SharedTool.getInstance().clearUserInfo(this);
        ActivityCollector.finishAll();
        Intent intent = new Intent(SettingActivity.this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void logoutUnSuccessed() {
        ToastTool.getInstance().shortLength(this, "登出失败！", true);
    }
}
