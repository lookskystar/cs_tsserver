package com.ts.common.util;

import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


/**
 * ģ�黯����ר�Ŵ����ҳ��
 * @author Administrator
 *
 */
public class AbstractDao extends HibernateDaoSupport {
	/**
	 * ��ѯ��䲻�����
	 * @param hql 
	 * @return
	 */
	public PageModel findPageModel(String hql){
		return findPageModel(hql, null);
	}
	
	/**
	 * ��ѯ����һ������
	 * @param hql
	 * @param org
	 * @return
	 */
	
	public PageModel findPageModel(String hql,Object org){
		return findPageModel(hql, new Object[]{org});
	}
	/**
	 * ��ѯ������Ϊobject����
	 * @param hql
	 * @param orgs
	 * @return
	 */
	public PageModel findPageModel(String hql,Object[] orgs){
		PageModel pm =new PageModel();
		Query countQuery =getSession().createQuery(getCountHql(hql));
		if(orgs!=null&&orgs.length>0){
			for (int i = 0; i < orgs.length; i++) {
				countQuery.setParameter(i, orgs[i]);
			}
		}
		pm.setCount(((Long)countQuery.uniqueResult()).intValue());
		
		Query datasQuery =getSession().createQuery(hql);
		if(orgs!=null&&orgs.length>0){
			for (int i = 0; i < orgs.length; i++) {
				datasQuery.setParameter(i, orgs[i]);
			}
		}
		int i =SystemContext.getOffset();
		int j = SystemContext.getPageSize();		
		pm.setDatas(datasQuery.setFirstResult(i).setMaxResults(j).list());
		return pm;
	}
	
	/**
	 * ��ݲ�ѯ���ó����еļ�¼����
	 * @param hql
	 * @return
	 */
	private String getCountHql(String hql){
		if(hql.contains("group by")){
			return "select count(*) "+hql.substring(hql.indexOf("from"),hql.indexOf("group by")-1);
		}else if(hql.contains("order by")){
			return "select count(*) "+hql.substring(hql.indexOf("from"),hql.indexOf("order by")-1);
		}else{
			return "select count(*) "+hql.substring(hql.indexOf("from"));
		}
	}
	
	/**
	 * ���˵��ظ��ļ�¼��
	 * @param str
	 * @param hql
	 * @param orgs
	 * @return
	 */
	public PageModel findPageModel(String str, String hql,Object[] orgs){
		PageModel pm =new PageModel();
		Query countQuery =getSession().createQuery(getCountHql(str, hql));
		if(orgs!=null&&orgs.length>0){
			for (int i = 0; i < orgs.length; i++) {
				countQuery.setParameter(i, orgs[i]);
			}
		}
		pm.setCount(((Long)countQuery.uniqueResult()).intValue());
		
		Query datasQuery =getSession().createQuery(getDistinctHql(str, hql));
		if(orgs!=null&&orgs.length>0){
			for (int i = 0; i < orgs.length; i++) {
				datasQuery.setParameter(i, orgs[i]);
			}
		}
		int i =SystemContext.getOffset();
		int j = SystemContext.getPageSize();		
		pm.setDatas(datasQuery.setFirstResult(i).setMaxResults(j).list());
		return pm;
	}
	
	/**
	 * ��ݲ�ѯ���ó����еļ�¼����
	 * @param str
	 * @param hql
	 * @return
	 */
	protected String getCountHql(String str, String hql) {
		return "select count(" + str + ")" + hql.substring(hql.indexOf("from"));
	}
	
	/**
	 * ��ݲ�ѯ���ó����е�ȥ�ظ�����Ϣ
	 * @param str
	 * @param hql
	 * @return
	 */
	protected String getDistinctHql(String str, String hql) {
		return "select " + str + " " + hql.substring(hql.indexOf("from"));
	}
}
