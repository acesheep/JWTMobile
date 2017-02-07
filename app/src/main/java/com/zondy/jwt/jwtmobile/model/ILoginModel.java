package com.zondy.jwt.jwtmobile.model;

import com.zondy.jwt.jwtmobile.callback.ILoginCallback;

/**
 * Created by sheep on 2016/12/23.
 */

public interface ILoginModel {
    void login(String username, String password, String simid, ILoginCallback loginCallback);
}
