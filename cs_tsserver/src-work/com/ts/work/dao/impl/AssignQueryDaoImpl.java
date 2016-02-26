package com.ts.work.dao.impl;

import java.util.List;

import com.ts.common.pojo.DecAtRecord;
import com.ts.common.util.AbstractDao;
import com.ts.work.dao.AssignQueryDao;


public class AssignQueryDaoImpl extends AbstractDao implements AssignQueryDao{

	@SuppressWarnings("unchecked")
	public List<DecAtRecord> queryDecAtRecord(String beginTime, String endTime) {
		StringBuilder hql=new StringBuilder();
		hql.append("from DecAtRecord r where r.status=101");//101,派工完成
		if(beginTime!=null&&!beginTime.equals("")){
			hql.append("  and r.atTime >='"+beginTime+"'");
		}
		if(endTime!=null&&!endTime.equals("")){
			hql.append("  and r.atTime <='"+endTime+"'");
		}
		
		hql.append("  order by r.atTime asc");
		return getHibernateTemplate().find(hql.toString());
	
	}

	public DecAtRecord getDecAtRecordById(long id) {
		return getHibernateTemplate().get(DecAtRecord.class,id);
	}

	
	
}
