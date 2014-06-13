package com.suo.image;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import android.app.Application;
import android.content.Context;

public class TestApplication extends Application {

	public static final String TAG = "TestApplication"; 

	public static Context mContext;
	
	public static Context getAppContext(){
		return mContext;
	}
	

	@Override
	public void onCreate() {
		super.onCreate();
		mContext = this.getApplicationContext();
//		ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext()).build();
//		ImageLoader.getInstance().init(config);
	}

	
}
