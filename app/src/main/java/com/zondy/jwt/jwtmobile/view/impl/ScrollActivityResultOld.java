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
import com.zondy.jwt.jwtmobile.view.ISearchZHCXListView;
import com.zondy.mapgis.android.mapview.MapView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by sheep on 2016/12/26.
 */

public class ScrollActivityResultOld extends BaseActivity implements ISearchZHCXListView{
    @BindView(R.id.scrollresults_mapview)
    MapView mapview;

    private ISearchPresenter searchPresenter = new SearchPresenterImpl(this,this);
    private double longitude=114.980164;//经度
    private double latitude=30.095831;//纬度

    ///假数据展示
    private List<EntitySearchResult> mDatas = new ArrayList<>();
    int a = R.drawable.meishi_1;
    int b = R.drawable.meishi_2;
    int c = R.drawable.meishi_3;
    int d = R.drawable.meishi_4;
    int e = R.drawable.meishi_5;
    int f = R.drawable.meishi_6;
    int g = R.drawable.meishi_7;
    int h = R.drawable.meishi_8;
    EntitySearchResult entitySearchResult = new EntitySearchResult();
    EntitySearchResult entitySearchResult2 = new EntitySearchResult();
    EntitySearchResult entitySearchResult3 = new EntitySearchResult();
    EntitySearchResult entitySearchResult4 = new EntitySearchResult();
    EntitySearchResult entitySearchResult5 = new EntitySearchResult();
    EntitySearchResult entitySearchResult6 = new EntitySearchResult();
    EntitySearchResult entitySearchResult7 = new EntitySearchResult();
    EntitySearchResult entitySearchResult8 = new EntitySearchResult();
    ///

    //屏幕宽度
    private int width;

    private String searchMC;
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
        return R.layout.activity_scrollresults_old;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        searchMC = intent.getStringExtra("MC");
        initDatas();
        initParams();
        initView();
    }

    private void initDatas() {
        entitySearchResult.setDz("淮安市楚州区");
        entitySearchResult.setDistance("4.1km");
        entitySearchResult.setMc("戈雅牛排");
        entitySearchResult.setRs("89人访问");
        entitySearchResult.setImageResourceID(a);
        mDatas.add(entitySearchResult);
        entitySearchResult2.setDz("群光广场");
        entitySearchResult2.setDistance("14.5km");
        entitySearchResult2.setMc("沱江鱼府");
        entitySearchResult2.setRs("284人访问");
        entitySearchResult2.setImageResourceID(b);
        mDatas.add(entitySearchResult2);
        entitySearchResult3.setDz("翔宇大厦102号");
        entitySearchResult3.setDistance("2.8km");
        entitySearchResult3.setMc("文楼包铺（翔宇大厦店）");
        entitySearchResult3.setRs("499人访问");
        entitySearchResult3.setImageResourceID(c);
        mDatas.add(entitySearchResult3);
        entitySearchResult4.setMc("叫花鸡");
        entitySearchResult4.setDistance("6.9km");
        entitySearchResult4.setDz("警徽大道北大街12号");
        entitySearchResult4.setRs("1250人访问");
        entitySearchResult4.setImageResourceID(d);
        mDatas.add(entitySearchResult4);
        entitySearchResult5.setMc("四季煲仔饭");
        entitySearchResult5.setDistance("1.9km");
        entitySearchResult5.setDz("翔宇大夏负一楼");
        entitySearchResult5.setRs("1530人访问");
        entitySearchResult5.setImageResourceID(e);
        mDatas.add(entitySearchResult5);
        entitySearchResult6.setMc("皇室糕点");
        entitySearchResult6.setDistance("14.8km");
        entitySearchResult6.setDz("群光广场美食街");
        entitySearchResult6.setRs("980人访问");
        entitySearchResult6.setImageResourceID(f);
        mDatas.add(entitySearchResult6);
        entitySearchResult7.setMc("李季快餐");
        entitySearchResult7.setDistance("6.6km");
        entitySearchResult7.setDz("大学园路31号");
        entitySearchResult7.setRs("3410人访问");
        entitySearchResult7.setImageResourceID(g);
        mDatas.add(entitySearchResult7);
        entitySearchResult8.setMc("仟吉蛋糕");
        entitySearchResult8.setDistance("8.4km");
        entitySearchResult8.setDz("华夏城088号");
        entitySearchResult8.setRs("2030人访问");
        entitySearchResult8.setImageResourceID(h);
        mDatas.add(entitySearchResult8);
        ///
        Resources resources = this.getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        float density1 = dm.density;
        width = dm.widthPixels;
        ///
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
        searchPresenter.queryZHCXList("","",1,"美食",10,longitude,latitude,1,10);
        tvSearchResultsTopMc.setText(searchMC);
        tvSearchTopMc.setText(searchMC);
        tvFootMc.setText("共找到" + searchMC + "相关" + mDatas.size() + "个结果");
        final XRecyclerView mXRecyclerView = (XRecyclerView) findViewById(R.id.list_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mXRecyclerView.setLayoutManager(linearLayoutManager);
        mXRecyclerView.setRefreshProgressStyle(ProgressStyle.Pacman);
        mXRecyclerView.setLoadingMoreProgressStyle(ProgressStyle.Pacman);
        mXRecyclerView.setPullRefreshEnabled(false);
        mXRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        final CommonAdapter<EntitySearchResult> adapter = new CommonAdapter<EntitySearchResult>(this, R.layout.item_scrollresults, mDatas) {
            @Override
            protected void convert(ViewHolder holder, EntitySearchResult entitySearchResult, int position) {

            }

            @Override
            public void convert(ViewHolder holder, EntitySearchResult entitySearchResult) {
                holder.setImageResource(R.id.iv_item_scrollresults, entitySearchResult.getImageResourceID());
                holder.setText(R.id.tv_item_scrollresults_mc, entitySearchResult.getMc());
                holder.setText(R.id.tv_item_scrollresults_dz, entitySearchResult.getDz());
                holder.setText(R.id.tv_item_scrollresults_rs, entitySearchResult.getRs());
                holder.setText(R.id.tv_item_scrollresults_distance, entitySearchResult.getDistance());
            }
        };
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
                Intent intent = new Intent(ScrollActivityResultOld.this, SearchResultsItemActivity.class);
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
                        mDatas.add(entitySearchResult);
                        mDatas.add(entitySearchResult2);
                        adapter.notifyDataSetChanged();
                        mXRecyclerView.loadMoreComplete();
                    }
                }, 2000);
            }
        });

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
                Intent intent = new Intent(ScrollActivityResultOld.this, SearchActivity.class);
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
                Intent intent = new Intent(ScrollActivityResultOld.this, ScrollActivity.class);
                startActivity(intent);
            }
        });
        ivSearchResultsTopSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivityResultOld.this, SearchActivity.class);
                intent.putExtra("MC", tvSearchResultsTopMc.getText().toString());
                startActivity(intent);
            }
        });
        tvSearchTopMc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScrollActivityResultOld.this, SearchActivity.class);
                intent.putExtra("MC", tvSearchResultsTopMc.getText().toString());
                startActivity(intent);
            }
        });
        rlPopupFujin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = ScrollActivityResultOld.this.getLayoutInflater().inflate(R.layout.pop_scrollresults, null);
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("默认");
                mDatas.add("500米");
                mDatas.add("1000米");
                mDatas.add("2000米");
                mDatas.add("5000米");
                mDatas.add("全市");
                CommonAdapter<String> commonAdapter = new CommonAdapter<String>(ScrollActivityResultOld.this, R.layout.item_scrollresults_shaixuan, mDatas) {
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
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ScrollActivityResultOld.this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvPopupFujin.setLayoutManager(linearLayoutManager1);
                rvPopupFujin.setAdapter(commonAdapter);
                rvPopupFujin.addItemDecoration(new DividerItemDecoration(ScrollActivityResultOld.this, DividerItemDecoration.VERTICAL));
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
                View layout = ScrollActivityResultOld.this.getLayoutInflater().inflate(R.layout.pop_scrollresults, null);
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("智能排序");
                mDatas.add("离我最近");
                mDatas.add("评价最好");
                mDatas.add("团购优先");
                mDatas.add("人均最低");
                mDatas.add("人均最高");
                CommonAdapter<String> commonAdapter = new CommonAdapter<String>(ScrollActivityResultOld.this, R.layout.item_scrollresults_shaixuan, mDatas) {
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
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ScrollActivityResultOld.this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvPopupFujin.setLayoutManager(linearLayoutManager1);
                rvPopupFujin.setAdapter(commonAdapter);
                rvPopupFujin.addItemDecoration(new DividerItemDecoration(ScrollActivityResultOld.this, DividerItemDecoration.VERTICAL));
                PopupWindow window = new PopupWindow(layout, width, 600);
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

            }
        });
        rlPopupShaixuan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View layout = ScrollActivityResultOld.this.getLayoutInflater().inflate(R.layout.pop_scrollresults, null);
                List<String> mDatas = new ArrayList<String>();
                mDatas.add("0-50元");
                mDatas.add("50-100元");
                mDatas.add("100-300元");
                mDatas.add("300元以上");
                CommonAdapter<String> commonAdapter = new CommonAdapter<String>(ScrollActivityResultOld.this, R.layout.item_scrollresults_shaixuan, mDatas) {
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
                LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(ScrollActivityResultOld.this);
                linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
                rvPopupFujin.setLayoutManager(linearLayoutManager1);
                rvPopupFujin.setAdapter(commonAdapter);
                rvPopupFujin.addItemDecoration(new DividerItemDecoration(ScrollActivityResultOld.this, DividerItemDecoration.VERTICAL));
                PopupWindow window = new PopupWindow(layout, width, 600);
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

    }

    @Override
    public void queryZHCXListUnSuccessed(String msg) {

    }
}
