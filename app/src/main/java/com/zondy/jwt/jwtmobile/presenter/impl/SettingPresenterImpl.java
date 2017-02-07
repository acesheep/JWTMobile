package com.zondy.jwt.jwtmobile.presenter.impl;

import com.zondy.jwt.jwtmobile.callback.ILoginCallback;
import com.zondy.jwt.jwtmobile.callback.ILogoutCallback;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.model.ILoginModel;
import com.zondy.jwt.jwtmobile.model.ISettingModel;
import com.zondy.jwt.jwtmobile.model.impl.LoginModelImpl;
import com.zondy.jwt.jwtmobile.model.impl.SettingModelImpl;
import com.zondy.jwt.jwtmobile.presenter.ISettingPresenter;
import com.zondy.jwt.jwtmobile.view.ILoginView;
import com.zondy.jwt.jwtmobile.view.ISettingAccountInfoView;
import com.zondy.jwt.jwtmobile.view.ISettingView;

/**
 * Created by sheep on 2017/1/11.
 */

public class SettingPresenterImpl implements ISettingPresenter {
    private ISettingView settingView;
    private ISettingModel settingModel;
    private ISettingAccountInfoView settingAccountInfoView;
    public SettingPresenterImpl(ISettingView settingView) {
        super();
        this.settingView = settingView;
        settingModel = new SettingModelImpl();
    }

    public SettingPresenterImpl(ISettingAccountInfoView settingAccountInfoView){
        super();
        this.settingAccountInfoView=settingAccountInfoView;
        settingModel = new SettingModelImpl();
    }

    /**
     * 退出登录
     * setting界面
     * @param jh
     * @param simid
     */
    @Override
    public void logout(String jh, String simid) {
        settingModel.logout(jh, simid, new ILogoutCallback() {
            @Override
            public void logoutSuccessed() {
                settingView.logoutSuccessed();
            }

            @Override
            public void logoutUnSuccessed() {
                settingView.logoutUnSuccessed();
            }
        });
    }
    /**
     * 退出登录
     * settingAccoutInfo界面
     * @param jh
     * @param simid
     */
    @Override
    public void logoutAccout(String jh, String simid) {
        settingModel.logout(jh, simid, new ILogoutCallback() {
            @Override
            public void logoutSuccessed() {
                settingAccountInfoView.logoutSuccessed();
            }

            @Override
            public void logoutUnSuccessed() {
                settingAccountInfoView.logoutUnSuccessed();
            }
        });
    }
}
