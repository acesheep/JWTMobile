package com.zondy.jwt.jwtmobile.model.impl;

import android.content.Context;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zondy.jwt.jwtmobile.callback.IQueryTCFZListCallback;
import com.zondy.jwt.jwtmobile.callback.IQueryZHCXListCallback;
import com.zondy.jwt.jwtmobile.entity.EntitySearchResult;
import com.zondy.jwt.jwtmobile.entity.EntityZD;
import com.zondy.jwt.jwtmobile.manager.UrlManager;
import com.zondy.jwt.jwtmobile.model.ISearchModel;
import com.zondy.jwt.jwtmobile.util.CommonUtil;
import com.zondy.jwt.jwtmobile.util.SharedTool;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

import static android.R.attr.radius;

/**
 * Created by sheep on 2017/1/18.
 */

public class SearchModelImpl implements ISearchModel{
    @Override
    public void queryZHCXList(Context context, String layerid,String layername,int orderType,String keyword, double radius, double longitude, double latitude, int nowpage, int pagesize,
                              final IQueryZHCXListCallback queryZHCXListCallback) {
        String url= UrlManager.getSERVER()+UrlManager.queryZHCXList;
        JSONObject param=new JSONObject();
        try {
            if(!TextUtils.isEmpty(layerid)&&!TextUtils.isEmpty(layername)){
                param.put("layerid",layerid);
                param.put("layername",layername);
            }
            param.put("keyword",keyword);
            param.put("radius",radius);
            param.put("x",longitude);
            param.put("y",latitude);
            param.put("nowpage",nowpage);
            param.put("pagesize",pagesize);
            param.put("orderType",orderType);//排序类型，1 代表距离排序，2 代表采集时间排序。 默认为距离排序
            param.put("jh", SharedTool.getInstance().getUserInfo(context).getUserName());
            param.put("simid", CommonUtil.getDeviceId(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            OkHttpUtils.postString().url(url).content(param.toString()).mediaType(MediaType.parse("application/json; charset=utf-8"))
                    .build().execute(new Callback() {

                @Override
                public Object parseNetworkResponse(Response response, int id) throws Exception {
                    String string=response.body().string();
                    JSONObject object=new JSONObject(string);
                    int resultCode=object.optInt("result");
                    String msg=object.optString("message");

                    switch (resultCode){
                        case 1:
                            List<EntitySearchResult> allEntitys=new ArrayList<EntitySearchResult>();
                            JSONArray zhcxlist=null;
                            zhcxlist=object.optJSONArray("zhcxxxList");
                            if(zhcxlist!=null){
                                for(int i=0;i<zhcxlist.length();i++){
                                    JSONObject zhcxObj=zhcxlist.getJSONObject(i);
                                    String obj=zhcxObj.toString();
                                    EntitySearchResult zhcxResult=new Gson().fromJson(obj,EntitySearchResult.class);
                                    allEntitys.add(zhcxResult);
                                }
                            }
                            return allEntitys;
                        default:
                            return msg;
                    }
                }

                @Override
                public void onError(Call call, Exception e, int id) {

                }

                @Override
                public void onResponse(Object response, int id) {
                    if(response instanceof String){
                        String msg= (String) response;
                        queryZHCXListCallback.queryUnSuccessed(msg);
                    }else {
                        List<EntitySearchResult> allEntitys= (List<EntitySearchResult>) response;
                        queryZHCXListCallback.querySuccessed(allEntitys);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 综合查询 查询图层分类
     * @param context
     * @param queryTCFZListCallback
     */
    @Override
    public void queryTCFZList(Context context, IQueryTCFZListCallback queryTCFZListCallback) {
        String url= UrlManager.getSERVER()+UrlManager.queryTCFZList;
        JSONObject param=new JSONObject();
        try {
            param.put("jh", SharedTool.getInstance().getUserInfo(context).getUserName());
            param.put("simid", CommonUtil.getDeviceId(context));
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            OkHttpUtils.postString().url(url).content(param.toString()).mediaType(MediaType.parse("application/json; charset=utf-8"))
                    .build().execute(new Callback() {

                @Override
                public Object parseNetworkResponse(Response response, int id) throws Exception {
                    return null;
                }

                @Override
                public void onError(Call call, Exception e, int id) {

                }

                @Override
                public void onResponse(Object response, int id) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
