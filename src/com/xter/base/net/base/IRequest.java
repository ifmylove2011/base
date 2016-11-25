package com.xter.base.net.base;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

/**
 * 请求接口
 */
public interface IRequest {
	String getRequestText() throws JSONException;

	void onResponse(JSONObject response) throws JSONException;

	void onError(String error);
}
