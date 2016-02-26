package com.ts.server.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.ts.common.pojo.DecBadPJRec;
import com.ts.common.pojo.DecRecord;
import com.ts.common.pojo.DictJcType;
import com.ts.common.util.Contains;
import com.ts.server.dao.DecRecordDao;

public class DecRecordDaoImpl extends HibernateDaoSupport implements DecRecordDao {

	public DecRecord getDecRecord(Long id) {
		return getHibernateTemplate().get(DecRecord.class, id);
	}

	@SuppressWarnings("unchecked")
	public List<DecRecord> listDecRecords(String btime, String etime,int status) {
		StringBuilder builder=new StringBuilder();
		builder.append("from DecRecord t where 1=1");
		List<Object> params=new ArrayList<Object>();
		if(btime!=null&&!"".equals(btime)){
			builder.append(" and t.atTime>=?");
			params.add(btime);
		}
		if(etime!=null&&!"".equals(etime)){
			builder.append(" and t.atTime<=?");
			params.add(etime);
		}
		builder.append(" and t.status=?");
		params.add(status);
		return getHibernateTemplate().find(builder.toString(),params.toArray());
	}

	public void saveOrUpdateDecRecord(DecRecord decRecord) {
		
	}
	
	@SuppressWarnings("unchecked")
	public List<DecBadPJRec> listBadPJRec(String btime,String etime){
		String hql = "from DecBadPJRec t where t.decRecId.status="+Contains.DECRECORD_FINISH_STATUS;
		if(btime!=null && !"".equals(btime)){
			hql += " and t.decRecId.atTime >= '"+btime+"'";
		}
		if(etime!=null && !"".equals(etime)){
			hql += " and t.decRecId.atTime <= '"+etime+"'";
		}
		return getHibernateTemplate().find(hql);
	}
	
	@SuppressWarnings("unchecked")
	public List<DictJcType> listJcTypes(){
		return getHibernateTemplate().find("from DictJcType t order by t.jcTypeId asc");
	}

	public void saveOrUpdateDecBadPjRec(DecBadPJRec decBadPJRec) {
		getHibernateTemplate().saveOrUpdate(decBadPJRec);
	}
	
	@SuppressWarnings("unchecked")
	public List<DecBadPJRec> listDecBadPjRec(long recordId){
		String hql = "from DecBadPJRec t where t.decRecId.id=?";
		return getHibernateTemplate().find(hql,recordId); 
	}
	
	public List<DecBadPJRec> listDecBadPjRec(String btime,String etime,String  pjName,String jcType){
		String hql = "from DecBadPJRec t where 1=1";
		if(pjName!=null && !"".equals(pjName)){
			hql += " and t.pjName='"+pjName+"'";
		}
		if(btime!=null && !"".equals(btime)){
			hql += " and t.decRecId.atTime>='"+btime+"'";
		}
		if(etime!=null && !"".equals(etime)){
			hql += " and t.decRecId.atTime<='"+etime+"'";
		}
		if(jcType!=null && !"".equals(jcType)){
			hql += " and t.decRecId.jcType='"+jcType+"'";
		}
		return getHibernateTemplate().find(hql); 
	}

	public void delBadPJRecById(Long id) {
		String hql="delete from DecBadPJRec t where t.id=?";
		getSession().createQuery(hql).setLong(0, id).executeUpdate();
	}
	
}
