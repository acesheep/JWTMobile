package com.zondy.jwt.jwtmobile.presenter.impl;

import android.content.Context;

import com.zondy.jwt.jwtmobile.callback.IQueryTCFZListCallback;
import com.zondy.jwt.jwtmobile.callback.IQueryZHCXListCallback;
import com.zondy.jwt.jwtmobile.entity.EntitySearchResult;
import com.zondy.jwt.jwtmobile.model.ISearchModel;
import com.zondy.jwt.jwtmobile.model.impl.SearchModelImpl;
import com.zondy.jwt.jwtmobile.presenter.ISearchPresenter;
import com.zondy.jwt.jwtmobile.view.ISearchTCFLView;
import com.zondy.jwt.jwtmobile.view.ISearchZHCXListView;

import java.util.List;

/**
 * Created by sheep on 2017/1/18.
 */

public class SearchPresenterImpl implements ISearchPresenter{
    private ISearchTCFLView searchTCFLView;
    private ISearchZHCXListView searchZHCXListView;
    private ISearchModel searchModel;
    Context context;
    public SearchPresenterImpl(Context context,ISearchTCFLView searchTCFLView){
        super();
        this.searchTCFLView=searchTCFLView;
        this.context=context;
        searchModel=new SearchModelImpl();
    }
    public SearchPresenterImpl(Context context, ISearchZHCXListView searchZHCXListView){
        super();
        this.searchZHCXListView=searchZHCXListView;
        this.context=context;
        searchModel=new SearchModelImpl();
    }
    /**
     * 通过图层名直接获取查询结果
     * @param keyword
     * @param radius
     * @param longitude
     * @param latitude
     * @param nowpage
     * @param pagesize
     */
    @Override
    public void queryZHCXList(String layerid,String layername,int orderType,String keyword, double radius, double longitude, double latitude, int nowpage, int pagesize) {
        searchModel.queryZHCXList(context,layerid,layername,orderType,keyword, radius, longitude, latitude, nowpage, pagesize, new IQueryZHCXListCallback() {
            @Override
            public void querySuccessed(List<EntitySearchResult> allEntitys) {
                searchZHCXListView.queryZHCXListSuccessed(allEntitys);
            }

            @Override
            public void queryUnSuccessed(String msg) {
                searchZHCXListView.queryZHCXListUnSuccessed(msg);
            }
        });
    }

    @Override
    public void queryTCFZList() {
        searchModel.queryTCFZList(context, new IQueryTCFZListCallback() {
            @Override
            public void querySuccessed() {

            }

            @Override
            public void queryUnSuccessed() {

            }
        });
    }
}
