package com.zondy.jwt.jwtmobile.manager;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

import com.zondy.jwt.jwtmobile.util.SharedTool;
import com.zondy.jwt.jwtmobile.util.ToastTool;

import static android.content.ContentValues.TAG;

/**
 * Created by sheep on 2017/1/18.
 */

public class GPSLocationManager {
    LocationManager manager;
    private static Context context;
    private static long timeInterval = 30;
    private static float distanceInterval = 10;//单位m
    private static GPSLocationManager gpsLocationManager;//单例
    private  MyLocationListener listener=new MyLocationListener();

    //私有化构造方法
    private GPSLocationManager() {

    }

    public static synchronized GPSLocationManager getInstance(Context context, long timeInterval, float distanceInterval) {
        if (gpsLocationManager == null) {
            gpsLocationManager = new GPSLocationManager();
            GPSLocationManager.context = context;
            GPSLocationManager.timeInterval = timeInterval;
            GPSLocationManager.distanceInterval = distanceInterval;
        }
        return gpsLocationManager;
    }

    // 获取gps 信息
    public void startLocation() {
        // 获取与位置相关的服务 服务都是通过上下文获取出来的
        manager = (LocationManager) context
                .getSystemService(Context.LOCATION_SERVICE);
        // 获取所有的定位方式
        // manager.getAllProviders(); // gps //wifi //
        // 选择一种目前状态下最好的定位方式
        String provider = getProvider(manager);
        // 注册位置的监听器
        /**
         * provider 定位方式 用什么设备定位 基站 网络 GPS AGPS 时间 gps 多长时间重新获取一下位置 最小为1分钟 位置
         * 最短位移 位置改变多少 重新获取一下位置 listener 位置发生改变时 对应的回调方法
         */
        manager.requestLocationUpdates(provider, timeInterval * 1000,
                distanceInterval, getListener());
    }

    private class MyLocationListener implements LocationListener {
        /**
         * 当手机位置发生改变的时候 调用的方法
         */
        @Override
        public void onLocationChanged(Location location) {
//            ToastTool.getInstance().shortLength(context,"定位经度："+location.getLongitude()+"--定位纬度："+location.getLatitude(),true);
            if (location != null && location.getLongitude() > 0
                    && location.getLatitude() > 0) {
                SharedTool.getInstance().saveLastLocation(context, location.getLongitude(), location.getLatitude());
            }
        }

        /**
         * 某一个设备的状态发生改变的时候 调用 可用->不可用 不可用->可用 GPS是否可用
         */
        @Override
        public void onStatusChanged(String provider, int status, Bundle extras) {

        }

        /**
         * 某个设备被打开 GPS被打开
         */
        @Override
        public void onProviderEnabled(String provider) {

        }

        /**
         * 某个设备被禁用 GPS被禁用
         */
        @Override
        public void onProviderDisabled(String provider) {

        }
    }

    /**
     * @param manager 位置管理服务
     * @return 最好的位置提供者 // gps //wifi //
     */
    private String getProvider(LocationManager manager) {
        // 一组查询条件
        Criteria criteria = new Criteria();
        criteria.setAccuracy(Criteria.ACCURACY_FINE); // 获取精准位置、
        criteria.setAltitudeRequired(false);// 对海拔不敏感
        criteria.setPowerRequirement(Criteria.POWER_MEDIUM);// 耗电量中等
        criteria.setSpeedRequired(true);// 速度变化敏感
        criteria.setCostAllowed(true);// 产生开销 通信费用
        // 返回最好的位置提供者 true 表示只返回当前已经打开的定位设备
        return manager.getBestProvider(criteria, true);
    }

    // 返回Listener实例
    private synchronized MyLocationListener getListener() {
        if (listener == null) {
            listener = new MyLocationListener();
        }
        return listener;
    }

    // 停止gps监听
    public void stopGPSListener() {
        // 参数为LocationListener
        if (manager != null) {
            manager.removeUpdates(getListener());
            manager = null;
        }
    }
}
