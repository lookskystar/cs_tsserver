package com.ts.manage.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.DetecBaohuoTeam;
import com.ts.common.pojo.DetecBaohuoUnit;
import com.ts.common.pojo.Users;
import com.ts.common.util.PageModel;
import com.ts.manage.service.PartsManageService;

public class PartsManageAction {
	@Resource(name="partManageService")
	private PartsManageService partsManageService;
	
	private String teamId;
	private String names;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	public static final SimpleDateFormat YMD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String findPartsByCondition(){
		List<DetecBaohuoTeam> teamList = partsManageService.findAllDetecBaohuoTeam();
		PageModel<DetecBaohuoUnit>  dataPm = partsManageService.findDetecBaohuoUnitByCondition(teamId, names);
		request.setAttribute("dataPm", dataPm);
		request.setAttribute("teamList", teamList);
		return "listparts";
	}
	
	public void deleteParts() throws IOException{
		String result = "";
		String partsIdArray[] = request.getParameter("parts").split(",");
		try {
			partsManageService.deleteParts(partsIdArray);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}
	
	public String addPartsInput() {
		List<DetecBaohuoTeam> teamList = partsManageService.findAllDetecBaohuoTeam();
		List<Users> tsUsers = partsManageService.findAllUsersInTsTeam();
		request.setAttribute("teamList", teamList);
		request.setAttribute("tsUsers", tsUsers);
		return "addparts";
	}
	
	public String editPartsInput() {
		String id = request.getParameter("id");
		DetecBaohuoUnit part = partsManageService.findDetecBaohuoUnitById(Long.parseLong(id));
		List<DetecBaohuoTeam> teamList = partsManageService.findAllDetecBaohuoTeam();
		List<Users> tsUsers = partsManageService.findAllUsersInTsTeam();
		request.setAttribute("teamList", teamList);
		request.setAttribute("part", part);
		request.setAttribute("tsUsers", tsUsers);
		return "editparts";
	}
	
	public void saveOrUpdateParts() throws IOException{
		String result ="";
		String id = request.getParameter("id");
		DetecBaohuoUnit detecBaohuoUnit = new DetecBaohuoUnit();
		if(StringUtils.isNotEmpty(id)){
			detecBaohuoUnit.setUnitId(Long.parseLong(id));
		}
		detecBaohuoUnit.setUnitName(request.getParameter("name"));
		detecBaohuoUnit.setTeamId(Long.parseLong(request.getParameter("teamId")));
		detecBaohuoUnit.setXc1(request.getParameter("xc1"));
		detecBaohuoUnit.setXc2(request.getParameter("xc2"));
		detecBaohuoUnit.setW1(request.getParameter("w1"));
		detecBaohuoUnit.setW2(request.getParameter("w2"));
		detecBaohuoUnit.setW3(request.getParameter("w3"));
		detecBaohuoUnit.setW4(request.getParameter("w4"));
		detecBaohuoUnit.setW5(request.getParameter("w5"));
		detecBaohuoUnit.setW6(request.getParameter("w6"));
		detecBaohuoUnit.setW7(request.getParameter("w7"));
		detecBaohuoUnit.setW8(request.getParameter("w8"));
		detecBaohuoUnit.setW9(request.getParameter("w9"));
		detecBaohuoUnit.setW10(request.getParameter("w10"));
		detecBaohuoUnit.setW11(request.getParameter("w11"));
		detecBaohuoUnit.setW12(request.getParameter("w12"));
		detecBaohuoUnit.setT1(request.getParameter("t1"));
		detecBaohuoUnit.setT2(request.getParameter("t2"));
		detecBaohuoUnit.setQ1(request.getParameter("q1"));
		detecBaohuoUnit.setQ2(request.getParameter("q2"));
		try {
			partsManageService.saveOrUpdateParts(detecBaohuoUnit);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
	
	
}
