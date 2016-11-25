package com.xter.base.net.base;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.xter.base.bean.Header;

/**
 * 基类
 */
public abstract class BaseJsonRequest<T> extends BaseRequest<T> {
	public BaseJsonRequest(ICallback<T> callback) {
		super(callback);
	}

	@Override
	public String getRequestText() throws JSONException {
		Header header = createRequestHeader();
		JSONObject serviceContent = createRequestBody();
		JSONObject jsonObj = new JSONObject();

		jsonObj.put("serviceContent", serviceContent);

		// jsonObj.put("origDomain", header.getOrigDomain());

		return "$data=" + jsonObj.toString();
	}
}
