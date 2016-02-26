package com.ts.work.service;

import java.util.List;

import com.ts.common.pojo.DecAtRecord;




/**
 * 信息查询
 */
public interface AssignQueryService {

	
	/**
	 * 根据条件查询派工记录
	 * @return
	 */
	public List<DecAtRecord> queryDecAtRecord(String beginTime,String endTime);
	
	/**
	 * 根据ID查询报活信息
	 */
	public DecAtRecord getDecAtRecordById(long id);

}
