package com.ts.server.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ts.common.pojo.Users;
import com.ts.server.dao.UsersDao;

public class UsersDaoImpl extends HibernateDaoSupport implements UsersDao {
	
	@SuppressWarnings("unchecked")
	public Users login(String username, String password) {
		String hql = "from Users u where u.gongHao=? and u.pw=?";
		List<Users> users = getHibernateTemplate().find(hql,new Object[]{username,password});
		if(users==null || users.size()==0){
			return null;
		}
		return users.get(0);
	}

	@SuppressWarnings("unchecked")
	public Users login(String idkid) {
		String hql = "from Users u where u.jdkId=?";
		List<Users> users = getHibernateTemplate().find(hql,new Object[]{idkid});
		if(users==null || users.size()==0){
			return null;
		}
		if(users.size()>1){
			System.out.println("该卡号存在多个用户");
			return null;
		}
		return users.get(0);
	}

	public void updateUser(Users user) {
		this.getHibernateTemplate().update(user);
		
	}
}
