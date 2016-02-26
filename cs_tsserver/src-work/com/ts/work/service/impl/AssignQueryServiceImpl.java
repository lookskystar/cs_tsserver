package com.ts.work.service.impl;

import java.util.List;

import javax.annotation.Resource;


import com.ts.common.pojo.DecAtRecord;
import com.ts.work.dao.AssignQueryDao;
import com.ts.work.service.AssignQueryService;

public class AssignQueryServiceImpl implements AssignQueryService{
	
	@Resource(name="assignQueryDao")
	private AssignQueryDao assignQueryDao;

	public List<DecAtRecord> queryDecAtRecord(String beginTime, String endTime) {
		
		return assignQueryDao.queryDecAtRecord(beginTime, endTime);
	}

	public DecAtRecord getDecAtRecordById(long id) {
		return assignQueryDao.getDecAtRecordById(id);
	}
	
	
	
}
