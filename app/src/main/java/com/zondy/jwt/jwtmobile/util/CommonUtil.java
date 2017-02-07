package com.zondy.jwt.jwtmobile.util;

import android.content.Context;
import android.telephony.TelephonyManager;

/**
 * Created by sheep on 2017/1/9.
 */

public class CommonUtil {
    public static String getDeviceId(Context context) {
        String deviceId = "";
        TelephonyManager tm = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        if (tm != null) {
            deviceId = tm.getDeviceId();
        }
        return deviceId;
    }
}
