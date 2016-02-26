package com.ts.server.service;

import com.ts.common.pojo.Users;

public interface UsersService {
	
	/**
	 * 用户登录
	 * @param username 用户名
	 * @param password 密码
	 * @return
	 */
	Users login(String username, String password);
	
	/**
	 * 用户刷卡登录
	 * @param idkid 卡号
	 * @return
	 */
	Users login(String idkid);
	
	/**
	 * 修改密码
	 */
	public void updateUser(Users user);
}
