package com.zondy.jwt.jwtmobile.callback;

import com.zondy.jwt.jwtmobile.entity.EntityContact;

import java.util.List;

/**
 * Created by sheep on 2017/1/17.
 */

public interface IQueryContactsByZZJGCallback {
    void querySuccessed(List<EntityContact> contacts);
    void queryUnSuccessed(String msg);
}
