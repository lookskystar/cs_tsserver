/**
 * 
 */
package com.ts.manage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecPosition;
import com.ts.common.pojo.Users;
import com.ts.common.util.AbstractDao;
import com.ts.common.util.PageModel;
import com.ts.manage.dao.UserManageDao;

/**
 * @author eleven
 *
 */
public class UserManageDaoImpl extends AbstractDao implements UserManageDao {
	
	@SuppressWarnings("unchecked")
	public PageModel<Users> findDetecUsersByCondition(String teamId, String gonghao, String names) {
		StringBuilder builder = new StringBuilder();
		builder.append("from Users t where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(teamId)){
			builder.append(" and t.teamId=?");
			params.add(Integer.parseInt(teamId));
		}
		if(StringUtils.isNotEmpty(gonghao)){
			builder.append(" and t.gongHao=?");
			params.add(gonghao);
		}
		if(StringUtils.isNotEmpty(names)){
			builder.append(" and t.xm like '%"+ names +"%'");
		}
		builder.append(" order by t.id, t.teamId desc");
		return findPageModel(builder.toString(),params.toArray());
	}
	
	public void deleteUsers(Integer[] usersIdArray) {
		this.getSession().createQuery("delete from Users t where t.id in(:userIds)").setParameterList("userIds", usersIdArray).executeUpdate();
	}
	
	public void saveOrUpdateUsers(Users users){
		this.getHibernateTemplate().saveOrUpdate(users);
	}
	
	public void deleteUsers(Users users){
		this.getHibernateTemplate().delete(users);
	}

	public Users findUsersById(Integer id) {
		return this.getHibernateTemplate().get(Users.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam() {
		return this.getHibernateTemplate().find("from DetecBaohuoTeam t order by t.id");
	}

	@SuppressWarnings("unchecked")
	public List<DetecPosition> findAllDetecPosition() {
		return this.getHibernateTemplate().find("from DetecPosition t order by t.id");
	}
}
