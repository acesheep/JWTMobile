package com.zondy.jwt.jwtmobile.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zondy.jwt.jwtmobile.manager.ActivityCollector;

import butterknife.ButterKnife;


/**
 * Created by sheep on 2016/12/23.
 */

public abstract class BaseActivity extends AppCompatActivity {
    public abstract int setCustomContentViewResourceId();
    public Context context;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setCustomContentViewResourceId());
        context=this;
        ActivityCollector.addActivity(this);
        //使用ButterKnife 注入view
        ButterKnife.bind(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
