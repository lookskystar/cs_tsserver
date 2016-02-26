package com.ts.common.pojo;

import java.io.Serializable;

public class DictJcType implements Serializable{

	private static final long serialVersionUID = 4675195299578021036L;
	
	/**
	 * ID号
	 */
	private int id;
	
	/**
	 * 机车类型名称
	 */
	private String jcTypeEvalue;
	
	/**
	 * 机车类型ID
	 */
	private int jcTypeId;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJcTypeEvalue() {
		return jcTypeEvalue;
	}

	public void setJcTypeEvalue(String jcTypeEvalue) {
		this.jcTypeEvalue = jcTypeEvalue;
	}

	public int getJcTypeId() {
		return jcTypeId;
	}

	public void setJcTypeId(int jcTypeId) {
		this.jcTypeId = jcTypeId;
	}
}	
