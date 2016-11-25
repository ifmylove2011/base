package com.xter.base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * @param <T>
 * @see QuickAdapter 快速使用基类
 */
public abstract class QuickAdapter<T> extends BaseAdapter {

	/**
	 * 上下文
	 */
	protected Context mContext;
	/**
	 * 数据源
	 */
	protected List<T> mData;
	/**
	 * 布局资源文件
	 */
	protected int mRes;

	public QuickAdapter(Context context, int res, List<T> data) {
		this.mContext = context;
		this.mData = data == null ? new ArrayList<T>() : data;
		this.mRes = res;
	}

	@Override
	public int getCount() {
		return mData.size();
	}

	@Override
	public Object getItem(int position) {
		if (position >= mData.size()) {
			return null;
		}
		return mData.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	/**
	 * 使用该getItemView方法替换原来的getView方法，需要子类实现
	 *
	 * @param position    位置索引
	 * @param convertView 子视图
	 * @param holder      视图持有
	 * @return 子视图
	 */
	public abstract View getItemView(int position, View convertView, ViewHolder holder);

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		if (null == convertView) {
			convertView = View.inflate(mContext, mRes, null);
			holder = new ViewHolder(convertView);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}
		return getItemView(position, convertView, holder);
	}

	public void addAll(List<T> elem) {
		mData.addAll(elem);
		notifyDataSetChanged();
	}

	public void remove(T elem) {
		mData.remove(elem);
		notifyDataSetChanged();
	}

	public void remove(int index) {
		mData.remove(index);
		notifyDataSetChanged();
	}

	public void replaceAll(List<T> elem) {
		if (elem == null) {
			mData.clear();
			notifyDataSetChanged();
			return;
		}
		mData.clear();
		mData.addAll(elem);
		notifyDataSetChanged();
	}

	/**
	 * 视图控制持有
	 */
	static class ViewHolder {
		private SparseArray<View> views = new SparseArray<View>();
		private View convertView;

		public ViewHolder(View convertView) {
			this.convertView = convertView;
		}

		@SuppressWarnings("unchecked")
		public <T extends View> T getView(int resId) {
			View v = views.get(resId);
			if (null == v) {
				v = convertView.findViewById(resId);
				views.put(resId, v);
			}
			return (T) v;
		}
	}
}