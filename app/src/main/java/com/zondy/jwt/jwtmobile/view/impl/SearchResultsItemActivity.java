package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;

/**
 * Created by sheep on 2017/1/5.
 */

public class SearchResultsItemActivity extends BaseActivity {
    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_searchresults_item;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        String itemName = intent.getStringExtra("NAME");
        int itemImageId = intent.getIntExtra("IMAGE_ID", 0);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar_searchresults_item);
        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsingtoolbarlayout);
        ImageView imageView= (ImageView) findViewById(R.id.iv_searchresults_item);
        TextView textView= (TextView) findViewById(R.id.tv_searchresults_item_content_text);
        setSupportActionBar(toolbar);
        ActionBar actionBar=getSupportActionBar();
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        collapsingToolbarLayout.setTitle(itemName);
        Glide.with(this).load(itemImageId).into(imageView);
        textView.setText(itemName);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
