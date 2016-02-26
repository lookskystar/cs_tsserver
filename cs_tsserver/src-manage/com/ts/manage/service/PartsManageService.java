package com.ts.manage.service;

import java.util.List;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecBaohuoUnit;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;

public interface PartsManageService {
	
	public PageModel<DetecBaohuoUnit> findDetecBaohuoUnitByCondition(String teamId, String name);
	
	public DetecBaohuoUnit findDetecBaohuoUnitById(Long id);
	
	public void saveOrUpdateParts(DetecBaohuoUnit detecBaohuoUnit);
	
	public void deleteParts(DetecBaohuoUnit detecBaohuoUnit);
	
	public void deleteParts(String[] partsIdArray);
	
	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam();
	
	public List<Users> findAllUsersInTsTeam();
}
