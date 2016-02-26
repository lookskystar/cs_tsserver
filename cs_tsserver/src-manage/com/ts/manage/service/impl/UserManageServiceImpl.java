/**
 * 
 */
package com.ts.manage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.sun.org.apache.commons.beanutils.ConvertUtils;
import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecPosition;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;
import com.ts.manage.dao.UserManageDao;
import com.ts.manage.service.UserManageService;

/**
 * @author eleven
 *
 */
public class UserManageServiceImpl implements UserManageService{

	@Resource(name="userManageDao")
	private UserManageDao userManageDao;

	public void deleteUsers(Users users) {
		userManageDao.deleteUsers(users);
	}

	public void deleteUsers(String[] userIdArray) {
		userManageDao.deleteUsers((Integer[])ConvertUtils.convert(userIdArray, Integer.class));
		
	}

	public PageModel<Users> findDetecUsersByCondition(String teamId,
			String gonghao, String name) {
		return userManageDao.findDetecUsersByCondition(teamId, gonghao, name);
	}

	public Users findUsersById(Integer id) {
		return userManageDao.findUsersById(id);
	}

	public void saveOrUpdateUsers(Users users) {
		userManageDao.saveOrUpdateUsers(users);
	}

	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam() {
		return userManageDao.findAllDetecBaohuoTeam();
	}

	public List<DetecPosition> findAllDetecPosition() {
		return userManageDao.findAllDetecPosition();
	}
	
	
	

}
