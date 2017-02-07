package com.zondy.jwt.jwtmobile.model.impl;

import android.util.Log;

import com.google.gson.Gson;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zondy.jwt.jwtmobile.callback.ILoginCallback;
import com.zondy.jwt.jwtmobile.callback.ILogoutCallback;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.manager.UrlManager;
import com.zondy.jwt.jwtmobile.model.ISettingModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.Response;

import static android.R.attr.password;
import static android.content.ContentValues.TAG;

/**
 * Created by sheep on 2017/1/11.
 */

public class SettingModelImpl implements ISettingModel {

    @Override
    public void logout(String jh, String simid, final ILogoutCallback logoutCallback) {
        String url = UrlManager.getSERVER() + UrlManager.LOGOUT;
        JSONObject param = new JSONObject();
        try {
            param.put("jh", jh);
            param.put("simid", simid);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        try {
            OkHttpUtils.postString().url(url).content(param.toString()).mediaType(MediaType.parse("application/json; charset=utf-8"))
                    .build().execute(new Callback() {
                @Override
                public Object parseNetworkResponse(Response response, int id) throws Exception {
                    String string = response.body().string();
                    Log.i("sheep", "parseNetworkResponse: "+string);
                    JSONObject object = new JSONObject(string);
                    int resultCode = object.optInt("result");
                    switch (resultCode) {
                        case 1:
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public void onError(Call call, Exception e, int id) {

                }

                @Override
                public void onResponse(Object response, int id) {
                    if ((Boolean) response) {
                        logoutCallback.logoutSuccessed();
                    } else {
                        logoutCallback.logoutUnSuccessed();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
