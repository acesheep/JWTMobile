package com.zondy.jwt.jwtmobile.util;

import android.app.Activity;
import android.content.Context;
import android.widget.Toast;

import com.zondy.jwt.jwtmobile.base.MyApplication;


public class ToastTool {

	private static ToastTool instance;

	public synchronized static ToastTool getInstance() {
		if (instance == null) {
			instance = new ToastTool();
		}
		return instance;
	}


	public void shortLength(Context context,String msg,boolean isProductEnvironmentShow){
		if(isProductEnvironmentShow){
			Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
		}else{
			if (!MyApplication.IS_PRODUCT_ENVIRONMENT) {
				Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
			}
		}
	}

	public void longLength(Context context, String msg,boolean isProductEnvironmentShow) {
		if(isProductEnvironmentShow){
			Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
		}else{
			if (!MyApplication.IS_PRODUCT_ENVIRONMENT) {
				Toast.makeText(context, msg, Toast.LENGTH_LONG).show();
			}
		}
	}

}
