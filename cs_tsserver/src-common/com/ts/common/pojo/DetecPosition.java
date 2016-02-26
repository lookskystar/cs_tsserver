package com.ts.common.pojo;

import java.io.Serializable;
/**
 * 探伤职位表
 * @author Administrator
 *
 */
public class DetecPosition implements Serializable{

	private static final long serialVersionUID = 7104158540269923614L;
	
	private int id;
	
	/**
	 * 职位ID号
	 */
	private int posId;
	
	/**
	 * 职位名字
	 */
	private String posValue;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}

	public String getPosValue() {
		return posValue;
	}

	public void setPosValue(String posValue) {
		this.posValue = posValue;
	}
}
