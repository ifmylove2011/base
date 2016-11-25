package com.xter.base.net.base;

import java.util.List;

/**
 * 基类
 */
public abstract class Callback<T> implements ICallback<T> {
	@Override
	public void onReceive(T t) {

	}

	@Override
	public void onReceive(List<T> t) {

	}
}
