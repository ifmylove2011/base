package com.xter.base.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基类
 */
public abstract class BaseActivity extends Activity {

	Unbinder unbinder;
	
	@Override
	protected void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView();
		unbinder = ButterKnife.bind(this);
		initData();
	}

	/**
	 * 设置视图
	 */
	protected abstract void setContentView();

	/**
	 * 初始化数据
	 */
	protected abstract void initData();
	
	@Override
	protected void onDestroy() {
		super.onDestroy();
		unbinder.unbind();
	}

}