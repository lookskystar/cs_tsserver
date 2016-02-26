package com.ts.common.pojo;

import java.io.Serializable;

public class DictArea implements Serializable{

	private static final long serialVersionUID = 2688982267675364322L;
	
	private int id;
	
	/**
	 * 区域ID
	 */
	private String areaId;
	
	/**
	 * 区域名字
	 */
	private String name;
	
	/**
	 * 机务段代码
	 */
	private String jwdCode;
	
	/**
	 * 机务段IP
	 */
	private String ip;
	
	/**
	 * 数据库名称
	 */
	private String dbName;
	
	/**
	 * 数据库登录名
	 */
	private String loginName;
	
	/**
	 * 数据库密码
	 */
	private String password;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAreaId() {
		return areaId;
	}

	public void setAreaId(String areaId) {
		this.areaId = areaId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getJwdCode() {
		return jwdCode;
	}

	public void setJwdCode(String jwdCode) {
		this.jwdCode = jwdCode;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getDbName() {
		return dbName;
	}

	public void setDbName(String dbName) {
		this.dbName = dbName;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
