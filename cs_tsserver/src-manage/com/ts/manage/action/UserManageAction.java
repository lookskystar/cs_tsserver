/**
 * 用户管理
 */
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
import com.ts.common.pojo.DetecPosition;
import com.ts.common.pojo.Users;
import com.ts.common.util.Contains;
import com.ts.common.util.MD5;
import com.ts.common.util.PageModel;
import com.ts.manage.service.UserManageService;

/**
 * @author eleven
 *
 */
public class UserManageAction {
	
	@Resource(name="userManageService")
	private UserManageService userManageService;
	
	private String teamId;
	private String gonghao;
	private String names;
	
	private HttpServletRequest request = ServletActionContext.getRequest();
	private HttpServletResponse response=ServletActionContext.getResponse();
	public static final SimpleDateFormat YMD_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
	public static final SimpleDateFormat YMDHMS_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public String findUsersByCondition(){
		List<DetecBaohuoTeam> teamList = userManageService.findAllDetecBaohuoTeam();
		List<DetecPosition>  positionList=userManageService.findAllDetecPosition();
		PageModel<Users>  dataPm = userManageService.findDetecUsersByCondition(teamId, gonghao, names);
		request.setAttribute("dataPm", dataPm);
		request.setAttribute("teamList", teamList);
		request.setAttribute("positionList", positionList);
		return "listusers";
	}
	
	public void deleteUsers() throws IOException{
		String result = "";
		String usersIdArray[] = request.getParameter("users").split(",");
		try {
			userManageService.deleteUsers(usersIdArray);
			result = "success";
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}
	
	public String addUsersInput() {
		List<DetecBaohuoTeam> teamList = userManageService.findAllDetecBaohuoTeam();
		request.setAttribute("teamList", teamList);
		request.setAttribute("positionList", userManageService.findAllDetecPosition());
		return "addusers";
	}
	
	public String editUsersInput() {
		String id = request.getParameter("id");
		Users user = userManageService.findUsersById(Integer.parseInt(id));
		List<DetecBaohuoTeam> teamList = userManageService.findAllDetecBaohuoTeam();
		request.setAttribute("teamList", teamList);
		request.setAttribute("positionList", userManageService.findAllDetecPosition());
		request.setAttribute("user", user);
		return "editusers";
	}
	
	public void saveOrUpdateUsers() throws IOException{
		String result ="success";
		String id = request.getParameter("id");
		String teamId = request.getParameter("teamId");
		String gonghao = request.getParameter("gonghao");
		String xm = request.getParameter("xm");
		String pw = request.getParameter("pw");
		String posId = request.getParameter("posId");
		String jdkId = request.getParameter("jdkId");
		Users user =  null;
		if(StringUtils.isNotEmpty(id)){
			user = userManageService.findUsersById(Integer.parseInt(id));
		}else{
			user = new Users();
		}
		if(StringUtils.isNotEmpty(gonghao)){
			user.setGongHao(gonghao);
		}
		if(StringUtils.isNotEmpty(jdkId)){
			user.setJdkId(jdkId);
		}
		if(StringUtils.isNotEmpty(pw)){
			user.setPw(MD5.GetMD5Code(pw));
		}
		if(StringUtils.isNotEmpty(teamId)){
			user.setTeamId(Integer.parseInt(teamId));
		}
		if(StringUtils.isNotEmpty(posId)){
			user.setPosId(Integer.parseInt(posId));
		}
		if(StringUtils.isNotEmpty(xm)){
			user.setXm(xm);
		}
		user.setJwdCode(Contains.CS_JWD_CODE);
		try {
			userManageService.saveOrUpdateUsers(user);
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}
	
	public void recoveryPw() throws IOException{
		String result = "success";
		String id = request.getParameter("id");
		Users user =  userManageService.findUsersById(Integer.parseInt(id));
		user.setPw(MD5.GetMD5Code(Contains.DEFAULT_PW));
		try {
			userManageService.saveOrUpdateUsers(user);
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally{
			response.getWriter().write(result);
		}
	}
	
	public String updatePwInput(){
		String id = request.getParameter("id");
		request.setAttribute("id", id);
		return "updatepw";
	}
	
	public void updatePw()  throws Exception{
		String result = "success";
		String id = request.getParameter("id");
		String opw = request.getParameter("opw");
		String npw = request.getParameter("npw");
		Users user =  userManageService.findUsersById(Integer.parseInt(id));
		String pwDb = user.getPw();
		String pwCl = MD5.GetMD5Code(opw);
		try {
			if(pwDb.equals(pwCl)){
				user.setPw(MD5.GetMD5Code(npw));
				userManageService.saveOrUpdateUsers(user);
			}else{
				result = "noauthor";
			}
		} catch (Exception e) {
			e.printStackTrace();
			result = "failure";
		} finally {
			response.getWriter().write(result);
		}
	}

	public String getTeamId() {
		return teamId;
	}

	public void setTeamId(String teamId) {
		this.teamId = teamId;
	}

	public String getGonghao() {
		return gonghao;
	}

	public void setGonghao(String gonghao) {
		this.gonghao = gonghao;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}
}
