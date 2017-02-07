package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
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
import com.zondy.jwt.jwtmobile.view.ISettingAccountInfoView;

import butterknife.BindView;

/**
 * Created by sheep on 2017/1/22.
 */

public class SettingAccountInfo extends BaseActivity implements ISettingAccountInfoView{
    ISettingPresenter settingPresenter = new SettingPresenterImpl(this);
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.tv_ctname)
    TextView tvCtname;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.tv_phone)
    TextView tvPhone;
    @BindView(R.id.tv_usertype)
    TextView tvUsertype;
    @BindView(R.id.tv_zzjgmc)
    TextView tvZzjgmc;
    @BindView(R.id.tv_logout)
    TextView tvLogout;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_setting_accountinfo;
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
        EntityUser user = SharedTool.getInstance().getUserInfo(SettingAccountInfo.this);
        tvCtname.setText("账户名："+getStrValue(user.getCtname()));
        tvUsername.setText("警号："+getStrValue(user.getUserName()));
        tvPhone.setText("手机号："+getStrValue(user.getPhone()));
        tvUsertype.setText("职务："+getStrValue(user.getUsertype()));
        tvZzjgmc.setText("所属单位："+getStrValue(user.getZzjgmc()));
        tvLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(tvLogout, "确定退出登录？", Snackbar.LENGTH_LONG)
                        .setAction("确定", new View.OnClickListener() {

                            @Override
                            public void onClick(View v) {
                                EntityUser userInfo = SharedTool.getInstance().getUserInfo(SettingAccountInfo.this);
                                String simid = CommonUtil.getDeviceId(SettingAccountInfo.this);
                                settingPresenter.logoutAccout(userInfo.getUserName(), simid);
                            }
                        }).show();
            }
        });
    }
    public String getStrValue(String str){
        String value = "暂无信息";
        if(TextUtils.isEmpty(str)||"null".equals(str)){

        }else{
            value = str;
        }
        return value;
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
    public void logoutSuccessed() {
        SharedTool.getInstance().clearUserInfo(this);
        ActivityCollector.finishAll();
        Intent intent = new Intent(SettingAccountInfo.this, LoginActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void logoutUnSuccessed() {
        ToastTool.getInstance().shortLength(this, "登出失败！", true);
    }
}
