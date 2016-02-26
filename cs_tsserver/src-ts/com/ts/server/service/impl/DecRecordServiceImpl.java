package com.ts.server.service.impl;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import com.ts.common.pojo.DecBadPJRec;
import com.ts.common.pojo.DecRecord;
import com.ts.common.pojo.DictJcType;
import com.ts.server.dao.DecRecordDao;
import com.ts.server.service.DecRecordService;

public class DecRecordServiceImpl implements DecRecordService{
	
	@Resource(name="decRecordDao")
	private DecRecordDao decRecordDao;
	
	public DecRecord getDecRecord(Long id) {
		return decRecordDao.getDecRecord(id);
	}

	public List<DecRecord> listDecRecords(String btime, String etime,int status) {
		return decRecordDao.listDecRecords(btime, etime,status);
	}

	public void saveOrUpdateDecRecord(DecRecord decRecord) {
		decRecordDao.saveOrUpdateDecRecord(decRecord);
	}
	
	public Map<String, Map<String,Integer>> countBadPJ(String btime,String etime){
		List<DecBadPJRec> badPJRecs = decRecordDao.listBadPJRec(btime, etime);
		Map<String, Map<String, Integer>> map = new LinkedHashMap<String, Map<String,Integer>>();
		
		Map<String, Integer> temp = new HashMap<String, Integer>();
		String tempUnitName = null;
		String tempJctype = null;
		int tempNum = 0;
		for (DecBadPJRec rec : badPJRecs) {
			tempJctype = rec.getDecRecId().getJcType();
			tempUnitName = rec.getPjName();
			tempNum = rec.getPjAmount();
			temp = map.get(tempUnitName);
			if(temp==null && tempUnitName!=null && !"".equals(tempUnitName)){
				temp = new HashMap<String, Integer>();
				temp.put(tempJctype, tempNum);
				map.put(tempUnitName, temp);
			}else{
				if(temp.get(tempJctype)==null){
					temp.put(tempJctype, 0);
				}
				temp.put(tempJctype, temp.get(tempJctype)+tempNum);
			}
		}
		return map;
	}
	
	public List<DictJcType> listJcTypes(){
		return decRecordDao.listJcTypes();
	}
	
	public List<DecBadPJRec> listDecBadPjRec(long recordId){
		return decRecordDao.listDecBadPjRec(recordId);
	}
	
	public List<DecBadPJRec> listDecBadPjRec(String btime,String etime,String  pjName,String jcType){
		return decRecordDao.listDecBadPjRec(btime, etime, pjName, jcType);
	}
	
	public void saveOrUpdateDecBadPjRec(DecBadPJRec decBadPJRec) {
		decRecordDao.saveOrUpdateDecBadPjRec(decBadPJRec);
	}

	public void delBadPJRecById(Long id) {
		decRecordDao.delBadPJRecById(id);
	}
}
