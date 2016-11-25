package com.xter.base.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * 基类
 */
public abstract class BaseFragment extends Fragment {

	Unbinder unbinder;

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
			@Nullable Bundle savedInstanceState) {
		View rootView = inflate(inflater, container);
		unbinder = ButterKnife.bind(this, rootView);
		initData();
		return rootView;
	}

	/**
	 * 构建视图
	 *
	 * @param inflater
	 *            视图渲染器
	 * @param container
	 *            视图容器
	 * @return 视图
	 */
	public abstract View inflate(LayoutInflater inflater, ViewGroup container);

	/**
	 * 初始化数据
	 */
	public abstract void initData();

	@Override
	public void onDestroyView() {
		super.onDestroyView();
		unbinder.unbind();
	}
}
