package com.ts.work.action;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.DecAtRecord;
import com.ts.common.util.Contains;
import com.ts.work.service.TsAssignService;


/**
 * 探伤任务
 */
public class TsAssignAction {

	@Resource(name="tsAssignService")
	private TsAssignService tsAssignService;
	
	private DecAtRecord decatrec;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	public static final SimpleDateFormat YMD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	
	
	/**
	 * 进入探伤派工主页面
	 */
	public String assignInput() throws Exception {
		String btimeTemp =YMD_FORMAT.format(new Date());
		String etimeTemp =YMD_FORMAT.format(new Date());
		String bTime=YMD_FORMAT.format(new Date())+" 00:00:00";
		String eTime=YMD_FORMAT.format(new Date())+" 23:59:59";
		request.setAttribute("teamlist", tsAssignService.listTeam());
		List<DecAtRecord>  declist=tsAssignService.findDecAtRecord(bTime,eTime);
		request.setAttribute("declist", declist);
		request.setAttribute("bTime", btimeTemp);
		request.setAttribute("eTime", etimeTemp);
		return "assign";
	}
	
	
	/**
	 * 探伤派工，按时间查询
	 */
	public String query(){
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
		request.setAttribute("teamlist", tsAssignService.listTeam());
		List<DecAtRecord>  declist=tsAssignService.findDecAtRecord(bTime,eTime);
		request.setAttribute("declist", declist);
		request.setAttribute("bTime", btimeTemp);
		request.setAttribute("eTime", etimeTemp);
		return "assign";
	}
	
	
	/**
	 * 进入探伤派工
	 */
	public String tsassignInput() throws Exception {
		String beginTime=YMD_FORMAT.format(new Date())+" 00:00:00";
		String endTime=YMD_FORMAT.format(new Date())+" 23:59:59";
		DecAtRecord  decatrecord=tsAssignService.getDecAtRecordById(Long.valueOf(request.getParameter("id")));
		request.setAttribute("examuserslist", tsAssignService.listExamUsers(beginTime, endTime));
		request.setAttribute("userslist", tsAssignService.listUsers());
		request.setAttribute("decatrecord", decatrecord);
		return "tsassign";
	}
	
	/**
	 * 探伤派工
	 */
	public String tsassign() throws Exception {
		DecAtRecord  decatrecord=tsAssignService.getDecAtRecordById(Long.valueOf(request.getParameter("id")));
		decatrecord.setW1(decatrec.getW1());
		decatrecord.setW2(decatrec.getW2());
		decatrecord.setStatus(Contains.DECREATCORD_FINISH_STATUS);//状态设为101，派工成功
		
		tsAssignService.updateDecAtRecord(decatrecord);
		request.setAttribute("message", "探伤派工成功");
		return assignInput();
	}

	
	/**
	 * 进入紧急派工主页面
	 */
	public String jjassignInput() throws Exception {
		String btimeTemp =YMD_FORMAT.format(new Date());
		String etimeTemp =YMD_FORMAT.format(new Date());
		String bTime=YMD_FORMAT.format(new Date())+" 00:00:00";
		String eTime=YMD_FORMAT.format(new Date())+" 23:59:59";
		request.setAttribute("teamlist", tsAssignService.listTeam());
		List<DecAtRecord>  declist=tsAssignService.findDecAtRecord(bTime,eTime);
		request.setAttribute("declist", declist);
		request.setAttribute("bTime", btimeTemp);
		request.setAttribute("eTime", etimeTemp);
		return "jjassign";
	}
	
	
	/**
	 * 紧急派工，按时间查询
	 */
	public String jjquery(){
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
		request.setAttribute("teamlist", tsAssignService.listTeam());
		List<DecAtRecord>  declist=tsAssignService.findDecAtRecord(bTime,eTime);
		request.setAttribute("declist", declist);
		request.setAttribute("bTime", btimeTemp);
		request.setAttribute("eTime", etimeTemp);
		return "jjassign";
	}
	
	/**
	 * 进入紧急派工
	 */
	public String urgentInput() throws Exception {
		DecAtRecord  decatrecord=tsAssignService.getDecAtRecordById(Long.valueOf(request.getParameter("id")));
		request.setAttribute("userslist", tsAssignService.listUsers());
		request.setAttribute("decatrecord", decatrecord);
		return "urgent";
	}
	
	/**
	 * 紧急派工
	 */
	public String urgent() throws Exception {
		DecAtRecord  decatrecord=tsAssignService.getDecAtRecordById(Long.valueOf(request.getParameter("id")));
		
		decatrecord.setW1(decatrec.getW1());
		decatrecord.setW2(decatrec.getW2());
		decatrecord.setStatus(Contains.DECREATCORD_FINISH_STATUS);//状态设为101，派工成功
		
		tsAssignService.updateDecAtRecord(decatrecord);
		request.setAttribute("message", "紧急派工成功");
		return jjassignInput();
	}
	
	
	
	public DecAtRecord getDecatrec() {
		return decatrec;
	}

	public void setDecatrec(DecAtRecord decatrec) {
		this.decatrec = decatrec;
	}

}
