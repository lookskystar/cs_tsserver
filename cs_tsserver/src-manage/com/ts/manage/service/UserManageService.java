/**
 * 
 */
package com.ts.manage.service;

import java.util.List;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecPosition;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;

/**
 * @author eleven
 *
 */
public interface UserManageService {
	
	public PageModel<Users> findDetecUsersByCondition(String teamId, String gonghao, String name);
	
	public Users findUsersById(Integer id);
	
	public void saveOrUpdateUsers(Users users);
	
	public void deleteUsers(Users users);
	
	public void deleteUsers(String[] userIdArray);
	
	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam();
	
	public List<DetecPosition> findAllDetecPosition();
}
