package com.ts.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecBaohuoUnit;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;
import com.ts.manage.dao.PartsManageDao;
import com.ts.manage.service.PartsManageService;

public class PartsManageServiceImpl implements PartsManageService {
	@Resource(name="partManageDao")
	private PartsManageDao partsManageDao;

	public void deleteParts(DetecBaohuoUnit detecBaohuoUnit) {
		partsManageDao.deleteParts(detecBaohuoUnit);
	}

	public void deleteParts(String[] partsIdArray) {
		partsManageDao.deleteParts((Long[])ConvertUtils.convert(partsIdArray, Long.class));
	}

	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam() {
		return partsManageDao.findAllDetecBaohuoTeam();
	}

	public PageModel<DetecBaohuoUnit> findDetecBaohuoUnitByCondition(
			String teamId, String name) {
		return partsManageDao.findDetecBaohuoUnitByCondition(teamId, name);
	}

	public DetecBaohuoUnit findDetecBaohuoUnitById(Long id) {
		return partsManageDao.findDetecBaohuoUnitById(id);
	}

	public void saveOrUpdateParts(DetecBaohuoUnit detecBaohuoUnit) {
		partsManageDao.saveOrUpdateParts(detecBaohuoUnit);
	}

	public List<Users> findAllUsersInTsTeam() {
		return partsManageDao.findAllUsersInTsTeam();
	}

	

}
