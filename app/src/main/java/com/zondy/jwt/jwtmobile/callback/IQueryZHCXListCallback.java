package com.zondy.jwt.jwtmobile.callback;

import com.zondy.jwt.jwtmobile.entity.EntitySearchResult;

import java.util.List;

/**
 * Created by sheep on 2017/1/19.
 */

public interface IQueryZHCXListCallback {
    void querySuccessed(List<EntitySearchResult> allEntitys);
    void queryUnSuccessed(String msg);
}
