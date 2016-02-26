package com.ts.manage.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecBaohuoUnit;
import com.ts.common.pojo.Users;
import com.ts.common.util.AbstractDao;
import com.ts.common.util.Contains;
import com.ts.common.util.PageModel;
import com.ts.manage.dao.PartsManageDao;

public class PartsManageDaoImpl extends AbstractDao implements PartsManageDao {

	public void deleteParts(DetecBaohuoUnit detecBaohuoUnit) {
		this.getHibernateTemplate().delete(detecBaohuoUnit);
	}

	public void deleteParts(Long[] partsIdArray) {
		this.getSession().createQuery("delete from DetecBaohuoUnit t where t.unitId in(:partIds)").setParameterList("partIds", partsIdArray).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<DetecBaohuoTeam> findAllDetecBaohuoTeam() {
		return this.getHibernateTemplate().find("from DetecBaohuoTeam t order by t.id");
	}

	@SuppressWarnings("unchecked")
	public PageModel<DetecBaohuoUnit> findDetecBaohuoUnitByCondition(
			String teamId, String name) {
		StringBuilder builder = new StringBuilder();
		builder.append("from DetecBaohuoUnit t where 1=1");
		List<Object> params = new ArrayList<Object>();
		if(StringUtils.isNotEmpty(teamId)){
			builder.append(" and t.teamId=?");
			params.add(Long.parseLong(teamId));
		}
		if(StringUtils.isNotEmpty(name)){
			builder.append(" and t.unitName like '%"+ name +"%'");
		}
		builder.append(" order by t.id, t.teamId desc");
		return findPageModel(builder.toString(),params.toArray());
	}

	public DetecBaohuoUnit findDetecBaohuoUnitById(Long id) {
		return this.getHibernateTemplate().get(DetecBaohuoUnit.class, id);
	}

	public void saveOrUpdateParts(DetecBaohuoUnit detecBaohuoUnit) {
		this.getHibernateTemplate().saveOrUpdate(detecBaohuoUnit);
	}

	@SuppressWarnings("unchecked")
	public List<Users> findAllUsersInTsTeam() {
		return this.getHibernateTemplate().find("from Users t where t.teamId=?", new Object[]{Contains.TS_TEAM_ID});
	}

	

}
