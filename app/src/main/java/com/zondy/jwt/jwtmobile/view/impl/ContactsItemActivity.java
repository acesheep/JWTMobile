package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;

import butterknife.BindView;

/**
 * Created by sheep on 2017/1/13.
 */

public class ContactsItemActivity extends BaseActivity implements View.OnClickListener {

    @BindView(R.id.rl_message)
    RelativeLayout rlMessage;
    @BindView(R.id.rl_telephone)
    RelativeLayout rlTelephone;
    @BindView(R.id.tv_dh)
    TextView tvDh;
    @BindView(R.id.tv_jh)
    TextView tvJh;
    @BindView(R.id.tv_zw)
    TextView tvZw;
    @BindView(R.id.tv_ssdwmc)
    TextView tvSsdwmc;
    private String dh;
    private String jh;
    private String ssdwmc;
    private String zw;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_contacts_item;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initViews();

    }

    private void initViews() {
        Intent intent = getIntent();
        String mc = intent.getStringExtra("MC");
        dh = intent.getStringExtra("DH");
        jh = intent.getStringExtra("JH");
        ssdwmc = intent.getStringExtra("SSDWMC");
        zw = intent.getStringExtra("ZW");
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_contacts_item);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbarlayout);
        setSupportActionBar(toolbar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(mc);
        tvDh.setText("电话："+dh);
        tvJh.setText("警号："+jh);
        tvZw.setText("职务："+zw);
        tvSsdwmc.setText("所属单位："+ssdwmc);
        rlMessage.setOnClickListener(this);
        rlTelephone.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rl_message:
                Uri smsToUri = Uri.parse("smsto:" + dh);
                Intent intentMes = new Intent(Intent.ACTION_SENDTO, smsToUri);
                startActivity(intentMes);
                break;
            case R.id.rl_telephone:
                Uri telToUri = Uri.parse("tel:" + dh);
                Intent intentTel = new Intent(Intent.ACTION_DIAL, telToUri);
                intentTel.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intentTel);
                break;
        }
    }
}
