package com.ts.common.pojo;

import java.io.Serializable;

public class DetecQuestion implements Serializable{

	private static final long serialVersionUID = 7104158540269923614L;
	
	private int id;
	
	/**
	 * 问题类型ID号  QID 1 -磁粉理论题2-超声波理题3 磁粉题4- 超声波工艺题
	 */
	private int qid;
	
	/**
	 * 问题正文
	 */
	private String text;
	
	/**
	 * 回答A
	 */
	private String answerA;
	
	/**
	 * 回答B
	 */
	private String answerB;
	
	/**
	 * 回答C
	 */
	private String answerC;
	
	/**
	 * 回答D
	 */
	private String answerD;
	
	/**
	 * 正确答案
	 */
	private int rightAnswer;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getQid() {
		return qid;
	}

	public void setQid(int qid) {
		this.qid = qid;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAnswerA() {
		return answerA;
	}

	public void setAnswerA(String answerA) {
		this.answerA = answerA;
	}

	public String getAnswerB() {
		return answerB;
	}

	public void setAnswerB(String answerB) {
		this.answerB = answerB;
	}

	public String getAnswerC() {
		return answerC;
	}

	public void setAnswerC(String answerC) {
		this.answerC = answerC;
	}

	public String getAnswerD() {
		return answerD;
	}

	public void setAnswerD(String answerD) {
		this.answerD = answerD;
	}

	public int getRightAnswer() {
		return rightAnswer;
	}

	public void setRightAnswer(int rightAnswer) {
		this.rightAnswer = rightAnswer;
	}
}
