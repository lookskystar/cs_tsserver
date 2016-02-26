package com.ts.server.service.impl;

import javax.annotation.Resource;

import com.ts.common.pojo.Users;
import com.ts.server.dao.UsersDao;
import com.ts.server.service.UsersService;

public class UsersServiceImpl implements UsersService{
	
	@Resource(name="usersDao")
	private UsersDao usersDao;
	
	public Users login(String username, String password) {
		return usersDao.login(username, password);
	}

	public Users login(String idkid) {
		return usersDao.login(idkid);
	}
	
	public void updateUser(Users user) {
		usersDao.updateUser(user);
		
	}
}
