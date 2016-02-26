package com.ts.common.util;

import java.util.LinkedHashMap;
import java.util.List;

public interface DaoManage {
	/**
	 * ����ʵ��
	 * @param entity ʵ�����
	 */
	public void save(Object entity);
	
	/**
	 * ����ʵ��
	 * @param entity ʵ�����
	 */
	public void update(Object entity);
	
	/**
	 * ɾ��ʵ��
	 * @param entityClass ʵ����
	 * @param entityId ʵ��ID
	 */
	public <T> void delete(Class<T> entityClass, Object entityId);
	
	/**
	 * ɾ��ʵ��
	 * @param entityClass ʵ����
	 * @param entityIds ʵ��ID����
	 */
	public <T> void delete(Class<T> entityClass, Object[] entityIds);
	
	/**
	 * ����ʵ��
	 * @param <T>
	 * @param eneityClass ʵ����
	 * @param entityId ʵ��ID
	 * @return
	 */
	public <T> T find(Class<T> entityClass, Object entityId);
	
	/**
	 * ����ʵ������
	 * @param <T>
	 * @param entityClass ʵ����
	 * @return
	 */
	public <T> List<T> find(Class<T> entityClass);
	
	/**
	 * ����ʵ������
	 * @param <T>
	 * @param entityClass ʵ����
	 * @param wherehql ��ѯ���where������
	 * @param queryParams ��������Ҫ����Ĳ����
	 * @return
	 */
	public <T> List<T> find(Class<T> entityClass, String wherehql, Object[] queryParams);
	
	/**
	 * ����ʵ������
	 * @param <T>
	 * @param entityClass ʵ����
	 * @param wherehql ��ѯ���where������
	 * @param queryParams ��������Ҫ����Ĳ����
	 * @param orderby ʵ�����ԣ�desc/asc order by key1 desc, key2 asc, xxx desc
	 * @return
	 */
	public <T> List<T> find(Class<T> entityClass, String wherehql, Object[] queryParams, LinkedHashMap<String, String> orderby);
	
	/**
	 * ��ȡʵ���������
	 * @param <T>
	 * @param entityClass
	 * @return
	 */
	public <T> PageModel<T> getScrollData(Class<T> entityClass);
	
	/**
	 * ��ȡ��ҳ���
	 * @param <T>
	 * @param entityClass ʵ����
	 * @param wherejpql ��ѯ���where������
	 * @param queryParams ��������Ҫ����Ĳ����
	 * @return
	 */
	public <T> PageModel<T> getScrollData(Class<T> entityClass, String wherehql, Object[] queryParams);
	
	/**
	 * ��ȡ��ҳ���
	 * @param <T>
	 * @param entityClass ʵ����
	 * @param orderby ʵ�����ԣ�desc/asc order by key1 desc, key2 asc, xxx desc 
	 * @return
	 */
	public <T> PageModel<T> getScrollData(Class<T> entityClass, LinkedHashMap<String, String> orderby);
	
	/**
	 * ��ȡ��ҳ���(ʹ��LinkedHashMap��֤��ӵ�˳���ȡ���������˳����һ�µ�)
	 * @param <T>
	 * @param entityClass ʵ����
	 * @param wherejpql ��ѯ���where������
	 * @param queryParams ��������Ҫ����Ĳ����
	 * @param orderby ʵ�����ԣ�desc/asc order by key1 desc, key2 asc, xxx desc  
	 * @return
	 */
	public <T> PageModel<T> getScrollData(Class<T> entityClass, String wherehql, Object[] queryParams, LinkedHashMap<String, String> orderby);
}
