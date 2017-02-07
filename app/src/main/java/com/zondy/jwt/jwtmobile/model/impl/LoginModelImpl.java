package com.zondy.jwt.jwtmobile.model.impl;


import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zondy.jwt.jwtmobile.callback.ILoginCallback;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.manager.UrlManager;
import com.zondy.jwt.jwtmobile.model.ILoginModel;

import org.json.JSONException;
import org.json.JSONObject;


import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;


/**
 * Created by sheep on 2016/12/23.
 */

public class LoginModelImpl implements ILoginModel {

    @Override
    public void login(String username, String password, final String simid, final ILoginCallback loginCallback) {
        String url = UrlManager.getSERVER() + UrlManager.LOGIN;
        JSONObject param=new JSONObject();
        try {
            param.put("userName",username);
            param.put("password",password);
            param.put("simid",simid);
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
                            EntityUser entityUser=new Gson().fromJson(string,EntityUser.class);
                            return entityUser;
                        default:
                            return msg;
                    }
                }


                @Override
                public void onError(Call call, Exception e, int id) {
                    loginCallback.loginFailed();
                }

                @Override
                public void onResponse(Object response, int id) {
                    if(response instanceof EntityUser){
                        EntityUser entityUser= (EntityUser) response;
                        loginCallback.loginSuccess(entityUser);
                    }else {
                        loginCallback.loginUnSuccessed((String) response);
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}