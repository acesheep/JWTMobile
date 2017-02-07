package com.zondy.jwt.jwtmobile.presenter.impl;

import com.zondy.jwt.jwtmobile.callback.ILoginCallback;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.model.ILoginModel;
import com.zondy.jwt.jwtmobile.model.impl.LoginModelImpl;
import com.zondy.jwt.jwtmobile.presenter.ILoginPresenter;
import com.zondy.jwt.jwtmobile.view.ILoginView;

/**
 * Created by sheep on 2016/12/23.
 */

public class LoginPresenterImpl implements ILoginPresenter{
    private ILoginView loginView;
    private ILoginModel loginModel;
    public LoginPresenterImpl(ILoginView loginView){
        super();
        this.loginView=loginView;
        loginModel=new LoginModelImpl();
    }

    /**
     * 登录
     * @param username
     * @param password
     * @param simid
     */
    @Override
    public void login(String username, String password, String simid) {
        loginModel.login(username, password, simid, new ILoginCallback() {
            @Override
            public void loginSuccess(EntityUser entityUser) {
                loginView.loginSuccessed(entityUser);
            }

            @Override
            public void loginUnSuccessed(String msg) {
                loginView.loginUnSuccessed(msg);
            }

            @Override
            public void loginFailed() {
                loginView.loginFailed();
            }
        });
    }
}
