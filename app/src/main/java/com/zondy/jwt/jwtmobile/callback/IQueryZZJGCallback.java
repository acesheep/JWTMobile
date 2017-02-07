package com.zondy.jwt.jwtmobile.callback;

import com.zondy.jwt.jwtmobile.entity.EntityZD;

import java.util.List;

/**
 * Created by sheep on 2017/1/17.
 */

public interface IQueryZZJGCallback {
    void querySuccessed(List<EntityZD> allEntitys);
    void queryUnSuccessed(String msg);
}
