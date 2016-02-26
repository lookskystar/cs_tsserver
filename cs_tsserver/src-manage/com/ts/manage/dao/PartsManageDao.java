package com.ts.manage.dao;

import java.util.List;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecBaohuoUnit;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;

public interface PartsManageDao {
	/**
	 * 分页查询配件
	 * @param teamId
	 * @param name
	 * @return
	 */
	public PageModel<DetecBaohuoUnit> findDetecBaohuoUnitByCondition(String teamId, String name);
	
	/**
	 * 查询配件
	 * @param id
	 * @return
	 */
	public DetecBaohuoUnit findDetecBaohuoUnitById(Long id);
	
	/**
	 * 新增更新配件
	 * @param detecBaohuoUnit
	 */
	public void saveOrUpdateParts(DetecBaohuoUnit detecBaohuoUnit);
	
	/**
	 * 删除用户
	 * @param detecBaohuoUnit
	 */
	public void deleteParts(DetecBaohuoUnit detecBaohuoUnit);
	
	/**
	 * 批量删除
	 * @param partsIdArray
	 */
	public void deleteParts(Long[] partsIdArray);
	
	/**
	 * 查询所有班组
	 * @return
	 */
	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam();
	
	/**
	 * 查询探伤组人员
	 * @return
	 */
	public List<Users> findAllUsersInTsTeam();
}
