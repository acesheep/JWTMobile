package com.zondy.jwt.jwtmobile.view;

import com.zondy.jwt.jwtmobile.entity.EntityContact;
import com.zondy.jwt.jwtmobile.entity.EntityZD;

import java.util.List;

/**
 * Created by sheep on 2017/1/17.
 */

public interface IContactView {
    void queryZZJGSuccessed(List<EntityZD> allEntitys);
    void queryZZJGUnSuccessed(String msg);
    void queryContactsByZZJGSuccessed(List<EntityContact> contacts);
    void queryContactsByZZJGUnSuccessed(String msg);
}
