package com.ts.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class DecAtRecord implements Serializable {

	private static final long serialVersionUID = -2282535664852095788L;

	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 报活修程
	 */
	private String atxc;

	/**
	 * 报活修次
	 */
	private String atxci;

	/**
	 *修程１
	 */
	private String xc1;

	/**
	 *修程２
	 */
	private String xc2;

	/**
	 *小组
	 */
	private String team;

	/**
	 *报活工人名字
	 */
	private String name;
	/**
	 *设备名
	 */
	private String unit;

	/**
	 *设备绑定工人名
	 */
	private String w1;

	/**
	 *设备绑定工人名
	 */
	private String w2;

	/**
	 *设备绑定工人名
	 */
	private String w3;

	/**
	 *设备绑定工人名
	 */
	private String w4;
	/**
	 *设备绑定工人名
	 */
	private String w5;

	/**
	 *设备绑定工人名
	 */
	private String w6;

	/**
	 *设备绑定工人名
	 */
	private String w7;
	/**
	 *设备绑定工人名
	 */
	private String w8;

	/**
	 *设备绑定工人名
	 */
	private String w9;

	/**
	 *设备绑定工人名
	 */
	private String w10;
	/**
	 *设备绑定工人名
	 */
	private String w11;

	/**
	 *设备绑定工人名
	 */
	private String w12;

	/**
	 *检验员
	 */
	private String t1;
	/**
	 *质检员
	 */
	private String q1;

	/**
	 *机车类型
	 */
	private String jcType;

	/**
	 *机车编号
	 */
	private String jcNumber;

	/**
	 *设备数量
	 */
	private Integer unitNumber;

	/**
	 *设备编号　逗号分隔
	 */
	private String unitNumberText;

	/**
	 *报活时间
	 */
	private String atTime;

	/**
	 *状态位
	 */
	private Integer status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAtxc() {
		return atxc;
	}

	public void setAtxc(String atxc) {
		this.atxc = atxc;
	}

	public String getAtxci() {
		return atxci;
	}

	public void setAtxci(String atxci) {
		this.atxci = atxci;
	}

	public String getXc1() {
		return xc1;
	}

	public void setXc1(String xc1) {
		this.xc1 = xc1;
	}

	public String getXc2() {
		return xc2;
	}

	public void setXc2(String xc2) {
		this.xc2 = xc2;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getW1() {
		return w1;
	}

	public void setW1(String w1) {
		this.w1 = w1;
	}

	public String getW2() {
		return w2;
	}

	public void setW2(String w2) {
		this.w2 = w2;
	}

	public String getW3() {
		return w3;
	}

	public void setW3(String w3) {
		this.w3 = w3;
	}

	public String getW4() {
		return w4;
	}

	public void setW4(String w4) {
		this.w4 = w4;
	}

	public String getW5() {
		return w5;
	}

	public void setW5(String w5) {
		this.w5 = w5;
	}

	public String getW6() {
		return w6;
	}

	public void setW6(String w6) {
		this.w6 = w6;
	}

	public String getW7() {
		return w7;
	}

	public void setW7(String w7) {
		this.w7 = w7;
	}

	public String getW8() {
		return w8;
	}

	public void setW8(String w8) {
		this.w8 = w8;
	}

	public String getW9() {
		return w9;
	}

	public void setW9(String w9) {
		this.w9 = w9;
	}

	public String getW10() {
		return w10;
	}

	public void setW10(String w10) {
		this.w10 = w10;
	}

	public String getW11() {
		return w11;
	}

	public void setW11(String w11) {
		this.w11 = w11;
	}

	public String getW12() {
		return w12;
	}

	public void setW12(String w12) {
		this.w12 = w12;
	}

	public String getT1() {
		return t1;
	}

	public void setT1(String t1) {
		this.t1 = t1;
	}

	public String getQ1() {
		return q1;
	}

	public void setQ1(String q1) {
		this.q1 = q1;
	}

	public String getJcType() {
		return jcType;
	}

	public void setJcType(String jcType) {
		this.jcType = jcType;
	}

	public String getJcNumber() {
		return jcNumber;
	}

	public void setJcNumber(String jcNumber) {
		this.jcNumber = jcNumber;
	}

	public Integer getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(Integer unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getUnitNumberText() {
		return unitNumberText;
	}

	public void setUnitNumberText(String unitNumberText) {
		this.unitNumberText = unitNumberText;
	}


	public String getAtTime() {
		return atTime;
	}

	public void setAtTime(String atTime) {
		this.atTime = atTime;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

}
