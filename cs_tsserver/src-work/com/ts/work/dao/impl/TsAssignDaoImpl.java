package com.ts.work.dao.impl;

import java.util.List;

import com.ts.common.pojo.DecAtRecord;
import com.ts.common.pojo.DecRecord;
import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.Users;
import com.ts.common.util.AbstractDao;
import com.ts.common.util.Contains;
import com.ts.work.dao.TsAssignDao;


public class TsAssignDaoImpl extends AbstractDao implements TsAssignDao{

	@SuppressWarnings("unchecked")
	public List<DecAtRecord> findDecAtRecord(String beginTime, String endTime) {
		StringBuilder hql=new StringBuilder();
		hql.append("from DecAtRecord r where r.status=100");
		if(beginTime!=null&&!beginTime.equals("")){
			hql.append("  and r.atTime >='"+beginTime+"'");
		}
		if(endTime!=null&&!endTime.equals("")){
			hql.append("  and r.atTime <='"+endTime+"'");
		}
		
		hql.append("  order by r.atTime asc");
		return getHibernateTemplate().find(hql.toString());
	}

	@SuppressWarnings("unchecked")
	public List<Users> listUsers() {
		String hql="from Users r where r.teamId=10";
		return getHibernateTemplate().find(hql);
	}

	@SuppressWarnings("unchecked")
	public List<DetecBaohuoTeam> listTeam() {
		String hql="from DetecBaohuoTeam r";
		return getHibernateTemplate().find(hql);
	}

	public DecAtRecord getDecAtRecordById(long id) {
		return getHibernateTemplate().get(DecAtRecord.class,id);
	}

	public void updateDecAtRecord(DecAtRecord decatrecord) {
		getHibernateTemplate().update(decatrecord);
		
		DecRecord decRecord = new DecRecord();
		decRecord.setJcType(decatrecord.getJcType());
		decRecord.setJcNumber(decatrecord.getJcNumber());
		decRecord.setXc(decatrecord.getAtxc());
		decRecord.setXci(decatrecord.getAtxci());
		decRecord.setUnitName(decatrecord.getUnit());
		decRecord.setUnitNumber(Integer.toString(decatrecord.getUnitNumber()));
		decRecord.setUnitNotext(decatrecord.getUnitNumberText());
		decRecord.setMainName(decatrecord.getW1());
		decRecord.setSecondName(decatrecord.getW2());
		decRecord.setAtTime(decatrecord.getAtTime());
		decRecord.setStatus(Contains.DECRECORD_UNFINISH_STATUS);
		
		getHibernateTemplate().save(decRecord);
		
		
		
	}

	@SuppressWarnings("unchecked")
	public List<Users> listExamUsers(String beginTime,String endTime) {
		String hql="from Users r where r.teamId=10 and r.gongHao in (select gongHao from DetecExam  d where d.grade>=80 and d.examTime >='"+beginTime+"' and d.examTime <='"+endTime+"')";
		return getHibernateTemplate().find(hql);
	}

	
}
