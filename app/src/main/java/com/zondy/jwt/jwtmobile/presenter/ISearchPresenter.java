package com.zondy.jwt.jwtmobile.presenter;

import static android.R.attr.radius;

/**
 * Created by sheep on 2017/1/18.
 */

public interface ISearchPresenter {
    void queryZHCXList(String layerid,String layername,int orderType,String keyword,double radius,double longitude,double latitude,int nowpage,int pagesize);
    void queryTCFZList();
}
