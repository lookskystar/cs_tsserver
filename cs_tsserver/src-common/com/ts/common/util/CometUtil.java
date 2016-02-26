package com.ts.common.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.comet4j.core.CometConnection;
import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import org.json.JSONException;
import org.json.JSONObject;

public class CometUtil {
	
	private static Map<Long, List<String>> connMap = new HashMap<Long, List<String>>();
	
	/**
	 * ������Ϣ
	 * @param rjhmId �ռƻ�ID
	 * @param xx �޳��޴�
	 * @param bzId �б���İ���
	 * @param jctype ����
	 * @param jcnum ����
	 * @param nodeId ��ǰ�ռƻ��ڵ�ID
	 */
	public static void send(int rjhmId,String xx,Long bzId,String jcType, String jcNum,Integer projectType,Integer nodeId) {
		CometContext context = CometContext.getInstance();
		CometEngine engine = context.getEngine();
		List<String>  ids = connMap.get(bzId);
		List<CometConnection> list = new ArrayList<CometConnection>();
		JSONObject obj = new JSONObject();
		String info = null;
		try {
			obj.accumulate("rjhmId", rjhmId);
			obj.accumulate("xx", xx);
			obj.accumulate("jctype", jcType);
			obj.accumulate("jcnum", jcNum);
			obj.accumulate("projectType", projectType);
			obj.accumulate("nodeId", nodeId);
			info = obj.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		if(ids!=null && ids.size()>0){
			for(String id : ids) {
				list.add(engine.getConnection(id));
			}
			engine.sendTo("report", list, info);
		}
	}
	
	/**
	 * ��������
	 * @param bzId
	 * @param connId
	 */
	public static void addConnect(Long bzId,String connId){
		if(CometUtil.connMap.get(bzId)==null){
			CometUtil.connMap.put(bzId, new ArrayList<String>());
		}
		CometUtil.connMap.get(bzId).add(connId);
	}
	
	/**
	 * �Ͽ�����
	 * @param bzId
	 * @param connId
	 */
	public static void removeConnect(Long bzId,String connId){
		if(CometUtil.connMap.get(bzId)!=null  && connId!=null && !"".equals(connId)){
			CometUtil.connMap.get(bzId).remove(connId);
		}
	}
}
