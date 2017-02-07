package com.zondy.jwt.jwtmobile.callback;

import com.zondy.jwt.jwtmobile.entity.EntityUser;

/**
 * Created by sheep on 2017/1/9.
 */

public interface ILoginCallback {
    void loginSuccess(EntityUser entityUser);
    void loginUnSuccessed(String msg);
    void loginFailed();
}
