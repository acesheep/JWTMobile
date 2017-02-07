package com.zondy.jwt.jwtmobile.view;

import com.zondy.jwt.jwtmobile.entity.EntityUser;

/**
 * Created by sheep on 2016/12/23.
 */

public interface ILoginView {
    void loginSuccessed(EntityUser entityUser);
    void loginFailed();
    void loginUnSuccessed(String msg);
}
