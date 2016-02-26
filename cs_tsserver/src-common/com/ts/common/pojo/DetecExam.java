package com.ts.common.pojo;

import java.io.Serializable;

public class DetecExam implements Serializable{

	private static final long serialVersionUID = -7542778765860902393L;
	
	private int id;
	/**
	 * 工号
	 */
	private String gongHao;
	/**
	 * 考试时间
	 */
	private String examTime;
	/**
	 * 成绩
	 */
	private int grade;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGongHao() {
		return gongHao;
	}
	public void setGongHao(String gongHao) {
		this.gongHao = gongHao;
	}
	public String getExamTime() {
		return examTime;
	}
	public void setExamTime(String examTime) {
		this.examTime = examTime;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
}
