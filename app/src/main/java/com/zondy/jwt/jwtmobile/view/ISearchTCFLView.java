package com.zondy.jwt.jwtmobile.view;

import com.zondy.jwt.jwtmobile.entity.EntityTCFL;

import java.util.List;

/**
 * Created by sheep on 2017/1/18.
 */

public interface ISearchTCFLView {
    void queryTCFLSuccessed(List<EntityTCFL> tcfls);
    void queryTCFLUnSuccessed();
}
