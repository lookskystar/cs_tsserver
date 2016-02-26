package com.ts.common.pojo;

import java.io.Serializable;

public class DictFixNum implements Serializable{

	private static final long serialVersionUID = 3051696397287552063L;
	
	private int id;
	
	/**
	 * 机车修程名称
	 */
	private String jxFixValue;
	
	/**
	 * 机车修程ID
	 */
	private int jxFixId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJxFixValue() {
		return jxFixValue;
	}

	public void setJxFixValue(String jxFixValue) {
		this.jxFixValue = jxFixValue;
	}

	public int getJxFixId() {
		return jxFixId;
	}

	public void setJxFixId(int jxFixId) {
		this.jxFixId = jxFixId;
	}
}
