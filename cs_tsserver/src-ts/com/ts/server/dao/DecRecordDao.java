package com.ts.server.dao;

import java.util.List;
import java.util.Map;

import com.ts.common.pojo.DecBadPJRec;
import com.ts.common.pojo.DecRecord;
import com.ts.common.pojo.DictJcType;

public interface DecRecordDao {
	
	/**
	 * 
	 * @param btime
	 * @param etime
	 * @param status 0:全部 101 未完成 102 已完成
	 * @return
	 */
	public List<DecRecord> listDecRecords(String btime,String etime,int status);
	
	public DecRecord getDecRecord(Long id);
	
	public void saveOrUpdateDecRecord(DecRecord decRecord);
	
	/**
	 * 统计裂损配件数
	 * @param btime
	 * @param etime
	 * @return
	 */
	public List<DecBadPJRec> listBadPJRec(String btime,String etime);
	
	/**
	 * 查询所有车型
	 */
	public List<DictJcType> listJcTypes();
	
	/**
	 * 根据探伤记录ID找出所有的裂损配件
	 */
	public List<DecBadPJRec> listDecBadPjRec(long recordId);
	
	/**
	 * 查询裂损配件
	 * @param 探伤的时间
	 * @param 探伤的时间
	 * @param 配件名称
	 * @param 探伤的机车类型
	 */
	public List<DecBadPJRec> listDecBadPjRec(String btime,String etime,String  pjName,String jcType);
	
	/**
	 * 保存裂损配件记录信息
	 * @param decBadPJRec
	 */
	public void saveOrUpdateDecBadPjRec(DecBadPJRec decBadPJRec);
	
	/**
	 * 根据ID删除裂损配件信息
	 * @param id
	 */
	public void delBadPJRecById(Long id);
}
