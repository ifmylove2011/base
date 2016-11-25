package com.xter.base.db;

import com.litesuits.orm.LiteOrm;
import com.xter.base.app.BaseApp;
import com.xter.base.constant.LocalConstant;

/**
 * 数据库管理 --DataBaseManager
 */
public class DBM {

	private static LiteOrm liteOrmDefault;

	/**
	 * 获取默认的orm
	 *
	 * @return DefaultOrm
	 */
	public static LiteOrm getDefaultOrm() {
		if (liteOrmDefault == null) {
			liteOrmDefault = LiteOrm.newSingleInstance(BaseApp.getContext(), LocalConstant.DB_DEFAULT_NAME);
		}
		return liteOrmDefault;
	}
}
