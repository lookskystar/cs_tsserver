package com.ts.work.dao;

import java.util.List;

import com.ts.common.pojo.DecAtRecord;
import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.Users;




/**
 * 探伤任务
 */
public interface TsAssignDao {

	
	/**
	 * 根据条件查询报活记录
	 * @return
	 */
	public List<DecAtRecord> findDecAtRecord(String beginTime,String endTime);
	
	/**
	 * 查询探伤组人员信息
	 */
	public List<Users> listUsers();
	
	/**
	 * 查询考试合格的探伤组人员信息
	 */
	public List<Users> listExamUsers(String beginTime,String endTime);
	
	
	/**
	 * 查询所有班组
	 */
	public List<DetecBaohuoTeam> listTeam();
	
	/**
	 * 根据ID查询报活信息
	 */
	public DecAtRecord getDecAtRecordById(long id);
	
	/**
	 * 派工成功,更改记录表
	 */
	public void updateDecAtRecord(DecAtRecord decatrecord);
	

}
