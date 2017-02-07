package com.zondy.jwt.jwtmobile.callback;

/**
 * Created by sheep on 2017/1/9.
 */

public interface IipSetListener {
    /**
     * 当IP设置完成之后调用
     *
     * @param serverIp   服务IP
     * @param serverPort 服务端口
     * @param pushIp     推送IP
     * @param pushPort   推送端口
     */
    public void onIpSeted(String serverIp, String serverPort, String pushIp,
                          String pushPort);
}
