package com.ts.common.pojo;

import java.io.Serializable;

public class DictJWD implements Serializable{

	private static final long serialVersionUID = -4811470506449833951L;

	private int id;
	
	/**
	 * 机务段代码
	 */
	private String jwdCode;
	
	/**
	 * 机务段名称
	 */
	private String jwdMC;
	
	/**
	 * 拼音
	 */
	private String py;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJwdCode() {
		return jwdCode;
	}

	public void setJwdCode(String jwdCode) {
		this.jwdCode = jwdCode;
	}

	public String getJwdMC() {
		return jwdMC;
	}

	public void setJwdMC(String jwdMC) {
		this.jwdMC = jwdMC;
	}

	public String getPy() {
		return py;
	}

	public void setPy(String py) {
		this.py = py;
	}
}
