package com.ts.work.service;

import java.util.Date;
import java.util.List;

import com.ts.common.pojo.DecAtRecord;
import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;




/**
 * 探伤任务
 */
public interface TsAssignService {

	
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
	 * 查询班组信息
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
