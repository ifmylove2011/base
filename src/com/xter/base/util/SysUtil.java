package com.xter.base.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * 系统相关
 */
public class SysUtil {

	/**
	 * 得到当前时间
	 *
	 * @return 时间--格式为"2015-01-01 12:00:00"
	 */
	public static String getNow() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		return sdf.format(d);
	}

	/**
	 * 得到当前时间
	 *
	 * @return 时间--格式为"20150101120000"
	 */
	public static String getNow2() {
		Date d = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss", Locale.CHINA);
		return sdf.format(d);
	}

	/**
	 * 得到转换时间
	 *
	 * @param time 系统当前时间
	 * @return 时间--格式为"2015-01-01 12:00:00"
	 */
	public static String getTime(long time) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
		return sdf.format(time);
	}

	/**
	 * 隐藏系统UI
	 *
	 * @param view 当前顶层视图--一般指decorview
	 */
	@SuppressLint("NewApi")
	public static void hideSystemUI(View view) {
		view.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
				| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
				| View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
				| View.SYSTEM_UI_FLAG_FULLSCREEN
				| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
	}

	/**
	 * 显示系统UI
	 *
	 * @param view 当前顶层视图--一般指decorview
	 */
	@SuppressLint("NewApi")
	public static void showSystemUI(View view) {
		view.setSystemUiVisibility(
				View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
	}

	/* 获得状态栏高度 */
	public static int getStatusBarHeight(Context context) {
		int result = 0;
		int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen", "android");
		if (resourceId > 0) {
			result = context.getResources().getDimensionPixelSize(resourceId);
		}
		return result;
	}

	/* 获取操作拦高度 */
	public static int getActionBarHeight(Context context) {
		int actionBarHeight = 0;
		TypedValue tv = new TypedValue();
		if (context.getTheme().resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
			actionBarHeight = TypedValue.complexToDimensionPixelSize(tv.data, context.getResources().getDisplayMetrics());
		}
		return actionBarHeight;
	}

	/* 得到系统栏高度 */
	public static int getSystemBarHeight(Context context) {
		return getActionBarHeight(context) + getStatusBarHeight(context);
	}

	/* 得到系统栏（包括状态栏和操作栏）参数 */
	public static LinearLayout.LayoutParams getSystemBarParam(Context context) {
		int occupyHeight = getActionBarHeight(context) + getStatusBarHeight(context);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, occupyHeight);
		return layoutParams;
	}

}
