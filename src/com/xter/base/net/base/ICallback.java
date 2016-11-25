package com.xter.base.net.base;

import java.util.List;

/**
 * 接收接口
 */
public interface ICallback<T> {
	void onReceive(T t);

	void onReceive(List<T> t);

	void onError(String error);
}
