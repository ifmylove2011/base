package com.xter.base.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

/**
 * Toast工具类
 */
public class ToastUtil {

	private static Toast mToast;
	private static Handler mHandler = new Handler(Looper.getMainLooper());

	/**
	 * 短时间显示Toast
	 *
	 * @param context 上下文
	 * @param message 消息内容
	 */
	public static void showShort(final Context context, final CharSequence message) {
		mHandler.post(new Runnable() {
			@Override
			public synchronized void run() {
				if (null == mToast) {
					mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
				} else {
					mToast.setText(message);
				}
				mToast.show();
			}
		});
	}

	/**
	 * 短时间显示Toast
	 *
	 * @param context 上下文
	 * @param message 消息内容ID
	 */
	public static void showShort(final Context context, final int message) {
		mHandler.post(new Runnable() {
			@Override
			public synchronized void run() {
				if (null == mToast) {
					mToast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
				} else {
					mToast.setText(message);
				}
				mToast.show();
			}
		});

	}

	/**
	 * 长时间显示Toast
	 *
	 * @param context 上下文
	 * @param message 消息内容
	 */
	public static void showLong(final Context context, final CharSequence message) {
		mHandler.post(new Runnable() {
			@Override
			public synchronized void run() {
				if (null == mToast) {
					mToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
				} else {
					mToast.setText(message);
				}
				mToast.show();
			}
		});

	}

	/**
	 * 长时间显示Toast
	 *
	 * @param context 上下文
	 * @param message 消息内容ID
	 */
	public static void showLong(final Context context, final int message) {
		mHandler.post(new Runnable() {
			@Override
			public synchronized void run() {
				if (null == mToast) {
					mToast = Toast.makeText(context, message, Toast.LENGTH_LONG);
				} else {
					mToast.setText(message);
				}
				mToast.show();
			}
		});
	}
}
