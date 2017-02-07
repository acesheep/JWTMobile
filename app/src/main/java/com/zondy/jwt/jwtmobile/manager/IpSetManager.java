package com.zondy.jwt.jwtmobile.manager;

import java.util.Properties;

import android.app.Activity;
import android.app.Dialog;
import android.text.TextUtils;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.base.MyApplication;
import com.zondy.jwt.jwtmobile.callback.IipSetListener;
import com.zondy.jwt.jwtmobile.global.Constant;
import com.zondy.jwt.jwtmobile.manager.UrlManager;
import com.zondy.jwt.jwtmobile.util.SharedTool;
import com.zondy.jwt.jwtmobile.util.ToastTool;


public class IpSetManager {

    Dialog setIpDialog;
    int selectIpCount;
    IipSetListener ipSetListener;

    public void showSetIpDialog(final Activity activity,
                                IipSetListener ipSetListener) {
        this.ipSetListener = ipSetListener;
        Window window = null;
        if (setIpDialog == null) {
            setIpDialog = new Dialog(activity, R.style.edit_dialog_style);
            setIpDialog.show();

            window = setIpDialog.getWindow();
            window.setWindowAnimations(R.style.tongjfx_popupwindow_animate_style);
            window.setContentView(R.layout.dia_login_setip);
            /*
			 * 将对话框的大小按屏幕大小的百分比设置
			 */
            WindowManager m = ((Activity) activity).getWindowManager();
            Display d = m.getDefaultDisplay(); // 获取屏幕宽、高用
            WindowManager.LayoutParams p = setIpDialog.getWindow()
                    .getAttributes(); // 获取对话框当前的参数值
        } else {
            window = setIpDialog.getWindow();
        }
        setIpDialog.show();
        final EditText etIpno = (EditText) window.findViewById(R.id.et_ipno);
        final EditText etPort = (EditText) window.findViewById(R.id.et_port);
        final EditText etPushIpno = (EditText) window
                .findViewById(R.id.et_push_ipno);
        final EditText etPushPort = (EditText) window
                .findViewById(R.id.et_push_port);

        String ipAndPort = SharedTool.getInstance().getIp(activity);
        String[] ips = ipAndPort.split("_");
        if (ips.length == 4 && !TextUtils.isEmpty(ips[0])
                && !TextUtils.isEmpty(ips[1]) && !TextUtils.isEmpty(ips[2])
                && !TextUtils.isEmpty(ips[3])) {
            etIpno.setText(ips[0]);
            etIpno.setSelection(etIpno.getText().length());
            etPort.setText(ips[1]);
            etPort.setSelection(etPort.getText().length());
            etPushIpno.setText(ips[2]);
            etPushIpno.setSelection(etPushIpno.getText().length());
            etPushPort.setText(ips[3]);
            etPushPort.setSelection(etPushPort.getText().length());

            UrlManager.HOST_IP = ips[0];
            UrlManager.HOST_PORT = ips[1];
            UrlManager.PUSH_HOST_IP = ips[2];
            UrlManager.PUSH_HOST_PORT = ips[3];
        } else {// sharedpreference保存的文件不正确,则使用默认配置
            String[] defaultIps = new String[4];
            if (Constant.JWT_AREA_SELECTED.equals(Constant.JWT_AREA_FN)) {
                defaultIps[0] = "127.0.0.1";
                defaultIps[1] = "9096/fl1";
                defaultIps[2] = "127.0.0.1";
                defaultIps[3] = "9092";
            } else if (Constant.JWT_AREA_SELECTED.equals(Constant.JWT_AREA_LYG)) {
                defaultIps[0] = "10.142.137.173";
                defaultIps[1] = "9087";
                defaultIps[2] = "10.142.137.173";
                defaultIps[3] = "5222";
            } else if (Constant.JWT_AREA_SELECTED.equals(Constant.JWT_AREA_ZJG)) {
                defaultIps[0] = "192.168.9.188";
                defaultIps[1] = "8080";
                defaultIps[2] = "192.168.9.188";
                defaultIps[3] = "5222";
            } else if (Constant.JWT_AREA_SELECTED.equals(Constant.JWT_AREA_WH)) {
                defaultIps[0] = "61.183.129.187";
                defaultIps[1] = "4040";
                defaultIps[2] = "61.183.129.187";
                defaultIps[3] = "4041";
            } else if (Constant.JWT_AREA_SELECTED
                    .equals(Constant.JWT_AREA_TEST)) {
                defaultIps[0] = "192.168.10.217";
                defaultIps[1] = "8080";
                defaultIps[2] = "192.168.10.217";
                defaultIps[3] = "5222";
            } else {
                // 默认使用武汉测试地址
                defaultIps[0] = "192.168.10.217";
                defaultIps[1] = "8080";
                defaultIps[2] = "192.168.10.217";
                defaultIps[3] = "5222";
            }
            etIpno.setText(defaultIps[0]);
            etIpno.setSelection(etIpno.getText().length());
            etPort.setText(defaultIps[1]);
            etPort.setSelection(etPort.getText().length());
            etPushIpno.setText(defaultIps[2]);
            etPushIpno.setSelection(etPushIpno.getText().length());
            etPushPort.setText(defaultIps[3]);
            etPushPort.setSelection(etPushPort.getText().length());

            UrlManager.HOST_IP = defaultIps[0];
            UrlManager.HOST_PORT = defaultIps[1];
            UrlManager.PUSH_HOST_IP = defaultIps[2];
            UrlManager.PUSH_HOST_PORT = defaultIps[3];
        }

        Button btn_setip = (Button) window.findViewById(R.id.btn_setip);
        if (!MyApplication.IS_PRODUCT_ENVIRONMENT) {// 是开发环境
            btn_setip.setVisibility(View.VISIBLE);
            btn_setip.setOnClickListener(new OnClickListener() {

                @Override
                public void onClick(View arg0) {
                    selectIpCount++;
                    Properties props = new Properties();
                    try {
                        int id = activity.getResources().getIdentifier(
                                "ipconfig", "raw", activity.getPackageName());
                        props.load(activity.getResources().openRawResource(id));
                        String ip1 = props.getProperty("ip1", "");
                        String port1_1 = props.getProperty("port1_1", "");
                        String port1_2 = props.getProperty("port1_2", "");
                        String ip2 = props.getProperty("ip2", "");
                        String port2_1 = props.getProperty("port2_1", "");
                        String port2_2 = props.getProperty("port2_2", "");
                        String ip3 = props.getProperty("ip3", "");
                        String port3_1 = props.getProperty("port3_1", "");
                        String port3_2 = props.getProperty("port3_2", "");
                        String ip4 = props.getProperty("ip4", "");
                        String port4_1 = props.getProperty("port4_1", "");
                        String port4_2 = props.getProperty("port4_2", "");

                        if (selectIpCount % 4 == 0) {
                            etIpno.setText(ip1);
                            etPort.setText(port1_1);
                            etPushIpno.setText(ip1);
                            etPushPort.setText(port1_2);
                        }
                        if (selectIpCount % 4 == 1) {
                            etIpno.setText(ip2);
                            etPort.setText(port2_1);
                            etPushIpno.setText(ip2);
                            etPushPort.setText(port2_2);
                        }
                        if (selectIpCount % 4 == 2) {
                            etIpno.setText(ip3);
                            etPort.setText(port3_1);
                            etPushIpno.setText(ip3);
                            etPushPort.setText(port3_2);
                        }
                        if (selectIpCount % 4 == 3) {
                            etIpno.setText(ip4);
                            etPort.setText(port4_1);
                            etPushIpno.setText(ip4);
                            etPushPort.setText(port4_2);
                        }

                    } catch (Exception e) {
                        Log.e("loadProperties",
                                "Could not find the properties file.", e);
                        e.printStackTrace();
                    }

                }
            });
        } else {
            btn_setip.setVisibility(View.GONE);
        }

        TextView btnConfir = (TextView) window.findViewById(R.id.btn_confirm);
        TextView btnCancel = (TextView) window.findViewById(R.id.btn_cancel);
        OnClickListener listener = new OnClickListener() {

            @Override
            public void onClick(View arg0) {
                switch (arg0.getId()) {
                    case R.id.btn_confirm:
                        String ipno = etIpno.getText().toString().trim();
                        String port = etPort.getText().toString().trim();
                        String pushIpno = etPushIpno.getText().toString().trim();
                        String pushPort = etPushPort.getText().toString().trim();
                        if (TextUtils.isEmpty(ipno) || TextUtils.isEmpty(port)
                                || TextUtils.isEmpty(pushIpno)
                                || TextUtils.isEmpty(pushPort)) {
                            ToastTool.getInstance().shortLength(activity,
                                    "ip或端口号不能为空", true);
                        } else {
                            UrlManager.HOST_IP = ipno;
                            UrlManager.HOST_PORT = port;
                            UrlManager.PUSH_HOST_IP = pushIpno;
                            UrlManager.PUSH_HOST_PORT = pushPort;
                            if (IpSetManager.this.ipSetListener != null) {
                                IpSetManager.this.ipSetListener.onIpSeted(
                                        UrlManager.HOST_IP, UrlManager.HOST_PORT,
                                        UrlManager.PUSH_HOST_IP,
                                        UrlManager.PUSH_HOST_PORT);
                            }

                            SharedTool.getInstance().saveIp(activity, ipno, port,
                                    pushIpno, pushPort);
                            setIpDialog.dismiss();
                            ToastTool.getInstance().shortLength(activity, "设置成功", true);
                        }
                        break;
                    case R.id.btn_cancel:
                        setIpDialog.dismiss();
                        break;

                    default:
                        break;
                }
            }
        };
        btnConfir.setOnClickListener(listener);
        btnCancel.setOnClickListener(listener);
    }
}
