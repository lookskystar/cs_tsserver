package com.ts.common.pojo;

import java.io.Serializable;

public class Users implements Serializable{

	private static final long serialVersionUID = -403012597044130419L;
	
	/**
	 * 主键
	 */
	private int userId;
	
	/**
	 * 机务段代码
	 */
	private String jwdCode;
	
	/**
	 * 地区ID
	 */
	private String areaCode;
	
	/**
	 * 班组
	 */
	private int teamId;
	
	/**
	 * 工号
	 */
	private String gongHao;
	
	/**
	 * 姓名
	 */
	private String xm;
	
	/**
	 * 密码
	 */
	private String pw;
	
	/**
	 * 卡号
	 */
	private String jdkId;
	
	/**
	 * 职务ID
	 */
	private int posId;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getJwdCode() {
		return jwdCode;
	}

	public void setJwdCode(String jwdCode) {
		this.jwdCode = jwdCode;
	}

	public String getAreaCode() {
		return areaCode;
	}

	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}

	public int getTeamId() {
		return teamId;
	}

	public void setTeamId(int teamId) {
		this.teamId = teamId;
	}

	public String getGongHao() {
		return gongHao;
	}

	public void setGongHao(String gongHao) {
		this.gongHao = gongHao;
	}

	public String getXm() {
		return xm;
	}

	public void setXm(String xm) {
		this.xm = xm;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getJdkId() {
		return jdkId;
	}

	public void setJdkId(String jdkId) {
		this.jdkId = jdkId;
	}

	public int getPosId() {
		return posId;
	}

	public void setPosId(int posId) {
		this.posId = posId;
	}
}
