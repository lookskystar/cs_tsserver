package com.ts.work.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.ts.common.pojo.DecAtRecord;
import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;
import com.ts.work.dao.TsAssignDao;
import com.ts.work.service.TsAssignService;

public class TsAssignServiceImpl implements TsAssignService{
	
	@Resource(name="tsAssignDao")
	private TsAssignDao tsAssignDao;

	public List<DecAtRecord> findDecAtRecord(
			String beginTime, String endTime) {
		return tsAssignDao.findDecAtRecord(beginTime, endTime);
	}

	public List<Users> listUsers() {
		return tsAssignDao.listUsers();
	}

	public List<DetecBaohuoTeam> listTeam() {
		return tsAssignDao.listTeam();
	}

	public DecAtRecord getDecAtRecordById(long id) {
		return tsAssignDao.getDecAtRecordById(id);
	}

	public void updateDecAtRecord(DecAtRecord decatrecord) {
		tsAssignDao.updateDecAtRecord(decatrecord);
		
	}

	public List<Users> listExamUsers(String beginTime, String endTime) {
		return tsAssignDao.listExamUsers(beginTime, endTime);
	}

	
}
