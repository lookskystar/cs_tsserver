package com.ts.common.pojo;

import java.io.Serializable;

/**
 * 裂损配件记录表
 * @author Administrator
 *
 */
public class DecBadPJRec implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8513569652807108292L;
	
	private Long id;
	
	/**
	 * 对应的探伤记录ID
	 */
	private DecRecord decRecId;
	
    /**
     * 配件名称
     */
	private String pjName;
	
	/**
	 * 配件数量
	 */
	private Integer pjAmount;
	
	/**
	 * 配件编号
	 */
	private String pjNums;
	
	/**
	 * 配件压缩图片地址
	 */
	private String pjImageUrls;
	
	/**
	 * 配件大图片地址
	 */
	private String pjBigImageUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public DecRecord getDecRecId() {
		return decRecId;
	}

	public void setDecRecId(DecRecord decRecId) {
		this.decRecId = decRecId;
	}

	public String getPjName() {
		return pjName;
	}

	public void setPjName(String pjName) {
		this.pjName = pjName;
	}

	public Integer getPjAmount() {
		return pjAmount;
	}

	public void setPjAmount(Integer pjAmount) {
		this.pjAmount = pjAmount;
	}

	public String getPjNums() {
		return pjNums;
	}

	public void setPjNums(String pjNums) {
		this.pjNums = pjNums;
	}

	public String getPjImageUrls() {
		return pjImageUrls;
	}

	public void setPjImageUrls(String pjImageUrls) {
		this.pjImageUrls = pjImageUrls;
	}

	public String getPjBigImageUrl() {
		return pjBigImageUrl;
	}

	public void setPjBigImageUrl(String pjBigImageUrl) {
		this.pjBigImageUrl = pjBigImageUrl;
	}
}
