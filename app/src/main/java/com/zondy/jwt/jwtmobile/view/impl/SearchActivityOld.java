package com.zondy.jwt.jwtmobile.view.impl;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

public class SearchActivityOld extends BaseActivity {
    ///
    private CheckBox cbMeishi;
    private CheckBox cbJiudian;
    private CheckBox cbYinhang;
    private CheckBox cbXiyu;
    private CheckBox cbWangba;
    private CheckBox cbZuliao;
    private CheckBox cbXiaochikuaican;
    private CheckBox cbCesuo;
    private CheckBox cbJiuba;
    private CheckBox cbDitiezhan;
    private CheckBox cbDianyingyuan;
    List<CheckBox> checkBoxes=new ArrayList<>();
    ///
    private ImageView ivBack;
    private Button btnSearch;
    private ImageView ivCancel;
    private EditText etSearch;
//    private Button btnSearchMeishi;
    private XRecyclerView rvHistory;
    private RelativeLayout btnClearHistory;
    private String searchMC;
    //搜索历史假数据
    private List<String> mDatas = new ArrayList<>();

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_search_old;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        if(intent!=null){
            searchMC=intent.getStringExtra("MC");
        }
        initParams();
        initViews();
        initDatas();
    }

    private void initDatas() {
        mDatas.add("银行");
        mDatas.add("淮安市客运站");
        mDatas.add("新公安局");
        mDatas.add("东湖宾馆");
        mDatas.add("小吃");
        mDatas.add("加油站");
        mDatas.add("中百超市");
        mDatas.add("公交站");
        mDatas.add("药店");
        mDatas.add("翔宇大厦");
        mDatas.add("景点");
        mDatas.add("网鱼网咖");
        checkBoxes.add(cbMeishi);
        checkBoxes.add(cbJiudian);
        checkBoxes.add(cbYinhang);
        checkBoxes.add(cbXiyu);
        checkBoxes.add(cbWangba);
        checkBoxes.add(cbZuliao);
        checkBoxes.add(cbXiaochikuaican);
        checkBoxes.add(cbCesuo);
        checkBoxes.add(cbJiuba);
        checkBoxes.add(cbDitiezhan);
        checkBoxes.add(cbDianyingyuan);
    }

    private void initParams() {
        ivBack = (ImageView) findViewById(R.id.iv_search_back);
        btnSearch = (Button) findViewById(R.id.btn_search_confirm);
        ivCancel = (ImageView) findViewById(R.id.iv_search_cancel);
        etSearch = (EditText) findViewById(R.id.et_activity_search);
//        btnSearchMeishi = (Button) findViewById(R.id.btn_search_meishi);
        rvHistory = (XRecyclerView) findViewById(R.id.rv_history);
        btnClearHistory = (RelativeLayout) findViewById(R.id.btn_clear_history);

        cbMeishi= (CheckBox) findViewById(R.id.cb_meishi);
        cbJiudian= (CheckBox) findViewById(R.id.cb_jiudian);
        cbYinhang= (CheckBox) findViewById(R.id.cb_yinhang);
        cbXiyu= (CheckBox) findViewById(R.id.cb_xiyu);
        cbWangba= (CheckBox) findViewById(R.id.cb_wangba);
        cbZuliao= (CheckBox) findViewById(R.id.cb_zuliao);
        cbXiaochikuaican= (CheckBox) findViewById(R.id.cb_xiaochikuaican);
        cbCesuo= (CheckBox) findViewById(R.id.cb_cesuo);
        cbJiuba= (CheckBox) findViewById(R.id.cb_jiuba);
        cbDitiezhan= (CheckBox) findViewById(R.id.cb_ditiezhan);
        cbDianyingyuan= (CheckBox) findViewById(R.id.cb_dianyingyuan);
    }

    private void initViews() {
        if(searchMC!=null){
            etSearch.setText(searchMC);
            etSearch.requestFocus();
            btnSearch.setVisibility(View.VISIBLE);
            ivCancel.setVisibility(View.VISIBLE);
        }
        cbMeishi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbJiudian.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbYinhang.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbXiyu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbWangba.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbZuliao.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbXiaochikuaican.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbCesuo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbJiuba.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbDitiezhan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        cbDianyingyuan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked||!TextUtils.isEmpty(etSearch.getText().toString())){
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                }else{
                    for (CheckBox cb:checkBoxes){
                        if(cb.isChecked()){
                            ivCancel.setVisibility(View.VISIBLE);
                            btnSearch.setVisibility(View.VISIBLE);
                            return;
                        }
                    }
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                boolean flag=false;
                for(CheckBox cb:checkBoxes){
                    if(cb.isChecked()){
                        flag=true;
                        break;
                    }
                }
                if (!TextUtils.isEmpty(etSearch.getText().toString())||flag) {
                    ivCancel.setVisibility(View.VISIBLE);
                    btnSearch.setVisibility(View.VISIBLE);
                } else {
                    ivCancel.setVisibility(View.GONE);
                    btnSearch.setVisibility(View.GONE);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        rvHistory.setLayoutManager(new LinearLayoutManager(this));
        rvHistory.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        final CommonAdapter<String> commonAdapter = new CommonAdapter<String>(this, R.layout.item_search_history, mDatas) {

            @Override
            protected void convert(ViewHolder holder, String s, int position) {

            }

            @Override
            public void convert(ViewHolder holder, String s) {
                holder.setText(R.id.tv_item_search_history, s);
            }
        };
        commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Toast.makeText(SearchActivityOld.this,"点击了"+mDatas.get(position-1),Toast.LENGTH_SHORT).show();
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        rvHistory.setAdapter(commonAdapter);
        rvHistory.setPullRefreshEnabled(false);
        rvHistory.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        rvHistory.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mDatas.add("加载了更多搜索历史");
                        mDatas.add("加载了更多搜索历史");
                        mDatas.add("加载了更多搜索历史");
                        mDatas.add("加载了更多搜索历史");
                        mDatas.add("加载了更多搜索历史");
                        mDatas.add("加载了更多搜索历史");
                        commonAdapter.notifyDataSetChanged();
                        rvHistory.loadMoreComplete();
                    }
                },2000);
            }
        });

        ivBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etSearch.setText("");
            }
        });
        btnClearHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatas.clear();
                commonAdapter.notifyDataSetChanged();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SearchActivityOld.this,ScrollActivityResult.class);
                intent.putExtra("MC","美食");
                startActivity(intent);
            }
        });
    }

}
