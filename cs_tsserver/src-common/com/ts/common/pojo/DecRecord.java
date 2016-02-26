package com.ts.common.pojo;

import java.io.Serializable;
import java.util.Date;

public class DecRecord implements Serializable {

	private static final long serialVersionUID = 5288994457621139425L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 机车类型
	 */
	private String jcType;

	/**
	 * 机车编号
	 */
	private String jcNumber;

	/**
	 *修程
	 */
	private String xc;

	/**
	 *修次
	 */
	private String xci;

	/**
	 *设备名称
	 */
	private String unitName;

	/**
	 *设备数量
	 */
	private String unitNumber;
	/**
	 *设备编号，用，分割
	 */
	private String unitNotext;

	/**
	 *检查结果
	 */
	private String atResult;

	/**
	 *实验结果
	 */
	private String operResult;

	/**
	 *设备名称１
	 */
	private String u1;

	/**
	 *设备编号１
	 */
	private String un1;
	/**
	 *
	 */
	private String ui1;
	

	/**
	 *
	 */
	private String u2;

	/**
	 *
	 */
	private String un2;
	/**
	 *
	 */
	private String ui2;
	

	/**
	 *
	 */
	private String u3;

	/**
	 *
	 */
	private String un3;
	/**
	 *
	 */
	private String ui3;
	

	/**
	 *
	 */
	private String u4;

	/**
	 *
	 */
	private String un4;
	/**
	 *
	 */
	private String ui4;
	
	/**
	 *
	 */
	private String u5;

	/**
	 *
	 */
	private String un5;
	/**
	 *
	 */
	private String ui5;
	
	/**
	 *
	 */
	private String u6;

	/**
	 *
	 */
	private String un6;
	/**
	 *
	 */
	private String ui6;
	

	/**
	 *
	 */
	private String u7;

	/**
	 *
	 */
	private String un7;
	/**
	 *
	 */
	private String ui7;
	

	/**
	 *
	 */
	private String u8;

	/**
	 *
	 */
	private String un8;
	/**
	 *
	 */
	private String ui8;
	
	/**
	 *
	 */
	private String u9;

	/**
	 *
	 */
	private String un9;
	/**
	 *
	 */
	private String ui9;
	
	/**
	 *
	 */
	private String u10;

	/**
	 *
	 */
	private String un10;
	/**
	 *
	 */
	private String ui10;
	

	/**
	 *实验方法
	 */
	private String tway;
	/**
	 *主探
	 */
	private String mainName;

	/**
	 *复探
	 */
	private String secondName;
	/**
	 *报活时间
	 */
	private String atTime;

	/**
	 *测试人员
	 */
	private String t1;
	/**
	 *质检人员
	 */
	private String q1;

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

	public String getXc() {
		return xc;
	}

	public void setXc(String xc) {
		this.xc = xc;
	}

	public String getXci() {
		return xci;
	}

	public void setXci(String xci) {
		this.xci = xci;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getUnitNumber() {
		return unitNumber;
	}

	public void setUnitNumber(String unitNumber) {
		this.unitNumber = unitNumber;
	}

	public String getUnitNotext() {
		return unitNotext;
	}

	public void setUnitNotext(String unitNotext) {
		this.unitNotext = unitNotext;
	}

	public String getAtResult() {
		return atResult;
	}

	public void setAtResult(String atResult) {
		this.atResult = atResult;
	}

	public String getOperResult() {
		return operResult;
	}

	public void setOperResult(String operResult) {
		this.operResult = operResult;
	}

	public String getU1() {
		return u1;
	}

	public void setU1(String u1) {
		this.u1 = u1;
	}

	public String getUn1() {
		return un1;
	}

	public void setUn1(String un1) {
		this.un1 = un1;
	}

	public String getUi1() {
		return ui1;
	}

	public void setUi1(String ui1) {
		this.ui1 = ui1;
	}

	public String getU2() {
		return u2;
	}

	public void setU2(String u2) {
		this.u2 = u2;
	}

	public String getUn2() {
		return un2;
	}

	public void setUn2(String un2) {
		this.un2 = un2;
	}

	public String getUi2() {
		return ui2;
	}

	public void setUi2(String ui2) {
		this.ui2 = ui2;
	}

	public String getU3() {
		return u3;
	}

	public void setU3(String u3) {
		this.u3 = u3;
	}

	public String getUn3() {
		return un3;
	}

	public void setUn3(String un3) {
		this.un3 = un3;
	}

	public String getUi3() {
		return ui3;
	}

	public void setUi3(String ui3) {
		this.ui3 = ui3;
	}

	public String getU4() {
		return u4;
	}

	public void setU4(String u4) {
		this.u4 = u4;
	}

	public String getUn4() {
		return un4;
	}

	public void setUn4(String un4) {
		this.un4 = un4;
	}

	public String getUi4() {
		return ui4;
	}

	public void setUi4(String ui4) {
		this.ui4 = ui4;
	}

	public String getU5() {
		return u5;
	}

	public void setU5(String u5) {
		this.u5 = u5;
	}

	public String getUn5() {
		return un5;
	}

	public void setUn5(String un5) {
		this.un5 = un5;
	}

	public String getUi5() {
		return ui5;
	}

	public void setUi5(String ui5) {
		this.ui5 = ui5;
	}

	public String getU6() {
		return u6;
	}

	public void setU6(String u6) {
		this.u6 = u6;
	}

	public String getUn6() {
		return un6;
	}

	public void setUn6(String un6) {
		this.un6 = un6;
	}

	public String getUi6() {
		return ui6;
	}

	public void setUi6(String ui6) {
		this.ui6 = ui6;
	}

	public String getU7() {
		return u7;
	}

	public void setU7(String u7) {
		this.u7 = u7;
	}

	public String getUn7() {
		return un7;
	}

	public void setUn7(String un7) {
		this.un7 = un7;
	}

	public String getUi7() {
		return ui7;
	}

	public void setUi7(String ui7) {
		this.ui7 = ui7;
	}

	public String getU8() {
		return u8;
	}

	public void setU8(String u8) {
		this.u8 = u8;
	}

	public String getUn8() {
		return un8;
	}

	public void setUn8(String un8) {
		this.un8 = un8;
	}

	public String getUi8() {
		return ui8;
	}

	public void setUi8(String ui8) {
		this.ui8 = ui8;
	}

	public String getU9() {
		return u9;
	}

	public void setU9(String u9) {
		this.u9 = u9;
	}

	public String getUn9() {
		return un9;
	}

	public void setUn9(String un9) {
		this.un9 = un9;
	}

	public String getUi9() {
		return ui9;
	}

	public void setUi9(String ui9) {
		this.ui9 = ui9;
	}

	public String getU10() {
		return u10;
	}

	public void setU10(String u10) {
		this.u10 = u10;
	}

	public String getUn10() {
		return un10;
	}

	public void setUn10(String un10) {
		this.un10 = un10;
	}

	public String getUi10() {
		return ui10;
	}

	public void setUi10(String ui10) {
		this.ui10 = ui10;
	}

	public String getTway() {
		return tway;
	}

	public void setTway(String tway) {
		this.tway = tway;
	}

	public String getMainName() {
		return mainName;
	}

	public void setMainName(String mainName) {
		this.mainName = mainName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getAtTime() {
		return atTime;
	}

	public void setAtTime(String atTime) {
		this.atTime = atTime;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
}
