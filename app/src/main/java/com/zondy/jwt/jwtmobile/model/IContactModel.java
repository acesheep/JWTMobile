package com.zondy.jwt.jwtmobile.model;

import android.content.Context;

import com.zondy.jwt.jwtmobile.callback.IQueryContactsByZZJGCallback;
import com.zondy.jwt.jwtmobile.callback.IQueryZZJGCallback;

/**
 * Created by sheep on 2017/1/17.
 */

public interface IContactModel {
    void queryZZJG(Context context,String zdlx, IQueryZZJGCallback queryZZJGCallback);
    void queryContactsByZZJG(Context context, String zzjg, IQueryContactsByZZJGCallback queryContactsByZZJGCallback);
}
