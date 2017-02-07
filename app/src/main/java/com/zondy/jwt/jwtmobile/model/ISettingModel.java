package com.zondy.jwt.jwtmobile.model;

import com.zondy.jwt.jwtmobile.callback.ILogoutCallback;

/**
 * Created by sheep on 2017/1/11.
 */

public interface ISettingModel {
    void logout(String jh, String simid, ILogoutCallback logoutCallback);
}
