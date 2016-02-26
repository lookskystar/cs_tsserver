package com.ts.common.pojo;

import java.io.Serializable;

/**
 * 探伤报活小组表
 */
public class DetecBaohuoTeam implements Serializable {

	private static final long serialVersionUID = -2426351765512552119L;
	
	/**
	 * 主键
	 */
	private Long id;
	/**
	 * 名称
	 */
	private String name;

	/**
	 * 班组ID
	 */
	private Long teamId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getTeamId() {
		return teamId;
	}

	public void setTeamId(Long teamId) {
		this.teamId = teamId;
	}
	
	

	
}
