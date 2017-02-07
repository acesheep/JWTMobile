package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.util.ToastTool;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by sheep on 2017/1/19.
 */

public class SearchMoreActivity extends BaseActivity {
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.rl_remen_wangba)
    RelativeLayout rlRemenWangba;
    @BindView(R.id.rl_remen_xuexiao)
    RelativeLayout rlRemenXuexiao;
    @BindView(R.id.rl_remen_tingchec)
    RelativeLayout rlRemenTingchec;
    @BindView(R.id.rl_remen_chaoshi)
    RelativeLayout rlRemenChaoshi;
    @BindView(R.id.rl_remen_xiaofangs)
    RelativeLayout rlRemenXiaofangs;
    @BindView(R.id.rl_zhusu_lvguan)
    RelativeLayout rlZhusuLvguan;
    @BindView(R.id.rl_zhusu_qitian)
    RelativeLayout rlZhusuQitian;
    @BindView(R.id.rl_zhusu_sanxingji)
    RelativeLayout rlZhusuSanxingji;
    @BindView(R.id.rl_zhusu_hangting)
    RelativeLayout rlZhusuHangting;
    @BindView(R.id.rl_zhusu_rujia)
    RelativeLayout rlZhusuRujia;
    @BindView(R.id.rl_zhusu_jinjiang)
    RelativeLayout rlZhusuJinjiang;
    @BindView(R.id.rl_shenghuo_yinhang)
    RelativeLayout rlShenghuoYinhang;
    @BindView(R.id.rl_shenghuo_ATM)
    RelativeLayout rlShenghuoATM;
    @BindView(R.id.rl_shenghuo_yiyuan)
    RelativeLayout rlShenghuoYiyuan;
    @BindView(R.id.rl_shenghuo_yidong)
    RelativeLayout rlShenghuoYidong;
    @BindView(R.id.rl_shenghuo_jiayouz)
    RelativeLayout rlShenghuoJiayouz;
    @BindView(R.id.rl_shenghuo_chaoshi)
    RelativeLayout rlShenghuoChaoshi;
    @BindView(R.id.rl_wanle_wangba)
    RelativeLayout rlWanleWangba;
    @BindView(R.id.rl_wanle_KTV)
    RelativeLayout rlWanleKTV;
    @BindView(R.id.rl_wanle_dianyingyuan)
    RelativeLayout rlWanleDianyingyuan;
    @BindView(R.id.rl_wanle_jiuba)
    RelativeLayout rlWanleJiuba;
    @BindView(R.id.rl_wanle_dianwancheng)
    RelativeLayout rlWanleDianwancheng;
    @BindView(R.id.rl_remen_lvguan)
    RelativeLayout rlRemenLvguan;

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_search_more;
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


    @OnClick({R.id.rl_remen_lvguan, R.id.rl_remen_wangba, R.id.rl_remen_xuexiao, R.id.rl_remen_tingchec, R.id.rl_remen_chaoshi, R.id.rl_remen_xiaofangs, R.id.rl_zhusu_lvguan, R.id.rl_zhusu_qitian, R.id.rl_zhusu_sanxingji, R.id.rl_zhusu_hangting, R.id.rl_zhusu_rujia, R.id.rl_zhusu_jinjiang, R.id.rl_shenghuo_yinhang, R.id.rl_shenghuo_ATM, R.id.rl_shenghuo_yiyuan, R.id.rl_shenghuo_yidong, R.id.rl_shenghuo_jiayouz, R.id.rl_shenghuo_chaoshi, R.id.rl_wanle_wangba, R.id.rl_wanle_KTV, R.id.rl_wanle_dianyingyuan, R.id.rl_wanle_jiuba, R.id.rl_wanle_dianwancheng})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.rl_remen_lvguan:
                Intent intentlg=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentlg.putExtra("MC","旅馆");
                intentlg.putExtra("layername","FN_CS_LGY_PT");
                intentlg.putExtra("layerid","756");
                startActivity(intentlg);
                break;
            case R.id.rl_remen_wangba:
                Intent intentwb=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentwb.putExtra("MC","网吧");
                intentwb.putExtra("layername","FN_CS_WB_PT");
                intentwb.putExtra("layerid","736");
                startActivity(intentwb);
                break;
            case R.id.rl_remen_xuexiao:
                Intent intentxx=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentxx.putExtra("MC","学校");
                intentxx.putExtra("layername","FN_CS_XX_PT");
                intentxx.putExtra("layerid","737");
                startActivity(intentxx);
                break;
            case R.id.rl_remen_tingchec:
                Intent intenttcc=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intenttcc.putExtra("MC","停车场");
                intenttcc.putExtra("layername","FN_CS_TCC_PT");
                intenttcc.putExtra("layerid","738");
                startActivity(intenttcc);
                break;
            case R.id.rl_remen_chaoshi:
                Intent intentcs=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentcs.putExtra("MC","超市");
                intentcs.putExtra("layername","FN_CS_CS_PT");
                intentcs.putExtra("layerid","739");
                startActivity(intentcs);
                break;
            case R.id.rl_remen_xiaofangs:
                Intent intentxfs=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentxfs.putExtra("MC","消防栓");
                intentxfs.putExtra("layername","FN_CS_XFS_PT");
                intentxfs.putExtra("layerid","740");
                startActivity(intentxfs);
                break;
            case R.id.rl_zhusu_lvguan:
                Intent intentlg2=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentlg2.putExtra("MC","旅馆");
                intentlg2.putExtra("layername","FN_CS_LGY_PT");
                intentlg2.putExtra("layerid","735");
                startActivity(intentlg2);
                break;
            case R.id.rl_zhusu_qitian:
                Intent intentqt=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentqt.putExtra("MC","7天连锁");
                intentqt.putExtra("layername","FN_CS_7T_PT");
                intentqt.putExtra("layerid","741");
                startActivity(intentqt);
                break;
            case R.id.rl_zhusu_sanxingji:
                Intent intentsxj=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentsxj.putExtra("MC","三星级宾馆");
                intentsxj.putExtra("layername","FN_CS_SXJBG_PT");
                intentsxj.putExtra("layerid","742");
                startActivity(intentsxj);
                break;
            case R.id.rl_zhusu_hangting:
                Intent intentht=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentht.putExtra("MC","汉庭");
                intentht.putExtra("layername","FN_CS_HT_PT");
                intentht.putExtra("layerid","743");
                startActivity(intentht);
                break;
            case R.id.rl_zhusu_rujia:
                Intent intentrj=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentrj.putExtra("MC","如家");
                intentrj.putExtra("layername","FN_CS_RJ_PT");
                intentrj.putExtra("layerid","744");
                startActivity(intentrj);
                break;
            case R.id.rl_zhusu_jinjiang:
                Intent intentjj=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentjj.putExtra("MC","锦江之星");
                intentjj.putExtra("layername","FN_CS_JJZX_PT");
                intentjj.putExtra("layerid","745");
                startActivity(intentjj);
                break;
            case R.id.rl_shenghuo_yinhang:
                Intent intentyh=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentyh.putExtra("MC","银行");
                intentyh.putExtra("layername","FN_CS_YH_PT");
                intentyh.putExtra("layerid","746");
                startActivity(intentyh);
                break;
            case R.id.rl_shenghuo_ATM:
                Intent intentatm=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentatm.putExtra("MC","ATM");
                intentatm.putExtra("layername","FN_CS_ATM_PT");
                intentatm.putExtra("layerid","747");
                startActivity(intentatm);
                break;
            case R.id.rl_shenghuo_yiyuan:
                Intent intentyy=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentyy.putExtra("MC","医院");
                intentyy.putExtra("layername","FN_CS_YY_PT");
                intentyy.putExtra("layerid","748");
                startActivity(intentyy);
                break;
            case R.id.rl_shenghuo_yidong:
                Intent intentyd=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentyd.putExtra("MC","移动营业厅");
                intentyd.putExtra("layername","FN_CS_YDYYT_PT");
                intentyd.putExtra("layerid","749");
                startActivity(intentyd);
                break;
            case R.id.rl_shenghuo_jiayouz:
                Intent intentjyz=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentjyz.putExtra("MC","加油站");
                intentjyz.putExtra("layername","FN_CS_JYZ_PT");
                intentjyz.putExtra("layerid","750");
                startActivity(intentjyz);
                break;
            case R.id.rl_shenghuo_chaoshi:
                Intent intentcs2=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentcs2.putExtra("MC","超市");
                intentcs2.putExtra("layername","FN_CS_CS_PT");
                intentcs2.putExtra("layerid","739");
                startActivity(intentcs2);
                break;
            case R.id.rl_wanle_wangba:
                Intent intentwb2=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentwb2.putExtra("MC","网吧");
                intentwb2.putExtra("layername","FN_CS_WB_PT");
                intentwb2.putExtra("layerid","736");
                startActivity(intentwb2);
                break;
            case R.id.rl_wanle_KTV:
                Intent intentktv=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentktv.putExtra("MC","KTV");
                intentktv.putExtra("layername","FN_CS_KTV_PT");
                intentktv.putExtra("layerid","751");
                startActivity(intentktv);
                break;
            case R.id.rl_wanle_dianyingyuan:
                Intent intentdyy=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentdyy.putExtra("MC","电影院");
                intentdyy.putExtra("layername","FN_CS_DYY_PT");
                intentdyy.putExtra("layerid","752");
                startActivity(intentdyy);
                break;
            case R.id.rl_wanle_jiuba:
                Intent intentjb=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentjb.putExtra("MC","酒吧");
                intentjb.putExtra("layername","FN_CS_JB_PT");
                intentjb.putExtra("layerid","753");
                startActivity(intentjb);
                break;
            case R.id.rl_wanle_dianwancheng:
                Intent intentdwc=new Intent(SearchMoreActivity.this,ScrollActivityResult.class);
                intentdwc.putExtra("MC","电玩城");
                intentdwc.putExtra("layername","FN_CS_DWC_PT");
                intentdwc.putExtra("layerid","754");
                startActivity(intentdwc);
                break;
        }
    }
}
