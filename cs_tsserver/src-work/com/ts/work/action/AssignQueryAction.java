package com.ts.work.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.DecAtRecord;
import com.ts.work.service.AssignQueryService;


/**
 * 信息查询
 */
public class AssignQueryAction {

	@Resource(name="assignQueryService")
	private AssignQueryService assignQueryService;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	public static final SimpleDateFormat YMD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	/**
	 * 进入派工查询主页面
	 */
	public String assignQueryInput() throws Exception {
		String btimeTemp =YMD_FORMAT.format(new Date());
		String etimeTemp =YMD_FORMAT.format(new Date());
		String bTime=YMD_FORMAT.format(new Date())+" 00:00:00";
		String eTime=YMD_FORMAT.format(new Date())+" 23:59:59";
		List<DecAtRecord>  decatreclist=assignQueryService.queryDecAtRecord(bTime, eTime);
		request.setAttribute("decatreclist", decatreclist);
		request.setAttribute("bTime", btimeTemp);
		request.setAttribute("eTime", etimeTemp);
		return "assignquery";
	}
	
	
	/**
	 * 派工查询，按时间查询
	 */
	public String assignquery(){
		String btimeTemp = request.getParameter("bTime");
		String etimeTemp = request.getParameter("eTime");
		String bTime = null;
		String eTime = null;
		Date now = new Date();
		if(btimeTemp==null || "".equals(btimeTemp)){
			btimeTemp = YMD_FORMAT.format(now);
		}
		bTime = btimeTemp + " 00:00:00";
		if(etimeTemp==null || "".equals(etimeTemp)){
			etimeTemp = YMD_FORMAT.format(now);
		}
		eTime = etimeTemp + " 23:59:59";
		List<DecAtRecord>  decatreclist=assignQueryService.queryDecAtRecord(bTime, eTime);
		request.setAttribute("decatreclist", decatreclist);
		request.setAttribute("bTime", btimeTemp);
		request.setAttribute("eTime", etimeTemp);
		return "assignquery";
	}

	/**
	 * 进入查看派活
	 */
	public String decInfoInput() throws Exception {
		DecAtRecord  decatrecord=assignQueryService.getDecAtRecordById(Long.valueOf(request.getParameter("id")));
		request.setAttribute("decatrecord", decatrecord);
		return "decInfo";
	}

}
