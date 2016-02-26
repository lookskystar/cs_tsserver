package com.ts.common.util;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;
import javax.persistence.Entity;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


public abstract class DaoManageSupport extends HibernateDaoSupport implements DaoManage{
	@Resource  
    public void setMySessionFactory(SessionFactory sessionFactory){  
        super.setSessionFactory(sessionFactory);  
    } 

	public void save(Object entity) {
		getHibernateTemplate().setFlushMode(HibernateTemplate.FLUSH_EAGER);
		getHibernateTemplate().persist(entity);
	}

	public void update(Object entity) {
		getHibernateTemplate().setFlushMode(HibernateTemplate.FLUSH_EAGER);
		getHibernateTemplate().merge(entity);
	}
	
	public <T> void delete(Class<T> entityClass, Object entityId) {
		delete(entityClass, new Object[] {entityId});
	}

	public <T> void delete(Class<T> entityClass, Object[] entityIds) {
		for (Object entityId : entityIds) {
			getHibernateTemplate().delete(getHibernateTemplate().get(entityClass, (Serializable) entityId));
		}
	}

	public <T> T find(Class<T> entityClass, Object entityId) {
		return (T) getHibernateTemplate().get(entityClass, (Serializable) entityId);
	}
	
	public <T> List<T> find(Class<T> entityClass) {
		return find(entityClass, null, null,null);
	}
	
	public <T> List<T> find(Class<T> entityClass, String wherehql, Object[] queryParams) {
		return find(entityClass, wherehql, queryParams, null);
	}
	
	@SuppressWarnings("unchecked")
	public <T> List<T> find(Class<T> entityClass, String wherehql, Object[] queryParams, LinkedHashMap<String, String> orderby) {
		String entityName = getEntityName(entityClass);
		Query query = getSession().createQuery("select o from " + entityName + " o" + (wherehql == null ? "" : " where " + wherehql) + buildOrderBy(orderby));
		setQueryParams(query, queryParams);
		return query.list();
	}

	public <T> PageModel<T> getScrollData(Class<T> entityClass, String wherehql,
			Object[] queryParams) {
		return getScrollData(entityClass, wherehql, queryParams, null);
	}

	public <T> PageModel<T> getScrollData(Class<T> entityClass, LinkedHashMap<String, String> orderby) {
		return getScrollData(entityClass, null, null, orderby);
	}

	public <T> PageModel<T> getScrollData(Class<T> entityClass) {
		return getScrollData(entityClass, null, null, null);
	}

	@SuppressWarnings("unchecked")
	public <T> PageModel<T> getScrollData(Class<T> entityClass,String wherehql,
			Object[] queryParams, LinkedHashMap<String, String> orderby) {
		PageModel<T> result = new PageModel<T>();
		String entityName = getEntityName(entityClass);
		Query query = getSession().createQuery("select o from " + entityName + " o" + (wherehql == null ? "" : " where " + wherehql) + buildOrderBy(orderby));
		setQueryParams(query, queryParams);
		query.setFirstResult(SystemContext.getOffset());
		query.setMaxResults(SystemContext.getPageSize());
		result.setDatas(query.list());
		query = getSession().createQuery("select count(o) from " + entityName + " o" + (wherehql == null ? "" : " where " + wherehql));
		setQueryParams(query, queryParams);
		result.setCount(query.uniqueResult().hashCode());
		return result;
	}
	
	/**
	 * ���ѯ������ò���
	 * @param query ��ѯ����
	 * @param queryParams ��������
	 */
	protected void setQueryParams(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}
	
	/**
	 * ��װorder by���
	 * @param orderby �����order by����
	 * @return
	 */
	protected String buildOrderBy(LinkedHashMap<String, String> orderby) {
		StringBuffer orderbyql = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			orderbyql.append(" order by ");
			for (String key : orderby.keySet()) {
				orderbyql.append("o.").append(key).append(" ").append(orderby.get(key)).append(",");
			}
			
			orderbyql.deleteCharAt(orderbyql.length() - 1);
		}
		return orderbyql.toString();
	}
	
	/**
	 * ��ȡʵ��������
	 * @param <T>
	 * @param entityClass ʵ����
	 * @return
	 */
	public <T> String getEntityName(Class<T> entityClass) {
		String entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (entity != null) {
			if (entity.name() != null && !("").equals(entity.name())) {
				entityName = entity.name();
			}
		}
		return entityName;
	}
}
