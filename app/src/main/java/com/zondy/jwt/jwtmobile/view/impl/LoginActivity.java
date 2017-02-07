package com.zondy.jwt.jwtmobile.view.impl;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.BaseActivity;
import com.zondy.jwt.jwtmobile.callback.IipSetListener;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.manager.IpSetManager;
import com.zondy.jwt.jwtmobile.manager.UrlManager;
import com.zondy.jwt.jwtmobile.presenter.ILoginPresenter;
import com.zondy.jwt.jwtmobile.presenter.impl.LoginPresenterImpl;
import com.zondy.jwt.jwtmobile.util.CommonUtil;
import com.zondy.jwt.jwtmobile.util.SharedTool;
import com.zondy.jwt.jwtmobile.util.ToastTool;
import com.zondy.jwt.jwtmobile.view.ILoginView;


import butterknife.BindView;

public class LoginActivity extends BaseActivity implements ILoginView, View.OnClickListener {
    EntityUser entityUser;
    @BindView(R.id.et_uname)
    EditText et_uname;//登录用户
    @BindView(R.id.et_pword)
    EditText et_pword;//登录密码
    @BindView(R.id.tv_dl_login)
    TextView tv_dl_login;//登录按钮
    @BindView(R.id.btn_setip)
    TextView btn_setip;//设置ip按钮
    @BindView(R.id.ll_container)
    RelativeLayout ll_container;
    IpSetManager ipSetManager;
    IipSetListener ipSetListener;

    ILoginPresenter loginPresenter = new LoginPresenterImpl(this);

    @Override
    public int setCustomContentViewResourceId() {
        return R.layout.activity_login;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initParam();
        initView();
        initOperator();
    }

    private void initParam() {
        entityUser = SharedTool.getInstance().getUserInfo(this);
        ipSetManager = new IpSetManager();
        ipSetListener = new IipSetListener() {
            @Override
            public void onIpSeted(String serverIp, String serverPort, String pushIp, String pushPort) {
                // TODO: 2017/1/9    需要增加检查更新的操作
            }
        };
    }

    private void initView() {
        if (entityUser != null) {
            et_uname.setText(entityUser.getUserName());
            et_pword.setText(entityUser.getPassword());
        }
        tv_dl_login.setOnClickListener(this);
        btn_setip.setOnClickListener(this);
    }

    private void initOperator() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_setip:
                ipSetManager.showSetIpDialog(LoginActivity.this, ipSetListener);
                break;
            case R.id.tv_dl_login:
                final String userName = et_uname.getText().toString().trim();
                final String password = et_pword.getText().toString().trim();
                if (TextUtils.isEmpty(userName) || TextUtils.isEmpty(password)) {
                    ToastTool.getInstance().shortLength(context, "用户名或密码不能为空", true);
                    return;
                }

                if (TextUtils.isEmpty(UrlManager.HOST_IP)
                        || TextUtils.isEmpty(UrlManager.HOST_PORT)) {
                    ToastTool.getInstance().shortLength(context, "请先设置ip和端口", true);
                    return;
                }
                String deviceId = CommonUtil.getDeviceId(context);
                loginPresenter.login(userName, password, deviceId);
                break;
        }
    }


    /**
     * 保存GPS定位配置及更新定位服务.
     *
     * @param sTimeInterval
     * @param sDistanceInterval
     */
    public void saveGPSSetting(String sTimeInterval, String sDistanceInterval) {
        long distanceInterval = 0;
        long timeInterval = 0;
        try {
            timeInterval = Long.valueOf(sTimeInterval);
        } catch (Exception e) {
        }
        try {
            distanceInterval = Long.valueOf(sDistanceInterval);
        } catch (Exception e) {
        }
        if (distanceInterval == 0 && timeInterval == 0) {// 都为0时,不需要实时每秒都上传GPS,默认30s一次.
            distanceInterval = 0;
            timeInterval = 30;
        }
        SharedTool.getInstance().saveLocationInterval(context, timeInterval,
                distanceInterval);

    }


    @Override
    public void loginSuccessed(EntityUser entityUser) {
        entityUser.setPassword(et_pword.getText().toString());//因为服务端没有返回用户密码，此操作为保存密码
        //保存用户信息
        SharedTool.getInstance().saveUserInfo(LoginActivity.this, entityUser);
        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    @Override
    public void loginFailed() {
        ToastTool.getInstance().shortLength(this, "网络请求失败！", true);
    }

    @Override
    public void loginUnSuccessed(String msg) {
        ToastTool.getInstance().shortLength(this, msg, true);
    }

}

