package com.ts.common.util;

import java.util.List;
/**
 * �����ҳ����
 * @author Administrator
 *
 */
public class PageModel<T> {
	/**
	 * ��ѯ�����ļ�¼����
	 */
	private int count;
	/**
	 * ÿҳ��ʾ�����
	 */
	private List<T> datas;
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List<T> getDatas() {
		return datas;
	}
	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	
}
