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
import com.zondy.jwt.jwtmobile.entity.EntityTCFL;
import com.zondy.jwt.jwtmobile.presenter.ISearchPresenter;
import com.zondy.jwt.jwtmobile.presenter.impl.SearchPresenterImpl;
import com.zondy.jwt.jwtmobile.view.ISearchTCFLView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.OnClick;

public class SearchActivity extends BaseActivity implements ISearchTCFLView {
    @BindView(R.id.btn_more)
    Button btnMore;
    @BindView(R.id.cb_lvguan)
    CheckBox cbLvguan;
    @BindView(R.id.cb_wangba)
    CheckBox cbWangba;
    @BindView(R.id.cb_xuexiao)
    CheckBox cbXuexiao;
    @BindView(R.id.cb_tingchechang)
    CheckBox cbTingchechang;
    @BindView(R.id.cb_chaoshi)
    CheckBox cbChaoshi;
    @BindView(R.id.cb_jiuba)
    CheckBox cbJiuba;
    @BindView(R.id.cb_dianyingyuan)
    CheckBox cbDianyingyuan;
    private ISearchPresenter searchPresenter = new SearchPresenterImpl(this, this);
    private ImageView ivBack;
    private Button btnSearch;
    private ImageView ivCancel;
    private EditText etSearch;
    private XRecyclerView rvHistory;
    private RelativeLayout btnClearHistory;
    private String searchMC = "";


    //搜索历史假数据
    private List<String> mDatas = new ArrayList<>();

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_search;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if (intent != null) {
            searchMC = intent.getStringExtra("MC");
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
    }

    private void initParams() {
        ivBack = (ImageView) findViewById(R.id.iv_search_back);
        btnSearch = (Button) findViewById(R.id.btn_search_confirm);
        ivCancel = (ImageView) findViewById(R.id.iv_search_cancel);
        etSearch = (EditText) findViewById(R.id.et_activity_search);
        rvHistory = (XRecyclerView) findViewById(R.id.rv_history);
        btnClearHistory = (RelativeLayout) findViewById(R.id.btn_clear_history);

    }

    private void initViews() {
        //暂时为了布局美观，通过返回一次的数据源，写死，需要重新搜索时，再调用。
//        searchPresenter.queryTCFZList();
        if (searchMC != null) {
            etSearch.setText(searchMC);
            etSearch.requestFocus();
            btnSearch.setVisibility(View.VISIBLE);
            ivCancel.setVisibility(View.VISIBLE);
        }
        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, SearchMoreActivity.class);
                startActivity(intent);
            }
        });
        etSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (!TextUtils.isEmpty(etSearch.getText().toString())) {
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
//                Toast.makeText(SearchActivity.this, "点击了" + mDatas.get(position - 1), Toast.LENGTH_SHORT).show();
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
                }, 2000);
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
                rvHistory.setVisibility(View.GONE);
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SearchActivity.this, ScrollActivityResult.class);
                intent.putExtra("MC", ""+etSearch.getText().toString());
                startActivity(intent);
            }
        });
    }

    @Override
    public void queryTCFLSuccessed(List<EntityTCFL> tcfls) {

    }

    @Override
    public void queryTCFLUnSuccessed() {

    }

    @OnClick({R.id.cb_lvguan, R.id.cb_wangba, R.id.cb_xuexiao, R.id.cb_tingchechang, R.id.cb_chaoshi, R.id.cb_jiuba, R.id.cb_dianyingyuan})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.cb_lvguan:
                Intent intentlg=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intentlg.putExtra("MC","旅馆");
                startActivity(intentlg);
                break;
            case R.id.cb_wangba:
                Intent intentwb=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intentwb.putExtra("MC","网吧");
                startActivity(intentwb);
                break;
            case R.id.cb_xuexiao:
                Intent intentxx=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intentxx.putExtra("MC","学校");
                startActivity(intentxx);
                break;
            case R.id.cb_tingchechang:
                Intent intenttcc=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intenttcc.putExtra("MC","停车场");
                startActivity(intenttcc);
                break;
            case R.id.cb_chaoshi:
                Intent intentcs=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intentcs.putExtra("MC","超市");
                startActivity(intentcs);
                break;
            case R.id.cb_jiuba:
                Intent intentjb=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intentjb.putExtra("MC","酒吧");
                startActivity(intentjb);
                break;
            case R.id.cb_dianyingyuan:
                Intent intentdyy=new Intent(SearchActivity.this,ScrollActivityResult.class);
                intentdyy.putExtra("MC","电影院");
                startActivity(intentdyy);
                break;
        }
    }
}
