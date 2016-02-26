package com.ts.manage.dao;

import java.util.List;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecPosition;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;

public interface UserManageDao {
	
	/**
	 * 分页查询用户
	 * @param type
	 * @param keys
	 * @return
	 */
	public PageModel<Users> findDetecUsersByCondition(String teamId, String gonghao, String name);
	
	/**
	 * 查询用户
	 * @param id
	 * @return
	 */
	public Users findUsersById(Integer id);
	
	/**
	 * 新增更新用户
	 * @param detecQuestion
	 */
	public void saveOrUpdateUsers(Users users);
	
	/**
	 * 删除用户
	 * @param detecQuestion
	 */
	public void deleteUsers(Users users);
	
	/**
	 * 批量删除
	 * @param questionIdArray
	 */
	public void deleteUsers(Integer[] userIdArray);
	
	/**
	 * 查询所有班组
	 * @return
	 */
	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam();
	
	/**
	 * 查询所有职位
	 * @return
	 */
	public List<DetecPosition> findAllDetecPosition();
}
