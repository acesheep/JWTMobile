package com.zondy.jwt.jwtmobile.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;

import com.zondy.jwt.jwtmobile.entity.EntityLocation;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.global.Constant;

import static com.zondy.jwt.jwtmobile.global.Constant.USER_SHARED_FILE;


public class SharedTool {

    private static SharedTool instance = null;

    private SharedTool() {
    }

    public static synchronized SharedTool getInstance() {
        if (instance == null) {
            instance = new SharedTool();
        }
        return instance;
    }

    /**
     * 保存上次获取的经纬度
     *
     * @param longitude
     * @param latitude
     */
    public void saveLastLocation(Context context, double longitude, double latitude) {
        SharedPreferences preferences = context.getSharedPreferences(Constant.USER_SHARED_FILE, Activity.MODE_PRIVATE);
        Editor editor=preferences.edit();
        editor.putString("longitude",longitude+"");
        editor.putString("latitude",latitude+"");
        editor.commit();
    }

    /**
     * 功能描述：保存用户信息到配置文件
     *
     * @param
     */
    public void saveUserInfo(Context context, EntityUser user) {
        SharedPreferences preferences = context.getSharedPreferences(
                Constant.USER_SHARED_FILE, Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
        editor.putString("userName", user.getUserName());
        editor.putString("password", user.getPassword());
        editor.putString("userId", user.getUserId());
        editor.putString("usertype", user.getUsertype());
        editor.putString("zzjgdm", user.getZzjgdm());
        editor.putString("zzjgmc", user.getZzjgmc());
        editor.putString("ctname", user.getCtname());
        editor.putString("carid", user.getCarid());
        editor.putString("roleId", user.getRoleId());
        editor.putString("ssxq", user.getSsxq());
        editor.putString("phone", user.getPhone());
        editor.commit();

    }

    /**
     * 清除用户信息
     *
     * @param context
     */
    public void clearUserInfo(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_PRIVATE);
        Editor editor = preferences.edit();
//		editor.remove("userName");
//		editor.remove("password");// user.getPassword());
        editor.remove("userId");// user.getUserId());/
        editor.remove("usertype");// user.getUsertype());
        editor.remove("zzjgdm");// user.getZzjgdm());
        editor.remove("zzjgmc");
        editor.remove("ctname");// user.getCtname());
        editor.remove("carid");// user.getCarid());
        editor.remove("roleId");// user.getRoleId());
        editor.remove("ssxq");// user.getSsxq());
        editor.remove("phone");// user.getSsxq());
        editor.commit();
    }

    /**
     * 读取偏好存储中最近的gps定位信息
     * @param context
     * @return
     */
    public EntityLocation getLocationInfo(Context context){
        SharedPreferences preferences=context.getSharedPreferences(USER_SHARED_FILE,Activity.MODE_PRIVATE);
        EntityLocation entityLocation=new EntityLocation();
        entityLocation.setLongitude(preferences.getString("longitude",""));
        entityLocation.setLatitude(preferences.getString("latitude",""));
        return entityLocation;
    }
    /**
     * 功能描述：读取本地用户信息设置
     *
     * @param
     */
    public EntityUser getUserInfo(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_PRIVATE);
        EntityUser entityUser = new EntityUser();

        entityUser.setUserName(preferences.getString("userName", ""));
        entityUser.setUserId(preferences.getString("userId", ""));
        entityUser.setPassword(preferences.getString("password", ""));
        entityUser.setCtname(preferences.getString("ctname", ""));
        entityUser.setCarid(preferences.getString("carid", ""));
        entityUser.setUsertype(preferences.getString("usertype", ""));
        entityUser.setRoleId(preferences.getString("roleId", ""));
        entityUser.setSsxq(preferences.getString("ssxq", ""));
        entityUser.setZzjgmc(preferences.getString("zzjgmc", ""));
        entityUser.setPhone(preferences.getString("phone", ""));
        return entityUser;
    }


    /**
     * 保存ip
     *
     * @param @param act
     * @param @param ip
     * @param @param prot
     * @return void
     * @throws
     * @Method: com.zondy.xunjing.utils.SharedTool.saveIp
     * @Description: TODO
     */
    public void saveIp(Context act, String ip, String prot, String pushIp,
                       String pushPort) {

        SharedPreferences preferences = act.getSharedPreferences("Shared_File",
                Activity.MODE_MULTI_PROCESS);
        Editor editor = preferences.edit();
        editor.putString("ip", ip);
        editor.putString("port", prot);
        editor.putString("pushIp", pushIp);
        editor.putString("pushPort", pushPort);
        editor.commit();
    }

    /**
     * 获取IP和prot
     *
     * @param @param  context
     * @param @return
     * @return String
     * @throws
     * @Method: com.zondy.xunjing.utils.SharedTool.getIp
     * @Description: TODO
     */
    public String getIp(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(
                "Shared_File", Activity.MODE_MULTI_PROCESS);
        String ip = preferences.getString("ip", "");
        String port = preferences.getString("port", "");
        String pushIp = preferences.getString("pushIp", "");
        String pushPort = preferences.getString("pushPort", "");
        return ip + "_" + port + "_" + pushIp + "_" + pushPort;
    }

    /**
     * 保存采集方式，分为'GPS定位'和'地图选点'
     */
    public void saveCaijiType(Context act, String caijiType) {

        SharedPreferences preferences = act.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        Editor editor = preferences.edit();
        editor.putString("caijiType", caijiType);
        editor.commit();
    }

    /**
     * 获取采集方式
     */
    public String getCaijiType(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        String caijiType = preferences.getString("caijiType", "");
        return caijiType;
    }

    /**
     * 保存定位间隔方式：时间间隔，距离间隔，时间和距离间隔
     *
     * @param act
     * @param locationIntervalType
     */
    public void saveLocationIntervalType(Context act,
                                         String locationIntervalType) {

        SharedPreferences preferences = act.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        Editor editor = preferences.edit();
        editor.putString("locationIntervalType", locationIntervalType);
        editor.commit();
    }

    public String getLocationIntervalType(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        String locationIntervalType = preferences.getString(
                "locationIntervalType", "时间间隔");
        return locationIntervalType;
    }

    /**
     * 保存定位间隔
     */
    public void saveLocationInterval(Context act, long timeInterval,
                                     long distanceInterval) {

        SharedPreferences preferences = act.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        Editor editor = preferences.edit();
        editor.putLong("timeInterval", timeInterval);
        editor.putLong("distanceInterval", distanceInterval);
        editor.commit();
    }

    /**
     * 获取定位间隔,默认时间间隔30s,距离间隔10米
     */
    public Map<String, Long> getLocationInterval(Context context) {
        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        long timeInterval = preferences.getLong("timeInterval", 30);
        long distanceInterval = preferences.getLong("distanceInterval", 10);
        Map<String, Long> result = new HashMap<String, Long>();
        result.put("timeInterval", timeInterval);
        result.put("distanceInterval", distanceInterval);
        return result;
    }

    /**
     * 保存警员接警的警情id
     *
     * @param @param  context
     * @param @param  jingqId
     * @param @param  isArrive
     * @param @return
     * @return boolean
     * @throws
     * @Method: com.zondy.utils.SharedTool.saveJingqArrive
     * @Description: TODO
     */
    public boolean saveUnarriveJingqId(Context context, String jingqId) {

        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        Editor editor = preferences.edit();
        editor.putString("acceptJingqId", jingqId);
        return editor.commit();
    }


    /**
     * 清除接警的警情id
     *
     * @param @param  context
     * @param @param  jingqId
     * @param @return
     * @return boolean
     * @throws
     * @Method: com.zondy.utils.SharedTool.clearUnarriveJingqId
     * @Description: TODO
     */
    public boolean clearUnarriveJingqId(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        Editor editor = preferences.edit();
        editor.remove("acceptJingqId");
        return editor.commit();
    }

    /**
     * 获取接警后未到场的警情id
     *
     * @param @param  context
     * @param @return
     * @return String
     * @throws
     * @Method: com.zondy.utils.SharedTool.getUnarriveJingqId
     * @Description: TODO
     */
    public String getUnarriveJingqId(Context context) {

        SharedPreferences preferences = context.getSharedPreferences(
                USER_SHARED_FILE, Activity.MODE_MULTI_PROCESS);
        String acceptJingqId = preferences.getString("acceptJingqId", "");
        if (TextUtils.isEmpty(acceptJingqId)) {
            return null;
        } else {
            return acceptJingqId;
        }
    }
}
