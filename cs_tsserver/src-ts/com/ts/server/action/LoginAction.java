package com.ts.server.action;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.ts.common.pojo.Users;
import com.ts.common.util.MD5;
import com.ts.server.service.UsersService;

/**
 * 用户登录Action
 *
 */
public class LoginAction {

	@Resource(name="usersService")
	private UsersService usersService;
	
	private HttpServletRequest request=ServletActionContext.getRequest();
	private Users user;
	
	/**
	 * 用户登录
	 * @return
	 */
	public String login(){
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String idkid = request.getParameter("idkid");
		
		password = MD5.GetMD5Code(password);
		
		if(idkid!=null && !"".equals(idkid)){
			user = usersService.login(idkid);
			if(user == null){
				request.setAttribute("loginError", "读卡错误,请确认IC卡！");
				return "loginOut";
			}
		}else{
			user = usersService.login(username,password);
			if(user == null){
				request.setAttribute("loginError", "您输入的用户名或密码不对，请重新输入！");
				return "loginOut";
			}
		}
		request.getSession().setAttribute("session_user", user);
		return "main";
	}
	
	/**
	 * 用户退出
	 * @return
	 */
	public String loginOut(){
		request.getSession().removeAttribute("session_user");
		request.getSession().setAttribute("session_user", null);
		return "loginOut";
	}
	
	/**
	 * 用户修改密码
	 * @return
	 */
	public String updatePwd(){
		HttpServletResponse response=ServletActionContext.getResponse();
		String new_pwd=request.getParameter("new_pwd");
		Users user = (Users) request.getSession().getAttribute("session_user");
		String result="failure";
		if(user==null){
			result="session_null";
		}else{
			user.setPw(MD5.GetMD5Code(new_pwd));
			usersService.updateUser(user);
			result="success";
		}
		response.setContentType("text/plain");
		try {
			response.getWriter().write(result);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取服务器时间
	 * @throws Exception 
	 */
	public String getServerTime() throws Exception{
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd/hh:mm:ss");
		String timeStr = dateFormat.format(new Date());
		ServletActionContext.getResponse().getWriter().print(timeStr);
		return null;
	}
}

