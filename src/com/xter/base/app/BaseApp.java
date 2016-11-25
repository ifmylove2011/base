package com.xter.base.app;

import com.xter.base.util.L;

import android.app.Application;
import android.content.Context;


/**
 * 用静态内部类建单例，保证线程安全
 */
public class BaseApp extends Application {

	private static BaseApp instance;

	public static BaseApp getInstance() {
		return instance;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		instance = this;
		L.DEBUG = true;
	}

	public static Context getContext() {
		return instance.getApplicationContext();
	}

}
