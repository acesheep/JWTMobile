package com.zondy.jwt.jwtmobile.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.location.Location;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.zondy.jwt.jwtmobile.R;
import com.zondy.jwt.jwtmobile.entity.EntityUser;
import com.zondy.jwt.jwtmobile.manager.GPSLocationManager;
import com.zondy.jwt.jwtmobile.util.CommonUtil;
import com.zondy.jwt.jwtmobile.util.SharedTool;

import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;

/**
 * Created by sheep on 2017/1/18.
 */

public class GPSService extends Service {
    public final int SERVICE_ID = 110;
    public final static String SERVICE_REPEAT = "com.zondy.service.intent.action.ServiceRepeat";
    GPSLocationManager myLocationManager;
    static Context context;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

//    public void startRepeat() {
//        if (context == null) {
//            stopSelf();
//            return;
//        }
//        // 在API11之后构建Notification的方式,创建notification,用于前台服务
//        Notification.Builder builder = new Notification.Builder(context); // 获取一个Notification构造器
//        Intent nfIntent = ActMainWithGridview.createIntent(context);
//
//
//        builder.setContentIntent(
//                PendingIntent.getActivity(this, 0, nfIntent, 0))
//                // 设置PendingIntent
//                .setLargeIcon(
//                        BitmapFactory.decodeResource(this.getResources(),
//                                R.drawable.ic_launcher)) // 设置下拉列表中的图标(大图标)
//                .setContentTitle("移动处警平台") // 设置下拉列表里的标题
//                .setSmallIcon(R.drawable.ic_launcher) // 设置状态栏内的小图标
//                .setContentText("移动处警平台保持在后台运行") // 设置上下文内容
//                .setWhen(System.currentTimeMillis()); // 设置该通知发生的时间
//
//        Notification notification = builder.build(); // 获取构建好的Notification
//        notification.defaults = Notification.DEFAULT_SOUND; // 设置为默认的声音
//
//        Map<String, Long> locationIntervalMap = SharedTool.getInstance()
//                .getLocationInterval(context);
//        long timeInterval = locationIntervalMap.get("timeInterval");
//        float distanceInterval = Float.valueOf(locationIntervalMap
//                .get("distanceInterval"));
//        myLocationManager = GpsLocationManager.getInstance(context,
//                timeInterval, distanceInterval);
//        myLocationManager.startLocation();
//        if (timer == null) {
//            timer = new Timer();
//        }
//        timer.schedule(new TimerTask() {
//
//            @Override
//            public void run() {
//
//                // 上传定位信息
//                Location location = myLocationManager.getLocation();
//                if (location == null || location.getLongitude() <= 0
//                        || location.getLatitude() <= 0) {
//                    // 获取不到定位
//                } else {
//                    String deviceId = CommonUtil.getDeviceId(context);
//                    double longitude = location.getLongitude();
//                    double latitude = location.getLatitude();
//
//                    new TaskUploadGPS(context, deviceId, longitude, latitude,
//                            0, new TaskResultListener<Boolean>() {
//
//                        @Override
//                        public void onSuccess(Boolean t) {
//                            System.out.println("上传GPS成功");
//                        }
//
//                        @Override
//                        public void onFail(Exception e) {
//                            System.out.println("上传GPS失败");
//
//                        }
//                    }).isShowDialog(false, false).executeOnExecutor(
//                            Executors.newCachedThreadPool());
//                }
//
//                // 更新登陆后的在线时间
//                EntityUser userInfo = SharedTool.getInstance().getUserInfo(
//                        context);
//                String jh = userInfo.getUserName();
//                String simid = CommonUtil.getDeviceId(context);
//                if (!TextUtils.isEmpty(jh) && !TextUtils.isEmpty(simid)) {
//                    new TaskUploadDlxx(context, jh, simid,
//                            new TaskResultListener<Boolean>() {
//
//                                @Override
//                                public void onSuccess(Boolean t) {
//
//                                }
//
//                                @Override
//                                public void onFail(Exception e) {
//
//                                }
//                            }).isShowDialog(false, false).executeOnExecutor(
//                            Executors.newCachedThreadPool());
//                }
//            }
//        }, 0, repeatTime * 1000);
//
//        startForeground(SERVICE_ID, notification);// 开始前台服务
//    }
}
