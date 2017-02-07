package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jcodecraeer.xrecyclerview.ProgressStyle;
import com.jcodecraeer.xrecyclerview.XRecyclerView;
import com.yinglan.scrolllayout.ScrollLayout;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
import com.zhy.adapter.recyclerview.base.ViewHolder;
import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.entity.EntitySearchResult;
import com.zondy.jwt.jwtmobile.presenter.ISearchPresenter;
import com.zondy.jwt.jwtmobile.presenter.impl.SearchPresenterImpl;
import com.zondy.jwt.jwtmobile.util.ScreenUtil;
import com.zondy.jwt.jwtmobile.util.SharedTool;
import com.zondy.jwt.jwtmobile.util.ToastTool;
import com.zondy.jwt.jwtmobile.view.ISearchZHCXListView;
import com.zondy.mapgis.android.mapview.MapView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by sheep on 2016/12/26.
 */

public class ScrollActivityResult extends BaseActivity implements ISearchZHCXListView {
    @BindView(R.id.scrollresults_mapview)
    MapView mapview;
    private ISearchPresenter searchPresenter = new SearchPresenterImpl(this, this);
    private double radius = 10;//半径，单位千米
    private int nowpage = 1;//分页页码，首次查询为1
    private int pagesize = 10;//每页显示条数，默认为10
    private double longitude = 114.980164;//经度
    private double latitude = 30.095831;//纬度
    private int orderType=1;//排序类型，1 代表距离排序，2 代表采集时间排序。 默认为距离排序
    private List<EntitySearchResult> mDatas = new ArrayList<>();
    private CommonAdapter<EntitySearchResult> adapter;
    //屏幕宽度
    private int width;
    private int flag=0;//默认为0，通过距离或时间排序调用的方法为1
    private String searchMC;
    private String layerid;
    private String layername;
    private RelativeLayout rlSearchTop;//顶部查询总布局
    private RelativeLayout rlSearchResultsTop;//查询结果列表全屏时，顶部显示查询内容的总布局
    private TextView tvSearchResultsTopMc;//查询结果列表全屏时，顶部显示查询内容的textview
    private TextView tvSearchTopMc;
    private TextView tvFootMc;
    private ImageView ivSearchTopBack;
    private ImageView ivSearchResultsTopBack;
    private ImageView ivSearchTopCancel;
    private ImageView ivSearchResultsTopSearch;

    private RelativeLayout rlShaixuan;
    private RelativeLayout rlPopupFujin;
    private RelativeLayout rlPopupPaixu;
    private RelativeLayout rlPopupShaixuan;
    private LinearLayout llFujinXuanzhong;
    private LinearLayout llFujinWeixuan;
    private LinearLayout llPaixuXuanzhong;
    private LinearLayout llPaixuWeixuan;
    private LinearLayout llShaixuanWeixuan;
    private LinearLayout llShaixuanXuanzhong;
    private ScrollLayout mScrollLayout;//抽屉滑动效果的总体布局
    private LinearLayout ll_foot;//底部抽屉头部的总布局
    private ScrollLayout.OnScrollChangedListener mOnScrollChangedListener = new ScrollLayout.OnScrollChangedListener() {
        @Override
        public void onScrollProgressChanged(float currentProgress) {
            //currentProgress exit：-1  中间open 1  顶部close 0
            // （  从底部到中间为 【-1，0）1  从中间到顶部  【1，0】  ）
            if (currentProgress >= 0) {
                float precent = 255 * currentProgress;
                if (precent > 255) {
                    precent = 255;
                } else if (precent < 0) {
                    precent = 0;
                }
//                mScrollLayout.getBackground().setAlpha(255 - (int) precent);

            }
            if (currentProgress == 0) {
                rlSearchTop.setVisibility(View.GONE);
                rlSearchResultsTop.setVisibility(View.VISIBLE);
                ll_foot.setVisibility(View.GONE);
            }
            if (currentProgress != 0) {
                rlSearchResultsTop.setVisibility(View.GONE);
                ll_foot.setVisibility(View.VISIBLE);
                if (rlSearchTop.getVisibility() == View.GONE) {
                    rlSearchTop.setVisibility(View.VISIBLE);
                }
            }
        }

        @Override
        public void onScrollFinished(ScrollLayout.Status currentStatus) {
            if (currentStatus.equals(ScrollLayout.Status.EXIT)) {
                ll_foot.setVisibility(View.VISIBLE);

            }
        }

        @Override
        public void onChildScroll(int top) {
        }
    };

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_scrollresults;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        searchMC = intent.getStringExtra("MC");
        layerid = intent.getStringExtra("layerid");
        layername = intent.getStringExtra("layername");
        if (layerid == null) {
            layerid = "";
        }
        if (layername == null) {
            layername = "";
        }
        initDatas();
        initParams();
        initView();
    }

    private void initDatas() {
        width = this.getResources().getDisplayMetrics().widthPixels;
    }

    private void initParams() {
        rlSearchTop = (RelativeLayout) findViewById(R.id.rl_search_top);
        rlSearchResultsTop = (RelativeLayout) findViewById(R.id.rl_searchresults_top);
        tvSearchResultsTopMc = (TextView) findViewById(R.id.tv_searchresults_top_mc);
        tvSearchTopMc = (TextView) findViewById(R.id.tv_search_top_mc);
        tvFootMc = (TextView) findViewById(R.id.tv_foot_mc);
        ivSearchResultsTopBack = (ImageView) findViewById(R.id.iv_searchresults_top_back);
        ivSearchTopBack = (ImageView) findViewById(R.id.iv_search_top_back);
        ivSearchTopCancel = (ImageView) findViewById(R.id.iv_search_top_cancel);
        ivSearchResultsTopSearch = (ImageView) findViewById(R.id.iv_searchresults_top_search);
        mScrollLayout = (ScrollLayout) findViewById(R.id.scroll_down_layout);
        ll_foot = (LinearLayout) findViewById(R.id.ll_foot);
        rlShaixuan = (RelativeLayout) findViewById(R.id.rl_scrollresults_shaixuan);
        rlPopupFujin = (RelativeLayout) findViewById(R.id.rl_pop_fujin);
        rlPopupPaixu = (RelativeLayout) findViewById(R.id.rl_pop_paixu);
        rlPopupShaixuan = (RelativeLayout) findViewById(R.id.rl_pop_shaixuan);
        llFujinWeixuan = (LinearLayout) findViewById(R.id.ll_scrollresults_shaixuan_fujin_weixuan);
        llFujinXuanzhong = (LinearLayout) findViewById(R.id.ll_scrollresults_shaixuan_fujin_xuanzhong);
        llPaixuWeixuan = (LinearLayout) findViewById(R.id.ll_scrollresults_shaixuan_paixu_weixuan);
        llPaixuXuanzhong = (LinearLayout) findViewById(R.id.ll_scrollresults_shaixuan_paixu_xuanzhong);
        llShaixuanWeixuan = (LinearLayout) findViewById(R.id.ll_scrollresults_shaixuan_shaixuan_weixuan);
        llShaixuanXuanzhong = (LinearLayout) findViewById(R.id.ll_scrollresults_shaixuan_shaixuan_xuanzhong);
    }

    private void initView() {
        mapview.loadFromFile(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "MapGIS/map/wuhan/wuhan.xml");
        mapview.setShowNorthArrow(false);
//        longitude= Double.parseDouble(SharedTool.getInstance().getLocationInfo(this).getLongitude());
//        latitude= Double.parseDouble(SharedTool.getInstance().getLocationInfo(this).getLatitude());
        searchPresenter.queryZHCXList(layerid, layername, orderType,searchMC, radius, longitude, latitude, nowpage, pagesize);
        tvSearchResultsTopMc.setText(searchMC);
        tvSearchTopMc.setText(searchMC);


        /**设置 setting*/
        mScrollLayout.setMinOffset(0);
        mScrollLayout.setMaxOffset((int) (ScreenUtil.getScreenHeight(this) * 0.65));
        mScrollLayout.setExitOffset(ScreenUtil.dip2px(this, 150));
        mScrollLayout.setIsSupportExit(true);
        mScrollLayout.setAllowHorizontalScroll(true);
        mScrollLayout.setOnScrollChangedListener(mOnScrollChangedListener);
        mScrollLayout.setToOpen();
        mScrollLayout.getBackground().setAlpha(0);
        tvSearchResultsTopMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollLayout.scrollToExit();
            }
        });
        tvSearchTopMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivityResult.this, SearchActivity.class);
                startActivity(intent);
            }
        });
        ll_foot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mScrollLayout.setToOpen();
            }
        });
        ivSearchTopBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivSearchResultsTopBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ivSearchTopCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivityResult.this, ScrollActivity.class);
                startActivity(intent);
            }
        });
        ivSearchResultsTopSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivityResult.this, SearchActivity.class);
                intent.putExtra("MC", tvSearchResultsTopMc.getText().toString());
                startActivity(intent);
            }
        });
        tvSearchTopMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivityResult.this, SearchActivity.class);
                intent.putExtra("MC", tvSearchResultsTopMc.getText().toString());
                startActivity(intent);
            }
        });
        rlPopupFujin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = ScrollActivityResult.this.getLayoutInflater().inflate(R.layout.pop_scrollresults, null);
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("默认");
                mDatas.add("500米");
                mDatas.add("1000米");
                mDatas.add("2000米");
                mDatas.add("5000米");
                mDatas.add("全市");
                CommonAdapter<String> commonAdapter = new CommonAdapter<String>(ScrollActivityResult.this, R.layout.item_scrollresults_shaixuan, mDatas) {
                    @Override
                    protected void convert(ViewHolder holder, String s, int position) {

                    }

                    @Override
                    public void convert(ViewHolder holder, String s) {
                        super.convert(holder, s);
                        holder.setText(R.id.tv_item_scrollresults_shaixuan, s);
                    }
                };
                RecyclerView rvPopupFujin = (RecyclerView) layout.findViewById(R.id.rv_item_pop);
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ScrollActivityResult.this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvPopupFujin.setLayoutManager(linearLayoutManager1);
                rvPopupFujin.setAdapter(commonAdapter);
                rvPopupFujin.addItemDecoration(new DividerItemDecoration(ScrollActivityResult.this, DividerItemDecoration.VERTICAL));
                PopupWindow window = new PopupWindow(layout, width, 600);
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                window.setFocusable(true);
                window.setOutsideTouchable(true);
                window.update();
                window.showAsDropDown(rlShaixuan);
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        llFujinWeixuan.setVisibility(View.VISIBLE);
                        llFujinXuanzhong.setVisibility(View.GONE);
                    }
                });
                if (window.isShowing()) {
                    llFujinWeixuan.setVisibility(View.GONE);
                    llFujinXuanzhong.setVisibility(View.VISIBLE);
                }

            }
        });
        rlPopupPaixu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = ScrollActivityResult.this.getLayoutInflater().inflate(R.layout.pop_scrollresults, null);
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("距离排序");
                mDatas.add("时间排序");
                CommonAdapter<String> commonAdapter = new CommonAdapter<String>(ScrollActivityResult.this, R.layout.item_scrollresults_shaixuan, mDatas) {
                    @Override
                    protected void convert(ViewHolder holder, String s, int position) {

                    }

                    @Override
                    public void convert(ViewHolder holder, String s) {
                        super.convert(holder, s);
                        holder.setText(R.id.tv_item_scrollresults_shaixuan, s);
                    }
                };
                RecyclerView rvPopupFujin = (RecyclerView) layout.findViewById(R.id.rv_item_pop);
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ScrollActivityResult.this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvPopupFujin.setLayoutManager(linearLayoutManager1);
                rvPopupFujin.setAdapter(commonAdapter);
                rvPopupFujin.addItemDecoration(new DividerItemDecoration(ScrollActivityResult.this, DividerItemDecoration.VERTICAL));
                final PopupWindow window = new PopupWindow(layout, width, 280);
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                window.setFocusable(true);
                window.setOutsideTouchable(true);
                window.update();
                window.showAsDropDown(rlShaixuan);
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        llPaixuWeixuan.setVisibility(View.VISIBLE);
                        llPaixuXuanzhong.setVisibility(View.GONE);
                    }
                });
                if (window.isShowing()) {

                    llPaixuWeixuan.setVisibility(View.GONE);
                    llPaixuXuanzhong.setVisibility(View.VISIBLE);
                }
                commonAdapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                        if((position+1)==orderType){
                            window.dismiss();
                            return;
                        }else{
                            orderType=(position+1);
                            searchPresenter.queryZHCXList(layerid, layername, orderType,searchMC, radius, longitude, latitude, nowpage, pagesize);
                            flag=1;
                            window.dismiss();
                        }

                    }

                    @Override
                    public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                        return false;
                    }
                });

            }
        });
        rlPopupShaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = ScrollActivityResult.this.getLayoutInflater().inflate(R.layout.pop_scrollresults, null);
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("0-50元");
                mDatas.add("50-100元");
                mDatas.add("100-300元");
                mDatas.add("300元以上");
                CommonAdapter<String> commonAdapter = new CommonAdapter<String>(ScrollActivityResult.this, R.layout.item_scrollresults_shaixuan, mDatas) {
                    @Override
                    protected void convert(ViewHolder holder, String s, int position) {

                    }

                    @Override
                    public void convert(ViewHolder holder, String s) {
                        super.convert(holder, s);
                        holder.setText(R.id.tv_item_scrollresults_shaixuan, s);
                    }
                };
                RecyclerView rvPopupFujin = (RecyclerView) layout.findViewById(R.id.rv_item_pop);
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ScrollActivityResult.this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvPopupFujin.setLayoutManager(linearLayoutManager1);
                rvPopupFujin.setAdapter(commonAdapter);
                rvPopupFujin.addItemDecoration(new DividerItemDecoration(ScrollActivityResult.this, DividerItemDecoration.VERTICAL));
                PopupWindow window = new PopupWindow(layout, width, 550);
                window.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#ffffff")));
                window.setFocusable(true);
                window.setOutsideTouchable(true);
                window.update();
                window.showAsDropDown(rlShaixuan);
                window.setOnDismissListener(new PopupWindow.OnDismissListener() {
                    @Override
                    public void onDismiss() {
                        llShaixuanWeixuan.setVisibility(View.VISIBLE);
                        llShaixuanXuanzhong.setVisibility(View.GONE);
                    }
                });
                if (window.isShowing()) {
                    llShaixuanWeixuan.setVisibility(View.GONE);
                    llShaixuanXuanzhong.setVisibility(View.VISIBLE);
                }

            }
        });
    }

    @Override
    public void queryZHCXListSuccessed(List<EntitySearchResult> searchResults) {
        if(flag==0){
            if (nowpage > 1) {
                mDatas.addAll(searchResults);
                tvFootMc.setText("共找到\"" + searchMC + "\"相关" + mDatas.size() + "个结果");
                adapter.notifyDataSetChanged();
            } else {
                mDatas.addAll(searchResults);
                tvFootMc.setText("共找到\"" + searchMC + "\"相关" + mDatas.size() + "个结果");
                loadSearchResultsList();
            }
        }else if(flag==1){
            mDatas.clear();
            mDatas.addAll(searchResults);
            adapter.notifyDataSetChanged();
            flag=0;
        }

    }


    @Override
    public void queryZHCXListUnSuccessed(String msg) {
        ToastTool.getInstance().shortLength(this, msg, true);
    }

    private void loadSearchResultsList() {
        final XRecyclerView mXRecyclerView = (XRecyclerView) findViewById(R.id.list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.Pacman);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        mXRecyclerView.setPullRefreshEnabled(false);
//        mXRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        adapter = new CommonAdapter<EntitySearchResult>(this, R.layout.item_scrollresults, mDatas) {
            @Override
            protected void convert(ViewHolder holder, EntitySearchResult entitySearchResult, int position) {

            }

            @Override
            public void convert(ViewHolder holder, EntitySearchResult entitySearchResult) {
                holder.setImageResource(R.id.iv_item_scrollresults, R.drawable.ic_zanwutupian);
                holder.setText(R.id.tv_item_scrollresults_mc, entitySearchResult.getMc());
                holder.setText(R.id.tv_item_scrollresults_dz, entitySearchResult.getDz());
                String distance = entitySearchResult.getDistance();
                if (distance.length() > 4) {
                    distance = distance.substring(0, 4);
                }
                holder.setText(R.id.tv_item_scrollresults_distance, distance + "km");
            }
        };
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent = new Intent(ScrollActivityResult.this, SearchResultsItemActivity.class);
                intent.putExtra("NAME", mDatas.get(position - 1).getMc());
                intent.putExtra("IMAGE_ID", mDatas.get(position - 1).getImageResourceID());
                startActivity(intent);
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
        mXRecyclerView.setAdapter(adapter);
        mXRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        mXRecyclerView.refreshComplete();
                    }

                }, 1500);
            }

            @Override
            public void onLoadMore() {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        nowpage = nowpage + 1;
                        searchPresenter.queryZHCXList(layerid, layername, orderType,searchMC, radius, longitude, latitude, nowpage, pagesize);
                        mXRecyclerView.loadMoreComplete();
                    }
                }, 2000);
            }
        });

    }

}
